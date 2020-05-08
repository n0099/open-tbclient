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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public abstract class al extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    private static final int aft = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afu = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afv = afu - aft;
    private static int afw = afv / 2;
    private static int afx = afv / 3;
    protected com.baidu.tbadk.core.data.a ade;
    protected RoundCornerFrameLayout afB;
    protected com.baidu.tieba.play.operableVideoView.a afC;
    private BdUniqueId afD;
    private final View.OnClickListener afE;
    private a.b afF;
    private boolean afo;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a rr();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.afo = false;
        this.afE = new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.adb != null) {
                    al.this.adb.a(al.this.ade);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.rl() != null) {
                    al.this.rl().a(view, al.this.ade);
                }
            }
        };
        this.afF = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0095a c0095a) {
                if (c0095a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0095a.getActionType() == 2) {
                    if (al.this.afC != null) {
                        al.this.afC.bpd();
                    }
                } else if (c0095a.getActionType() == 3) {
                    if (al.this.afC != null) {
                        al.this.afC.cES();
                    }
                } else if (c0095a.getActionType() == 6) {
                    if (al.this.afC != null) {
                        return al.this.afC.onBackPress();
                    }
                } else if (c0095a.getActionType() == 7) {
                    if (al.this.afB != null) {
                        al.this.afB.aI(((Boolean) c0095a.rJ()).booleanValue());
                    }
                } else if (c0095a.getActionType() == 8 && al.this.afC != null && (c0095a.rJ() instanceof Boolean)) {
                    return al.this.afC.nV(((Boolean) c0095a.rJ()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, this.afF);
        a(2, this.afF);
        a(3, this.afF);
        a(6, this.afF);
        a(7, this.afF);
        a(8, this.afF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.afB = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.afC = rr();
            this.afC.cJn().setBackgroundResource(R.color.transparent);
            this.afC.setUniqueId(this.afD);
            this.afC.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
        if (r2 == r6.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0132, code lost:
        if (r2 == r6.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0134, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.card.m
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            afu = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afv = afu - aft;
            afw = afv / 2;
            afx = afv / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ade = aVar;
        if (this.ade != null && this.ade.aIu() != null && this.ade.aIu().aKT() != null) {
            this.afC.setData(aVar.aIu());
            ViewGroup.LayoutParams layoutParams = this.afB.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = afv;
                layoutParams.height = (afv / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.ade.aIu().aMx()) {
                }
                if (this.adb != null) {
                }
                if (rl() == null) {
                }
            } else {
                if (this.ade.aIu().aKT().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cJV = this.afC.cJV();
                    if (cJV != null) {
                        int i3 = (afw / 9) * 16;
                        int i4 = afx;
                        int videoWidth = cJV.getVideoWidth();
                        int videoHeight = cJV.getVideoHeight();
                        layoutParams.width = afw;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * afw);
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
                    layoutParams.width = afv;
                    layoutParams.height = (afv / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.afB.setLayoutParams(layoutParams);
                }
                if (!this.ade.aIu().aMx()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.ade.aIu(), afv, this.afo);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.ade.aIu(), 0, this.afo);
                }
                if (this.adb != null) {
                    this.afC.aa(this.afE);
                }
                if (rl() == null) {
                    this.afC.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.adb = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ade != null && this.ade.aIu() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.ade.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.afB.onChangeSkinType(i);
            this.afB.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.afC != null) {
            this.afC.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rI() {
        return this.afC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.afC.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.afC.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.afC == null) {
            return false;
        }
        return this.afC.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.afC.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.afC.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.afB;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ade == null || this.ade.aIu() == null) {
            return null;
        }
        return this.ade.aIu().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.afC != null) {
            this.afC.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afD = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.afC.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }
}
