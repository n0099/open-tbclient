package com.baidu.tbadk.core.data;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.FrsPage.RecreationRankInfo;
/* loaded from: classes4.dex */
public class FrsGameRankInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String icon;
    public String rankColor;
    public String rankIcon;
    public String rankLink;
    public String rankName;
    public int rankScore;
    public int showType;

    public FrsGameRankInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static FrsGameRankInfoData ofRecreationRankInfo(@NonNull RecreationRankInfo recreationRankInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, recreationRankInfo)) == null) {
            FrsGameRankInfoData frsGameRankInfoData = new FrsGameRankInfoData();
            frsGameRankInfoData.icon = recreationRankInfo.icon;
            frsGameRankInfoData.rankName = recreationRankInfo.rank_name;
            frsGameRankInfoData.rankScore = recreationRankInfo.rank_score.intValue();
            frsGameRankInfoData.rankLink = recreationRankInfo.rank_link;
            frsGameRankInfoData.rankIcon = recreationRankInfo.rank_icon;
            frsGameRankInfoData.rankColor = recreationRankInfo.rank_color;
            frsGameRankInfoData.showType = recreationRankInfo.show_type.intValue();
            return frsGameRankInfoData;
        }
        return (FrsGameRankInfoData) invokeL.objValue;
    }
}
