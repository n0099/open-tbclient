package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class ac extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    private static final int Hq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int Hr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int Hs = Hr - Hq;
    private static int Ht = Hs / 2;
    private static int Hu = Hs / 3;
    protected com.baidu.tbadk.core.data.a Fx;
    protected RoundCornerFrameLayout Hv;
    protected com.baidu.tieba.play.operableVideoView.a Hw;
    private BdUniqueId Hx;
    private a.b Hy;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a lM();

    public ac(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.lH() != null) {
                    ac.this.lH().a(view, ac.this.Fx);
                }
            }
        };
        this.Hy = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (c0044a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0044a.getActionType() == 2) {
                    if (ac.this.Hw != null) {
                        ac.this.Hw.aLW();
                    }
                } else if (c0044a.getActionType() == 3) {
                    if (ac.this.Hw != null) {
                        ac.this.Hw.ccX();
                    }
                } else if (c0044a.getActionType() == 6) {
                    if (ac.this.Hw != null) {
                        return ac.this.Hw.onBackPress();
                    }
                } else if (c0044a.getActionType() == 7) {
                    if (ac.this.Hv != null) {
                        ac.this.Hv.Z(((Boolean) c0044a.mb()).booleanValue());
                    }
                } else if (c0044a.getActionType() == 8 && ac.this.Hw != null && (c0044a.mb() instanceof Boolean)) {
                    return ac.this.Hw.ll(((Boolean) c0044a.mb()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        a(1, this.Hy);
        a(2, this.Hy);
        a(3, this.Hy);
        a(6, this.Hy);
        a(7, this.Hy);
        a(8, this.Hy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.Hv = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.Hw = lM();
            this.Hw.cbX().setBackgroundResource(R.color.transparent);
            this.Hw.setUniqueId(this.Hx);
            this.Hw.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
        if (r4 == r5.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0111, code lost:
        if (r4 == r5.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0113, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.card.i
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            Hr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            Hs = Hr - Hq;
            Ht = Hs / 2;
            Hu = Hs / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Fx = aVar;
        if (this.Fx != null && this.Fx.agI() != null && this.Fx.agI().aiX() != null) {
            this.Hw.setData(aVar.agI());
            ViewGroup.LayoutParams layoutParams = this.Hv.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = Hs;
                layoutParams.height = (Hs / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                au.a(this.mTitle, this.Fx.agI());
                if (lH() == null) {
                }
            } else {
                if (this.Fx.agI().aiX().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.v ccy = this.Hw.ccy();
                    if (ccy != null) {
                        int i3 = (Ht / 9) * 16;
                        int i4 = Hu;
                        int videoWidth = ccy.getVideoWidth();
                        int videoHeight = ccy.getVideoHeight();
                        layoutParams.width = Ht;
                        boolean z3 = i != layoutParams.width;
                        if (videoWidth == 0 || videoHeight == 0) {
                            layoutParams.height = i3;
                            if (i2 != layoutParams.height) {
                                z = true;
                                z2 = z;
                            }
                            z = z3;
                            z2 = z;
                        } else {
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Ht);
                            if (i5 >= i4) {
                                i4 = i5 > i3 ? i3 : i5;
                            }
                            layoutParams.height = i4;
                            if (i2 != layoutParams.height) {
                                z = true;
                                z2 = z;
                            }
                            z = z3;
                            z2 = z;
                        }
                    } else {
                        return;
                    }
                } else {
                    layoutParams.width = Hs;
                    layoutParams.height = (Hs / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.Hv.setLayoutParams(layoutParams);
                }
                au.a(this.mTitle, this.Fx.agI());
                if (lH() == null) {
                    this.Hw.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Fx != null && this.Fx.agI() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.Fx.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.Hv.onChangeSkinType(i);
            this.Hv.setBackgroundColor(am.getColor(com.baidu.tbadk.util.e.Vl()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.Hw != null) {
            this.Hw.c(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a ma() {
        return this.Hw;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Hw.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Hw.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Hw == null) {
            return false;
        }
        return this.Hw.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.c) && ((com.baidu.tbadk.core.util.g.c) this.mContext).videoNeedPreload()) {
            this.Hw.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Hw.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Hv;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Fx == null || this.Fx.agI() == null) {
            return null;
        }
        return this.Fx.agI().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Hw != null) {
            this.Hw.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Hx = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Hw.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
