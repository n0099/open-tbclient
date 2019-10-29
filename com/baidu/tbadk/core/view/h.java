package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.c {
    private c cpS;
    private b cpT;
    private d cpU;
    private a cpV;
    protected ContinuousAnimationView cpW;
    private boolean cpX;
    private SmartBubbleAnimatedView cpY;
    private f cpZ;
    private e cqa;
    private boolean cqb;
    private boolean cqc;
    private View.OnClickListener cqd;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void anW();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onListPullRefreshFinished(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onListPullToRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void iQ(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.cpS = null;
        this.cpT = null;
        this.cpU = null;
        this.cpV = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.cpX = false;
        this.cqb = true;
        this.cqc = true;
        this.cqd = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cqd != null) {
                    h.this.cqd.onClick(view);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.cpW = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.cpW.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!amA()) {
            this.mAnimImage = af.amz().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!amA() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.cpU != null) {
            this.cpU.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!amA() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (amA()) {
            this.cpW.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (amA()) {
            if (!jG()) {
                this.cpW.playAnimation();
            }
        } else if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            this.mPullImage.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.mAnimImage != null) {
                        h.this.mAnimImage.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.isManualTrigger = false;
        this.cqc = true;
        if (amA()) {
            this.cpW.pauseAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        anR();
        if (this.cpT != null) {
            this.cpT.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!jG()) {
            if (this.cpS != null && this.cqc) {
                this.cpS.onListPullRefresh(z);
            }
            this.cqc = true;
        }
    }

    public void anQ() {
        this.cqc = false;
    }

    public void a(e eVar) {
        this.cqa = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!jG()) {
            if (this.cpV != null) {
                this.cpV.anW();
            }
            anT();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.cpS = cVar;
    }

    public void a(b bVar) {
        this.cpT = bVar;
    }

    public void a(d dVar) {
        this.cpU = dVar;
    }

    public void a(a aVar) {
        this.cpV = aVar;
    }

    public void changeSkin(int i) {
        if (amA()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
        }
        if (this.cpY != null) {
            this.cpY.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amA() {
        return af.amz().amA();
    }

    private void initPullView() {
        if (this.cpY != null && this.cpY.getParent() != null) {
            this.mPullRoot.removeView(this.cpY);
        }
        if (amA()) {
            if (this.mPullImage != null && this.cpW != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.cpW.getVisibility() != 0) {
                    this.cpW.setVisibility(0);
                }
                if (this.cpW.isAnimating()) {
                    this.cpW.cancelAnimation();
                }
            }
        } else if (this.mPullImage != null && this.cpW != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.cpW.getVisibility() != 8) {
                this.cpW.setVisibility(8);
            }
        }
    }

    private void anR() {
        if (amA() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean anS() {
        return this.cpX;
    }

    public void a(f fVar) {
        this.cpZ = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.cqb = z;
    }

    public void anT() {
        if (anS() && this.cqb && this.cqa != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.cpW.setVisibility(8);
            if (this.cpY == null) {
                this.cpY = new SmartBubbleAnimatedView(getContext());
                this.cpY.setExtrusionRemind(true);
            }
            this.cpY.cqf = this.cqa.getTipText();
            this.cpY.fzC = this.cqa.anX();
            if (this.cpY.getParent() != null) {
                this.mPullRoot.removeView(this.cpY);
            }
            this.mPullRoot.addView(this.cpY);
            this.cpY.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.3
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void anV() {
                    if (h.this.cpZ != null) {
                        h.this.cpZ.onAnimationEnd();
                    }
                }
            });
            if (this.cpZ != null) {
                this.cpZ.iQ(this.cpY.getTipViewHeight());
            }
            this.cpY.blQ();
        }
    }

    public void anU() {
        if (this.mPullRoot != null && this.cpY != null && this.cpY.getParent() != null) {
            this.mPullRoot.removeView(this.cpY);
        }
    }

    public void iP(int i) {
        this.cpW.setAnimation(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cqd = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String cqf;
        private int cqg;

        public e(String str, int i) {
            this.cqf = str;
            this.cqg = i;
        }

        public String getTipText() {
            return this.cqf;
        }

        public int anX() {
            return this.cqg;
        }
    }
}
