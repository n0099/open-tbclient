package com.baidu.searchbox.ng.ai.apps.textarea;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes2.dex */
public class SoftGlobalLayoutListener {
    private OnSoftGlobalLayoutChangeListener mOnSoftGlobalLayoutChangeListener;
    private View rootView;
    private int rootViewVisibleHeight;
    private int DEF_HEIGHT = 0;
    private int CHANGE_BASE_HEIGHT = 200;

    /* loaded from: classes2.dex */
    public interface OnSoftGlobalLayoutChangeListener {
        void keyBoardHide(String str, int i);

        void keyBoardShow(String str, int i);

        void onGlobalLayout(String str);
    }

    private SoftGlobalLayoutListener(final String str, Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener != null) {
                    SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener.onGlobalLayout(str);
                }
                Rect rect = new Rect();
                SoftGlobalLayoutListener.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (SoftGlobalLayoutListener.this.rootViewVisibleHeight == SoftGlobalLayoutListener.this.DEF_HEIGHT) {
                    SoftGlobalLayoutListener.this.rootViewVisibleHeight = height;
                } else if (SoftGlobalLayoutListener.this.rootViewVisibleHeight != height) {
                    if (SoftGlobalLayoutListener.this.rootViewVisibleHeight - height > SoftGlobalLayoutListener.this.CHANGE_BASE_HEIGHT) {
                        if (SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener != null) {
                            SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener.keyBoardShow(str, SoftGlobalLayoutListener.this.rootViewVisibleHeight - height);
                        }
                        SoftGlobalLayoutListener.this.rootViewVisibleHeight = height;
                    } else if (height - SoftGlobalLayoutListener.this.rootViewVisibleHeight > SoftGlobalLayoutListener.this.CHANGE_BASE_HEIGHT) {
                        if (SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener != null) {
                            SoftGlobalLayoutListener.this.mOnSoftGlobalLayoutChangeListener.keyBoardHide(str, height - SoftGlobalLayoutListener.this.rootViewVisibleHeight);
                        }
                        SoftGlobalLayoutListener.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    private void setmOnSoftGlobalLayoutChangeListener(OnSoftGlobalLayoutChangeListener onSoftGlobalLayoutChangeListener) {
        this.mOnSoftGlobalLayoutChangeListener = onSoftGlobalLayoutChangeListener;
    }

    public static void setListener(String str, Activity activity, OnSoftGlobalLayoutChangeListener onSoftGlobalLayoutChangeListener) {
        new SoftGlobalLayoutListener(str, activity).setmOnSoftGlobalLayoutChangeListener(onSoftGlobalLayoutChangeListener);
    }
}
