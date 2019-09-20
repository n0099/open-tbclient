package com.baidu.tbadk.BdToken;

import tbclient.GetToken.DataRes;
/* loaded from: classes.dex */
public class v {
    private a bAA;
    private String btn_cancel;
    private String btn_sure;
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
                this.bAA = new a();
                this.bAA.url = dataRes.activity_done.url;
                this.bAA.btntext = dataRes.activity_done.btntext;
                this.bAA.message = dataRes.activity_done.message;
                this.bAA.sharetoken = dataRes.activity_done.sharetoken;
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public a ZX() {
        return this.bAA;
    }
}
