package c.a.p0.h.a.c.g;

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
import c.a.p0.h.a.c.f.f;
import c.a.p0.h.a.k.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadButtonView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f9959b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.h.a.c.g.a f9960c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h.a.c.f.a f9961d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9962e;

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
            this.f9962e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || c.a.p0.h.a.f.a.b() == null) {
                return;
            }
            if (this.f9962e.f9960c.a == DownloadState.NOT_START || this.f9962e.f9960c.a == DownloadState.DELETED) {
                c.a.p0.h.a.f.a.b().d(this.f9962e.a, ((DownloadParams) this.f9962e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f9962e.f9961d);
            }
            if (this.f9962e.f9960c.a == DownloadState.DOWNLOADING) {
                c.a.p0.h.a.f.a.b().d(this.f9962e.a, ((DownloadParams) this.f9962e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f9962e.f9961d);
            }
            if (this.f9962e.f9960c.a == DownloadState.DOWNLOAD_PAUSED) {
                c.a.p0.h.a.f.a.b().d(this.f9962e.a, ((DownloadParams) this.f9962e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f9962e.f9961d);
            }
            if (this.f9962e.f9960c.a == DownloadState.DOWNLOAD_FAILED) {
                c.a.p0.h.a.f.a.b().d(this.f9962e.a, ((DownloadParams) this.f9962e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f9962e.f9961d);
            }
            if (this.f9962e.f9960c.a == DownloadState.DOWNLOADED) {
                this.f9962e.f9961d.b();
                c.a.p0.h.a.f.a.b().d(this.f9962e.a, ((DownloadParams) this.f9962e.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.f9962e.f9961d);
            }
            if (this.f9962e.f9960c.a == DownloadState.INSTALLED) {
                String e2 = this.f9962e.f9961d.e();
                if (TextUtils.isEmpty(this.f9962e.f9960c.f9957b) && !TextUtils.isEmpty(e2)) {
                    this.f9962e.a(e2);
                }
                b bVar = this.f9962e;
                bVar.r(bVar.f9960c.f9957b);
            }
        }
    }

    /* renamed from: c.a.p0.h.a.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0662b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1528079059, "Lc/a/p0/h/a/c/g/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1528079059, "Lc/a/p0/h/a/c/g/b$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.INSTALLED.ordinal()] = 6;
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
        if (interceptable == null || (invokeF = interceptable.invokeF(65541, null, f2)) == null) {
            DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
            return f2 * (displayMetrics != null ? displayMetrics.density : 0.0f);
        }
        return invokeF.floatValue;
    }

    @Override // c.a.p0.h.a.c.f.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f9960c.f9957b = str;
        }
    }

    @Override // c.a.p0.h.a.c.f.f
    public void b(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadState) == null) {
            v(downloadState);
        }
    }

    @Override // c.a.p0.h.a.c.f.f
    public /* bridge */ /* synthetic */ f c(Context context, DownloadParams downloadParams, c.a.p0.h.a.c.f.a aVar) {
        l(context, downloadParams, aVar);
        return this;
    }

    @Override // c.a.p0.h.a.c.f.f
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            t(i2);
        }
    }

    @Override // c.a.p0.h.a.c.f.f
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f9959b.setTag(obj);
        }
    }

    @Override // c.a.p0.h.a.c.f.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u(this.f9959b);
        }
    }

    @Override // c.a.p0.h.a.c.f.f
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9959b : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f9959b = new SwanAdDownloadButtonView(this.a);
            String string = this.a.getResources().getString(R.string.swanapp_ad_download_button);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (this.a.getResources().getDisplayMetrics().heightPixels * 0.14d);
            this.f9959b.setLayoutParams(layoutParams);
            float n = n(this.a, R.dimen.swan_ad_round_text_size);
            int color = this.a.getResources().getColor(R.color.swanapp_ad_download_button_color);
            u(this.f9959b);
            this.f9959b.setTextSize(m(n)).isCornerRadius(true).setTextColor(-1).setBgColor(color).isShowProgress(true);
            this.f9959b.setText(string);
            this.f9959b.setVisibility(0);
            this.f9959b.setProgress(this.f9960c.f9958c);
        }
    }

    public b l(Context context, DownloadParams downloadParams, c.a.p0.h.a.c.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, downloadParams, aVar)) == null) {
            this.a = context;
            this.f9960c = c.a.p0.h.a.c.g.a.a(downloadParams.a, downloadParams.f38315b);
            this.f9961d = aVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f9959b.getTag() : invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f9959b.setOnClickListener(new a(this));
        }
    }

    public final void r(String str) {
        ResolveInfo o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str) || (o = o(this.a, str)) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = o.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(268435456);
        try {
            this.a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadState)) == null) {
            switch (C0662b.a[downloadState.ordinal()]) {
                case 1:
                default:
                    return R.string.swanapp_ad_download_button;
                case 2:
                    return R.string.swanapp_ad_download_button_pause;
                case 3:
                    return R.string.swanapp_ad_download_button_continue;
                case 4:
                    return R.string.swanapp_ad_download_button_install;
                case 5:
                    return R.string.swanapp_ad_download_button_failed_retry;
                case 6:
                    return R.string.swanapp_ad_download_button_open;
            }
        }
        return invokeL.intValue;
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            c.a.p0.h.a.c.g.a aVar = this.f9960c;
            if (i2 != aVar.f9958c) {
                aVar.f9958c = i2;
                w();
            }
        }
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || view == null) {
            return;
        }
        float n = n(this.a, R.dimen.swan_ad_round_width_size);
        float n2 = n(this.a, R.dimen.swan_ad_round_height_size);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        if (n >= 0.0f && n <= 1.0f) {
            n *= this.a.getResources().getDisplayMetrics().widthPixels;
        }
        if (n2 > 0.0f && n2 <= 1.0f) {
            n2 *= this.a.getResources().getDisplayMetrics().heightPixels;
        }
        layoutParams.width = (int) n;
        layoutParams.height = (int) n2;
    }

    public final void v(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadState) == null) {
            c.a.p0.h.a.c.g.a aVar = this.f9960c;
            if (downloadState != aVar.a) {
                aVar.a = downloadState;
                w();
            }
        }
    }

    public final void w() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.p0.h.a.c.g.a aVar = this.f9960c;
            if (aVar.a == DownloadState.DOWNLOADING) {
                SwanAdDownloadButtonView swanAdDownloadButtonView = this.f9959b;
                if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                    if (this.f9960c.f9958c < this.f9959b.getMax()) {
                        String string2 = this.a.getResources().getString(R.string.swanapp_ad_button_downloading);
                        string = String.format(string2, this.f9960c.f9958c + "%");
                    } else {
                        string = this.a.getResources().getString(R.string.swanapp_ad_download_button_install);
                    }
                    this.f9959b.setText(string);
                    this.f9959b.setProgress(this.f9960c.f9958c);
                }
            } else {
                if (g.a(this.a, aVar.f9957b)) {
                    this.f9960c.a = DownloadState.INSTALLED;
                }
                String string3 = this.a.getResources().getString(s(this.f9960c.a));
                if (this.f9960c.a == DownloadState.DOWNLOADED) {
                    this.f9959b.setProgress(100);
                }
                c.a.p0.h.a.c.g.a aVar2 = this.f9960c;
                if (aVar2.a == DownloadState.DOWNLOAD_PAUSED) {
                    this.f9959b.setProgress(aVar2.f9958c);
                }
                this.f9959b.setText(string3);
            }
            SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f9959b;
            if (swanAdDownloadButtonView2 != null) {
                swanAdDownloadButtonView2.postInvalidate();
            }
        }
    }
}
