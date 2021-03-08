package com.baidu.swan.games.view.recommend.popview;

import android.view.View;
import com.baidu.swan.games.view.recommend.popview.c;
/* loaded from: classes8.dex */
public class d {
    public static void ba(View view) {
        if (view != null) {
            c cVar = new c();
            cVar.setView(view);
            cVar.a(new c.a() { // from class: com.baidu.swan.games.view.recommend.popview.d.1
                @Override // com.baidu.swan.games.view.recommend.popview.c.a
                public void aY(View view2) {
                    if (view2 != null) {
                        view2.setAlpha(0.2f);
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.popview.c.a
                public void aZ(View view2) {
                    if (view2 != null) {
                        view2.setAlpha(1.0f);
                    }
                }
            });
            view.setBackground(cVar);
        }
    }
}
