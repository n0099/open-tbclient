package com.baidu.searchbox.ng.ai.apps.canvas.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class AbsCanvasView extends View implements ICanvasView {
    private boolean mGesture;
    private boolean mHide;
    private boolean mInterceptTouchEvent;

    public AbsCanvasView(Context context) {
        this(context, null);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AbsCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterceptTouchEvent = false;
        this.mGesture = false;
        this.mHide = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public boolean isInterceptTouchEvent() {
        return this.mInterceptTouchEvent;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public void setInterceptTouchEvent(boolean z) {
        this.mInterceptTouchEvent = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public boolean isGesture() {
        return this.mGesture;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public void setGesture(boolean z) {
        this.mGesture = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public boolean isHide() {
        return this.mHide;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.view.ICanvasView
    public void setHide(boolean z) {
        this.mHide = z;
    }
}
