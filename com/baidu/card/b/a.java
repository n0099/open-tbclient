package com.baidu.card.b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiP = new ArrayList<>();
    private boolean aiQ;
    private f<bj> aiR;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bj> fVar) {
        this.aiR = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiP.clear();
            this.aiP.addAll(arrayList);
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
        if (this.aiP != null && this.aiP.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiP.get(i);
            if ((viewHolder instanceof C0097a) && (aVar instanceof m)) {
                ((C0097a) viewHolder).a((m) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bj)) {
                bj bjVar = (bj) aVar;
                ((b) viewHolder).a(bjVar);
                if (this.aiR != null) {
                    this.aiR.b(viewHolder.itemView, bjVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.aiP.get(i) instanceof bj) {
            return 1;
        }
        if (this.aiP.get(i) instanceof m) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aiP == null) {
            return 0;
        }
        return this.aiP.size();
    }

    /* loaded from: classes20.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView aiS;
        private ImageView aiT;
        private TextView aiU;
        private TextView aiV;
        private bj aiZ;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiS = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiT = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiU = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aiV = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.aiR != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.aiR.a(view2, b.this.aiZ, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bj bjVar) {
            if (bjVar != null) {
                this.aiZ = bjVar;
                this.aiS.setShowOval(true);
                this.aiS.setShowOuterBorder(false);
                this.aiS.setShowInnerBorder(true);
                this.aiS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiS.setStrokeColorResId(R.color.CAM_X0401);
                this.aiT.setVisibility(8);
                this.aiS.setVisibility(0);
                this.aiS.startLoad(bjVar.getAvatar(), 10, false);
                if (au.getChineseAndEnglishLength(bjVar.getForumName()) <= 10) {
                    this.aiU.setText(bjVar.getForumName());
                } else {
                    this.aiU.setText(au.cutChineseAndEnglishWithSuffix(bjVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aiV.setText(this.attention + " " + au.dA(bjVar.bkG()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiU, R.color.CAM_X0105);
            ap.setViewTextColor(this.aiV, R.color.CAM_X0109);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C0097a extends RecyclerView.ViewHolder {
        private BarImageView aiS;
        private ImageView aiT;
        private TextView aiU;
        private TextView aiV;
        private String attention;
        private View mRootView;

        public C0097a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiS = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiT = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiU = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aiV = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.aiR != null) {
                        int adapterPosition = C0097a.this.getAdapterPosition();
                        a.this.aiR.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(m mVar) {
            if (mVar != null) {
                this.aiT.setVisibility(0);
                this.aiS.setVisibility(8);
                SvgManager.bqB().a(this.aiT, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.aiU.setText(R.string.forum_square_title);
                this.aiV.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiU, R.color.CAM_X0105);
            ap.setViewTextColor(this.aiV, R.color.CAM_X0109);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.aiQ = z;
    }
}
