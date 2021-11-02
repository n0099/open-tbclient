package b.q.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class d4 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h4 f33291a;

    public d4(h4 h4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33291a = h4Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || (info = this.f33291a.f33338c) == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        h4 h4Var = this.f33291a;
        Context context = h4Var.f33336a;
        Info info2 = h4Var.f33338c;
        if (!r0.H(context)) {
            Toast.makeText(context, context.getString(m1.win_wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            y2 a2 = c3.a(context);
            a2.q(new g3(info2), 1);
            a2.m();
            return;
        }
        try {
            if (r0.B(context, info2.getOpen()) && r0.A(context, info2)) {
                y2 a3 = c3.a(context);
                g3 g3Var = new g3(info2);
                String open = info2.getOpen();
                try {
                    a3.f33579b = c3.d("wii", g3Var);
                    a3.l("msg", c3.b(open));
                } catch (JSONException unused) {
                }
                a3.m();
                r0.z(info2, context, r0.f(context, info2.getOpen()));
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (info2 != null) {
            try {
                if (TextUtils.isEmpty(info2.getOpen())) {
                    return;
                }
                m2.f(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                y2 a4 = c3.a(context);
                a4.q(new g3(info2), 2);
                a4.l("desc", e3.getMessage());
                a4.m();
            }
        }
    }
}
