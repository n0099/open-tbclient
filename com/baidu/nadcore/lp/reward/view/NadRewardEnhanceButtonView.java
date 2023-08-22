package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView;
import com.baidu.tieba.fr0;
import com.baidu.tieba.m61;
import com.baidu.tieba.mp0;
/* loaded from: classes3.dex */
public class NadRewardEnhanceButtonView extends AdEnhanceButtonView {
    public NadRewardEnhanceButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NadRewardEnhanceButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NadRewardEnhanceButtonView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        super(context, viewGroup, view2);
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView, com.baidu.tieba.ud1
    public void setData(@NonNull fr0 fr0Var) {
        super.setData(fr0Var);
        setBtnTextSize(m61.c.k(getContext(), getResources().getDimensionPixelSize(mp0.a().p())));
        setBtnCornerRadius(getResources().getDimensionPixelSize(mp0.a().h()));
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public void u() {
        setBtnHeight(getResources().getDimensionPixelSize(mp0.a().b()));
    }
}
