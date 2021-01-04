package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> akq = new ArrayList<>();
    private boolean akr;
    private f<bl> aks;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bl> fVar) {
        this.aks = fVar;
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.akq.clear();
            this.akq.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new a(inflate) : new b(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.akq != null && this.akq.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.akq.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof m)) {
                ((a) viewHolder).a((m) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bl)) {
                bl blVar = (bl) aVar;
                ((b) viewHolder).a(blVar);
                if (this.aks != null) {
                    this.aks.b(viewHolder.itemView, blVar, i, i);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.akq.get(i) instanceof bl) {
            return 1;
        }
        if (this.akq.get(i) instanceof m) {
            return 2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.akq == null) {
            return 0;
        }
        return this.akq.size();
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.ViewHolder {
        private bl akA;
        private BarImageView akt;
        private ImageView aku;
        private TextView akv;
        private TextView akw;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.akt = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aku = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.akv = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.akw = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.aks != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.aks.a(view2, b.this.akA, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bl blVar) {
            if (blVar != null) {
                this.akA = blVar;
                this.akt.setShowOval(true);
                this.akt.setShowOuterBorder(false);
                this.akt.setShowInnerBorder(true);
                this.akt.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.akt.setStrokeColorResId(R.color.CAM_X0401);
                this.aku.setVisibility(8);
                this.akt.setVisibility(0);
                this.akt.startLoad(blVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(blVar.getForumName()) <= 10) {
                    this.akv.setText(blVar.getForumName());
                } else {
                    this.akv.setText(at.cutChineseAndEnglishWithSuffix(blVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.akw.setText(this.attention + " " + at.dZ(blVar.bqu()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.akv, R.color.CAM_X0105);
            ao.setViewTextColor(this.akw, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    class a extends RecyclerView.ViewHolder {
        private BarImageView akt;
        private ImageView aku;
        private TextView akv;
        private TextView akw;
        private String attention;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.akt = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aku = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.akv = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.akw = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.aks != null) {
                        int adapterPosition = a.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.aks.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(m mVar) {
            if (mVar != null) {
                this.aku.setVisibility(0);
                this.akt.setVisibility(8);
                SvgManager.bwq().a(this.aku, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.akv.setText(R.string.forum_square_title);
                this.akw.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.akv, R.color.CAM_X0105);
            ao.setViewTextColor(this.akw, R.color.CAM_X0109);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.akr = z;
    }
}
