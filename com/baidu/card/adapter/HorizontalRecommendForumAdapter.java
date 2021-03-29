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
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4356a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.h0.g0.b.a> f4357b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f4358c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4359a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4360b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4361c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4362d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4363e;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0066a implements View.OnClickListener {
            public View$OnClickListenerC0066a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4358c != null) {
                    int adapterPosition = a.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4358c.a(view, null, adapterPosition, adapterPosition);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4359a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4360b = (BarImageView) this.f4359a.findViewById(R.id.forum_icon);
            this.f4361c = (ImageView) this.f4359a.findViewById(R.id.square_icon);
            this.f4362d = (TextView) this.f4359a.findViewById(R.id.forum_name);
            this.f4363e = (TextView) this.f4359a.findViewById(R.id.desc);
            this.f4359a.setOnClickListener(new View$OnClickListenerC0066a(HorizontalRecommendForumAdapter.this));
        }

        public void a(n nVar) {
            if (nVar == null) {
                return;
            }
            this.f4361c.setVisibility(0);
            this.f4360b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4361c, R.drawable.ic_icon_pure_square28, null);
            this.f4362d.setText(R.string.forum_square_title);
            this.f4363e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            SkinManager.setViewTextColor(this.f4362d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4363e, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4366a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4367b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4368c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4369d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4370e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f4371f;

        /* renamed from: g  reason: collision with root package name */
        public String f4372g;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4358c != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4358c.a(view, b.this.f4371f, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f4366a = view;
            this.f4372g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4367b = (BarImageView) this.f4366a.findViewById(R.id.forum_icon);
            this.f4368c = (ImageView) this.f4366a.findViewById(R.id.square_icon);
            this.f4369d = (TextView) this.f4366a.findViewById(R.id.forum_name);
            this.f4370e = (TextView) this.f4366a.findViewById(R.id.desc);
            this.f4366a.setOnClickListener(new a(HorizontalRecommendForumAdapter.this));
        }

        public void b(n1 n1Var) {
            if (n1Var == null) {
                return;
            }
            this.f4371f = n1Var;
            this.f4367b.setShowOval(true);
            this.f4367b.setShowOuterBorder(false);
            this.f4367b.setShowInnerBorder(true);
            this.f4367b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4367b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4368c.setVisibility(8);
            this.f4367b.setVisibility(0);
            this.f4367b.W(n1Var.B(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.D()) <= 10) {
                this.f4369d.setText(n1Var.D());
            } else {
                this.f4369d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.D(), 8, StringHelper.STRING_MORE));
            }
            this.f4370e.setText(this.f4372g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
            c();
        }

        public void c() {
            SkinManager.setViewTextColor(this.f4369d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4370e, R.color.CAM_X0109);
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i) {
        this.f4356a = tbPageContext;
    }

    public void d(ArrayList<? extends d.b.h0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f4357b.clear();
        this.f4357b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void e(boolean z) {
    }

    public void f(f<n1> fVar) {
        this.f4358c = fVar;
    }

    public void g(String str) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4357b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f4357b.get(i) instanceof n1) {
            return 1;
        }
        return this.f4357b.get(i) instanceof n ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f4357b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.h0.g0.b.a aVar = this.f4357b.get(i);
        if ((viewHolder instanceof a) && (aVar instanceof n)) {
            ((a) viewHolder).a((n) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f4358c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.f4356a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        if (i == 2) {
            return new a(inflate);
        }
        return new b(inflate);
    }
}
