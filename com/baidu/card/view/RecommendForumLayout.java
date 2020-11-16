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
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean aiQ;
    private PullLeftRefreshLayout alk;
    private com.baidu.card.b.a alm;
    private FrameLayout aln;
    private View alo;
    private ImageView alp;
    private ImageView alq;
    private boolean alr;
    private boolean als;
    private boolean alt;
    private boolean alu;
    private RefreshView alv;
    private View.OnClickListener alw;
    private PullLeftRefreshLayout.a alx;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bj> fVar) {
        this.alm.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.alw = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.alx = aVar;
        this.alk.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.alr = true;
        this.als = true;
        this.alt = true;
        this.alu = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aln = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.alo = findViewById(R.id.layout_into);
        this.alp = (ImageView) findViewById(R.id.iv_into);
        this.alq = (ImageView) findViewById(R.id.iv_into_s);
        this.alk = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.alm = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.alm.setHasLikeForum(this.aiQ);
        } else if (this.mFrom == 1) {
            this.alm.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.alm);
        this.mRecyclerView.setClipChildren(false);
        this.alm.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.alq.setClickable(false);
        this.alv = new RefreshView(getContext());
        this.alk.setRefreshViewAndListener(this.alv);
        this.alk.setCallback(this.alx);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.alr = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.als = z;
    }

    public void setEnableShowInto(boolean z) {
        this.alt = z;
    }

    public void setShowMore(boolean z) {
        this.alu = z;
        if (this.alk != null) {
            this.alk.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bk bkVar) {
        b(bkVar);
    }

    public void b(bk bkVar) {
        this.alp.setOnClickListener(this.alw);
        this.alo.setOnClickListener(this.alw);
        if (!TextUtils.isEmpty(bkVar.title) && bkVar.eAT != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bkVar.title);
            this.mTitleColorId = bkVar.eAT;
            this.alo.setVisibility(0);
            this.alp.setVisibility(8);
            if (this.aln.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aln.getLayoutParams()).topMargin = 0;
                this.aln.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.CAM_X0105;
            this.alo.setVisibility(8);
            this.alp.setVisibility(0);
            if (this.aln.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aln.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.aln.requestLayout();
            }
        }
        if (!this.alt) {
            this.alo.setVisibility(8);
            this.alp.setVisibility(8);
        }
        if (bkVar != null && bkVar.bkI() != null && bkVar.bkI().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bj> bkI = bkVar.bkI();
            if (this.alr) {
                if (this.als) {
                    arrayList.add(new m());
                }
                if (bkI != null) {
                    arrayList.addAll(bkI);
                }
            } else {
                if (bkI != null) {
                    arrayList.addAll(bkI);
                }
                if (this.als) {
                    arrayList.add(new m());
                }
            }
            this.alm.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.bqB().a(this.alp, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bqB().a(this.alq, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.alv.onChangeSkinType();
        this.alm.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.aiQ = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
