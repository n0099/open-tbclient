package com.baidu.tbadk.BdToken;

import tbclient.GetToken.DataRes;
/* loaded from: classes.dex */
public class f {
    private String btn_cancel;
    private String btn_sure;
    private String img;
    private String tips;
    private String title;
    private String url;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.title = dataRes.title;
            this.img = dataRes.img;
            this.tips = dataRes.tips;
            this.url = dataRes.url;
            this.btn_sure = dataRes.btn_sure;
            this.btn_cancel = dataRes.btn_cancel;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }
}
