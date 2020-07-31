package com.baidu.card.view;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class RecommendForumLayout extends LinearLayout implements o {
    public boolean agM;
    private PullLeftRefreshLayout aiX;
    private com.baidu.card.b.a aiY;
    private FrameLayout aiZ;
    private View aja;
    private ImageView ajb;
    private ImageView ajc;
    private boolean ajd;
    private boolean aje;
    private boolean ajf;
    private boolean ajg;
    private RefreshView ajh;
    private View.OnClickListener aji;
    private PullLeftRefreshLayout.a ajj;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bh> fVar) {
        this.aiY.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.aji = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ajj = aVar;
        this.aiX.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.ajd = true;
        this.aje = true;
        this.ajf = true;
        this.ajg = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aiZ = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.aja = findViewById(R.id.layout_into);
        this.ajb = (ImageView) findViewById(R.id.iv_into);
        this.ajc = (ImageView) findViewById(R.id.iv_into_s);
        this.aiX = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.aiY = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.aiY.setHasLikeForum(this.agM);
        } else if (this.mFrom == 1) {
            this.aiY.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.aiY);
        this.mRecyclerView.setClipChildren(false);
        this.aiY.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.ajc.setClickable(false);
        this.ajh = new RefreshView(getContext());
        this.aiX.setRefreshViewAndListener(this.ajh);
        this.aiX.setCallback(this.ajj);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.ajd = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.aje = z;
    }

    public void setEnableShowInto(boolean z) {
        this.ajf = z;
    }

    public void setShowMore(boolean z) {
        this.ajg = z;
        if (this.aiX != null) {
            this.aiX.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bi biVar) {
        b(biVar);
    }

    public void b(bi biVar) {
        this.ajb.setOnClickListener(this.aji);
        this.aja.setOnClickListener(this.aji);
        if (!TextUtils.isEmpty(biVar.title) && biVar.dQB != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(biVar.title);
            this.mTitleColorId = biVar.dQB;
            this.aja.setVisibility(0);
            this.ajb.setVisibility(8);
            if (this.aiZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiZ.getLayoutParams()).topMargin = 0;
                this.aiZ.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.aja.setVisibility(8);
            this.ajb.setVisibility(0);
            if (this.aiZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiZ.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.aiZ.requestLayout();
            }
        }
        if (!this.ajf) {
            this.aja.setVisibility(8);
            this.ajb.setVisibility(8);
        }
        if (biVar != null && biVar.aVr() != null && biVar.aVr().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bh> aVr = biVar.aVr();
            if (this.ajd) {
                if (this.aje) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (aVr != null) {
                    arrayList.addAll(aVr);
                }
            } else {
                if (aVr != null) {
                    arrayList.addAll(aVr);
                }
                if (this.aje) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.aiY.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.baR().a(this.ajb, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.ajc, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.ajh.onChangeSkinType();
        this.aiY.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.agM = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
