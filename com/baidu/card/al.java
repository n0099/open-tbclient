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
    private static final int MC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int ME = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int MF = ME - MC;
    private static int MG = MF / 2;
    private static int MH = MF / 3;
    protected com.baidu.tbadk.core.data.a Kc;
    protected RoundCornerFrameLayout MN;
    protected com.baidu.tieba.play.operableVideoView.a MO;
    private BdUniqueId MP;
    private final View.OnClickListener MQ;
    private a.b MR;
    private boolean Mw;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a mZ();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.Mw = false;
        this.MQ = new View.OnClickListener() { // from class: com.baidu.card.al.1
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
        this.MR = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0052a c0052a) {
                if (c0052a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0052a.getActionType() == 2) {
                    if (al.this.MO != null) {
                        al.this.MO.bfO();
                    }
                } else if (c0052a.getActionType() == 3) {
                    if (al.this.MO != null) {
                        al.this.MO.cup();
                    }
                } else if (c0052a.getActionType() == 6) {
                    if (al.this.MO != null) {
                        return al.this.MO.onBackPress();
                    }
                } else if (c0052a.getActionType() == 7) {
                    if (al.this.MN != null) {
                        al.this.MN.aj(((Boolean) c0052a.nq()).booleanValue());
                    }
                } else if (c0052a.getActionType() == 8 && al.this.MO != null && (c0052a.nq() instanceof Boolean)) {
                    return al.this.MO.mR(((Boolean) c0052a.nq()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mS() {
        a(1, this.MR);
        a(2, this.MR);
        a(3, this.MR);
        a(6, this.MR);
        a(7, this.MR);
        a(8, this.MR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.MN = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.MO = mZ();
            this.MO.cyL().setBackgroundResource(R.color.transparent);
            this.MO.setUniqueId(this.MP);
            this.MO.setFrom(this.mFrom);
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
    public void A(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            ME = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            MF = ME - MC;
            MG = MF / 2;
            MH = MF / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Kc = aVar;
        if (this.Kc != null && this.Kc.aAj() != null && this.Kc.aAj().aCI() != null) {
            this.MO.setData(aVar.aAj());
            ViewGroup.LayoutParams layoutParams = this.MN.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = MF;
                layoutParams.height = (MF / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.Kc.aAj().aEl()) {
                }
                if (this.Ka != null) {
                }
                if (mT() == null) {
                }
            } else {
                if (this.Kc.aAj().aCI().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u czt = this.MO.czt();
                    if (czt != null) {
                        int i3 = (MG / 9) * 16;
                        int i4 = MH;
                        int videoWidth = czt.getVideoWidth();
                        int videoHeight = czt.getVideoHeight();
                        layoutParams.width = MG;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * MG);
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
                    layoutParams.width = MF;
                    layoutParams.height = (MF / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.MN.setLayoutParams(layoutParams);
                }
                if (!this.Kc.aAj().aEl()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.Kc.aAj(), MF, this.Mw);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.Kc.aAj(), 0, this.Mw);
                }
                if (this.Ka != null) {
                    this.MO.Z(this.MQ);
                }
                if (mT() == null) {
                    this.MO.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.Kc != null && this.Kc.aAj() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.Kc.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.MN.onChangeSkinType(i);
            this.MN.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.MO != null) {
            this.MO.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a np() {
        return this.MO;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.MO.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.MO.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.MO == null) {
            return false;
        }
        return this.MO.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.MO.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.MO.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.MN;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Kc == null || this.Kc.aAj() == null) {
            return null;
        }
        return this.Kc.aAj().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.MO != null) {
            this.MO.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.MP = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.MO.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.Mw = z;
    }
}
