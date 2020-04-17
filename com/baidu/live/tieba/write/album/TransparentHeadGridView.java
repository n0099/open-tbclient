package com.baidu.live.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes3.dex */
public class TransparentHeadGridView extends GridView {
    private float aXa;
    private boolean aXb;
    private int aXc;
    private View aXd;
    private Interpolator aXe;
    private d aXf;
    private int aXg;
    private a aXh;
    private b aXi;
    private AbsListView.OnScrollListener aXj;
    private int aXk;
    private boolean aXl;
    private Animation.AnimationListener aXm;
    private c aXn;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void di(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void FX();

        void dj(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void FW();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aXa = 0.0f;
        this.aXb = true;
        this.aXc = -1;
        this.aXk = -1;
        this.aXl = false;
        this.aXm = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aXn = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void FW() {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aXi != null) {
                    TransparentHeadGridView.this.aXi.FX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aXh != null && TransparentHeadGridView.this.aXk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aXh.di(100);
                        TransparentHeadGridView.this.aXk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXc < 0) {
                        TransparentHeadGridView.this.aXc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXc);
                    TransparentHeadGridView.this.aXb = i4 == 0;
                    if (TransparentHeadGridView.this.aXd != null) {
                        TransparentHeadGridView.this.aXd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aXh != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXk) {
                        TransparentHeadGridView.this.aXh.di(height);
                        TransparentHeadGridView.this.aXk = height;
                    }
                }
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aXa = 0.0f;
        this.aXb = true;
        this.aXc = -1;
        this.aXk = -1;
        this.aXl = false;
        this.aXm = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aXn = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void FW() {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aXi != null) {
                    TransparentHeadGridView.this.aXi.FX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aXh != null && TransparentHeadGridView.this.aXk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aXh.di(100);
                        TransparentHeadGridView.this.aXk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXc < 0) {
                        TransparentHeadGridView.this.aXc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXc);
                    TransparentHeadGridView.this.aXb = i4 == 0;
                    if (TransparentHeadGridView.this.aXd != null) {
                        TransparentHeadGridView.this.aXd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aXh != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXk) {
                        TransparentHeadGridView.this.aXh.di(height);
                        TransparentHeadGridView.this.aXk = height;
                    }
                }
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aXa = 0.0f;
        this.aXb = true;
        this.aXc = -1;
        this.aXk = -1;
        this.aXl = false;
        this.aXm = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aXn = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void FW() {
                if (TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aXi != null) {
                    TransparentHeadGridView.this.aXi.FX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aXh != null && TransparentHeadGridView.this.aXk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aXh.di(100);
                        TransparentHeadGridView.this.aXk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXc < 0) {
                        TransparentHeadGridView.this.aXc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXc);
                    TransparentHeadGridView.this.aXb = i4 == 0;
                    if (TransparentHeadGridView.this.aXd != null) {
                        TransparentHeadGridView.this.aXd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aXh != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXk) {
                        TransparentHeadGridView.this.aXh.di(height);
                        TransparentHeadGridView.this.aXk = height;
                    }
                }
                if (TransparentHeadGridView.this.aXj != null) {
                    TransparentHeadGridView.this.aXj.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aXg = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aXa = 0.0f;
                if (this.aXl && getPaddingTop() > this.aXg) {
                    a(getHeight(), 200L, 0L, this.aXn);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aXa == 0.0f) {
                    this.aXa = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aXa && getPaddingTop() == 0 && this.aXb) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aXa) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.aXi != null && i >= 0 && this.aXg > 0 && i <= this.aXg) {
                        this.aXi.dj((i * 100) / this.aXg);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void FV() {
        setPadding(0, (int) ((10.0f - this.aXa) / 2.0f), 0, 0);
        this.mState = 0;
        this.aXa = 0.0f;
        if (this.aXl && getPaddingTop() > this.aXg) {
            a(getHeight(), 200L, 0L, this.aXn);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aXj = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aXd = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.aXf != null) {
            this.aXf.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aXe == null) {
                this.aXe = new DecelerateInterpolator();
            }
            this.aXf = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.aXf, j2);
            } else {
                post(this.aXf);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aXp;
        private final int aXq;
        private c aXr;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aXs = true;
        private long mStartTime = -1;
        private int aXt = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aXq = i;
            this.aXp = i2;
            this.mInterpolator = TransparentHeadGridView.this.aXe;
            this.mDuration = j;
            this.aXr = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aXt = this.aXq - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aXq - this.aXp));
                TransparentHeadGridView.this.setPadding(0, this.aXt, 0, 0);
                if (TransparentHeadGridView.this.aXi != null && this.aXt >= 0 && TransparentHeadGridView.this.aXg > 0 && this.aXt <= TransparentHeadGridView.this.aXg) {
                    TransparentHeadGridView.this.aXi.dj((this.aXt * 100) / TransparentHeadGridView.this.aXg);
                }
            }
            if (this.aXs && this.aXp != this.aXt) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.aXr != null) {
                this.aXr.FW();
            }
        }

        public void stop() {
            this.aXs = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.aXh = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.aXi = bVar;
    }
}
