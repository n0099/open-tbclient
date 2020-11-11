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
        super(context, com.baidu.live.im.a.bhk);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Mb() {
        if (Mc()) {
            Md();
        } else {
            Me();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (Mc()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.c.sdk_common_color_10034);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (aVar instanceof com.baidu.live.im.a) {
            z = !"0".equals(aVar.Mo().userId) && ((com.baidu.live.im.a) aVar).KY().equals(aVar.Mo().userId);
        } else {
            z = false;
        }
        if (z) {
            com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(bVar, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, aVar.Mo(), aVar2, z, true, true);
        if (z) {
            bY(false);
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
