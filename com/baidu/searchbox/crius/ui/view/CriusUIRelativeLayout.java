package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes2.dex */
public class CriusUIRelativeLayout extends CriusUI<RelativeLayout> {
    public CriusUIRelativeLayout(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        View view2 = criusData.getUI().getView();
        if (view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        ((RelativeLayout) this.mView).addView(view2, i);
    }

    private boolean hasRadius() {
        if (this.renderObject.convertedBorderRadius() <= 0.0f && this.renderObject.convertedBorderRadiusLT() <= 0.0f && this.renderObject.convertedBorderRadiusRT() <= 0.0f && this.renderObject.convertedBorderRadiusRB() <= 0.0f && this.renderObject.convertedBorderRadiusLB() <= 0.0f) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void removeChild(CriusData criusData) {
        if (criusData.hasUI()) {
            ((RelativeLayout) this.mView).removeView(criusData.getUI().getView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.searchbox.crius.ui.view.RoundCornerRelativeLayout' to match base method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public RelativeLayout createView(Context context) {
        RoundCornerRelativeLayout roundCornerRelativeLayout = new RoundCornerRelativeLayout(context);
        if (hasRadius()) {
            roundCornerRelativeLayout.setCornerRadius(this.renderObject.convertedBorderRadius());
            roundCornerRelativeLayout.setCornerRadius(this.renderObject.convertedBorderRadiusLT(), this.renderObject.convertedBorderRadiusRT(), this.renderObject.convertedBorderRadiusRB(), this.renderObject.convertedBorderRadiusLB());
        }
        return roundCornerRelativeLayout;
    }
}
