package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes.dex */
public class g {
    public String dvP;
    public Integer dvQ;
    private int urlType;
    private static final String DEFAULT_TITLE = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    private static final String DEFAULT_TIPS = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    private static final String dvL = TbadkCoreApplication.getInst().getString(R.string.cancel);
    private static final String dvM = TbadkCoreApplication.getInst().getString(R.string.check_immediately);
    private String title = "";
    private String img = "";
    private String tips = "";
    private String url = "";
    private String dvN = "";
    private String dvO = "";
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
                    this.dvQ = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.url = com.baidu.tieba.aiapps.a.a(this.appId, optString, "9104", this.dvQ);
                    this.dvP = jSONObject.optString("swan_app_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.dvN = StringUtils.isNull(dataRes.btn_sure) ? dvM : dataRes.btn_sure;
            this.dvO = StringUtils.isNull(dataRes.btn_cancel) ? dvL : dataRes.btn_cancel;
        } else if (this.urlType == 2) {
            this.title = dataRes.title;
            this.url = dataRes.url;
        } else if (this.urlType != 4 && this.urlType == 3) {
            this.url = dataRes.url;
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.dvN = dataRes.btn_sure;
            this.dvO = dataRes.btn_cancel;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getImg() {
        return this.img;
    }

    public String getTips() {
        return this.tips;
    }

    public String getUrl() {
        return this.url;
    }

    public String aLy() {
        return this.dvN;
    }

    public String aLz() {
        return this.dvO;
    }

    public int aLA() {
        return this.urlType;
    }
}
