package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class VirtualBarAssist {
    public View childOfContent;
    public final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.VirtualBarAssist.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            VirtualBarAssist.this.possiblyResizeChildOfContent();
        }
    };
    public int usableHeightPrevious;
    public ViewTreeObserver viewTreeObserver;

    public VirtualBarAssist(@NonNull Activity activity) {
        this.childOfContent = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void addOnGlobalLayoutListener() {
        measureIsAliveViewTreeObserver();
        ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        this.viewTreeObserver.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public static VirtualBarAssist assistActivity(@NonNull Activity activity) {
        VirtualBarAssist virtualBarAssist = new VirtualBarAssist(activity);
        virtualBarAssist.addOnGlobalLayoutListener();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return virtualBarAssist;
    }

    private void measureIsAliveViewTreeObserver() {
        View view;
        ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
        if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (view = this.childOfContent) != null) {
            this.viewTreeObserver = view.getViewTreeObserver();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.childOfContent == null) {
            return;
        }
        Rect rect = new Rect();
        this.childOfContent.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != this.usableHeightPrevious) {
            int height = this.childOfContent.getRootView().getHeight();
            int i2 = height - rect.bottom;
            int i3 = (height - i) - i2;
            if (i3 > height / 4) {
                this.childOfContent.getLayoutParams().height = height - i3;
            } else {
                this.childOfContent.getLayoutParams().height = height - i2;
            }
            this.childOfContent.requestLayout();
            this.usableHeightPrevious = i;
        }
    }

    private void removeOnGlobalLayoutListener() {
        measureIsAliveViewTreeObserver();
        ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        this.viewTreeObserver.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public void onDestroy() {
        removeOnGlobalLayoutListener();
    }

    public void onPause() {
        removeOnGlobalLayoutListener();
    }

    public void onResume() {
        addOnGlobalLayoutListener();
    }
}
