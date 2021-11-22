package b.a.q0.s.g0.p;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "ItemTabLogUtil")
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) {
            if (i2 != 1) {
                return i2 != 2 ? -1 : 2;
            } else if (i3 != 1) {
                return i3 != 2 ? -1 : 3;
            } else {
                return 4;
            }
        }
        return invokeII.intValue;
    }

    public static final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (Intrinsics.areEqual(ItemCardHelper.f46389a, str)) {
                return 1;
            }
            return Intrinsics.areEqual(ItemCardHelper.f46390b, str) ? 2 : 9;
        }
        return invokeL.intValue;
    }

    public static final void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem();
            boolean z = false;
            switch (bVar.getType()) {
                case 1:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_ALBUM_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.g()).param("fid", bVar.a()).param("uid", bVar.i());
                    break;
                case 2:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_TAG_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("fid", bVar.a());
                    break;
                case 3:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RECOMMEND_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.g()).param("fid", bVar.a());
                    break;
                case 4:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK).param("obj_name", bVar.b()).param("obj_locate", bVar.c()).param("obj_type", bVar.g()).param("fid", bVar.a());
                    break;
                case 5:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_SHOW).param("obj_name", bVar.b()).param("obj_source", bVar.f()).param("obj_locate", bVar.a());
                    break;
                case 6:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RANKING).param("obj_name", bVar.b()).param("obj_type", bVar.g()).param("fid", bVar.a());
                    break;
                case 7:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_EXPORT).param("obj_name", bVar.b()).param("obj_type", bVar.g()).param("fid", bVar.a()).param("uid", bVar.i());
                    break;
                case 8:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_CLICK).param("obj_name", bVar.b()).param("obj_type", bVar.g()).param("fid", bVar.a()).param("uid", bVar.i()).param("obj_source", bVar.f());
                    String d2 = bVar.d();
                    if (!((d2 == null || d2.length() == 0) ? true : true)) {
                        statisticItem.param("obj_locate", bVar.d());
                        break;
                    }
                    break;
                case 9:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_SHOW).param("fid", bVar.a());
                    break;
                case 10:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_CLICK).param("fid", bVar.a());
                    break;
                case 11:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_SHOW).param("fid", bVar.a()).param("obj_locate", bVar.c());
                    break;
                case 12:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_CLICK).param("fid", bVar.a()).param("obj_locate", bVar.c());
                    String h2 = bVar.h();
                    if (!((h2 == null || h2.length() == 0) ? true : true)) {
                        statisticItem.param("post_id", bVar.h());
                        break;
                    }
                    break;
                case 13:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_SHOW).param("fid", bVar.a()).param("obj_id", bVar.b()).param("uid", bVar.i());
                    break;
                case 14:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_CLICK).param("fid", bVar.a()).param("obj_id", bVar.b()).param("uid", bVar.i());
                    break;
                case 15:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_SHOW).param("obj_id", bVar.b()).param("fid", bVar.a()).param("obj_locate", bVar.c()).param("uid", bVar.i());
                    break;
                case 16:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_CLICK).param("obj_id", bVar.b()).param("fid", bVar.a()).param("obj_name", bVar.e()).param("obj_type", bVar.g());
                    break;
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
