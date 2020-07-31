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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class AutoBannerLayout extends RelativeLayout implements n<k>, o {
    private CoverFlowView<j> agX;
    private c agY;
    private d<j> agZ;
    private d<j> aha;
    private List<j> mData;

    public AutoBannerLayout(Context context) {
        this(context, null);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agX = null;
        this.mData = null;
        this.aha = new d<j>() { // from class: com.baidu.card.view.AutoBannerLayout.2
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                AutoBannerLayout.this.cY(str);
                int count = x.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.agZ != null) {
                    AutoBannerLayout.this.agZ.f(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, j jVar) {
                int count = x.getCount(AutoBannerLayout.this.mData);
                if (i2 >= 0 && i2 <= count && AutoBannerLayout.this.agZ != null) {
                    AutoBannerLayout.this.agZ.a(i2, jVar);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.agX = new CoverFlowView<>(getContext());
        b bVar = new b() { // from class: com.baidu.card.view.AutoBannerLayout.1
            @Override // com.baidu.tbadk.core.flow.a.b, com.baidu.tbadk.core.flow.a
            public e so() {
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
            public com.baidu.tbadk.core.flow.a.c sp() {
                com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
                cVar.lB(R.drawable.icon_banner_gray_n);
                cVar.lC(R.drawable.icon_banner_s);
                cVar.setGravity(81);
                cVar.lD(R.dimen.tbds26);
                cVar.setSpacing(R.dimen.tbds10);
                return cVar;
            }
        };
        this.agX.setPageMargin(l.getDimens(getContext(), R.dimen.tbds42));
        this.agX.setIndicatorNoOffet(false);
        this.agX.setDisableParentEvent(false);
        this.agX.setCoverFlowFactory(bVar);
        this.agX.setIndicatorVisible(0);
        this.agX.setIsAutoPlayDragging(false);
        this.agX.setCallback(this.aha);
        addView(this.agX);
    }

    public CoverFlowView getCoverFlowView() {
        return this.agX;
    }

    public void cY(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bd.baV().b((TbPageContext) i.G(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sn() {
        if (this.agX != null) {
            this.agX.sn();
        }
    }

    public void setIndicatorVisible(int i) {
        if (this.agX != null) {
            this.agX.setIndicatorVisible(i);
        }
    }

    public void setMarqueenTime(long j) {
        if (this.agX != null) {
            this.agX.setMarqueenTime(j);
        }
    }

    public void setPageMargin(int i) {
        if (this.agX != null) {
            this.agX.setPageMargin(i);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.agY != null) {
            this.agY.a(this, i == 0, null);
        }
    }

    public void setIWindowChangedListener(c cVar) {
        this.agY = cVar;
    }

    public void setOnCoverViewCallback(d<j> dVar) {
        this.agZ = dVar;
    }

    public void setBannerHeight(int i) {
        if (this.agX != null) {
            e eVar = new e();
            eVar.setHeight(i);
            this.agX.a(eVar);
        }
    }

    public void q(List<j> list) {
        if (list == null || x.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mData = list;
        this.agX.setData(this.mData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(k kVar) {
        if (kVar == null || x.isEmpty(kVar.dataList)) {
            setVisibility(8);
        } else {
            q(kVar.dataList);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.agX != null) {
            this.agX.onChangeSkinType();
        }
    }
}
