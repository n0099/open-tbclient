package c.q.a;

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
/* loaded from: classes9.dex */
public class y1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f31519b;

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
        this.f31519b = wDownLoadService;
        this.a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new v1(this));
            u0.f31466d.f31468c = false;
            y2 a = c3.a(this.f31519b.getApplicationContext());
            a.p(new g3(this.a), 2);
            a.m();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f31519b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_failed), this.f31519b.getString(m1.win_wdownload_failed_msg), 0);
            try {
                WDownLoadService.a(this.f31519b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f31519b.stopSelf();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            u0.f31466d.f31468c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f31519b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_processing), this.f31519b.getString(m1.win_wdownload_processing), i2);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u0.f31466d.f31468c = false;
            y2 a = c3.a(this.f31519b.getApplicationContext());
            a.p(new g3(this.a), 200);
            a.m();
            Info info = this.a;
            try {
                r0.o(info, 301, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downf_urls())) {
                    r0.K(info.getVv_downf_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            WDownLoadService.a(this.f31519b, this.a);
            this.f31519b.stopSelf();
            y2 a2 = c3.a(this.f31519b.getApplicationContext());
            g3 g3Var = new g3(this.a);
            String str = this.f31519b.a;
            try {
                a2.f31520b = c3.d("witr", g3Var);
                a2.l("msg", c3.b(str));
            } catch (JSONException unused) {
            }
            a2.m();
            r0.z(this.a, this.f31519b.getApplicationContext(), this.f31519b.a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u0.f31466d.f31468c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f31519b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(m1.win_wdownload_failed), this.f31519b.getString(m1.win_wdownload_failed_msg), 0);
            WDownLoadService.a(this.f31519b);
            this.f31519b.stopSelf();
            y2 a = c3.a(this.f31519b.getApplicationContext());
            a.p(new g3(this.a), 1);
            a.m();
        }
    }
}
