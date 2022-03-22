package c.m.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.downloader.WDownLoadService;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class y3 implements DownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ c4 a;

    public y3(c4 c4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c4Var;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Info info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || (info = this.a.f23416c) == null || info.getOpent() != 1 || j <= 10) {
            return;
        }
        c4 c4Var = this.a;
        Context context = c4Var.a;
        Info info2 = c4Var.f23416c;
        if (!r0.H(context)) {
            Toast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f1562) + info2.getDl_name(), 0).show();
            t2 a = x2.a(context);
            a.q(new b3(info2), 1);
            a.m();
            return;
        }
        try {
            if (r0.B(context, info2.getOpen()) && r0.A(context, info2)) {
                t2 a2 = x2.a(context);
                b3 b3Var = new b3(info2);
                String open = info2.getOpen();
                try {
                    a2.f23575b = x2.d("wii", b3Var);
                    a2.l("msg", x2.b(open));
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
                h2.f(context, info2.getDl_pkg(), info2);
                Intent intent = new Intent(context, WDownLoadService.class);
                intent.putExtra("down_load_apk_url", info2.getOpen());
                intent.putExtra("down_load_pkg_name", info2.getDl_pkg());
                context.startService(intent);
            } catch (Exception e3) {
                e3.printStackTrace();
                t2 a3 = x2.a(context);
                a3.q(new b3(info2), 2);
                a3.l("desc", e3.getMessage());
                a3.m();
            }
        }
    }
}
