package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes3.dex */
public class CriusUIVirtualLayout extends CriusUI<VirtualCriusLayout> {
    public CriusUIVirtualLayout(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        View view2 = criusData.getUI().getView();
        if (view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        ((VirtualCriusLayout) this.mView).addView(view2, i, criusData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public VirtualCriusLayout createView(Context context) {
        return new VirtualCriusLayout(context, this.renderObject);
    }
}
