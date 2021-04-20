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
import d.b.c.e.p.l;
import d.b.h0.m.f;
import d.b.h0.r.q.n;
import d.b.h0.r.q.n1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4391a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.h0.g0.b.a> f4392b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f4393c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4394a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4395b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4396c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4397d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4398e;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0065a implements View.OnClickListener {
            public View$OnClickListenerC0065a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4393c != null) {
                    int adapterPosition = a.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4393c.a(view, null, adapterPosition, adapterPosition);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4394a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4395b = (BarImageView) this.f4394a.findViewById(R.id.forum_icon);
            this.f4396c = (ImageView) this.f4394a.findViewById(R.id.square_icon);
            this.f4397d = (TextView) this.f4394a.findViewById(R.id.forum_name);
            this.f4398e = (TextView) this.f4394a.findViewById(R.id.desc);
            this.f4394a.setOnClickListener(new View$OnClickListenerC0065a(HorizontalRecommendForumAdapter.this));
        }

        public void a(n nVar) {
            if (nVar == null) {
                return;
            }
            this.f4396c.setVisibility(0);
            this.f4395b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4396c, R.drawable.ic_icon_pure_square28, null);
            this.f4397d.setText(R.string.forum_square_title);
            this.f4398e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            SkinManager.setViewTextColor(this.f4397d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4398e, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4401a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4402b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4403c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4404d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4405e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f4406f;

        /* renamed from: g  reason: collision with root package name */
        public String f4407g;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4393c != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4393c.a(view, b.this.f4406f, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f4401a = view;
            this.f4407g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4402b = (BarImageView) this.f4401a.findViewById(R.id.forum_icon);
            this.f4403c = (ImageView) this.f4401a.findViewById(R.id.square_icon);
            this.f4404d = (TextView) this.f4401a.findViewById(R.id.forum_name);
            this.f4405e = (TextView) this.f4401a.findViewById(R.id.desc);
            this.f4401a.setOnClickListener(new a(HorizontalRecommendForumAdapter.this));
        }

        public void b(n1 n1Var) {
            if (n1Var == null) {
                return;
            }
            this.f4406f = n1Var;
            this.f4402b.setShowOval(true);
            this.f4402b.setShowOuterBorder(false);
            this.f4402b.setShowInnerBorder(true);
            this.f4402b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4402b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4403c.setVisibility(8);
            this.f4402b.setVisibility(0);
            this.f4402b.W(n1Var.B(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.D()) <= 10) {
                this.f4404d.setText(n1Var.D());
            } else {
                this.f4404d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.D(), 8, StringHelper.STRING_MORE));
            }
            this.f4405e.setText(this.f4407g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
            c();
        }

        public void c() {
            SkinManager.setViewTextColor(this.f4404d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4405e, R.color.CAM_X0109);
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.f4391a = tbPageContext;
    }

    public void d(ArrayList<? extends d.b.h0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f4392b.clear();
        this.f4392b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void e(boolean z) {
    }

    public void f(f<n1> fVar) {
        this.f4393c = fVar;
    }

    public void g(String str) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4392b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f4392b.get(i) instanceof n1) {
            return 1;
        }
        return this.f4392b.get(i) instanceof n ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4392b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.h0.g0.b.a aVar = this.f4392b.get(i);
        if ((viewHolder instanceof a) && (aVar instanceof n)) {
            ((a) viewHolder).a((n) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f4393c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.f4391a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        if (i == 2) {
            return new a(inflate);
        }
        return new b(inflate);
    }
}
