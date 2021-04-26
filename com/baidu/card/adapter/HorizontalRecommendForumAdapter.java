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
import d.a.c.e.p.l;
import d.a.i0.m.f;
import d.a.i0.r.q.n;
import d.a.i0.r.q.n1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4471a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.i0.g0.b.a> f4472b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f4473c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4474a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4475b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4476c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4477d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4478e;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0065a implements View.OnClickListener {
            public View$OnClickListenerC0065a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4473c != null) {
                    int adapterPosition = a.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4473c.a(view, null, adapterPosition, adapterPosition);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4474a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4475b = (BarImageView) this.f4474a.findViewById(R.id.forum_icon);
            this.f4476c = (ImageView) this.f4474a.findViewById(R.id.square_icon);
            this.f4477d = (TextView) this.f4474a.findViewById(R.id.forum_name);
            this.f4478e = (TextView) this.f4474a.findViewById(R.id.desc);
            this.f4474a.setOnClickListener(new View$OnClickListenerC0065a(HorizontalRecommendForumAdapter.this));
        }

        public void a(n nVar) {
            if (nVar == null) {
                return;
            }
            this.f4476c.setVisibility(0);
            this.f4475b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4476c, R.drawable.ic_icon_pure_square28, null);
            this.f4477d.setText(R.string.forum_square_title);
            this.f4478e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            SkinManager.setViewTextColor(this.f4477d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4478e, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4481a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4482b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4483c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4484d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4485e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f4486f;

        /* renamed from: g  reason: collision with root package name */
        public String f4487g;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4473c != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4473c.a(view, b.this.f4486f, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f4481a = view;
            this.f4487g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4482b = (BarImageView) this.f4481a.findViewById(R.id.forum_icon);
            this.f4483c = (ImageView) this.f4481a.findViewById(R.id.square_icon);
            this.f4484d = (TextView) this.f4481a.findViewById(R.id.forum_name);
            this.f4485e = (TextView) this.f4481a.findViewById(R.id.desc);
            this.f4481a.setOnClickListener(new a(HorizontalRecommendForumAdapter.this));
        }

        public void b(n1 n1Var) {
            if (n1Var == null) {
                return;
            }
            this.f4486f = n1Var;
            this.f4482b.setShowOval(true);
            this.f4482b.setShowOuterBorder(false);
            this.f4482b.setShowInnerBorder(true);
            this.f4482b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4482b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4483c.setVisibility(8);
            this.f4482b.setVisibility(0);
            this.f4482b.V(n1Var.B(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.D()) <= 10) {
                this.f4484d.setText(n1Var.D());
            } else {
                this.f4484d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.D(), 8, StringHelper.STRING_MORE));
            }
            this.f4485e.setText(this.f4487g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
            c();
        }

        public void c() {
            SkinManager.setViewTextColor(this.f4484d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4485e, R.color.CAM_X0109);
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i2) {
        this.f4471a = tbPageContext;
    }

    public void d(ArrayList<? extends d.a.i0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f4472b.clear();
        this.f4472b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void e(boolean z) {
    }

    public void f(f<n1> fVar) {
        this.f4473c = fVar;
    }

    public void g(String str) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.i0.g0.b.a> arrayList = this.f4472b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f4472b.get(i2) instanceof n1) {
            return 1;
        }
        return this.f4472b.get(i2) instanceof n ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<d.a.i0.g0.b.a> arrayList = this.f4472b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.i0.g0.b.a aVar = this.f4472b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof n)) {
            ((a) viewHolder).a((n) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f4473c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View inflate = this.f4471a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        if (i2 == 2) {
            return new a(inflate);
        }
        return new b(inflate);
    }
}
