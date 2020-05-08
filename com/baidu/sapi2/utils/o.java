package com.baidu.sapi2.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.utils.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class o implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        p.a aVar;
        p.a aVar2;
        p.a aVar3;
        p.a aVar4;
        Rect rect = new Rect();
        view = this.a.a;
        view.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        System.out.println("" + height);
        p pVar = this.a;
        int i = pVar.b;
        if (i == 0) {
            pVar.b = height;
        } else if (i != height) {
            if (i - height > 200) {
                aVar3 = pVar.c;
                if (aVar3 != null) {
                    aVar4 = this.a.c;
                    aVar4.keyBoardShow(this.a.b - height);
                }
                this.a.b = height;
            } else if (height - i > 200) {
                aVar = pVar.c;
                if (aVar != null) {
                    aVar2 = this.a.c;
                    aVar2.keyBoardHide(height - this.a.b);
                }
                this.a.b = height;
            }
        }
    }
}
