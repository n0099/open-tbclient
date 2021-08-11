package c.a.o0.t.g;

import c.a.e.e.p.k;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (k.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return c.a.o0.s.d0.b.j().k("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
                return -1;
            }
            int a2 = a();
            int i2 = R.drawable.icon_mask_share_wechat40_svg;
            if (a2 != 2) {
                if (a2 != 3) {
                    if (a2 != 4) {
                        if (a2 != 6) {
                            return a2 != 8 ? i2 : R.drawable.icon_mask_share_qq40_svg;
                        }
                        return R.drawable.icon_mask_share_weibo40_svg;
                    }
                    return R.drawable.icon_mask_share_qqzone40_svg;
                }
                return i2;
            }
            return R.drawable.icon_mask_share_circle40_svg;
        }
        return invokeV.intValue;
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, null, i2) == null) || i2 <= 0 || k.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        c.a.o0.s.d0.b.j().v("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i2);
    }
}
