package b.a.k.b.b.b;

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

    /* renamed from: a  reason: collision with root package name */
    public b f3246a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f3247b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f3248c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3249d;

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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f3248c == null) {
            return;
        }
        SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f3248c.toString());
        this.f3248c = null;
    }

    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            try {
                if (this.f3247b == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f3247b = jSONObject;
                    jSONObject.put("type", MonitorType.MONITOR_TYPE_INIT_WEBKIT);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f3247b.put(str, str2);
            } catch (Exception unused) {
                Log.e("staticWebkitInit JSON error");
            }
        }
    }

    public final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            try {
                if (this.f3248c == null) {
                    JSONObject jSONObject = new JSONObject();
                    this.f3248c = jSONObject;
                    jSONObject.put("type", MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT);
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f3248c.put(str, str2);
            } catch (Exception unused) {
                Log.e("mWebkitDownloadStatics JSON error");
            }
        }
    }
}
