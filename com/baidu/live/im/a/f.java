package com.baidu.live.im.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class f extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        super(context, com.baidu.live.im.a.aeq);
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
            return -1;
        }
        return this.mContext.getResources().getColor(a.d.sdk_common_color_10034);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean equals = aVar instanceof com.baidu.live.im.a ? ((com.baidu.live.im.a) aVar).sd().equals(aVar.tf().userId) : false;
        a(spannableStringBuilder, aVar.tf(), cVar, equals, true, true);
        String content = aVar.getContent();
        SpannableString valueOf = SpannableString.valueOf(content);
        if (content != null) {
            if (equals) {
                valueOf.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(a.d.sdk_cp_other_b)), 0, content.length(), 33);
            } else {
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, content.length(), 33);
            }
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        return spannableStringBuilder;
    }
}
