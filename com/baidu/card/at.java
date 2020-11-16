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
/* loaded from: classes20.dex */
public abstract class at extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.e {
    private static int aiA;
    private static final int air;
    private static int ais;
    private static int aiy;
    private static int aiz;
    protected com.baidu.tbadk.core.data.a afN;
    protected RoundCornerFrameLayout aiB;
    protected com.baidu.tieba.play.operableVideoView.a aiC;
    private String aiD;
    private BdUniqueId aiE;
    private final View.OnClickListener aiF;
    private a.b aiG;
    private boolean ain;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a tH();

    static {
        air = com.baidu.tbadk.a.d.bhw() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        ais = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        aiy = ais - air;
        aiz = aiy / 2;
        aiA = aiy / 3;
    }

    public at(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.ain = false;
        this.aiF = new View.OnClickListener() { // from class: com.baidu.card.at.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.afL != null) {
                    at.this.afL.a(at.this.afN);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.at.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.tB() != null) {
                    at.this.tB().a(view, at.this.afN);
                }
            }
        };
        this.aiG = new a.b() { // from class: com.baidu.card.at.5
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0096a c0096a) {
                if (c0096a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(at.this.mTitle, at.this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0096a.getActionType() == 2) {
                    if (at.this.aiC != null) {
                        at.this.aiC.bST();
                    }
                } else if (c0096a.getActionType() == 3) {
                    if (at.this.aiC != null) {
                        at.this.aiC.drL();
                    }
                } else if (c0096a.getActionType() == 6) {
                    if (at.this.aiC != null) {
                        return at.this.aiC.dxb();
                    }
                } else if (c0096a.getActionType() == 7) {
                    if (at.this.aiB != null) {
                        at.this.aiB.aQ(((Boolean) c0096a.ud()).booleanValue());
                    }
                } else if (c0096a.getActionType() == 8 && at.this.aiC != null && (c0096a.ud() instanceof Boolean)) {
                    return at.this.aiC.rh(((Boolean) c0096a.ud()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, this.aiG);
        a(2, this.aiG);
        a(3, this.aiG);
        a(6, this.aiG);
        a(7, this.aiG);
        a(8, this.aiG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.aiB = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.aiC = tH();
            this.aiC.dwp().setBackgroundResource(R.color.transparent);
            this.aiC.setUniqueId(this.aiE);
            this.aiC.setFrom(this.mFrom);
            this.aiC.setStageType(this.aiD);
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
            ais = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            aiy = ais - air;
            aiz = aiy / 2;
            aiA = aiy / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afN = aVar;
        if (this.afN != null && this.afN.bjd() != null && this.afN.bjd().blU() != null) {
            this.aiC.setData(aVar.bjd());
            final ViewGroup.LayoutParams layoutParams = this.aiB.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.afN.bjd().blU().is_vertical.intValue() == 1) {
                int i3 = (aiz / 9) * 16;
                int i4 = aiA;
                int intValue = this.afN.bjd().blU().video_width.intValue();
                int intValue2 = this.afN.bjd().blU().video_height.intValue();
                layoutParams.width = aiz;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aiC, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aiC, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * aiz);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aiC, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aiC, i, i2);
                }
            } else {
                layoutParams.width = aiy;
                layoutParams.height = (aiy / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.afN.bjd().blU().is_vertical.intValue() == 1) {
                    this.aiB.setLayoutParams(layoutParams);
                    this.aiB.post(new Runnable() { // from class: com.baidu.card.at.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                } else {
                    this.aiB.post(new Runnable() { // from class: com.baidu.card.at.2
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = at.this.mRootView.getWidth();
                            layoutParams.height = (at.this.mRootView.getWidth() / 16) * 9;
                            at.this.aiB.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.afN.bjd().bnA()) {
                this.mTitle.setMaxLines(5);
                az.a(this.mTitle, this.afN.bjd(), aiy, this.ain);
            } else {
                this.mTitle.setMaxLines(2);
                az.a(this.mTitle, this.afN.bjd(), 0, this.ain);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            az.a(this.aiB, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.afL != null) {
                this.aiC.ac(this.aiF);
            }
            if (tB() != null) {
                this.aiC.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.afL = aVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afN != null && this.afN.bjd() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.afN.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.aiB.onChangeSkinType(i);
            this.aiB.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.aiC != null) {
            this.aiC.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a uc() {
        return this.aiC;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.aiC.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.aiC.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.aiC == null) {
            return false;
        }
        return this.aiC.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.aiC.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.aiC.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.aiB;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afN == null || this.afN.bjd() == null) {
            return null;
        }
        return this.afN.bjd().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.aiC != null) {
            this.aiC.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.aiD = str;
        if (this.aiC != null) {
            this.aiC.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aiE = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.aiC.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }
}
