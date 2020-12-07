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
    private float bIF;
    private boolean bIG;
    private int bIH;
    private View bII;
    private Interpolator bIJ;
    private d bIK;
    private int bIL;
    private a bIM;
    private b bIN;
    private AbsListView.OnScrollListener bIO;
    private int bIP;
    private boolean bIQ;
    private Animation.AnimationListener bIR;
    private c bIS;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes4.dex */
    public interface a {
        void gw(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void Wc();

        void gx(int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void Wb();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bIF = 0.0f;
        this.bIG = true;
        this.bIH = -1;
        this.bIP = -1;
        this.bIQ = false;
        this.bIR = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIS = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Wb() {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIN != null) {
                    TransparentHeadGridView.this.bIN.Wc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIM != null && TransparentHeadGridView.this.bIP != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIM.gw(100);
                        TransparentHeadGridView.this.bIP = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIH < 0) {
                        TransparentHeadGridView.this.bIH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIH);
                    TransparentHeadGridView.this.bIG = i4 == 0;
                    if (TransparentHeadGridView.this.bII != null) {
                        TransparentHeadGridView.this.bII.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIM != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIP) {
                        TransparentHeadGridView.this.bIM.gw(height);
                        TransparentHeadGridView.this.bIP = height;
                    }
                }
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bIF = 0.0f;
        this.bIG = true;
        this.bIH = -1;
        this.bIP = -1;
        this.bIQ = false;
        this.bIR = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIS = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Wb() {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIN != null) {
                    TransparentHeadGridView.this.bIN.Wc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIM != null && TransparentHeadGridView.this.bIP != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIM.gw(100);
                        TransparentHeadGridView.this.bIP = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIH < 0) {
                        TransparentHeadGridView.this.bIH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIH);
                    TransparentHeadGridView.this.bIG = i4 == 0;
                    if (TransparentHeadGridView.this.bII != null) {
                        TransparentHeadGridView.this.bII.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIM != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIP) {
                        TransparentHeadGridView.this.bIM.gw(height);
                        TransparentHeadGridView.this.bIP = height;
                    }
                }
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bIF = 0.0f;
        this.bIG = true;
        this.bIH = -1;
        this.bIP = -1;
        this.bIQ = false;
        this.bIR = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIS = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Wb() {
                if (TransparentHeadGridView.this.bIQ) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIN != null) {
                    TransparentHeadGridView.this.bIN.Wc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIM != null && TransparentHeadGridView.this.bIP != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIM.gw(100);
                        TransparentHeadGridView.this.bIP = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIH < 0) {
                        TransparentHeadGridView.this.bIH = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIH);
                    TransparentHeadGridView.this.bIG = i4 == 0;
                    if (TransparentHeadGridView.this.bII != null) {
                        TransparentHeadGridView.this.bII.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIM != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIP) {
                        TransparentHeadGridView.this.bIM.gw(height);
                        TransparentHeadGridView.this.bIP = height;
                    }
                }
                if (TransparentHeadGridView.this.bIO != null) {
                    TransparentHeadGridView.this.bIO.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bIL = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bIF = 0.0f;
                if (this.bIQ && getPaddingTop() > this.bIL) {
                    a(getHeight(), 200L, 0L, this.bIS);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bIF == 0.0f) {
                    this.bIF = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bIF && getPaddingTop() == 0 && this.bIG) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bIF) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bIN != null && i >= 0 && this.bIL > 0 && i <= this.bIL) {
                        this.bIN.gx((i * 100) / this.bIL);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Wa() {
        setPadding(0, (int) ((10.0f - this.bIF) / 2.0f), 0, 0);
        this.mState = 0;
        this.bIF = 0.0f;
        if (this.bIQ && getPaddingTop() > this.bIL) {
            a(getHeight(), 200L, 0L, this.bIS);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bIO = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bII = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bIK != null) {
            this.bIK.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bIJ == null) {
                this.bIJ = new DecelerateInterpolator();
            }
            this.bIK = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bIK, j2);
            } else {
                post(this.bIK);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        private final int bIU;
        private final int bIV;
        private c bIW;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bIX = true;
        private long mStartTime = -1;
        private int bIY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bIV = i;
            this.bIU = i2;
            this.mInterpolator = TransparentHeadGridView.this.bIJ;
            this.mDuration = j;
            this.bIW = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bIY = this.bIV - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bIV - this.bIU));
                TransparentHeadGridView.this.setPadding(0, this.bIY, 0, 0);
                if (TransparentHeadGridView.this.bIN != null && this.bIY >= 0 && TransparentHeadGridView.this.bIL > 0 && this.bIY <= TransparentHeadGridView.this.bIL) {
                    TransparentHeadGridView.this.bIN.gx((this.bIY * 100) / TransparentHeadGridView.this.bIL);
                }
            }
            if (this.bIX && this.bIU != this.bIY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bIW != null) {
                this.bIW.Wb();
            }
        }

        public void stop() {
            this.bIX = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bIM = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bIN = bVar;
    }
}
