package com.baidu.tbadk.BdToken;

import tbclient.GetToken.DataRes;
/* loaded from: classes2.dex */
public class x {
    private String btn_cancel;
    private String btn_sure;
    private a dQz;
    private String img;
    private String tips;
    private String title;
    private String url;

    /* loaded from: classes2.dex */
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
                this.dQz = new a();
                this.dQz.url = dataRes.activity_done.url;
                this.dQz.btntext = dataRes.activity_done.btntext;
                this.dQz.message = dataRes.activity_done.message;
                this.dQz.sharetoken = dataRes.activity_done.sharetoken;
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public a aZA() {
        return this.dQz;
    }
}
