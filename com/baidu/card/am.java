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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public abstract class am extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.f {
    private static final int afP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afQ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afR = afQ - afP;
    private static int afS = afR / 2;
    private static int afT = afR / 3;
    protected AbsThreadDataSupport adw;
    private boolean afL;
    protected RoundCornerFrameLayout afX;
    protected com.baidu.tieba.play.operableVideoView.a afY;
    private BdUniqueId afZ;
    private final View.OnClickListener aga;
    private a.b agb;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a ry();

    public am(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.afL = false;
        this.aga = new View.OnClickListener() { // from class: com.baidu.card.am.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.adu != null) {
                    am.this.adu.a(am.this.adw);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.am.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (am.this.rs() != null) {
                    am.this.rs().a(view, am.this.adw);
                }
            }
        };
        this.agb = new a.b() { // from class: com.baidu.card.am.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0097a c0097a) {
                if (c0097a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(am.this.mTitle, am.this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0097a.getActionType() == 2) {
                    if (am.this.afY != null) {
                        am.this.afY.buW();
                    }
                } else if (c0097a.getActionType() == 3) {
                    if (am.this.afY != null) {
                        am.this.afY.cMi();
                    }
                } else if (c0097a.getActionType() == 6) {
                    if (am.this.afY != null) {
                        return am.this.afY.cRP();
                    }
                } else if (c0097a.getActionType() == 7) {
                    if (am.this.afX != null) {
                        am.this.afX.aJ(((Boolean) c0097a.rS()).booleanValue());
                    }
                } else if (c0097a.getActionType() == 8 && am.this.afY != null && (c0097a.rS() instanceof Boolean)) {
                    return am.this.afY.or(((Boolean) c0097a.rS()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rr() {
        a(1, this.agb);
        a(2, this.agb);
        a(3, this.agb);
        a(6, this.agb);
        a(7, this.agb);
        a(8, this.agb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.afX = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.afY = ry();
            this.afY.cQD().setBackgroundResource(R.color.transparent);
            this.afY.setUniqueId(this.afZ);
            this.afY.setFrom(this.mFrom);
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
    @Override // com.baidu.card.n
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            afQ = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afR = afQ - afP;
            afS = afR / 2;
            afT = afR / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.adw = absThreadDataSupport;
        if (this.adw != null && this.adw.aOi() != null && this.adw.aOi().aQQ() != null) {
            this.afY.setData(absThreadDataSupport.aOi());
            ViewGroup.LayoutParams layoutParams = this.afX.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = afR;
                layoutParams.height = (afR / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.adw.aOi().aSw()) {
                }
                if (this.adu != null) {
                }
                if (rs() == null) {
                }
            } else {
                if (this.adw.aOi().aQQ().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cRl = this.afY.cRl();
                    if (cRl != null) {
                        int i3 = (afS / 9) * 16;
                        int i4 = afT;
                        int videoWidth = cRl.getVideoWidth();
                        int videoHeight = cRl.getVideoHeight();
                        layoutParams.width = afS;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * afS);
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
                    layoutParams.width = afR;
                    layoutParams.height = (afR / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.afX.setLayoutParams(layoutParams);
                }
                if (!this.adw.aOi().aSw()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.adw.aOi(), afR, this.afL);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.adw.aOi(), 0, this.afL);
                }
                if (this.adu != null) {
                    this.afY.aa(this.aga);
                }
                if (rs() == null) {
                    this.afY.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.adu = aVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.adw != null && this.adw.aOi() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.adw.aOi().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.afX.onChangeSkinType(i);
            this.afX.setBackgroundColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.afY != null) {
            this.afY.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rR() {
        return this.afY;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.afY.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.afY.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.afY == null) {
            return false;
        }
        return this.afY.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.afY.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.afY.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.afX;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.adw == null || this.adw.aOi() == null) {
            return null;
        }
        return this.adw.aOi().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.afY != null) {
            this.afY.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afZ = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.afY.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}
