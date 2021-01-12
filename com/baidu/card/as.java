package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class as extends a<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.e {
    private static final int agG = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agI = agH - agG;
    private static int agJ = agI / 2;
    private static int agK = agI / 3;
    protected RoundCornerFrameLayout agL;
    private BdUniqueId agN;
    private boolean agO;
    private a.b agP;
    protected com.baidu.tbadk.core.data.a agr;
    protected com.baidu.tieba.play.operableVideoView.a ajp;
    private String ajq;
    private final View.OnClickListener ajr;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a sX();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agO = false;
        this.ajr = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.agp != null) {
                    as.this.agp.a(as.this.agr);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.sR() != null) {
                    as.this.sR().a(view, as.this.agr);
                }
            }
        };
        this.agP = new a.b() { // from class: com.baidu.card.as.4
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0089a.getActionType() == 2) {
                    if (as.this.ajp != null) {
                        as.this.ajp.bVs();
                    }
                } else if (c0089a.getActionType() == 3) {
                    if (as.this.ajp != null) {
                        as.this.ajp.dtc();
                    }
                } else if (c0089a.getActionType() == 6) {
                    if (as.this.ajp != null) {
                        return as.this.ajp.dys();
                    }
                } else if (c0089a.getActionType() == 7) {
                    if (as.this.agL != null) {
                        as.this.agL.aN(((Boolean) c0089a.tu()).booleanValue());
                    }
                } else if (c0089a.getActionType() == 8 && as.this.ajp != null && (c0089a.tu() instanceof Boolean)) {
                    return as.this.ajp.sc(((Boolean) c0089a.tu()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sQ() {
        a(1, this.agP);
        a(2, this.agP);
        a(3, this.agP);
        a(6, this.agP);
        a(7, this.agP);
        a(8, this.agP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agL = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.ajp = sX();
            this.ajp.dxG().setBackgroundResource(R.color.transparent);
            this.ajp.setUniqueId(this.agN);
            this.ajp.setFrom(this.mFrom);
            this.ajp.setStageType(this.ajq);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agH = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agI = agH - agG;
            agJ = agI / 2;
            agK = agI / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agr = aVar;
        if (this.agr != null && this.agr.bkV() != null && this.agr.bkV().bnO() != null) {
            this.ajp.setData(aVar.bkV());
            final ViewGroup.LayoutParams layoutParams = this.agL.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.agr.bkV().bnO().is_vertical.intValue() == 1) {
                int i3 = (agJ / 9) * 16;
                int i4 = agK;
                int intValue = this.agr.bkV().bnO().video_width.intValue();
                int intValue2 = this.agr.bkV().bnO().video_height.intValue();
                layoutParams.width = agJ;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajp, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajp, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * agJ);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajp, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajp, i, i2);
                }
            } else {
                layoutParams.width = agI;
                layoutParams.height = (agI / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.agr.bkV().bnO().is_vertical.intValue() == 1) {
                    this.agL.setLayoutParams(layoutParams);
                } else {
                    this.agL.post(new Runnable() { // from class: com.baidu.card.as.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = as.this.mRootView.getWidth();
                            layoutParams.height = (as.this.mRootView.getWidth() / 16) * 9;
                            as.this.agL.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.agr.bkV().bpw()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.agr.bkV(), agI, this.agO);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.agr.bkV(), 0, this.agO);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            ay.a(this.agL, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.agp != null) {
                this.ajp.ae(this.ajr);
            }
            if (sR() != null) {
                this.ajp.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agp = interfaceC0088a;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agr != null && this.agr.bkV() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.agr.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.agL.onChangeSkinType(i);
            this.agL.setBackgroundColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.ajp != null) {
            this.ajp.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tt() {
        return this.ajp;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ajp.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ajp.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ajp == null) {
            return false;
        }
        return this.ajp.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.b) && ((com.baidu.tbadk.core.util.g.b) this.mContext).videoNeedPreload()) {
            this.ajp.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.ajp.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.agL;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agr == null || this.agr.bkV() == null) {
            return null;
        }
        return this.agr.bkV().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ajp != null) {
            this.ajp.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.ajq = str;
        if (this.ajp != null) {
            this.ajp.setStageType(str);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.ajp.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}
