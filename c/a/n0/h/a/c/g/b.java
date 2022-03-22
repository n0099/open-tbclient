package c.a.n0.h.a.c.g;

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
import c.a.n0.h.a.c.f.f;
import c.a.n0.h.a.k.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
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
/* loaded from: classes.dex */
public class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAdDownloadButtonView f8343b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.h.a.c.g.a f8344c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.h.a.c.f.a f8345d;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || c.a.n0.h.a.f.a.b() == null) {
                return;
            }
            if (this.a.f8344c.a == DownloadState.NOT_START || this.a.f8344c.a == DownloadState.DELETED) {
                c.a.n0.h.a.f.a.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.f8345d);
            }
            if (this.a.f8344c.a == DownloadState.DOWNLOADING) {
                c.a.n0.h.a.f.a.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.a.f8345d);
            }
            if (this.a.f8344c.a == DownloadState.DOWNLOAD_PAUSED) {
                c.a.n0.h.a.f.a.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.f8345d);
            }
            if (this.a.f8344c.a == DownloadState.DOWNLOAD_FAILED) {
                c.a.n0.h.a.f.a.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.f8345d);
            }
            if (this.a.f8344c.a == DownloadState.DOWNLOADED) {
                this.a.f8345d.b();
                c.a.n0.h.a.f.a.b().d(this.a.a, ((DownloadParams) this.a.p()).a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.a.f8345d);
            }
            if (this.a.f8344c.a == DownloadState.INSTALLED) {
                String e2 = this.a.f8345d.e();
                if (TextUtils.isEmpty(this.a.f8344c.f8341b) && !TextUtils.isEmpty(e2)) {
                    this.a.a(e2);
                }
                b bVar = this.a;
                bVar.r(bVar.f8344c.f8341b);
            }
        }
    }

    /* renamed from: c.a.n0.h.a.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0656b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-248215381, "Lc/a/n0/h/a/c/g/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-248215381, "Lc/a/n0/h/a/c/g/b$b;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // c.a.n0.h.a.c.f.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f8344c.f8341b = str;
        }
    }

    @Override // c.a.n0.h.a.c.f.f
    public void b(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadState) == null) {
            v(downloadState);
        }
    }

    @Override // c.a.n0.h.a.c.f.f
    public /* bridge */ /* synthetic */ f c(Context context, DownloadParams downloadParams, c.a.n0.h.a.c.f.a aVar) {
        l(context, downloadParams, aVar);
        return this;
    }

    @Override // c.a.n0.h.a.c.f.f
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            t(i);
        }
    }

    @Override // c.a.n0.h.a.c.f.f
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f8343b.setTag(obj);
        }
    }

    @Override // c.a.n0.h.a.c.f.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u(this.f8343b);
        }
    }

    @Override // c.a.n0.h.a.c.f.f
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f8343b : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8343b = new SwanAdDownloadButtonView(this.a);
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1249);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) (this.a.getResources().getDisplayMetrics().heightPixels * 0.14d);
            this.f8343b.setLayoutParams(layoutParams);
            float n = n(this.a, R.dimen.obfuscated_res_0x7f0705fa);
            int color = this.a.getResources().getColor(R.color.obfuscated_res_0x7f060a4e);
            u(this.f8343b);
            SwanAdDownloadButtonView swanAdDownloadButtonView = this.f8343b;
            swanAdDownloadButtonView.j(m(n));
            swanAdDownloadButtonView.f(true);
            swanAdDownloadButtonView.i(-1);
            swanAdDownloadButtonView.h(color);
            swanAdDownloadButtonView.g(true);
            this.f8343b.setText(string);
            this.f8343b.setVisibility(0);
            this.f8343b.setProgress(this.f8344c.f8342c);
        }
    }

    public b l(Context context, DownloadParams downloadParams, c.a.n0.h.a.c.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, downloadParams, aVar)) == null) {
            this.a = context;
            this.f8344c = c.a.n0.h.a.c.g.a.a(downloadParams.a, downloadParams.f29461b);
            this.f8345d = aVar;
            k();
            q();
            return this;
        }
        return (b) invokeLLL.objValue;
    }

    public final float n(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, context, i)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i, typedValue, true);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f8343b.getTag() : invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f8343b.setOnClickListener(new a(this));
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
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        try {
            this.a.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final int s(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, downloadState)) == null) {
            switch (C0656b.a[downloadState.ordinal()]) {
                case 1:
                default:
                    return R.string.obfuscated_res_0x7f0f1249;
                case 2:
                    return R.string.obfuscated_res_0x7f0f124e;
                case 3:
                    return R.string.obfuscated_res_0x7f0f124a;
                case 4:
                    return R.string.obfuscated_res_0x7f0f124c;
                case 5:
                    return R.string.obfuscated_res_0x7f0f124b;
                case 6:
                    return R.string.obfuscated_res_0x7f0f124d;
            }
        }
        return invokeL.intValue;
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            c.a.n0.h.a.c.g.a aVar = this.f8344c;
            if (i != aVar.f8342c) {
                aVar.f8342c = i;
                w();
            }
        }
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, view) == null) || view == null) {
            return;
        }
        float n = n(this.a, R.dimen.obfuscated_res_0x7f0705fc);
        float n2 = n(this.a, R.dimen.obfuscated_res_0x7f0705f9);
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
            c.a.n0.h.a.c.g.a aVar = this.f8344c;
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
            c.a.n0.h.a.c.g.a aVar = this.f8344c;
            if (aVar.a == DownloadState.DOWNLOADING) {
                SwanAdDownloadButtonView swanAdDownloadButtonView = this.f8343b;
                if (swanAdDownloadButtonView != null && swanAdDownloadButtonView.getVisibility() != 8) {
                    if (this.f8344c.f8342c < this.f8343b.getMax()) {
                        String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1248);
                        string = String.format(string2, this.f8344c.f8342c + "%");
                    } else {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f124c);
                    }
                    this.f8343b.setText(string);
                    this.f8343b.setProgress(this.f8344c.f8342c);
                }
            } else {
                if (g.a(this.a, aVar.f8341b)) {
                    this.f8344c.a = DownloadState.INSTALLED;
                }
                String string3 = this.a.getResources().getString(s(this.f8344c.a));
                if (this.f8344c.a == DownloadState.DOWNLOADED) {
                    this.f8343b.setProgress(100);
                }
                c.a.n0.h.a.c.g.a aVar2 = this.f8344c;
                if (aVar2.a == DownloadState.DOWNLOAD_PAUSED) {
                    this.f8343b.setProgress(aVar2.f8342c);
                }
                this.f8343b.setText(string3);
            }
            SwanAdDownloadButtonView swanAdDownloadButtonView2 = this.f8343b;
            if (swanAdDownloadButtonView2 != null) {
                swanAdDownloadButtonView2.postInvalidate();
            }
        }
    }
}
