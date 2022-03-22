package c.a.n0.a.y1;

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
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.pm.ShortcutManagerCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.f.d.p;
import c.a.n0.a.p2.a0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.t;
import c.a.n0.a.p2.u;
import c.a.n0.a.s1.b.b.h;
import c.a.n0.a.v0.e.c;
import c.a.n0.a.x.m.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
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
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0596a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f7733b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f7734c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f7735d;

        public C0596a(c.a.n0.a.v0.e.b bVar, c.a aVar, int i, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f7733b = aVar;
            this.f7734c = i;
            this.f7735d = fVar;
        }

        @Override // c.a.n0.a.x.m.u.c.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || c.a.n0.a.t1.e.L() == null) {
                return;
            }
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
            a.q(x, this.a, this.f7733b, bitmap, this.f7734c);
            a.r(x, this.a, this.f7735d);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f7736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f7737c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f7738d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7739e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.c f7740f;

        public b(c.a.n0.a.v0.e.b bVar, Context context, int i, c.a.n0.a.v0.e.b bVar2, Bitmap bitmap, c.a.n0.a.v0.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Integer.valueOf(i), bVar2, bitmap, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f7736b = context;
            this.f7737c = i;
            this.f7738d = bVar2;
            this.f7739e = bitmap;
            this.f7740f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p X = c.a.n0.a.s0.a.X();
                String q1 = this.a.q1();
                if (!TextUtils.isEmpty(q1) && X.b(this.f7736b, q1)) {
                    a.n("click");
                    if (X.a(this.f7736b, q1)) {
                        if (this.f7737c != 1) {
                            a.u(this.f7736b);
                            return;
                        }
                        return;
                    } else if (X.c(this.f7736b, q1)) {
                        a.n("show");
                        if (this.f7737c != 1) {
                            a.u(this.f7736b);
                            return;
                        }
                        return;
                    }
                }
                if (c.a.n0.a.p2.d.j()) {
                    a.t(this.f7736b, this.f7738d.H(), this.f7738d.K(), this.f7739e, c.a.n0.a.v0.e.c.g1(this.f7736b, this.f7740f));
                } else {
                    try {
                        this.f7736b.sendBroadcast(a.m(this.f7738d.K(), this.f7739e, c.a.n0.a.v0.e.c.g1(this.f7736b, this.f7740f)));
                    } catch (Throwable th) {
                        if (a.a) {
                            th.printStackTrace();
                        }
                        try {
                            this.f7736b.sendBroadcast(a.m(this.f7738d.K(), u.a(this.f7739e, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), c.a.n0.a.v0.e.c.g1(this.f7736b, this.f7740f)));
                        } catch (Throwable th2) {
                            if (a.a) {
                                th2.printStackTrace();
                            }
                            c.a.n0.a.s1.b.f.e.f(this.f7736b, R.string.obfuscated_res_0x7f0f01bd).G();
                        }
                    }
                }
                if (this.f7737c != 1) {
                    a.u(this.f7736b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: c.a.n0.a.y1.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0597a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0597a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a aVar = new h.a(this.a);
                aVar.n(new c.a.n0.a.q2.h.a());
                h c2 = aVar.c();
                aVar.U(R.string.obfuscated_res_0x7f0f00f9);
                aVar.w(a.p(this.a, c2));
                aVar.y();
                aVar.H(R.string.obfuscated_res_0x7f0f0111, new DialogInterface$OnClickListenerC0597a(this));
                aVar.J(c.a.n0.a.s0.a.M().a());
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
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f7741b;

        public d(h hVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.f7741b = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
                a0.g(this.f7741b);
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
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f7742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f7743c;

        public e(f fVar, Context context, c.a.n0.a.v0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f7742b = context;
            this.f7743c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(a.s(this.f7742b, this.f7743c.K(), this.f7743c.H()));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1227763644, "Lc/a/n0/a/y1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1227763644, "Lc/a/n0/a/y1/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void i(Context context, c.a.n0.a.v0.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, bVar) == null) {
            k(context, bVar, null);
        }
    }

    public static void j(Context context, c.a.n0.a.v0.e.b bVar, int i, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, bVar, i, fVar) == null) {
            String Q = bVar.Q();
            if (TextUtils.isEmpty(Q) || (C = q0.C(Q)) == null) {
                return;
            }
            l(bVar);
            c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().v0(bVar.H())).I0(bVar.T())).P0(bVar.c0())).R0(bVar.e0())).y0(bVar.L())).A0(bVar.n0())).L0(bVar.p0())).a1(bVar.k0())).u0(bVar.G())).Q0(bVar.d0())).K0(c.a.n0.a.v0.e.c.h1(bVar.H(), bVar.T(), bVar.G()));
            if (t.d(C)) {
                q(context, bVar, aVar, t.c(C, context), i);
                r(context, bVar, fVar);
                return;
            }
            c.a.n0.a.x.m.u.c.c(Q, aVar.G(), new C0596a(bVar, aVar, i, fVar));
        }
    }

    public static void k(Context context, c.a.n0.a.v0.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, bVar, fVar) == null) {
            j(context, bVar, 0, fVar);
        }
    }

    public static void l(c.a.n0.a.v0.e.b bVar) {
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
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            eVar.f4192f = c.a.n0.a.t1.d.J().getAppId();
            eVar.f4188b = str;
            eVar.a = n.n(c.a.n0.a.t1.d.J().l());
            if (c.a.n0.a.t1.e.a0() != null && c.a.n0.a.t1.e.a0().V() != null) {
                eVar.f4189c = c.a.n0.a.t1.e.a0().V().T();
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

    public static SpannableStringBuilder p(Context context, h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, hVar)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(R.string.obfuscated_res_0x7f0f00f8);
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f00fa);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(hVar, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.obfuscated_res_0x7f0603ac)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, c.a.n0.a.v0.e.b bVar, c.a.n0.a.v0.e.c cVar, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, bVar, cVar, bitmap, Integer.valueOf(i)}) == null) || context == null) {
            return;
        }
        if (bitmap == null) {
            c.a.n0.a.s1.b.f.e.f(context, R.string.obfuscated_res_0x7f0f12dd).G();
        } else if (c.a.n0.a.t1.e.a0() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(c.a.n0.a.t1.e.a0().V(), context, i, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, c.a.n0.a.v0.e.b bVar, f fVar) {
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
                if (a) {
                    Log.d("SwanAppShortcutHelper", "fail: " + e2);
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
                    if (a) {
                        throw e2;
                    }
                    return;
                }
            }
            c.a.n0.a.s1.b.f.e.f(context, R.string.obfuscated_res_0x7f0f01be).G();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
                return;
            }
            q0.a0(new c(context));
        }
    }
}
