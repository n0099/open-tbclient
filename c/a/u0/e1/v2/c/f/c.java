package c.a.u0.e1.v2.c.f;

import androidx.annotation.NonNull;
import c.a.u0.e1.c1;
import c.a.u0.e1.f1;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: LikeSign.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, tBSpecificationBtn) == null) && c.a.t0.b.d.u()) {
            Object tag = tBSpecificationBtn.getTag(f1.item_tag_data);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                c.a.t0.s.l0.n.b bVar = (c.a.t0.s.l0.n.b) tBSpecificationBtn.getStyleConfig();
                bVar.t(c1.CAM_X0105);
                tBSpecificationBtn.setConfig(bVar);
            }
        }
    }
}
