package com.baidu.card.view;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.card.adapter.HorizontalRecommendForumAdapter;
import com.baidu.card.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean akr;
    private PullLeftRefreshLayout amN;
    private HorizontalRecommendForumAdapter amO;
    private FrameLayout amP;
    private View amQ;
    private ImageView amR;
    private ImageView amS;
    private boolean amT;
    private boolean amU;
    private boolean amV;
    private boolean amW;
    private RefreshView amX;
    private int amY;
    private View.OnClickListener amZ;
    private PullLeftRefreshLayout.a ana;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private String tabName;

    public void setOnItemCoverListener(f<bl> fVar) {
        this.amO.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.amZ = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.ana = aVar;
        this.amN.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.amT = true;
        this.amU = true;
        this.amV = true;
        this.amW = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.amP = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.amQ = findViewById(R.id.layout_into);
        this.amR = (ImageView) findViewById(R.id.iv_into);
        this.amS = (ImageView) findViewById(R.id.iv_into_s);
        this.amN = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.amO = new HorizontalRecommendForumAdapter(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.amO.setHasLikeForum(this.akr);
        } else if (this.mFrom == 1) {
            this.amO.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.amO);
        this.mRecyclerView.setClipChildren(false);
        this.amO.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.amS.setClickable(false);
        this.amX = new RefreshView(getContext());
        this.amN.setRefreshViewAndListener(this.amX);
        this.amN.setCallback(this.ana);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.amT = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.amU = z;
    }

    public void setEnableShowInto(boolean z) {
        this.amV = z;
    }

    public void setShowMore(boolean z) {
        this.amW = z;
        if (this.amN != null) {
            this.amN.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bm bmVar) {
        b(bmVar);
    }

    public void b(bm bmVar) {
        this.amR.setOnClickListener(this.amZ);
        this.amQ.setOnClickListener(this.amZ);
        if (!TextUtils.isEmpty(bmVar.title) && bmVar.eRL != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bmVar.title);
            this.amY = bmVar.eRL;
            this.amQ.setVisibility(0);
            this.amR.setVisibility(8);
            if (this.amP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.amP.getLayoutParams()).topMargin = 0;
                this.amP.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.amY = R.color.CAM_X0105;
            this.amQ.setVisibility(8);
            this.amR.setVisibility(0);
            if (this.amP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.amP.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.amP.requestLayout();
            }
        }
        if (!this.amV) {
            this.amQ.setVisibility(8);
            this.amR.setVisibility(8);
        }
        if (bmVar != null && bmVar.bqx() != null && bmVar.bqx().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bl> bqx = bmVar.bqx();
            if (this.amT) {
                if (this.amU) {
                    arrayList.add(new m());
                }
                if (bqx != null) {
                    arrayList.addAll(bqx);
                }
            } else {
                if (bqx != null) {
                    arrayList.addAll(bqx);
                }
                if (this.amU) {
                    arrayList.add(new m());
                }
            }
            this.amO.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, this.amY);
        SvgManager.bwr().a(this.amR, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bwr().a(this.amS, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.amX.onChangeSkinType();
        this.amO.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.akr = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
