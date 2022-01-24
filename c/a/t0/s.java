package c.a.t0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.t0.x3.b0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                String versionName = TbadkCoreApplication.getInst().getVersionName();
                String q = c.a.s0.s.i0.b.k().q("version_name", "");
                if (TextUtils.isEmpty(versionName)) {
                    return null;
                }
                if (versionName.equals(q)) {
                    return c.a.s0.s.i0.b.k().q("apk_md5", "");
                }
                c.a.s0.s.i0.b.k().y("version_name", versionName);
                String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0));
                c.a.s0.s.i0.b.k().y("apk_md5", aPKMd5);
                return aPKMd5;
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void b(Context context, VersionData versionData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, versionData) == null) {
            try {
                str = TbMd5.creatSignInt(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 64));
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                str = "-1";
                Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
                intent.setFlags(268435488);
                intent.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
                intent.putExtra(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, "0");
                intent.putExtra("func", "11");
                Bundle bundle = new Bundle();
                bundle.putInt("versioncode", versionData.getNewVersionCode());
                bundle.putLong("patch_size", c.a.d.f.m.b.g(versionData.getPatchSize(), 0L));
                bundle.putString("patch_url", versionData.getPatch());
                bundle.putString("sname", context.getString(R.string.app_name));
                bundle.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
                bundle.putString("downurl", versionData.getUrl());
                bundle.putString("versionname", versionData.getNewVersion());
                bundle.putString("iconurl", versionData.getTiebaIconUrl());
                bundle.putString("updatetime", c.a.d.f.p.m.getDateStringDay(new Date(System.currentTimeMillis())));
                bundle.putString("size", versionData.getSize());
                bundle.putString("signmd5", str);
                bundle.putString("tj", str + context.getString(R.string.app_name));
                intent.putExtra("extra_client_downloadinfo", bundle);
                context.startActivity(intent);
            } catch (NumberFormatException e3) {
                BdLog.detailException(e3);
                str = "-1";
                Intent intent2 = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
                intent2.setFlags(268435488);
                intent2.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
                intent2.putExtra(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, "0");
                intent2.putExtra("func", "11");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("versioncode", versionData.getNewVersionCode());
                bundle2.putLong("patch_size", c.a.d.f.m.b.g(versionData.getPatchSize(), 0L));
                bundle2.putString("patch_url", versionData.getPatch());
                bundle2.putString("sname", context.getString(R.string.app_name));
                bundle2.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
                bundle2.putString("downurl", versionData.getUrl());
                bundle2.putString("versionname", versionData.getNewVersion());
                bundle2.putString("iconurl", versionData.getTiebaIconUrl());
                bundle2.putString("updatetime", c.a.d.f.p.m.getDateStringDay(new Date(System.currentTimeMillis())));
                bundle2.putString("size", versionData.getSize());
                bundle2.putString("signmd5", str);
                bundle2.putString("tj", str + context.getString(R.string.app_name));
                intent2.putExtra("extra_client_downloadinfo", bundle2);
                context.startActivity(intent2);
            }
            Intent intent22 = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
            intent22.setFlags(268435488);
            intent22.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
            intent22.putExtra(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, "0");
            intent22.putExtra("func", "11");
            Bundle bundle22 = new Bundle();
            bundle22.putInt("versioncode", versionData.getNewVersionCode());
            bundle22.putLong("patch_size", c.a.d.f.m.b.g(versionData.getPatchSize(), 0L));
            bundle22.putString("patch_url", versionData.getPatch());
            bundle22.putString("sname", context.getString(R.string.app_name));
            bundle22.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
            bundle22.putString("downurl", versionData.getUrl());
            bundle22.putString("versionname", versionData.getNewVersion());
            bundle22.putString("iconurl", versionData.getTiebaIconUrl());
            bundle22.putString("updatetime", c.a.d.f.p.m.getDateStringDay(new Date(System.currentTimeMillis())));
            bundle22.putString("size", versionData.getSize());
            bundle22.putString("signmd5", str);
            bundle22.putString("tj", str + context.getString(R.string.app_name));
            intent22.putExtra("extra_client_downloadinfo", bundle22);
            context.startActivity(intent22);
        }
    }

    public static boolean c(Context context, CombineDownload combineDownload) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, combineDownload)) == null) ? (combineDownload == null || b0.b(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) ? false : true : invokeLL.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || TbSingleton.getInstance().getSyncModel() == null) {
            return;
        }
        c.a.s0.t.e.e syncModel = TbSingleton.getInstance().getSyncModel();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TbSingleton.getInstance().getSyncModel().s(), syncModel.j())));
    }
}
