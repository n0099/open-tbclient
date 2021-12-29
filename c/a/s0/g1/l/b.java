package c.a.s0.g1.l;

import android.content.Context;
import c.a.t0.w3.y;
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
            tiePlusHelper.J(true);
            tiePlusHelper.I(a.download_url);
            tiePlusHelper.L(a.app_package);
            tiePlusHelper.M(a.app_power);
            tiePlusHelper.N(a.app_privacy);
            TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(context, tiePlusHelper, true);
            tiePlusHelper.H(tiePlusDownloadDialog);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.K(itemData);
            tiePlusDownloadDialog.setAppCompany(a.app_company).setAppIcon(a.app_icon).setAppTitle(a.title).setAppVersion(a.app_version);
            tiePlusDownloadDialog.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
