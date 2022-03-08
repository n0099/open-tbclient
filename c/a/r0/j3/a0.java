package c.a.r0.j3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.y3.m0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f18307c;

        public a(TbImageView tbImageView, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i2), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
            this.f18306b = i2;
            this.f18307c = f2;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || (layoutParams = this.a.getLayoutParams()) == null) {
                return;
            }
            layoutParams.height = this.f18306b;
            float f2 = this.f18307c;
            if (f2 <= 0.0f) {
                f2 = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f2);
            this.a.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.a.setAlpha(0.8f);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-419289935, "Lc/a/r0/j3/a0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-419289935, "Lc/a/r0/j3/a0;");
        }
    }

    public static int A(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uri, context)) == null) {
            try {
                String queryParameter = uri.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                if (TextUtils.isEmpty(queryParameter)) {
                    return 1003;
                }
                return t(context, Uri.parse(queryParameter));
            } catch (Exception unused) {
                return 1003;
            }
        }
        return invokeLL.intValue;
    }

    public static void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || c.a.r0.a.h().E() || a) {
            return;
        }
        a = true;
        String[] strArr = {"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"};
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                Class.forName(strArr[i2]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean C(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, advertAppInfo, str)) == null) {
            if (advertAppInfo == null || !advertAppInfo.W4() || TextUtils.isEmpty(str) || !r(advertAppInfo.y4) || str.startsWith("tieba://deeplink?")) {
                return false;
            }
            return x(advertAppInfo);
        }
        return invokeLL.booleanValue;
    }

    public static final void a(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, advertAppInfo) == null) {
            c.a.r0.j3.g0.e.n().g(advertAppInfo.x4, advertAppInfo.getDownloadId(), true);
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (s(TbadkCoreApplication.getInst(), str)) {
                return o(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            boolean checkWriteExternalStorage = PermissionUtil.checkWriteExternalStorage(activity);
            if (activity.getApplicationInfo().targetSdkVersion >= 23 || !Environment.getExternalStorageState().equals("unmounted")) {
                return checkWriteExternalStorage;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int d(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, context, str, str2, str3, str4)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (c.a.r0.a.h().y() && !TextUtils.isEmpty(str4) && c.a.r0.v.a.a(str4)) {
                return 1;
            }
            Bundle bundle = new Bundle();
            bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str2);
            bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, str3);
            if (str.startsWith("tieba://deeplink?")) {
                Uri parse = Uri.parse(str);
                int A = A(parse, context);
                if (A != 1000) {
                    if (i(context, parse.getQueryParameter("wap"), bundle)) {
                        return A;
                    }
                    return 0;
                }
                return 1000;
            }
            return i(context, str, bundle) ? 1 : 0;
        }
        return invokeLLLLL.intValue;
    }

    public static int e(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            return d(tbPageContext.getPageActivity(), str, str2, str3, str4);
        }
        return invokeLLLLL.intValue;
    }

    public static int f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
                return 0;
            }
            return A(Uri.parse(str), context);
        }
        return invokeLL.intValue;
    }

    public static int g(Context context, String str, AdvertAppInfo advertAppInfo, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, context, str, advertAppInfo, str2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            if (c.a.r0.a.h().y() && !TextUtils.isEmpty(str2)) {
                z.q().o(advertAppInfo);
                return c.a.r0.v.a.a(str2) ? 1 : 0;
            } else if (str.startsWith("tieba://deeplink?")) {
                int A = A(Uri.parse(str), context);
                if (A != 1000) {
                    z.q().i(advertAppInfo, context);
                    return A;
                }
                return 1000;
            } else {
                z.q().i(advertAppInfo, context);
                return 1;
            }
        }
        return invokeLLLL.intValue;
    }

    public static boolean h(Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, hashMap)) == null) {
            if (context == null || hashMap == null) {
                return false;
            }
            z.q().p(hashMap, context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(@NonNull Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, bundle)) == null) {
            String[] strArr = {str};
            l e2 = z.q().e();
            if (e2 == null) {
                return false;
            }
            if (e2.a(str)) {
                e2.b(context, strArr, true, bundle);
                return true;
            }
            return e2.c(context, strArr, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public static final boolean j(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65549, null, context, advertAppInfo, i2, downloadStaticsData)) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            String str = advertAppInfo.t4;
            if (StringUtils.isNull(str)) {
                str = "";
            }
            return k(context, advertAppInfo, i2, str, downloadStaticsData);
        }
        return invokeLLIL.booleanValue;
    }

    public static final boolean k(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, advertAppInfo, Integer.valueOf(i2), str, downloadStaticsData})) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            c.a.q0.u.a.k().h(advertAppInfo);
            String str2 = advertAppInfo.t4;
            c.a.r0.j3.g0.e.n().E(advertAppInfo.getDownloadId(), advertAppInfo.x4, StringUtils.isNull(str2) ? str : str2, i2, c.a.r0.j3.g0.e.o(advertAppInfo.y4).intValue(), null, true, false, true, advertAppInfo.u4, downloadStaticsData, advertAppInfo.t4);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void l(String str, TbImageView tbImageView, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{str, tbImageView, Float.valueOf(f2), Integer.valueOf(i2)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.startLoad(str, 10, false);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            if (f2 <= 0.0f) {
                f2 = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f2);
            tbImageView.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                tbImageView.setAlpha(0.8f);
            }
        }
        tbImageView.setVisibility(0);
    }

    public static Intent m(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) ? Uri.parse(str).getQueryParameter("wap") : str : (String) invokeL.objValue;
    }

    public static boolean o(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (TextUtils.isEmpty(str)) {
                c.a.d.f.p.n.M(inst, R.string.download_error);
                return false;
            }
            File d2 = b.d(str);
            if (b.l(d2)) {
                Intent intent = new Intent();
                if (c.a.r0.a.h().w()) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(UtilHelper.getUriFromFile(d2, intent, inst), "application/vnd.android.package-archive");
                intent.addFlags(268435456);
                inst.startActivity(intent);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("tieba://deeplink?");
        }
        return invokeL.booleanValue;
    }

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            switch (i2) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 8192) != null;
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
        }
        return invokeLL.booleanValue;
    }

    public static int t(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, uri)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return 1004;
                }
                context.startActivity(intent);
                return 1000;
            } catch (Exception unused) {
                return 1006;
            }
        }
        return invokeLL.intValue;
    }

    public static void u(String str, TbImageView tbImageView, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{str, tbImageView, Float.valueOf(f2), Integer.valueOf(i2)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.startLoad(str, 10, false);
        tbImageView.setEvent(new a(tbImageView, i2, f2));
    }

    public static void v(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            z.q().m(z, str, str2, str3, list, str4);
        }
    }

    public static void w(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            z.q().d(z, str, str2, str3, str4, list, str5);
        }
    }

    public static boolean x(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return false;
            }
            return y(advertAppInfo.y4);
        }
        return invokeL.booleanValue;
    }

    public static boolean y(String str) {
        InterceptResult invokeL;
        Context context;
        Intent m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (m = m((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
                return false;
            }
            try {
                context.startActivity(m);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean z(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, context)) == null) ? (TextUtils.isEmpty(str) || UrlSchemaJumpHelper.isHitBlackList(str) || t(context, Uri.parse(str)) != 1000) ? false : true : invokeLL.booleanValue;
    }
}
