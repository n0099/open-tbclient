package b.a.q0.f1.l;

import android.content.Context;
import b.a.q0.d1.p0;
import b.a.r0.l3.y;
import com.baidu.tbadk.core.data.ItemData;
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
            p0 p0Var = new p0(context);
            TiebaPlusInfo a2 = yVar.a();
            if (a2 == null) {
                return false;
            }
            p0Var.t(a2.app_id);
            p0Var.u(a2.title);
            p0Var.x(true);
            p0Var.w(a2.download_url);
            p0Var.z(a2.app_package);
            p0Var.A(a2.app_power);
            p0Var.B(a2.app_privacy);
            TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(context, p0Var, true);
            p0Var.v(tiePlusDownloadDialog);
            ItemData itemData = new ItemData();
            itemData.parseProto(a2);
            p0Var.y(itemData);
            tiePlusDownloadDialog.setAppCompany(a2.app_company).setAppIcon(a2.app_icon).setAppTitle(a2.title).setAppVersion(a2.app_version);
            tiePlusDownloadDialog.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
