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
/* loaded from: classes21.dex */
public class AutoBannerLayout extends RelativeLayout implements p<l>, q {
    private CoverFlowView<k> aka;
    private c akb;
    private d<k> akc;
    private d<k> akd;
    private List<k> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aka = null;
        this.mData = null;
        this.akd = new d<k>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                AutoBannerLayout.this.dq(str);
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.akc != null) {
                    AutoBannerLayout.this.akc.e(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, k kVar) {
                int count = y.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.akc != null) {
                    AutoBannerLayout.this.akc.a(i2, kVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.aka = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e ui() {
                e eVar = new e();
                eVar.setHeight(com.baidu.adp.lib.util.l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView W(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c uj() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.pH(R.drawable.icon_banner_gray_n);
                cVar.pI(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.pJ(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.aka.setPageMargin(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42));
        this.aka.setIndicatorNoOffet(false);
        this.aka.setDisableParentEvent(false);
        this.aka.setCoverFlowFactory(bVar);
        this.aka.setIndicatorVisible(0);
        this.aka.setIsAutoPlayDragging(false);
        this.aka.setCallback(this.akd);
        addView(this.aka);
    }

    public CoverFlowView getCoverFlowView() {
        return this.aka;
    }

    public void dq(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bua().b((TbPageContext) i.J(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uh() {
        if (this.aka != null) {
            this.aka.uh();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.aka != null) {
            this.aka.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.aka != null) {
            this.aka.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.aka != null) {
            this.aka.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.akb != null) {
            this.akb.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.akb = cVar;
    }

    public void setOnCoverViewCallback(d<k> dVar) {
        this.akc = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.aka != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.aka.a(eVar);
        }
    }

    public void r(List<k> list) {
        if (list == null || y.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.aka.setData(this.mData);
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
        if (this.aka != null) {
            this.aka.onChangeSkinType();
        }
    }
}
