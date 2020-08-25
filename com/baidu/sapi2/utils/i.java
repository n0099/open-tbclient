package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes12.dex */
public class i {
    private View a;
    int b;
    private b c;

    /* loaded from: classes12.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            i.this.a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            System.out.println("" + height);
            i iVar = i.this;
            int i = iVar.b;
            if (i == 0) {
                iVar.b = height;
            } else if (i != height) {
                if (i - height > 200) {
                    if (iVar.c != null) {
                        i.this.c.keyBoardShow(i.this.b - height);
                    }
                    i.this.b = height;
                } else if (height - i > 200) {
                    if (iVar.c != null) {
                        i.this.c.keyBoardHide(height - i.this.b);
                    }
                    i.this.b = height;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public i(Activity activity) {
        this.a = activity.getWindow().getDecorView();
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void a(b bVar) {
        this.c = bVar;
    }

    public static void a(Activity activity, b bVar) {
        new i(activity).a(bVar);
    }
}
