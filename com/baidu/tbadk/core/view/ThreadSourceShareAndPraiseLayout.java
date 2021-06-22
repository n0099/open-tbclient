package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12544e;

    /* renamed from: f  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f12545f;

    /* renamed from: g  reason: collision with root package name */
    public a2 f12546g;

    /* renamed from: h  reason: collision with root package name */
    public Context f12547h;

    /* renamed from: i  reason: collision with root package name */
    public String f12548i;
    public View.OnClickListener j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadSourceShareAndPraiseLayout.this.f12546g == null || StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.f12546g.i0())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.f12547h).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.f12546g.i0(), ThreadSourceShareAndPraiseLayout.this.f12548i)));
            if (ThreadSourceShareAndPraiseLayout.this.j != null) {
                ThreadSourceShareAndPraiseLayout.this.j.onClick(view);
            }
        }
    }

    public ThreadSourceShareAndPraiseLayout(Context context) {
        super(context);
        e(context);
    }

    public final void e(Context context) {
        if (context == null) {
            return;
        }
        this.f12547h = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
        this.f12544e = (TextView) inflate.findViewById(R.id.view_forum_source);
        this.f12545f = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
        this.f12544e.setOnClickListener(new a());
    }

    public void f() {
        if (!this.k) {
            SkinManager.setViewTextColor(this.f12544e, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f12544e, R.drawable.bg_forum_source_gray);
        }
        if (this.f12545f.getVisibility() == 0) {
            this.f12545f.onChangeSkinType();
        }
    }

    public boolean g(a2 a2Var) {
        if (a2Var == null) {
            setVisibility(8);
            return false;
        }
        this.f12546g = a2Var;
        if (!StringUtils.isNull(a2Var.i0()) && !this.k) {
            TextView textView = this.f12544e;
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f12546g.i0(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.f12544e.setVisibility(0);
        } else {
            this.f12544e.setVisibility(8);
        }
        this.f12545f.setData(this.f12546g);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.f12545f.setForumAfterClickListener(onClickListener);
        this.j = onClickListener;
    }

    public void setFrom(int i2) {
        this.f12545f.setFrom(i2);
    }

    public void setHideBarName(boolean z) {
        this.k = z;
    }

    public void setShareReportFrom(int i2) {
        this.f12545f.setShareReportFrom(i2);
    }

    public void setSourceFromForPb(int i2) {
        this.f12545f.R = i2;
    }

    public void setStType(String str) {
        this.f12548i = str;
        this.f12545f.setStType(str);
    }

    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e(context);
    }
}
