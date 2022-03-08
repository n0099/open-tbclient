package c.a.r0.d1.l2.c.f;

import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: LikeSign.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, tBSpecificationBtn) == null) && UbsABTestHelper.isFrsModifyABTestA()) {
            Object tag = tBSpecificationBtn.getTag(R.id.item_tag_data);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                c.a.q0.r.l0.n.b bVar = (c.a.q0.r.l0.n.b) tBSpecificationBtn.getStyleConfig();
                bVar.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(bVar);
            }
        }
    }
}
