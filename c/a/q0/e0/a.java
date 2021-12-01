package c.a.q0.e0;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.g0.p.d.b;
import c.a.q0.w.c;
import c.a.r0.h3.f0.g;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) {
            b.a(downloadData, 400);
            g.l().g(downloadData.getUrl(), downloadData.getId());
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? g.l().p(str) : invokeL.booleanValue;
    }

    public static int c(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadData)) == null) {
            if (g.l().o(downloadData.getId())) {
                return 5;
            }
            if (g.l().q(downloadData.getId())) {
                return 1;
            }
            return g.l().n(downloadData.getId(), downloadData.getName()) ? 7 : 6;
        }
        return invokeL.intValue;
    }

    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (c.q().t(str)) {
                return 1;
            }
            if (c.q().r(str)) {
                return 5;
            }
            File m = c.q().m(str, str2);
            return (m == null || !m.exists()) ? 6 : 7;
        }
        return invokeLL.intValue;
    }

    public static PackageInfo e(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                packageInfo = TbadkApplication.getInst().getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (str.equals(packageInfo.packageName)) {
                return packageInfo;
            }
            return null;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            return split.length == 2 ? split[1] : dataString;
        }
        return (String) invokeL.objValue;
    }

    public static int h(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            int i2 = g.l().i(downloadData.getId(), downloadData.getName());
            if (i2 < 0 || i2 > 100) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, downloadData) == null) {
            b.a(downloadData, 800);
            Application app = TbadkCoreApplication.getInst().getApp();
            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        }
    }

    public static DownloadData j(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, itemData)) == null) {
            String str = itemData.pkgName + ".v" + itemData.apkDetail.version;
            DownloadData downloadData = new DownloadData();
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setName(itemData.mTitle);
            downloadData.setUrl(itemData.buttonLink);
            downloadData.setNotifyId(g.m(str).intValue());
            downloadData.setNeedInvokeApk(true);
            downloadData.setNeedNotify(false);
            ItemDownloadExtraData itemDownloadExtraData = new ItemDownloadExtraData(itemData.apkDetail.pkg_source.intValue());
            itemDownloadExtraData.appName = itemData.mTitle;
            itemDownloadExtraData.pkgName = itemData.pkgName;
            downloadData.setExtra(itemDownloadExtraData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }

    public static void k(String str) {
        Context context;
        Intent f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || TextUtils.isEmpty(str) || (f2 = f((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return;
        }
        try {
            context.startActivity(f2);
        } catch (Exception unused) {
        }
    }

    public static boolean l(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, downloadData)) == null) {
            if (l.C()) {
                return g.l().s(downloadData);
            }
            c.a.q0.w.b.b(downloadData);
            return false;
        }
        return invokeL.booleanValue;
    }
}
