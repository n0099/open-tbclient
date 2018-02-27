package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ActivityChooserModel extends DataSetObservable {
    static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Object Lq = new Object();
    private static final Map<String, ActivityChooserModel> Lr = new HashMap();
    private OnChooseActivityListener LC;
    final String Lv;
    final Context mContext;
    private Intent mIntent;
    private final Object Ls = new Object();
    private final List<ActivityResolveInfo> Lt = new ArrayList();
    private final List<HistoricalRecord> Lu = new ArrayList();
    private ActivitySorter Lw = new a();
    private int Lx = 50;
    boolean Ly = true;
    private boolean Lz = false;
    private boolean LA = true;
    private boolean LB = false;

    /* loaded from: classes2.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: classes2.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* loaded from: classes2.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public static ActivityChooserModel H(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (Lq) {
            activityChooserModel = Lr.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                Lr.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(".xml")) {
            this.Lv = str + ".xml";
        } else {
            this.Lv = str;
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.Ls) {
            if (this.mIntent != intent) {
                this.mIntent = intent;
                this.LB = true;
                fq();
            }
        }
    }

    public int fn() {
        int size;
        synchronized (this.Ls) {
            fq();
            size = this.Lt.size();
        }
        return size;
    }

    public ResolveInfo aU(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Ls) {
            fq();
            resolveInfo = this.Lt.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.Ls) {
            fq();
            List<ActivityResolveInfo> list = this.Lt;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent aV(int i) {
        synchronized (this.Ls) {
            if (this.mIntent == null) {
                return null;
            }
            fq();
            ActivityResolveInfo activityResolveInfo = this.Lt.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.LC != null) {
                if (this.LC.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public void a(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.Ls) {
            this.LC = onChooseActivityListener;
        }
    }

    public ResolveInfo fo() {
        synchronized (this.Ls) {
            fq();
            if (!this.Lt.isEmpty()) {
                return this.Lt.get(0).resolveInfo;
            }
            return null;
        }
    }

    public void aW(int i) {
        float f;
        synchronized (this.Ls) {
            fq();
            ActivityResolveInfo activityResolveInfo = this.Lt.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.Lt.get(0);
            if (activityResolveInfo2 != null) {
                f = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
            } else {
                f = 1.0f;
            }
            a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void fp() {
        if (!this.Lz) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.LA) {
            this.LA = false;
            if (!TextUtils.isEmpty(this.Lv)) {
                AsyncTaskCompat.executeParallel(new b(), new ArrayList(this.Lu), this.Lv);
            }
        }
    }

    public int getHistorySize() {
        int size;
        synchronized (this.Ls) {
            fq();
            size = this.Lu.size();
        }
        return size;
    }

    private void fq() {
        boolean ft = ft() | fu();
        fv();
        if (ft) {
            fs();
            notifyChanged();
        }
    }

    private boolean fs() {
        if (this.Lw == null || this.mIntent == null || this.Lt.isEmpty() || this.Lu.isEmpty()) {
            return false;
        }
        this.Lw.sort(this.mIntent, this.Lt, Collections.unmodifiableList(this.Lu));
        return true;
    }

    private boolean ft() {
        if (!this.LB || this.mIntent == null) {
            return false;
        }
        this.LB = false;
        this.Lt.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.Lt.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean fu() {
        if (this.Ly && this.LA && !TextUtils.isEmpty(this.Lv)) {
            this.Ly = false;
            this.Lz = true;
            fw();
            return true;
        }
        return false;
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.Lu.add(historicalRecord);
        if (add) {
            this.LA = true;
            fv();
            fp();
            fs();
            notifyChanged();
        }
        return add;
    }

    private void fv() {
        int size = this.Lu.size() - this.Lx;
        if (size > 0) {
            this.LA = true;
            for (int i = 0; i < size; i++) {
                this.Lu.remove(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                HistoricalRecord historicalRecord = (HistoricalRecord) obj;
                if (this.activity == null) {
                    if (historicalRecord.activity != null) {
                        return false;
                    }
                } else if (!this.activity.equals(historicalRecord.activity)) {
                    return false;
                }
                return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.activity);
            sb.append("; time:").append(this.time);
            sb.append("; weight:").append(new BigDecimal(this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.resolveInfo.toString());
            sb.append("; weight:").append(new BigDecimal(this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    private final class a implements ActivitySorter {
        private final Map<ComponentName, ActivityResolveInfo> LE = new HashMap();

        a() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            float f;
            Map<ComponentName, ActivityResolveInfo> map = this.LE;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            int size2 = list2.size() - 1;
            while (size2 >= 0) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f2) + activityResolveInfo2.weight;
                    f = 0.95f * f2;
                } else {
                    f = f2;
                }
                size2--;
                f2 = f;
            }
            Collections.sort(list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1025=4, 1023=4] */
    private void fw() {
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(this.Lv);
            try {
                try {
                    try {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                        if (!"historical-records".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<HistoricalRecord> list = this.Lu;
                        list.clear();
                        while (true) {
                            int next = newPullParser.next();
                            if (next == 1) {
                                if (openFileInput != null) {
                                    try {
                                        openFileInput.close();
                                        return;
                                    } catch (IOException e) {
                                        return;
                                    }
                                }
                                return;
                            } else if (next != 3 && next != 4) {
                                if (!"historical-record".equals(newPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, PushConstants.INTENT_ACTIVITY_NAME), Long.parseLong(newPullParser.getAttributeValue(null, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (Throwable th) {
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e(LOG_TAG, "Error reading historical recrod file: " + this.Lv, e3);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e4) {
                        }
                    }
                }
            } catch (XmlPullParserException e5) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + this.Lv, e5);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b extends AsyncTask<Object, Void, Void> {
        b() {
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IPUT]}, finally: {[IGET, IPUT, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF] complete} */
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1090=5, 1091=5, 1093=5, 1094=5] */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.mContext.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        newSerializer.setOutput(openFileOutput, null);
                        newSerializer.startDocument("UTF-8", true);
                        newSerializer.startTag(null, "historical-records");
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                            newSerializer.startTag(null, "historical-record");
                            newSerializer.attribute(null, PushConstants.INTENT_ACTIVITY_NAME, historicalRecord.activity.flattenToString());
                            newSerializer.attribute(null, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(historicalRecord.time));
                            newSerializer.attribute(null, "weight", String.valueOf(historicalRecord.weight));
                            newSerializer.endTag(null, "historical-record");
                        }
                        newSerializer.endTag(null, "historical-records");
                        newSerializer.endDocument();
                        ActivityChooserModel.this.Ly = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th) {
                        ActivityChooserModel.this.Ly = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.Lv, e3);
                    ActivityChooserModel.this.Ly = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IllegalArgumentException e5) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.Lv, e5);
                    ActivityChooserModel.this.Ly = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IllegalStateException e7) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.Lv, e7);
                    ActivityChooserModel.this.Ly = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + str, e9);
            }
            return null;
        }
    }
}
