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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> agU = new ArrayList<>();
    private boolean agV;
    private f<bg> agW;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public void setOnItemCoverListener(f<bg> fVar) {
        this.agW = fVar;
    }

    public a(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.agU.clear();
            this.agU.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new C0099a(inflate) : new b(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.agU != null && this.agU.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.agU.get(i);
            if ((viewHolder instanceof C0099a) && (aVar instanceof l)) {
                ((C0099a) viewHolder).a((l) aVar);
            } else if ((viewHolder instanceof b) && (aVar instanceof bg)) {
                bg bgVar = (bg) aVar;
                ((b) viewHolder).a(bgVar);
                if (this.agW != null) {
                    this.agW.b(viewHolder.itemView, bgVar, i, i);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.agU.get(i) instanceof bg) {
            return 1;
        }
        if (this.agU.get(i) instanceof l) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.agU == null) {
            return 0;
        }
        return this.agU.size();
    }

    /* loaded from: classes8.dex */
    class b extends RecyclerView.ViewHolder {
        private BarImageView agX;
        private ImageView agY;
        private TextView agZ;
        private TextView aha;
        private bg ahe;
        private String attention;
        private View mRootView;

        public b(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.agX = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.agY = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.agZ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aha = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.agW != null) {
                        int adapterPosition = b.this.getAdapterPosition();
                        a.this.agW.a(view2, b.this.ahe, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(bg bgVar) {
            if (bgVar != null) {
                this.ahe = bgVar;
                this.agX.setShowOval(true);
                this.agX.setShowOuterBorder(false);
                this.agX.setShowInnerBorder(true);
                this.agX.setStrokeWith(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.agX.setStrokeColorResId(R.color.cp_border_a);
                this.agY.setVisibility(8);
                this.agX.setVisibility(0);
                this.agX.startLoad(bgVar.getAvatar(), 10, false);
                if (ar.getChineseAndEnglishLength(bgVar.getForumName()) <= 10) {
                    this.agZ.setText(bgVar.getForumName());
                } else {
                    this.agZ.setText(ar.cutChineseAndEnglishWithSuffix(bgVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aha.setText(this.attention + " " + ar.cp(bgVar.aRt()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            an.setViewTextColor(this.agZ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.aha, (int) R.color.cp_cont_d);
        }
    }

    /* renamed from: com.baidu.card.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    class C0099a extends RecyclerView.ViewHolder {
        private BarImageView agX;
        private ImageView agY;
        private TextView agZ;
        private TextView aha;
        private String attention;
        private View mRootView;

        public C0099a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.agX = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.agY = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.agZ = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aha = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.b.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.agW != null) {
                        int adapterPosition = C0099a.this.getAdapterPosition();
                        a.this.agW.a(view2, null, adapterPosition, adapterPosition);
                    }
                }
            });
        }

        public void a(l lVar) {
            if (lVar != null) {
                this.agY.setVisibility(0);
                this.agX.setVisibility(8);
                SvgManager.aWQ().a(this.agY, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.agZ.setText(R.string.forum_square_title);
                this.aha.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            an.setViewTextColor(this.agZ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.aha, (int) R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.agV = z;
    }
}
