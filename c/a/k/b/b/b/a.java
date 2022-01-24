package c.a.k.b.b.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f4254b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f4255c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4256d;

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
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4255c == null) {
            return;
        }
        SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f4255c.toString());
        this.f4255c = null;
    }

    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            try {
                if (this.f4254b == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f4254b = jSONObject;
                    jSONObject.put("type", MonitorType.MONITOR_TYPE_INIT_WEBKIT);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4254b.put(str, str2);
            } catch (Exception unused) {
                Log.e("staticWebkitInit JSON error");
            }
        }
    }

    public final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            try {
                if (this.f4255c == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f4255c = jSONObject;
                    jSONObject.put("type", MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f4255c.put(str, str2);
            } catch (Exception unused) {
                Log.e("mWebkitDownloadStatics JSON error");
            }
        }
    }
}
