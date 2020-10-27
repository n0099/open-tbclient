package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class f extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        super(context, com.baidu.live.im.a.bfQ);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void LB() {
        if (LC()) {
            LD();
        } else {
            LE();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (LC()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.d.sdk_common_color_10034);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (aVar instanceof com.baidu.live.im.a) {
            z = !"0".equals(aVar.LO().userId) && ((com.baidu.live.im.a) aVar).Ky().equals(aVar.LO().userId);
        } else {
            z = false;
        }
        if (z) {
            com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.mContext, a.f.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(cVar, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, aVar.LO(), aVar2, z, true, true);
        if (z) {
            bX(false);
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
