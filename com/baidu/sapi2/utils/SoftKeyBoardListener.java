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
    public View f11424a;

    /* renamed from: b  reason: collision with root package name */
    public int f11425b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f11426c;

    /* loaded from: classes2.dex */
    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            SoftKeyBoardListener.this.f11424a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i = softKeyBoardListener.f11425b;
            if (i == 0) {
                softKeyBoardListener.f11425b = height;
            } else if (i == height) {
            } else {
                if (i - height > 200) {
                    if (softKeyBoardListener.f11426c != null) {
                        SoftKeyBoardListener.this.f11426c.keyBoardShow(SoftKeyBoardListener.this.f11425b - height);
                    }
                    SoftKeyBoardListener.this.f11425b = height;
                } else if (height - i > 200) {
                    if (softKeyBoardListener.f11426c != null) {
                        SoftKeyBoardListener.this.f11426c.keyBoardHide(height - SoftKeyBoardListener.this.f11425b);
                    }
                    SoftKeyBoardListener.this.f11425b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f11424a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.f11426c = onSoftKeyBoardChangeListener;
    }
}
