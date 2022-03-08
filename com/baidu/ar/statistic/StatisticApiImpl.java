package com.baidu.ar.statistic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class StatisticApiImpl implements g, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread wW;
    public c wX;
    public Thread wY;
    public h wZ;
    public d wp;
    public volatile k xa;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handlerThread};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wp = new d(context, "ar_stats_local.json", 100, 40);
        d dVar = new d(context, "ar_stats_pfm_local.json", 200, 0);
        this.xa = new k(dVar, 20, 200);
        a(handlerThread, new b(context, this.wp, q.xb, r.gr(), this.xa));
        a(context, dVar);
        this.wX.a(1, null);
        r(context);
    }

    private void a(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, dVar) == null) {
            d dVar2 = this.wp;
            this.wZ = new h(context, dVar2, new i[]{new i(dVar2, 10, new j(), true), new m(dVar, 20, new n(), false)});
            Thread thread = new Thread(this.wZ, "StatsLogSendThd");
            this.wY = thread;
            thread.start();
        }
    }

    private void a(HandlerThread handlerThread, b bVar) {
        HandlerThread handlerThread2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, handlerThread, bVar) == null) {
            if (handlerThread != null) {
                this.wW = handlerThread;
                if (handlerThread.getState() == Thread.State.NEW) {
                    handlerThread2 = this.wW;
                }
                this.wX = new c(this.wW.getLooper(), bVar);
            }
            handlerThread2 = new HandlerThread("StatsEventThd", 10);
            this.wW = handlerThread2;
            handlerThread2.start();
            this.wX = new c(this.wW.getLooper(), bVar);
        }
    }

    private void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            new l(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
        }
    }

    public void doRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.wW != null) {
                    this.wW.quitSafely();
                }
                if (this.wZ != null) {
                    this.wZ.shutdown();
                }
                if (this.wY != null) {
                    synchronized (this.wp) {
                        if (this.wp.isEmpty()) {
                            this.wY.interrupt();
                        }
                    }
                }
            }
            a.release();
        }
    }

    @Override // com.baidu.ar.statistic.g
    public boolean isAllowPerformanceEvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.xa.aJ(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            a az = a.az(str);
            az.b("event_param", str2);
            this.wX.a(2, az);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, map) == null) {
            a az = a.az(str);
            az.a(map);
            this.wX.a(2, az);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            a az = a.az(str);
            az.b("_db_period", Long.valueOf(j2));
            az.b("event_param", str2);
            this.wX.a(6, az);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), map}) == null) {
            a az = a.az(str);
            az.a(map);
            az.b("_db_period", Long.valueOf(j2));
            this.wX.a(6, az);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.wX.a(5, a.az(str));
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.wX.a(4, a.az(str));
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStatus(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z) == null) {
            a az = a.az(str);
            az.b("__stt", z ? "1" : "0");
            az.b("__falseev", str2);
            this.wX.a(3, az);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, map) == null) {
            synchronized (this.xa) {
                if (this.xa.aJ(str)) {
                    a az = a.az(str);
                    az.a(map);
                    this.wX.a(20, az);
                }
            }
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, jSONObject) == null) {
            synchronized (this.xa) {
                if (this.xa.aJ(str)) {
                    a az = a.az(str);
                    az.b("data", jSONObject);
                    this.wX.a(20, az);
                }
            }
        }
    }

    @Override // com.baidu.ar.statistic.l.a
    public void onPerformanceRequestFinished(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.wX.a(21, list);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.wX.a(97, Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.wX.a(99, this);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.wX.a(98, Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParam(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            this.wX.setPubParam(str, str2);
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            this.wX.setPubParams(map);
        }
    }
}
