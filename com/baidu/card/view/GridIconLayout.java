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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.h.e;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes20.dex */
public class GridIconLayout extends FrameLayout implements p<ai>, q {
    private c aiE;
    private f<j> ait;
    private XGridLayout ajN;
    private e<j> ajO;
    private com.baidu.tbadk.widget.extend.a.a ajP;

    public void setOnItemCoverListener(f<j> fVar) {
        this.ait = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.aiE = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajO = new e<j>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, j jVar, int i, long j) {
                if (jVar != null) {
                    GridIconLayout.this.dl(jVar.bdv());
                }
                if (GridIconLayout.this.ait != null) {
                    GridIconLayout.this.ait.a(view, jVar, i, j);
                }
            }
        };
        this.ajP = new com.baidu.tbadk.widget.extend.a.a<j>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, j jVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.rn(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(jVar.bdu(), 10, false);
                TextView textView = (TextView) cVar.rn(R.id.tv_title);
                ap.setViewTextColor(textView, R.color.cp_cont_b);
                textView.setText(jVar.getTitle());
                if (GridIconLayout.this.ait != null) {
                    GridIconLayout.this.ait.b(cVar.getView(), jVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajN = new XGridLayout(getContext());
        addView(this.ajN);
    }

    public void setVerticalSpace(int i) {
        this.ajN.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.ajN.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.ajN.setMaxItem(i);
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
        if (this.aiE != null) {
            this.aiE.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_e);
        if (this.ajN != null) {
            this.ajN.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(ai aiVar) {
        if (aiVar == null || y.isEmpty(aiVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<j> list = aiVar.dataList;
        this.ajN.setAutoGridSpan(list, 5);
        this.ajN.setAdapter(this.ajP);
        this.ajP.a(this.ajO);
        this.ajP.setData(list);
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
}
