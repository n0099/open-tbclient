package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.NoProguard;
import java.io.PrintStream;
/* loaded from: classes3.dex */
public class SoftKeyBoardListener implements NoProguard {
    public View a;
    public int b;
    public OnSoftKeyBoardChangeListener c;

    /* loaded from: classes3.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            SoftKeyBoardListener.this.a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i = softKeyBoardListener.b;
            if (i == 0) {
                softKeyBoardListener.b = height;
            } else if (i == height) {
            } else {
                if (i - height > 200) {
                    if (softKeyBoardListener.c != null) {
                        SoftKeyBoardListener.this.c.keyBoardShow(SoftKeyBoardListener.this.b - height);
                    }
                    SoftKeyBoardListener.this.b = height;
                } else if (height - i > 200) {
                    if (softKeyBoardListener.c != null) {
                        SoftKeyBoardListener.this.c.keyBoardHide(height - SoftKeyBoardListener.this.b);
                    }
                    SoftKeyBoardListener.this.b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.c = onSoftKeyBoardChangeListener;
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }
}
