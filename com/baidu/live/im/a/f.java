package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class f extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        super(context, com.baidu.live.im.a.aYr);
    }

    @Override // com.baidu.live.im.a.b
    protected void Jy() {
        if (Jz()) {
            JA();
        } else {
            JB();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Jz()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.d.sdk_common_color_10034);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean equals = aVar instanceof com.baidu.live.im.a ? ((com.baidu.live.im.a) aVar).Iu().equals(aVar.JK().userId) : false;
        if (equals) {
            com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(cVar2, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, aVar.JK(), cVar, equals, true, true);
        if (equals) {
            bQ(false);
        }
        String content = aVar.getContent();
        SpannableString valueOf = SpannableString.valueOf(content);
        if (content != null) {
            valueOf.setSpan(new ForegroundColorSpan(-1), 0, content.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
