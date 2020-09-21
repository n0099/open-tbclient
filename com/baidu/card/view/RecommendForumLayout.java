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
/* loaded from: classes20.dex */
public class RecommendForumLayout extends LinearLayout implements q {
    public boolean ais;
    private PullLeftRefreshLayout akN;
    private com.baidu.card.b.a akO;
    private FrameLayout akP;
    private View akQ;
    private ImageView akR;
    private ImageView akS;
    private boolean akT;
    private boolean akU;
    private boolean akV;
    private boolean akW;
    private RefreshView akX;
    private View.OnClickListener akY;
    private PullLeftRefreshLayout.a akZ;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private int mTitleColorId;
    private String tabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.akO.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.akY = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.akZ = aVar;
        this.akN.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.akT = true;
        this.akU = true;
        this.akV = true;
        this.akW = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.akP = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.akQ = findViewById(R.id.layout_into);
        this.akR = (ImageView) findViewById(R.id.iv_into);
        this.akS = (ImageView) findViewById(R.id.iv_into_s);
        this.akN = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.akO = new com.baidu.card.b.a(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.akO.setHasLikeForum(this.ais);
        } else if (this.mFrom == 1) {
            this.akO.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.akO);
        this.mRecyclerView.setClipChildren(false);
        this.akO.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.akS.setClickable(false);
        this.akX = new RefreshView(getContext());
        this.akN.setRefreshViewAndListener(this.akX);
        this.akN.setCallback(this.akZ);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.akT = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.akU = z;
    }

    public void setEnableShowInto(boolean z) {
        this.akV = z;
    }

    public void setShowMore(boolean z) {
        this.akW = z;
        if (this.akN != null) {
            this.akN.setEnablePull(z);
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
        this.akR.setOnClickListener(this.akY);
        this.akQ.setOnClickListener(this.akY);
        if (!TextUtils.isEmpty(bjVar.title) && bjVar.eci != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bjVar.title);
            this.mTitleColorId = bjVar.eci;
            this.akQ.setVisibility(0);
            this.akR.setVisibility(8);
            if (this.akP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akP.getLayoutParams()).topMargin = 0;
                this.akP.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.mTitleColorId = R.color.cp_cont_b;
            this.akQ.setVisibility(8);
            this.akR.setVisibility(0);
            if (this.akP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.akP.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.akP.requestLayout();
            }
        }
        if (!this.akV) {
            this.akQ.setVisibility(8);
            this.akR.setVisibility(8);
        }
        if (bjVar != null && bjVar.beE() != null && bjVar.beE().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bi> beE = bjVar.beE();
            if (this.akT) {
                if (this.akU) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
                if (beE != null) {
                    arrayList.addAll(beE);
                }
            } else {
                if (beE != null) {
                    arrayList.addAll(beE);
                }
                if (this.akU) {
                    arrayList.add(new com.baidu.tbadk.core.data.l());
                }
            }
            this.akO.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.mTitleColorId);
        SvgManager.bkl().a(this.akR, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bkl().a(this.akS, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        this.akX.onChangeSkinType();
        this.akO.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ais = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
