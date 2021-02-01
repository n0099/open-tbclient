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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tbadk.widget.horizontalpullview.RefreshView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean ajp;
    private PullLeftRefreshLayout alM;
    private HorizontalRecommendForumAdapter alN;
    private FrameLayout alO;
    private View alP;
    private ImageView alQ;
    private ImageView alR;
    private boolean alS;
    private boolean alT;
    private boolean alU;
    private boolean alV;
    private RefreshView alW;
    private int alX;
    private View.OnClickListener alY;
    private PullLeftRefreshLayout.a alZ;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private String tabName;

    public void setOnItemCoverListener(f<bn> fVar) {
        this.alN.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.alY = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.alZ = aVar;
        this.alM.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.alS = true;
        this.alT = true;
        this.alU = true;
        this.alV = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alO = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.alP = findViewById(R.id.layout_into);
        this.alQ = (ImageView) findViewById(R.id.iv_into);
        this.alR = (ImageView) findViewById(R.id.iv_into_s);
        this.alM = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.alN = new HorizontalRecommendForumAdapter(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.alN.setHasLikeForum(this.ajp);
        } else if (this.mFrom == 1) {
            this.alN.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.alN);
        this.mRecyclerView.setClipChildren(false);
        this.alN.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.alR.setClickable(false);
        this.alW = new RefreshView(getContext());
        this.alM.setRefreshViewAndListener(this.alW);
        this.alM.setCallback(this.alZ);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.alS = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.alT = z;
    }

    public void setEnableShowInto(boolean z) {
        this.alU = z;
    }

    public void setShowMore(boolean z) {
        this.alV = z;
        if (this.alM != null) {
            this.alM.setEnablePull(z);
        }
    }

    public void setTabName(String str) {
        this.tabName = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setData(bo boVar) {
        b(boVar);
    }

    public void b(bo boVar) {
        this.alQ.setOnClickListener(this.alY);
        this.alP.setOnClickListener(this.alY);
        if (!TextUtils.isEmpty(boVar.title) && boVar.ePm != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(boVar.title);
            this.alX = boVar.ePm;
            this.alP.setVisibility(0);
            this.alQ.setVisibility(8);
            if (this.alO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alO.getLayoutParams()).topMargin = 0;
                this.alO.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.alX = R.color.CAM_X0105;
            this.alP.setVisibility(8);
            this.alQ.setVisibility(0);
            if (this.alO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alO.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.alO.requestLayout();
            }
        }
        if (!this.alU) {
            this.alP.setVisibility(8);
            this.alQ.setVisibility(8);
        }
        if (boVar != null && boVar.bmW() != null && boVar.bmW().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bn> bmW = boVar.bmW();
            if (this.alS) {
                if (this.alT) {
                    arrayList.add(new n());
                }
                if (bmW != null) {
                    arrayList.addAll(bmW);
                }
            } else {
                if (bmW != null) {
                    arrayList.addAll(bmW);
                }
                if (this.alT) {
                    arrayList.add(new n());
                }
            }
            this.alN.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.alX);
        SvgManager.bsR().a(this.alQ, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a(this.alR, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.alW.onChangeSkinType();
        this.alN.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ajp = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
