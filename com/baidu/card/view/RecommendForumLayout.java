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
import com.baidu.card.p;
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
/* loaded from: classes15.dex */
public class RecommendForumLayout extends LinearLayout implements p {
    public boolean ahV;
    private PullLeftRefreshLayout akm;
    private com.baidu.card.b.a akn;
    private FrameLayout ako;
    private View akp;
    private ImageView akq;
    private ImageView akr;
    private boolean aks;
    private boolean akt;
    private boolean aku;
    private boolean akv;
    private RefreshView akw;
    private View.OnClickListener akx;
    private PullLeftRefreshLayout.a aky;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.akn.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.akx = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.aky = aVar;
        this.akm.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.aks = true;
        this.akt = true;
        this.aku = true;
        this.akv = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ako = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.akp = findViewById(R.id.layout_into);
        this.akq = (ImageView) findViewById(R.id.iv_into);
        this.akr = (ImageView) findViewById(R.id.iv_into_s);
        this.akm = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.akn = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.akn.setHasLikeForum(this.ahV);
        } else if (this.mFrom == 1) {
            this.akn.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.akn);
        this.mRecyclerView.setClipChildren(false);
        this.akn.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.akr.setClickable(false);
        this.akw = new RefreshView(getContext());
        this.akm.setRefreshViewAndListener(this.akw);
        this.akm.setCallback(this.aky);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.aks = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.akt = z;
    }

    public void setEnableShowInto(boolean z) {
        this.aku = z;
    }

    public void setShowMore(boolean z) {
        this.akv = z;
        if (this.akm != null) {
            this.akm.setEnablePull(z);
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
        this.akq.setOnClickListener(this.akx);
        this.akp.setOnClickListener(this.akx);
        if (!TextUtils.isEmpty(bjVar.title) && bjVar.dZU != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bjVar.title);
            this.mTitleColorId = bjVar.dZU;
            this.akp.setVisibility(0);
            this.akq.setVisibility(8);
            if (this.ako.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ako.getLayoutParams()).topMargin = 0;
                this.ako.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.akp.setVisibility(8);
            this.akq.setVisibility(0);
            if (this.ako.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ako.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.ako.requestLayout();
            }
        }
        if (!this.aku) {
            this.akp.setVisibility(8);
            this.akq.setVisibility(8);
        }
        if (bjVar != null && bjVar.bdK() != null && bjVar.bdK().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bi> bdK = bjVar.bdK();
            if (this.aks) {
                if (this.akt) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (bdK != null) {
                    arrayList.addAll(bdK);
                }
            } else {
                if (bdK != null) {
                    arrayList.addAll(bdK);
                }
                if (this.akt) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.akn.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.bjq().a(this.akq, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.akr, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.akw.onChangeSkinType();
        this.akn.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ahV = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
