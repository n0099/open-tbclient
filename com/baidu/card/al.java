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
    private static final int MA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int MC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int ME = MC - MA;
    private static int MF = ME / 2;
    private static int MG = ME / 3;
    protected com.baidu.tbadk.core.data.a Kc;
    protected RoundCornerFrameLayout MK;
    protected com.baidu.tieba.play.operableVideoView.a MN;
    private BdUniqueId MO;
    private final View.OnClickListener MP;
    private a.b MQ;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a mZ();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.MP = new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.Ka != null) {
                    al.this.Ka.a(al.this.Kc);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.mT() != null) {
                    al.this.mT().a(view, al.this.Kc);
                }
            }
        };
        this.MQ = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (c0052a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.Kc.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0052a.getActionType() == 2) {
                    if (al.this.MN != null) {
                        al.this.MN.bfJ();
                    }
                } else if (c0052a.getActionType() == 3) {
                    if (al.this.MN != null) {
                        al.this.MN.ctW();
                    }
                } else if (c0052a.getActionType() == 6) {
                    if (al.this.MN != null) {
                        return al.this.MN.onBackPress();
                    }
                } else if (c0052a.getActionType() == 7) {
                    if (al.this.MK != null) {
                        al.this.MK.aj(((Boolean) c0052a.nq()).booleanValue());
                    }
                } else if (c0052a.getActionType() == 8 && al.this.MN != null && (c0052a.nq() instanceof Boolean)) {
                    return al.this.MN.mL(((Boolean) c0052a.nq()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, this.MQ);
        a(2, this.MQ);
        a(3, this.MQ);
        a(6, this.MQ);
        a(7, this.MQ);
        a(8, this.MQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.MK = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.MN = mZ();
            this.MN.cys().setBackgroundResource(R.color.transparent);
            this.MN.setUniqueId(this.MO);
            this.MN.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
        if (r4 == r5.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0130, code lost:
        if (r4 == r5.width) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0132, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.card.m
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            MC = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            ME = MC - MA;
            MF = ME / 2;
            MG = ME / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Kc = aVar;
        if (this.Kc != null && this.Kc.aAg() != null && this.Kc.aAg().aCF() != null) {
            this.MN.setData(aVar.aAg());
            ViewGroup.LayoutParams layoutParams = this.MK.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = ME;
                layoutParams.height = (ME / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.Kc.aAg().aEh()) {
                }
                if (this.Ka != null) {
                }
                if (mT() == null) {
                }
            } else {
                if (this.Kc.aAg().aCF().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cza = this.MN.cza();
                    if (cza != null) {
                        int i3 = (MF / 9) * 16;
                        int i4 = MG;
                        int videoWidth = cza.getVideoWidth();
                        int videoHeight = cza.getVideoHeight();
                        layoutParams.width = MF;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * MF);
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
                    layoutParams.width = ME;
                    layoutParams.height = (ME / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.MK.setLayoutParams(layoutParams);
                }
                if (!this.Kc.aAg().aEh()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.Kc.aAg(), ME);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.Kc.aAg());
                }
                if (this.Ka != null) {
                    this.MN.Z(this.MP);
                }
                if (mT() == null) {
                    this.MN.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Kc != null && this.Kc.aAg() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Kc.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.MK.onChangeSkinType(i);
            this.MK.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.MN != null) {
            this.MN.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a np() {
        return this.MN;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.MN.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.MN.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.MN == null) {
            return false;
        }
        return this.MN.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.MN.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.MN.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.MK;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Kc == null || this.Kc.aAg() == null) {
            return null;
        }
        return this.Kc.aAg().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.MN != null) {
            this.MN.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.MO = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.MN.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
