package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes.dex */
public class g {
    public String bSB;
    public Integer bSC;
    private int urlType;
    private static final String DEFAULT_TITLE = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    private static final String DEFAULT_TIPS = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    private static final String bSx = TbadkCoreApplication.getInst().getString(R.string.cancel);
    private static final String bSy = TbadkCoreApplication.getInst().getString(R.string.check_immediately);
    private String title = "";
    private String img = "";
    private String tips = "";
    private String url = "";
    private String bSz = "";
    private String bSA = "";
    public String appId = "";
    public String appName = "";

    public void a(DataRes dataRes) {
        this.urlType = dataRes.type.intValue();
        if (this.urlType == 0 || this.urlType == 1) {
            this.title = StringUtils.isNull(dataRes.title) ? DEFAULT_TITLE : dataRes.title;
            this.img = dataRes.img;
            this.tips = StringUtils.isNull(dataRes.tips) ? DEFAULT_TIPS : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.appId = jSONObject.optString("appid");
                    this.appName = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    this.bSC = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.url = com.baidu.tieba.aiapps.a.a(this.appId, optString, "9104", this.bSC);
                    this.bSB = jSONObject.optString("swan_app_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bSz = StringUtils.isNull(dataRes.btn_sure) ? bSy : dataRes.btn_sure;
            this.bSA = StringUtils.isNull(dataRes.btn_cancel) ? bSx : dataRes.btn_cancel;
        } else if (this.urlType == 2) {
            this.title = dataRes.title;
            this.url = dataRes.url;
        } else if (this.urlType != 4 && this.urlType == 3) {
            this.url = dataRes.url;
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.bSz = dataRes.btn_sure;
            this.bSA = dataRes.btn_cancel;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String aer() {
        return this.img;
    }

    public String getTips() {
        return this.tips;
    }

    public String getUrl() {
        return this.url;
    }

    public String aes() {
        return this.bSz;
    }

    public String aet() {
        return this.bSA;
    }

    public int aeu() {
        return this.urlType;
    }
}
