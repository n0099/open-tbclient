package com.baidu.live.utils;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes7.dex */
public class a extends ClickableSpan {
    private int mColor;
    private String mUrl;

    public a(String str, int i) {
        this.mUrl = str;
        this.mColor = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.mUrl)) {
            UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(view.getContext()), new String[]{this.mUrl}, true);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(true);
    }
}
