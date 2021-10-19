package c.a.r0.k2.j;

import c.a.r0.k2.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f a(TbPageContext tbPageContext, IBaseDialogData iBaseDialogData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, iBaseDialogData)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || iBaseDialogData == null || iBaseDialogData.getType() != 1) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(b.a.f19682a);
            int i2 = 0;
            int from = iBaseDialogData.getFrom();
            if (from == 0) {
                i2 = 2;
            } else if (from == 1) {
                i2 = 3;
            } else if (from == 2) {
                i2 = 4;
            }
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            return new d(tbPageContext, (CustomDialogData) iBaseDialogData);
        }
        return (f) invokeLL.objValue;
    }
}
