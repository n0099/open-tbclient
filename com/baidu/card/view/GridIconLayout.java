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
    private f<k> ajB;
    private c ajM;
    private XGridLayout akU;
    private e<k> akV;
    private com.baidu.tbadk.widget.extend.a.a akW;

    public void setOnItemCoverListener(f<k> fVar) {
        this.ajB = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.ajM = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akV = new e<k>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, k kVar, int i, long j) {
                if (kVar != null) {
                    GridIconLayout.this.de(kVar.bls());
                }
                if (GridIconLayout.this.ajB != null) {
                    GridIconLayout.this.ajB.a(view, kVar, i, j);
                }
            }
        };
        this.akW = new com.baidu.tbadk.widget.extend.a.a<k>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, k kVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.rM(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(kVar.getImgUrl(), 10, false);
                TextView textView = (TextView) cVar.rM(R.id.tv_title);
                ao.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(kVar.getTitle());
                if (GridIconLayout.this.ajB != null) {
                    GridIconLayout.this.ajB.b(cVar.getView(), kVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akU = new XGridLayout(getContext());
        addView(this.akU);
    }

    public void setVerticalSpace(int i) {
        this.akU.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.akU.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.akU.setMaxItem(i);
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
        if (this.ajM != null) {
            this.ajM.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this, R.color.CAM_X0205);
        if (this.akU != null) {
            this.akU.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void C(aj ajVar) {
        if (ajVar == null || x.isEmpty(ajVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<k> list = ajVar.dataList;
        this.akU.setAutoGridSpan(list, 5);
        this.akU.setAdapter(this.akW);
        this.akW.a(this.akV);
        this.akW.setData(list);
    }

    public void de(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.bsB().b((TbPageContext) j.K(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
