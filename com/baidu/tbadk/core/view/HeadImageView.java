package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class HeadImageView extends TbImageView {
    private String d;
    private String e;
    private String f;

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
        g();
    }

    private void g() {
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
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
