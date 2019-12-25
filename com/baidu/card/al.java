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
/* loaded from: classes5.dex */
public abstract class al extends b<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.f {
    private static final int LX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int LY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int LZ = LY - LX;
    private static int Ma = LZ / 2;
    private static int Mb = LZ / 3;
    protected com.baidu.tbadk.core.data.a JB;
    protected RoundCornerFrameLayout Mf;
    protected com.baidu.tieba.play.operableVideoView.a Mg;
    private BdUniqueId Mh;
    private final View.OnClickListener Mi;
    private a.b Mj;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a mK();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.Mi = new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.Jz != null) {
                    al.this.Jz.a(al.this.JB);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.mE() != null) {
                    al.this.mE().a(view, al.this.JB);
                }
            }
        };
        this.Mj = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0050a c0050a) {
                if (c0050a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.JB.axx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0050a.getActionType() == 2) {
                    if (al.this.Mg != null) {
                        al.this.Mg.bdd();
                    }
                } else if (c0050a.getActionType() == 3) {
                    if (al.this.Mg != null) {
                        al.this.Mg.crr();
                    }
                } else if (c0050a.getActionType() == 6) {
                    if (al.this.Mg != null) {
                        return al.this.Mg.onBackPress();
                    }
                } else if (c0050a.getActionType() == 7) {
                    if (al.this.Mf != null) {
                        al.this.Mf.ag(((Boolean) c0050a.mY()).booleanValue());
                    }
                } else if (c0050a.getActionType() == 8 && al.this.Mg != null && (c0050a.mY() instanceof Boolean)) {
                    return al.this.Mg.my(((Boolean) c0050a.mY()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void mD() {
        a(1, this.Mj);
        a(2, this.Mj);
        a(3, this.Mj);
        a(6, this.Mj);
        a(7, this.Mj);
        a(8, this.Mj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.Mf = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.Mg = mK();
            this.Mg.cvN().setBackgroundResource(R.color.transparent);
            this.Mg.setUniqueId(this.Mh);
            this.Mg.setFrom(this.mFrom);
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
            LY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            LZ = LY - LX;
            Ma = LZ / 2;
            Mb = LZ / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.JB = aVar;
        if (this.JB != null && this.JB.axx() != null && this.JB.axx().azV() != null) {
            this.Mg.setData(aVar.axx());
            ViewGroup.LayoutParams layoutParams = this.Mf.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = LZ;
                layoutParams.height = (LZ / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.JB.axx().aBB()) {
                }
                if (this.Jz != null) {
                }
                if (mE() == null) {
                }
            } else {
                if (this.JB.axx().azV().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cwu = this.Mg.cwu();
                    if (cwu != null) {
                        int i3 = (Ma / 9) * 16;
                        int i4 = Mb;
                        int videoWidth = cwu.getVideoWidth();
                        int videoHeight = cwu.getVideoHeight();
                        layoutParams.width = Ma;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Ma);
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
                    layoutParams.width = LZ;
                    layoutParams.height = (LZ / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.Mf.setLayoutParams(layoutParams);
                }
                if (!this.JB.axx().aBB()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.JB.axx(), LZ);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.JB.axx());
                }
                if (this.Jz != null) {
                    this.Mg.aa(this.Mi);
                }
                if (mE() == null) {
                    this.Mg.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.Jz = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.JB != null && this.JB.axx() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.JB.axx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.Mf.onChangeSkinType(i);
            this.Mf.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.Mg != null) {
            this.Mg.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a mX() {
        return this.Mg;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.Mg.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.Mg.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.Mg == null) {
            return false;
        }
        return this.Mg.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.c) && ((com.baidu.tbadk.core.util.g.c) this.mContext).videoNeedPreload()) {
            this.Mg.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.Mg.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.Mf;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.JB == null || this.JB.axx() == null) {
            return null;
        }
        return this.JB.axx().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.Mg != null) {
            this.Mg.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.Mh = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.Mg.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
