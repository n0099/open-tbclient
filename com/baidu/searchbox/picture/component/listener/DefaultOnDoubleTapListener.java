package com.baidu.searchbox.picture.component.listener;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.searchbox.picture.component.view.Attacher;
import com.facebook.drawee.generic.a;
import com.facebook.drawee.view.DraweeView;
/* loaded from: classes11.dex */
public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private Attacher mAttacher;

    public DefaultOnDoubleTapListener(Attacher attacher) {
        setPhotoDraweeViewAttacher(attacher);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        DraweeView<a> draweeView;
        RectF displayRect;
        if (this.mAttacher == null || (draweeView = this.mAttacher.getDraweeView()) == null) {
            return false;
        }
        if (this.mAttacher.getOnPhotoTapListener() != null && (displayRect = this.mAttacher.getDisplayRect()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (displayRect.contains(x, y)) {
                this.mAttacher.getOnPhotoTapListener().onPhotoTap(draweeView, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.mAttacher.getOnViewTapListener() != null) {
            this.mAttacher.getOnViewTapListener().onViewTap(draweeView, motionEvent.getX(), motionEvent.getY());
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.mAttacher == null) {
            return false;
        }
        try {
            float scale = this.mAttacher.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.mAttacher.getMediumScale()) {
                this.mAttacher.setScale(this.mAttacher.getMediumScale(), x, y, true);
            } else if (scale >= this.mAttacher.getMediumScale() && scale < this.mAttacher.getMaximumScale()) {
                this.mAttacher.setScale(this.mAttacher.getMaximumScale(), x, y, true);
            } else {
                this.mAttacher.setScale(this.mAttacher.getMinimumScale(), x, y, true);
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setPhotoDraweeViewAttacher(Attacher attacher) {
        this.mAttacher = attacher;
    }
}
