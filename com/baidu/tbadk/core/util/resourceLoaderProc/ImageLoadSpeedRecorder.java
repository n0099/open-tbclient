package com.baidu.tbadk.core.util.resourceLoaderProc;

import c.a.e.e.p.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes6.dex */
public class ImageLoadSpeedRecorder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOWEST_SPEED_FOR_PARALLEL = 20;
    public static final int QUEUE_SIZE = 5;
    public static ImageLoadSpeedRecorder _speedRecorder;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAverageSpeed;
    public Queue<LoadSpeedRecordItem> mSpeedRecordQueue;
    public BdAsyncTaskParallel mTaskParallelThree;
    public BdAsyncTaskParallel mTaskSerial;

    /* renamed from: com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoadSpeedRecorder$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(490226495, "Lcom/baidu/tbadk/core/util/resourceLoaderProc/ImageLoadSpeedRecorder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(490226495, "Lcom/baidu/tbadk/core/util/resourceLoaderProc/ImageLoadSpeedRecorder;");
        }
    }

    public ImageLoadSpeedRecorder() {
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
        this.mSpeedRecordQueue = new LinkedList();
        this.mTaskSerial = null;
        this.mTaskParallelThree = null;
        this.mAverageSpeed = 0.0f;
    }

    public static ImageLoadSpeedRecorder sharedInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (_speedRecorder == null) {
                _speedRecorder = new ImageLoadSpeedRecorder();
            }
            return _speedRecorder;
        }
        return (ImageLoadSpeedRecorder) invokeV.objValue;
    }

    public synchronized void addSpeedRecordItem(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                LoadSpeedRecordItem loadSpeedRecordItem = new LoadSpeedRecordItem(this, null);
                loadSpeedRecordItem.downloadSize = i2;
                loadSpeedRecordItem.timeCosts = j2;
                this.mSpeedRecordQueue.offer(loadSpeedRecordItem);
                if (this.mSpeedRecordQueue.size() > 5) {
                    this.mSpeedRecordQueue.poll();
                }
                if (speedRedordAvilable()) {
                    int i3 = 0;
                    for (LoadSpeedRecordItem loadSpeedRecordItem2 : this.mSpeedRecordQueue) {
                        if (j2 > 0) {
                            i3 = (int) (i3 + (loadSpeedRecordItem2.downloadSize / loadSpeedRecordItem2.timeCosts));
                        }
                    }
                    this.mAverageSpeed = i3 / 5;
                }
            }
        }
    }

    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (j.v()) {
                if (speedRedordAvilable() && this.mAverageSpeed < 20.0f) {
                    if (this.mTaskSerial == null) {
                        this.mTaskSerial = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
                    }
                    return this.mTaskSerial;
                }
                if (this.mTaskParallelThree == null) {
                    this.mTaskParallelThree = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, BdUniqueId.gen());
                }
                return this.mTaskParallelThree;
            }
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    public boolean speedRedordAvilable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSpeedRecordQueue.size() == 5 : invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class LoadSpeedRecordItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int downloadSize;
        public final /* synthetic */ ImageLoadSpeedRecorder this$0;
        public long timeCosts;

        public LoadSpeedRecordItem(ImageLoadSpeedRecorder imageLoadSpeedRecorder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageLoadSpeedRecorder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imageLoadSpeedRecorder;
            this.downloadSize = 0;
            this.timeCosts = 0L;
        }

        public /* synthetic */ LoadSpeedRecordItem(ImageLoadSpeedRecorder imageLoadSpeedRecorder, AnonymousClass1 anonymousClass1) {
            this(imageLoadSpeedRecorder);
        }
    }
}
