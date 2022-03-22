package c.m.a;

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
    public final /* synthetic */ WDownLoadService f23574b;

    public t1(WDownLoadService wDownLoadService, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wDownLoadService, info};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23574b = wDownLoadService;
        this.a = info;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new q1(this));
            u0.f23588d.f23590c = false;
            t2 a = x2.a(this.f23574b.getApplicationContext());
            a.p(new b3(this.a), 2);
            a.m();
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f23574b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f155f), this.f23574b.getString(R.string.obfuscated_res_0x7f0f1560), 0);
            try {
                WDownLoadService.a(this.f23574b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f23574b.stopSelf();
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            u0.f23588d.f23590c = true;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f23574b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f1563), this.f23574b.getString(R.string.obfuscated_res_0x7f0f1563), i);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u0.f23588d.f23590c = false;
            t2 a = x2.a(this.f23574b.getApplicationContext());
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
            WDownLoadService.a(this.f23574b, this.a);
            this.f23574b.stopSelf();
            t2 a2 = x2.a(this.f23574b.getApplicationContext());
            b3 b3Var = new b3(this.a);
            String str = this.f23574b.a;
            try {
                a2.f23575b = x2.d("witr", b3Var);
                a2.l("msg", x2.b(str));
            } catch (JSONException unused) {
            }
            a2.m();
            r0.z(this.a, this.f23574b.getApplicationContext(), this.f23574b.a);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u0.f23588d.f23590c = false;
            Info info = this.a;
            WDownLoadService wDownLoadService = this.f23574b;
            wDownLoadService.a(info, info != null ? info.getDl_name() : wDownLoadService.getString(R.string.obfuscated_res_0x7f0f155f), this.f23574b.getString(R.string.obfuscated_res_0x7f0f1560), 0);
            WDownLoadService.a(this.f23574b);
            this.f23574b.stopSelf();
            t2 a = x2.a(this.f23574b.getApplicationContext());
            a.p(new b3(this.a), 1);
            a.m();
        }
    }
}
