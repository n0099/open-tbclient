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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public abstract class as extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.e {
    protected AbsThreadDataSupport aeW;
    protected RoundCornerFrameLayout ahH;
    protected com.baidu.tieba.play.operableVideoView.a ahI;
    private String ahJ;
    private BdUniqueId ahK;
    private final View.OnClickListener ahL;
    private a.b ahM;
    private boolean ahv;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int ahz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahB = ahA - ahz;
    private static int ahC = ahB / 2;
    private static int ahD = ahB / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a tC();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahv = false;
        this.ahL = new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.aeU != null) {
                    as.this.aeU.a(as.this.aeW);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.tw() != null) {
                    as.this.tw().a(view, as.this.aeW);
                }
            }
        };
        this.ahM = new a.b() { // from class: com.baidu.card.as.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                } else if (c0095a.getActionType() == 2) {
                    if (as.this.ahI != null) {
                        as.this.ahI.bKB();
                    }
                } else if (c0095a.getActionType() == 3) {
                    if (as.this.ahI != null) {
                        as.this.ahI.dfn();
                    }
                } else if (c0095a.getActionType() == 6) {
                    if (as.this.ahI != null) {
                        return as.this.ahI.dkx();
                    }
                } else if (c0095a.getActionType() == 7) {
                    if (as.this.ahH != null) {
                        as.this.ahH.aO(((Boolean) c0095a.tX()).booleanValue());
                    }
                } else if (c0095a.getActionType() == 8 && as.this.ahI != null && (c0095a.tX() instanceof Boolean)) {
                    return as.this.ahI.pN(((Boolean) c0095a.tX()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, this.ahM);
        a(2, this.ahM);
        a(3, this.ahM);
        a(6, this.ahM);
        a(7, this.ahM);
        a(8, this.ahM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahH = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            com.baidu.tbadk.a.b.a.d(this.ahH, R.dimen.tbds28, R.dimen.tbds14);
            com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            this.ahI = tC();
            this.ahI.djM().setBackgroundResource(R.color.transparent);
            this.ahI.setUniqueId(this.ahK);
            this.ahI.setFrom(this.mFrom);
            this.ahI.setStageType(this.ahJ);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahA = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahB = ahA - ahz;
            ahC = ahB / 2;
            ahD = ahB / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aeW = absThreadDataSupport;
        if (this.aeW != null && this.aeW.bce() != null && this.aeW.bce().beW() != null) {
            this.ahI.setData(absThreadDataSupport.bce());
            ViewGroup.LayoutParams layoutParams = this.ahH.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.aeW.bce().beW().is_vertical.intValue() == 1) {
                int i3 = (ahC / 9) * 16;
                int i4 = ahD;
                int intValue = this.aeW.bce().beW().video_width.intValue();
                int intValue2 = this.aeW.bce().beW().video_height.intValue();
                layoutParams.width = ahC;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahI, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahI, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahC);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahI, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahI, i, i2);
                }
            } else {
                layoutParams.width = ahB;
                layoutParams.height = (ahB / 16) * 9;
                if (i2 == layoutParams.height && i == layoutParams.width) {
                    z2 = false;
                }
            }
            if (z2) {
                this.ahH.setLayoutParams(layoutParams);
            }
            if (this.aeW.bce().bgA()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.aeW.bce(), ahB, this.ahv);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.aeW.bce(), 0, this.ahv);
            }
            if (this.aeU != null) {
                this.ahI.ac(this.ahL);
            }
            if (tw() != null) {
                this.ahI.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aeW != null && this.aeW.bce() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.aeW.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            this.ahH.onChangeSkinType(i);
            this.ahH.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.ahI != null) {
            this.ahI.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tW() {
        return this.ahI;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ahI.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ahI.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ahI == null) {
            return false;
        }
        return this.ahI.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.ahI.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.ahI.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.ahH;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.aeW == null || this.aeW.bce() == null) {
            return null;
        }
        return this.aeW.bce().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ahI != null) {
            this.ahI.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.ahJ = str;
        if (this.ahI != null) {
            this.ahI.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahK = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.ahI.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }
}
