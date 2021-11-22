package com.baidu.mobstat.dxmpay;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42362a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f42363b;

    /* renamed from: c  reason: collision with root package name */
    public a f42364c;

    /* renamed from: d  reason: collision with root package name */
    public a f42365d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42366e;

    /* renamed from: f  reason: collision with root package name */
    public long f42367f;

    /* renamed from: g  reason: collision with root package name */
    public Session f42368g;

    /* renamed from: h  reason: collision with root package name */
    public int f42369h;

    /* renamed from: i  reason: collision with root package name */
    public int f42370i;
    public long j;
    public boolean k;
    public LaunchInfo l;
    public LaunchInfo m;
    public Callback mCallback;

    /* loaded from: classes7.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42371a;

        public a() {
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
            this.f42371a = false;
        }
    }

    public SessionAnalysis() {
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
        this.f42362a = false;
        this.f42363b = new HashMap();
        this.f42364c = new a();
        this.f42365d = new a();
        this.f42366e = false;
        this.f42367f = 0L;
        this.f42368g = new Session();
        this.f42369h = 0;
        this.f42370i = 0;
        this.j = 0L;
        this.k = true;
    }

    private void a(Context context, long j, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (this.f42368g.hasEnd()) {
                DataCore.instance().putSession(this.f42368g);
                DataCore.instance().flush(context);
                d.a(this.f42368g.getPageSessionHead());
                this.f42368g.setEndTime(0L);
            }
            boolean z3 = j > 0;
            long startTime = z3 ? j : this.f42368g.getStartTime();
            if (z3) {
                this.f42368g.reset();
                this.f42368g.setStartTime(j);
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, null);
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onCallback(DataCore.instance().getLogData());
            }
            if (z3 || this.k) {
                LogSender.instance().onSend(context);
            }
            clearLastSessionCache(context);
        }
    }

    public void autoTrackLaunchInfo(LaunchInfo launchInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, launchInfo, z) == null) {
            if (z) {
                this.l = launchInfo;
            } else {
                this.m = launchInfo;
            }
        }
    }

    public void autoTrackSessionEndTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j) == null) || context == null) {
            return;
        }
        this.f42368g.setTrackEndTime(j);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j) == null) || context == null) {
            return;
        }
        this.f42368g.setTrackStartTime(j);
        this.j = j;
    }

    public void clearLastSessionCache(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String k = w.k(context);
        o.a(context, k + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    public void doSendLogCheck(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j) == null) {
            long j2 = this.f42367f;
            if (j2 <= 0 || j - j2 <= getSessionTimeOut()) {
                return;
            }
            a(context, -1L, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42368g.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42370i : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42368g.getStartTime() : invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f42369h <= 0) {
                this.f42369h = 30000;
            }
            return this.f42369h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f42368g.getStartTime() > 0 : invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j, ExtraInfo extraInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, str3, Long.valueOf(j), extraInfo, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j, boolean z, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j), Boolean.valueOf(z), extraInfo}) == null) {
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, str3, Long.valueOf(j)}) == null) {
        }
    }

    public void onPageStart(Context context, String str, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
        }
    }

    public void onPageStartAct(Context context, String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onPageStartFrag(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, Long.valueOf(j)}) == null) {
        }
    }

    public void onSessionStart(Context context, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f42362a) {
            return;
        }
        DataCore.instance().init(context);
        LaunchInfo launchInfo = this.l;
        a(context, j, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.f42362a = true;
    }

    public void setAutoSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.k = z;
        }
    }

    public void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 < 1) {
                i2 = 30;
                h.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[30] is used");
            } else if (i2 > 600) {
                h.c().b("[WARNING] SessionTimeout should be between 1 and 600. Default value[600] is used");
                i2 = 600;
            }
            this.f42369h = i2 * 1000;
        }
    }

    public SessionAnalysis(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42362a = false;
        this.f42363b = new HashMap();
        this.f42364c = new a();
        this.f42365d = new a();
        this.f42366e = false;
        this.f42367f = 0L;
        this.f42368g = new Session();
        this.f42369h = 0;
        this.f42370i = 0;
        this.j = 0L;
        this.k = true;
        this.mCallback = callback;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, context) == null) && this.f42368g.hasStart()) {
            String jSONObject = this.f42368g.constructJSONObject().toString();
            this.f42370i = jSONObject.getBytes().length;
            String k = w.k(context);
            o.a(context, k + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
