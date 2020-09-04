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
    private static final int ahB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahD = ahC - ahB;
    private static int ahE = ahD / 2;
    private static int ahF = ahD / 3;
    protected AbsThreadDataSupport aeY;
    protected RoundCornerFrameLayout ahJ;
    protected com.baidu.tieba.play.operableVideoView.a ahK;
    private String ahL;
    private BdUniqueId ahM;
    private final View.OnClickListener ahN;
    private a.b ahO;
    private boolean ahx;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a tC();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahx = false;
        this.ahN = new View.OnClickListener() { // from class: com.baidu.card.as.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.aeW != null) {
                    as.this.aeW.a(as.this.aeY);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.tw() != null) {
                    as.this.tw().a(view, as.this.aeY);
                }
            }
        };
        this.ahO = new a.b() { // from class: com.baidu.card.as.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                } else if (c0095a.getActionType() == 2) {
                    if (as.this.ahK != null) {
                        as.this.ahK.bKC();
                    }
                } else if (c0095a.getActionType() == 3) {
                    if (as.this.ahK != null) {
                        as.this.ahK.dfo();
                    }
                } else if (c0095a.getActionType() == 6) {
                    if (as.this.ahK != null) {
                        return as.this.ahK.dkA();
                    }
                } else if (c0095a.getActionType() == 7) {
                    if (as.this.ahJ != null) {
                        as.this.ahJ.aO(((Boolean) c0095a.tX()).booleanValue());
                    }
                } else if (c0095a.getActionType() == 8 && as.this.ahK != null && (c0095a.tX() instanceof Boolean)) {
                    return as.this.ahK.pP(((Boolean) c0095a.tX()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tv() {
        a(1, this.ahO);
        a(2, this.ahO);
        a(3, this.ahO);
        a(6, this.ahO);
        a(7, this.ahO);
        a(8, this.ahO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.ahJ = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            com.baidu.tbadk.a.b.a.d(this.ahJ, R.dimen.tbds28, R.dimen.tbds14);
            com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            this.ahK = tC();
            this.ahK.djP().setBackgroundResource(R.color.transparent);
            this.ahK.setUniqueId(this.ahM);
            this.ahK.setFrom(this.mFrom);
            this.ahK.setStageType(this.ahL);
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
            ahC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahD = ahC - ahB;
            ahE = ahD / 2;
            ahF = ahD / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aeY = absThreadDataSupport;
        if (this.aeY != null && this.aeY.bce() != null && this.aeY.bce().beW() != null) {
            this.ahK.setData(absThreadDataSupport.bce());
            ViewGroup.LayoutParams layoutParams = this.ahJ.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.aeY.bce().beW().is_vertical.intValue() == 1) {
                int i3 = (ahE / 9) * 16;
                int i4 = ahF;
                int intValue = this.aeY.bce().beW().video_width.intValue();
                int intValue2 = this.aeY.bce().beW().video_height.intValue();
                layoutParams.width = ahE;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahK, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahK, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahE);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahK, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.ahK, i, i2);
                }
            } else {
                layoutParams.width = ahD;
                layoutParams.height = (ahD / 16) * 9;
                if (i2 == layoutParams.height && i == layoutParams.width) {
                    z2 = false;
                }
            }
            if (z2) {
                this.ahJ.setLayoutParams(layoutParams);
            }
            if (this.aeY.bce().bgA()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.aeY.bce(), ahD, this.ahx);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.aeY.bce(), 0, this.ahx);
            }
            if (this.aeW != null) {
                this.ahK.ac(this.ahN);
            }
            if (tw() != null) {
                this.ahK.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.aeW = aVar;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aeY != null && this.aeY.bce() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.aeY.bce().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            this.ahJ.onChangeSkinType(i);
            this.ahJ.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.ahK != null) {
            this.ahK.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tW() {
        return this.ahK;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ahK.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ahK.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ahK == null) {
            return false;
        }
        return this.ahK.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.ahK.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.ahK.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.ahJ;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.aeY == null || this.aeY.bce() == null) {
            return null;
        }
        return this.aeY.bce().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ahK != null) {
            this.ahK.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.ahL = str;
        if (this.ahK != null) {
            this.ahK.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ahM = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.ahK.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }
}
