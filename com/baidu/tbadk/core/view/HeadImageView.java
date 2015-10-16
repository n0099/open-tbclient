package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int acS;
    private int acT;
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
        this.acS = i.e.icon_default_avatar100;
        this.acT = i.c.cp_cont_e;
        init();
    }

    private void init() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.acT);
        setDefaultResource(this.acS);
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
    public void vr() {
        if (!this.aAV) {
            this.aAV = true;
        } else if (this.aAY != null && this.aAY.axr) {
            this.aAY.DT();
        }
    }
}
