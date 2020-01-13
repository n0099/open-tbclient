package com.baidu.searchbox.picture.component.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.picture.component.listener.DefaultOnDoubleTapListener;
import com.baidu.searchbox.picture.component.listener.OnPhotoTapListener;
import com.baidu.searchbox.picture.component.listener.OnScaleChangeListener;
import com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener;
import com.baidu.searchbox.picture.component.listener.OnViewTapListener;
import com.facebook.drawee.generic.a;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes12.dex */
public class PhotoDraweeView extends SimpleDraweeView implements IAttacher {
    private Attacher mAttacher;

    public PhotoDraweeView(Context context, a aVar) {
        super(context, aVar);
        init();
    }

    public PhotoDraweeView(Context context) {
        super(context);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void init() {
        if (this.mAttacher == null || this.mAttacher.getDraweeView() == null) {
            this.mAttacher = new Attacher(this);
        }
        setOnDoubleTapListener(new DefaultOnDoubleTapListener(this.mAttacher));
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.mAttacher.getDrawMatrix());
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.mAttacher.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    public RectF getRectF() {
        return this.mAttacher.getRectF();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMinimumScale() {
        return this.mAttacher.getMinimumScale();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMediumScale() {
        return this.mAttacher.getMediumScale();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMaximumScale() {
        return this.mAttacher.getMaximumScale();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMinimumScale(float f) {
        this.mAttacher.setMinimumScale(f);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMediumScale(float f) {
        this.mAttacher.setMediumScale(f);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMaximumScale(float f) {
        this.mAttacher.setMaximumScale(f);
    }

    public void setScaleParams(float f, float f2, float f3) {
        this.mAttacher.setScaleParams(f, f2, f3);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getScale() {
        return this.mAttacher.getScale();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f) {
        this.mAttacher.setScale(f);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f, boolean z) {
        this.mAttacher.setScale(f, z);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f, float f2, float f3, boolean z) {
        this.mAttacher.setScale(f, f2, f3, z);
    }

    public void setOnScaleDragGestureListener(OnScaleDragGestureListener onScaleDragGestureListener) {
        this.mAttacher.setOnScaleDragGestureListener(onScaleDragGestureListener);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setZoomTransitionDuration(long j) {
        this.mAttacher.setZoomTransitionDuration(j);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAttacher.setAllowParentInterceptOnEdge(z);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mAttacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mAttacher.setOnScaleChangeListener(onScaleChangeListener);
    }

    @Override // android.view.View, com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mAttacher.setOnLongClickListener(onLongClickListener);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mAttacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mAttacher.setOnViewTapListener(onViewTapListener);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mAttacher.getOnPhotoTapListener();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public OnViewTapListener getOnViewTapListener() {
        return this.mAttacher.getOnViewTapListener();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void update(int i, int i2) {
        this.mAttacher.update(i, i2);
    }
}
