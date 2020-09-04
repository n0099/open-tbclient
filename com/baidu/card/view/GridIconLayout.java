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
import com.baidu.card.o;
import com.baidu.card.p;
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
/* loaded from: classes15.dex */
public class GridIconLayout extends FrameLayout implements o<ai>, p {
    private f<j> ahY;
    private c aik;
    private XGridLayout ajp;
    private e<j> ajq;
    private com.baidu.tbadk.widget.extend.a.a ajr;

    public void setOnItemCoverListener(f<j> fVar) {
        this.ahY = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.aik = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajq = new e<j>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, j jVar, int i, long j) {
                if (jVar != null) {
                    GridIconLayout.this.dj(jVar.bcB());
                }
                if (GridIconLayout.this.ahY != null) {
                    GridIconLayout.this.ahY.a(view, jVar, i, j);
                }
            }
        };
        this.ajr = new com.baidu.tbadk.widget.extend.a.a<j>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, j jVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.qW(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(jVar.bcA(), 10, false);
                TextView textView = (TextView) cVar.qW(R.id.tv_title);
                ap.setViewTextColor(textView, R.color.cp_cont_b);
                textView.setText(jVar.getTitle());
                if (GridIconLayout.this.ahY != null) {
                    GridIconLayout.this.ahY.b(cVar.getView(), jVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ajp = new XGridLayout(getContext());
        addView(this.ajp);
    }

    public void setVerticalSpace(int i) {
        this.ajp.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.ajp.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.ajp.setMaxItem(i);
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
        if (this.aik != null) {
            this.aik.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_e);
        if (this.ajp != null) {
            this.ajp.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(ai aiVar) {
        if (aiVar == null || y.isEmpty(aiVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<j> list = aiVar.dataList;
        this.ajp.setAutoGridSpan(list, 5);
        this.ajp.setAdapter(this.ajr);
        this.ajr.a(this.ajq);
        this.ajr.setData(list);
    }

    public void dj(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.bju().b((TbPageContext) i.I(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
