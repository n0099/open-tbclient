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
/* loaded from: classes20.dex */
public abstract class at extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.e {
    private static final int ahV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ahW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ahX = ahW - ahV;
    private static int ahY = ahX / 2;
    private static int ahZ = ahX / 3;
    protected AbsThreadDataSupport afq;
    private boolean ahR;
    protected RoundCornerFrameLayout aie;
    protected com.baidu.tieba.play.operableVideoView.a aif;
    private String aig;
    private BdUniqueId aih;
    private final View.OnClickListener aii;
    private a.b aij;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a tH();

    public at(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ahR = false;
        this.aii = new View.OnClickListener() { // from class: com.baidu.card.at.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.afo != null) {
                    at.this.afo.a(at.this.afq);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.at.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.tB() != null) {
                    at.this.tB().a(view, at.this.afq);
                }
            }
        };
        this.aij = new a.b() { // from class: com.baidu.card.at.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(at.this.mTitle, at.this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                } else if (c0096a.getActionType() == 2) {
                    if (at.this.aif != null) {
                        at.this.aif.bLM();
                    }
                } else if (c0096a.getActionType() == 3) {
                    if (at.this.aif != null) {
                        at.this.aif.diS();
                    }
                } else if (c0096a.getActionType() == 6) {
                    if (at.this.aif != null) {
                        return at.this.aif.doh();
                    }
                } else if (c0096a.getActionType() == 7) {
                    if (at.this.aie != null) {
                        at.this.aie.aO(((Boolean) c0096a.ud()).booleanValue());
                    }
                } else if (c0096a.getActionType() == 8 && at.this.aif != null && (c0096a.ud() instanceof Boolean)) {
                    return at.this.aif.pX(((Boolean) c0096a.ud()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, this.aij);
        a(2, this.aij);
        a(3, this.aij);
        a(6, this.aij);
        a(7, this.aij);
        a(8, this.aij);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.aie = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            com.baidu.tbadk.a.b.a.d(this.aie, R.dimen.tbds28, R.dimen.tbds14);
            com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            this.aif = tH();
            this.aif.dnv().setBackgroundResource(R.color.transparent);
            this.aif.setUniqueId(this.aih);
            this.aif.setFrom(this.mFrom);
            this.aif.setStageType(this.aig);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ahW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ahX = ahW - ahV;
            ahY = ahX / 2;
            ahZ = ahX / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afq = absThreadDataSupport;
        if (this.afq != null && this.afq.bcY() != null && this.afq.bcY().bfQ() != null) {
            this.aif.setData(absThreadDataSupport.bcY());
            ViewGroup.LayoutParams layoutParams = this.aie.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.afq.bcY().bfQ().is_vertical.intValue() == 1) {
                int i3 = (ahY / 9) * 16;
                int i4 = ahZ;
                int intValue = this.afq.bcY().bfQ().video_width.intValue();
                int intValue2 = this.afq.bcY().bfQ().video_height.intValue();
                layoutParams.width = ahY;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.aif, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.aif, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * ahY);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z = true;
                        z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.aif, i, i2);
                    }
                    z = z3;
                    z2 = com.baidu.tbadk.a.b.a.a(layoutParams, z, this.aif, i, i2);
                }
            } else {
                layoutParams.width = ahX;
                layoutParams.height = (ahX / 16) * 9;
                if (i2 == layoutParams.height && i == layoutParams.width) {
                    z2 = false;
                }
            }
            if (z2) {
                this.aie.setLayoutParams(layoutParams);
            }
            if (this.afq.bcY().bhu()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.afq.bcY(), ahX, this.ahR);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.afq.bcY(), 0, this.ahR);
            }
            if (this.afo != null) {
                this.aif.ac(this.aii);
            }
            if (tB() != null) {
                this.aif.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.afo = aVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afq != null && this.afq.bcY() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.afq.bcY().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            this.aie.onChangeSkinType(i);
            this.aie.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.aif != null) {
            this.aif.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a uc() {
        return this.aif;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.aif.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.aif.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.aif == null) {
            return false;
        }
        return this.aif.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.aif.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.aif.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.aie;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afq == null || this.afq.bcY() == null) {
            return null;
        }
        return this.afq.bcY().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.aif != null) {
            this.aif.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.aig = str;
        if (this.aif != null) {
            this.aif.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aih = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.aif.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }
}
