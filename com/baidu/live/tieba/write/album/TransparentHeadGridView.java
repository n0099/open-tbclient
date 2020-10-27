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
/* loaded from: classes4.dex */
public class TransparentHeadGridView extends GridView {
    private float byX;
    private boolean byY;
    private int byZ;
    private View bza;
    private Interpolator bzb;
    private d bzc;
    private int bzd;
    private a bze;
    private b bzf;
    private AbsListView.OnScrollListener bzg;
    private int bzh;
    private boolean bzi;
    private Animation.AnimationListener bzj;
    private c bzk;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes4.dex */
    public interface a {
        void fO(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void RD();

        void fP(int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void RC();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.byX = 0.0f;
        this.byY = true;
        this.byZ = -1;
        this.bzh = -1;
        this.bzi = false;
        this.bzj = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bzk = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void RC() {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bzf != null) {
                    TransparentHeadGridView.this.bzf.RD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bze != null && TransparentHeadGridView.this.bzh != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bze.fO(100);
                        TransparentHeadGridView.this.bzh = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.byZ < 0) {
                        TransparentHeadGridView.this.byZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.byZ);
                    TransparentHeadGridView.this.byY = i4 == 0;
                    if (TransparentHeadGridView.this.bza != null) {
                        TransparentHeadGridView.this.bza.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bze != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bzh) {
                        TransparentHeadGridView.this.bze.fO(height);
                        TransparentHeadGridView.this.bzh = height;
                    }
                }
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.byX = 0.0f;
        this.byY = true;
        this.byZ = -1;
        this.bzh = -1;
        this.bzi = false;
        this.bzj = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bzk = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void RC() {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bzf != null) {
                    TransparentHeadGridView.this.bzf.RD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bze != null && TransparentHeadGridView.this.bzh != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bze.fO(100);
                        TransparentHeadGridView.this.bzh = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.byZ < 0) {
                        TransparentHeadGridView.this.byZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.byZ);
                    TransparentHeadGridView.this.byY = i4 == 0;
                    if (TransparentHeadGridView.this.bza != null) {
                        TransparentHeadGridView.this.bza.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bze != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bzh) {
                        TransparentHeadGridView.this.bze.fO(height);
                        TransparentHeadGridView.this.bzh = height;
                    }
                }
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.byX = 0.0f;
        this.byY = true;
        this.byZ = -1;
        this.bzh = -1;
        this.bzi = false;
        this.bzj = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bzk = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void RC() {
                if (TransparentHeadGridView.this.bzi) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bzf != null) {
                    TransparentHeadGridView.this.bzf.RD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bze != null && TransparentHeadGridView.this.bzh != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bze.fO(100);
                        TransparentHeadGridView.this.bzh = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.byZ < 0) {
                        TransparentHeadGridView.this.byZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.byZ);
                    TransparentHeadGridView.this.byY = i4 == 0;
                    if (TransparentHeadGridView.this.bza != null) {
                        TransparentHeadGridView.this.bza.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bze != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bzh) {
                        TransparentHeadGridView.this.bze.fO(height);
                        TransparentHeadGridView.this.bzh = height;
                    }
                }
                if (TransparentHeadGridView.this.bzg != null) {
                    TransparentHeadGridView.this.bzg.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bzd = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.byX = 0.0f;
                if (this.bzi && getPaddingTop() > this.bzd) {
                    a(getHeight(), 200L, 0L, this.bzk);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.byX == 0.0f) {
                    this.byX = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.byX && getPaddingTop() == 0 && this.byY) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.byX) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bzf != null && i >= 0 && this.bzd > 0 && i <= this.bzd) {
                        this.bzf.fP((i * 100) / this.bzd);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void RB() {
        setPadding(0, (int) ((10.0f - this.byX) / 2.0f), 0, 0);
        this.mState = 0;
        this.byX = 0.0f;
        if (this.bzi && getPaddingTop() > this.bzd) {
            a(getHeight(), 200L, 0L, this.bzk);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bzg = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bza = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bzc != null) {
            this.bzc.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bzb == null) {
                this.bzb = new DecelerateInterpolator();
            }
            this.bzc = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bzc, j2);
            } else {
                post(this.bzc);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        private final int bzm;
        private final int bzn;
        private c bzo;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bzp = true;
        private long mStartTime = -1;
        private int bzq = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bzn = i;
            this.bzm = i2;
            this.mInterpolator = TransparentHeadGridView.this.bzb;
            this.mDuration = j;
            this.bzo = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bzq = this.bzn - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bzn - this.bzm));
                TransparentHeadGridView.this.setPadding(0, this.bzq, 0, 0);
                if (TransparentHeadGridView.this.bzf != null && this.bzq >= 0 && TransparentHeadGridView.this.bzd > 0 && this.bzq <= TransparentHeadGridView.this.bzd) {
                    TransparentHeadGridView.this.bzf.fP((this.bzq * 100) / TransparentHeadGridView.this.bzd);
                }
            }
            if (this.bzp && this.bzm != this.bzq) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bzo != null) {
                this.bzo.RC();
            }
        }

        public void stop() {
            this.bzp = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bze = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bzf = bVar;
    }
}
