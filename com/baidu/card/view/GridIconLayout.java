package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.card.p;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.h.e;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes20.dex */
public class GridIconLayout extends FrameLayout implements p<aj>, q {
    private f<k> aiR;
    private c ajc;
    private XGridLayout akj;
    private e<k> akk;
    private com.baidu.tbadk.widget.extend.a.a akl;

    public void setOnItemCoverListener(f<k> fVar) {
        this.aiR = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.ajc = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = new e<k>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, k kVar, int i, long j) {
                if (kVar != null) {
                    GridIconLayout.this.dn(kVar.bjz());
                }
                if (GridIconLayout.this.aiR != null) {
                    GridIconLayout.this.aiR.a(view, kVar, i, j);
                }
            }
        };
        this.akl = new com.baidu.tbadk.widget.extend.a.a<k>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, k kVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.sE(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(kVar.bjy(), 10, false);
                TextView textView = (TextView) cVar.sE(R.id.tv_title);
                ap.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(kVar.getTitle());
                if (GridIconLayout.this.aiR != null) {
                    GridIconLayout.this.aiR.b(cVar.getView(), kVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akj = new XGridLayout(getContext());
        addView(this.akj);
    }

    public void setVerticalSpace(int i) {
        this.akj.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.akj.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.akj.setMaxItem(i);
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
        if (this.ajc != null) {
            this.ajc.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0205);
        if (this.akj != null) {
            this.akj.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(aj ajVar) {
        if (ajVar == null || y.isEmpty(ajVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<k> list = ajVar.dataList;
        this.akj.setAutoGridSpan(list, 5);
        this.akj.setAdapter(this.akl);
        this.akl.a(this.akk);
        this.akl.setData(list);
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
}
