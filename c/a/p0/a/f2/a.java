package c.a.p0.a.f2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.pm.ShortcutManagerCompat;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.h;
import c.a.p0.a.h0.m.r.c;
import c.a.p0.a.k;
import c.a.p0.a.p.d.p;
import c.a.p0.a.v2.a0;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.t;
import c.a.p0.a.v2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5728a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0190a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5729a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f5730b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5731c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f5732d;

        public C0190a(c.a.p0.a.f1.e.b bVar, c.a aVar, int i2, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i2), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5729a = bVar;
            this.f5730b = aVar;
            this.f5731c = i2;
            this.f5732d = fVar;
        }

        @Override // c.a.p0.a.h0.m.r.c.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || c.a.p0.a.a2.e.i() == null) {
                return;
            }
            SwanAppActivity x = c.a.p0.a.a2.d.g().x();
            a.q(x, this.f5729a, this.f5730b, bitmap, this.f5731c);
            a.r(x, this.f5729a, this.f5732d);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5733e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5734f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5735g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5736h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bitmap f5737i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.c f5738j;

        public b(c.a.p0.a.f1.e.b bVar, Context context, int i2, c.a.p0.a.f1.e.b bVar2, Bitmap bitmap, c.a.p0.a.f1.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Integer.valueOf(i2), bVar2, bitmap, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5733e = bVar;
            this.f5734f = context;
            this.f5735g = i2;
            this.f5736h = bVar2;
            this.f5737i = bitmap;
            this.f5738j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p S = c.a.p0.a.c1.a.S();
                String o1 = this.f5733e.o1();
                if (!TextUtils.isEmpty(o1) && S.b(this.f5734f, o1)) {
                    a.n(PrefetchEvent.STATE_CLICK);
                    if (S.a(this.f5734f, o1)) {
                        if (this.f5735g != 1) {
                            a.u(this.f5734f);
                            return;
                        }
                        return;
                    } else if (S.c(this.f5734f, o1)) {
                        a.n("show");
                        if (this.f5735g != 1) {
                            a.u(this.f5734f);
                            return;
                        }
                        return;
                    }
                }
                if (c.a.p0.a.v2.d.j()) {
                    a.t(this.f5734f, this.f5736h.H(), this.f5736h.K(), this.f5737i, c.a.p0.a.f1.e.c.d1(this.f5734f, this.f5738j));
                } else {
                    try {
                        this.f5734f.sendBroadcast(a.m(this.f5736h.K(), this.f5737i, c.a.p0.a.f1.e.c.d1(this.f5734f, this.f5738j)));
                    } catch (Throwable th) {
                        if (a.f5728a) {
                            th.printStackTrace();
                        }
                        try {
                            this.f5734f.sendBroadcast(a.m(this.f5736h.K(), u.a(this.f5737i, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), c.a.p0.a.f1.e.c.d1(this.f5734f, this.f5738j)));
                        } catch (Throwable th2) {
                            if (a.f5728a) {
                                th2.printStackTrace();
                            }
                            c.a.p0.a.z1.b.f.e.f(this.f5734f, h.aiapps_shortcut_add_failure).F();
                        }
                    }
                }
                if (this.f5735g != 1) {
                    a.u(this.f5734f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5739e;

        /* renamed from: c.a.p0.a.f2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0191a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0191a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5739e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5739e);
                aVar.n(new c.a.p0.a.w2.h.a());
                SwanAppAlertDialog c2 = aVar.c();
                aVar.U(h.aiapps_add_shortcut_note_dialog_title);
                aVar.w(a.p(this.f5739e, c2));
                aVar.y();
                aVar.H(h.aiapps_confirm_text, new DialogInterface$OnClickListenerC0191a(this));
                aVar.J(c.a.p0.a.c1.a.H().a());
                aVar.a();
                c2.setCancelable(false);
                c2.show();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f5740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5741f;

        public d(SwanAppAlertDialog swanAppAlertDialog, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlertDialog, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5740e = swanAppAlertDialog;
            this.f5741f = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5740e.dismiss();
                a0.g(this.f5741f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5743f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5744g;

        public e(f fVar, Context context, c.a.p0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5742e = fVar;
            this.f5743f = context;
            this.f5744g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5742e.a(a.s(this.f5743f, this.f5744g.K(), this.f5744g.H()));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817219526, "Lc/a/p0/a/f2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(817219526, "Lc/a/p0/a/f2/a;");
                return;
            }
        }
        f5728a = k.f7085a;
    }

    public static void i(Context context, c.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, bVar) == null) {
            k(context, bVar, null);
        }
    }

    public static void j(Context context, c.a.p0.a.f1.e.b bVar, int i2, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, bVar, i2, fVar) == null) {
            String Q = bVar.Q();
            if (TextUtils.isEmpty(Q) || (C = q0.C(Q)) == null) {
                return;
            }
            l(bVar);
            c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(bVar.H())).H0(bVar.T())).O0(bVar.c0())).Q0(bVar.e0())).x0(bVar.L())).z0(bVar.m0())).K0(bVar.o0())).Y0(bVar.j0())).t0(bVar.G())).P0(bVar.d0())).J0(c.a.p0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G()));
            if (t.d(C)) {
                q(context, bVar, aVar, t.c(C, context), i2);
                r(context, bVar, fVar);
                return;
            }
            c.a.p0.a.h0.m.r.c.c(Q, aVar.G(), new C0190a(bVar, aVar, i2, fVar));
        }
    }

    public static void k(Context context, c.a.p0.a.f1.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, bVar, fVar) == null) {
            j(context, bVar, 0, fVar);
        }
    }

    public static void l(c.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            bVar.Q0(null);
            bVar.H0("1230000000000000");
        }
    }

    public static Intent m(String str, Bitmap bitmap, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, bitmap, intent)) == null) {
            Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent2.putExtra("duplicate", false);
            return intent2;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            c.a.p0.a.j2.p.e eVar = new c.a.p0.a.j2.p.e();
            eVar.f7076f = c.a.p0.a.a2.d.g().getAppId();
            eVar.f7072b = str;
            eVar.f7071a = c.a.p0.a.j2.k.m(c.a.p0.a.a2.d.g().l());
            if (c.a.p0.a.a2.e.Q() != null && c.a.p0.a.a2.e.Q().L() != null) {
                eVar.f7073c = c.a.p0.a.a2.e.Q().L().T();
            }
            c.a.p0.a.j2.k.u("1591", eVar);
        }
    }

    @NonNull
    public static String o(Context context) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null && !"android".equals(activityInfo.packageName)) {
                PackageManager packageManager = context.getPackageManager();
                ActivityInfo activityInfo2 = resolveActivity.activityInfo;
                List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(activityInfo2.processName, activityInfo2.applicationInfo.uid, 65536);
                if (queryContentProviders == null) {
                    return "com.android.launcher3.settings";
                }
                for (ProviderInfo providerInfo : queryContentProviders) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && !TextUtils.isEmpty(providerInfo.readPermission) && Pattern.matches(".*launcher.*permission\\.READ_SETTINGS", providerInfo.readPermission)) {
                        for (String str : providerInfo.authority.split(";")) {
                            if (str != null && str.endsWith(".settings")) {
                                return str;
                            }
                        }
                        continue;
                    }
                }
            }
            return "com.android.launcher3.settings";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableStringBuilder p(Context context, SwanAppAlertDialog swanAppAlertDialog) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, swanAppAlertDialog)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(h.aiapps_add_shortcut_note_dialog_content);
            String string2 = context.getString(h.aiapps_add_shortcut_permission_setting);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(swanAppAlertDialog, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(c.a.p0.a.c.aiapps_go_permission_color)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, c.a.p0.a.f1.e.b bVar, c.a.p0.a.f1.e.c cVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, bVar, cVar, bitmap, Integer.valueOf(i2)}) == null) || context == null) {
            return;
        }
        if (bitmap == null) {
            c.a.p0.a.z1.b.f.e.f(context, h.swanapp_tip_net_unavailable).F();
        } else if (c.a.p0.a.a2.e.Q() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(c.a.p0.a.a2.e.Q().L(), context, i2, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, c.a.p0.a.f1.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, context, bVar, fVar) == null) || fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            q.d(new e(fVar, context, bVar), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static int s(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", o(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
                while (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("intent"));
                    if (string != null && string.contains(str2)) {
                        if (query != null) {
                            query.close();
                        }
                        return 1;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return 0;
            } catch (Exception e2) {
                if (f5728a) {
                    String str3 = "fail: " + e2;
                    return -1;
                }
                return -1;
            }
        }
        return invokeLLL.intValue;
    }

    @TargetApi(26)
    public static void t(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65556, null, context, str, str2, bitmap, intent) == null) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
                try {
                    shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                    return;
                } catch (IllegalStateException e2) {
                    if (f5728a) {
                        throw e2;
                    }
                    return;
                }
            }
            c.a.p0.a.z1.b.f.e.f(context, h.aiapps_shortcut_not_supported_text).F();
        }
    }

    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (f5728a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
                return;
            }
            q0.X(new c(context));
        }
    }
}
