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
    private ArrayList<com.baidu.tbadk.mvc.b.a> akG = new ArrayList<>();
    private boolean akH;
    private f<bn> akI;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bn> fVar) {
        this.akI = fVar;
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.akG.clear();
            this.akG.addAll(arrayList);
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
        if (this.akG != null && this.akG.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.akG.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof n)) {
                ((a) viewHolder).a((n) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bn)) {
                bn bnVar = (bn) aVar;
                ((b) viewHolder).a(bnVar);
                if (this.akI != null) {
                    this.akI.b(viewHolder.itemView, bnVar, i, i);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.akG.get(i) instanceof bn) {
            return 1;
        }
        if (this.akG.get(i) instanceof n) {
            return 2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.akG == null) {
            return 0;
        }
        return this.akG.size();
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView akJ;
        private ImageView akK;
        private TextView akL;
        private TextView akM;
        private bn akQ;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.akJ = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.akK = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.akL = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.akM = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.akI != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.akI.a(view2, b.this.akQ, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bn bnVar) {
            if (bnVar != null) {
                this.akQ = bnVar;
                this.akJ.setShowOval(true);
                this.akJ.setShowOuterBorder(false);
                this.akJ.setShowInnerBorder(true);
                this.akJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.akJ.setStrokeColorResId(R.color.CAM_X0401);
                this.akK.setVisibility(8);
                this.akJ.setVisibility(0);
                this.akJ.startLoad(bnVar.getAvatar(), 10, false);
                if (au.getChineseAndEnglishLength(bnVar.getForumName()) <= 10) {
                    this.akL.setText(bnVar.getForumName());
                } else {
                    this.akL.setText(au.cutChineseAndEnglishWithSuffix(bnVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.akM.setText(this.attention + " " + au.ef(bnVar.bmW()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.akL, R.color.CAM_X0105);
            ap.setViewTextColor(this.akM, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    class a extends RecyclerView.ViewHolder {
        private BarImageView akJ;
        private ImageView akK;
        private TextView akL;
        private TextView akM;
        private String attention;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.akJ = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.akK = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.akL = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.akM = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.akI != null) {
                        int adapterPosition = a.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.akI.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(n nVar) {
            if (nVar != null) {
                this.akK.setVisibility(0);
                this.akJ.setVisibility(8);
                SvgManager.bsU().a(this.akK, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.akL.setText(R.string.forum_square_title);
                this.akM.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.akL, R.color.CAM_X0105);
            ap.setViewTextColor(this.akM, R.color.CAM_X0109);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.akH = z;
    }
}
