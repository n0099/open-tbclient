package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView;
import com.baidu.tieba.bl0;
import com.baidu.tieba.w11;
import com.baidu.tieba.xm0;
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
        return bl0.a().h();
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public void v() {
        setBtnHeight(getResources().getDimensionPixelSize(bl0.a().c()));
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView, com.baidu.tieba.d91
    public void setData(@NonNull xm0 xm0Var) {
        super.setData(xm0Var);
        setBtnTextSize(w11.c.m(getContext(), getResources().getDimensionPixelSize(bl0.a().t())));
        setBtnCornerRadius(getResources().getDimensionPixelSize(bl0.a().k()));
    }
}
