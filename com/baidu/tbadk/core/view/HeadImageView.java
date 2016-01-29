package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int afa;
    private int afb;
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
        this.afa = t.f.icon_default_avatar100;
        this.afb = t.d.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.afb);
        setDefaultResource(this.afa);
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
        this.user_name = str;
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wQ() {
        if (!this.aEq) {
            this.aEq = true;
        } else if (this.aEt != null && this.aEt.aAD) {
            this.aEt.FQ();
        }
    }
}
