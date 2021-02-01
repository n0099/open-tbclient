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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tbadk.core.data.a> {
    private static final int agv = (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    private static int agw = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static int agx = agw - agv;
    private static int agy = agx / 2;
    private static int agz = agx / 3;
    protected RoundCornerFrameLayout agA;
    protected FakeVideoContainer agB;
    private BdUniqueId agC;
    private boolean agD;
    private a.b agE;
    protected com.baidu.tbadk.core.data.a agj;
    private int mLastScreenWidth;
    protected View mRootView;
    protected TextView mTitle;

    public i(Context context) {
        super(context);
        this.mLastScreenWidth = 0;
        this.agD = false;
        this.agE = new a.b() { // from class: com.baidu.card.i.2
            @Override // com.baidu.card.a.a.b
            public boolean a(a.C0089a c0089a) {
                if (c0089a.getActionType() == 7 && i.this.agA != null) {
                    i.this.agA.aN(((Boolean) c0089a.tr()).booleanValue());
                    return false;
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public void sN() {
        a(7, this.agE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.a
    public View getView() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.mTitle = (TextView) this.mRootView.findViewById(R.id.video_seg_title);
            this.agA = (RoundCornerFrameLayout) this.mRootView.findViewById(R.id.frame_video);
            this.agB = new FakeVideoContainer(this.mContext);
            this.agB.setBackgroundResource(R.color.transparent);
            this.agA.addView(this.agB);
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
            this.agB.setData(aVar.bln());
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
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                } else {
                    int i5 = (int) (((intValue2 * 1.0f) / intValue) * agy);
                    if (i5 >= i4) {
                        i4 = i5 > i3 ? i3 : i5;
                    }
                    layoutParams.height = i4;
                    if (i2 != layoutParams.height) {
                        z2 = true;
                        z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
                    }
                    z2 = z4;
                    z = com.baidu.tbadk.a.b.b.a(layoutParams, z2, (com.baidu.tieba.play.operableVideoView.a) null, i, i2);
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
                    this.agA.post(new Runnable() { // from class: com.baidu.card.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            layoutParams.width = i.this.mRootView.getWidth();
                            layoutParams.height = (i.this.mRootView.getWidth() / 16) * 9;
                            i.this.agA.setLayoutParams(layoutParams);
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
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agj != null && this.agj.bln() != null) {
            com.baidu.tieba.card.m.a(this.mTitle, this.agj.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.agA.onChangeSkinType(i);
            this.agA.setBackgroundColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209));
        }
    }

    @Override // com.baidu.card.a
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}
