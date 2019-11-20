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
    private static final int GO = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int GP = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int GQ = GP - GO;
    private static int GR = GQ / 2;
    private static int GU = GQ / 3;
    protected com.baidu.tbadk.core.data.a EX;
    protected RoundCornerFrameLayout GV;
    protected com.baidu.tieba.play.operableVideoView.a GW;
    private BdUniqueId GX;
    private a.b GY;
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
                    ac.this.lH().a(view, ac.this.EX);
                }
            }
        };
        this.GY = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0044a c0044a) {
                if (c0044a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.EX.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0044a.getActionType() == 2) {
                    if (ac.this.GW != null) {
                        ac.this.GW.aLU();
                    }
                } else if (c0044a.getActionType() == 3) {
                    if (ac.this.GW != null) {
                        ac.this.GW.ccV();
                    }
                } else if (c0044a.getActionType() == 6) {
                    if (ac.this.GW != null) {
                        return ac.this.GW.onBackPress();
                    }
                } else if (c0044a.getActionType() == 7) {
                    if (ac.this.GV != null) {
                        ac.this.GV.Z(((Boolean) c0044a.mb()).booleanValue());
                    }
                } else if (c0044a.getActionType() == 8 && ac.this.GW != null && (c0044a.mb() instanceof Boolean)) {
                    return ac.this.GW.ll(((Boolean) c0044a.mb()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void lG() {
        a(1, this.GY);
        a(2, this.GY);
        a(3, this.GY);
        a(6, this.GY);
        a(7, this.GY);
        a(8, this.GY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.GV = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.GW = lM();
            this.GW.cbV().setBackgroundResource(R.color.transparent);
            this.GW.setUniqueId(this.GX);
            this.GW.setFrom(this.mFrom);
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
            GP = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            GQ = GP - GO;
            GR = GQ / 2;
            GU = GQ / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.EX = aVar;
        if (this.EX != null && this.EX.agG() != null && this.EX.agG().aiV() != null) {
            this.GW.setData(aVar.agG());
            ViewGroup.LayoutParams layoutParams = this.GV.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = GQ;
                layoutParams.height = (GQ / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                au.a(this.mTitle, this.EX.agG());
                if (lH() == null) {
                }
            } else {
                if (this.EX.agG().aiV().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.v ccw = this.GW.ccw();
                    if (ccw != null) {
                        int i3 = (GR / 9) * 16;
                        int i4 = GU;
                        int videoWidth = ccw.getVideoWidth();
                        int videoHeight = ccw.getVideoHeight();
                        layoutParams.width = GR;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * GR);
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
                    layoutParams.width = GQ;
                    layoutParams.height = (GQ / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.GV.setLayoutParams(layoutParams);
                }
                au.a(this.mTitle, this.EX.agG());
                if (lH() == null) {
                    this.GW.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.EX != null && this.EX.agG() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.EX.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.GV.onChangeSkinType(i);
            this.GV.setBackgroundColor(am.getColor(com.baidu.tbadk.util.e.Vj()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.GW != null) {
            this.GW.c(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a ma() {
        return this.GW;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.GW.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.GW.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.GW == null) {
            return false;
        }
        return this.GW.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.c) && ((com.baidu.tbadk.core.util.g.c) this.mContext).videoNeedPreload()) {
            this.GW.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.GW.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.GV;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.EX == null || this.EX.agG() == null) {
            return null;
        }
        return this.EX.agG().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.GW != null) {
            this.GW.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.GX = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.GW.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
