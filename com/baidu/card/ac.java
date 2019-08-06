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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class ac extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    protected com.baidu.tbadk.core.data.a VJ;
    protected RoundCornerFrameLayout XC;
    protected com.baidu.tieba.play.operableVideoView.a XD;
    private BdUniqueId XE;
    private a.b XF;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Xy = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
    private static int Xz = SCREEN_WIDTH - Xy;
    private static int XA = Xz / 2;
    private static int XB = Xz / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a qG();

    public ac(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.qB() != null) {
                    ac.this.qB().a(view, ac.this.VJ);
                }
            }
        };
        this.XF = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.VJ.acy().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0038a.getActionType() == 2) {
                    if (ac.this.XD != null) {
                        ac.this.XD.cfi();
                    }
                } else if (c0038a.getActionType() == 3) {
                    if (ac.this.XD != null) {
                        ac.this.XD.cfj();
                    }
                } else if (c0038a.getActionType() == 6) {
                    if (ac.this.XD != null) {
                        return ac.this.XD.onBackPress();
                    }
                } else if (c0038a.getActionType() == 7) {
                    if (ac.this.XC != null) {
                        ac.this.XC.aE(((Boolean) c0038a.qV()).booleanValue());
                    }
                } else if (c0038a.getActionType() == 8 && ac.this.XD != null && (c0038a.qV() instanceof Boolean)) {
                    return ac.this.XD.lu(((Boolean) c0038a.qV()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qA() {
        a(1, this.XF);
        a(2, this.XF);
        a(3, this.XF);
        a(6, this.XF);
        a(7, this.XF);
        a(8, this.XF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.XC = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.XD = qG();
            this.XD.ceg().setBackgroundResource(R.color.transparent);
            this.XD.setUniqueId(this.XE);
            this.XD.setFrom(this.mFrom);
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
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        if (af != this.mLastScreenWidth) {
            SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
            Xz = SCREEN_WIDTH - Xy;
            XA = Xz / 2;
            XB = Xz / 3;
            this.mLastScreenWidth = af;
        }
        this.VJ = aVar;
        if (this.VJ != null && this.VJ.acy() != null && this.VJ.acy().aeP() != null) {
            this.XD.setData(aVar.acy());
            ViewGroup.LayoutParams layoutParams = this.XC.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = Xz;
                layoutParams.height = (Xz / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                av.a(this.mTitle, this.VJ.acy());
                if (qB() == null) {
                }
            } else {
                if (this.VJ.acy().aeP().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.v ceI = this.XD.ceI();
                    if (ceI != null) {
                        int i3 = (XA / 9) * 16;
                        int i4 = XB;
                        int videoWidth = ceI.getVideoWidth();
                        int videoHeight = ceI.getVideoHeight();
                        layoutParams.width = XA;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * XA);
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
                    layoutParams.width = Xz;
                    layoutParams.height = (Xz / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.XC.setLayoutParams(layoutParams);
                }
                av.a(this.mTitle, this.VJ.acy());
                if (qB() == null) {
                    this.XD.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.VJ != null && this.VJ.acy() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.VJ.acy().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.XC.onChangeSkinType(i);
            this.XC.setBackgroundColor(am.getColor(com.baidu.tbadk.util.e.Qr()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.XD != null) {
            this.XD.c(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a qU() {
        return this.XD;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.XD.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.XD.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.XD == null) {
            return false;
        }
        return this.XD.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.e.c) && ((com.baidu.tbadk.core.util.e.c) this.mContext).videoNeedPreload()) {
            this.XD.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.XD.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.XC;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.VJ == null || this.VJ.acy() == null) {
            return null;
        }
        return this.VJ.acy().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.XD != null) {
            this.XD.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.XE = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.XD.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
