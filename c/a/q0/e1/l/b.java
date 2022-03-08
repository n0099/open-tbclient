package c.a.q0.e1.l;

import android.content.Context;
import c.a.r0.y3.z;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, zVar)) == null) {
            if (context == null || zVar == null || !zVar.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = zVar.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.E(a.app_id);
            tiePlusHelper.F(a.title);
            tiePlusHelper.K(true);
            tiePlusHelper.J(a.download_url);
            tiePlusHelper.M(a.app_package);
            tiePlusHelper.N(a.app_power);
            tiePlusHelper.O(a.app_privacy);
            TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(context, tiePlusHelper, true);
            tiePlusHelper.I(tiePlusDownloadDialog);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.L(itemData);
            tiePlusDownloadDialog.setAppCompany(a.app_company).setAppIcon(a.app_icon).setAppTitle(a.title).setAppVersion(a.app_version);
            tiePlusDownloadDialog.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
