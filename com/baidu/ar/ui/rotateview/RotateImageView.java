package com.baidu.ar.ui.rotateview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.ar.util.b;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class RotateImageView extends ImageView {
    float a;
    float b;
    private int c;

    public RotateImageView(Context context) {
        this(context, null, 0);
    }

    public RotateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.5f;
        this.b = 0.5f;
        this.c = 0;
    }

    private int a(int i) {
        if (i < 0) {
            i = (i % 360) + 360;
        }
        return Math.round(i / 90.0f) * 90;
    }

    private void a(int i, final Orientation orientation) {
        float f = 90.0f;
        if (getVisibility() != 0) {
            switch (orientation) {
                case PORTRAIT:
                    a();
                    return;
                case LANDSCAPE:
                    b();
                    return;
                case LANDSCAPE_REVERSE:
                    c();
                    return;
                case PORTRAIT_REVERSE:
                default:
                    return;
            }
        }
        switch (i) {
            case 1:
                f = -90.0f;
                break;
            case 2:
                f = 180.0f;
                break;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f, 1, this.a, 1, this.b);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setDuration(200L);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.ar.ui.rotateview.RotateImageView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RotateImageView.this.clearAnimation();
                switch (AnonymousClass2.a[orientation.ordinal()]) {
                    case 1:
                        RotateImageView.this.a();
                        return;
                    case 2:
                        RotateImageView.this.b();
                        return;
                    case 3:
                        RotateImageView.this.c();
                        return;
                    case 4:
                    default:
                        return;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(rotateAnimation);
    }

    public void a() {
        setAngle(0);
    }

    public void a(Orientation orientation, boolean z) {
        switch (this.c) {
            case 0:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case 360:
                switch (orientation) {
                    case PORTRAIT:
                    case PORTRAIT_REVERSE:
                    default:
                        return;
                    case LANDSCAPE:
                        if (z) {
                            a(0, orientation);
                            return;
                        } else {
                            b();
                            return;
                        }
                    case LANDSCAPE_REVERSE:
                        if (z) {
                            a(1, orientation);
                            return;
                        } else {
                            c();
                            return;
                        }
                }
            case 90:
                switch (orientation) {
                    case PORTRAIT:
                        if (z) {
                            a(1, orientation);
                            return;
                        } else {
                            a();
                            return;
                        }
                    case LANDSCAPE:
                    case PORTRAIT_REVERSE:
                    default:
                        return;
                    case LANDSCAPE_REVERSE:
                        if (z) {
                            a(2, orientation);
                            return;
                        } else {
                            c();
                            return;
                        }
                }
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                switch (orientation) {
                    case PORTRAIT:
                        if (z) {
                            a(0, orientation);
                            return;
                        } else {
                            a();
                            return;
                        }
                    case LANDSCAPE:
                        if (z) {
                            a(2, orientation);
                            return;
                        } else {
                            b();
                            return;
                        }
                    case LANDSCAPE_REVERSE:
                    case PORTRAIT_REVERSE:
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void b() {
        setAngle(90);
    }

    public void c() {
        setAngle(-90);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c == 0 || this.c == 360) {
            super.onDraw(canvas);
        } else {
            canvas.save();
            canvas.rotate(this.c, getWidth() * this.a, getHeight() * this.b);
            super.onDraw(canvas);
            canvas.restore();
        }
        b.a("width is : " + getWidth() + " height is : " + getHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setAngle(int i) {
        this.c = a(i);
        invalidate();
    }
}
