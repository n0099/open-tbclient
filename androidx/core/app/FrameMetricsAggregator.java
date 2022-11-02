package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameMetricsBaseImpl mInstance;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NANOS_PER_MS = 1000000;
        public static final int NANOS_ROUNDING_VALUE = 500000;
        public static Handler sHandler;
        public static HandlerThread sHandlerThread;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<WeakReference<Activity>> mActivities;
        public Window.OnFrameMetricsAvailableListener mListener;
        public SparseIntArray[] mMetrics;
        public int mTrackingFlags;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-163336874, "Landroidx/core/app/FrameMetricsAggregator$FrameMetricsApi24Impl;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163336874, "Landroidx/core/app/FrameMetricsAggregator$FrameMetricsApi24Impl;");
            }
        }

        public FrameMetricsApi24Impl(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mMetrics = new SparseIntArray[9];
            this.mActivities = new ArrayList<>();
            this.mListener = new Window.OnFrameMetricsAvailableListener(this) { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrameMetricsApi24Impl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, window, frameMetrics, i4) == null) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl = this.this$0;
                        if ((frameMetricsApi24Impl.mTrackingFlags & 1) != 0) {
                            frameMetricsApi24Impl.addDurationItem(frameMetricsApi24Impl.mMetrics[0], frameMetrics.getMetric(8));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl2 = this.this$0;
                        if ((frameMetricsApi24Impl2.mTrackingFlags & 2) != 0) {
                            frameMetricsApi24Impl2.addDurationItem(frameMetricsApi24Impl2.mMetrics[1], frameMetrics.getMetric(1));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl3 = this.this$0;
                        if ((frameMetricsApi24Impl3.mTrackingFlags & 4) != 0) {
                            frameMetricsApi24Impl3.addDurationItem(frameMetricsApi24Impl3.mMetrics[2], frameMetrics.getMetric(3));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl4 = this.this$0;
                        if ((frameMetricsApi24Impl4.mTrackingFlags & 8) != 0) {
                            frameMetricsApi24Impl4.addDurationItem(frameMetricsApi24Impl4.mMetrics[3], frameMetrics.getMetric(4));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl5 = this.this$0;
                        if ((frameMetricsApi24Impl5.mTrackingFlags & 16) != 0) {
                            frameMetricsApi24Impl5.addDurationItem(frameMetricsApi24Impl5.mMetrics[4], frameMetrics.getMetric(5));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl6 = this.this$0;
                        if ((frameMetricsApi24Impl6.mTrackingFlags & 64) != 0) {
                            frameMetricsApi24Impl6.addDurationItem(frameMetricsApi24Impl6.mMetrics[6], frameMetrics.getMetric(7));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl7 = this.this$0;
                        if ((frameMetricsApi24Impl7.mTrackingFlags & 32) != 0) {
                            frameMetricsApi24Impl7.addDurationItem(frameMetricsApi24Impl7.mMetrics[5], frameMetrics.getMetric(6));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl8 = this.this$0;
                        if ((frameMetricsApi24Impl8.mTrackingFlags & 128) != 0) {
                            frameMetricsApi24Impl8.addDurationItem(frameMetricsApi24Impl8.mMetrics[7], frameMetrics.getMetric(0));
                        }
                        FrameMetricsApi24Impl frameMetricsApi24Impl9 = this.this$0;
                        if ((frameMetricsApi24Impl9.mTrackingFlags & 256) != 0) {
                            frameMetricsApi24Impl9.addDurationItem(frameMetricsApi24Impl9.mMetrics[8], frameMetrics.getMetric(2));
                        }
                    }
                }
            };
            this.mTrackingFlags = i;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                if (sHandlerThread == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                    sHandlerThread = handlerThread;
                    handlerThread.start();
                    sHandler = new Handler(sHandlerThread.getLooper());
                }
                for (int i = 0; i <= 8; i++) {
                    SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                    if (sparseIntArrayArr[i] == null && (this.mTrackingFlags & (1 << i)) != 0) {
                        sparseIntArrayArr[i] = new SparseIntArray();
                    }
                }
                activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
                this.mActivities.add(new WeakReference<>(activity));
            }
        }

        public void addDurationItem(SparseIntArray sparseIntArray, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseIntArray, j) == null) && sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mMetrics;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                this.mMetrics = new SparseIntArray[9];
                return sparseIntArrayArr;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
                Iterator<WeakReference<Activity>> it = this.mActivities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<Activity> next = it.next();
                    if (next.get() == activity) {
                        this.mActivities.remove(next);
                        break;
                    }
                }
                activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                return this.mMetrics;
            }
            return (SparseIntArray[]) invokeL.objValue;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                for (int size = this.mActivities.size() - 1; size >= 0; size--) {
                    WeakReference<Activity> weakReference = this.mActivities.get(size);
                    Activity activity = weakReference.get();
                    if (weakReference.get() != null) {
                        activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                        this.mActivities.remove(size);
                    }
                }
                return this.mMetrics;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class FrameMetricsBaseImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void add(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            }
        }

        public SparseIntArray[] getMetrics() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }

        public SparseIntArray[] remove(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
                return null;
            }
            return (SparseIntArray[]) invokeL.objValue;
        }

        public SparseIntArray[] reset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }

        public SparseIntArray[] stop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (SparseIntArray[]) invokeV.objValue;
        }

        public FrameMetricsBaseImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameMetricsAggregator() {
        this(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mInstance.getMetrics();
        }
        return (SparseIntArray[]) invokeV.objValue;
    }

    @Nullable
    public SparseIntArray[] reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mInstance.reset();
        }
        return (SparseIntArray[]) invokeV.objValue;
    }

    @Nullable
    public SparseIntArray[] stop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mInstance.stop();
        }
        return (SparseIntArray[]) invokeV.objValue;
    }

    public FrameMetricsAggregator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInstance = new FrameMetricsApi24Impl(i);
        } else {
            this.mInstance = new FrameMetricsBaseImpl();
        }
    }

    public void add(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.mInstance.add(activity);
        }
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return this.mInstance.remove(activity);
        }
        return (SparseIntArray[]) invokeL.objValue;
    }
}
