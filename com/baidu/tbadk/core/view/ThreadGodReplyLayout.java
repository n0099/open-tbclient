package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends LinearLayout {
    private TextView alH;
    private TextView amn;
    private LinearLayout amo;
    private boolean amp;
    private String content;
    private Context mContext;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(w.j.thread_god_reply_layout, (ViewGroup) this, true);
        this.amo = (LinearLayout) this.mView.findViewById(w.h.god_comment_layout);
        this.amn = (TextView) this.mView.findViewById(w.h.god_reply_content);
        this.alH = (TextView) this.mView.findViewById(w.h.praise_num);
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        setPraised(postData.bgZ());
        aO(postData.bgZ());
    }

    public void a(PostData postData) {
        if (this.amn == null || postData.aui() == null) {
            setVisibility(8);
            return;
        }
        String bT = postData.bT(this.mContext);
        this.content = bT;
        if (com.baidu.tbadk.core.util.au.isEmpty(bT)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.amn.setText(dU(bT));
    }

    private SpannableStringBuilder dU(String str) {
        if (com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        int color = com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_r);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(w.l.god_reply_prefix));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }

    public void b(PostData postData) {
        if (this.alH != null && postData != null) {
            this.alH.setText(com.baidu.tbadk.core.util.au.u(postData.bgY() >= 0 ? (int) postData.bgY() : 0L));
        }
    }

    private void aO(boolean z) {
        Drawable drawable;
        if (z) {
            drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_floor_praised);
        } else {
            drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_floor_praise_n);
        }
        this.alH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.alH.setGravity(16);
    }

    private void setPraised(boolean z) {
        this.amp = z;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.k(this.amo, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.amn, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.i(this.alH, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.aq.i(this.amn, w.e.cp_cont_f);
        this.amn.setText(dU(this.content));
        aO(this.amp);
    }

    public TextView getGodReplyContent() {
        return this.amn;
    }

    public TextView getPraiseNum() {
        return this.alH;
    }
}
