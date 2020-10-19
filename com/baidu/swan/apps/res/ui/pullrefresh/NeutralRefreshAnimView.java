package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.b;
/* loaded from: classes10.dex */
public class NeutralRefreshAnimView extends View {
    private static final boolean DEBUG = b.DEBUG;
    private static final int daZ = ah.J(3.5f);
    private static final int dba = Color.parseColor("#000000");
    private static final int dbb = ah.J(18.0f);
    private static final int dbc = dbb >> 1;
    private float dbd;
    private Paint dbe;
    private Paint dbf;
    private PointF dbg;
    private ValueAnimator dbh;
    private ValueAnimator dbi;
    private float dbj;
    private float dbk;
    private ValueAnimator dbl;
    private ValueAnimator dbm;
    private int dbn;
    private int dbo;
    private AnimatorSet mAnimatorSet;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private int mHeight;
    private int mState;
    private int mWidth;

    public NeutralRefreshAnimView(Context context) {
        super(context);
        init();
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.dbg = new PointF();
        this.dbe = new Paint(1);
        this.dbf = new Paint(1);
        this.dbe.setColor(dba);
        this.dbf.setColor(dba);
    }

    public void setAnimPercent(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        this.dbd = f3;
        ju(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f3);
        }
    }

    public boolean ha(int i) {
        if (this.dbf == null || this.dbe == null) {
            return false;
        }
        this.dbe.setColor(i);
        this.dbf.setColor(i);
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.dbg.set(this.mWidth >> 1, this.mHeight >> 1);
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    NeutralRefreshAnimView.this.mBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    NeutralRefreshAnimView.this.mCanvas = new Canvas(NeutralRefreshAnimView.this.mBitmap);
                }
            }, "CreateBitmapOnSizeChanged");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        switch (this.mState) {
            case 1:
                q(canvas);
                break;
            case 2:
                r(canvas);
                break;
            case 3:
                s(canvas);
                break;
            case 4:
                r(canvas);
                break;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(int i) {
        this.mState = i;
        if (DEBUG) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.mState);
        }
    }

    private void q(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            if (this.dbd == 0.0f) {
                this.dbf.setAlpha(0);
                this.mCanvas.drawCircle(this.dbg.x, this.dbg.y, daZ, this.dbf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            } else if (this.dbd <= 0.5f) {
                int i = (int) (this.dbd * 77.0f);
                this.dbf.setAlpha(i);
                this.mCanvas.drawCircle(this.dbg.x, this.dbg.y, daZ, this.dbf);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
                }
            } else if (this.dbd < 1.0f) {
                int jv = jv((int) (this.dbd * 77.0f));
                this.dbf.setAlpha(jv);
                float f = (this.dbd - 0.5f) * 2.0f;
                int jv2 = jv((int) (26.0f * f));
                this.dbe.setAlpha(jv2);
                this.mCanvas.drawCircle(this.dbg.x + (dbc * f), this.dbg.y, daZ, this.dbf);
                this.mCanvas.drawCircle(this.dbg.x - (dbc * f), this.dbg.y, daZ, this.dbe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.dbd);
                    Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + jv);
                    Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + jv2);
                    Log.e("NeutralRefreshAnimView", "second level,fraction=" + f);
                    Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (f * dbc));
                }
            } else if (this.dbd == 1.0f) {
                this.dbe.setAlpha(26);
                this.dbf.setAlpha(77);
                this.mCanvas.drawCircle(this.dbg.x + dbc, this.dbg.y, daZ, this.dbf);
                this.mCanvas.drawCircle(this.dbg.x - dbc, this.dbg.y, daZ, this.dbe);
                canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
                if (DEBUG) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.dbd);
                }
            }
        }
    }

    public void aCf() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        ju(2);
        aCg();
    }

    private void aCg() {
        aCe();
        this.dbi = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.dbi.setDuration(480L);
        this.dbi.setRepeatMode(2);
        this.dbi.setRepeatCount(-1);
        this.dbi.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dbi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dbj = NeutralRefreshAnimView.dbc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.dbj + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.dbh = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.dbh.setDuration(480L);
        this.dbh.setRepeatMode(2);
        this.dbh.setRepeatCount(-1);
        this.dbh.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dbh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                NeutralRefreshAnimView.this.dbk = NeutralRefreshAnimView.dbc * floatValue;
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.dbk + ",anim value=" + floatValue);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(this.dbh, this.dbi);
        this.mAnimatorSet.setDuration(480L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NeutralRefreshAnimView.this.ju(4);
                NeutralRefreshAnimView.this.postInvalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        if (!this.mAnimatorSet.isRunning()) {
            this.mAnimatorSet.start();
        }
    }

    private void r(Canvas canvas) {
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dbf.setAlpha(77);
            this.mCanvas.drawCircle(this.dbg.x + this.dbj, this.dbg.y, daZ, this.dbf);
            this.dbe.setAlpha(26);
            this.mCanvas.drawCircle(this.dbg.x + this.dbk, this.dbg.y, daZ, this.dbe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
            }
        }
    }

    public void aCh() {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        stopAnim();
        ju(3);
        aCi();
    }

    private void aCi() {
        this.dbl = ValueAnimator.ofInt(26, 0);
        this.dbl.setDuration(300L);
        this.dbl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dbn = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dbn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dbl.isRunning()) {
            this.dbl.start();
        }
        this.dbm = ValueAnimator.ofInt(77, 0);
        this.dbm.setDuration(300L);
        this.dbm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.NeutralRefreshAnimView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NeutralRefreshAnimView.this.dbo = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (NeutralRefreshAnimView.DEBUG) {
                    Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.dbn);
                }
                NeutralRefreshAnimView.this.postInvalidate();
            }
        });
        if (!this.dbm.isRunning()) {
            this.dbm.start();
        }
    }

    private void s(Canvas canvas) {
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        if (this.mBitmap != null && this.mCanvas != null) {
            this.mBitmap.eraseColor(0);
            this.dbn = jv(this.dbn);
            this.dbo = jv(this.dbo);
            this.dbf.setAlpha(this.dbo);
            this.dbe.setAlpha(this.dbn);
            this.mCanvas.drawCircle(this.dbg.x + this.dbj, this.dbg.y, daZ, this.dbf);
            this.dbe.setAlpha(this.dbn);
            this.mCanvas.drawCircle(this.dbg.x + this.dbk, this.dbg.y, daZ, this.dbe);
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, (Paint) null);
            if (DEBUG) {
                Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.dbn);
                Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.dbj);
                Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.dbk);
            }
        }
    }

    public void stopAnim() {
        aCe();
        clearAnimation();
        ju(1);
        postInvalidate();
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "stopAnim");
        }
    }

    private void a(ValueAnimator valueAnimator, boolean z) {
        if (valueAnimator != null) {
            if (z) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    private void aCe() {
        a(this.dbh, true);
        a(this.dbi, true);
        a(this.dbl, false);
        a(this.dbm, false);
        if (this.mAnimatorSet != null) {
            this.mAnimatorSet.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet.cancel();
        }
        if (DEBUG) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    private int jv(int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }
}
