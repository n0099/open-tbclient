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
/* loaded from: classes21.dex */
public abstract class at extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.e {
    private static final int aio = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int aiq = aip - aio;
    private static int air = aiq / 2;
    private static int ais = aiq / 3;
    protected AbsThreadDataSupport afI;
    private final View.OnClickListener aiA;
    private a.b aiB;
    private boolean aik;
    protected RoundCornerFrameLayout aiw;
    protected com.baidu.tieba.play.operableVideoView.a aix;
    private String aiy;
    private BdUniqueId aiz;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a tH();

    public at(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.aik = false;
        this.aiA = new View.OnClickListener() { // from class: com.baidu.card.at.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.afG != null) {
                    at.this.afG.a(at.this.afI);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.at.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.tB() != null) {
                    at.this.tB().a(view, at.this.afI);
                }
            }
        };
        this.aiB = new a.b() { // from class: com.baidu.card.at.5
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(at.this.mTitle, at.this.afI.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                } else if (c0097a.getActionType() == 2) {
                    if (at.this.aix != null) {
                        at.this.aix.bRb();
                    }
                } else if (c0097a.getActionType() == 3) {
                    if (at.this.aix != null) {
                        at.this.aix.dpJ();
                    }
                } else if (c0097a.getActionType() == 6) {
                    if (at.this.aix != null) {
                        return at.this.aix.duZ();
                    }
                } else if (c0097a.getActionType() == 7) {
                    if (at.this.aiw != null) {
                        at.this.aiw.aO(((Boolean) c0097a.ud()).booleanValue());
                    }
                } else if (c0097a.getActionType() == 8 && at.this.aix != null && (c0097a.ud() instanceof Boolean)) {
                    return at.this.aix.qV(((Boolean) c0097a.ud()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void tA() {
        a(1, this.aiB);
        a(2, this.aiB);
        a(3, this.aiB);
        a(6, this.aiB);
        a(7, this.aiB);
        a(8, this.aiB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.aiw = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            com.baidu.tbadk.a.b.a.d(this.aiw, R.dimen.tbds28, R.dimen.tbds14);
            com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
            this.aix = tH();
            this.aix.dun().setBackgroundResource(R.color.transparent);
            this.aix.setUniqueId(this.aiz);
            this.aix.setFrom(this.mFrom);
            this.aix.setStageType(this.aiy);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            aiq = aip - aio;
            air = aiq / 2;
            ais = aiq / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.afI = absThreadDataSupport;
        if (this.afI != null && this.afI.bhz() != null && this.afI.bhz().bks() != null) {
            this.aix.setData(absThreadDataSupport.bhz());
            final ViewGroup.LayoutParams layoutParams = this.aiw.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.afI.bhz().bks().is_vertical.intValue() == 1) {
                int i3 = (air / 9) * 16;
                int i4 = ais;
                int intValue = this.afI.bhz().bks().video_width.intValue();
                int intValue2 = this.afI.bhz().bks().video_height.intValue();
                layoutParams.width = air;
                boolean z3 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aix, i, i2);
                    }
                    z2 = z3;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aix, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * air);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aix, i, i2);
                    }
                    z2 = z3;
                    z = com.baidu.tbadk.a.b.a.a(layoutParams, z2, this.aix, i, i2);
                }
            } else {
                layoutParams.width = aiq;
                layoutParams.height = (aiq / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.afI.bhz().bks().is_vertical.intValue() == 1) {
                    this.aiw.setLayoutParams(layoutParams);
                    this.aiw.post(new Runnable() { // from class: com.baidu.card.at.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                } else {
                    this.aiw.post(new Runnable() { // from class: com.baidu.card.at.2
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = at.this.mRootView.getWidth();
                            layoutParams.height = (at.this.mRootView.getWidth() / 16) * 9;
                            at.this.aiw.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.afI.bhz().blW()) {
                this.mTitle.setMaxLines(5);
                ay.a(this.mTitle, this.afI.bhz(), aiq, this.aik);
            } else {
                this.mTitle.setMaxLines(2);
                ay.a(this.mTitle, this.afI.bhz(), 0, this.aik);
            }
            if (this.afG != null) {
                this.aix.ac(this.aiA);
            }
            if (tB() != null) {
                this.aix.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.afG = aVar;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.afI != null && this.afI.bhz() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.afI.bhz().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            this.aiw.onChangeSkinType(i);
            this.aiw.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.aix != null) {
            this.aix.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a uc() {
        return this.aix;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.aix.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.aix.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.aix == null) {
            return false;
        }
        return this.aix.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.b) && ((com.baidu.tbadk.core.util.f.b) this.mContext).videoNeedPreload()) {
            this.aix.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.aix.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.aiw;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.afI == null || this.afI.bhz() == null) {
            return null;
        }
        return this.afI.bhz().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.aix != null) {
            this.aix.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.aiy = str;
        if (this.aix != null) {
            this.aix.setStageType(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aiz = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.aix.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }
}
