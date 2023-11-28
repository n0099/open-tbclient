package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tieba.ax4;
import com.baidu.tieba.ez4;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SignData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7905612002845096083L;
    public transient /* synthetic */ FieldHolder $fh;
    public BlockPopInfoData blockPopInfoData;
    public int cashBalance;
    public ax4 chatRoomGuideData;
    public int contDays;
    public int count_sign_num;
    public int count_total_sign_num;
    public int errorCode;
    public String errorMsg;
    public String forumId;
    public String forumName;
    public int forum_rank;
    public int getCash;
    public boolean isShowSignToast;
    public int is_signed;
    public int levelup_score;
    public ContriInfo mContriInfo;
    public ez4 mSignStampInfoData;
    public int miss_sign_num;
    public boolean showGuideToChatRoom;
    public int sign_bonus_point;
    public int sign_count;
    public String userInfoJson;
    public int user_sign_rank;

    public SignData() {
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
        this.isShowSignToast = true;
        this.is_signed = 0;
        this.user_sign_rank = 0;
        this.count_sign_num = 0;
        this.count_total_sign_num = 0;
        this.forum_rank = 0;
        this.sign_bonus_point = 3;
        this.sign_count = 0;
        this.miss_sign_num = 0;
        this.errorCode = 0;
        this.errorMsg = "";
        this.mContriInfo = new ContriInfo();
        this.mSignStampInfoData = new ez4();
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(SourceConstant.SOURCE_USER_INFO);
            if (optJSONObject != null) {
                this.userInfoJson = optJSONObject.toString();
                this.is_signed = optJSONObject.optInt("is_sign_in");
                this.user_sign_rank = optJSONObject.optInt("user_sign_rank");
                this.count_sign_num = optJSONObject.optInt("cont_sign_num");
                this.count_total_sign_num = optJSONObject.optInt("cout_total_sing_num");
                this.sign_bonus_point = optJSONObject.optInt("sign_bonus_point");
                this.levelup_score = optJSONObject.optInt("levelup_score");
                this.miss_sign_num = optJSONObject.optInt("miss_sign_num");
                this.getCash = optJSONObject.optInt("get_cash");
                this.cashBalance = optJSONObject.optInt("cash_balance");
                this.contDays = optJSONObject.optInt("cont_days");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
            if (optJSONObject2 != null) {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData = blockPopInfoData;
                blockPopInfoData.block_info = optJSONObject2.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject2.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject2.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject2.optString("block_cancel");
            }
            this.mContriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
            this.mSignStampInfoData.c(jSONObject.optJSONObject("icon_toast"));
            if (jSONObject.optInt("not_show_sign_toast") == 1) {
                this.isShowSignToast = false;
            }
        }
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_sign_in", this.is_signed);
                jSONObject2.put("user_sign_rank", this.user_sign_rank);
                jSONObject2.put("cont_sign_num", this.count_sign_num);
                jSONObject2.put("cout_total_sing_num", this.count_total_sign_num);
                jSONObject2.put("sign_bonus_point", this.sign_bonus_point);
                jSONObject2.put("levelup_score", this.levelup_score);
                jSONObject2.put("miss_sign_num", this.miss_sign_num);
                jSONObject2.put("get_cash", this.getCash);
                jSONObject2.put("cash_balance", this.cashBalance);
                jSONObject2.put("cont_days", this.contDays);
                jSONObject.put(SourceConstant.SOURCE_USER_INFO, jSONObject2);
                if (this.blockPopInfoData != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("block_content", this.blockPopInfoData.block_info);
                    jSONObject3.put("block_confirm", this.blockPopInfoData.ahead_info);
                    jSONObject3.put("block_dealurl", this.blockPopInfoData.ahead_url);
                    jSONObject3.put("block_cancel", this.blockPopInfoData.ok_info);
                    jSONObject.put("info", jSONObject3);
                }
                if (this.mContriInfo != null) {
                    jSONObject.put("contri_info", this.mContriInfo.toJsonObject());
                }
                if (this.mSignStampInfoData != null) {
                    jSONObject.put("icon_toast", this.mSignStampInfoData.d());
                }
                int i2 = 0;
                if (this.isShowSignToast) {
                    i = 0;
                } else {
                    i = 1;
                }
                jSONObject.put("not_show_sign_toast", i);
                if (this.showGuideToChatRoom) {
                    i2 = 1;
                }
                jSONObject.put("has_chatroom_sign", i2);
                if (this.chatRoomGuideData != null) {
                    jSONObject.put("chatroom_sign_info", this.chatRoomGuideData.d());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
