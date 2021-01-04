package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.h.e;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements p<aj>, q {
    private c akD;
    private f<k> aks;
    private XGridLayout alM;
    private e<k> alN;
    private com.baidu.tbadk.widget.extend.a.a alO;

    public void setOnItemCoverListener(f<k> fVar) {
        this.aks = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.akD = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alN = new e<k>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, k kVar, int i, long j) {
                if (kVar != null) {
                    GridIconLayout.this.dj(kVar.bpl());
                }
                if (GridIconLayout.this.aks != null) {
                    GridIconLayout.this.aks.a(view, kVar, i, j);
                }
            }
        };
        this.alO = new com.baidu.tbadk.widget.extend.a.a<k>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, k kVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.ts(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(kVar.getImgUrl(), 10, false);
                TextView textView = (TextView) cVar.ts(R.id.tv_title);
                ao.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(kVar.getTitle());
                if (GridIconLayout.this.aks != null) {
                    GridIconLayout.this.aks.b(cVar.getView(), kVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alM = new XGridLayout(getContext());
        addView(this.alM);
    }

    public void setVerticalSpace(int i) {
        this.alM.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.alM.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.alM.setMaxItem(i);
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.akD != null) {
            this.akD.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this, R.color.CAM_X0205);
        if (this.alM != null) {
            this.alM.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(aj ajVar) {
        if (ajVar == null || x.isEmpty(ajVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<k> list = ajVar.dataList;
        this.alM.setAutoGridSpan(list, 5);
        this.alM.setAdapter(this.alO);
        this.alO.a(this.alN);
        this.alO.setData(list);
    }

    public void dj(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.bwu().b((TbPageContext) j.K(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
