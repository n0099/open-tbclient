package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.commonLike.forum.ForumLikeBotton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.w1;
import d.a.o0.z.m;
/* loaded from: classes3.dex */
public class ThreadForumUserInfoLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f12519e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12520f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12521g;

    /* renamed from: h  reason: collision with root package name */
    public ForumLikeBotton f12522h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.f0.n.c.a f12523i;
    public a2 j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadForumUserInfoLayout.this.j == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadForumUserInfoLayout.this.getContext()).createNormalCfg(ThreadForumUserInfoLayout.this.j.h0() != null ? ThreadForumUserInfoLayout.this.j.h0().h() : ThreadForumUserInfoLayout.this.j.i0(), m.g())));
            if (ThreadForumUserInfoLayout.this.k != null) {
                ThreadForumUserInfoLayout.this.k.onClick(view);
            }
        }
    }

    public ThreadForumUserInfoLayout(Context context) {
        this(context, null);
    }

    public final void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_forum_user_info_layout, (ViewGroup) this, true);
        this.f12519e = (TbImageView) inflate.findViewById(R.id.forum_avatar);
        TextView textView = (TextView) inflate.findViewById(R.id.forum_name);
        this.f12520f = textView;
        textView.setOnClickListener(this.l);
        this.f12521g = (TextView) inflate.findViewById(R.id.user_name_and_reply_time);
        this.f12522h = (ForumLikeBotton) inflate.findViewById(R.id.like_button);
        if (context instanceof TbPageContextSupport) {
            this.f12523i = new d.a.n0.r.f0.n.c.a(((TbPageContextSupport) context).getPageContext(), this.f12522h);
        }
        setGravity(16);
        d();
    }

    public final void d() {
        TbImageView tbImageView = this.f12519e;
        if (tbImageView == null) {
            return;
        }
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f12519e.setOnClickListener(this.l);
    }

    public String e(String str) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public final void f(w1 w1Var) {
        if (w1Var != null && !StringUtils.isNull(w1Var.a())) {
            this.f12519e.setVisibility(0);
            this.f12519e.U(w1Var.a(), 10, false);
            this.f12519e.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            return;
        }
        this.f12519e.setVisibility(4);
    }

    public void g(w1 w1Var) {
        if (w1Var != null && !StringUtils.isNull(w1Var.h())) {
            this.f12520f.setText(StringHelper.cutChineseAndEnglishWithSuffix(w1Var.h(), 14, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.f12520f.setVisibility(0);
            return;
        }
        this.f12520f.setVisibility(4);
    }

    public TextView getForumName() {
        return this.f12520f;
    }

    public TbImageView getHeaderImg() {
        return this.f12519e;
    }

    public ForumLikeBotton getLikeButton() {
        return this.f12522h;
    }

    public TextView getUserName() {
        return this.f12521g;
    }

    public void h(w1 w1Var) {
        int i2 = 8;
        if (w1Var == null) {
            this.f12522h.setVisibility(8);
            return;
        }
        this.f12523i.f(w1Var);
        this.f12522h.setVisibility((!w1Var.getIsLike() || w1Var.c()) ? 0 : 0);
    }

    public void i(a2 a2Var) {
        if (a2Var == null || StringUtils.isNull(this.j.T().getName_show())) {
            return;
        }
        this.f12521g.setText(getContext().getString(R.string.user_name_and_publish, e(this.j.T().getName_show())));
        this.f12521g.setVisibility(0);
    }

    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.j = a2Var;
        f(a2Var.h0());
        g(a2Var.h0());
        i(a2Var);
        h(a2Var.h0());
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void setLikeButtonAfterClickListener(View.OnClickListener onClickListener) {
        d.a.n0.r.f0.n.c.a aVar = this.f12523i;
        if (aVar != null) {
            aVar.e(onClickListener);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView = this.f12519e;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
        d.a.n0.r.f0.n.c.a aVar = this.f12523i;
        if (aVar != null) {
            aVar.g(bdUniqueId);
        }
    }

    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = new a();
        c(getContext());
    }
}
