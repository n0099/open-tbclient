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
    protected com.baidu.tbadk.core.data.a VI;
    protected RoundCornerFrameLayout XB;
    protected com.baidu.tieba.play.operableVideoView.a XC;
    private BdUniqueId XD;
    private a.b XE;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;
    private static final int Xx = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int SCREEN_WIDTH = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
    private static int Xy = SCREEN_WIDTH - Xx;
    private static int Xz = Xy / 2;
    private static int XA = Xy / 3;

    protected abstract com.baidu.tieba.play.operableVideoView.a qH();

    public ac(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ac.this.qC() != null) {
                    ac.this.qC().a(view, ac.this.VI);
                }
            }
        };
        this.XE = new a.b() { // from class: com.baidu.card.ac.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0038a c0038a) {
                if (c0038a.getActionType() == 1) {
                    com.baidu.tieba.card.n.a(ac.this.mTitle, ac.this.VI.acC().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0038a.getActionType() == 2) {
                    if (ac.this.XC != null) {
                        ac.this.XC.cfW();
                    }
                } else if (c0038a.getActionType() == 3) {
                    if (ac.this.XC != null) {
                        ac.this.XC.cfX();
                    }
                } else if (c0038a.getActionType() == 6) {
                    if (ac.this.XC != null) {
                        return ac.this.XC.onBackPress();
                    }
                } else if (c0038a.getActionType() == 7) {
                    if (ac.this.XB != null) {
                        ac.this.XB.aE(((Boolean) c0038a.qW()).booleanValue());
                    }
                } else if (c0038a.getActionType() == 8 && ac.this.XC != null && (c0038a.qW() instanceof Boolean)) {
                    return ac.this.XC.lx(((Boolean) c0038a.qW()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void qB() {
        a(1, this.XE);
        a(2, this.XE);
        a(3, this.XE);
        a(6, this.XE);
        a(7, this.XE);
        a(8, this.XE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.XB = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.XC = qH();
            this.XC.ceV().setBackgroundResource(R.color.transparent);
            this.XC.setUniqueId(this.XD);
            this.XC.setFrom(this.mFrom);
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
            Xy = SCREEN_WIDTH - Xx;
            Xz = Xy / 2;
            XA = Xy / 3;
            this.mLastScreenWidth = af;
        }
        this.VI = aVar;
        if (this.VI != null && this.VI.acC() != null && this.VI.acC().aeT() != null) {
            this.XC.setData(aVar.acC());
            ViewGroup.LayoutParams layoutParams = this.XB.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = Xy;
                layoutParams.height = (Xy / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                au.a(this.mTitle, this.VI.acC());
                if (qC() == null) {
                }
            } else {
                if (this.VI.acC().aeT().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.v cfw = this.XC.cfw();
                    if (cfw != null) {
                        int i3 = (Xz / 9) * 16;
                        int i4 = XA;
                        int videoWidth = cfw.getVideoWidth();
                        int videoHeight = cfw.getVideoHeight();
                        layoutParams.width = Xz;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * Xz);
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
                    layoutParams.width = Xy;
                    layoutParams.height = (Xy / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.XB.setLayoutParams(layoutParams);
                }
                au.a(this.mTitle, this.VI.acC());
                if (qC() == null) {
                    this.XC.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.VI != null && this.VI.acC() != null) {
            com.baidu.tieba.card.n.a(this.mTitle, this.VI.acC().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.XB.onChangeSkinType(i);
            this.XB.setBackgroundColor(am.getColor(com.baidu.tbadk.util.e.Qv()));
        }
    }

    public void a(com.baidu.tieba.play.z zVar) {
        if (this.XC != null) {
            this.XC.c(zVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a qV() {
        return this.XC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.XC.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.XC.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.XC == null) {
            return false;
        }
        return this.XC.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.c) && ((com.baidu.tbadk.core.util.g.c) this.mContext).videoNeedPreload()) {
            this.XC.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.XC.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.XB;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.VI == null || this.VI.acC() == null) {
            return null;
        }
        return this.VI.acC().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.XC != null) {
            this.XC.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.XD = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.XC.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
