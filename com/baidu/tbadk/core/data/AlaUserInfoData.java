package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
/* loaded from: classes3.dex */
public class AlaUserInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long ala_id;
    public int anchor_fans;
    public long anchor_live;
    public long charm_count;
    public String description;
    public long enter_live;
    public String great_anchor_desc_grade;
    public String great_anchor_desc_role;
    public String great_anchor_icon;
    public int is_official;
    public double lat;
    public long level_exp;
    public int level_id;
    public String level_name;
    public long live_id;
    public int live_status;
    public double lng;
    public String location;
    public String portrait;
    public String sex;
    public int update_time;
    public long user_id;
    public String user_name;
    public String verify_status;

    public AlaUserInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void parserProtobuf(AlaUserInfo alaUserInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaUserInfo) == null) || alaUserInfo == null) {
            return;
        }
        try {
            this.ala_id = alaUserInfo.ala_id.longValue();
            this.user_name = alaUserInfo.user_name;
            this.portrait = alaUserInfo.portrait;
            this.anchor_live = alaUserInfo.anchor_live.longValue();
            this.enter_live = alaUserInfo.enter_live.longValue();
            this.description = alaUserInfo.description;
            this.sex = alaUserInfo.sex;
            this.live_status = alaUserInfo.live_status.intValue();
            this.live_id = alaUserInfo.live_id.longValue();
            this.location = alaUserInfo.location;
            this.update_time = alaUserInfo.update_time.intValue();
            this.charm_count = alaUserInfo.charm_count.longValue();
            this.level_exp = alaUserInfo.level_exp.longValue();
            this.is_official = alaUserInfo.is_official.intValue();
            this.verify_status = alaUserInfo.verify_status;
            this.level_id = alaUserInfo.level_id.intValue();
            this.great_anchor_icon = alaUserInfo.great_anchor_icon;
            this.great_anchor_desc_grade = alaUserInfo.great_anchor_desc_grade;
            this.great_anchor_desc_role = alaUserInfo.great_anchor_desc_role;
            this.lng = alaUserInfo.lng.doubleValue();
            this.lat = alaUserInfo.lat.doubleValue();
            this.user_id = alaUserInfo.user_id.longValue();
            this.anchor_fans = alaUserInfo.anchor_fans.intValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.ala_id = jSONObject.optLong("ala_id");
            this.user_name = jSONObject.optString("user_name");
            this.portrait = jSONObject.optString("portrait");
            this.enter_live = jSONObject.optLong("enter_live");
            this.anchor_live = jSONObject.optLong("anchor_live");
            this.description = jSONObject.optString("description");
            this.sex = jSONObject.optString("sex");
            this.live_status = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
            this.live_id = jSONObject.optLong("live_id");
            this.location = jSONObject.optString("location");
            this.update_time = jSONObject.optInt("update_time");
            this.charm_count = jSONObject.optLong("charm_count");
            this.level_exp = jSONObject.optLong("level_exp");
            this.is_official = jSONObject.optInt("is_official");
            this.verify_status = jSONObject.optString("verify_status");
            this.level_id = jSONObject.optInt("level_id");
            this.level_name = jSONObject.optString("level_name");
            this.great_anchor_icon = jSONObject.optString("great_anchor_icon");
            this.great_anchor_desc_grade = jSONObject.optString("great_anchor_desc_grade");
            this.great_anchor_desc_role = jSONObject.optString("great_anchor_desc_role");
            this.lng = jSONObject.optDouble(SuggestAddrField.KEY_LNG);
            this.lat = jSONObject.optDouble(SuggestAddrField.KEY_LAT);
            this.user_id = jSONObject.optLong("user_id");
            this.anchor_fans = jSONObject.optInt("anchor_fans");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
