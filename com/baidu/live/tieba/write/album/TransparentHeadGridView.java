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
    private boolean beA;
    private int beB;
    private View beC;
    private Interpolator beD;
    private d beE;
    private int beF;
    private a beG;
    private b beH;
    private AbsListView.OnScrollListener beI;
    private int beJ;
    private boolean beK;
    private Animation.AnimationListener beL;
    private c beM;
    private float bez;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void dn(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void HP();

        /* renamed from: do  reason: not valid java name */
        void m21do(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void HO();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bez = 0.0f;
        this.beA = true;
        this.beB = -1;
        this.beJ = -1;
        this.beK = false;
        this.beL = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.beM = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void HO() {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.beH != null) {
                    TransparentHeadGridView.this.beH.HP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.beG != null && TransparentHeadGridView.this.beJ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.beG.dn(100);
                        TransparentHeadGridView.this.beJ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.beB < 0) {
                        TransparentHeadGridView.this.beB = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.beB);
                    TransparentHeadGridView.this.beA = i4 == 0;
                    if (TransparentHeadGridView.this.beC != null) {
                        TransparentHeadGridView.this.beC.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.beG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.beJ) {
                        TransparentHeadGridView.this.beG.dn(height);
                        TransparentHeadGridView.this.beJ = height;
                    }
                }
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bez = 0.0f;
        this.beA = true;
        this.beB = -1;
        this.beJ = -1;
        this.beK = false;
        this.beL = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.beM = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void HO() {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.beH != null) {
                    TransparentHeadGridView.this.beH.HP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.beG != null && TransparentHeadGridView.this.beJ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.beG.dn(100);
                        TransparentHeadGridView.this.beJ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.beB < 0) {
                        TransparentHeadGridView.this.beB = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.beB);
                    TransparentHeadGridView.this.beA = i4 == 0;
                    if (TransparentHeadGridView.this.beC != null) {
                        TransparentHeadGridView.this.beC.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.beG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.beJ) {
                        TransparentHeadGridView.this.beG.dn(height);
                        TransparentHeadGridView.this.beJ = height;
                    }
                }
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bez = 0.0f;
        this.beA = true;
        this.beB = -1;
        this.beJ = -1;
        this.beK = false;
        this.beL = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.beM = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void HO() {
                if (TransparentHeadGridView.this.beK) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.beH != null) {
                    TransparentHeadGridView.this.beH.HP();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.beG != null && TransparentHeadGridView.this.beJ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.beG.dn(100);
                        TransparentHeadGridView.this.beJ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.beB < 0) {
                        TransparentHeadGridView.this.beB = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.beB);
                    TransparentHeadGridView.this.beA = i4 == 0;
                    if (TransparentHeadGridView.this.beC != null) {
                        TransparentHeadGridView.this.beC.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.beG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.beJ) {
                        TransparentHeadGridView.this.beG.dn(height);
                        TransparentHeadGridView.this.beJ = height;
                    }
                }
                if (TransparentHeadGridView.this.beI != null) {
                    TransparentHeadGridView.this.beI.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.beF = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bez = 0.0f;
                if (this.beK && getPaddingTop() > this.beF) {
                    a(getHeight(), 200L, 0L, this.beM);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bez == 0.0f) {
                    this.bez = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bez && getPaddingTop() == 0 && this.beA) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bez) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.beH != null && i >= 0 && this.beF > 0 && i <= this.beF) {
                        this.beH.m21do((i * 100) / this.beF);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void HN() {
        setPadding(0, (int) ((10.0f - this.bez) / 2.0f), 0, 0);
        this.mState = 0;
        this.bez = 0.0f;
        if (this.beK && getPaddingTop() > this.beF) {
            a(getHeight(), 200L, 0L, this.beM);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.beI = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.beC = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.beE != null) {
            this.beE.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.beD == null) {
                this.beD = new DecelerateInterpolator();
            }
            this.beE = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.beE, j2);
            } else {
                post(this.beE);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int beO;
        private final int beP;
        private c beQ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean beR = true;
        private long mStartTime = -1;
        private int beS = -1;

        public d(int i, int i2, long j, c cVar) {
            this.beP = i;
            this.beO = i2;
            this.mInterpolator = TransparentHeadGridView.this.beD;
            this.mDuration = j;
            this.beQ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.beS = this.beP - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.beP - this.beO));
                TransparentHeadGridView.this.setPadding(0, this.beS, 0, 0);
                if (TransparentHeadGridView.this.beH != null && this.beS >= 0 && TransparentHeadGridView.this.beF > 0 && this.beS <= TransparentHeadGridView.this.beF) {
                    TransparentHeadGridView.this.beH.m21do((this.beS * 100) / TransparentHeadGridView.this.beF);
                }
            }
            if (this.beR && this.beO != this.beS) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.beQ != null) {
                this.beQ.HO();
            }
        }

        public void stop() {
            this.beR = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.beG = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.beH = bVar;
    }
}
