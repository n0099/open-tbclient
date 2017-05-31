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
    private TextView alx;
    private TextView amd;
    private LinearLayout ame;
    private boolean amf;
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
        this.ame = (LinearLayout) this.mView.findViewById(w.h.god_comment_layout);
        this.amd = (TextView) this.mView.findViewById(w.h.god_reply_content);
        this.alx = (TextView) this.mView.findViewById(w.h.praise_num);
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        setPraised(postData.bit());
        aM(postData.bit());
    }

    public void a(PostData postData) {
        if (this.amd == null || postData.avd() == null) {
            setVisibility(8);
            return;
        }
        String bU = postData.bU(this.mContext);
        this.content = bU;
        if (com.baidu.tbadk.core.util.au.isEmpty(bU)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.amd.setText(dR(bU));
    }

    private SpannableStringBuilder dR(String str) {
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
        if (this.alx != null && postData != null) {
            this.alx.setText(com.baidu.tbadk.core.util.au.u(postData.bis() >= 0 ? (int) postData.bis() : 0L));
        }
    }

    private void aM(boolean z) {
        Drawable drawable;
        if (z) {
            drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_floor_praised);
        } else {
            drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_floor_praise_n);
        }
        this.alx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.alx.setGravity(16);
    }

    private void setPraised(boolean z) {
        this.amf = z;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.k(this.ame, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.amd, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.i(this.alx, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.aq.i(this.amd, w.e.cp_cont_f);
        this.amd.setText(dR(this.content));
        aM(this.amf);
    }

    public TextView getGodReplyContent() {
        return this.amd;
    }

    public TextView getPraiseNum() {
        return this.alx;
    }
}
