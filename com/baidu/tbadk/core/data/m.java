package com.baidu.tbadk.core.data;

import tbclient.FrsPage.CarrierEnter;
/* loaded from: classes.dex */
public class m {
    private String headline_cover;
    private String obj_id;
    private String text;
    private String title;
    private String url;

    public void a(CarrierEnter carrierEnter) {
        if (carrierEnter != null) {
            this.title = carrierEnter.title;
            this.text = carrierEnter.text;
            this.headline_cover = carrierEnter.headline_cover;
            this.url = carrierEnter.url;
            this.obj_id = carrierEnter.obj_id;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public String pG() {
        return this.headline_cover;
    }

    public String getUrl() {
        return this.url;
    }

    public String pH() {
        return this.obj_id;
    }
}
