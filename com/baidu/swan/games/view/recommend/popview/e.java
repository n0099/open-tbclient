package com.baidu.swan.games.view.recommend.popview;

import android.view.View;
import com.baidu.swan.games.view.recommend.popview.d;
/* loaded from: classes10.dex */
public class e {
    public static void aE(View view) {
        if (view != null) {
            d dVar = new d();
            dVar.setView(view);
            dVar.a(new d.a() { // from class: com.baidu.swan.games.view.recommend.popview.e.1
                @Override // com.baidu.swan.games.view.recommend.popview.d.a
                public void aC(View view2) {
                    if (view2 != null) {
                        view2.setAlpha(0.2f);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.d.a
                public void aD(View view2) {
                    if (view2 != null) {
                        view2.setAlpha(1.0f);
                    }
                }
            });
            view.setBackground(dVar);
        }
    }
}
