package com.baidu.card.b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ahU = new ArrayList<>();
    private boolean ahV;
    private f<bi> ahW;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.ahW = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ahU.clear();
            this.ahU.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new C0096a(inflate) : new b(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ahU != null && this.ahU.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ahU.get(i);
            if ((viewHolder instanceof C0096a) && (aVar instanceof l)) {
                ((C0096a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bi)) {
                bi biVar = (bi) aVar;
                ((b) viewHolder).a(biVar);
                if (this.ahW != null) {
                    this.ahW.b(viewHolder.itemView, biVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ahU.get(i) instanceof bi) {
            return 1;
        }
        if (this.ahU.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ahU == null) {
            return 0;
        }
        return this.ahU.size();
    }

    /* loaded from: classes15.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView ahX;
        private ImageView ahY;
        private TextView ahZ;
        private TextView aia;
        private bi aif;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ahX = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ahY = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ahZ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aia = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ahW != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.ahW.a(view2, b.this.aif, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bi biVar) {
            if (biVar != null) {
                this.aif = biVar;
                this.ahX.setShowOval(true);
                this.ahX.setShowOuterBorder(false);
                this.ahX.setShowInnerBorder(true);
                this.ahX.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ahX.setStrokeColorResId(R.color.cp_border_a);
                this.ahY.setVisibility(8);
                this.ahX.setVisibility(0);
                this.ahX.startLoad(biVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(biVar.getForumName()) <= 10) {
                    this.ahZ.setText(biVar.getForumName());
                } else {
                    this.ahZ.setText(at.cutChineseAndEnglishWithSuffix(biVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aia.setText(this.attention + " " + at.cT(biVar.bdI()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.ahZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.aia, R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C0096a extends RecyclerView.ViewHolder {
        private BarImageView ahX;
        private ImageView ahY;
        private TextView ahZ;
        private TextView aia;
        private String attention;
        private View mRootView;

        public C0096a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ahX = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.ahY = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.ahZ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aia = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ahW != null) {
                        int adapterPosition = C0096a.this.getAdapterPosition();
                        a.this.ahW.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.ahY.setVisibility(0);
                this.ahX.setVisibility(8);
                SvgManager.bjq().a(this.ahY, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.ahZ.setText(R.string.forum_square_title);
                this.aia.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.ahZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.aia, R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.ahV = z;
    }
}
