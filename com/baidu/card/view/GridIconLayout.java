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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.l;
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
/* loaded from: classes.dex */
public class GridIconLayout extends FrameLayout implements p<ak>, q {
    private f<l> akI;
    private c akT;
    private XGridLayout amd;
    private e<l> ame;
    private com.baidu.tbadk.widget.extend.a.a amf;

    public void setOnItemCoverListener(f<l> fVar) {
        this.akI = fVar;
    }

    public void setIWindowChangedListener(c cVar) {
        this.akT = cVar;
    }

    public GridIconLayout(Context context) {
        this(context, null);
    }

    public GridIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ame = new e<l>() { // from class: com.baidu.card.view.GridIconLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.e
            public void a(View view, l lVar, int i, long j) {
                if (lVar != null) {
                    GridIconLayout.this.di(lVar.blM());
                }
                if (GridIconLayout.this.akI != null) {
                    GridIconLayout.this.akI.a(view, lVar, i, j);
                }
            }
        };
        this.amf = new com.baidu.tbadk.widget.extend.a.a<l>(getContext(), R.layout.grid_icon_item) { // from class: com.baidu.card.view.GridIconLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.widget.extend.a.a
            public void a(com.baidu.tbadk.widget.extend.a.c cVar, l lVar, int i) {
                RoundTbImageView roundTbImageView = (RoundTbImageView) cVar.rT(R.id.iv_icon);
                roundTbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
                roundTbImageView.setPlaceHolder(1);
                roundTbImageView.startLoad(lVar.getImgUrl(), 10, false);
                TextView textView = (TextView) cVar.rT(R.id.tv_title);
                ap.setViewTextColor(textView, R.color.CAM_X0105);
                textView.setText(lVar.getTitle());
                if (GridIconLayout.this.akI != null) {
                    GridIconLayout.this.akI.b(cVar.getView(), lVar, i, i);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amd = new XGridLayout(getContext());
        addView(this.amd);
    }

    public void setVerticalSpace(int i) {
        this.amd.setVerticalSpace(i);
    }

    public void setHorizontalSpace(int i) {
        this.amd.setHorizontalSpace(i);
    }

    public void setMaxItem(int i) {
        this.amd.setMaxItem(i);
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
        if (this.akT != null) {
            this.akT.a(this, i == 0, null);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this, R.color.CAM_X0205);
        if (this.amd != null) {
            this.amd.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(ak akVar) {
        if (akVar == null || y.isEmpty(akVar.dataList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<l> list = akVar.dataList;
        this.amd.setAutoGridSpan(list, 5);
        this.amd.setAdapter(this.amf);
        this.amf.a(this.ame);
        this.amf.setData(list);
    }

    public void di(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                bf.bsY().b((TbPageContext) j.J(getContext()), new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
