package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.b;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public abstract class at extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.e {
    private static final int ajq;
    private static int ajr;
    private static int ajx;
    private static int ajy;
    private static int ajz;
    protected com.baidu.tbadk.core.data.a agJ;
    protected RoundCornerFrameLayout ajA;
    protected com.baidu.tieba.play.operableVideoView.a ajB;
    private String ajC;
    private BdUniqueId ajD;
    private final View.OnClickListener ajE;
    private a.b ajF;
    private boolean ajm;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a tK();

    static {
        ajq = com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        ajr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        ajx = ajr - ajq;
        ajy = ajx / 2;
        ajz = ajx / 3;
    }

    public at(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ajm = false;
        this.ajE = new View.OnClickListener() { // from class: com.baidu.card.at.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.agH != null) {
                    at.this.agH.a(at.this.agJ);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.at.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.tE() != null) {
                    at.this.tE().a(view, at.this.agJ);
                }
            }
        };
        this.ajF = new a.b() { // from class: com.baidu.card.at.5
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(at.this.mTitle, at.this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0097a.getActionType() == 2) {
                    if (at.this.ajB != null) {
                        at.this.ajB.bWE();
                    }
                } else if (c0097a.getActionType() == 3) {
                    if (at.this.ajB != null) {
                        at.this.ajB.dxe();
                    }
                } else if (c0097a.getActionType() == 6) {
                    if (at.this.ajB != null) {
                        return at.this.ajB.dCu();
                    }
                } else if (c0097a.getActionType() == 7) {
                    if (at.this.ajA != null) {
                        at.this.ajA.aQ(((Boolean) c0097a.ug()).booleanValue());
                    }
                } else if (c0097a.getActionType() == 8 && at.this.ajB != null && (c0097a.ug() instanceof Boolean)) {
                    return at.this.ajB.rJ(((Boolean) c0097a.ug()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tD() {
        a(1, this.ajF);
        a(2, this.ajF);
        a(3, this.ajF);
        a(6, this.ajF);
        a(7, this.ajF);
        a(8, this.ajF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ajA = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.ajB = tK();
            this.ajB.dBI().setBackgroundResource(R.color.transparent);
            this.ajB.setUniqueId(this.ajD);
            this.ajB.setFrom(this.mFrom);
            this.ajB.setStageType(this.ajC);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ajr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ajx = ajr - ajq;
            ajy = ajx / 2;
            ajz = ajx / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agJ = aVar;
        if (this.agJ != null && this.agJ.bmn() != null && this.agJ.bmn().bph() != null) {
            this.ajB.setData(aVar.bmn());
            final ViewGroup.LayoutParams layoutParams = this.ajA.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.agJ.bmn().bph().is_vertical.intValue() == 1) {
                int i3 = (ajy / 9) * 16;
                int i4 = ajz;
                int intValue = this.agJ.bmn().bph().video_width.intValue();
                int intValue2 = this.agJ.bmn().bph().video_height.intValue();
                layoutParams.width = ajy;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.ajB, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.ajB, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ajy);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.ajB, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.ajB, i, i2);
                }
            } else {
                layoutParams.width = ajx;
                layoutParams.height = (ajx / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.agJ.bmn().bph().is_vertical.intValue() == 1) {
                    this.ajA.setLayoutParams(layoutParams);
                    this.ajA.post(new Runnable() { // from class: com.baidu.card.at.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                } else {
                    this.ajA.post(new Runnable() { // from class: com.baidu.card.at.2
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = at.this.mRootView.getWidth();
                            layoutParams.height = (at.this.mRootView.getWidth() / 16) * 9;
                            at.this.ajA.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.agJ.bmn().bqN()) {
                this.mTitle.setMaxLines(5);
                az.a(this.mTitle, this.agJ.bmn(), ajx, this.ajm);
            } else {
                this.mTitle.setMaxLines(2);
                az.a(this.mTitle, this.agJ.bmn(), 0, this.ajm);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            az.a(this.ajA, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.agH != null) {
                this.ajB.ac(this.ajE);
            }
            if (tE() != null) {
                this.ajB.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.agH = aVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agJ != null && this.agJ.bmn() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.agJ.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.ajA.onChangeSkinType(i);
            this.ajA.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.ajB != null) {
            this.ajB.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a uf() {
        return this.ajB;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ajB.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ajB.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ajB == null) {
            return false;
        }
        return this.ajB.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.ajB.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.ajB.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.ajA;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agJ == null || this.agJ.bmn() == null) {
            return null;
        }
        return this.agJ.bmn().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ajB != null) {
            this.ajB.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.ajC = str;
        if (this.ajB != null) {
            this.ajB.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.ajB.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }
}
