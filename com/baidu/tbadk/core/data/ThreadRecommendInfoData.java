package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes3.dex */
public class ThreadRecommendInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo backgroundColor;
    public String forumAvatar;
    public String forumName;
    public String jumpLink;
    public String recommendIcon;
    public String recommendReason;
    public ThemeColorInfo recommendReasonColor;
    public String recommendTail;
    public long recommendTopicId;
    public String recommendType;
    public ThemeColorInfo recommendTypeColor;
    public int showNum;
    public String showType;
    public ThemeColorInfo stripColor;

    public ThreadRecommendInfoData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                this.forumAvatar = jSONObject.optString(IntentConfig.FORUM_AVATAR);
                this.forumName = jSONObject.optString("forum_name");
                this.showNum = jSONObject.optInt("show_num");
                this.showType = jSONObject.optString(RecordVideoActivityConfig.SHOW_TYPE);
                this.recommendReason = jSONObject.optString("recommend_reason");
                this.recommendTopicId = jSONObject.optLong("topic_id");
                this.jumpLink = jSONObject.optString("jump_link");
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void parseProto(ThreadRecommendInfo threadRecommendInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadRecommendInfo) != null) || threadRecommendInfo == null) {
            return;
        }
        this.forumAvatar = threadRecommendInfo.forum_avatar;
        this.forumName = threadRecommendInfo.forum_name;
        this.showNum = threadRecommendInfo.show_num.intValue();
        this.showType = threadRecommendInfo.show_type;
        this.recommendReason = threadRecommendInfo.recommend_reason;
        this.recommendTopicId = threadRecommendInfo.topic_id.longValue();
        this.recommendType = threadRecommendInfo.recommend_type;
        this.recommendTail = threadRecommendInfo.recommend_tail;
        this.recommendIcon = threadRecommendInfo.recommend_icon;
        this.recommendTypeColor = threadRecommendInfo.recommend_type_color;
        this.recommendReasonColor = threadRecommendInfo.recommend_reason_color;
        this.stripColor = threadRecommendInfo.strip_color;
        this.backgroundColor = threadRecommendInfo.background_color;
        this.jumpLink = threadRecommendInfo.jump_link;
    }
}
