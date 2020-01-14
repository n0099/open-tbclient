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
/* loaded from: classes6.dex */
public abstract class al extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    private static final int Mc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int Me = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int Mf = Me - Mc;
    private static int Mg = Mf / 2;
    private static int Mh = Mf / 3;
    protected com.baidu.tbadk.core.data.a JH;
    protected RoundCornerFrameLayout Mk;
    protected com.baidu.tieba.play.operableVideoView.a Ml;
    private BdUniqueId Mm;
    private final View.OnClickListener Mn;
    private a.b Mo;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a mK();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.Mn = new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.JF != null) {
                    al.this.JF.a(al.this.JH);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.mE() != null) {
                    al.this.mE().a(view, al.this.JH);
                }
            }
        };
        this.Mo = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c0050a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0050a.getActionType() == 2) {
                    if (al.this.Ml != null) {
                        al.this.Ml.bdy();
                    }
                } else if (c0050a.getActionType() == 3) {
                    if (al.this.Ml != null) {
                        al.this.Ml.csA();
                    }
                } else if (c0050a.getActionType() == 6) {
                    if (al.this.Ml != null) {
                        return al.this.Ml.onBackPress();
                    }
                } else if (c0050a.getActionType() == 7) {
                    if (al.this.Mk != null) {
                        al.this.Mk.ag(((Boolean) c0050a.mZ()).booleanValue());
                    }
                } else if (c0050a.getActionType() == 8 && al.this.Ml != null && (c0050a.mZ() instanceof Boolean)) {
                    return al.this.Ml.mJ(((Boolean) c0050a.mZ()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, this.Mo);
        a(2, this.Mo);
        a(3, this.Mo);
        a(6, this.Mo);
        a(7, this.Mo);
        a(8, this.Mo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.Mk = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.Ml = mK();
            this.Ml.cwW().setBackgroundResource(R.color.transparent);
            this.Ml.setUniqueId(this.Mm);
            this.Ml.setFrom(this.mFrom);
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
            Me = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            Mf = Me - Mc;
            Mg = Mf / 2;
            Mh = Mf / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.JH = aVar;
        if (this.JH != null && this.JH.axQ() != null && this.JH.axQ().aAo() != null) {
            this.Ml.setData(aVar.axQ());
            ViewGroup.LayoutParams layoutParams = this.Mk.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = Mf;
                layoutParams.height = (Mf / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.JH.axQ().aBU()) {
                }
                if (this.JF != null) {
                }
                if (mE() == null) {
                }
            } else {
                if (this.JH.axQ().aAo().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cxD = this.Ml.cxD();
                    if (cxD != null) {
                        int i3 = (Mg / 9) * 16;
                        int i4 = Mh;
                        int videoWidth = cxD.getVideoWidth();
                        int videoHeight = cxD.getVideoHeight();
                        layoutParams.width = Mg;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Mg);
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
                    layoutParams.width = Mf;
                    layoutParams.height = (Mf / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.Mk.setLayoutParams(layoutParams);
                }
                if (!this.JH.axQ().aBU()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.JH.axQ(), Mf);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.JH.axQ());
                }
                if (this.JF != null) {
                    this.Ml.Z(this.Mn);
                }
                if (mE() == null) {
                    this.Ml.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.JF = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.JH != null && this.JH.axQ() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.JH.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.Mk.onChangeSkinType(i);
            this.Mk.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.Ml != null) {
            this.Ml.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a mY() {
        return this.Ml;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Ml.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Ml.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Ml == null) {
            return false;
        }
        return this.Ml.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.c) && ((com.baidu.tbadk.core.util.g.c) this.mContext).videoNeedPreload()) {
            this.Ml.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Ml.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Mk;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.JH == null || this.JH.axQ() == null) {
            return null;
        }
        return this.JH.axQ().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Ml != null) {
            this.Ml.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Mm = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Ml.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
