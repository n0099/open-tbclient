package com.baidu.card;

import android.content.Context;
import android.graphics.Rect;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class as extends a<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.e {
    private static final int ahN = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahP = ahO - ahN;
    private static int ahQ = ahP / 2;
    private static int ahR = ahP / 3;
    protected com.baidu.tbadk.core.data.a ahB;
    protected RoundCornerFrameLayout ahS;
    private BdUniqueId ahU;
    private boolean ahV;
    private a.b ahW;
    protected com.baidu.tieba.play.operableVideoView.a akv;
    private String akw;
    private View.OnClickListener akx;
    private final View.OnClickListener aky;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a sU();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahV = false;
        this.akx = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.a.d.bjw() && as.this.ahB != null) {
                    com.baidu.tbadk.util.s.a(false, as.this.mContext, as.this.ahB.blp(), as.this.mFrom);
                } else if (com.baidu.tbadk.a.d.bjx()) {
                    if (as.this.ahB != null && as.this.ahB.blp() != null) {
                        com.baidu.tbadk.util.s.a(false, as.this.mContext, as.this.ahB.blp(), 0, (Rect) null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", as.this.mFrom, as.this.mFrom);
                    }
                } else if (as.this.ahz != null) {
                    as.this.ahz.a(as.this.ahB);
                }
            }
        };
        this.aky = new View.OnClickListener() { // from class: com.baidu.card.as.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.ahz != null) {
                    as.this.ahz.a(as.this.ahB);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.sO() != null) {
                    as.this.sO().a(view, as.this.ahB);
                }
            }
        };
        this.ahW = new a.b() { // from class: com.baidu.card.as.5
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0095a.getActionType() == 2) {
                    if (as.this.akv != null) {
                        as.this.akv.onScroll();
                    }
                } else if (c0095a.getActionType() == 3) {
                    if (as.this.akv != null) {
                        as.this.akv.dvF();
                    }
                } else if (c0095a.getActionType() == 6) {
                    if (as.this.akv != null) {
                        return as.this.akv.dAP();
                    }
                } else if (c0095a.getActionType() == 7) {
                    if (as.this.ahS != null) {
                        as.this.ahS.aN(((Boolean) c0095a.tr()).booleanValue());
                    }
                } else if (c0095a.getActionType() == 8 && as.this.akv != null && (c0095a.tr() instanceof Boolean)) {
                    return as.this.akv.sp(((Boolean) c0095a.tr()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, this.ahW);
        a(2, this.ahW);
        a(3, this.ahW);
        a(6, this.ahW);
        a(7, this.ahW);
        a(8, this.ahW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahS = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.akv = sU();
            this.akv.dAf().setBackgroundResource(R.color.transparent);
            this.akv.setUniqueId(this.ahU);
            this.akv.setFrom(this.mFrom);
            this.akv.setStageType(this.akw);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahO = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahP = ahO - ahN;
            ahQ = ahP / 2;
            ahR = ahP / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahB = aVar;
        if (this.ahB != null && this.ahB.blp() != null && this.ahB.blp().boj() != null) {
            this.akv.setData(aVar.blp());
            final ViewGroup.LayoutParams layoutParams = this.ahS.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.ahB.blp().boj().is_vertical.intValue() == 1) {
                int i3 = (ahQ / 9) * 16;
                int i4 = ahR;
                int intValue = this.ahB.blp().boj().video_width.intValue();
                int intValue2 = this.ahB.blp().boj().video_height.intValue();
                layoutParams.width = ahQ;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akv, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akv, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahQ);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akv, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.akv, i, i2);
                }
            } else {
                layoutParams.width = ahP;
                layoutParams.height = (ahP / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.ahB.blp().boj().is_vertical.intValue() == 1) {
                    this.ahS.setLayoutParams(layoutParams);
                } else {
                    this.ahS.post(new Runnable() { // from class: com.baidu.card.as.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = as.this.mRootView.getWidth();
                            layoutParams.height = (as.this.mRootView.getWidth() / 16) * 9;
                            as.this.ahS.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.ahB.blp().bpQ()) {
                this.mTitle.setMaxLines(5);
                az.a(this.mTitle, this.ahB.blp(), ahP, this.ahV);
            } else {
                this.mTitle.setMaxLines(2);
                az.a(this.mTitle, this.ahB.blp(), 0, this.ahV);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            az.a(this.ahS, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.ahz != null) {
                this.akv.af(this.aky);
            }
            if (sO() != null) {
                this.akv.setAfterClickListener(this.mOnClickListener);
            }
            if (this.mTitle != null && this.mRootView != null) {
                this.mTitle.setOnClickListener(this.akx);
                this.mRootView.setOnClickListener(this.akx);
            }
        }
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahB != null && this.ahB.blp() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.ahB.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.ahS.onChangeSkinType(i);
            this.ahS.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.akv != null) {
            this.akv.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tq() {
        return this.akv;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.akv.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.akv.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.akv == null) {
            return false;
        }
        return this.akv.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.b) && ((com.baidu.tbadk.core.util.g.b) this.mContext).videoNeedPreload()) {
            this.akv.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.akv.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.ahS;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ahB == null || this.ahB.blp() == null) {
            return null;
        }
        return this.ahB.blp().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.akv != null) {
            this.akv.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.akw = str;
        if (this.akv != null) {
            this.akv.setStageType(str);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahU = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.akv.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}
