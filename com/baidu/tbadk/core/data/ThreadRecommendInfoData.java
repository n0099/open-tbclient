package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes3.dex */
public class ThreadRecommendInfoData implements Serializable {
    public String forumAvatar;
    public String forumName;
    public String recommendReason;
    public int showNum;
    public String showType;

    public void parseJson(JSONObject jSONObject) {
        try {
            this.forumAvatar = jSONObject.optString(IntentConfig.FORUM_AVATAR);
            this.forumName = jSONObject.optString("forum_name");
            this.showNum = jSONObject.optInt("show_num");
            this.showType = jSONObject.optString(RecordVideoActivityConfig.SHOW_TYPE);
            this.recommendReason = jSONObject.optString("recommend_reason");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void parseProto(ThreadRecommendInfo threadRecommendInfo) {
        if (threadRecommendInfo == null) {
            return;
        }
        this.forumAvatar = threadRecommendInfo.forum_avatar;
        this.forumName = threadRecommendInfo.forum_name;
        this.showNum = threadRecommendInfo.show_num.intValue();
        this.showType = threadRecommendInfo.show_type;
        this.recommendReason = threadRecommendInfo.recommend_reason;
    }
}
