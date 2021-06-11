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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.u.c;
/* loaded from: classes3.dex */
public class TopicEnterButton extends AppCompatTextView implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public static final int f12481f = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);

    /* renamed from: g  reason: collision with root package name */
    public static final int f12482g = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);

    /* renamed from: h  reason: collision with root package name */
    public static final int f12483h = (((((l.k(TbadkCoreApplication.getInst()) / 2) - l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004) * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002)) - f12481f) - f12482g;

    /* renamed from: e  reason: collision with root package name */
    public RecommendTopicData.RecommendTopicListData f12484e;

    public TopicEnterButton(Context context) {
        super(context);
        e();
    }

    public void d(RecommendTopicData.RecommendTopicListData recommendTopicListData) {
        this.f12484e = recommendTopicListData;
        if (recommendTopicListData != null) {
            String topicName = recommendTopicListData.getTopicName();
            if (k.isEmpty(topicName)) {
                setVisibility(8);
                return;
            }
            setText(TextUtils.ellipsize(topicName, getPaint(), f12483h, TextUtils.TruncateAt.END));
            setVisibility(0);
            f();
            return;
        }
        setVisibility(8);
    }

    public void e() {
        setHeight((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds62));
        setMaxLines(1);
        setGravity(17);
        setPadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.M_W_X004), 0);
        setOnClickListener(this);
        f();
    }

    public void f() {
        c d2 = c.d(this);
        d2.x(R.string.F_X01);
        d2.w(R.dimen.T_X09);
        d2.s(R.color.CAM_X0304);
        d2.e(R.string.A_X07);
        d2.m(R.string.J_X01);
        d2.k(R.dimen.L_X02);
        d2.j(R.color.CAM_X0304);
        Drawable maskDrawable = WebPManager.getMaskDrawable(R.drawable.icon_pb_huati, WebPManager.ResourceStateType.NORMAL_PRESS);
        setCompoundDrawablePadding(f12481f);
        if (maskDrawable != null) {
            int i2 = f12482g;
            maskDrawable.setBounds(0, 0, i2, i2);
        }
        setCompoundDrawables(maskDrawable, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecommendTopicData.RecommendTopicListData recommendTopicListData = this.f12484e;
        if (recommendTopicListData == null || k.isEmpty(recommendTopicListData.getTopicName())) {
            return;
        }
        new HotTopicActivityConfig(view.getContext()).createNormalConfig(null, this.f12484e.getTopicName(), "2").start();
    }

    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public TopicEnterButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
