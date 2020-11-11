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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean aiL;
    private PullLeftRefreshLayout alg;
    private com.baidu.card.b.a alh;
    private FrameLayout ali;
    private View alj;
    private ImageView alk;
    private ImageView alm;
    private boolean aln;
    private boolean alo;
    private boolean alp;
    private boolean alq;
    private RefreshView alr;
    private View.OnClickListener als;
    private PullLeftRefreshLayout.a alt;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.alh.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.als = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.alt = aVar;
        this.alg.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.aln = true;
        this.alo = true;
        this.alp = true;
        this.alq = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ali = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.alj = findViewById(R.id.layout_into);
        this.alk = (ImageView) findViewById(R.id.iv_into);
        this.alm = (ImageView) findViewById(R.id.iv_into_s);
        this.alg = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.alh = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.alh.setHasLikeForum(this.aiL);
        } else if (this.mFrom == 1) {
            this.alh.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.alh);
        this.mRecyclerView.setClipChildren(false);
        this.alh.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.alm.setClickable(false);
        this.alr = new RefreshView(getContext());
        this.alg.setRefreshViewAndListener(this.alr);
        this.alg.setCallback(this.alt);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.aln = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.alo = z;
    }

    public void setEnableShowInto(boolean z) {
        this.alp = z;
    }

    public void setShowMore(boolean z) {
        this.alq = z;
        if (this.alg != null) {
            this.alg.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bj bjVar) {
        b(bjVar);
    }

    public void b(bj bjVar) {
        this.alk.setOnClickListener(this.als);
        this.alj.setOnClickListener(this.als);
        if (!TextUtils.isEmpty(bjVar.title) && bjVar.eCC != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bjVar.title);
            this.mTitleColorId = bjVar.eCC;
            this.alj.setVisibility(0);
            this.alk.setVisibility(8);
            if (this.ali.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ali.getLayoutParams()).topMargin = 0;
                this.ali.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.alj.setVisibility(8);
            this.alk.setVisibility(0);
            if (this.ali.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ali.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.ali.requestLayout();
            }
        }
        if (!this.alp) {
            this.alj.setVisibility(8);
            this.alk.setVisibility(8);
        }
        if (bjVar != null && bjVar.blG() != null && bjVar.blG().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bi> blG = bjVar.blG();
            if (this.aln) {
                if (this.alo) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (blG != null) {
                    arrayList.addAll(blG);
                }
            } else {
                if (blG != null) {
                    arrayList.addAll(blG);
                }
                if (this.alo) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.alh.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.brn().a(this.alk, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.alm, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.alr.onChangeSkinType();
        this.alh.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.aiL = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
