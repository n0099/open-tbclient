package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes.dex */
public class g {
    private int urlType;
    private static final String DEFAULT_TITLE = TbadkCoreApplication.getInst().getString(d.j.tb_token);
    private static final String DEFAULT_TIPS = TbadkCoreApplication.getInst().getString(d.j.tb_ai_apps_tips);
    private static final String brT = TbadkCoreApplication.getInst().getString(d.j.cancel);
    private static final String brU = TbadkCoreApplication.getInst().getString(d.j.check_immediately);
    private String title = "";
    private String img = "";
    private String tips = "";
    private String url = "";
    private String brV = "";
    private String brW = "";
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
                    this.url = com.baidu.tieba.aiapps.a.G(this.appId, jSONObject.optString("url"), "9104");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.brV = StringUtils.isNull(dataRes.btn_sure) ? brU : dataRes.btn_sure;
            this.brW = StringUtils.isNull(dataRes.btn_cancel) ? brT : dataRes.btn_cancel;
        } else if (this.urlType == 2) {
            this.title = dataRes.title;
            this.url = dataRes.url;
        } else if (this.urlType != 4 && this.urlType == 3) {
            this.url = dataRes.url;
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.brV = dataRes.btn_sure;
            this.brW = dataRes.btn_cancel;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String Uk() {
        return this.img;
    }

    public String getTips() {
        return this.tips;
    }

    public String getUrl() {
        return this.url;
    }

    public String Ul() {
        return this.brV;
    }

    public String Um() {
        return this.brW;
    }

    public int Un() {
        return this.urlType;
    }
}
