package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.a.n0.r.q.a;
import d.a.n0.r.u.c;
import java.util.List;
/* loaded from: classes.dex */
public class RecommendInfoLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f4516e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f4517f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4518g;

    public RecommendInfoLayout(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_recommend_info_layout, (ViewGroup) this, true);
        this.f4516e = (LinearLayout) inflate.findViewById(R.id.recommend_layout);
        this.f4517f = (BarImageView) inflate.findViewById(R.id.recommend_forum_avatar);
        this.f4518g = (TextView) inflate.findViewById(R.id.recommend_info_view);
    }

    public final void b(ThreadRecommendInfoData threadRecommendInfoData) {
        if (threadRecommendInfoData == null || TextUtils.isEmpty(threadRecommendInfoData.forumName) || TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            return;
        }
        this.f4518g.setText(StringHelper.cutChineseAndEnglishWithSuffix(threadRecommendInfoData.forumName, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.forum) + threadRecommendInfoData.recommendReason);
    }

    public void c() {
        c d2 = c.d(this.f4516e);
        d2.m(R.string.J_X01);
        d2.f(R.color.CAM_X0209);
        c d3 = c.d(this.f4518g);
        d3.x(R.string.F_X01);
        d3.w(R.dimen.T_X09);
        d3.s(R.color.CAM_X0107);
    }

    public void setData(a aVar) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        List<ThreadRecommendInfoData> u1 = aVar.i().u1();
        if (ListUtils.isEmpty(u1)) {
            return;
        }
        ThreadRecommendInfoData threadRecommendInfoData = u1.get(0);
        this.f4517f.U(threadRecommendInfoData.forumAvatar, 10, false);
        b(threadRecommendInfoData);
    }

    public RecommendInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RecommendInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
