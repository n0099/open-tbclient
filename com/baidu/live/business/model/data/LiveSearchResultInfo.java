package com.baidu.live.business.model.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSearchResultInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String audienceCount;
    public String avatar;
    public String cmd;
    public String description;
    public String displayName;
    public String feedId;
    public boolean hasFollowed;
    public boolean hasLiving;
    public String liveType;
    public String question;
    public String roomId;
    public String sid;
    public String ssid;
    public LiveStatInfo statInfo;
    public String status;
    public String templateId;
    public String thirdId;
    public String tpl;
    public String type;
    public String uid;
    public String uk;
    public String yyuid;

    public LiveSearchResultInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.question = "";
        this.displayName = "百度";
        this.avatar = "";
        this.audienceCount = "";
        this.roomId = "";
        this.cmd = "";
        this.description = "";
        this.hasFollowed = false;
        this.hasLiving = false;
        this.feedId = "";
        this.liveType = "";
        this.yyuid = "";
        this.sid = "";
        this.ssid = "";
        this.tpl = "";
        this.templateId = "";
        this.uid = "";
        this.thirdId = "";
        this.type = "";
        this.status = "";
        this.uk = "";
    }

    public boolean isHasFollowed(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) ? jSONObject.optString("has_follow").equals("1") : invokeL.booleanValue;
    }

    public boolean isHasLiving(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? jSONObject.optString(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS).equals("1") : invokeL.booleanValue;
    }

    public void parseJSONObj(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.question = jSONObject.optString("q");
            this.displayName = jSONObject.optString("name");
            this.avatar = jSONObject.optString("avatar");
            this.audienceCount = jSONObject.optString("AudienceCount");
            this.roomId = jSONObject.optString("room_id");
            this.cmd = jSONObject.optString("cmd");
            this.description = jSONObject.optString("description");
            this.hasFollowed = isHasFollowed(jSONObject);
            this.hasLiving = isHasLiving(jSONObject);
            this.status = jSONObject.optString(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
            this.feedId = jSONObject.optString("feed_id");
            this.uid = jSONObject.optString("user_id");
            this.uk = jSONObject.optString("uk");
            this.thirdId = jSONObject.optString("third_id");
            this.type = jSONObject.optString("type");
            JSONObject optJSONObject = jSONObject.optJSONObject("stat");
            if (optJSONObject != null) {
                this.liveType = optJSONObject.optString("live_type");
                this.yyuid = optJSONObject.optString(TiebaStatic.YYParams.YYUID);
                this.sid = optJSONObject.optString("sid");
                this.ssid = optJSONObject.optString("ssid");
                this.tpl = optJSONObject.optString("tpl");
                this.templateId = optJSONObject.optString("template_id");
                LiveStatInfo liveStatInfo = new LiveStatInfo();
                this.statInfo = liveStatInfo;
                liveStatInfo.parserJson(optJSONObject);
            }
        }
    }
}
