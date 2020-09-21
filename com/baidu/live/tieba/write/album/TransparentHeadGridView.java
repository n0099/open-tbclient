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
    private float bsV;
    private boolean bsW;
    private int bsX;
    private View bsY;
    private Interpolator bsZ;
    private d bta;
    private int btb;
    private a btc;
    private b btd;
    private AbsListView.OnScrollListener bte;
    private int btf;
    private boolean btg;
    private Animation.AnimationListener bth;
    private c bti;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes4.dex */
    public interface a {
        void fD(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void PD();

        void fE(int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void PC();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bsV = 0.0f;
        this.bsW = true;
        this.bsX = -1;
        this.btf = -1;
        this.btg = false;
        this.bth = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bti = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void PC() {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.btd != null) {
                    TransparentHeadGridView.this.btd.PD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.btc != null && TransparentHeadGridView.this.btf != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.btc.fD(100);
                        TransparentHeadGridView.this.btf = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bsX < 0) {
                        TransparentHeadGridView.this.bsX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bsX);
                    TransparentHeadGridView.this.bsW = i4 == 0;
                    if (TransparentHeadGridView.this.bsY != null) {
                        TransparentHeadGridView.this.bsY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.btc != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.btf) {
                        TransparentHeadGridView.this.btc.fD(height);
                        TransparentHeadGridView.this.btf = height;
                    }
                }
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bsV = 0.0f;
        this.bsW = true;
        this.bsX = -1;
        this.btf = -1;
        this.btg = false;
        this.bth = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bti = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void PC() {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.btd != null) {
                    TransparentHeadGridView.this.btd.PD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.btc != null && TransparentHeadGridView.this.btf != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.btc.fD(100);
                        TransparentHeadGridView.this.btf = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bsX < 0) {
                        TransparentHeadGridView.this.bsX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bsX);
                    TransparentHeadGridView.this.bsW = i4 == 0;
                    if (TransparentHeadGridView.this.bsY != null) {
                        TransparentHeadGridView.this.bsY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.btc != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.btf) {
                        TransparentHeadGridView.this.btc.fD(height);
                        TransparentHeadGridView.this.btf = height;
                    }
                }
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bsV = 0.0f;
        this.bsW = true;
        this.bsX = -1;
        this.btf = -1;
        this.btg = false;
        this.bth = new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.bti = new c() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.live.tieba.write.album.TransparentHeadGridView.c
            public void PC() {
                if (TransparentHeadGridView.this.btg) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.btd != null) {
                    TransparentHeadGridView.this.btd.PD();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.live.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.btc != null && TransparentHeadGridView.this.btf != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.btc.fD(100);
                        TransparentHeadGridView.this.btf = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bsX < 0) {
                        TransparentHeadGridView.this.bsX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bsX);
                    TransparentHeadGridView.this.bsW = i4 == 0;
                    if (TransparentHeadGridView.this.bsY != null) {
                        TransparentHeadGridView.this.bsY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.btc != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.btf) {
                        TransparentHeadGridView.this.btc.fD(height);
                        TransparentHeadGridView.this.btf = height;
                    }
                }
                if (TransparentHeadGridView.this.bte != null) {
                    TransparentHeadGridView.this.bte.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.btb = (int) (BdUtilHelper.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bsV = 0.0f;
                if (this.btg && getPaddingTop() > this.btb) {
                    a(getHeight(), 200L, 0L, this.bti);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.bsV == 0.0f) {
                    this.bsV = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bsV && getPaddingTop() == 0 && this.bsW) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bsV) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.btd != null && i >= 0 && this.btb > 0 && i <= this.btb) {
                        this.btd.fE((i * 100) / this.btb);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void PB() {
        setPadding(0, (int) ((10.0f - this.bsV) / 2.0f), 0, 0);
        this.mState = 0;
        this.bsV = 0.0f;
        if (this.btg && getPaddingTop() > this.btb) {
            a(getHeight(), 200L, 0L, this.bti);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bte = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bsY = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.bta != null) {
            this.bta.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bsZ == null) {
                this.bsZ = new DecelerateInterpolator();
            }
            this.bta = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.bta, j2);
            } else {
                post(this.bta);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        private final int btk;
        private final int btl;
        private c btm;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bto = true;
        private long mStartTime = -1;
        private int btp = -1;

        public d(int i, int i2, long j, c cVar) {
            this.btl = i;
            this.btk = i2;
            this.mInterpolator = TransparentHeadGridView.this.bsZ;
            this.mDuration = j;
            this.btm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.btp = this.btl - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.btl - this.btk));
                TransparentHeadGridView.this.setPadding(0, this.btp, 0, 0);
                if (TransparentHeadGridView.this.btd != null && this.btp >= 0 && TransparentHeadGridView.this.btb > 0 && this.btp <= TransparentHeadGridView.this.btb) {
                    TransparentHeadGridView.this.btd.fE((this.btp * 100) / TransparentHeadGridView.this.btb);
                }
            }
            if (this.bto && this.btk != this.btp) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.btm != null) {
                this.btm.PC();
            }
        }

        public void stop() {
            this.bto = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.btc = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.btd = bVar;
    }
}
