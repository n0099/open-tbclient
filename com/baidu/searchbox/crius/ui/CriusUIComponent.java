package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.crius.factory.ComponentFactory;
import com.baidu.searchbox.crius.parser.CriusData;
/* loaded from: classes3.dex */
public class CriusUIComponent extends CriusUI<View> {
    public CriusUIComponent(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public View createView(Context context) {
        return ComponentFactory.getInstance().createComponent(context, this.renderObject.component);
    }
}
