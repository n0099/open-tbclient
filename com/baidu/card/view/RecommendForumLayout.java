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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class RecommendForumLayout extends LinearLayout implements o {
    public boolean agV;
    private PullLeftRefreshLayout ajc;
    private com.baidu.card.b.a ajd;
    private FrameLayout aje;
    private View ajf;
    private ImageView ajg;
    private ImageView ajh;
    private boolean aji;
    private boolean ajj;
    private boolean ajk;
    private boolean ajl;
    private RefreshView ajm;
    private View.OnClickListener ajn;
    private PullLeftRefreshLayout.a ajo;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bg> fVar) {
        this.ajd.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ajn = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ajo = aVar;
        this.ajc.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.aji = true;
        this.ajj = true;
        this.ajk = true;
        this.ajl = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aje = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.ajf = findViewById(R.id.layout_into);
        this.ajg = (ImageView) findViewById(R.id.iv_into);
        this.ajh = (ImageView) findViewById(R.id.iv_into_s);
        this.ajc = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.ajd = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.ajd.setHasLikeForum(this.agV);
        } else if (this.mFrom == 1) {
            this.ajd.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.ajd);
        this.mRecyclerView.setClipChildren(false);
        this.ajd.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.ajh.setClickable(false);
        this.ajm = new RefreshView(getContext());
        this.ajc.setRefreshViewAndListener(this.ajm);
        this.ajc.setCallback(this.ajo);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.aji = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.ajj = z;
    }

    public void setEnableShowInto(boolean z) {
        this.ajk = z;
    }

    public void setShowMore(boolean z) {
        this.ajl = z;
        if (this.ajc != null) {
            this.ajc.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bh bhVar) {
        b(bhVar);
    }

    public void b(bh bhVar) {
        this.ajg.setOnClickListener(this.ajn);
        this.ajf.setOnClickListener(this.ajn);
        if (!TextUtils.isEmpty(bhVar.title) && bhVar.dKp != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bhVar.title);
            this.mTitleColorId = bhVar.dKp;
            this.ajf.setVisibility(0);
            this.ajg.setVisibility(8);
            if (this.aje.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aje.getLayoutParams()).topMargin = 0;
                this.aje.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.ajf.setVisibility(8);
            this.ajg.setVisibility(0);
            if (this.aje.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aje.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.aje.requestLayout();
            }
        }
        if (!this.ajk) {
            this.ajf.setVisibility(8);
            this.ajg.setVisibility(8);
        }
        if (bhVar != null && bhVar.aRv() != null && bhVar.aRv().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bg> aRv = bhVar.aRv();
            if (this.aji) {
                if (this.ajj) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (aRv != null) {
                    arrayList.addAll(aRv);
                }
            } else {
                if (aRv != null) {
                    arrayList.addAll(aRv);
                }
                if (this.ajj) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.ajd.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.aWQ().a(this.ajg, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a(this.ajh, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.ajm.onChangeSkinType();
        this.ajd.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.agV = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
