package c.q.a;

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
/* loaded from: classes9.dex */
public class d4 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ h4 a;

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
        this.a = h4Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) || (info = this.a.f30364c) == null || info.getOpent() != 1 || j2 <= 10) {
            return;
        }
        h4 h4Var = this.a;
        Context context = h4Var.a;
        Info info2 = h4Var.f30364c;
        if (!r0.H(context)) {
            Toast.makeText(context, context.getString(m1.win_wdownload_no_netwrok) + info2.getDl_name(), 0).show();
            y2 a = c3.a(context);
            a.q(new g3(info2), 1);
            a.m();
            return;
        }
        try {
            if (r0.B(context, info2.getOpen()) && r0.A(context, info2)) {
                y2 a2 = c3.a(context);
                g3 g3Var = new g3(info2);
                String open = info2.getOpen();
                try {
                    a2.f30557b = c3.d("wii", g3Var);
                    a2.l("msg", c3.b(open));
                } catch (JSONException unused) {
                }
                a2.m();
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
                y2 a3 = c3.a(context);
                a3.q(new g3(info2), 2);
                a3.l("desc", e3.getMessage());
                a3.m();
            }
        }
    }
}
