package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView;
import com.baidu.tieba.bs0;
import com.baidu.tieba.e71;
import com.baidu.tieba.jq0;
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

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView, com.baidu.tieba.me1
    public void setData(@NonNull bs0 bs0Var) {
        super.setData(bs0Var);
        setBtnTextSize(e71.c.k(getContext(), getResources().getDimensionPixelSize(jq0.a().n())));
        setBtnCornerRadius(getResources().getDimensionPixelSize(jq0.a().h()));
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public void u() {
        setBtnHeight(getResources().getDimensionPixelSize(jq0.a().b()));
    }
}
