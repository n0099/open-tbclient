package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "JobIntentService";
    public static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer;
    public static final Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<CompatWorkItem> mCompatQueue;
    public WorkEnqueuer mCompatWorkEnqueuer;
    public CommandProcessor mCurProcessor;
    public boolean mDestroyed;
    public boolean mInterruptIfStopped;
    public CompatJobEngine mJobImpl;
    public boolean mStopped;

    /* loaded from: classes.dex */
    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JobIntentService this$0;

        public CommandProcessor(JobIntentService jobIntentService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jobIntentService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = jobIntentService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) != null) {
                return (Void) invokeL.objValue;
            }
            while (true) {
                GenericWorkItem dequeueWork = this.this$0.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                this.this$0.onHandleWork(dequeueWork.getIntent());
                dequeueWork.complete();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onCancelled(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                this.this$0.processorFinished();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, r5) == null) {
                this.this$0.processorFinished();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* loaded from: classes.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public final PowerManager.WakeLock mLaunchWakeLock;
        public boolean mLaunchingService;
        public final PowerManager.WakeLock mRunWakeLock;
        public boolean mServiceProcessing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ComponentName) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(this.mComponentName);
                if (this.mContext.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.mLaunchingService) {
                            this.mLaunchingService = true;
                            if (!this.mServiceProcessing) {
                                this.mLaunchWakeLock.acquire(60000L);
                            }
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.mServiceProcessing) {
                        if (this.mLaunchingService) {
                            this.mLaunchWakeLock.acquire(60000L);
                        }
                        this.mServiceProcessing = false;
                        this.mRunWakeLock.release();
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (!this.mServiceProcessing) {
                        this.mServiceProcessing = true;
                        this.mRunWakeLock.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
                        this.mLaunchWakeLock.release();
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.mLaunchingService = false;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class CompatWorkItem implements GenericWorkItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Intent mIntent;
        public final int mStartId;
        public final /* synthetic */ JobIntentService this$0;

        public CompatWorkItem(JobIntentService jobIntentService, Intent intent, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jobIntentService, intent, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = jobIntentService;
            this.mIntent = intent;
            this.mStartId = i2;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.stopSelf(this.mStartId);
            }
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIntent : (Intent) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean DEBUG = false;
        public static final String TAG = "JobServiceEngineImpl";
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mLock;
        public JobParameters mParams;
        public final JobIntentService mService;

        /* loaded from: classes.dex */
        public final class WrapperWorkItem implements GenericWorkItem {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final JobWorkItem mJobWork;
            public final /* synthetic */ JobServiceEngineImpl this$0;

            public WrapperWorkItem(JobServiceEngineImpl jobServiceEngineImpl, JobWorkItem jobWorkItem) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jobServiceEngineImpl, jobWorkItem};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = jobServiceEngineImpl;
                this.mJobWork = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mLock) {
                        if (this.this$0.mParams != null) {
                            this.this$0.mParams.completeWork(this.mJobWork);
                        }
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mJobWork.getIntent() : (Intent) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jobIntentService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Service) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
            this.mService = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getBinder() : (IBinder) invokeV.objValue;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.mLock) {
                    if (this.mParams == null) {
                        return null;
                    }
                    JobWorkItem dequeueWork = this.mParams.dequeueWork();
                    if (dequeueWork != null) {
                        dequeueWork.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
                        return new WrapperWorkItem(this, dequeueWork);
                    }
                    return null;
                }
            }
            return (GenericWorkItem) invokeV.objValue;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jobParameters)) == null) {
                this.mParams = jobParameters;
                this.mService.ensureProcessorRunningLocked(false);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jobParameters)) == null) {
                boolean doStopCurrentWork = this.mService.doStopCurrentWork();
                synchronized (this.mLock) {
                    this.mParams = null;
                }
                return doStopCurrentWork;
            }
            return invokeL.booleanValue;
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JobInfo mJobInfo;
        public final JobScheduler mJobScheduler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JobWorkEnqueuer(Context context, ComponentName componentName, int i2) {
            super(componentName);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((ComponentName) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ensureJobId(i2);
            this.mJobInfo = new JobInfo.Builder(i2, this.mComponentName).setOverrideDeadline(0L).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
                this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class WorkEnqueuer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ComponentName mComponentName;
        public boolean mHasJobId;
        public int mJobId;

        public WorkEnqueuer(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {componentName};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mComponentName = componentName;
        }

        public abstract void enqueueWork(Intent intent);

        public void ensureJobId(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (!this.mHasJobId) {
                    this.mHasJobId = true;
                    this.mJobId = i2;
                } else if (this.mJobId == i2) {
                } else {
                    throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.mJobId);
                }
            }
        }

        public void serviceProcessingFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public void serviceProcessingStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void serviceStartReceived() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146690277, "Landroidx/core/app/JobIntentService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-146690277, "Landroidx/core/app/JobIntentService;");
                return;
            }
        }
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap<>();
    }

    public JobIntentService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i2, @NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65539, null, context, cls, i2, intent) == null) {
            enqueueWork(context, new ComponentName(context, cls), i2, intent);
        }
    }

    public static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean z, int i2) {
        InterceptResult invokeCommon;
        WorkEnqueuer compatWorkEnqueuer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, componentName, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            WorkEnqueuer workEnqueuer = sClassWorkEnqueuer.get(componentName);
            if (workEnqueuer == null) {
                if (Build.VERSION.SDK_INT < 26) {
                    compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
                } else if (z) {
                    compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
                } else {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
                sClassWorkEnqueuer.put(componentName, workEnqueuer2);
                return workEnqueuer2;
            }
            return workEnqueuer;
        }
        return (WorkEnqueuer) invokeCommon.objValue;
    }

    public GenericWorkItem dequeueWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CompatJobEngine compatJobEngine = this.mJobImpl;
            if (compatJobEngine != null) {
                return compatJobEngine.dequeueWork();
            }
            synchronized (this.mCompatQueue) {
                if (this.mCompatQueue.size() > 0) {
                    return this.mCompatQueue.remove(0);
                }
                return null;
            }
        }
        return (GenericWorkItem) invokeV.objValue;
    }

    public boolean doStopCurrentWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CommandProcessor commandProcessor = this.mCurProcessor;
            if (commandProcessor != null) {
                commandProcessor.cancel(this.mInterruptIfStopped);
            }
            this.mStopped = true;
            return onStopCurrentWork();
        }
        return invokeV.booleanValue;
    }

    public void ensureProcessorRunningLocked(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor(this);
            WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean isStopped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStopped : invokeV.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) {
            CompatJobEngine compatJobEngine = this.mJobImpl;
            if (compatJobEngine != null) {
                return compatJobEngine.compatGetBinder();
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCreate();
            if (Build.VERSION.SDK_INT >= 26) {
                this.mJobImpl = new JobServiceEngineImpl(this);
                this.mCompatWorkEnqueuer = null;
                return;
            }
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, JobIntentService.class), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
            if (arrayList != null) {
                synchronized (arrayList) {
                    this.mDestroyed = true;
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }
            }
        }
    }

    public abstract void onHandleWork(@NonNull Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent, i2, i3)) == null) {
            if (this.mCompatQueue != null) {
                this.mCompatWorkEnqueuer.serviceStartReceived();
                synchronized (this.mCompatQueue) {
                    ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
                    if (intent == null) {
                        intent = new Intent();
                    }
                    arrayList.add(new CompatWorkItem(this, intent, i3));
                    ensureProcessorRunningLocked(true);
                }
                return 3;
            }
            return 2;
        }
        return invokeLII.intValue;
    }

    public boolean onStopCurrentWork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void processorFinished() {
        ArrayList<CompatWorkItem> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (arrayList = this.mCompatQueue) == null) {
            return;
        }
        synchronized (arrayList) {
            this.mCurProcessor = null;
            if (this.mCompatQueue != null && this.mCompatQueue.size() > 0) {
                ensureProcessorRunningLocked(false);
            } else if (!this.mDestroyed) {
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    public void setInterruptIfStopped(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mInterruptIfStopped = z;
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65538, null, context, componentName, i2, intent) == null) {
            if (intent != null) {
                synchronized (sLock) {
                    WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i2);
                    workEnqueuer.ensureJobId(i2);
                    workEnqueuer.enqueueWork(intent);
                }
                return;
            }
            throw new IllegalArgumentException("work must not be null");
        }
    }
}
