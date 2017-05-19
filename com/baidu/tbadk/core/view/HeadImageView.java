package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.e {
    private int ahN;
    private int ahO;
    private String mUrl;
    private String user_id;
    private String user_name;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.ahN = w.g.transparent_bg;
        this.ahO = w.e.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ahO);
        setDefaultResource(this.ahN);
        setDefaultErrorResource(w.g.icon_default_avatar100);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.mUrl;
    }

    public void setUserId(String str) {
        this.user_id = str;
    }

    public String getUserId() {
        return this.user_id;
    }

    public void setUserName(String str) {
        ad(str, String.valueOf(str) + getResources().getString(w.l.somebodys_portrait));
    }

    public void ad(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void vW() {
        if (!this.aKP) {
            this.aKP = true;
        } else if (this.aKS != null && this.aKS.aGB) {
            this.aKS.FD();
        }
    }
}
