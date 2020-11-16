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
        super(context, com.baidu.live.im.a.bfy);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Ls() {
        if (Lt()) {
            Lu();
        } else {
            Lv();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (Lt()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.c.sdk_common_color_10034);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (aVar instanceof com.baidu.live.im.a) {
            z = !"0".equals(aVar.LF().userId) && ((com.baidu.live.im.a) aVar).Kp().equals(aVar.LF().userId);
        } else {
            z = false;
        }
        if (z) {
            com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(bVar, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, aVar.LF(), aVar2, z, true, true);
        if (z) {
            ca(false);
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
