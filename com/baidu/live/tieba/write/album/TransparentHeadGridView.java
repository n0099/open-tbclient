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
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private float ayd;
    private boolean aye;
    private int ayf;
    private View ayg;
    private Interpolator ayh;
    private d ayi;
    private int ayj;
    private a ayk;
    private b ayl;
    private AbsListView.OnScrollListener aym;
    private int ayn;
    private boolean ayo;
    private Animation.AnimationListener ayp;
    private c ayq;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void cC(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void cD(int i);

        void yj();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void yi();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.ayd = 0.0f;
        this.aye = true;
        this.ayf = -1;
        this.ayn = -1;
        this.ayo = false;
        this.ayp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ayq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void yi() {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ayl != null) {
                    TransparentHeadGridView.this.ayl.yj();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ayk != null && TransparentHeadGridView.this.ayn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ayk.cC(100);
                        TransparentHeadGridView.this.ayn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayf < 0) {
                        TransparentHeadGridView.this.ayf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayf);
                    TransparentHeadGridView.this.aye = i4 == 0;
                    if (TransparentHeadGridView.this.ayg != null) {
                        TransparentHeadGridView.this.ayg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ayk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayn) {
                        TransparentHeadGridView.this.ayk.cC(height);
                        TransparentHeadGridView.this.ayn = height;
                    }
                }
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.ayd = 0.0f;
        this.aye = true;
        this.ayf = -1;
        this.ayn = -1;
        this.ayo = false;
        this.ayp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ayq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void yi() {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ayl != null) {
                    TransparentHeadGridView.this.ayl.yj();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ayk != null && TransparentHeadGridView.this.ayn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ayk.cC(100);
                        TransparentHeadGridView.this.ayn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayf < 0) {
                        TransparentHeadGridView.this.ayf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayf);
                    TransparentHeadGridView.this.aye = i4 == 0;
                    if (TransparentHeadGridView.this.ayg != null) {
                        TransparentHeadGridView.this.ayg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ayk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayn) {
                        TransparentHeadGridView.this.ayk.cC(height);
                        TransparentHeadGridView.this.ayn = height;
                    }
                }
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.ayd = 0.0f;
        this.aye = true;
        this.ayf = -1;
        this.ayn = -1;
        this.ayo = false;
        this.ayp = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ayq = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void yi() {
                if (TransparentHeadGridView.this.ayo) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.ayl != null) {
                    TransparentHeadGridView.this.ayl.yj();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.ayk != null && TransparentHeadGridView.this.ayn != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.ayk.cC(100);
                        TransparentHeadGridView.this.ayn = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayf < 0) {
                        TransparentHeadGridView.this.ayf = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayf);
                    TransparentHeadGridView.this.aye = i4 == 0;
                    if (TransparentHeadGridView.this.ayg != null) {
                        TransparentHeadGridView.this.ayg.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.ayk != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayn) {
                        TransparentHeadGridView.this.ayk.cC(height);
                        TransparentHeadGridView.this.ayn = height;
                    }
                }
                if (TransparentHeadGridView.this.aym != null) {
                    TransparentHeadGridView.this.aym.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.ayj = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.ayd = 0.0f;
                if (this.ayo && getPaddingTop() > this.ayj) {
                    a(getHeight(), 200L, 0L, this.ayq);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.ayd == 0.0f) {
                    this.ayd = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.ayd && getPaddingTop() == 0 && this.aye) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.ayd) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.ayl != null && i >= 0 && this.ayj > 0 && i <= this.ayj) {
                        this.ayl.cD((i * 100) / this.ayj);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void yh() {
        setPadding(0, (int) ((10.0f - this.ayd) / 2.0f), 0, 0);
        this.mState = 0;
        this.ayd = 0.0f;
        if (this.ayo && getPaddingTop() > this.ayj) {
            a(getHeight(), 200L, 0L, this.ayq);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aym = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.ayg = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.ayi != null) {
            this.ayi.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.ayh == null) {
                this.ayh = new DecelerateInterpolator();
            }
            this.ayi = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.ayi, j2);
            } else {
                post(this.ayi);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int ays;
        private final int ayt;
        private c ayu;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean ayv = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.ayt = i;
            this.ays = i2;
            this.mInterpolator = TransparentHeadGridView.this.ayh;
            this.mDuration = j;
            this.ayu = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.ayt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.ayt - this.ays));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.ayl != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.ayj > 0 && this.mCurrentY <= TransparentHeadGridView.this.ayj) {
                    TransparentHeadGridView.this.ayl.cD((this.mCurrentY * 100) / TransparentHeadGridView.this.ayj);
                }
            }
            if (this.ayv && this.ays != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.ayu != null) {
                this.ayu.yi();
            }
        }

        public void stop() {
            this.ayv = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.ayk = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.ayl = bVar;
    }
}
