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
    protected LinearLayout caH;
    protected ImageView caI;
    private c caJ;
    private b caK;
    private d caL;
    private a caM;
    protected AnimationDrawable caN;
    protected ContinuousAnimationView caO;
    private boolean caP;
    private boolean caQ;
    private SmartBubbleAnimatedView caR;
    private f caS;
    private e caT;
    private boolean caU;
    private boolean caV;
    private View.OnClickListener caW;
    private View.OnClickListener mClickListener;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void akW();
    }

    /* loaded from: classes.dex */
    public interface b {
        void f(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void er(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void es(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void ja(int i);

        void onAnimationEnd();
    }

    public h(Context context) {
        super(context);
        this.mHeaderView = null;
        this.caH = null;
        this.caI = null;
        this.caJ = null;
        this.caK = null;
        this.caL = null;
        this.caM = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.caP = false;
        this.caQ = false;
        this.caU = true;
        this.caV = true;
        this.caW = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.caW != null) {
                    h.this.caW.onClick(view);
                }
            }
        };
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.caH = (LinearLayout) this.mHeaderView.findViewById(R.id.pull_root);
        this.caO = (ContinuousAnimationView) this.mHeaderView.findViewById(R.id.continuous_loading_view);
        this.caO.setOnClickListener(this.mClickListener);
        this.caI = (ImageView) this.mHeaderView.findViewById(R.id.pull_image);
        this.caI.setOnClickListener(this.mClickListener);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!ajc()) {
            this.caN = af.aiU().ic(skinType);
        }
        this.caI.setBackgroundDrawable(this.caN);
        akQ();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (!ajc() && this.caN != null && this.caI != null) {
            this.caN.stop();
            this.caI.setBackgroundDrawable(this.caN.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        if (this.caL != null) {
            this.caL.es(z);
        }
        akQ();
        this.caP = true;
        if (!ajc() && this.caN != null && this.caI != null) {
            this.caN.stop();
            this.caI.setBackgroundDrawable(this.caN.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f2, float f3) {
        super.n(f2, f3);
        if (ajc()) {
            this.caO.setAlpha(f2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        akQ();
        if (ajc()) {
            this.caO.br();
        } else if (this.caN != null && this.caI != null) {
            this.caN.stop();
            this.caI.setBackgroundDrawable(this.caN);
            this.caI.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.caN != null) {
                        h.this.caN.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        this.caP = false;
        this.caV = true;
        if (ajc()) {
            this.caO.bt();
        } else if (this.caN != null) {
            this.caN.stop();
        }
        akR();
        if (this.caK != null) {
            this.caK.f(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (this.caJ != null && this.caV) {
            this.caJ.er(z);
        }
        this.caV = true;
    }

    public void akP() {
        this.caV = false;
    }

    public void a(e eVar) {
        this.caT = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        if (this.caM != null) {
            this.caM.akW();
        }
        akT();
    }

    public void setListPullRefreshListener(c cVar) {
        this.caJ = cVar;
    }

    public void a(b bVar) {
        this.caK = bVar;
    }

    public void a(d dVar) {
        this.caL = dVar;
    }

    public void a(a aVar) {
        this.caM = aVar;
    }

    public void iV(int i) {
        if (ajc()) {
            am.h(this.mHeaderView, R.color.cp_bg_line_f, i);
        }
        if (this.caR != null) {
            this.caR.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ajc() {
        return af.aiU().ajc();
    }

    private void akQ() {
        if (this.caR != null && this.caR.getParent() != null) {
            this.caH.removeView(this.caR);
        }
        if (ajc()) {
            if (this.caI != null && this.caO != null) {
                if (this.caI.getVisibility() != 8) {
                    this.caI.setVisibility(8);
                }
                if (this.caO.getVisibility() != 0) {
                    this.caO.setVisibility(0);
                }
                if (this.caO.isAnimating()) {
                    this.caO.cancelAnimation();
                }
            }
        } else if (this.caI != null && this.caO != null) {
            if (this.caI.getVisibility() != 0) {
                this.caI.setVisibility(0);
            }
            if (this.caO.getVisibility() != 8) {
                this.caO.setVisibility(8);
            }
        }
    }

    private void akR() {
        if (ajc() && this.caN != null) {
            this.caN.stop();
            this.caN = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public boolean akS() {
        return this.caQ;
    }

    public void a(f fVar) {
        this.caS = fVar;
    }

    public void setExecuteMsgAnimation(boolean z) {
        this.caU = z;
    }

    public void akT() {
        if (akS() && this.caU && this.caT != null && this.caH != null) {
            this.caI.setVisibility(8);
            this.caO.setVisibility(8);
            if (this.caR == null) {
                this.caR = new SmartBubbleAnimatedView(getContext());
                this.caR.setExtrusionRemind(true);
            }
            this.caR.caY = this.caT.getTipText();
            this.caR.fyB = this.caT.akX();
            if (this.caR.getParent() != null) {
                this.caH.removeView(this.caR);
            }
            this.caH.addView(this.caR);
            this.caR.setOnBubbleAnimateListener(new SmartBubbleAnimatedView.a() { // from class: com.baidu.tbadk.core.view.h.3
                @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.a
                public void akV() {
                    if (h.this.caS != null) {
                        h.this.caS.onAnimationEnd();
                    }
                }
            });
            if (this.caS != null) {
                this.caS.ja(this.caR.getTipViewHeight());
            }
            this.caR.bob();
        }
    }

    public void akU() {
        if (this.caH != null && this.caR != null && this.caR.getParent() != null) {
            this.caH.removeView(this.caR);
        }
    }

    public void iZ(int i) {
        this.caO.setAnimation(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.caW = onClickListener;
    }

    /* loaded from: classes.dex */
    public static class e {
        private String caY;
        private int caZ;

        public e(String str, int i) {
            this.caY = str;
            this.caZ = i;
        }

        public String getTipText() {
            return this.caY;
        }

        public int akX() {
            return this.caZ;
        }
    }
}
