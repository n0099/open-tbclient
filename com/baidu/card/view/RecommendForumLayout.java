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
    public boolean ahX;
    private PullLeftRefreshLayout.a akA;
    private PullLeftRefreshLayout ako;
    private com.baidu.card.b.a akp;
    private FrameLayout akq;
    private View akr;
    private ImageView aks;
    private ImageView akt;
    private boolean aku;
    private boolean akv;
    private boolean akw;
    private boolean akx;
    private RefreshView aky;
    private View.OnClickListener akz;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.akp.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.akz = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.akA = aVar;
        this.ako.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.aku = true;
        this.akv = true;
        this.akw = true;
        this.akx = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akq = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.akr = findViewById(R.id.layout_into);
        this.aks = (ImageView) findViewById(R.id.iv_into);
        this.akt = (ImageView) findViewById(R.id.iv_into_s);
        this.ako = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.akp = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.akp.setHasLikeForum(this.ahX);
        } else if (this.mFrom == 1) {
            this.akp.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.akp);
        this.mRecyclerView.setClipChildren(false);
        this.akp.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.akt.setClickable(false);
        this.aky = new RefreshView(getContext());
        this.ako.setRefreshViewAndListener(this.aky);
        this.ako.setCallback(this.akA);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.aku = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.akv = z;
    }

    public void setEnableShowInto(boolean z) {
        this.akw = z;
    }

    public void setShowMore(boolean z) {
        this.akx = z;
        if (this.ako != null) {
            this.ako.setEnablePull(z);
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
        this.aks.setOnClickListener(this.akz);
        this.akr.setOnClickListener(this.akz);
        if (!TextUtils.isEmpty(bjVar.title) && bjVar.dZY != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bjVar.title);
            this.mTitleColorId = bjVar.dZY;
            this.akr.setVisibility(0);
            this.aks.setVisibility(8);
            if (this.akq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akq.getLayoutParams()).topMargin = 0;
                this.akq.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.akr.setVisibility(8);
            this.aks.setVisibility(0);
            if (this.akq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akq.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.akq.requestLayout();
            }
        }
        if (!this.akw) {
            this.akr.setVisibility(8);
            this.aks.setVisibility(8);
        }
        if (bjVar != null && bjVar.bdK() != null && bjVar.bdK().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bi> bdK = bjVar.bdK();
            if (this.aku) {
                if (this.akv) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (bdK != null) {
                    arrayList.addAll(bdK);
                }
            } else {
                if (bdK != null) {
                    arrayList.addAll(bdK);
                }
                if (this.akv) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.akp.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.bjq().a(this.aks, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bjq().a(this.akt, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.aky.onChangeSkinType();
        this.akp.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ahX = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
