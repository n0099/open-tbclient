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
/* loaded from: classes20.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> air = new ArrayList<>();
    private boolean ais;
    private f<bi> ait;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bi> fVar) {
        this.ait = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.air.clear();
            this.air.addAll(arrayList);
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
        if (this.air != null && this.air.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.air.get(i);
            if ((viewHolder instanceof C0097a) && (aVar instanceof l)) {
                ((C0097a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bi)) {
                bi biVar = (bi) aVar;
                ((b) viewHolder).a(biVar);
                if (this.ait != null) {
                    this.ait.b(viewHolder.itemView, biVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.air.get(i) instanceof bi) {
            return 1;
        }
        if (this.air.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.air == null) {
            return 0;
        }
        return this.air.size();
    }

    /* loaded from: classes20.dex */
    class b extends RecyclerView.ViewHolder {
        private bi aiB;
        private BarImageView aiu;
        private ImageView aiv;
        private TextView aiw;
        private TextView aix;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiu = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiv = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiw = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aix = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ait != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.ait.a(view2, b.this.aiB, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bi biVar) {
            if (biVar != null) {
                this.aiB = biVar;
                this.aiu.setShowOval(true);
                this.aiu.setShowOuterBorder(false);
                this.aiu.setShowInnerBorder(true);
                this.aiu.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiu.setStrokeColorResId(R.color.cp_border_a);
                this.aiv.setVisibility(8);
                this.aiu.setVisibility(0);
                this.aiu.startLoad(biVar.getAvatar(), 10, false);
                if (at.getChineseAndEnglishLength(biVar.getForumName()) <= 10) {
                    this.aiw.setText(biVar.getForumName());
                } else {
                    this.aiw.setText(at.cutChineseAndEnglishWithSuffix(biVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aix.setText(this.attention + " " + at.cU(biVar.beC()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiw, R.color.cp_cont_b);
            ap.setViewTextColor(this.aix, R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C0097a extends RecyclerView.ViewHolder {
        private BarImageView aiu;
        private ImageView aiv;
        private TextView aiw;
        private TextView aix;
        private String attention;
        private View mRootView;

        public C0097a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.aiu = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.aiv = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.aiw = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aix = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ait != null) {
                        int adapterPosition = C0097a.this.getAdapterPosition();
                        a.this.ait.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.aiv.setVisibility(0);
                this.aiu.setVisibility(8);
                SvgManager.bkl().a(this.aiv, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.aiw.setText(R.string.forum_square_title);
                this.aix.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            ap.setViewTextColor(this.aiw, R.color.cp_cont_b);
            ap.setViewTextColor(this.aix, R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.ais = z;
    }
}
