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
/* loaded from: classes21.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiJ = new ArrayList<>();
    private boolean aiK;
    private f<bi> aiL;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.aiL = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiJ.clear();
            this.aiJ.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new C0098a(inflate) : new b(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.aiJ != null && this.aiJ.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiJ.get(i);
            if ((viewHolder instanceof C0098a) && (aVar instanceof l)) {
                ((C0098a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bi)) {
                bi biVar = (bi) aVar;
                ((b) viewHolder).a(biVar);
                if (this.aiL != null) {
                    this.aiL.b(viewHolder.itemView, biVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.aiJ.get(i) instanceof bi) {
            return 1;
        }
        if (this.aiJ.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aiJ == null) {
            return 0;
        }
        return this.aiJ.size();
    }

    /* loaded from: classes21.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView aiM;
        private ImageView aiN;
        private TextView aiO;
        private TextView aiP;
        private bi aiT;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiM = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiN = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiO = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aiP = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.aiL != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.aiL.a(view2, b.this.aiT, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bi biVar) {
            if (biVar != null) {
                this.aiT = biVar;
                this.aiM.setShowOval(true);
                this.aiM.setShowOuterBorder(false);
                this.aiM.setShowInnerBorder(true);
                this.aiM.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiM.setStrokeColorResId(R.color.cp_border_a);
                this.aiN.setVisibility(8);
                this.aiM.setVisibility(0);
                this.aiM.startLoad(biVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(biVar.getForumName()) <= 10) {
                    this.aiO.setText(biVar.getForumName());
                } else {
                    this.aiO.setText(at.cutChineseAndEnglishWithSuffix(biVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aiP.setText(this.attention + " " + at.dc(biVar.bhl()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiO, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C0098a extends RecyclerView.ViewHolder {
        private BarImageView aiM;
        private ImageView aiN;
        private TextView aiO;
        private TextView aiP;
        private String attention;
        private View mRootView;

        public C0098a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiM = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiN = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiO = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aiP = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.aiL != null) {
                        int adapterPosition = C0098a.this.getAdapterPosition();
                        a.this.aiL.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.aiN.setVisibility(0);
                this.aiM.setVisibility(8);
                SvgManager.bmU().a(this.aiN, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.aiO.setText(R.string.forum_square_title);
                this.aiP.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiO, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.aiK = z;
    }
}
