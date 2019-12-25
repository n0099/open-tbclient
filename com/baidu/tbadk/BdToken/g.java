package com.baidu.tbadk.BdToken;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes.dex */
public class g {
    public String cEk;
    public Integer cEl;
    private int urlType;
    private static final String DEFAULT_TITLE = TbadkCoreApplication.getInst().getString(R.string.tb_token);
    private static final String DEFAULT_TIPS = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
    private static final String cEg = TbadkCoreApplication.getInst().getString(R.string.cancel);
    private static final String cEh = TbadkCoreApplication.getInst().getString(R.string.check_immediately);
    private String title = "";
    private String img = "";
    private String tips = "";
    private String url = "";
    private String cEi = "";
    private String cEj = "";
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
                    this.cEl = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.url = com.baidu.tieba.aiapps.a.a(this.appId, optString, "9104", this.cEl);
                    this.cEk = jSONObject.optString("swan_app_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.cEi = StringUtils.isNull(dataRes.btn_sure) ? cEh : dataRes.btn_sure;
            this.cEj = StringUtils.isNull(dataRes.btn_cancel) ? cEg : dataRes.btn_cancel;
        } else if (this.urlType == 2) {
            this.title = dataRes.title;
            this.url = dataRes.url;
        } else if (this.urlType != 4 && this.urlType == 3) {
            this.url = dataRes.url;
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.cEi = dataRes.btn_sure;
            this.cEj = dataRes.btn_cancel;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String avi() {
        return this.img;
    }

    public String getTips() {
        return this.tips;
    }

    public String getUrl() {
        return this.url;
    }

    public String avj() {
        return this.cEi;
    }

    public String avk() {
        return this.cEj;
    }

    public int avl() {
        return this.urlType;
    }
}
