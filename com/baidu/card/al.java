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
    private static final int afq = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int afr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int afs = afr - afq;
    private static int aft = afs / 2;
    private static int afu = afs / 3;
    protected com.baidu.tbadk.core.data.a ada;
    private BdUniqueId afA;
    private final View.OnClickListener afB;
    private a.b afC;
    private boolean afl;
    protected RoundCornerFrameLayout afy;
    protected com.baidu.tieba.play.operableVideoView.a afz;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a rr();

    public al(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.afl = false;
        this.afB = new View.OnClickListener() { // from class: com.baidu.card.al.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.acY != null) {
                    al.this.acY.a(al.this.ada);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.al.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (al.this.rl() != null) {
                    al.this.rl().a(view, al.this.ada);
                }
            }
        };
        this.afC = new a.b() { // from class: com.baidu.card.al.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0074a c0074a) {
                if (c0074a.getActionType() == 1) {
                    com.baidu.tieba.card.l.a(al.this.mTitle, al.this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0074a.getActionType() == 2) {
                    if (al.this.afz != null) {
                        al.this.afz.bpf();
                    }
                } else if (c0074a.getActionType() == 3) {
                    if (al.this.afz != null) {
                        al.this.afz.cEV();
                    }
                } else if (c0074a.getActionType() == 6) {
                    if (al.this.afz != null) {
                        return al.this.afz.onBackPress();
                    }
                } else if (c0074a.getActionType() == 7) {
                    if (al.this.afy != null) {
                        al.this.afy.aI(((Boolean) c0074a.rJ()).booleanValue());
                    }
                } else if (c0074a.getActionType() == 8 && al.this.afz != null && (c0074a.rJ() instanceof Boolean)) {
                    return al.this.afz.nV(((Boolean) c0074a.rJ()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rk() {
        a(1, this.afC);
        a(2, this.afC);
        a(3, this.afC);
        a(6, this.afC);
        a(7, this.afC);
        a(8, this.afC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.afy = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.afz = rr();
            this.afz.cJq().setBackgroundResource(R.color.transparent);
            this.afz.setUniqueId(this.afA);
            this.afz.setFrom(this.mFrom);
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
            afr = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            afs = afr - afq;
            aft = afs / 2;
            afu = afs / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ada = aVar;
        if (this.ada != null && this.ada.aIw() != null && this.ada.aIw().aKV() != null) {
            this.afz.setData(aVar.aIw());
            ViewGroup.LayoutParams layoutParams = this.afy.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
            if ("index".equals(this.mFrom) && (homePageStyleAbTest & 4) != 0) {
                layoutParams.width = afs;
                layoutParams.height = (afs / 16) * 9;
                if (i2 == layoutParams.height) {
                }
                if (z2) {
                }
                if (!this.ada.aIw().aMz()) {
                }
                if (this.acY != null) {
                }
                if (rl() == null) {
                }
            } else {
                if (this.ada.aIw().aKV().is_vertical.intValue() == 1) {
                    com.baidu.tieba.play.u cJY = this.afz.cJY();
                    if (cJY != null) {
                        int i3 = (aft / 9) * 16;
                        int i4 = afu;
                        int videoWidth = cJY.getVideoWidth();
                        int videoHeight = cJY.getVideoHeight();
                        layoutParams.width = aft;
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
                            int i5 = (int) (((1.0f * videoHeight) / videoWidth) * aft);
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
                    layoutParams.width = afs;
                    layoutParams.height = (afs / 16) * 9;
                    if (i2 == layoutParams.height) {
                    }
                }
                if (z2) {
                    this.afy.setLayoutParams(layoutParams);
                }
                if (!this.ada.aIw().aMz()) {
                    this.mTitle.setMaxLines(5);
                    au.a(this.mTitle, this.ada.aIw(), afs, this.afl);
                } else {
                    this.mTitle.setMaxLines(2);
                    au.a(this.mTitle, this.ada.aIw(), 0, this.afl);
                }
                if (this.acY != null) {
                    this.afz.aa(this.afB);
                }
                if (rl() == null) {
                    this.afz.setAfterClickListener(this.mOnClickListener);
                }
            }
        }
    }

    public void a(b.a aVar) {
        this.acY = aVar;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ada != null && this.ada.aIw() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.ada.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.afy.onChangeSkinType(i);
            this.afy.setBackgroundColor(am.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.afz != null) {
            this.afz.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a rI() {
        return this.afz;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.afz.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.afz.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.afz == null) {
            return false;
        }
        return this.afz.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.afz.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.afz.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.afy;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ada == null || this.ada.aIw() == null) {
            return null;
        }
        return this.ada.aIw().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.afz != null) {
            this.afz.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.afA = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.afz.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}
