package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class g extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        super(context, com.baidu.live.im.a.blx);
    }

    @Override // com.baidu.live.im.a.b
    protected void KC() {
        if (KD()) {
            KE();
        } else {
            KF();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (KD()) {
            return -7479041;
        }
        return this.mContext.getResources().getColor(a.c.sdk_cp_cont_d);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder b(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, bVar.Lc(), cVar, false, false);
        String string = this.mContext.getString(a.h.ala_zan_content);
        SpannableString valueOf = SpannableString.valueOf(string);
        if (string != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, string.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
