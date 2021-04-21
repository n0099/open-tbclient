package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import d.b.j0.x.e0.c;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes3.dex */
public class PbLinkData extends c implements Serializable {
    public String extTxt;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public int sort;
    public String title;
    public int urlType;

    public void parseJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.optString("title");
            this.linkUrl = jSONObject.optString("to_url");
            this.picUrl = jSONObject.optString("pic_url");
            this.linkFrom = jSONObject.optString("link_from");
            this.extTxt = jSONObject.optString("ext_txt");
            this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
            this.urlType = jSONObject.optInt("url_type");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void parseProto(PbLinkInfo pbLinkInfo) {
        if (pbLinkInfo == null) {
            return;
        }
        this.title = pbLinkInfo.title;
        this.linkUrl = pbLinkInfo.to_url;
        this.picUrl = pbLinkInfo.pic_url;
        this.linkFrom = pbLinkInfo.link_from;
        this.extTxt = pbLinkInfo.ext_txt;
        this.sort = pbLinkInfo.sort.intValue();
        this.urlType = pbLinkInfo.url_type.intValue();
    }

    @Override // d.b.j0.x.e0.c
    public int sort() {
        return this.sort;
    }
}
