package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes3.dex */
public class TopicEnterButton extends AppCompatTextView implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public static final int f13550f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);

    /* renamed from: g  reason: collision with root package name */
    public static final int f13551g = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);

    /* renamed from: h  reason: collision with root package name */
    public static final int f13552h = (((((l.k(TbadkCoreApplication.getInst()) / 2) - l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004) * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002)) - f13550f) - f13551g;

    /* renamed from: e  reason: collision with root package name */
    public RecommendTopicData.RecommendTopicListData f13553e;

    public TopicEnterButton(Context context) {
        super(context);
        h();
    }

    public void a() {
        c a2 = c.a(this);
        a2.s(R.string.F_X01);
        a2.r(R.dimen.T_X09);
        a2.n(R.color.CAM_X0304);
        a2.b(R.string.A_X07);
        a2.h(R.string.J_X01);
        a2.f(R.dimen.L_X02);
        a2.e(R.color.CAM_X0304);
        Drawable maskDrawable = WebPManager.getMaskDrawable(R.drawable.icon_pb_huati, WebPManager.ResourceStateType.NORMAL_PRESS);
        setCompoundDrawablePadding(f13550f);
        if (maskDrawable != null) {
            int i = f13551g;
            maskDrawable.setBounds(0, 0, i, i);
        }
        setCompoundDrawables(maskDrawable, null, null, null);
    }

    public void f(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        this.f13553e = recommendTopicListData;
        if (recommendTopicListData != null) {
            String topicName = recommendTopicListData.getTopicName();
            if (k.isEmpty(topicName)) {
                setVisibility(8);
                return;
            }
            setText(TextUtils.ellipsize(topicName, getPaint(), f13552h, TextUtils.TruncateAt.END));
            setVisibility(0);
            a();
            return;
        }
        setVisibility(8);
    }

    public void h() {
        setHeight((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds62));
        setMaxLines(1);
        setGravity(17);
        setPadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0);
        setOnClickListener(this);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecommendTopicData.RecommendTopicListData recommendTopicListData = this.f13553e;
        if (recommendTopicListData == null || k.isEmpty(recommendTopicListData.getTopicName())) {
            return;
        }
        new HotTopicActivityConfig(view.getContext()).createNormalConfig(null, this.f13553e.getTopicName(), "2").start();
    }

    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }
}
