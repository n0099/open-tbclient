package b.o.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f34410a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f34411b;

    public y1(WDownLoadService wDownLoadService, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wDownLoadService, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34411b = wDownLoadService;
        this.f34410a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new v1(this));
            u0.f34345d.f34348c = false;
            y2 a2 = c3.a(this.f34411b.getApplicationContext());
            a2.p(new g3(this.f34410a), 2);
            a2.m();
            Info info = this.f34410a;
            WDownLoadService wDownLoadService = this.f34411b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_failed), this.f34411b.getString(m1.win_wdownload_failed_msg), 0);
            try {
                WDownLoadService.a(this.f34411b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f34411b.stopSelf();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            u0.f34345d.f34348c = true;
            Info info = this.f34410a;
            WDownLoadService wDownLoadService = this.f34411b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_processing), this.f34411b.getString(m1.win_wdownload_processing), i2);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u0.f34345d.f34348c = false;
            y2 a2 = c3.a(this.f34411b.getApplicationContext());
            a2.p(new g3(this.f34410a), 200);
            a2.m();
            Info info = this.f34410a;
            try {
                r0.o(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    r0.K(info.getVv_downf_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            WDownLoadService.a(this.f34411b, this.f34410a);
            this.f34411b.stopSelf();
            y2 a3 = c3.a(this.f34411b.getApplicationContext());
            g3 g3Var = new g3(this.f34410a);
            String str = this.f34411b.f71426a;
            try {
                a3.f34413b = c3.d("witr", g3Var);
                a3.l("msg", c3.b(str));
            } catch (JSONException unused) {
            }
            a3.m();
            r0.z(this.f34410a, this.f34411b.getApplicationContext(), this.f34411b.f71426a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u0.f34345d.f34348c = false;
            Info info = this.f34410a;
            WDownLoadService wDownLoadService = this.f34411b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_failed), this.f34411b.getString(m1.win_wdownload_failed_msg), 0);
            WDownLoadService.a(this.f34411b);
            this.f34411b.stopSelf();
            y2 a2 = c3.a(this.f34411b.getApplicationContext());
            a2.p(new g3(this.f34410a), 1);
            a2.m();
        }
    }
}
