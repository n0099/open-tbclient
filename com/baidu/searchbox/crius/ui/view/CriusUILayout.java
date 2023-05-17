package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes3.dex */
public class CriusUILayout extends CriusUI<CriusLayout> {
    public CriusUILayout(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        View view2 = criusData.getUI().getView();
        if (view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        ((CriusLayout) this.mView).addView(view2, i, criusData);
    }

    private boolean hasRadius() {
        if (this.renderObject.convertedBorderRadius() <= 0.0f && this.renderObject.convertedBorderRadiusLT() <= 0.0f && this.renderObject.convertedBorderRadiusRT() <= 0.0f && this.renderObject.convertedBorderRadiusRB() <= 0.0f && this.renderObject.convertedBorderRadiusLB() <= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public CriusLayout createView(Context context) {
        if (hasRadius()) {
            RoundCornerCirusLayout roundCornerCirusLayout = new RoundCornerCirusLayout(context, this.renderObject);
            roundCornerCirusLayout.setCornerRadius(this.renderObject.convertedBorderRadius());
            roundCornerCirusLayout.setCornerRadius(this.renderObject.convertedBorderRadiusLT(), this.renderObject.convertedBorderRadiusRT(), this.renderObject.convertedBorderRadiusRB(), this.renderObject.convertedBorderRadiusLB());
            return roundCornerCirusLayout;
        }
        return new CriusLayout(context, this.renderObject);
    }
}
