package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes20.dex */
public class AutoBannerLayout extends RelativeLayout implements p<k>, q {
    private CoverFlowView<j> aiD;
    private c aiE;
    private d<j> aiF;
    private d<j> aiG;
    private List<j> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiD = null;
        this.mData = null;
        this.aiG = new d<j>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                AutoBannerLayout.this.dl(str);
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.aiF != null) {
                    AutoBannerLayout.this.aiF.e(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, j jVar) {
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.aiF != null) {
                    AutoBannerLayout.this.aiF.a(i2, jVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.aiD = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e uf() {
                e eVar = new e();
                eVar.setHeight(l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView V(Context context) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(false);
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ug() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.nT(R.drawable.icon_banner_gray_n);
                cVar.nU(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.nV(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.aiD.setPageMargin(l.getDimens(getContext(), R.dimen.tbds42));
        this.aiD.setIndicatorNoOffet(false);
        this.aiD.setDisableParentEvent(false);
        this.aiD.setCoverFlowFactory(bVar);
        this.aiD.setIndicatorVisible(0);
        this.aiD.setIsAutoPlayDragging(false);
        this.aiD.setCallback(this.aiG);
        addView(this.aiD);
    }

    public CoverFlowView getCoverFlowView() {
        return this.aiD;
    }

    public void dl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.bkp().b((TbPageContext) i.I(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ue() {
        if (this.aiD != null) {
            this.aiD.ue();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.aiD != null) {
            this.aiD.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.aiD != null) {
            this.aiD.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.aiD != null) {
            this.aiD.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aiE != null) {
            this.aiE.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.aiE = cVar;
    }

    public void setOnCoverViewCallback(d<j> dVar) {
        this.aiF = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.aiD != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.aiD.a(eVar);
        }
    }

    public void r(List<j> list) {
        if (list == null || y.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.aiD.setData(this.mData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(k kVar) {
        if (kVar == null || y.isEmpty(kVar.dataList)) {
            setVisibility(8);
        } else {
            r(kVar.dataList);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.aiD != null) {
            this.aiD.onChangeSkinType();
        }
    }
}
