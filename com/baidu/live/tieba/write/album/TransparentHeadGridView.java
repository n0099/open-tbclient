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
/* loaded from: classes11.dex */
public class TransparentHeadGridView extends GridView {
    private a bNA;
    private b bNB;
    private AbsListView.OnScrollListener bNC;
    private int bND;
    private boolean bNE;
    private Animation.AnimationListener bNF;
    private c bNG;
    private float bNt;
    private boolean bNu;
    private int bNv;
    private View bNw;
    private Interpolator bNx;
    private d bNy;
    private int bNz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes11.dex */
    public interface a {
        void gx(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void Xe();

        void gy(int i);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void Xd();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bNG = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Xd() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNB != null) {
                    TransparentHeadGridView.this.bNB.Xe();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNA != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNA.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.bNA.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bNG = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Xd() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNB != null) {
                    TransparentHeadGridView.this.bNB.Xe();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNA != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNA.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.bNA.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bNG = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Xd() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNB != null) {
                    TransparentHeadGridView.this.bNB.Xe();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNA != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNA.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNA != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.bNA.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bNz = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bNt = 0.0f;
                if (this.bNE && getPaddingTop() > this.bNz) {
                    a(getHeight(), 200L, 0L, this.bNG);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bNt == 0.0f) {
                    this.bNt = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bNt && getPaddingTop() == 0 && this.bNu) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bNt) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bNB != null && i >= 0 && this.bNz > 0 && i <= this.bNz) {
                        this.bNB.gy((i * 100) / this.bNz);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Xc() {
        setPadding(0, (int) ((10.0f - this.bNt) / 2.0f), 0, 0);
        this.mState = 0;
        this.bNt = 0.0f;
        if (this.bNE && getPaddingTop() > this.bNz) {
            a(getHeight(), 200L, 0L, this.bNG);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bNC = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bNw = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bNy != null) {
            this.bNy.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bNx == null) {
                this.bNx = new DecelerateInterpolator();
            }
            this.bNy = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bNy, j2);
            } else {
                post(this.bNy);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        private final int bNI;
        private final int bNJ;
        private c bNK;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bNL = true;
        private long mStartTime = -1;
        private int bNM = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bNJ = i;
            this.bNI = i2;
            this.mInterpolator = TransparentHeadGridView.this.bNx;
            this.mDuration = j;
            this.bNK = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bNM = this.bNJ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bNJ - this.bNI));
                TransparentHeadGridView.this.setPadding(0, this.bNM, 0, 0);
                if (TransparentHeadGridView.this.bNB != null && this.bNM >= 0 && TransparentHeadGridView.this.bNz > 0 && this.bNM <= TransparentHeadGridView.this.bNz) {
                    TransparentHeadGridView.this.bNB.gy((this.bNM * 100) / TransparentHeadGridView.this.bNz);
                }
            }
            if (this.bNL && this.bNI != this.bNM) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bNK != null) {
                this.bNK.Xd();
            }
        }

        public void stop() {
            this.bNL = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bNA = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bNB = bVar;
    }
}
