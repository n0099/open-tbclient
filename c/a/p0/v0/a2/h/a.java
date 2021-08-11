package c.a.p0.v0.a2.h;

import c.a.o0.s.f0.p.b;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "ItemTabLogUtil")
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem();
            switch (bVar.f()) {
                case 1:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_ALBUM_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.e()).param("fid", bVar.a()).param("uid", bVar.g());
                    break;
                case 2:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_TAG_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("fid", bVar.a());
                    break;
                case 3:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RECOMMEND_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.e()).param("fid", bVar.a());
                    break;
                case 4:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.e()).param("fid", bVar.a());
                    break;
                case 5:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_SHOW).param("obj_name", bVar.b()).param("obj_source", bVar.d()).param("fid", bVar.a());
                    break;
                case 6:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RANKING).param("obj_name", bVar.b()).param("obj_type", bVar.e()).param("fid", bVar.a());
                    break;
                case 7:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_EXPORT).param("obj_name", bVar.b()).param("obj_type", bVar.e()).param("fid", bVar.a()).param("uid", bVar.g());
                    break;
                case 8:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_CLICK).param("obj_name", bVar.b()).param("obj_type", bVar.e()).param("fid", bVar.a()).param("uid", bVar.g());
                    break;
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
