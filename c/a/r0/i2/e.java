package c.a.r0.i2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, userData) == null) || userData == null || userData.getUserId() == null || userData.getAlaUserData() == null || userData.getAlaInfo() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        AlaInfoData alaInfo = userData.getAlaInfo();
        String str2 = StringUtils.isNull(alaInfo.appId) ? null : alaInfo.appId;
        if (alaInfo.mYyExtData != null) {
            str2 = TiebaStatic.YYValues.YY_LIVE;
        }
        statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(alaInfo));
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
        TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
        TiebaStatic.log(statisticItem);
    }
}
