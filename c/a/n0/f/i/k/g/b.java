package c.a.n0.f.i.k.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.f.i.c;
import c.a.n0.f.i.g;
import c.a.n0.f.i.k.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10330a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f10331b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.f.i.k.g.a f10332c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.f.i.k.f.a f10333d;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10334e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10334e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || c.a.n0.f.i.m.a.b() == null) {
                return;
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.NOT_START || this.f10334e.f10332c.f10327a == DownloadState.DELETED) {
                c.a.n0.f.i.m.a.b().b(this.f10334e.f10330a, ((DownloadParams) this.f10334e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10334e.f10333d);
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.DOWNLOADING) {
                c.a.n0.f.i.m.a.b().b(this.f10334e.f10330a, ((DownloadParams) this.f10334e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f10334e.f10333d);
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.DOWNLOAD_PAUSED) {
                c.a.n0.f.i.m.a.b().b(this.f10334e.f10330a, ((DownloadParams) this.f10334e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10334e.f10333d);
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.DOWNLOAD_FAILED) {
                c.a.n0.f.i.m.a.b().b(this.f10334e.f10330a, ((DownloadParams) this.f10334e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10334e.f10333d);
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.DOWNLOADED) {
                this.f10334e.f10333d.b();
                c.a.n0.f.i.m.a.b().b(this.f10334e.f10330a, ((DownloadParams) this.f10334e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.f10334e.f10333d);
            }
            if (this.f10334e.f10332c.f10327a == DownloadState.INSTALLED) {
                String e2 = this.f10334e.f10333d.e();
                if (TextUtils.isEmpty(this.f10334e.f10332c.f10328b) && !TextUtils.isEmpty(e2)) {
                    this.f10334e.a(e2);
                }
                b bVar = this.f10334e;
                bVar.r(bVar.f10332c.f10328b);
            }
        }
    }

    /* renamed from: c.a.n0.f.i.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0517b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10335a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020908067, "Lc/a/n0/f/i/k/g/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1020908067, "Lc/a/n0/f/i/k/g/b$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f10335a = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10335a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10335a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10335a[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10335a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10335a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static float m(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.AD_TEXT_ID, null, f2)) == null) {
            DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
            return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
        }
        return invokeF.floatValue;
    }

    @Override // c.a.n0.f.i.k.f.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f10332c.f10328b = str;
        }
    }

    @Override // c.a.n0.f.i.k.f.f
    public void b(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadState) == null) {
            v(downloadState);
        }
    }

    @Override // c.a.n0.f.i.k.f.f
    public /* bridge */ /* synthetic */ f c(Context context, DownloadParams downloadParams, c.a.n0.f.i.k.f.a aVar) {
        l(context, downloadParams, aVar);
        return this;
    }

    @Override // c.a.n0.f.i.k.f.f
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            t(i2);
        }
    }

    @Override // c.a.n0.f.i.k.f.f
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f10331b.setTag(obj);
        }
    }

    @Override // c.a.n0.f.i.k.f.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u(this.f10331b);
        }
    }

    @Override // c.a.n0.f.i.k.f.f
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10331b : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f10331b = new SwanAdDownloadButtonView(this.f10330a);
            String string = this.f10330a.getResources().getString(g.swanapp_ad_download_button);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (this.f10330a.getResources().getDisplayMetrics().heightPixels * 0.04d);
            this.f10331b.setLayoutParams(layoutParams);
            float n = n(this.f10330a, c.swan_ad_round_text_size);
            int color = this.f10330a.getResources().getColor(c.a.n0.f.i.b.swanapp_ad_download_button_color);
            u(this.f10331b);
            this.f10331b.setTextSize(m(n)).isCornerRadius(true).setTextColor(-1).setBgColor(color).isShowProgress(true);
            this.f10331b.setText(string);
            this.f10331b.setVisibility(0);
            this.f10331b.setProgress(this.f10332c.f10329c);
        }
    }

    public b l(Context context, DownloadParams downloadParams, c.a.n0.f.i.k.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, downloadParams, aVar)) == null) {
            this.f10330a = context;
            this.f10332c = c.a.n0.f.i.k.g.a.a(downloadParams.f46672a, downloadParams.f46673b);
            this.f10333d = aVar;
            k();
            q();
            return this;
        }
        return (b) invokeLLL.objValue;
    }

    public final float n(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, context, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i2, typedValue, true);
            return typedValue.getFloat();
        }
        return invokeLI.floatValue;
    }

    public final ResolveInfo o(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                return queryIntentActivities.iterator().next();
            }
            return null;
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public Object p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f10331b.getTag() : invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f10331b.setOnClickListener(new a(this));
        }
    }

    public final void r(String str) {
        ResolveInfo o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str) || (o = o(this.f10330a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(268435456);
        try {
            this.f10330a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadState)) == null) {
            switch (C0517b.f10335a[downloadState.ordinal()]) {
                case 1:
                    return g.swanapp_ad_download_button;
                case 2:
                    return g.swanapp_ad_download_button_pause;
                case 3:
                    return g.swanapp_ad_download_button_continue;
                case 4:
                    return g.swanapp_ad_download_button_install;
                case 5:
                    return g.swanapp_ad_download_button_failed_retry;
                case 6:
                    return g.swanapp_ad_download_button_open;
                default:
                    return g.swanapp_ad_download_button;
            }
        }
        return invokeL.intValue;
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            c.a.n0.f.i.k.g.a aVar = this.f10332c;
            if (i2 != aVar.f10329c) {
                aVar.f10329c = i2;
                w();
            }
        }
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || view == null) {
            return;
        }
        float n = n(this.f10330a, c.swan_ad_round_width_size);
        float n2 = n(this.f10330a, c.swan_ad_round_height_size);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        if (n >= 0.0f && n <= 1.0f) {
            n *= this.f10330a.getResources().getDisplayMetrics().widthPixels;
        }
        if (n2 > 0.0f && n2 <= 1.0f) {
            n2 *= this.f10330a.getResources().getDisplayMetrics().heightPixels;
        }
        layoutParams.width = (int) n;
        layoutParams.height = (int) n2;
    }

    public final void v(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadState) == null) {
            c.a.n0.f.i.k.g.a aVar = this.f10332c;
            if (downloadState != aVar.f10327a) {
                aVar.f10327a = downloadState;
                w();
            }
        }
    }

    public final void w() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.n0.f.i.k.g.a aVar = this.f10332c;
            if (aVar.f10327a == DownloadState.DOWNLOADING) {
                SwanAdDownloadButtonView swanAdDownloadButtonView = this.f10331b;
                if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                    if (this.f10332c.f10329c < this.f10331b.getMax()) {
                        String string2 = this.f10330a.getResources().getString(g.swanapp_ad_button_downloading);
                        string = String.format(string2, this.f10332c.f10329c + "%");
                    } else {
                        string = this.f10330a.getResources().getString(g.swanapp_ad_download_button_install);
                    }
                    this.f10331b.setText(string);
                    this.f10331b.setProgress(this.f10332c.f10329c);
                }
            } else {
                if (c.a.n0.f.i.r.g.a(this.f10330a, aVar.f10328b)) {
                    this.f10332c.f10327a = DownloadState.INSTALLED;
                }
                String string3 = this.f10330a.getResources().getString(s(this.f10332c.f10327a));
                if (this.f10332c.f10327a == DownloadState.DOWNLOADED) {
                    this.f10331b.setProgress(100);
                }
                c.a.n0.f.i.k.g.a aVar2 = this.f10332c;
                if (aVar2.f10327a == DownloadState.DOWNLOAD_PAUSED) {
                    this.f10331b.setProgress(aVar2.f10329c);
                }
                this.f10331b.setText(string3);
            }
            SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f10331b;
            if (swanAdDownloadButtonView2 != null) {
                swanAdDownloadButtonView2.postInvalidate();
            }
        }
    }
}
