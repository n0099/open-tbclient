package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes.dex */
public class PbLinkData implements Serializable {
    public String linkUrl;
    public String picUrl;
    public String title;

    public void parseProto(PbLinkInfo pbLinkInfo) {
        if (pbLinkInfo != null) {
            this.title = pbLinkInfo.title;
            this.linkUrl = pbLinkInfo.to_url;
            this.picUrl = pbLinkInfo.pic_url;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.optString("title");
            this.linkUrl = jSONObject.optString("to_url");
            this.picUrl = jSONObject.optString("pic_url");
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
