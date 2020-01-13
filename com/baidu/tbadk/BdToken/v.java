package com.baidu.tbadk.BdToken;

import tbclient.GetToken.DataRes;
/* loaded from: classes.dex */
public class v {
    private String btn_cancel;
    private String btn_sure;
    private a cEZ;
    private String img;
    private String tips;
    private String title;
    private String url;

    /* loaded from: classes.dex */
    public static class a {
        public String btntext;
        public String message;
        public String sharetoken;
        public String url;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.url = dataRes.url;
            this.btn_sure = dataRes.btn_sure;
            this.btn_cancel = dataRes.btn_cancel;
            if (dataRes.activity_done != null) {
                this.cEZ = new a();
                this.cEZ.url = dataRes.activity_done.url;
                this.cEZ.btntext = dataRes.activity_done.btntext;
                this.cEZ.message = dataRes.activity_done.message;
                this.cEZ.sharetoken = dataRes.activity_done.sharetoken;
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public a avW() {
        return this.cEZ;
    }
}
