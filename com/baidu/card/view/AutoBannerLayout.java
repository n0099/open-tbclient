package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.j;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.data.m;
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
/* loaded from: classes.dex */
public class AutoBannerLayout extends RelativeLayout implements p<m>, q {
    private CoverFlowView<l> akS;
    private c akT;
    private d<l> akU;
    private d<l> akV;
    private List<l> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akS = null;
        this.mData = null;
        this.akV = new d<l>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                AutoBannerLayout.this.di(str);
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.akU != null) {
                    AutoBannerLayout.this.akU.f(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, l lVar) {
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.akU != null) {
                    AutoBannerLayout.this.akU.a(i2, lVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.akS = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e tt() {
                e eVar = new e();
                eVar.setHeight(com.baidu.adp.lib.util.l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView U(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c tu() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.oq(R.drawable.icon_banner_gray_n);
                cVar.or(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.os(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.akS.setPageMargin(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
        this.akS.setIndicatorNoOffet(false);
        this.akS.setDisableParentEvent(false);
        this.akS.setCoverFlowFactory(bVar);
        this.akS.setIndicatorVisible(0);
        this.akS.setIsAutoPlayDragging(false);
        this.akS.setCallback(this.akV);
        addView(this.akS);
    }

    public CoverFlowView getCoverFlowView() {
        return this.akS;
    }

    public void di(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bsY().b((TbPageContext) j.J(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ts() {
        if (this.akS != null) {
            this.akS.ts();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.akS != null) {
            this.akS.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.akS != null) {
            this.akS.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.akS != null) {
            this.akS.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.akT != null) {
            this.akT.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.akT = cVar;
    }

    public void setOnCoverViewCallback(d<l> dVar) {
        this.akU = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.akS != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.akS.a(eVar);
        }
    }

    public void r(List<l> list) {
        if (list == null || y.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.akS.setData(this.mData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(m mVar) {
        if (mVar == null || y.isEmpty(mVar.dataList)) {
            setVisibility(8);
        } else {
            r(mVar.dataList);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.akS != null) {
            this.akS.onChangeSkinType();
        }
    }
}
