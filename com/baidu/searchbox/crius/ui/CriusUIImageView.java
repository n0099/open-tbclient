package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.crius.factory.NativeRenderFactory;
import com.baidu.searchbox.crius.parser.CriusData;
/* loaded from: classes2.dex */
public class CriusUIImageView extends CriusUI<View> {
    public CriusUIImageView(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public View createView(Context context) {
        return NativeRenderFactory.getInstance().createView(context, "image");
    }
}
