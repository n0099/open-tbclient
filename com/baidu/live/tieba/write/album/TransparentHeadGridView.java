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
/* loaded from: classes7.dex */
public class TransparentHeadGridView extends GridView {
    private float bpM;
    private boolean bpN;
    private int bpO;
    private View bpP;
    private Interpolator bpQ;
    private d bpR;
    private int bpS;
    private a bpT;
    private b bpU;
    private AbsListView.OnScrollListener bpV;
    private int bpW;
    private boolean bpX;
    private Animation.AnimationListener bpY;
    private c bpZ;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes7.dex */
    public interface a {
        void fs(int i);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void Pa();

        void ft(int i);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void OZ();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bpM = 0.0f;
        this.bpN = true;
        this.bpO = -1;
        this.bpW = -1;
        this.bpX = false;
        this.bpY = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpZ = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpU != null) {
                    TransparentHeadGridView.this.bpU.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpT != null && TransparentHeadGridView.this.bpW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpT.fs(100);
                        TransparentHeadGridView.this.bpW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpO < 0) {
                        TransparentHeadGridView.this.bpO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpO);
                    TransparentHeadGridView.this.bpN = i4 == 0;
                    if (TransparentHeadGridView.this.bpP != null) {
                        TransparentHeadGridView.this.bpP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpW) {
                        TransparentHeadGridView.this.bpT.fs(height);
                        TransparentHeadGridView.this.bpW = height;
                    }
                }
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bpM = 0.0f;
        this.bpN = true;
        this.bpO = -1;
        this.bpW = -1;
        this.bpX = false;
        this.bpY = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpZ = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpU != null) {
                    TransparentHeadGridView.this.bpU.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpT != null && TransparentHeadGridView.this.bpW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpT.fs(100);
                        TransparentHeadGridView.this.bpW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpO < 0) {
                        TransparentHeadGridView.this.bpO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpO);
                    TransparentHeadGridView.this.bpN = i4 == 0;
                    if (TransparentHeadGridView.this.bpP != null) {
                        TransparentHeadGridView.this.bpP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpW) {
                        TransparentHeadGridView.this.bpT.fs(height);
                        TransparentHeadGridView.this.bpW = height;
                    }
                }
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bpM = 0.0f;
        this.bpN = true;
        this.bpO = -1;
        this.bpW = -1;
        this.bpX = false;
        this.bpY = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpZ = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpU != null) {
                    TransparentHeadGridView.this.bpU.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpT != null && TransparentHeadGridView.this.bpW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpT.fs(100);
                        TransparentHeadGridView.this.bpW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpO < 0) {
                        TransparentHeadGridView.this.bpO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpO);
                    TransparentHeadGridView.this.bpN = i4 == 0;
                    if (TransparentHeadGridView.this.bpP != null) {
                        TransparentHeadGridView.this.bpP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpW) {
                        TransparentHeadGridView.this.bpT.fs(height);
                        TransparentHeadGridView.this.bpW = height;
                    }
                }
                if (TransparentHeadGridView.this.bpV != null) {
                    TransparentHeadGridView.this.bpV.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bpS = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bpM = 0.0f;
                if (this.bpX && getPaddingTop() > this.bpS) {
                    a(getHeight(), 200L, 0L, this.bpZ);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bpM == 0.0f) {
                    this.bpM = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bpM && getPaddingTop() == 0 && this.bpN) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bpM) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bpU != null && i >= 0 && this.bpS > 0 && i <= this.bpS) {
                        this.bpU.ft((i * 100) / this.bpS);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void OY() {
        setPadding(0, (int) ((10.0f - this.bpM) / 2.0f), 0, 0);
        this.mState = 0;
        this.bpM = 0.0f;
        if (this.bpX && getPaddingTop() > this.bpS) {
            a(getHeight(), 200L, 0L, this.bpZ);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bpV = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bpP = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bpR != null) {
            this.bpR.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bpQ == null) {
                this.bpQ = new DecelerateInterpolator();
            }
            this.bpR = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bpR, j2);
            } else {
                post(this.bpR);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        private final int bqb;
        private final int bqc;
        private c bqd;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bqe = true;
        private long mStartTime = -1;
        private int bqf = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bqc = i;
            this.bqb = i2;
            this.mInterpolator = TransparentHeadGridView.this.bpQ;
            this.mDuration = j;
            this.bqd = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bqf = this.bqc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bqc - this.bqb));
                TransparentHeadGridView.this.setPadding(0, this.bqf, 0, 0);
                if (TransparentHeadGridView.this.bpU != null && this.bqf >= 0 && TransparentHeadGridView.this.bpS > 0 && this.bqf <= TransparentHeadGridView.this.bpS) {
                    TransparentHeadGridView.this.bpU.ft((this.bqf * 100) / TransparentHeadGridView.this.bpS);
                }
            }
            if (this.bqe && this.bqb != this.bqf) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bqd != null) {
                this.bqd.OZ();
            }
        }

        public void stop() {
            this.bqe = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bpT = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bpU = bVar;
    }
}
