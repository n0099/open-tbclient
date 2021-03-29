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
    public View f11425a;

    /* renamed from: b  reason: collision with root package name */
    public int f11426b;

    /* renamed from: c  reason: collision with root package name */
    public OnSoftKeyBoardChangeListener f11427c;

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
            SoftKeyBoardListener.this.f11425a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i = softKeyBoardListener.f11426b;
            if (i == 0) {
                softKeyBoardListener.f11426b = height;
            } else if (i == height) {
            } else {
                if (i - height > 200) {
                    if (softKeyBoardListener.f11427c != null) {
                        SoftKeyBoardListener.this.f11427c.keyBoardShow(SoftKeyBoardListener.this.f11426b - height);
                    }
                    SoftKeyBoardListener.this.f11426b = height;
                } else if (height - i > 200) {
                    if (softKeyBoardListener.f11427c != null) {
                        SoftKeyBoardListener.this.f11427c.keyBoardHide(height - SoftKeyBoardListener.this.f11426b);
                    }
                    SoftKeyBoardListener.this.f11426b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.f11425a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.f11427c = onSoftKeyBoardChangeListener;
    }
}
