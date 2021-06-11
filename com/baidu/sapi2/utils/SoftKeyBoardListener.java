package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.NoProguard;
import java.io.PrintStream;
/* loaded from: classes2.dex */
public class SoftKeyBoardListener implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public View f9891a;

    /* renamed from: b  reason: collision with root package name */
    public int f9892b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f9893c;

    /* loaded from: classes2.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            SoftKeyBoardListener.this.f9891a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i2 = softKeyBoardListener.f9892b;
            if (i2 == 0) {
                softKeyBoardListener.f9892b = height;
            } else if (i2 == height) {
            } else {
                if (i2 - height > 200) {
                    if (softKeyBoardListener.f9893c != null) {
                        SoftKeyBoardListener.this.f9893c.keyBoardShow(SoftKeyBoardListener.this.f9892b - height);
                    }
                    SoftKeyBoardListener.this.f9892b = height;
                } else if (height - i2 > 200) {
                    if (softKeyBoardListener.f9893c != null) {
                        SoftKeyBoardListener.this.f9893c.keyBoardHide(height - SoftKeyBoardListener.this.f9892b);
                    }
                    SoftKeyBoardListener.this.f9892b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f9891a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.f9893c = onSoftKeyBoardChangeListener;
    }
}
