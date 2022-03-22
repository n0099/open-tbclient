package c.a.p0.l3.g0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.d.f.p.n;
import c.a.p0.l3.a0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, advertAppInfo) == null) {
            c.a.o0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && !adAdSense.f()) {
                a0.a(advertAppInfo);
            } else {
                k.j().f(advertAppInfo.r, advertAppInfo.getDownloadId(), true);
            }
        }
    }

    public static final boolean b(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, context, advertAppInfo, i, downloadStaticsData)) == null) {
            c.a.o0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense == null || adAdSense.f()) {
                if (context == null || advertAppInfo == null) {
                    return false;
                }
                String str = advertAppInfo.n;
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                return c(context, advertAppInfo, i, str, downloadStaticsData);
            }
            return a0.j(context, advertAppInfo, i, downloadStaticsData);
        }
        return invokeLLIL.booleanValue;
    }

    public static final boolean c(Context context, AdvertAppInfo advertAppInfo, int i, String str, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, advertAppInfo, Integer.valueOf(i), str, downloadStaticsData})) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            c.a.o0.u.a.k().h(advertAppInfo);
            String str2 = advertAppInfo.n;
            k.j().v(advertAppInfo.getDownloadId(), advertAppInfo.r, StringUtils.isNull(str2) ? str : str2, i, k.k(advertAppInfo.s).intValue(), null, true, false, true, advertAppInfo.o, downloadStaticsData, advertAppInfo.n);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static final void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                n.M(context, R.string.obfuscated_res_0x7f0f04e7);
                return;
            }
            File GetFile = FileHelper.GetFile(str.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            if (GetFile != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(intent);
            }
        }
    }
}
