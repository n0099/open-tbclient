package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.flow.a.b;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class AutoBannerLayout extends RelativeLayout implements n<k>, o {
    private CoverFlowView<j> ahg;
    private c ahh;
    private d<j> ahi;
    private d<j> ahj;
    private List<j> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahg = null;
        this.mData = null;
        this.ahj = new d<j>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                AutoBannerLayout.this.cZ(str);
                int count = w.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.ahi != null) {
                    AutoBannerLayout.this.ahi.f(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, j jVar) {
                int count = w.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.ahi != null) {
                    AutoBannerLayout.this.ahi.a(i2, jVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.ahg = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e sm() {
                e eVar = new e();
                eVar.setHeight(l.getDimens(AutoBannerLayout.this.getContext(), R.dimen.tbds209));
                return eVar;
            }

            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public TbImageView S(Context context) {
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
            public com.baidu.tbadk.core.flow.a.c sn() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.lh(R.drawable.icon_banner_gray_n);
                cVar.li(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.lj(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.ahg.setPageMargin(l.getDimens(getContext(), R.dimen.tbds42));
        this.ahg.setIndicatorNoOffet(false);
        this.ahg.setDisableParentEvent(false);
        this.ahg.setCoverFlowFactory(bVar);
        this.ahg.setIndicatorVisible(0);
        this.ahg.setIsAutoPlayDragging(false);
        this.ahg.setCallback(this.ahj);
        addView(this.ahg);
    }

    public CoverFlowView getCoverFlowView() {
        return this.ahg;
    }

    public void cZ(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bc.aWU().b((TbPageContext) i.G(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sl() {
        if (this.ahg != null) {
            this.ahg.sl();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.ahg != null) {
            this.ahg.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.ahg != null) {
            this.ahg.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.ahg != null) {
            this.ahg.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.ahh != null) {
            this.ahh.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.ahh = cVar;
    }

    public void setOnCoverViewCallback(d<j> dVar) {
        this.ahi = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.ahg != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.ahg.a(eVar);
        }
    }

    public void q(List<j> list) {
        if (list == null || w.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.ahg.setData(this.mData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(k kVar) {
        if (kVar == null || w.isEmpty(kVar.dataList)) {
            setVisibility(8);
        } else {
            q(kVar.dataList);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.ahg != null) {
            this.ahg.onChangeSkinType();
        }
    }
}
