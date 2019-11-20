package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class g extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        super(context, com.baidu.live.im.a.aet);
    }

    @Override // com.baidu.live.im.a.b
    protected void ta() {
        if (tb()) {
            tc();
        } else {
            td();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (tb()) {
            return -1647769;
        }
        return this.mContext.getResources().getColor(a.d.sdk_cp_cont_d);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.tf(), cVar, false, false);
        String string = this.mContext.getString(a.i.ala_zan_content);
        SpannableString valueOf = SpannableString.valueOf(string);
        if (string != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, string.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
