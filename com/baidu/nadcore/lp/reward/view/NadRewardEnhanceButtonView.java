package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView;
import com.baidu.tieba.jr0;
import com.baidu.tieba.np0;
import com.baidu.tieba.q61;
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

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public int getLayoutId() {
        return np0.a().f();
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public void u() {
        setBtnHeight(getResources().getDimensionPixelSize(np0.a().b()));
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView, com.baidu.tieba.yd1
    public void setData(@NonNull jr0 jr0Var) {
        super.setData(jr0Var);
        setBtnTextSize(q61.c.k(getContext(), getResources().getDimensionPixelSize(np0.a().q())));
        setBtnCornerRadius(getResources().getDimensionPixelSize(np0.a().i()));
    }
}
