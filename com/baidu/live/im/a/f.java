package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        super(context, com.baidu.live.im.a.aPe);
    }

    @Override // com.baidu.live.im.a.b
    protected void Db() {
        if (Dc()) {
            Dd();
        } else {
            De();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Dc()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.d.sdk_common_color_10034);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean equals = aVar instanceof com.baidu.live.im.a ? ((com.baidu.live.im.a) aVar).BP().equals(aVar.DB().userId) : false;
        if (equals) {
            com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, a.f.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(cVar2, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, aVar.DB(), cVar, equals, true, true);
        if (equals) {
            bH(false);
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
