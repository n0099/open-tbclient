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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean ajP;
    private PullLeftRefreshLayout aml;
    private com.baidu.card.b.a amm;
    private FrameLayout amn;
    private View amo;
    private ImageView amp;
    private ImageView amq;
    private boolean amr;
    private boolean ams;
    private boolean amt;
    private boolean amu;
    private RefreshView amv;
    private View.OnClickListener amw;
    private PullLeftRefreshLayout.a amx;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bk> fVar) {
        this.amm.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.amw = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.amx = aVar;
        this.aml.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.amr = true;
        this.ams = true;
        this.amt = true;
        this.amu = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amn = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.amo = findViewById(R.id.layout_into);
        this.amp = (ImageView) findViewById(R.id.iv_into);
        this.amq = (ImageView) findViewById(R.id.iv_into_s);
        this.aml = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.amm = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.amm.setHasLikeForum(this.ajP);
        } else if (this.mFrom == 1) {
            this.amm.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.amm);
        this.mRecyclerView.setClipChildren(false);
        this.amm.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.amq.setClickable(false);
        this.amv = new RefreshView(getContext());
        this.aml.setRefreshViewAndListener(this.amv);
        this.aml.setCallback(this.amx);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.amr = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.ams = z;
    }

    public void setEnableShowInto(boolean z) {
        this.amt = z;
    }

    public void setShowMore(boolean z) {
        this.amu = z;
        if (this.aml != null) {
            this.aml.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bl blVar) {
        b(blVar);
    }

    public void b(bl blVar) {
        this.amp.setOnClickListener(this.amw);
        this.amo.setOnClickListener(this.amw);
        if (!TextUtils.isEmpty(blVar.title) && blVar.eHT != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(blVar.title);
            this.mTitleColorId = blVar.eHT;
            this.amo.setVisibility(0);
            this.amp.setVisibility(8);
            if (this.amn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.amn.getLayoutParams()).topMargin = 0;
                this.amn.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.CAM_X0105;
            this.amo.setVisibility(8);
            this.amp.setVisibility(0);
            if (this.amn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.amn.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.amn.requestLayout();
            }
        }
        if (!this.amt) {
            this.amo.setVisibility(8);
            this.amp.setVisibility(8);
        }
        if (blVar != null && blVar.bnV() != null && blVar.bnV().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bk> bnV = blVar.bnV();
            if (this.amr) {
                if (this.ams) {
                    arrayList.add(new m());
                }
                if (bnV != null) {
                    arrayList.addAll(bnV);
                }
            } else {
                if (bnV != null) {
                    arrayList.addAll(bnV);
                }
                if (this.ams) {
                    arrayList.add(new m());
                }
            }
            this.amm.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.btW().a(this.amp, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.btW().a(this.amq, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.amv.onChangeSkinType();
        this.amm.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ajP = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
