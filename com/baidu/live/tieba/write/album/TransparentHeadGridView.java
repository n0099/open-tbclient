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
    private float bNR;
    private boolean bNS;
    private int bNT;
    private View bNU;
    private Interpolator bNV;
    private d bNW;
    private int bNX;
    private a bNY;
    private b bNZ;
    private AbsListView.OnScrollListener bOa;
    private int bOb;
    private boolean bOc;
    private Animation.AnimationListener bOd;
    private c bOe;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes10.dex */
    public interface a {
        void eV(int i);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void UW();

        void eW(int i);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void UV();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bNR = 0.0f;
        this.bNS = true;
        this.bNT = -1;
        this.bOb = -1;
        this.bOc = false;
        this.bOd = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bOe = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void UV() {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNZ != null) {
                    TransparentHeadGridView.this.bNZ.UW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNY != null && TransparentHeadGridView.this.bOb != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNY.eV(100);
                        TransparentHeadGridView.this.bOb = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNT < 0) {
                        TransparentHeadGridView.this.bNT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNT);
                    TransparentHeadGridView.this.bNS = i4 == 0;
                    if (TransparentHeadGridView.this.bNU != null) {
                        TransparentHeadGridView.this.bNU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNY != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bOb) {
                        TransparentHeadGridView.this.bNY.eV(height);
                        TransparentHeadGridView.this.bOb = height;
                    }
                }
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bNR = 0.0f;
        this.bNS = true;
        this.bNT = -1;
        this.bOb = -1;
        this.bOc = false;
        this.bOd = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bOe = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void UV() {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNZ != null) {
                    TransparentHeadGridView.this.bNZ.UW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNY != null && TransparentHeadGridView.this.bOb != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNY.eV(100);
                        TransparentHeadGridView.this.bOb = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNT < 0) {
                        TransparentHeadGridView.this.bNT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNT);
                    TransparentHeadGridView.this.bNS = i4 == 0;
                    if (TransparentHeadGridView.this.bNU != null) {
                        TransparentHeadGridView.this.bNU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNY != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bOb) {
                        TransparentHeadGridView.this.bNY.eV(height);
                        TransparentHeadGridView.this.bOb = height;
                    }
                }
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bNR = 0.0f;
        this.bNS = true;
        this.bNT = -1;
        this.bOb = -1;
        this.bOc = false;
        this.bOd = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bOe = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void UV() {
                if (TransparentHeadGridView.this.bOc) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.bNZ != null) {
                    TransparentHeadGridView.this.bNZ.UW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.bNY != null && TransparentHeadGridView.this.bOb != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.bNY.eV(100);
                        TransparentHeadGridView.this.bOb = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNT < 0) {
                        TransparentHeadGridView.this.bNT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNT);
                    TransparentHeadGridView.this.bNS = i4 == 0;
                    if (TransparentHeadGridView.this.bNU != null) {
                        TransparentHeadGridView.this.bNU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.bNY != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bOb) {
                        TransparentHeadGridView.this.bNY.eV(height);
                        TransparentHeadGridView.this.bOb = height;
                    }
                }
                if (TransparentHeadGridView.this.bOa != null) {
                    TransparentHeadGridView.this.bOa.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bNX = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bNR = 0.0f;
                if (this.bOc && getPaddingTop() > this.bNX) {
                    a(getHeight(), 200L, 0L, this.bOe);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bNR == 0.0f) {
                    this.bNR = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bNR && getPaddingTop() == 0 && this.bNS) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bNR) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.bNZ != null && i >= 0 && this.bNX > 0 && i <= this.bNX) {
                        this.bNZ.eW((i * 100) / this.bNX);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void UU() {
        setPadding(0, (int) ((10.0f - this.bNR) / 2.0f), 0, 0);
        this.mState = 0;
        this.bNR = 0.0f;
        if (this.bOc && getPaddingTop() > this.bNX) {
            a(getHeight(), 200L, 0L, this.bOe);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bOa = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bNU = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bNW != null) {
            this.bNW.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bNV == null) {
                this.bNV = new DecelerateInterpolator();
            }
            this.bNW = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bNW, j2);
            } else {
                post(this.bNW);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        private final int bOg;
        private final int bOh;
        private c bOi;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bOj = true;
        private long mStartTime = -1;
        private int bOk = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bOh = i;
            this.bOg = i2;
            this.mInterpolator = TransparentHeadGridView.this.bNV;
            this.mDuration = j;
            this.bOi = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bOk = this.bOh - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bOh - this.bOg));
                TransparentHeadGridView.this.setPadding(0, this.bOk, 0, 0);
                if (TransparentHeadGridView.this.bNZ != null && this.bOk >= 0 && TransparentHeadGridView.this.bNX > 0 && this.bOk <= TransparentHeadGridView.this.bNX) {
                    TransparentHeadGridView.this.bNZ.eW((this.bOk * 100) / TransparentHeadGridView.this.bNX);
                }
            }
            if (this.bOj && this.bOg != this.bOk) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.bOi != null) {
                this.bOi.UV();
            }
        }

        public void stop() {
            this.bOj = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.bNY = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.bNZ = bVar;
    }
}
