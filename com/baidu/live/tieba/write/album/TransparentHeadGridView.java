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
    private float aDd;
    private boolean aDe;
    private int aDf;
    private View aDg;
    private Interpolator aDh;
    private d aDi;
    private int aDj;
    private a aDk;
    private b aDl;
    private AbsListView.OnScrollListener aDm;
    private int aDn;
    private boolean aDo;
    private Animation.AnimationListener aDp;
    private c aDq;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void cT(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void AS();

        void cU(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void AR();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDk != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDk.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.aDk.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDk != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDk.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.aDk.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aDd = 0.0f;
        this.aDe = true;
        this.aDf = -1;
        this.aDn = -1;
        this.aDo = false;
        this.aDp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aDq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.aDk != null && TransparentHeadGridView.this.aDn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.aDk.cT(100);
                        TransparentHeadGridView.this.aDn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDf < 0) {
                        TransparentHeadGridView.this.aDf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDf);
                    TransparentHeadGridView.this.aDe = i4 == 0;
                    if (TransparentHeadGridView.this.aDg != null) {
                        TransparentHeadGridView.this.aDg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.aDk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDn) {
                        TransparentHeadGridView.this.aDk.cT(height);
                        TransparentHeadGridView.this.aDn = height;
                    }
                }
                if (TransparentHeadGridView.this.aDm != null) {
                    TransparentHeadGridView.this.aDm.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aDj = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aDd = 0.0f;
                if (this.aDo && getPaddingTop() > this.aDj) {
                    a(getHeight(), 200L, 0L, this.aDq);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aDd == 0.0f) {
                    this.aDd = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aDd && getPaddingTop() == 0 && this.aDe) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aDd) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.aDl != null && i >= 0 && this.aDj > 0 && i <= this.aDj) {
                        this.aDl.cU((i * 100) / this.aDj);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void AQ() {
        setPadding(0, (int) ((10.0f - this.aDd) / 2.0f), 0, 0);
        this.mState = 0;
        this.aDd = 0.0f;
        if (this.aDo && getPaddingTop() > this.aDj) {
            a(getHeight(), 200L, 0L, this.aDq);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aDm = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aDg = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.aDi != null) {
            this.aDi.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aDh == null) {
                this.aDh = new DecelerateInterpolator();
            }
            this.aDi = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.aDi, j2);
            } else {
                post(this.aDi);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aDs;
        private final int aDt;
        private c aDu;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aDt = i;
            this.aDs = i2;
            this.mInterpolator = TransparentHeadGridView.this.aDh;
            this.mDuration = j;
            this.aDu = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDt - this.aDs));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.aDl != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.aDj > 0 && this.mCurrentY <= TransparentHeadGridView.this.aDj) {
                    TransparentHeadGridView.this.aDl.cU((this.mCurrentY * 100) / TransparentHeadGridView.this.aDj);
                }
            }
            if (this.aDv && this.aDs != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.aDu != null) {
                this.aDu.AR();
            }
        }

        public void stop() {
            this.aDv = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.aDk = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.aDl = bVar;
    }
}
