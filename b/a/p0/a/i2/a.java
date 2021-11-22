package b.a.p0.a.i2;

import android.annotation.SuppressLint;
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
import b.a.p0.a.f1.e.c;
import b.a.p0.a.h;
import b.a.p0.a.h0.m.u.c;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.p.d.p;
import b.a.p0.a.z2.a0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.t;
import b.a.p0.a.z2.u;
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
    public static final boolean f6513a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0281a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f6514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f6515b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f6516c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f6517d;

        public C0281a(b.a.p0.a.f1.e.b bVar, c.a aVar, int i2, f fVar) {
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
            this.f6514a = bVar;
            this.f6515b = aVar;
            this.f6516c = i2;
            this.f6517d = fVar;
        }

        @Override // b.a.p0.a.h0.m.u.c.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || b.a.p0.a.d2.e.L() == null) {
                return;
            }
            SwanAppActivity x = b.a.p0.a.d2.d.J().x();
            a.q(x, this.f6514a, this.f6515b, bitmap, this.f6516c);
            a.r(x, this.f6514a, this.f6517d);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f6518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f6519f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6520g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f6521h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bitmap f6522i;
        public final /* synthetic */ b.a.p0.a.f1.e.c j;

        public b(b.a.p0.a.f1.e.b bVar, Context context, int i2, b.a.p0.a.f1.e.b bVar2, Bitmap bitmap, b.a.p0.a.f1.e.c cVar) {
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
            this.f6518e = bVar;
            this.f6519f = context;
            this.f6520g = i2;
            this.f6521h = bVar2;
            this.f6522i = bitmap;
            this.j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p X = b.a.p0.a.c1.a.X();
                String q1 = this.f6518e.q1();
                if (!TextUtils.isEmpty(q1) && X.b(this.f6519f, q1)) {
                    a.n(PrefetchEvent.STATE_CLICK);
                    if (X.a(this.f6519f, q1)) {
                        if (this.f6520g != 1) {
                            a.u(this.f6519f);
                            return;
                        }
                        return;
                    } else if (X.c(this.f6519f, q1)) {
                        a.n("show");
                        if (this.f6520g != 1) {
                            a.u(this.f6519f);
                            return;
                        }
                        return;
                    }
                }
                if (b.a.p0.a.z2.d.j()) {
                    a.t(this.f6519f, this.f6521h.H(), this.f6521h.K(), this.f6522i, b.a.p0.a.f1.e.c.g1(this.f6519f, this.j));
                } else {
                    try {
                        this.f6519f.sendBroadcast(a.m(this.f6521h.K(), this.f6522i, b.a.p0.a.f1.e.c.g1(this.f6519f, this.j)));
                    } catch (Throwable th) {
                        if (a.f6513a) {
                            th.printStackTrace();
                        }
                        try {
                            this.f6519f.sendBroadcast(a.m(this.f6521h.K(), u.a(this.f6522i, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), b.a.p0.a.f1.e.c.g1(this.f6519f, this.j)));
                        } catch (Throwable th2) {
                            if (a.f6513a) {
                                th2.printStackTrace();
                            }
                            b.a.p0.a.c2.b.f.e.f(this.f6519f, h.aiapps_shortcut_add_failure).G();
                        }
                    }
                }
                if (this.f6520g != 1) {
                    a.u(this.f6519f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6523e;

        /* renamed from: b.a.p0.a.i2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0282a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0282a(c cVar) {
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
            this.f6523e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6523e);
                aVar.n(new b.a.p0.a.a3.h.a());
                SwanAppAlertDialog c2 = aVar.c();
                aVar.U(h.aiapps_add_shortcut_note_dialog_title);
                aVar.w(a.p(this.f6523e, c2));
                aVar.y();
                aVar.H(h.aiapps_confirm_text, new DialogInterface$OnClickListenerC0282a(this));
                aVar.J(b.a.p0.a.c1.a.M().a());
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
        public final /* synthetic */ SwanAppAlertDialog f6524e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f6525f;

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
            this.f6524e = swanAppAlertDialog;
            this.f6525f = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6524e.dismiss();
                a0.g(this.f6525f);
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
        public final /* synthetic */ f f6526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f6527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f6528g;

        public e(f fVar, Context context, b.a.p0.a.f1.e.b bVar) {
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
            this.f6526e = fVar;
            this.f6527f = context;
            this.f6528g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6526e.a(a.s(this.f6527f, this.f6528g.K(), this.f6528g.H()));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1325548714, "Lb/a/p0/a/i2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1325548714, "Lb/a/p0/a/i2/a;");
                return;
            }
        }
        f6513a = k.f6863a;
    }

    public static void i(Context context, b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, bVar) == null) {
            k(context, bVar, null);
        }
    }

    public static void j(Context context, b.a.p0.a.f1.e.b bVar, int i2, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, bVar, i2, fVar) == null) {
            String Q = bVar.Q();
            if (TextUtils.isEmpty(Q) || (C = q0.C(Q)) == null) {
                return;
            }
            l(bVar);
            c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(bVar.H())).I0(bVar.T())).P0(bVar.c0())).R0(bVar.e0())).y0(bVar.L())).A0(bVar.n0())).L0(bVar.p0())).a1(bVar.k0())).u0(bVar.G())).Q0(bVar.d0())).K0(b.a.p0.a.f1.e.c.h1(bVar.H(), bVar.T(), bVar.G()));
            if (t.d(C)) {
                q(context, bVar, aVar, t.c(C, context), i2);
                r(context, bVar, fVar);
                return;
            }
            b.a.p0.a.h0.m.u.c.c(Q, aVar.G(), new C0281a(bVar, aVar, i2, fVar));
        }
    }

    public static void k(Context context, b.a.p0.a.f1.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, bVar, fVar) == null) {
            j(context, bVar, 0, fVar);
        }
    }

    public static void l(b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            bVar.R0(null);
            bVar.I0("1230000000000000");
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
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            eVar.f7384f = b.a.p0.a.d2.d.J().getAppId();
            eVar.f7380b = str;
            eVar.f7379a = n.n(b.a.p0.a.d2.d.J().l());
            if (b.a.p0.a.d2.e.a0() != null && b.a.p0.a.d2.e.a0().V() != null) {
                eVar.f7381c = b.a.p0.a.d2.e.a0().V().T();
            }
            n.x("1591", eVar);
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
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(b.a.p0.a.c.aiapps_go_permission_color)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, b.a.p0.a.f1.e.b bVar, b.a.p0.a.f1.e.c cVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, bVar, cVar, bitmap, Integer.valueOf(i2)}) == null) || context == null) {
            return;
        }
        if (bitmap == null) {
            b.a.p0.a.c2.b.f.e.f(context, h.swanapp_tip_net_unavailable).G();
        } else if (b.a.p0.a.d2.e.a0() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(b.a.p0.a.d2.e.a0().V(), context, i2, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, b.a.p0.a.f1.e.b bVar, f fVar) {
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
                if (f6513a) {
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
                    if (f6513a) {
                        throw e2;
                    }
                    return;
                }
            }
            b.a.p0.a.c2.b.f.e.f(context, h.aiapps_shortcut_not_supported_text).G();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (f6513a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
                return;
            }
            q0.a0(new c(context));
        }
    }
}
