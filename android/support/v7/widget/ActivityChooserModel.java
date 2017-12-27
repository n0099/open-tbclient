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
import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ActivityChooserModel extends DataSetObservable {
    static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    private static final Object Lw = new Object();
    private static final Map<String, ActivityChooserModel> Lx = new HashMap();
    final String LB;
    private OnChooseActivityListener LJ;
    final Context mContext;
    private Intent mIntent;
    private final Object Ly = new Object();
    private final List<ActivityResolveInfo> Lz = new ArrayList();
    private final List<HistoricalRecord> LA = new ArrayList();
    private ActivitySorter LC = new a();
    private int LD = 50;
    boolean LE = true;
    private boolean LG = false;
    private boolean LH = true;
    private boolean LI = false;

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
        synchronized (Lw) {
            activityChooserModel = Lx.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                Lx.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(".xml")) {
            this.LB = str + ".xml";
        } else {
            this.LB = str;
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.Ly) {
            if (this.mIntent != intent) {
                this.mIntent = intent;
                this.LI = true;
                fq();
            }
        }
    }

    public int fn() {
        int size;
        synchronized (this.Ly) {
            fq();
            size = this.Lz.size();
        }
        return size;
    }

    public ResolveInfo aU(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Ly) {
            fq();
            resolveInfo = this.Lz.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.Ly) {
            fq();
            List<ActivityResolveInfo> list = this.Lz;
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
        synchronized (this.Ly) {
            if (this.mIntent == null) {
                return null;
            }
            fq();
            ActivityResolveInfo activityResolveInfo = this.Lz.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.LJ != null) {
                if (this.LJ.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public void a(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.Ly) {
            this.LJ = onChooseActivityListener;
        }
    }

    public ResolveInfo fo() {
        synchronized (this.Ly) {
            fq();
            if (!this.Lz.isEmpty()) {
                return this.Lz.get(0).resolveInfo;
            }
            return null;
        }
    }

    public void aW(int i) {
        float f;
        synchronized (this.Ly) {
            fq();
            ActivityResolveInfo activityResolveInfo = this.Lz.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.Lz.get(0);
            if (activityResolveInfo2 != null) {
                f = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
            } else {
                f = 1.0f;
            }
            a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void fp() {
        if (!this.LG) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.LH) {
            this.LH = false;
            if (!TextUtils.isEmpty(this.LB)) {
                AsyncTaskCompat.executeParallel(new b(), new ArrayList(this.LA), this.LB);
            }
        }
    }

    public int getHistorySize() {
        int size;
        synchronized (this.Ly) {
            fq();
            size = this.LA.size();
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
        if (this.LC == null || this.mIntent == null || this.Lz.isEmpty() || this.LA.isEmpty()) {
            return false;
        }
        this.LC.sort(this.mIntent, this.Lz, Collections.unmodifiableList(this.LA));
        return true;
    }

    private boolean ft() {
        if (!this.LI || this.mIntent == null) {
            return false;
        }
        this.LI = false;
        this.Lz.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.Lz.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean fu() {
        if (this.LE && this.LH && !TextUtils.isEmpty(this.LB)) {
            this.LE = false;
            this.LG = true;
            fw();
            return true;
        }
        return false;
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.LA.add(historicalRecord);
        if (add) {
            this.LH = true;
            fv();
            fp();
            fs();
            notifyChanged();
        }
        return add;
    }

    private void fv() {
        int size = this.LA.size() - this.LD;
        if (size > 0) {
            this.LH = true;
            for (int i = 0; i < size; i++) {
                this.LA.remove(0);
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
        private final Map<ComponentName, ActivityResolveInfo> LM = new HashMap();

        a() {
        }

        @Override // android.support.v7.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            float f;
            Map<ComponentName, ActivityResolveInfo> map = this.LM;
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
            FileInputStream openFileInput = this.mContext.openFileInput(this.LB);
            try {
                try {
                    try {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, HTTP.UTF_8);
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                        if (!"historical-records".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<HistoricalRecord> list = this.LA;
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
                    Log.e(LOG_TAG, "Error reading historical recrod file: " + this.LB, e3);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e4) {
                        }
                    }
                }
            } catch (XmlPullParserException e5) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + this.LB, e5);
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
                        newSerializer.startDocument(HTTP.UTF_8, true);
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
                        ActivityChooserModel.this.LE = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th) {
                        ActivityChooserModel.this.LE = true;
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.LB, e3);
                    ActivityChooserModel.this.LE = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IllegalArgumentException e5) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.LB, e5);
                    ActivityChooserModel.this.LE = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IllegalStateException e7) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.LB, e7);
                    ActivityChooserModel.this.LE = true;
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
