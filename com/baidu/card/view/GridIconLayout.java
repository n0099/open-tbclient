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
/* loaded from: classes21.dex */
public class GridIconLayout extends FrameLayout implements p<ai>, q {
    private f<j> aiM;
    private c aiX;
    private XGridLayout akg;
    private e<j> akh;
    private com.baidu.tbadk.widget.extend.a.a aki;

    public void setOnItemCoverListener(f<j> fVar) {
        this.aiM = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.aiX = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akh = new e<j>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, j jVar, int i, long j) {
                if (jVar != null) {
                    GridIconLayout.this.dl(jVar.bhX());
                }
                if (GridIconLayout.this.aiM != null) {
                    GridIconLayout.this.aiM.a(view, jVar, i, j);
                }
            }
        };
        this.aki = new com.baidu.tbadk.widget.extend.a.a<j>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, j jVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.rW(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(jVar.bhW(), 10, false);
                TextView textView = (TextView) cVar.rW(R.id.tv_title);
                ap.setViewTextColor(textView, R.color.cp_cont_b);
                textView.setText(jVar.getTitle());
                if (GridIconLayout.this.aiM != null) {
                    GridIconLayout.this.aiM.b(cVar.getView(), jVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akg = new XGridLayout(getContext());
        addView(this.akg);
    }

    public void setVerticalSpace(int i) {
        this.akg.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.akg.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.akg.setMaxItem(i);
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
        if (this.aiX != null) {
            this.aiX.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.cp_bg_line_e);
        if (this.akg != null) {
            this.akg.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(ai aiVar) {
        if (aiVar == null || y.isEmpty(aiVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<j> list = aiVar.dataList;
        this.akg.setAutoGridSpan(list, 5);
        this.akg.setAdapter(this.aki);
        this.aki.a(this.akh);
        this.aki.setData(list);
    }

    public void dl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                be.boR().b((TbPageContext) i.I(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
