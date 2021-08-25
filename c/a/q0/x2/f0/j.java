package c.a.q0.x2.f0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.q0.x2.z;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, advertAppInfo) == null) {
            c.a.p0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && !adAdSense.f()) {
                z.a(advertAppInfo);
            } else {
                k.l().g(advertAppInfo.k4, advertAppInfo.getDownloadId(), true);
            }
        }
    }

    public static final boolean b(Context context, AdvertAppInfo advertAppInfo, int i2, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, context, advertAppInfo, i2, downloadStaticsData)) == null) {
            c.a.p0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense == null || adAdSense.f()) {
                if (context == null || advertAppInfo == null) {
                    return false;
                }
                String str = advertAppInfo.g4;
                if (StringUtils.isNull(str)) {
                    str = "";
                }
                return c(context, advertAppInfo, i2, str, downloadStaticsData);
            }
            return z.i(context, advertAppInfo, i2, downloadStaticsData);
        }
        return invokeLLIL.booleanValue;
    }

    public static final boolean c(Context context, AdvertAppInfo advertAppInfo, int i2, String str, DownloadStaticsData downloadStaticsData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, advertAppInfo, Integer.valueOf(i2), str, downloadStaticsData})) == null) {
            if (context == null || advertAppInfo == null) {
                return false;
            }
            c.a.p0.v.a.k().h(advertAppInfo);
            String str2 = advertAppInfo.g4;
            k.l().x(advertAppInfo.getDownloadId(), advertAppInfo.k4, StringUtils.isNull(str2) ? str : str2, i2, k.m(advertAppInfo.l4).intValue(), null, true, false, true, advertAppInfo.h4, downloadStaticsData, advertAppInfo.g4);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static final void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                c.a.e.e.p.l.L(context, R.string.download_error);
                return;
            }
            File GetFile = FileHelper.GetFile(str.replace(".", "_") + ".apk");
            if (GetFile != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }
}
