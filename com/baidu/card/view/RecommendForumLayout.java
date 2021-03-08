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
    public boolean akH;
    private PullLeftRefreshLayout ane;
    private HorizontalRecommendForumAdapter anf;
    private FrameLayout ang;
    private View anh;
    private ImageView ani;
    private ImageView anj;
    private boolean ank;
    private boolean anl;
    private boolean anm;
    private boolean ann;
    private RefreshView ano;
    private int anp;
    private View.OnClickListener anq;
    private PullLeftRefreshLayout.a anr;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private String tabName;

    public void setOnItemCoverListener(f<bn> fVar) {
        this.anf.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.anq = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.anr = aVar;
        this.ane.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.ank = true;
        this.anl = true;
        this.anm = true;
        this.ann = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ang = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.anh = findViewById(R.id.layout_into);
        this.ani = (ImageView) findViewById(R.id.iv_into);
        this.anj = (ImageView) findViewById(R.id.iv_into_s);
        this.ane = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.anf = new HorizontalRecommendForumAdapter(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.anf.setHasLikeForum(this.akH);
        } else if (this.mFrom == 1) {
            this.anf.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.anf);
        this.mRecyclerView.setClipChildren(false);
        this.anf.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.anj.setClickable(false);
        this.ano = new RefreshView(getContext());
        this.ane.setRefreshViewAndListener(this.ano);
        this.ane.setCallback(this.anr);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.ank = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.anl = z;
    }

    public void setEnableShowInto(boolean z) {
        this.anm = z;
    }

    public void setShowMore(boolean z) {
        this.ann = z;
        if (this.ane != null) {
            this.ane.setEnablePull(z);
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
        this.ani.setOnClickListener(this.anq);
        this.anh.setOnClickListener(this.anq);
        if (!TextUtils.isEmpty(boVar.title) && boVar.eQN != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(boVar.title);
            this.anp = boVar.eQN;
            this.anh.setVisibility(0);
            this.ani.setVisibility(8);
            if (this.ang.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ang.getLayoutParams()).topMargin = 0;
                this.ang.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.anp = R.color.CAM_X0105;
            this.anh.setVisibility(8);
            this.ani.setVisibility(0);
            if (this.ang.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ang.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.ang.requestLayout();
            }
        }
        if (!this.anm) {
            this.anh.setVisibility(8);
            this.ani.setVisibility(8);
        }
        if (boVar != null && boVar.bmY() != null && boVar.bmY().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bn> bmY = boVar.bmY();
            if (this.ank) {
                if (this.anl) {
                    arrayList.add(new n());
                }
                if (bmY != null) {
                    arrayList.addAll(bmY);
                }
            } else {
                if (bmY != null) {
                    arrayList.addAll(bmY);
                }
                if (this.anl) {
                    arrayList.add(new n());
                }
            }
            this.anf.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, this.anp);
        SvgManager.bsU().a(this.ani, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a(this.anj, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.ano.onChangeSkinType();
        this.anf.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.akH = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
