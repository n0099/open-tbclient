package c.a.o0.d0;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.o0.w.b;
import c.a.p0.x2.f0.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.Item;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) {
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

    public static PackageInfo d(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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

    public static Intent e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static String f(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            return split.length == 2 ? split[1] : dataString;
        }
        return (String) invokeL.objValue;
    }

    public static int g(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, downloadData)) == null) {
            int i2 = g.l().i(downloadData.getId(), downloadData.getName());
            if (i2 < 0 || i2 > 100) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, downloadData) == null) {
            Application app = TbadkCoreApplication.getInst().getApp();
            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + ".apk");
        }
    }

    public static DownloadData i(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, item)) == null) {
            String str = item.apk_name + ".v" + item.apk_detail.version;
            DownloadData downloadData = new DownloadData();
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setName(item.item_name);
            downloadData.setUrl(item.button_link);
            downloadData.setNotifyId(g.m(str).intValue());
            downloadData.setNeedInvokeApk(true);
            downloadData.setNeedNotify(false);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }

    public static void j(String str) {
        Context context;
        Intent e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || TextUtils.isEmpty(str) || (e2 = e((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return;
        }
        try {
            context.startActivity(e2);
        } catch (Exception unused) {
        }
    }

    public static void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, downloadData) == null) {
            if (l.D()) {
                g.l().s(downloadData);
            } else {
                b.b(downloadData);
            }
        }
    }
}
