package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ExceptionAnalysis {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ExceptionAnalysis f42955a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42956b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42957c;

    /* renamed from: d  reason: collision with root package name */
    public HeadObject f42958d;

    /* renamed from: e  reason: collision with root package name */
    public String f42959e;
    public Callback mCallback;

    /* loaded from: classes5.dex */
    public interface Callback {
        void onCallback(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(175523737, "Lcom/baidu/mobstat/ExceptionAnalysis;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(175523737, "Lcom/baidu/mobstat/ExceptionAnalysis;");
                return;
            }
        }
        f42955a = new ExceptionAnalysis();
    }

    public ExceptionAnalysis() {
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
        this.f42956b = false;
        this.f42958d = new HeadObject();
    }

    private JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_session", 0);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("failed_cnt", 0);
            } catch (Exception unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static ExceptionAnalysis getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f42955a : (ExceptionAnalysis) invokeV.objValue;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            if (context != null) {
                this.f42957c = context.getApplicationContext();
            }
            if (this.f42957c == null || this.f42956b) {
                return;
            }
            this.f42956b = true;
            ad.a().a(this.f42957c);
            if (z) {
                return;
            }
            NativeCrashHandler.init(this.f42957c);
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, th, z) == null) {
            if (context != null) {
                this.f42957c = context.getApplicationContext();
            }
            if (this.f42957c == null) {
                return;
            }
            String th2 = th.toString();
            String str = "";
            if (!TextUtils.isEmpty(th2)) {
                try {
                    String[] split = th2.split(":");
                    str = split.length > 1 ? split[0] : th2;
                } catch (Exception unused) {
                }
            }
            String str2 = TextUtils.isEmpty(str) ? th2 : str;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String obj = stringWriter.toString();
            if (z) {
                i2 = 0;
            } else if (th instanceof Exception) {
                i2 = 11;
            } else {
                i2 = th instanceof Error ? 12 : 13;
            }
            saveCrashInfo(this.f42957c, System.currentTimeMillis(), obj, str2, 0, i2);
        }
    }

    public void setCrashExtraInfo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        this.f42959e = str;
    }

    public ExceptionAnalysis(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42956b = false;
        this.f42958d = new HeadObject();
        this.mCallback = callback;
    }

    @SuppressLint({"NewApi"})
    private JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            JSONObject jSONObject = new JSONObject();
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put("total", memoryInfo.totalMem);
                }
                jSONObject.put("free", memoryInfo.availMem);
                jSONObject.put("low", memoryInfo.lowMemory ? 1 : 0);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void saveCrashInfo(Context context, long j2, String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            BDStatCore.instance().autoTrackSessionEndTime(context);
            if (context != null && str != null && !str.trim().equals("")) {
                try {
                    StringBuilder sb = new StringBuilder(str);
                    if (!TextUtils.isEmpty(this.f42959e)) {
                        sb.append(StringUtils.LF);
                        sb.append("ExtraInfo:");
                        sb.append(this.f42959e);
                    }
                    String appVersionName = CooperService.instance().getAppVersionName(context);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", j2);
                    jSONObject.put("c", sb.toString());
                    jSONObject.put("y", str2);
                    jSONObject.put("v", appVersionName);
                    jSONObject.put("ct", i2);
                    jSONObject.put("mem", a(context));
                    jSONObject.put("ty", i3);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    this.f42958d.installHeader(context, jSONObject2);
                    jSONObject2.put("ss", 0);
                    jSONObject2.put("sq", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("he", jSONObject2);
                    jSONObject3.put("pr", new JSONArray());
                    jSONObject3.put("ev", new JSONArray());
                    jSONObject3.put("ex", jSONArray);
                    jSONObject3.put("trace", a());
                    if (this.mCallback != null) {
                        this.mCallback.onCallback(jSONObject3);
                    }
                    bo.a(context, Config.PREFIX_SEND_DATA + System.currentTimeMillis(), jSONObject3.toString(), false);
                    bc.c().a("dump exception, exception: " + str);
                } catch (Exception unused) {
                }
            }
        }
    }
}
