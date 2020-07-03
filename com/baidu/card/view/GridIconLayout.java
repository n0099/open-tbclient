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
import com.baidu.card.n;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.h.e;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class GridIconLayout extends FrameLayout implements n<ag>, o {
    private f<j> agW;
    private c ahh;
    private XGridLayout aig;
    private e<j> aih;
    private com.baidu.tbadk.widget.extend.a.a aii;

    public void setOnItemCoverListener(f<j> fVar) {
        this.agW = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.ahh = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aih = new e<j>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, j jVar, int i, long j) {
                if (jVar != null) {
                    GridIconLayout.this.cZ(jVar.aQm());
                }
                if (GridIconLayout.this.agW != null) {
                    GridIconLayout.this.agW.a(view, jVar, i, j);
                }
            }
        };
        this.aii = new com.baidu.tbadk.widget.extend.a.a<j>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, j jVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.or(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(jVar.aQl(), 10, false);
                TextView textView = (TextView) cVar.or(R.id.tv_title);
                an.setViewTextColor(textView, (int) R.color.cp_cont_b);
                textView.setText(jVar.getTitle());
                if (GridIconLayout.this.agW != null) {
                    GridIconLayout.this.agW.b(cVar.getView(), jVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aig = new XGridLayout(getContext());
        addView(this.aig);
    }

    public void setVerticalSpace(int i) {
        this.aig.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.aig.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.aig.setMaxItem(i);
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
        if (this.ahh != null) {
            this.ahh.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        an.setBackgroundColor(this, R.color.cp_bg_line_e);
        if (this.aig != null) {
            this.aig.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(ag agVar) {
        if (agVar == null || w.isEmpty(agVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<j> list = agVar.dataList;
        this.aig.setAutoGridSpan(list, 5);
        this.aig.setAdapter(this.aii);
        this.aii.a(this.aih);
        this.aii.setData(list);
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
}
