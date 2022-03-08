package c.q.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Info a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WDownLoadService f29125b;

    public t1(WDownLoadService wDownLoadService, Info info) {
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
        this.f29125b = wDownLoadService;
        this.a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new q1(this));
            u0.f29141d.f29143c = false;
            t2 a = x2.a(this.f29125b.getApplicationContext());
            a.p(new b3(this.a), 2);
            a.m();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f29125b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f29125b.getString(R.string.win_wdownload_failed_msg), 0);
            try {
                WDownLoadService.a(this.f29125b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f29125b.stopSelf();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            u0.f29141d.f29143c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f29125b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_processing), this.f29125b.getString(R.string.win_wdownload_processing), i2);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u0.f29141d.f29143c = false;
            t2 a = x2.a(this.f29125b.getApplicationContext());
            a.p(new b3(this.a), 200);
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
            WDownLoadService.a(this.f29125b, this.a);
            this.f29125b.stopSelf();
            t2 a2 = x2.a(this.f29125b.getApplicationContext());
            b3 b3Var = new b3(this.a);
            String str = this.f29125b.a;
            try {
                a2.f29126b = x2.d("witr", b3Var);
                a2.l("msg", x2.b(str));
            } catch (JSONException unused) {
            }
            a2.m();
            r0.z(this.a, this.f29125b.getApplicationContext(), this.f29125b.a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u0.f29141d.f29143c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f29125b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.win_wdownload_failed), this.f29125b.getString(R.string.win_wdownload_failed_msg), 0);
            WDownLoadService.a(this.f29125b);
            this.f29125b.stopSelf();
            t2 a = x2.a(this.f29125b.getApplicationContext());
            a.p(new b3(this.a), 1);
            a.m();
        }
    }
}
