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
    private boolean ajA;
    private f<bl> ajB;
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajz = new ArrayList<>();
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bl> fVar) {
        this.ajB = fVar;
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajz.clear();
            this.ajz.addAll(arrayList);
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
        if (this.ajz != null && this.ajz.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajz.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof m)) {
                ((a) viewHolder).a((m) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bl)) {
                bl blVar = (bl) aVar;
                ((b) viewHolder).a(blVar);
                if (this.ajB != null) {
                    this.ajB.b(viewHolder.itemView, blVar, i, i);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ajz.get(i) instanceof bl) {
            return 1;
        }
        if (this.ajz.get(i) instanceof m) {
            return 2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajz == null) {
            return 0;
        }
        return this.ajz.size();
    }

    /* loaded from: classes.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView ajC;
        private ImageView ajD;
        private TextView ajE;
        private TextView ajF;
        private bl ajJ;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ajC = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ajD = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ajE = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.ajF = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.ajB != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.ajB.a(view2, b.this.ajJ, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bl blVar) {
            if (blVar != null) {
                this.ajJ = blVar;
                this.ajC.setShowOval(true);
                this.ajC.setShowOuterBorder(false);
                this.ajC.setShowInnerBorder(true);
                this.ajC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ajC.setStrokeColorResId(R.color.CAM_X0401);
                this.ajD.setVisibility(8);
                this.ajC.setVisibility(0);
                this.ajC.startLoad(blVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(blVar.getForumName()) <= 10) {
                    this.ajE.setText(blVar.getForumName());
                } else {
                    this.ajE.setText(at.cutChineseAndEnglishWithSuffix(blVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.ajF.setText(this.attention + " " + at.dZ(blVar.bmB()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.ajE, R.color.CAM_X0105);
            ao.setViewTextColor(this.ajF, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    class a extends RecyclerView.ViewHolder {
        private BarImageView ajC;
        private ImageView ajD;
        private TextView ajE;
        private TextView ajF;
        private String attention;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ajC = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ajD = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ajE = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.ajF = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.adapter.HorizontalRecommendForumAdapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (HorizontalRecommendForumAdapter.this.ajB != null) {
                        int adapterPosition = a.this.getAdapterPosition();
                        HorizontalRecommendForumAdapter.this.ajB.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(m mVar) {
            if (mVar != null) {
                this.ajD.setVisibility(0);
                this.ajC.setVisibility(8);
                SvgManager.bsx().a(this.ajD, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.ajE.setText(R.string.forum_square_title);
                this.ajF.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.ajE, R.color.CAM_X0105);
            ao.setViewTextColor(this.ajF, R.color.CAM_X0109);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.ajA = z;
    }
}
