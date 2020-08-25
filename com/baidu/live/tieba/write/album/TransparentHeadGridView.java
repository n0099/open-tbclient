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
    private float bpJ;
    private boolean bpK;
    private int bpL;
    private View bpM;
    private Interpolator bpN;
    private d bpO;
    private int bpP;
    private a bpQ;
    private b bpR;
    private AbsListView.OnScrollListener bpS;
    private int bpT;
    private boolean bpU;
    private Animation.AnimationListener bpV;
    private c bpW;
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
        this.bpJ = 0.0f;
        this.bpK = true;
        this.bpL = -1;
        this.bpT = -1;
        this.bpU = false;
        this.bpV = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpW = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpR != null) {
                    TransparentHeadGridView.this.bpR.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpQ != null && TransparentHeadGridView.this.bpT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpQ.fs(100);
                        TransparentHeadGridView.this.bpT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpL < 0) {
                        TransparentHeadGridView.this.bpL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpL);
                    TransparentHeadGridView.this.bpK = i4 == 0;
                    if (TransparentHeadGridView.this.bpM != null) {
                        TransparentHeadGridView.this.bpM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpT) {
                        TransparentHeadGridView.this.bpQ.fs(height);
                        TransparentHeadGridView.this.bpT = height;
                    }
                }
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bpJ = 0.0f;
        this.bpK = true;
        this.bpL = -1;
        this.bpT = -1;
        this.bpU = false;
        this.bpV = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpW = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpR != null) {
                    TransparentHeadGridView.this.bpR.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpQ != null && TransparentHeadGridView.this.bpT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpQ.fs(100);
                        TransparentHeadGridView.this.bpT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpL < 0) {
                        TransparentHeadGridView.this.bpL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpL);
                    TransparentHeadGridView.this.bpK = i4 == 0;
                    if (TransparentHeadGridView.this.bpM != null) {
                        TransparentHeadGridView.this.bpM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpT) {
                        TransparentHeadGridView.this.bpQ.fs(height);
                        TransparentHeadGridView.this.bpT = height;
                    }
                }
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bpJ = 0.0f;
        this.bpK = true;
        this.bpL = -1;
        this.bpT = -1;
        this.bpU = false;
        this.bpV = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bpW = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void OZ() {
                if (TransparentHeadGridView.this.bpU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bpR != null) {
                    TransparentHeadGridView.this.bpR.Pa();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bpQ != null && TransparentHeadGridView.this.bpT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bpQ.fs(100);
                        TransparentHeadGridView.this.bpT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bpL < 0) {
                        TransparentHeadGridView.this.bpL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bpL);
                    TransparentHeadGridView.this.bpK = i4 == 0;
                    if (TransparentHeadGridView.this.bpM != null) {
                        TransparentHeadGridView.this.bpM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bpQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bpT) {
                        TransparentHeadGridView.this.bpQ.fs(height);
                        TransparentHeadGridView.this.bpT = height;
                    }
                }
                if (TransparentHeadGridView.this.bpS != null) {
                    TransparentHeadGridView.this.bpS.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bpP = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bpJ = 0.0f;
                if (this.bpU && getPaddingTop() > this.bpP) {
                    a(getHeight(), 200L, 0L, this.bpW);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bpJ == 0.0f) {
                    this.bpJ = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bpJ && getPaddingTop() == 0 && this.bpK) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bpJ) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bpR != null && i >= 0 && this.bpP > 0 && i <= this.bpP) {
                        this.bpR.ft((i * 100) / this.bpP);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void OY() {
        setPadding(0, (int) ((10.0f - this.bpJ) / 2.0f), 0, 0);
        this.mState = 0;
        this.bpJ = 0.0f;
        if (this.bpU && getPaddingTop() > this.bpP) {
            a(getHeight(), 200L, 0L, this.bpW);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bpS = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bpM = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bpO != null) {
            this.bpO.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bpN == null) {
                this.bpN = new DecelerateInterpolator();
            }
            this.bpO = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bpO, j2);
            } else {
                post(this.bpO);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        private final int bpY;
        private final int bpZ;
        private c bqa;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bqb = true;
        private long mStartTime = -1;
        private int bqc = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bpZ = i;
            this.bpY = i2;
            this.mInterpolator = TransparentHeadGridView.this.bpN;
            this.mDuration = j;
            this.bqa = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bqc = this.bpZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bpZ - this.bpY));
                TransparentHeadGridView.this.setPadding(0, this.bqc, 0, 0);
                if (TransparentHeadGridView.this.bpR != null && this.bqc >= 0 && TransparentHeadGridView.this.bpP > 0 && this.bqc <= TransparentHeadGridView.this.bpP) {
                    TransparentHeadGridView.this.bpR.ft((this.bqc * 100) / TransparentHeadGridView.this.bpP);
                }
            }
            if (this.bqb && this.bpY != this.bqc) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bqa != null) {
                this.bqa.OZ();
            }
        }

        public void stop() {
            this.bqb = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bpQ = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bpR = bVar;
    }
}
