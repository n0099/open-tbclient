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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public abstract class ar extends b<AbsThreadDataSupport> implements com.baidu.tieba.play.f {
    private static final int agA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static int agB = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agC = agB - agA;
    private static int agD = agC / 2;
    private static int agE = agC / 3;
    protected AbsThreadDataSupport aea;
    protected RoundCornerFrameLayout agI;
    protected com.baidu.tieba.play.operableVideoView.a agJ;
    private BdUniqueId agK;
    private final View.OnClickListener agL;
    private a.b agM;
    private boolean agw;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a rP();

    public ar(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agw = false;
        this.agL = new View.OnClickListener() { // from class: com.baidu.card.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.adY != null) {
                    ar.this.adY.a(ar.this.aea);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.ar.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ar.this.rJ() != null) {
                    ar.this.rJ().a(view, ar.this.aea);
                }
            }
        };
        this.agM = new a.b() { // from class: com.baidu.card.ar.3
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0098a c0098a) {
                if (c0098a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(ar.this.mTitle, ar.this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                } else if (c0098a.getActionType() == 2) {
                    if (ar.this.agJ != null) {
                        ar.this.agJ.bxR();
                    }
                } else if (c0098a.getActionType() == 3) {
                    if (ar.this.agJ != null) {
                        ar.this.agJ.cQz();
                    }
                } else if (c0098a.getActionType() == 6) {
                    if (ar.this.agJ != null) {
                        return ar.this.agJ.cWg();
                    }
                } else if (c0098a.getActionType() == 7) {
                    if (ar.this.agI != null) {
                        ar.this.agI.aK(((Boolean) c0098a.sk()).booleanValue());
                    }
                } else if (c0098a.getActionType() == 8 && ar.this.agJ != null && (c0098a.sk() instanceof Boolean)) {
                    return ar.this.agJ.oC(((Boolean) c0098a.sk()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public void rI() {
        a(1, this.agM);
        a(2, this.agM);
        a(3, this.agM);
        a(6, this.agM);
        a(7, this.agM);
        a(8, this.agM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.b
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agI = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.agJ = rP();
            this.agJ.cUU().setBackgroundResource(R.color.transparent);
            this.agJ.setUniqueId(this.agK);
            this.agJ.setFrom(this.mFrom);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agB = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agC = agB - agA;
            agD = agC / 2;
            agE = agC / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aea = absThreadDataSupport;
        if (this.aea != null && this.aea.aPS() != null && this.aea.aPS().aSH() != null) {
            this.agJ.setData(absThreadDataSupport.aPS());
            ViewGroup.LayoutParams layoutParams = this.agI.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.aea.aPS().aSH().is_vertical.intValue() == 1) {
                com.baidu.tieba.play.u cVC = this.agJ.cVC();
                if (cVC != null) {
                    int i3 = (agD / 9) * 16;
                    int i4 = agE;
                    int videoWidth = cVC.getVideoWidth();
                    int videoHeight = cVC.getVideoHeight();
                    layoutParams.width = agD;
                    boolean z2 = i != layoutParams.width;
                    if (videoWidth == 0 || videoHeight == 0) {
                        layoutParams.height = i3;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    } else {
                        int i5 = (int) (((1.0f * videoHeight) / videoWidth) * agD);
                        if (i5 >= i4) {
                            i4 = i5 > i3 ? i3 : i5;
                        }
                        layoutParams.height = i4;
                        if (i2 != layoutParams.height) {
                            z = true;
                        }
                        z = z2;
                    }
                } else {
                    return;
                }
            } else {
                layoutParams.width = agC;
                layoutParams.height = (agC / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                this.agI.setLayoutParams(layoutParams);
            }
            if (this.aea.aPS().aUm()) {
                this.mTitle.setMaxLines(5);
                aw.a(this.mTitle, this.aea.aPS(), agC, this.agw);
            } else {
                this.mTitle.setMaxLines(2);
                aw.a(this.mTitle, this.aea.aPS(), 0, this.agw);
            }
            if (this.adY != null) {
                this.agJ.aa(this.agL);
            }
            if (rJ() != null) {
                this.agJ.setAfterClickListener(this.mOnClickListener);
            }
        }
    }

    public void a(b.a aVar) {
        this.adY = aVar;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aea != null && this.aea.aPS() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.aea.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            this.agI.onChangeSkinType(i);
            this.agI.setBackgroundColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_bg_line_j));
        }
    }

    public void a(com.baidu.tieba.play.y yVar) {
        if (this.agJ != null) {
            this.agJ.c(yVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a sj() {
        return this.agJ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.agJ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return this.agJ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        if (this.agJ == null) {
            return false;
        }
        return this.agJ.isFullScreen();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.f.c) && ((com.baidu.tbadk.core.util.f.c) this.mContext).videoNeedPreload()) {
            this.agJ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        this.agJ.stopPlay();
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        return this.agI;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.aea == null || this.aea.aPS() == null) {
            return null;
        }
        return this.aea.aPS().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.agJ != null) {
            this.agJ.setFrom(str);
        }
    }

    @Override // com.baidu.card.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agK = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        return this.agJ.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }
}
