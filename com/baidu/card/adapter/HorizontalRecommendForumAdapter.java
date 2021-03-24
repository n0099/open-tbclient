package com.baidu.card.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.m.f;
import d.b.h0.r.q.n;
import d.b.h0.r.q.n1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4355a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.h0.g0.b.a> f4356b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f4357c;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4358a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4359b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4360c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4361d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4362e;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0065a implements View.OnClickListener {
            public View$OnClickListenerC0065a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4357c != null) {
                    int adapterPosition = a.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4357c.a(view, null, adapterPosition, adapterPosition);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4358a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4359b = (BarImageView) this.f4358a.findViewById(R.id.forum_icon);
            this.f4360c = (ImageView) this.f4358a.findViewById(R.id.square_icon);
            this.f4361d = (TextView) this.f4358a.findViewById(R.id.forum_name);
            this.f4362e = (TextView) this.f4358a.findViewById(R.id.desc);
            this.f4358a.setOnClickListener(new View$OnClickListenerC0065a(HorizontalRecommendForumAdapter.this));
        }

        public void a(n nVar) {
            if (nVar == null) {
                return;
            }
            this.f4360c.setVisibility(0);
            this.f4359b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4360c, R.drawable.ic_icon_pure_square28, null);
            this.f4361d.setText(R.string.forum_square_title);
            this.f4362e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            SkinManager.setViewTextColor(this.f4361d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4362e, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4365a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4366b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4367c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4368d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4369e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f4370f;

        /* renamed from: g  reason: collision with root package name */
        public String f4371g;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4357c != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4357c.a(view, b.this.f4370f, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f4365a = view;
            this.f4371g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4366b = (BarImageView) this.f4365a.findViewById(R.id.forum_icon);
            this.f4367c = (ImageView) this.f4365a.findViewById(R.id.square_icon);
            this.f4368d = (TextView) this.f4365a.findViewById(R.id.forum_name);
            this.f4369e = (TextView) this.f4365a.findViewById(R.id.desc);
            this.f4365a.setOnClickListener(new a(HorizontalRecommendForumAdapter.this));
        }

        public void b(n1 n1Var) {
            if (n1Var == null) {
                return;
            }
            this.f4370f = n1Var;
            this.f4366b.setShowOval(true);
            this.f4366b.setShowOuterBorder(false);
            this.f4366b.setShowInnerBorder(true);
            this.f4366b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4366b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4367c.setVisibility(8);
            this.f4366b.setVisibility(0);
            this.f4366b.W(n1Var.B(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.D()) <= 10) {
                this.f4368d.setText(n1Var.D());
            } else {
                this.f4368d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.D(), 8, StringHelper.STRING_MORE));
            }
            this.f4369e.setText(this.f4371g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
            c();
        }

        public void c() {
            SkinManager.setViewTextColor(this.f4368d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4369e, R.color.CAM_X0109);
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.f4355a = tbPageContext;
    }

    public void d(ArrayList<? extends d.b.h0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f4356b.clear();
        this.f4356b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void e(boolean z) {
    }

    public void f(f<n1> fVar) {
        this.f4357c = fVar;
    }

    public void g(String str) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4356b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f4356b.get(i) instanceof n1) {
            return 1;
        }
        return this.f4356b.get(i) instanceof n ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4356b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.h0.g0.b.a aVar = this.f4356b.get(i);
        if ((viewHolder instanceof a) && (aVar instanceof n)) {
            ((a) viewHolder).a((n) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f4357c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.f4355a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        if (i == 2) {
            return new a(inflate);
        }
        return new b(inflate);
    }
}
