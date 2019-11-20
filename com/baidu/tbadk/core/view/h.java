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
    private c cpa;
    private b cpb;
    private d cpc;
    private a cpd;
    protected ContinuousAnimationView cpe;
    private boolean cpf;
    private SmartBubbleAnimatedView cpg;
    private f cph;
    private e cpi;
    private boolean cpj;
    private boolean cpk;
    private View.OnClickListener cpl;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void anU();
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
        void iP(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.cpa = null;
        this.cpb = null;
        this.cpc = null;
        this.cpd = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
        this.cpf = false;
        this.cpj = true;
        this.cpk = true;
        this.cpl = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.cpl != null) {
                    h.this.cpl.onClick(view);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.cpe = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.cpe.setOnClickListener(this.mClickListener);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.mPullImage.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!amy()) {
            this.mAnimImage = af.amx().getDefaultAnimationDrawable(skinType);
        }
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        initPullView();
        return this.mHeaderView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!amy() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        if (this.cpc != null) {
            this.cpc.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (!amy() && this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f2, float f3) {
        super.onPullPercentChange(f2, f3);
        if (amy()) {
            this.cpe.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        initPullView();
        if (amy()) {
            if (!jG()) {
                this.cpe.playAnimation();
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
        this.cpk = true;
        if (amy()) {
            this.cpe.pauseAnimation();
        } else if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        anP();
        if (this.cpb != null) {
            this.cpb.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (!jG()) {
            if (this.cpa != null && this.cpk) {
                this.cpa.onListPullRefresh(z);
            }
            this.cpk = true;
        }
    }

    public void anO() {
        this.cpk = false;
    }

    public void a(e eVar) {
        this.cpi = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        if (!jG()) {
            if (this.cpd != null) {
                this.cpd.anU();
            }
            anR();
        }
    }

    public void setListPullRefreshListener(c cVar) {
        this.cpa = cVar;
    }

    public void a(b bVar) {
        this.cpb = bVar;
    }

    public void a(d dVar) {
        this.cpc = dVar;
    }

    public void a(a aVar) {
        this.cpd = aVar;
    }

    public void changeSkin(int i) {
        if (amy()) {
            am.setBackgroundColor(this.mHeaderView, R.color.cp_bg_line_d, i);
        }
        if (this.cpg != null) {
            this.cpg.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amy() {
        return af.amx().amy();
    }

    private void initPullView() {
        if (this.cpg != null && this.cpg.getParent() != null) {
            this.mPullRoot.removeView(this.cpg);
        }
        if (amy()) {
            if (this.mPullImage != null && this.cpe != null) {
                if (this.mPullImage.getVisibility() != 8) {
                    this.mPullImage.setVisibility(8);
                }
                if (this.cpe.getVisibility() != 0) {
                    this.cpe.setVisibility(0);
                }
                if (this.cpe.isAnimating()) {
                    this.cpe.cancelAnimation();
                }
            }
        } else if (this.mPullImage != null && this.cpe != null) {
            if (this.mPullImage.getVisibility() != 0) {
                this.mPullImage.setVisibility(0);
            }
            if (this.cpe.getVisibility() != 8) {
                this.cpe.setVisibility(8);
            }
        }
    }

    private void anP() {
        if (amy() && this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean anQ() {
        return this.cpf;
    }

    public void a(f fVar) {
        this.cph = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.cpj = z;
    }

    public void anR() {
        if (anQ() && this.cpj && this.cpi != null && this.mPullRoot != null) {
            this.mPullImage.setVisibility(8);
            this.cpe.setVisibility(8);
            if (this.cpg == null) {
                this.cpg = new SmartBubbleAnimatedView(getContext());
                this.cpg.setExtrusionRemind(true);
            }
            this.cpg.cpn = this.cpi.getTipText();
            this.cpg.fyL = this.cpi.anV();
            if (this.cpg.getParent() != null) {
                this.mPullRoot.removeView(this.cpg);
            }
            this.mPullRoot.addView(this.cpg);
            this.cpg.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.3
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void anT() {
                    if (h.this.cph != null) {
                        h.this.cph.onAnimationEnd();
                    }
                }
            });
            if (this.cph != null) {
                this.cph.iP(this.cpg.getTipViewHeight());
            }
            this.cpg.blO();
        }
    }

    public void anS() {
        if (this.mPullRoot != null && this.cpg != null && this.cpg.getParent() != null) {
            this.mPullRoot.removeView(this.cpg);
        }
    }

    public void iO(int i) {
        this.cpe.setAnimation(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cpl = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String cpn;
        private int cpo;

        public e(String str, int i) {
            this.cpn = str;
            this.cpo = i;
        }

        public String getTipText() {
            return this.cpn;
        }

        public int anV() {
            return this.cpo;
        }
    }
}
