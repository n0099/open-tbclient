package com.baidu.tbadk.ala;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tieba.py4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
/* loaded from: classes3.dex */
public class AlaLiveUserInfoData extends py4 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3860430259513905402L;
    public transient /* synthetic */ FieldHolder $fh;
    public long alaId;
    public long anchorLive;
    public long charmCount;
    public String description;
    public long enterLive;
    public String greatAnchorDescGrade;
    public String greatAnchorDescRole;
    public String greatAnchorIcon;
    public int isOfficial;
    public double lat;
    public long levelExp;
    public int levelId;
    public long liveId;
    public int liveStatus;
    public double lng;
    public String location;
    public String portrait;
    public String sex;
    public int updateTime;
    public String userName;
    public String verifyStatus;

    @Override // com.baidu.tieba.py4
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    public AlaLiveUserInfoData() {
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

    public void convertFromAlaUserInfoData(AlaUserInfoData alaUserInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, alaUserInfoData) != null) || alaUserInfoData == null) {
            return;
        }
        this.alaId = alaUserInfoData.ala_id;
        this.userName = alaUserInfoData.user_name;
        this.portrait = alaUserInfoData.portrait;
        this.description = alaUserInfoData.description;
        this.sex = alaUserInfoData.sex;
        this.enterLive = alaUserInfoData.enter_live;
        this.anchorLive = alaUserInfoData.anchor_live;
        this.liveStatus = alaUserInfoData.live_status;
        this.liveId = alaUserInfoData.live_id;
        this.location = alaUserInfoData.location;
        this.lng = alaUserInfoData.lng;
        this.lat = alaUserInfoData.lat;
        this.updateTime = alaUserInfoData.update_time;
        this.charmCount = alaUserInfoData.charm_count;
        this.levelExp = alaUserInfoData.level_exp;
        this.isOfficial = alaUserInfoData.is_official;
        this.verifyStatus = alaUserInfoData.verify_status;
        this.levelId = alaUserInfoData.level_id;
        this.greatAnchorIcon = alaUserInfoData.great_anchor_icon;
        this.greatAnchorDescGrade = alaUserInfoData.great_anchor_desc_grade;
        this.greatAnchorDescRole = alaUserInfoData.great_anchor_desc_role;
    }

    public void parserProtoBuf(AlaUserInfo alaUserInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaUserInfo) != null) || alaUserInfo == null) {
            return;
        }
        this.alaId = alaUserInfo.ala_id.longValue();
        this.userName = alaUserInfo.user_name;
        this.portrait = alaUserInfo.portrait;
        this.description = alaUserInfo.description;
        this.sex = alaUserInfo.sex;
        this.enterLive = alaUserInfo.enter_live.longValue();
        this.anchorLive = alaUserInfo.anchor_live.longValue();
        this.liveStatus = alaUserInfo.live_status.intValue();
        this.liveId = alaUserInfo.live_id.longValue();
        this.location = alaUserInfo.location;
        this.lng = alaUserInfo.lng.doubleValue();
        this.lat = alaUserInfo.lat.doubleValue();
        this.updateTime = alaUserInfo.update_time.intValue();
        this.charmCount = alaUserInfo.charm_count.longValue();
        this.levelExp = alaUserInfo.level_exp.longValue();
        this.isOfficial = alaUserInfo.is_official.intValue();
        this.verifyStatus = alaUserInfo.verify_status;
        this.levelId = alaUserInfo.level_id.intValue();
        this.greatAnchorIcon = alaUserInfo.great_anchor_icon;
        this.greatAnchorDescGrade = alaUserInfo.great_anchor_desc_grade;
        this.greatAnchorDescRole = alaUserInfo.great_anchor_desc_role;
    }
}
