package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExceptionAnalysis {
    public static /* synthetic */ Interceptable $ic;
    public static ExceptionAnalysis a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public Context c;
    public HeadObject d;
    public String e;
    public Callback mCallback;

    /* loaded from: classes2.dex */
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
        a = new ExceptionAnalysis();
    }

    public ExceptionAnalysis() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = new HeadObject();
    }

    private JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.TRACE_APPLICATION_SESSION, 0);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put(Config.TRACE_FAILED_CNT, 0);
            } catch (Exception unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static ExceptionAnalysis getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a : (ExceptionAnalysis) invokeV.objValue;
    }

    public void openExceptionAnalysis(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            if (context != null) {
                this.c = context.getApplicationContext();
            }
            if (this.c == null || this.b) {
                return;
            }
            this.b = true;
            ad.a().a(this.c);
            if (z) {
                return;
            }
            NativeCrashHandler.init(this.c);
        }
    }

    public void saveCrashInfo(Context context, Throwable th, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, th, z) == null) {
            if (context != null) {
                this.c = context.getApplicationContext();
            }
            if (this.c == null) {
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
                i = 0;
            } else if (th instanceof Exception) {
                i = 11;
            } else {
                i = th instanceof Error ? 12 : 13;
            }
            saveCrashInfo(this.c, System.currentTimeMillis(), obj, str2, 0, i);
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
        this.e = str;
    }

    public ExceptionAnalysis(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = new HeadObject();
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
                jSONObject.put(Config.EXCEPTION_MEMORY_LOW, memoryInfo.lowMemory ? 1 : 0);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void saveCrashInfo(Context context, long j, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            BDStatCore.instance().autoTrackSessionEndTime(context);
            if (context != null && str != null && !str.trim().equals("")) {
                try {
                    StringBuilder sb = new StringBuilder(str);
                    if (!TextUtils.isEmpty(this.e)) {
                        sb.append("\n");
                        sb.append("ExtraInfo:");
                        sb.append(this.e);
                    }
                    String appVersionName = CooperService.instance().getAppVersionName(context);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", j);
                    jSONObject.put("c", sb.toString());
                    jSONObject.put("y", str2);
                    jSONObject.put("v", appVersionName);
                    jSONObject.put(Config.EXCEPTION_CRASH_TYPE, i);
                    jSONObject.put("mem", a(context));
                    jSONObject.put(Config.EXCEPTION_CRASH_CHANNEL, i2);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    this.d.installHeader(context, jSONObject2);
                    jSONObject2.put("ss", 0);
                    jSONObject2.put(Config.SEQUENCE_INDEX, 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.HEADER_PART, jSONObject2);
                    jSONObject3.put("pr", new JSONArray());
                    jSONObject3.put(Config.EVENT_PART, new JSONArray());
                    jSONObject3.put(Config.EXCEPTION_PART, jSONArray);
                    jSONObject3.put(Config.TRACE_PART, a());
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
