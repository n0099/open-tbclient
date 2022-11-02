package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.h.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AlgoHandleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int ir;
    public final List<Long> ml;
    public boolean mm;
    public long mn;
    public HandlerThread mo;
    public a mp;

    /* loaded from: classes.dex */
    public static final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean cC;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cC = false;
        }

        public void a(int i, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, runnable) == null) || this.cC) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1004) {
                    this.cC = true;
                }
                Runnable runnable = (Runnable) message.obj;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public AlgoHandleController() {
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
        this.ml = Collections.synchronizedList(new ArrayList());
        this.mm = true;
        this.ir = 0;
        this.mn = 0L;
        if (this.mo == null) {
            HandlerThread handlerThread = new HandlerThread("HandleHandlerThread");
            this.mo = handlerThread;
            handlerThread.start();
        }
        if (this.mp == null) {
            this.mp = new a(this.mo.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mm = false;
            if (this.ml.size() > 0) {
                try {
                    for (Long l : this.ml) {
                        long longValue = l.longValue();
                        if (longValue <= 0 || longValue != this.mn) {
                            AlgoHandleAdapter.destroyHandle(longValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    b.aS("release Exception:" + e.getMessage());
                }
            }
            if (this.mp != null) {
                this.mp = null;
            }
            HandlerThread handlerThread = this.mo;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mo = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, this, j)) == null) {
            m(j);
            return AlgoHandleAdapter.destroyHandle(j);
        }
        return invokeJ.intValue;
    }

    private void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, this, j) == null) {
            try {
                if (this.ml.contains(Long.valueOf(j))) {
                    int indexOf = this.ml.indexOf(Long.valueOf(j));
                    if (indexOf >= 0) {
                        this.ml.remove(indexOf);
                        if (indexOf >= 1) {
                            y(indexOf);
                            return;
                        }
                        return;
                    }
                    b.aS("removeHandle cant find:" + j);
                }
            } catch (Exception e) {
                e.printStackTrace();
                b.aS("removeHandle Exception:" + e.getMessage());
            }
        }
    }

    private void y(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i) == null) || i <= 5) {
            return;
        }
        b.aR("type:" + this.ir + " destroyIgnoreHandles current size:" + i);
        for (int i2 = 0; i2 < i; i2++) {
            long longValue = this.ml.get(0).longValue();
            this.ml.remove(0);
            AlgoHandleAdapter.destroyHandle(longValue);
        }
    }

    public long createHandle() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mm) {
                long createHandle = AlgoHandleAdapter.createHandle();
                HandlerThread handlerThread = this.mo;
                if (handlerThread != null && handlerThread.isAlive() && (aVar = this.mp) != null) {
                    aVar.a(1001, new Runnable(this, createHandle) { // from class: com.baidu.ar.databasic.AlgoHandleController.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long mr;
                        public final /* synthetic */ AlgoHandleController mt;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Long.valueOf(createHandle)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.mt = this;
                            this.mr = createHandle;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.mt.ml.add(Long.valueOf(this.mr));
                            }
                        }
                    });
                }
                return createHandle;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int destroyHandle(long j) {
        InterceptResult invokeJ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            HandlerThread handlerThread = this.mo;
            if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.mp) == null) {
                return -1;
            }
            aVar.a(1003, new Runnable(this, j) { // from class: com.baidu.ar.databasic.AlgoHandleController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long mr;
                public final /* synthetic */ AlgoHandleController mt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mt = this;
                    this.mr = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.mt.l(this.mr);
                    }
                }
            });
            return 0;
        }
        return invokeJ.intValue;
    }

    public byte[] getHandleMaskData(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? AlgoHandleAdapter.getHandleMaskData(j) : (byte[]) invokeJ.objValue;
    }

    public int getHandleReserveData(long j, ReserveHandleData reserveHandleData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, reserveHandleData)) == null) ? AlgoHandleAdapter.getHandleReserveData(j, reserveHandleData) : invokeJL.intValue;
    }

    public int getHandleType(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) ? AlgoHandleAdapter.getHandleType(j) : invokeJ.intValue;
    }

    public int increaseHandleReference(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? AlgoHandleAdapter.increaseHandleReference(j) : invokeJ.intValue;
    }

    public void release() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mm = false;
            HandlerThread handlerThread = this.mo;
            if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.mp) == null) {
                return;
            }
            aVar.a(1004, new Runnable(this) { // from class: com.baidu.ar.databasic.AlgoHandleController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlgoHandleController mt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mt = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.mt.da();
                    }
                }
            });
        }
    }

    public void sendHandleToRenderer(long j, l lVar, String str) {
        HandlerThread handlerThread;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), lVar, str}) == null) || (handlerThread = this.mo) == null || !handlerThread.isAlive() || (aVar = this.mp) == null) {
            return;
        }
        aVar.a(1002, new Runnable(this, lVar, j, str) { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l mq;
            public final /* synthetic */ long mr;
            public final /* synthetic */ String ms;
            public final /* synthetic */ AlgoHandleController mt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, lVar, Long.valueOf(j), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mt = this;
                this.mq = lVar;
                this.mr = j;
                this.ms = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (lVar2 = this.mq) == null) {
                    return;
                }
                lVar2.a(this.mr, this.ms);
            }
        });
    }

    public int setHandleFaceHandle(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? AlgoHandleAdapter.setHandleFaceHandle(j, j2) : invokeCommon.intValue;
    }

    public int setHandleInput(long j, int i, long j2, int i2, int i3, int i4, boolean z, int i5, boolean z2, ByteBuffer byteBuffer) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5), Boolean.valueOf(z2), byteBuffer})) == null) {
            this.ir = i;
            return AlgoHandleAdapter.setHandleInput(j, i, j2, i2, i3, i4, z, i5, z2, byteBuffer);
        }
        return invokeCommon.intValue;
    }

    public int setHandleMaskThreshold(long j, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Float.valueOf(f)})) == null) ? AlgoHandleAdapter.setHandleMaskThreshold(j, f) : invokeCommon.intValue;
    }

    public void setUsingHandle(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.mn = j;
        }
    }
}
