package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int adE;
    private int adF;
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
        this.adE = t.f.transparent_bg;
        this.adF = t.d.cp_bg_line_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.adF);
        setDefaultResource(this.adE);
        setDefaultErrorResource(t.f.icon_default_avatar100);
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
        ae(str, String.valueOf(str) + getResources().getString(t.j.whose_head_image));
    }

    public void ae(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void vU() {
        if (!this.aGt) {
            this.aGt = true;
        } else if (this.aGw != null && this.aGw.aCi) {
            this.aGw.Gi();
        }
    }
}
