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
    private ArrayList<com.baidu.tbadk.mvc.b.a> ahW = new ArrayList<>();
    private boolean ahX;
    private f<bi> ahY;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.ahY = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ahW.clear();
            this.ahW.addAll(arrayList);
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
        if (this.ahW != null && this.ahW.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ahW.get(i);
            if ((viewHolder instanceof C0096a) && (aVar instanceof l)) {
                ((C0096a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bi)) {
                bi biVar = (bi) aVar;
                ((b) viewHolder).a(biVar);
                if (this.ahY != null) {
                    this.ahY.b(viewHolder.itemView, biVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ahW.get(i) instanceof bi) {
            return 1;
        }
        if (this.ahW.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ahW == null) {
            return 0;
        }
        return this.ahW.size();
    }

    /* loaded from: classes15.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView ahZ;
        private ImageView aia;
        private TextView aib;
        private TextView aic;
        private bi aih;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ahZ = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aia = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aib = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aic = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ahY != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.ahY.a(view2, b.this.aih, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bi biVar) {
            if (biVar != null) {
                this.aih = biVar;
                this.ahZ.setShowOval(true);
                this.ahZ.setShowOuterBorder(false);
                this.ahZ.setShowInnerBorder(true);
                this.ahZ.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ahZ.setStrokeColorResId(R.color.cp_border_a);
                this.aia.setVisibility(8);
                this.ahZ.setVisibility(0);
                this.ahZ.startLoad(biVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(biVar.getForumName()) <= 10) {
                    this.aib.setText(biVar.getForumName());
                } else {
                    this.aib.setText(at.cutChineseAndEnglishWithSuffix(biVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aic.setText(this.attention + " " + at.cT(biVar.bdI()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aib, R.color.cp_cont_b);
            ap.setViewTextColor(this.aic, R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C0096a extends RecyclerView.ViewHolder {
        private BarImageView ahZ;
        private ImageView aia;
        private TextView aib;
        private TextView aic;
        private String attention;
        private View mRootView;

        public C0096a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.ahZ = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aia = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aib = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aic = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ahY != null) {
                        int adapterPosition = C0096a.this.getAdapterPosition();
                        a.this.ahY.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.aia.setVisibility(0);
                this.ahZ.setVisibility(8);
                SvgManager.bjq().a(this.aia, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.aib.setText(R.string.forum_square_title);
                this.aic.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aib, R.color.cp_cont_b);
            ap.setViewTextColor(this.aic, R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.ahX = z;
    }
}
