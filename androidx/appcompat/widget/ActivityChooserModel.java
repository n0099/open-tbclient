package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes.dex */
public class ActivityChooserModel extends DataSetObservable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ATTRIBUTE_ACTIVITY = "activity";
    public static final String ATTRIBUTE_TIME = "time";
    public static final String ATTRIBUTE_WEIGHT = "weight";
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ACTIVITY_INFLATION = 5;
    public static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    public static final String HISTORY_FILE_EXTENSION = ".xml";
    public static final int INVALID_INDEX = -1;
    public static final String LOG_TAG;
    public static final String TAG_HISTORICAL_RECORD = "historical-record";
    public static final String TAG_HISTORICAL_RECORDS = "historical-records";
    public static final Map<String, ActivityChooserModel> sDataModelRegistry;
    public static final Object sRegistryLock;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ActivityResolveInfo> mActivities;
    public OnChooseActivityListener mActivityChoserModelPolicy;
    public ActivitySorter mActivitySorter;
    public boolean mCanReadHistoricalData;
    public final Context mContext;
    public final List<HistoricalRecord> mHistoricalRecords;
    public boolean mHistoricalRecordsChanged;
    public final String mHistoryFileName;
    public int mHistoryMaxSize;
    public final Object mInstanceLock;
    public Intent mIntent;
    public boolean mReadShareHistoryCalled;
    public boolean mReloadActivities;

    /* loaded from: classes.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: classes.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List list, List list2);
    }

    /* loaded from: classes.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* loaded from: classes.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resolveInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.resolveInfo = resolveInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activityResolveInfo)) == null) {
                return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
            }
            return invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Float.floatToIntBits(this.weight) + 31;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + "resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class DefaultSorter implements ActivitySorter {
        public static /* synthetic */ Interceptable $ic = null;
        public static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        public DefaultSorter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, intent, list, list2) == null) {
                Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
                map.clear();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ActivityResolveInfo activityResolveInfo = list.get(i);
                    activityResolveInfo.weight = 0.0f;
                    ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                    map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
                }
                float f = 1.0f;
                for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                    HistoricalRecord historicalRecord = list2.get(size2);
                    ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                    if (activityResolveInfo2 != null) {
                        activityResolveInfo2.weight += historicalRecord.weight * f;
                        f *= 0.95f;
                    }
                }
                Collections.sort(list);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class HistoricalRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {componentName, Long.valueOf(j), Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), Float.valueOf(f)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((ComponentName) objArr2[0], ((Long) objArr2[1]).longValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || HistoricalRecord.class != obj.getClass()) {
                    return false;
                }
                HistoricalRecord historicalRecord = (HistoricalRecord) obj;
                ComponentName componentName = this.activity;
                if (componentName == null) {
                    if (historicalRecord.activity != null) {
                        return false;
                    }
                } else if (!componentName.equals(historicalRecord.activity)) {
                    return false;
                }
                if (this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ComponentName componentName = this.activity;
                if (componentName == null) {
                    hashCode = 0;
                } else {
                    hashCode = componentName.hashCode();
                }
                long j = this.time;
                return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return PreferencesUtil.LEFT_MOUNT + "; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivityChooserModel this$0;

        public PersistHistoryAsyncTask(ActivityChooserModel activityChooserModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityChooserModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = activityChooserModel;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IPUT]}, finally: {[IGET, IPUT, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
            if (r15 != null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
            if (r15 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b4, code lost:
            if (r15 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d4, code lost:
            if (r15 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d7, code lost:
            return null;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                List list = (List) objArr[0];
                String str = (String) objArr[1];
                try {
                    FileOutputStream openFileOutput = this.this$0.mContext.openFileOutput(str, 0);
                    XmlSerializer newSerializer = Xml.newSerializer();
                    try {
                        try {
                            try {
                                newSerializer.setOutput(openFileOutput, null);
                                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                                newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                                    newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                    newSerializer.attribute(null, "activity", historicalRecord.activity.flattenToString());
                                    newSerializer.attribute(null, "time", String.valueOf(historicalRecord.time));
                                    newSerializer.attribute(null, "weight", String.valueOf(historicalRecord.weight));
                                    newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                }
                                newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                                newSerializer.endDocument();
                                this.this$0.mCanReadHistoricalData = true;
                            } catch (Throwable th) {
                                this.this$0.mCanReadHistoricalData = true;
                                if (openFileOutput != null) {
                                    try {
                                        openFileOutput.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IllegalArgumentException e) {
                            String str2 = ActivityChooserModel.LOG_TAG;
                            Log.e(str2, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);
                            this.this$0.mCanReadHistoricalData = true;
                        }
                    } catch (IOException e2) {
                        String str3 = ActivityChooserModel.LOG_TAG;
                        Log.e(str3, "Error writing historical record file: " + this.this$0.mHistoryFileName, e2);
                        this.this$0.mCanReadHistoricalData = true;
                    } catch (IllegalStateException e3) {
                        String str4 = ActivityChooserModel.LOG_TAG;
                        Log.e(str4, "Error writing historical record file: " + this.this$0.mHistoryFileName, e3);
                        this.this$0.mCanReadHistoricalData = true;
                    }
                } catch (FileNotFoundException e4) {
                    String str5 = ActivityChooserModel.LOG_TAG;
                    Log.e(str5, "Error writing historical record file: " + str, e4);
                    return null;
                }
            } else {
                return (Void) invokeL.objValue;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-703257703, "Landroidx/appcompat/widget/ActivityChooserModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-703257703, "Landroidx/appcompat/widget/ActivityChooserModel;");
                return;
            }
        }
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private boolean sortActivitiesIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
                this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ResolveInfo getDefaultActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                if (!this.mActivities.isEmpty()) {
                    return this.mActivities.get(0).resolveInfo;
                }
                return null;
            }
        }
        return (ResolveInfo) invokeV.objValue;
    }

    public ActivityChooserModel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
            return;
        }
        this.mHistoryFileName = str;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, historicalRecord)) == null) {
            boolean add = this.mHistoricalRecords.add(historicalRecord);
            if (add) {
                this.mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsIfNeeded();
                persistHistoricalDataIfNeeded();
                sortActivitiesIfNeeded();
                notifyChanged();
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public ResolveInfo getActivity(int i) {
        InterceptResult invokeI;
        ResolveInfo resolveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                resolveInfo = this.mActivities.get(i).resolveInfo;
            }
            return resolveInfo;
        }
        return (ResolveInfo) invokeI.objValue;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activitySorter) == null) {
            synchronized (this.mInstanceLock) {
                if (this.mActivitySorter == activitySorter) {
                    return;
                }
                this.mActivitySorter = activitySorter;
                if (sortActivitiesIfNeeded()) {
                    notifyChanged();
                }
            }
        }
    }

    public void setHistoryMaxSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            synchronized (this.mInstanceLock) {
                if (this.mHistoryMaxSize == i) {
                    return;
                }
                this.mHistoryMaxSize = i;
                pruneExcessiveHistoricalRecordsIfNeeded();
                if (sortActivitiesIfNeeded()) {
                    notifyChanged();
                }
            }
        }
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            synchronized (this.mInstanceLock) {
                if (this.mIntent == intent) {
                    return;
                }
                this.mIntent = intent;
                this.mReloadActivities = true;
                ensureConsistentState();
            }
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onChooseActivityListener) == null) {
            synchronized (this.mInstanceLock) {
                this.mActivityChoserModelPolicy = onChooseActivityListener;
            }
        }
    }

    private void ensureConsistentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (loadActivitiesIfNeeded) {
                sortActivitiesIfNeeded();
                notifyChanged();
            }
        }
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || (size = this.mHistoricalRecords.size() - this.mHistoryMaxSize) <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < size; i++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
                return false;
            }
            this.mCanReadHistoricalData = false;
            this.mReadShareHistoryCalled = true;
            readHistoricalDataImpl();
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getActivityCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                size = this.mActivities.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public int getHistoryMaxSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.mInstanceLock) {
                i = this.mHistoryMaxSize;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int getHistorySize() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                size = this.mHistoricalRecords.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public Intent getIntent() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.mInstanceLock) {
                intent = this.mIntent;
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public static ActivityChooserModel get(Context context, String str) {
        InterceptResult invokeLL;
        ActivityChooserModel activityChooserModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            synchronized (sRegistryLock) {
                activityChooserModel = sDataModelRegistry.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    sDataModelRegistry.put(str, activityChooserModel);
                }
            }
            return activityChooserModel;
        }
        return (ActivityChooserModel) invokeLL.objValue;
    }

    private boolean loadActivitiesIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (!this.mReloadActivities || this.mIntent == null) {
                return false;
            }
            this.mReloadActivities = false;
            this.mActivities.clear();
            List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                this.mActivities.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void persistHistoricalDataIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (this.mReadShareHistoryCalled) {
                if (!this.mHistoricalRecordsChanged) {
                    return;
                }
                this.mHistoricalRecordsChanged = false;
                if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                    new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
                    return;
                }
                return;
            }
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
    }

    private void readHistoricalDataImpl() {
        XmlPullParser newPullParser;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                FileInputStream openFileInput = this.mContext.openFileInput(this.mHistoryFileName);
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (Throwable th) {
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    String str = LOG_TAG;
                    Log.e(str, "Error reading historical recrod file: " + this.mHistoryFileName, e);
                    if (openFileInput == null) {
                        return;
                    }
                } catch (XmlPullParserException e2) {
                    String str2 = LOG_TAG;
                    Log.e(str2, "Error reading historical recrod file: " + this.mHistoryFileName, e2);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (TAG_HISTORICAL_RECORDS.equals(newPullParser.getName())) {
                    List<HistoricalRecord> list = this.mHistoricalRecords;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (next != 3 && next != 4) {
                            if (TAG_HISTORICAL_RECORD.equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (FileNotFoundException unused3) {
            }
        }
    }

    public Intent chooseActivity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            synchronized (this.mInstanceLock) {
                if (this.mIntent == null) {
                    return null;
                }
                ensureConsistentState();
                ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
                ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
                Intent intent = new Intent(this.mIntent);
                intent.setComponent(componentName);
                if (this.mActivityChoserModelPolicy != null) {
                    if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                        return null;
                    }
                }
                addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            }
        }
        return (Intent) invokeI.objValue;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, resolveInfo)) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                List<ActivityResolveInfo> list = this.mActivities;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i).resolveInfo == resolveInfo) {
                        return i;
                    }
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public void setDefaultActivity(int i) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            synchronized (this.mInstanceLock) {
                ensureConsistentState();
                ActivityResolveInfo activityResolveInfo = this.mActivities.get(i);
                ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
                if (activityResolveInfo2 != null) {
                    f = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
                } else {
                    f = 1.0f;
                }
                addHistoricalRecord(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            }
        }
    }
}
