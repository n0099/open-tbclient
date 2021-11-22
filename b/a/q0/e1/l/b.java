package b.a.q0.e1.l;

import android.content.Context;
import b.a.r0.m3.y;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
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
            TiebaPlusInfo a2 = yVar.a();
            if (a2 == null) {
                return false;
            }
            tiePlusHelper.B(a2.app_id);
            tiePlusHelper.D(a2.title);
            tiePlusHelper.N(true);
            tiePlusHelper.M(a2.download_url);
            tiePlusHelper.P(a2.app_package);
            tiePlusHelper.Q(a2.app_power);
            tiePlusHelper.R(a2.app_privacy);
            TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(context, tiePlusHelper, true);
            tiePlusHelper.L(tiePlusDownloadDialog);
            ItemData itemData = new ItemData();
            itemData.parseProto(a2);
            tiePlusHelper.O(itemData);
            tiePlusDownloadDialog.setAppCompany(a2.app_company).setAppIcon(a2.app_icon).setAppTitle(a2.title).setAppVersion(a2.app_version);
            tiePlusDownloadDialog.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
