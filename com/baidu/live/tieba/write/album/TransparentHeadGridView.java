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
/* loaded from: classes6.dex */
public class TransparentHeadGridView extends GridView {
    private float aqG;
    private boolean aqH;
    private int aqI;
    private View aqJ;
    private Interpolator aqK;
    private d aqL;
    private int aqM;
    private a aqN;
    private b aqO;
    private AbsListView.OnScrollListener aqP;
    private int aqQ;
    private boolean aqR;
    private Animation.AnimationListener aqS;
    private c aqT;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes6.dex */
    public interface a {
        void ck(int i);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void cl(int i);

        void wk();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void wj();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aqG = 0.0f;
        this.aqH = true;
        this.aqI = -1;
        this.aqQ = -1;
        this.aqR = false;
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aqT = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void wj() {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aqO != null) {
                    TransparentHeadGridView.this.aqO.wk();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aqN != null && TransparentHeadGridView.this.aqQ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aqN.ck(100);
                        TransparentHeadGridView.this.aqQ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqI < 0) {
                        TransparentHeadGridView.this.aqI = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqI);
                    TransparentHeadGridView.this.aqH = i4 == 0;
                    if (TransparentHeadGridView.this.aqJ != null) {
                        TransparentHeadGridView.this.aqJ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aqN != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqQ) {
                        TransparentHeadGridView.this.aqN.ck(height);
                        TransparentHeadGridView.this.aqQ = height;
                    }
                }
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aqG = 0.0f;
        this.aqH = true;
        this.aqI = -1;
        this.aqQ = -1;
        this.aqR = false;
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aqT = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void wj() {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aqO != null) {
                    TransparentHeadGridView.this.aqO.wk();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aqN != null && TransparentHeadGridView.this.aqQ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aqN.ck(100);
                        TransparentHeadGridView.this.aqQ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqI < 0) {
                        TransparentHeadGridView.this.aqI = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqI);
                    TransparentHeadGridView.this.aqH = i4 == 0;
                    if (TransparentHeadGridView.this.aqJ != null) {
                        TransparentHeadGridView.this.aqJ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aqN != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqQ) {
                        TransparentHeadGridView.this.aqN.ck(height);
                        TransparentHeadGridView.this.aqQ = height;
                    }
                }
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aqG = 0.0f;
        this.aqH = true;
        this.aqI = -1;
        this.aqQ = -1;
        this.aqR = false;
        this.aqS = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aqT = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void wj() {
                if (TransparentHeadGridView.this.aqR) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aqO != null) {
                    TransparentHeadGridView.this.aqO.wk();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aqN != null && TransparentHeadGridView.this.aqQ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aqN.ck(100);
                        TransparentHeadGridView.this.aqQ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqI < 0) {
                        TransparentHeadGridView.this.aqI = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqI);
                    TransparentHeadGridView.this.aqH = i4 == 0;
                    if (TransparentHeadGridView.this.aqJ != null) {
                        TransparentHeadGridView.this.aqJ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aqN != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqQ) {
                        TransparentHeadGridView.this.aqN.ck(height);
                        TransparentHeadGridView.this.aqQ = height;
                    }
                }
                if (TransparentHeadGridView.this.aqP != null) {
                    TransparentHeadGridView.this.aqP.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aqM = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aqG = 0.0f;
                if (this.aqR && getPaddingTop() > this.aqM) {
                    a(getHeight(), 200L, 0L, this.aqT);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aqG == 0.0f) {
                    this.aqG = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aqG && getPaddingTop() == 0 && this.aqH) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aqG) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.aqO != null && i >= 0 && this.aqM > 0 && i <= this.aqM) {
                        this.aqO.cl((i * 100) / this.aqM);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void wi() {
        setPadding(0, (int) ((10.0f - this.aqG) / 2.0f), 0, 0);
        this.mState = 0;
        this.aqG = 0.0f;
        if (this.aqR && getPaddingTop() > this.aqM) {
            a(getHeight(), 200L, 0L, this.aqT);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aqP = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aqJ = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.aqL != null) {
            this.aqL.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aqK == null) {
                this.aqK = new DecelerateInterpolator();
            }
            this.aqL = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.aqL, j2);
            } else {
                post(this.aqL);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        private final int aqV;
        private final int aqW;
        private c aqX;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aqY = true;
        private long mStartTime = -1;
        private int aqZ = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aqW = i;
            this.aqV = i2;
            this.mInterpolator = TransparentHeadGridView.this.aqK;
            this.mDuration = j;
            this.aqX = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aqZ = this.aqW - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aqW - this.aqV));
                TransparentHeadGridView.this.setPadding(0, this.aqZ, 0, 0);
                if (TransparentHeadGridView.this.aqO != null && this.aqZ >= 0 && TransparentHeadGridView.this.aqM > 0 && this.aqZ <= TransparentHeadGridView.this.aqM) {
                    TransparentHeadGridView.this.aqO.cl((this.aqZ * 100) / TransparentHeadGridView.this.aqM);
                }
            }
            if (this.aqY && this.aqV != this.aqZ) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.aqX != null) {
                this.aqX.wj();
            }
        }

        public void stop() {
            this.aqY = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.aqN = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.aqO = bVar;
    }
}
