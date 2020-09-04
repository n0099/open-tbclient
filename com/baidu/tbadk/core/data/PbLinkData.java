package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes.dex */
public class PbLinkData extends com.baidu.tieba.card.data.d implements Serializable {
    public String extTxt;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public int sort;
    public String title;
    public int urlType;

    public void parseProto(PbLinkInfo pbLinkInfo) {
        if (pbLinkInfo != null) {
            this.title = pbLinkInfo.title;
            this.linkUrl = pbLinkInfo.to_url;
            this.picUrl = pbLinkInfo.pic_url;
            this.linkFrom = pbLinkInfo.link_from;
            this.extTxt = pbLinkInfo.ext_txt;
            this.sort = pbLinkInfo.sort.intValue();
            this.urlType = pbLinkInfo.url_type.intValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.optString("title");
            this.linkUrl = jSONObject.optString("to_url");
            this.picUrl = jSONObject.optString("pic_url");
            this.linkFrom = jSONObject.optString("link_from");
            this.extTxt = jSONObject.optString("ext_txt");
            this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
            this.urlType = jSONObject.optInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.tieba.card.data.d
    public int sort() {
        return this.sort;
    }
}
