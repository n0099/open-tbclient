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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajo = new ArrayList<>();
    private boolean ajp;
    private f<bn> ajq;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bn> fVar) {
        this.ajq = fVar;
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajo.clear();
            this.ajo.addAll(arrayList);
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
        if (this.ajo != null && this.ajo.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajo.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof n)) {
                ((a) viewHolder).a((n) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bn)) {
                bn bnVar = (bn) aVar;
                ((b) viewHolder).a(bnVar);
                if (this.ajq != null) {
                    this.ajq.b(viewHolder.itemView, bnVar, i, i);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ajo.get(i) instanceof bn) {
            return 1;
        }
        if (this.ajo.get(i) instanceof n) {
            return 2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajo == null) {
            return 0;
        }
        return this.ajo.size();
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView ajr;
        private ImageView ajs;
        private TextView ajt;
        private TextView aju;
        private bn ajy;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ajr = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ajs = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ajt = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aju = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.ajq != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.ajq.a(view2, b.this.ajy, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bn bnVar) {
            if (bnVar != null) {
                this.ajy = bnVar;
                this.ajr.setShowOval(true);
                this.ajr.setShowOuterBorder(false);
                this.ajr.setShowInnerBorder(true);
                this.ajr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ajr.setStrokeColorResId(R.color.CAM_X0401);
                this.ajs.setVisibility(8);
                this.ajr.setVisibility(0);
                this.ajr.startLoad(bnVar.getAvatar(), 10, false);
                if (au.getChineseAndEnglishLength(bnVar.getForumName()) <= 10) {
                    this.ajt.setText(bnVar.getForumName());
                } else {
                    this.ajt.setText(au.cutChineseAndEnglishWithSuffix(bnVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aju.setText(this.attention + " " + au.ef(bnVar.bmU()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.ajt, R.color.CAM_X0105);
            ap.setViewTextColor(this.aju, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    class a extends RecyclerView.ViewHolder {
        private BarImageView ajr;
        private ImageView ajs;
        private TextView ajt;
        private TextView aju;
        private String attention;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ajr = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ajs = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ajt = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aju = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.ajq != null) {
                        int adapterPosition = a.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.ajq.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(n nVar) {
            if (nVar != null) {
                this.ajs.setVisibility(0);
                this.ajr.setVisibility(8);
                SvgManager.bsR().a(this.ajs, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.ajt.setText(R.string.forum_square_title);
                this.aju.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.ajt, R.color.CAM_X0105);
            ap.setViewTextColor(this.aju, R.color.CAM_X0109);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.ajp = z;
    }
}
