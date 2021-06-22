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
    public View f9912a;

    /* renamed from: b  reason: collision with root package name */
    public int f9913b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f9914c;

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
            SoftKeyBoardListener.this.f9912a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i2 = softKeyBoardListener.f9913b;
            if (i2 == 0) {
                softKeyBoardListener.f9913b = height;
            } else if (i2 == height) {
            } else {
                if (i2 - height > 200) {
                    if (softKeyBoardListener.f9914c != null) {
                        SoftKeyBoardListener.this.f9914c.keyBoardShow(SoftKeyBoardListener.this.f9913b - height);
                    }
                    SoftKeyBoardListener.this.f9913b = height;
                } else if (height - i2 > 200) {
                    if (softKeyBoardListener.f9914c != null) {
                        SoftKeyBoardListener.this.f9914c.keyBoardHide(height - SoftKeyBoardListener.this.f9913b);
                    }
                    SoftKeyBoardListener.this.f9913b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f9912a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.f9914c = onSoftKeyBoardChangeListener;
    }
}
