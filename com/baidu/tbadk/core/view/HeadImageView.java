package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.j {
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = com.baidu.tieba.t.icon_default_avatar100;
        this.h = com.baidu.tieba.t.icon_default_avatar100_1;
        this.i = com.baidu.tieba.r.cp_cont_e;
        this.j = com.baidu.tieba.r.cp_cont_e_1;
        g();
    }

    private void g() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.i);
        setNightDefaultBgResource(this.j);
        setDefaultResource(this.g);
        setNightDefaultResource(this.h);
    }

    public void setUrl(String str) {
        this.f = str;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.f;
    }

    public void setUserId(String str) {
        this.d = str;
    }

    public String getUserId() {
        return this.d;
    }

    public void setUserName(String str) {
        this.e = str;
    }

    public String getUserName() {
        return this.e;
    }
}
