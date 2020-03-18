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
    private b aDA;
    private AbsListView.OnScrollListener aDB;
    private int aDC;
    private boolean aDD;
    private Animation.AnimationListener aDE;
    private c aDF;
    private float aDs;
    private boolean aDt;
    private int aDu;
    private View aDv;
    private Interpolator aDw;
    private d aDx;
    private int aDy;
    private a aDz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void cT(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void AZ();

        void cU(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void AY();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aDs = 0.0f;
        this.aDt = true;
        this.aDu = -1;
        this.aDC = -1;
        this.aDD = false;
        this.aDE = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDF = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AY() {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDA != null) {
                    TransparentHeadGridView.this.aDA.AZ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDz != null && TransparentHeadGridView.this.aDC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDz.cT(100);
                        TransparentHeadGridView.this.aDC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDu < 0) {
                        TransparentHeadGridView.this.aDu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDu);
                    TransparentHeadGridView.this.aDt = i4 == 0;
                    if (TransparentHeadGridView.this.aDv != null) {
                        TransparentHeadGridView.this.aDv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDC) {
                        TransparentHeadGridView.this.aDz.cT(height);
                        TransparentHeadGridView.this.aDC = height;
                    }
                }
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aDs = 0.0f;
        this.aDt = true;
        this.aDu = -1;
        this.aDC = -1;
        this.aDD = false;
        this.aDE = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDF = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AY() {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDA != null) {
                    TransparentHeadGridView.this.aDA.AZ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDz != null && TransparentHeadGridView.this.aDC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDz.cT(100);
                        TransparentHeadGridView.this.aDC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDu < 0) {
                        TransparentHeadGridView.this.aDu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDu);
                    TransparentHeadGridView.this.aDt = i4 == 0;
                    if (TransparentHeadGridView.this.aDv != null) {
                        TransparentHeadGridView.this.aDv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDC) {
                        TransparentHeadGridView.this.aDz.cT(height);
                        TransparentHeadGridView.this.aDC = height;
                    }
                }
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aDs = 0.0f;
        this.aDt = true;
        this.aDu = -1;
        this.aDC = -1;
        this.aDD = false;
        this.aDE = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDF = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AY() {
                if (TransparentHeadGridView.this.aDD) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDA != null) {
                    TransparentHeadGridView.this.aDA.AZ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDz != null && TransparentHeadGridView.this.aDC != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDz.cT(100);
                        TransparentHeadGridView.this.aDC = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDu < 0) {
                        TransparentHeadGridView.this.aDu = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDu);
                    TransparentHeadGridView.this.aDt = i4 == 0;
                    if (TransparentHeadGridView.this.aDv != null) {
                        TransparentHeadGridView.this.aDv.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDz != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDC) {
                        TransparentHeadGridView.this.aDz.cT(height);
                        TransparentHeadGridView.this.aDC = height;
                    }
                }
                if (TransparentHeadGridView.this.aDB != null) {
                    TransparentHeadGridView.this.aDB.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aDy = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aDs = 0.0f;
                if (this.aDD && getPaddingTop() > this.aDy) {
                    a(getHeight(), 200L, 0L, this.aDF);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aDs == 0.0f) {
                    this.aDs = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aDs && getPaddingTop() == 0 && this.aDt) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aDs) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.aDA != null && i >= 0 && this.aDy > 0 && i <= this.aDy) {
                        this.aDA.cU((i * 100) / this.aDy);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void AX() {
        setPadding(0, (int) ((10.0f - this.aDs) / 2.0f), 0, 0);
        this.mState = 0;
        this.aDs = 0.0f;
        if (this.aDD && getPaddingTop() > this.aDy) {
            a(getHeight(), 200L, 0L, this.aDF);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aDB = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aDv = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.aDx != null) {
            this.aDx.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aDw == null) {
                this.aDw = new DecelerateInterpolator();
            }
            this.aDx = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.aDx, j2);
            } else {
                post(this.aDx);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aDH;
        private final int aDI;
        private c aDJ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDK = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aDI = i;
            this.aDH = i2;
            this.mInterpolator = TransparentHeadGridView.this.aDw;
            this.mDuration = j;
            this.aDJ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDI - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDI - this.aDH));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.aDA != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.aDy > 0 && this.mCurrentY <= TransparentHeadGridView.this.aDy) {
                    TransparentHeadGridView.this.aDA.cU((this.mCurrentY * 100) / TransparentHeadGridView.this.aDy);
                }
            }
            if (this.aDK && this.aDH != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.aDJ != null) {
                this.aDJ.AY();
            }
        }

        public void stop() {
            this.aDK = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.aDz = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.aDA = bVar;
    }
}
