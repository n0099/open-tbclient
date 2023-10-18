package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView;
import com.baidu.tieba.c11;
import com.baidu.tieba.fm0;
import com.baidu.tieba.jk0;
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
        return jk0.a().f();
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView
    public void u() {
        setBtnHeight(getResources().getDimensionPixelSize(jk0.a().b()));
    }

    @Override // com.baidu.nadcore.business.uitemplate.AdEnhanceButtonView, com.baidu.tieba.h81
    public void setData(@NonNull fm0 fm0Var) {
        super.setData(fm0Var);
        setBtnTextSize(c11.c.k(getContext(), getResources().getDimensionPixelSize(jk0.a().q())));
        setBtnCornerRadius(getResources().getDimensionPixelSize(jk0.a().i()));
    }
}
