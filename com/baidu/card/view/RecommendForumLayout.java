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
    public boolean aiK;
    private PullLeftRefreshLayout alf;
    private com.baidu.card.b.a alg;
    private FrameLayout alh;
    private View ali;
    private ImageView alj;
    private ImageView alk;
    private boolean alm;
    private boolean aln;
    private boolean alo;
    private boolean alp;
    private RefreshView alq;
    private View.OnClickListener alr;
    private PullLeftRefreshLayout.a als;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.alg.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.alr = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.als = aVar;
        this.alf.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.alm = true;
        this.aln = true;
        this.alo = true;
        this.alp = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alh = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.ali = findViewById(R.id.layout_into);
        this.alj = (ImageView) findViewById(R.id.iv_into);
        this.alk = (ImageView) findViewById(R.id.iv_into_s);
        this.alf = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.alg = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.alg.setHasLikeForum(this.aiK);
        } else if (this.mFrom == 1) {
            this.alg.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.alg);
        this.mRecyclerView.setClipChildren(false);
        this.alg.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.alk.setClickable(false);
        this.alq = new RefreshView(getContext());
        this.alf.setRefreshViewAndListener(this.alq);
        this.alf.setCallback(this.als);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.alm = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.aln = z;
    }

    public void setEnableShowInto(boolean z) {
        this.alo = z;
    }

    public void setShowMore(boolean z) {
        this.alp = z;
        if (this.alf != null) {
            this.alf.setEnablePull(z);
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
        this.alj.setOnClickListener(this.alr);
        this.ali.setOnClickListener(this.alr);
        if (!TextUtils.isEmpty(bjVar.title) && bjVar.eon != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bjVar.title);
            this.mTitleColorId = bjVar.eon;
            this.ali.setVisibility(0);
            this.alj.setVisibility(8);
            if (this.alh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alh.getLayoutParams()).topMargin = 0;
                this.alh.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.ali.setVisibility(8);
            this.alj.setVisibility(0);
            if (this.alh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alh.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.alh.requestLayout();
            }
        }
        if (!this.alo) {
            this.ali.setVisibility(8);
            this.alj.setVisibility(8);
        }
        if (bjVar != null && bjVar.bhn() != null && bjVar.bhn().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bi> bhn = bjVar.bhn();
            if (this.alm) {
                if (this.aln) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (bhn != null) {
                    arrayList.addAll(bhn);
                }
            } else {
                if (bhn != null) {
                    arrayList.addAll(bhn);
                }
                if (this.aln) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.alg.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.bmU().a(this.alj, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a(this.alk, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.alq.onChangeSkinType();
        this.alg.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.aiK = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
