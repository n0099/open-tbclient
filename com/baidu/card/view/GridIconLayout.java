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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.h.c;
import com.baidu.tbadk.h.e;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.extend.XGridLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class GridIconLayout extends FrameLayout implements n<ah>, o {
    private f<j> agN;
    private c agY;
    private XGridLayout ahX;
    private e<j> ahY;
    private com.baidu.tbadk.widget.extend.a.a ahZ;

    public void setOnItemCoverListener(f<j> fVar) {
        this.agN = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.agY = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahY = new e<j>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, j jVar, int i, long j) {
                if (jVar != null) {
                    GridIconLayout.this.cY(jVar.aUi());
                }
                if (GridIconLayout.this.agN != null) {
                    GridIconLayout.this.agN.a(view, jVar, i, j);
                }
            }
        };
        this.ahZ = new com.baidu.tbadk.widget.extend.a.a<j>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, j jVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.oK(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(jVar.aUh(), 10, false);
                TextView textView = (TextView) cVar.oK(R.id.tv_title);
                ao.setViewTextColor(textView, R.color.cp_cont_b);
                textView.setText(jVar.getTitle());
                if (GridIconLayout.this.agN != null) {
                    GridIconLayout.this.agN.b(cVar.getView(), jVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahX = new XGridLayout(getContext());
        addView(this.ahX);
    }

    public void setVerticalSpace(int i) {
        this.ahX.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.ahX.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.ahX.setMaxItem(i);
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
        if (this.agY != null) {
            this.agY.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ao.setBackgroundColor(this, R.color.cp_bg_line_e);
        if (this.ahX != null) {
            this.ahX.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(ah ahVar) {
        if (ahVar == null || x.isEmpty(ahVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<j> list = ahVar.dataList;
        this.ahX.setAutoGridSpan(list, 5);
        this.ahX.setAdapter(this.ahZ);
        this.ahZ.a(this.ahY);
        this.ahZ.setData(list);
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
}
