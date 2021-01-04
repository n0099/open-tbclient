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
    protected RoundCornerFrameLayout ahC;
    private BdUniqueId ahE;
    private boolean ahF;
    private a.b ahG;
    protected com.baidu.tbadk.core.data.a ahi;
    protected com.baidu.tieba.play.operableVideoView.a akg;
    private String akh;
    private final View.OnClickListener aki;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int ahx = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahz = ahy - ahx;
    private static int ahA = ahz / 2;
    private static int ahB = ahz / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a ti();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahF = false;
        this.aki = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.ahg != null) {
                    as.this.ahg.a(as.this.ahi);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.tc() != null) {
                    as.this.tc().a(view, as.this.ahi);
                }
            }
        };
        this.ahG = new a.b() { // from class: com.baidu.card.as.4
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0090a c0090a) {
                if (c0090a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0090a.getActionType() == 2) {
                    if (as.this.akg != null) {
                        as.this.akg.bZj();
                    }
                } else if (c0090a.getActionType() == 3) {
                    if (as.this.akg != null) {
                        as.this.akg.dwT();
                    }
                } else if (c0090a.getActionType() == 6) {
                    if (as.this.akg != null) {
                        return as.this.akg.dCj();
                    }
                } else if (c0090a.getActionType() == 7) {
                    if (as.this.ahC != null) {
                        as.this.ahC.aN(((Boolean) c0090a.tF()).booleanValue());
                    }
                } else if (c0090a.getActionType() == 8 && as.this.akg != null && (c0090a.tF() instanceof Boolean)) {
                    return as.this.akg.sg(((Boolean) c0090a.tF()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void tb() {
        a(1, this.ahG);
        a(2, this.ahG);
        a(3, this.ahG);
        a(6, this.ahG);
        a(7, this.ahG);
        a(8, this.ahG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahC = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.akg = ti();
            this.akg.dBx().setBackgroundResource(R.color.transparent);
            this.akg.setUniqueId(this.ahE);
            this.akg.setFrom(this.mFrom);
            this.akg.setStageType(this.akh);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahy = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahz = ahy - ahx;
            ahA = ahz / 2;
            ahB = ahz / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahi = aVar;
        if (this.ahi != null && this.ahi.boO() != null && this.ahi.boO().brH() != null) {
            this.akg.setData(aVar.boO());
            final ViewGroup.LayoutParams layoutParams = this.ahC.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.ahi.boO().brH().is_vertical.intValue() == 1) {
                int i3 = (ahA / 9) * 16;
                int i4 = ahB;
                int intValue = this.ahi.boO().brH().video_width.intValue();
                int intValue2 = this.ahi.boO().brH().video_height.intValue();
                layoutParams.width = ahA;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akg, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akg, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahA);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akg, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akg, i, i2);
                }
            } else {
                layoutParams.width = ahz;
                layoutParams.height = (ahz / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.ahi.boO().brH().is_vertical.intValue() == 1) {
                    this.ahC.setLayoutParams(layoutParams);
                } else {
                    this.ahC.post(new Runnable() { // from class: com.baidu.card.as.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = as.this.mRootView.getWidth();
                            layoutParams.height = (as.this.mRootView.getWidth() / 16) * 9;
                            as.this.ahC.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.ahi.boO().btp()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.ahi.boO(), ahz, this.ahF);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.ahi.boO(), 0, this.ahF);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            ay.a(this.ahC, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.ahg != null) {
                this.akg.ae(this.aki);
            }
            if (tc() != null) {
                this.akg.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahi != null && this.ahi.boO() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.ahi.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.ahC.onChangeSkinType(i);
            this.ahC.setBackgroundColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.akg != null) {
            this.akg.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tE() {
        return this.akg;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.akg.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.akg.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.akg == null) {
            return false;
        }
        return this.akg.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.b) && ((com.baidu.tbadk.core.util.g.b) this.mContext).videoNeedPreload()) {
            this.akg.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.akg.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.ahC;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ahi == null || this.ahi.boO() == null) {
            return null;
        }
        return this.ahi.boO().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.akg != null) {
            this.akg.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.akh = str;
        if (this.akg != null) {
            this.akg.setStageType(str);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahE = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.akg.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}
