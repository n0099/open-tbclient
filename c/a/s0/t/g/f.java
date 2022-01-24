package c.a.s0.t.g;

import c.a.d.f.p.m;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (m.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return c.a.s0.s.i0.b.k().l("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
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
            int a = a();
            int i2 = R.drawable.icon_mask_share_wechat40_svg;
            if (a != 2) {
                if (a != 3) {
                    if (a != 4) {
                        if (a != 6) {
                            return a != 8 ? i2 : R.drawable.icon_mask_share_qq40_svg;
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
        if (!(interceptable == null || interceptable.invokeI(65538, null, i2) == null) || i2 <= 0 || m.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        c.a.s0.s.i0.b.k().w("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i2);
    }
}
