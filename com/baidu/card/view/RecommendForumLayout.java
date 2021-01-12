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
    public boolean ajA;
    private PullLeftRefreshLayout alW;
    private HorizontalRecommendForumAdapter alX;
    private FrameLayout alY;
    private View alZ;
    private ImageView ama;
    private ImageView amb;
    private boolean amc;
    private boolean amd;
    private boolean ame;
    private boolean amf;
    private RefreshView amg;
    private int amh;
    private View.OnClickListener ami;
    private PullLeftRefreshLayout.a amj;
    public int mFrom;
    private TbPageContext<?> mPageContext;
    private RecyclerView mRecyclerView;
    private TextView mTitle;
    private String tabName;

    public void setOnItemCoverListener(f<bl> fVar) {
        this.alX.setOnItemCoverListener(fVar);
    }

    public void setOnClickRightArrowListener(View.OnClickListener onClickListener) {
        this.ami = onClickListener;
    }

    public void setOnRullOkCallbackr(PullLeftRefreshLayout.a aVar) {
        this.amj = aVar;
        this.alW.setCallback(aVar);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext) {
        this(tbPageContext, null);
    }

    public RecommendForumLayout(TbPageContext<?> tbPageContext, @Nullable AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        this.amc = true;
        this.amd = true;
        this.ame = true;
        this.amf = false;
        this.mFrom = 0;
        this.mPageContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_forum_horizontal_view, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alY = (FrameLayout) findViewById(R.id.title_view);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.alZ = findViewById(R.id.layout_into);
        this.ama = (ImageView) findViewById(R.id.iv_into);
        this.amb = (ImageView) findViewById(R.id.iv_into_s);
        this.alW = (PullLeftRefreshLayout) findViewById(R.id.refresh_layout);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.alX = new HorizontalRecommendForumAdapter(this.mPageContext, this.mFrom);
        if (this.mFrom == 0) {
            this.alX.setHasLikeForum(this.ajA);
        } else if (this.mFrom == 1) {
            this.alX.setTabName(this.tabName);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity(), 0, false));
        this.mRecyclerView.setAdapter(this.alX);
        this.mRecyclerView.setClipChildren(false);
        this.alX.notifyDataSetChanged();
        this.mTitle.setText(this.mPageContext.getPageActivity().getString(R.string.recommend_forum_title_horizontal));
        this.amb.setClickable(false);
        this.amg = new RefreshView(getContext());
        this.alW.setRefreshViewAndListener(this.amg);
        this.alW.setCallback(this.amj);
    }

    public void setSquareEntranceAtStart(boolean z) {
        this.amc = z;
    }

    public void setShowSquareEntrance(boolean z) {
        this.amd = z;
    }

    public void setEnableShowInto(boolean z) {
        this.ame = z;
    }

    public void setShowMore(boolean z) {
        this.amf = z;
        if (this.alW != null) {
            this.alW.setEnablePull(z);
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
        this.ama.setOnClickListener(this.ami);
        this.alZ.setOnClickListener(this.ami);
        if (!TextUtils.isEmpty(bmVar.title) && bmVar.eNa != 0) {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds37));
            this.mTitle.setText(bmVar.title);
            this.amh = bmVar.eNa;
            this.alZ.setVisibility(0);
            this.ama.setVisibility(8);
            if (this.alY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alY.getLayoutParams()).topMargin = 0;
                this.alY.requestLayout();
            }
        } else {
            this.mTitle.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds46));
            this.mTitle.setText(R.string.recommend_forum_title_horizontal);
            this.amh = R.color.CAM_X0105;
            this.alZ.setVisibility(8);
            this.ama.setVisibility(0);
            if (this.alY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.alY.getLayoutParams()).topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                this.alY.requestLayout();
            }
        }
        if (!this.ame) {
            this.alZ.setVisibility(8);
            this.ama.setVisibility(8);
        }
        if (bmVar != null && bmVar.bmD() != null && bmVar.bmD().size() > 0) {
            ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList = new ArrayList<>();
            ArrayList<bl> bmD = bmVar.bmD();
            if (this.amc) {
                if (this.amd) {
                    arrayList.add(new m());
                }
                if (bmD != null) {
                    arrayList.addAll(bmD);
                }
            } else {
                if (bmD != null) {
                    arrayList.addAll(bmD);
                }
                if (this.amd) {
                    arrayList.add(new m());
                }
            }
            this.alX.setData(arrayList);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, this.amh);
        SvgManager.bsx().a(this.ama, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsx().a(this.amb, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        this.amg.onChangeSkinType();
        this.alX.notifyDataSetChanged();
    }

    public void setHasLikeForum(boolean z) {
        this.ajA = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        onChangeSkinType();
    }
}
