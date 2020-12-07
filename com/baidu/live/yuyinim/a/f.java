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
        super(context, com.baidu.live.im.a.bjO);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Nx() {
        if (Ny()) {
            Nz();
        } else {
            NA();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        if (Ny()) {
            return -1;
        }
        return this.mContext.getResources().getColor(a.c.sdk_common_color_10034);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (bVar instanceof com.baidu.live.im.a) {
            z = !"0".equals(bVar.NU().userId) && ((com.baidu.live.im.a) bVar).Mr().equals(bVar.NU().userId);
        } else {
            z = false;
        }
        if (z) {
            com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, a.e.icon_im_anchor);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.setSpan(bVar2, 0, 1, 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, bVar.NU(), aVar, z, true, true);
        if (z) {
            cj(false);
        }
        String content = bVar.getContent();
        SpannableString valueOf = SpannableString.valueOf(content);
        if (content != null) {
            valueOf.setSpan(new ForegroundColorSpan(-1), 0, content.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
