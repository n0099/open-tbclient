package com.baidu.searchbox.crius.parser;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes2.dex */
public class CriusDataFactory {
    public static CriusData create(Context context, final View view2) {
        CriusData criusData = new CriusData();
        criusData.setUI(new CriusUI(context, criusData) { // from class: com.baidu.searchbox.crius.parser.CriusDataFactory.1
            @Override // com.baidu.searchbox.crius.ui.CriusUI
            public View createView(Context context2) {
                return view2;
            }
        });
        return criusData;
    }
}
