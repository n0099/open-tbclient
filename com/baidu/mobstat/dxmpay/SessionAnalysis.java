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
/* loaded from: classes8.dex */
public class SessionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f37423b;

    /* renamed from: c  reason: collision with root package name */
    public a f37424c;

    /* renamed from: d  reason: collision with root package name */
    public a f37425d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37426e;

    /* renamed from: f  reason: collision with root package name */
    public long f37427f;

    /* renamed from: g  reason: collision with root package name */
    public Session f37428g;

    /* renamed from: h  reason: collision with root package name */
    public int f37429h;

    /* renamed from: i  reason: collision with root package name */
    public int f37430i;

    /* renamed from: j  reason: collision with root package name */
    public long f37431j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f37432k;
    public LaunchInfo l;
    public LaunchInfo m;
    public Callback mCallback;

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

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
            this.a = false;
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
        this.a = false;
        this.f37423b = new HashMap();
        this.f37424c = new a();
        this.f37425d = new a();
        this.f37426e = false;
        this.f37427f = 0L;
        this.f37428g = new Session();
        this.f37429h = 0;
        this.f37430i = 0;
        this.f37431j = 0L;
        this.f37432k = true;
    }

    private void a(Context context, long j2, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            if (this.f37428g.hasEnd()) {
                DataCore.instance().putSession(this.f37428g);
                DataCore.instance().flush(context);
                d.a(this.f37428g.getPageSessionHead());
                this.f37428g.setEndTime(0L);
            }
            boolean z3 = j2 > 0;
            long startTime = z3 ? j2 : this.f37428g.getStartTime();
            if (z3) {
                this.f37428g.reset();
                this.f37428g.setStartTime(j2);
            }
            DataCore.instance().saveLogData(context, z3, z, startTime, z2, null);
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onCallback(DataCore.instance().getLogData());
            }
            if (z3 || this.f37432k) {
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

    public void autoTrackSessionEndTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j2) == null) || context == null) {
            return;
        }
        this.f37428g.setTrackEndTime(j2);
        a(context);
    }

    public void autoTrackSessionStartTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j2) == null) || context == null) {
            return;
        }
        this.f37428g.setTrackStartTime(j2);
        this.f37431j = j2;
    }

    public void clearLastSessionCache(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || context == null) {
            return;
        }
        String jSONObject = new JSONObject().toString();
        String k2 = w.k(context);
        o.a(context, k2 + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
    }

    public void doSendLogCheck(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j2) == null) {
            long j3 = this.f37427f;
            if (j3 <= 0 || j2 - j3 <= getSessionTimeOut()) {
                return;
            }
            a(context, -1L, false, false, 0);
        }
    }

    public JSONObject getPageSessionHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37428g.getPageSessionHead() : (JSONObject) invokeV.objValue;
    }

    public int getSessionSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37430i : invokeV.intValue;
    }

    public long getSessionStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37428g.getStartTime() : invokeV.longValue;
    }

    public int getSessionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f37429h <= 0) {
                this.f37429h = 30000;
            }
            return this.f37429h;
        }
        return invokeV.intValue;
    }

    public boolean isSessionStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37428g.getStartTime() > 0 : invokeV.booleanValue;
    }

    public void onPageEnd(Context context, String str, String str2, String str3, long j2, ExtraInfo extraInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, str2, str3, Long.valueOf(j2), extraInfo, Boolean.valueOf(z)}) == null) {
        }
    }

    public void onPageEndAct(Context context, String str, String str2, String str3, long j2, boolean z, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, str3, Long.valueOf(j2), Boolean.valueOf(z), extraInfo}) == null) {
        }
    }

    public void onPageEndFrag(Context context, String str, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, str3, Long.valueOf(j2)}) == null) {
        }
    }

    public void onPageStart(Context context, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    public void onPageStartAct(Context context, String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
        }
    }

    public void onPageStartFrag(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, str, Long.valueOf(j2)}) == null) {
        }
    }

    public void onSessionStart(Context context, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z)}) == null) || this.a) {
            return;
        }
        DataCore.instance().init(context);
        LaunchInfo launchInfo = this.l;
        a(context, j2, z, true, launchInfo != null ? launchInfo.getLaunchType(context) : 0);
        this.a = true;
    }

    public void setAutoSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f37432k = z;
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
            this.f37429h = i2 * 1000;
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
        this.a = false;
        this.f37423b = new HashMap();
        this.f37424c = new a();
        this.f37425d = new a();
        this.f37426e = false;
        this.f37427f = 0L;
        this.f37428g = new Session();
        this.f37429h = 0;
        this.f37430i = 0;
        this.f37431j = 0L;
        this.f37432k = true;
        this.mCallback = callback;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, context) == null) && this.f37428g.hasStart()) {
            String jSONObject = this.f37428g.constructJSONObject().toString();
            this.f37430i = jSONObject.getBytes().length;
            String k2 = w.k(context);
            o.a(context, k2 + Config.LAST_SESSION_FILE_NAME, jSONObject, false);
        }
    }
}
