package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private View f5418a;

    /* renamed from: b  reason: collision with root package name */
    int f5419b;
    private b c;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            i.this.f5418a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            System.out.println("" + height);
            i iVar = i.this;
            int i = iVar.f5419b;
            if (i == 0) {
                iVar.f5419b = height;
            } else if (i != height) {
                if (i - height > 200) {
                    if (iVar.c != null) {
                        i.this.c.keyBoardShow(i.this.f5419b - height);
                    }
                    i.this.f5419b = height;
                } else if (height - i > 200) {
                    if (iVar.c != null) {
                        i.this.c.keyBoardHide(height - i.this.f5419b);
                    }
                    i.this.f5419b = height;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public i(Activity activity) {
        this.f5418a = activity.getWindow().getDecorView();
        this.f5418a.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void a(b bVar) {
        this.c = bVar;
    }

    public static void a(Activity activity, b bVar) {
        new i(activity).a(bVar);
    }
}
