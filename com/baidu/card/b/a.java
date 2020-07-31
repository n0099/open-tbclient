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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> agL = new ArrayList<>();
    private boolean agM;
    private f<bh> agN;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bh> fVar) {
        this.agN = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.agL.clear();
            this.agL.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new C0097a(inflate) : new b(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.agL != null && this.agL.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.agL.get(i);
            if ((viewHolder instanceof C0097a) && (aVar instanceof l)) {
                ((C0097a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bh)) {
                bh bhVar = (bh) aVar;
                ((b) viewHolder).a(bhVar);
                if (this.agN != null) {
                    this.agN.b(viewHolder.itemView, bhVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.agL.get(i) instanceof bh) {
            return 1;
        }
        if (this.agL.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.agL == null) {
            return 0;
        }
        return this.agL.size();
    }

    /* loaded from: classes15.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView agO;
        private ImageView agP;
        private TextView agQ;
        private TextView agR;
        private bh agV;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.agO = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.agP = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.agQ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.agR = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.agN != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.agN.a(view2, b.this.agV, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bh bhVar) {
            if (bhVar != null) {
                this.agV = bhVar;
                this.agO.setShowOval(true);
                this.agO.setShowOuterBorder(false);
                this.agO.setShowInnerBorder(true);
                this.agO.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.agO.setStrokeColorResId(R.color.cp_border_a);
                this.agP.setVisibility(8);
                this.agO.setVisibility(0);
                this.agO.startLoad(bhVar.getAvatar(), 10, false);
                if (as.getChineseAndEnglishLength(bhVar.getForumName()) <= 10) {
                    this.agQ.setText(bhVar.getForumName());
                } else {
                    this.agQ.setText(as.cutChineseAndEnglishWithSuffix(bhVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.agR.setText(this.attention + " " + as.cI(bhVar.aVp()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.agQ, R.color.cp_cont_b);
            ao.setViewTextColor(this.agR, R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C0097a extends RecyclerView.ViewHolder {
        private BarImageView agO;
        private ImageView agP;
        private TextView agQ;
        private TextView agR;
        private String attention;
        private View mRootView;

        public C0097a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.agO = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.agP = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.agQ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.agR = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.agN != null) {
                        int adapterPosition = C0097a.this.getAdapterPosition();
                        a.this.agN.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.agP.setVisibility(0);
                this.agO.setVisibility(8);
                SvgManager.baR().a(this.agP, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.agQ.setText(R.string.forum_square_title);
                this.agR.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ao.setViewTextColor(this.agQ, R.color.cp_cont_b);
            ao.setViewTextColor(this.agR, R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.agM = z;
    }
}
