package c.a.r0.f1.l;

import android.content.Context;
import c.a.s0.v3.y;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, y yVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, yVar)) == null) {
            if (context == null || yVar == null || !yVar.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = yVar.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.E(a.app_id);
            tiePlusHelper.F(a.title);
            tiePlusHelper.M(true);
            tiePlusHelper.L(a.download_url);
            tiePlusHelper.Q(a.app_package);
            tiePlusHelper.S(a.app_power);
            tiePlusHelper.T(a.app_privacy);
            TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(context, tiePlusHelper, true);
            tiePlusHelper.K(tiePlusDownloadDialog);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.O(itemData);
            tiePlusDownloadDialog.setAppCompany(a.app_company).setAppIcon(a.app_icon).setAppTitle(a.title).setAppVersion(a.app_version);
            tiePlusDownloadDialog.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
