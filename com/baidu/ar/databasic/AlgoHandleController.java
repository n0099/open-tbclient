package com.baidu.ar.databasic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.l;
import com.baidu.ar.h.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class AlgoHandleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int ir;
    public final List<Long> ml;
    public boolean mm;
    public long mn;
    public HandlerThread mo;
    public a mp;

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cC = false;
        }

        public void a(int i2, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, runnable) == null) || this.cC) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                    b.aS("release Exception:" + e2.getMessage());
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
    public int l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2)) == null) {
            m(j2);
            return AlgoHandleAdapter.destroyHandle(j2);
        }
        return invokeJ.intValue;
    }

    private void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, this, j2) == null) {
            try {
                if (this.ml.contains(Long.valueOf(j2))) {
                    int indexOf = this.ml.indexOf(Long.valueOf(j2));
                    if (indexOf >= 0) {
                        this.ml.remove(indexOf);
                        if (indexOf >= 1) {
                            y(indexOf);
                            return;
                        }
                        return;
                    }
                    b.aS("removeHandle cant find:" + j2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                b.aS("removeHandle Exception:" + e2.getMessage());
            }
        }
    }

    private void y(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || i2 <= 5) {
            return;
        }
        b.aR("type:" + this.ir + " destroyIgnoreHandles current size:" + i2);
        for (int i3 = 0; i3 < i2; i3++) {
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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

    public int destroyHandle(long j2) {
        InterceptResult invokeJ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            HandlerThread handlerThread = this.mo;
            if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.mp) == null) {
                return -1;
            }
            aVar.a(1003, new Runnable(this, j2) { // from class: com.baidu.ar.databasic.AlgoHandleController.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long mr;
                public final /* synthetic */ AlgoHandleController mt;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mt = this;
                    this.mr = j2;
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

    public byte[] getHandleMaskData(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? AlgoHandleAdapter.getHandleMaskData(j2) : (byte[]) invokeJ.objValue;
    }

    public int getHandleReserveData(long j2, ReserveHandleData reserveHandleData) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, reserveHandleData)) == null) ? AlgoHandleAdapter.getHandleReserveData(j2, reserveHandleData) : invokeJL.intValue;
    }

    public int getHandleType(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) ? AlgoHandleAdapter.getHandleType(j2) : invokeJ.intValue;
    }

    public int increaseHandleReference(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? AlgoHandleAdapter.increaseHandleReference(j2) : invokeJ.intValue;
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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

    public void sendHandleToRenderer(long j2, l lVar, String str) {
        HandlerThread handlerThread;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), lVar, str}) == null) || (handlerThread = this.mo) == null || !handlerThread.isAlive() || (aVar = this.mp) == null) {
            return;
        }
        aVar.a(1002, new Runnable(this, lVar, j2, str) { // from class: com.baidu.ar.databasic.AlgoHandleController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l mq;
            public final /* synthetic */ long mr;

            /* renamed from: ms  reason: collision with root package name */
            public final /* synthetic */ String f38461ms;
            public final /* synthetic */ AlgoHandleController mt;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, lVar, Long.valueOf(j2), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mt = this;
                this.mq = lVar;
                this.mr = j2;
                this.f38461ms = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (lVar2 = this.mq) == null) {
                    return;
                }
                lVar2.a(this.mr, this.f38461ms);
            }
        });
    }

    public int setHandleFaceHandle(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? AlgoHandleAdapter.setHandleFaceHandle(j2, j3) : invokeCommon.intValue;
    }

    public int setHandleInput(long j2, int i2, long j3, int i3, int i4, int i5, boolean z, int i6, boolean z2, ByteBuffer byteBuffer) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Integer.valueOf(i6), Boolean.valueOf(z2), byteBuffer})) == null) {
            this.ir = i2;
            return AlgoHandleAdapter.setHandleInput(j2, i2, j3, i3, i4, i5, z, i6, z2, byteBuffer);
        }
        return invokeCommon.intValue;
    }

    public int setHandleMaskThreshold(long j2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2)})) == null) ? AlgoHandleAdapter.setHandleMaskThreshold(j2, f2) : invokeCommon.intValue;
    }

    public void setUsingHandle(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.mn = j2;
        }
    }
}
