package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes20.dex */
public class AutoBannerLayout extends RelativeLayout implements p<l>, q {
    private CoverFlowView<k> ajb;
    private c ajc;
    private d<k> ajd;
    private d<k> aje;
    private List<k> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajb = null;
        this.mData = null;
        this.aje = new d<k>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                AutoBannerLayout.this.dn(str);
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.ajd != null) {
                    AutoBannerLayout.this.ajd.e(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, k kVar) {
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.ajd != null) {
                    AutoBannerLayout.this.ajd.a(i2, kVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.ajb = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e uf() {
                e eVar = new e();
                eVar.setHeight(com.baidu.adp.lib.util.l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
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
                tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds12));
                return tbImageView;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public com.baidu.tbadk.core.flow.a.c ug() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.pg(R.drawable.icon_banner_gray_n);
                cVar.ph(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.pi(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.ajb.setPageMargin(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
        this.ajb.setIndicatorNoOffet(false);
        this.ajb.setDisableParentEvent(false);
        this.ajb.setCoverFlowFactory(bVar);
        this.ajb.setIndicatorVisible(0);
        this.ajb.setIsAutoPlayDragging(false);
        this.ajb.setCallback(this.aje);
        addView(this.ajb);
    }

    public CoverFlowView getCoverFlowView() {
        return this.ajb;
    }

    public void dn(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bqF().b((TbPageContext) i.I(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ue() {
        if (this.ajb != null) {
            this.ajb.ue();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.ajb != null) {
            this.ajb.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.ajb != null) {
            this.ajb.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.ajb != null) {
            this.ajb.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ajc != null) {
            this.ajc.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.ajc = cVar;
    }

    public void setOnCoverViewCallback(d<k> dVar) {
        this.ajd = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.ajb != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.ajb.a(eVar);
        }
    }

    public void r(List<k> list) {
        if (list == null || y.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.ajb.setData(this.mData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(l lVar) {
        if (lVar == null || y.isEmpty(lVar.dataList)) {
            setVisibility(8);
        } else {
            r(lVar.dataList);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ajb != null) {
            this.ajb.onChangeSkinType();
        }
    }
}
