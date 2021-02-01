package com.baidu.card;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class as extends a<com.baidu.tbadk.core.data.a> implements com.baidu.tieba.play.e {
    private static final int agv = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int agw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agx = agw - agv;
    private static int agy = agx / 2;
    private static int agz = agx / 3;
    protected RoundCornerFrameLayout agA;
    private BdUniqueId agC;
    private boolean agD;
    private a.b agE;
    protected com.baidu.tbadk.core.data.a agj;
    protected com.baidu.tieba.play.operableVideoView.a ajd;
    private String aje;
    private View.OnClickListener ajf;
    private final View.OnClickListener ajg;
    private String mFrom;
    private int mLastScreenWidth;
    private final View.OnClickListener mOnClickListener;
    protected View mRootView;
    protected TextView mTitle;

    protected abstract com.baidu.tieba.play.operableVideoView.a sU();

    public as(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agD = false;
        this.ajf = new View.OnClickListener() { // from class: com.baidu.card.as.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.a.d.bju() && as.this.agj != null) {
                    com.baidu.tbadk.util.s.a(false, as.this.mContext, as.this.agj.bln(), as.this.mFrom);
                } else if (com.baidu.tbadk.a.d.bjv()) {
                    if (as.this.agj != null && as.this.agj.bln() != null) {
                        com.baidu.tbadk.util.s.a(false, as.this.mContext, as.this.agj.bln(), 0, (Rect) null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", as.this.mFrom, as.this.mFrom);
                    }
                } else if (as.this.agh != null) {
                    as.this.agh.a(as.this.agj);
                }
            }
        };
        this.ajg = new View.OnClickListener() { // from class: com.baidu.card.as.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.agh != null) {
                    as.this.agh.a(as.this.agj);
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.as.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (as.this.sO() != null) {
                    as.this.sO().a(view, as.this.agj);
                }
            }
        };
        this.agE = new a.b() { // from class: com.baidu.card.as.5
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.getActionType() == 1) {
                    com.baidu.tieba.card.m.a(as.this.mTitle, as.this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                } else if (c0089a.getActionType() == 2) {
                    if (as.this.ajd != null) {
                        as.this.ajd.onScroll();
                    }
                } else if (c0089a.getActionType() == 3) {
                    if (as.this.ajd != null) {
                        as.this.ajd.dvp();
                    }
                } else if (c0089a.getActionType() == 6) {
                    if (as.this.ajd != null) {
                        return as.this.ajd.dAA();
                    }
                } else if (c0089a.getActionType() == 7) {
                    if (as.this.agA != null) {
                        as.this.agA.aN(((Boolean) c0089a.tr()).booleanValue());
                    }
                } else if (c0089a.getActionType() == 8 && as.this.ajd != null && (c0089a.tr() instanceof Boolean)) {
                    return as.this.ajd.sp(((Boolean) c0089a.tr()).booleanValue());
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(1, this.agE);
        a(2, this.agE);
        a(3, this.agE);
        a(6, this.agE);
        a(7, this.agE);
        a(8, this.agE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agA = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.ajd = sU();
            this.ajd.dzP().setBackgroundResource(R.color.transparent);
            this.ajd.setUniqueId(this.agC);
            this.ajd.setFrom(this.mFrom);
            this.ajd.setStageType(this.aje);
        }
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        if (equipmentWidth != this.mLastScreenWidth) {
            agw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            agx = agw - agv;
            agy = agx / 2;
            agz = agx / 3;
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agj = aVar;
        if (this.agj != null && this.agj.bln() != null && this.agj.bln().boh() != null) {
            this.ajd.setData(aVar.bln());
            final ViewGroup.LayoutParams layoutParams = this.agA.getLayoutParams();
            int i = layoutParams.width;
            int i2 = layoutParams.height;
            if (this.agj.bln().boh().is_vertical.intValue() == 1) {
                int i3 = (agy / 9) * 16;
                int i4 = agz;
                int intValue = this.agj.bln().boh().video_width.intValue();
                int intValue2 = this.agj.bln().boh().video_height.intValue();
                layoutParams.width = agy;
                boolean z4 = i != layoutParams.width;
                if (intValue == 0 || intValue2 == 0) {
                    layoutParams.height = i3;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajd, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajd, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * agy);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajd, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, this.ajd, i, i2);
                }
            } else {
                layoutParams.width = agx;
                layoutParams.height = (agx / 16) * 9;
                z = (i2 == layoutParams.height && i == layoutParams.width) ? false : true;
            }
            if (z) {
                if (this.agj.bln().boh().is_vertical.intValue() == 1) {
                    this.agA.setLayoutParams(layoutParams);
                } else {
                    this.agA.post(new Runnable() { // from class: com.baidu.card.as.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = as.this.mRootView.getWidth();
                            layoutParams.height = (as.this.mRootView.getWidth() / 16) * 9;
                            as.this.agA.setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            if (this.agj.bln().bpO()) {
                this.mTitle.setMaxLines(5);
                az.a(this.mTitle, this.agj.bln(), agx, this.agD);
            } else {
                this.mTitle.setMaxLines(2);
                az.a(this.mTitle, this.agj.bln(), 0, this.agD);
            }
            if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                z3 = false;
            }
            az.a(this.agA, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.agh != null) {
                this.ajd.ae(this.ajg);
            }
            if (sO() != null) {
                this.ajd.setAfterClickListener(this.mOnClickListener);
            }
            if (this.mTitle != null && this.mRootView != null) {
                this.mTitle.setOnClickListener(this.ajf);
                this.mRootView.setOnClickListener(this.ajf);
            }
        }
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agj != null && this.agj.bln() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.agA.onChangeSkinType(i);
            this.agA.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    public void setVideoStatData(com.baidu.tieba.play.o oVar) {
        if (this.ajd != null) {
            this.ajd.b(oVar);
        }
    }

    public com.baidu.tieba.play.operableVideoView.a tq() {
        return this.ajd;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ajd.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ajd.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.ajd == null) {
            return false;
        }
        return this.ajd.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if ((this.mContext instanceof com.baidu.tbadk.core.util.g.b) && ((com.baidu.tbadk.core.util.g.b) this.mContext).videoNeedPreload()) {
            this.ajd.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        this.ajd.stopPlay();
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        return this.agA;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.agj == null || this.agj.bln() == null) {
            return null;
        }
        return this.agj.bln().getVideoUrl();
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.ajd != null) {
            this.ajd.setFrom(str);
        }
    }

    public void setStageType(String str) {
        this.aje = str;
        if (this.ajd != null) {
            this.ajd.setStageType(str);
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        return this.ajd.getCurrentPosition();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}
