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
/* loaded from: classes10.dex */
public class TransparentHeadGridView extends GridView {
    private float bIH;
    private boolean bII;
    private int bIJ;
    private View bIK;
    private Interpolator bIL;
    private d bIM;
    private int bIN;
    private a bIO;
    private b bIP;
    private AbsListView.OnScrollListener bIQ;
    private int bIR;
    private boolean bIS;
    private Animation.AnimationListener bIT;
    private c bIU;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes10.dex */
    public interface a {
        void eQ(int i);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Tm();

        void eR(int i);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void Tl();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bIH = 0.0f;
        this.bII = true;
        this.bIJ = -1;
        this.bIR = -1;
        this.bIS = false;
        this.bIT = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIU = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Tl() {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIP != null) {
                    TransparentHeadGridView.this.bIP.Tm();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIO != null && TransparentHeadGridView.this.bIR != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIO.eQ(100);
                        TransparentHeadGridView.this.bIR = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIJ < 0) {
                        TransparentHeadGridView.this.bIJ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIJ);
                    TransparentHeadGridView.this.bII = i4 == 0;
                    if (TransparentHeadGridView.this.bIK != null) {
                        TransparentHeadGridView.this.bIK.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIO != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIR) {
                        TransparentHeadGridView.this.bIO.eQ(height);
                        TransparentHeadGridView.this.bIR = height;
                    }
                }
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bIH = 0.0f;
        this.bII = true;
        this.bIJ = -1;
        this.bIR = -1;
        this.bIS = false;
        this.bIT = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIU = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Tl() {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIP != null) {
                    TransparentHeadGridView.this.bIP.Tm();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIO != null && TransparentHeadGridView.this.bIR != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIO.eQ(100);
                        TransparentHeadGridView.this.bIR = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIJ < 0) {
                        TransparentHeadGridView.this.bIJ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIJ);
                    TransparentHeadGridView.this.bII = i4 == 0;
                    if (TransparentHeadGridView.this.bIK != null) {
                        TransparentHeadGridView.this.bIK.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIO != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIR) {
                        TransparentHeadGridView.this.bIO.eQ(height);
                        TransparentHeadGridView.this.bIR = height;
                    }
                }
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bIH = 0.0f;
        this.bII = true;
        this.bIJ = -1;
        this.bIR = -1;
        this.bIS = false;
        this.bIT = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bIU = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void Tl() {
                if (TransparentHeadGridView.this.bIS) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bIP != null) {
                    TransparentHeadGridView.this.bIP.Tm();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bIO != null && TransparentHeadGridView.this.bIR != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bIO.eQ(100);
                        TransparentHeadGridView.this.bIR = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bIJ < 0) {
                        TransparentHeadGridView.this.bIJ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bIJ);
                    TransparentHeadGridView.this.bII = i4 == 0;
                    if (TransparentHeadGridView.this.bIK != null) {
                        TransparentHeadGridView.this.bIK.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bIO != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bIR) {
                        TransparentHeadGridView.this.bIO.eQ(height);
                        TransparentHeadGridView.this.bIR = height;
                    }
                }
                if (TransparentHeadGridView.this.bIQ != null) {
                    TransparentHeadGridView.this.bIQ.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bIN = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bIH = 0.0f;
                if (this.bIS && getPaddingTop() > this.bIN) {
                    a(getHeight(), 200L, 0L, this.bIU);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bIH == 0.0f) {
                    this.bIH = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bIH && getPaddingTop() == 0 && this.bII) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bIH) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bIP != null && i >= 0 && this.bIN > 0 && i <= this.bIN) {
                        this.bIP.eR((i * 100) / this.bIN);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Tk() {
        setPadding(0, (int) ((10.0f - this.bIH) / 2.0f), 0, 0);
        this.mState = 0;
        this.bIH = 0.0f;
        if (this.bIS && getPaddingTop() > this.bIN) {
            a(getHeight(), 200L, 0L, this.bIU);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bIQ = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bIK = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bIM != null) {
            this.bIM.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bIL == null) {
                this.bIL = new DecelerateInterpolator();
            }
            this.bIM = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bIM, j2);
            } else {
                post(this.bIM);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        private final int bIW;
        private final int bIX;
        private c bIY;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bIZ = true;
        private long mStartTime = -1;
        private int bJa = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bIX = i;
            this.bIW = i2;
            this.mInterpolator = TransparentHeadGridView.this.bIL;
            this.mDuration = j;
            this.bIY = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJa = this.bIX - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bIX - this.bIW));
                TransparentHeadGridView.this.setPadding(0, this.bJa, 0, 0);
                if (TransparentHeadGridView.this.bIP != null && this.bJa >= 0 && TransparentHeadGridView.this.bIN > 0 && this.bJa <= TransparentHeadGridView.this.bIN) {
                    TransparentHeadGridView.this.bIP.eR((this.bJa * 100) / TransparentHeadGridView.this.bIN);
                }
            }
            if (this.bIZ && this.bIW != this.bJa) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bIY != null) {
                this.bIY.Tl();
            }
        }

        public void stop() {
            this.bIZ = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bIO = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bIP = bVar;
    }
}
