package com.baidu.sapi2.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.utils.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class m implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        n.a aVar;
        n.a aVar2;
        n.a aVar3;
        n.a aVar4;
        Rect rect = new Rect();
        view = this.a.a;
        view.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        System.out.println("" + height);
        n nVar = this.a;
        int i = nVar.b;
        if (i == 0) {
            nVar.b = height;
        } else if (i != height) {
            if (i - height > 200) {
                aVar3 = nVar.c;
                if (aVar3 != null) {
                    aVar4 = this.a.c;
                    aVar4.keyBoardShow(this.a.b - height);
                }
                this.a.b = height;
            } else if (height - i > 200) {
                aVar = nVar.c;
                if (aVar != null) {
                    aVar2 = this.a.c;
                    aVar2.keyBoardHide(height - this.a.b);
                }
                this.a.b = height;
            }
        }
    }
}
