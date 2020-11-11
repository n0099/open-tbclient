package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class g extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        super(context, com.baidu.live.im.a.bhn);
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
            return -6574339;
        }
        return this.mContext.getResources().getColor(a.c.sdk_cp_cont_d);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.Mo(), aVar2, false, false);
        String string = this.mContext.getString(a.h.ala_zan_content);
        SpannableString valueOf = SpannableString.valueOf(string);
        if (string != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, string.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
