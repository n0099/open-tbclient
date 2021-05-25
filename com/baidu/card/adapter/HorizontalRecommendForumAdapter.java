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
import d.a.m0.m.f;
import d.a.m0.r.q.n;
import d.a.m0.r.q.n1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HorizontalRecommendForumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f4325a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.m0.g0.b.a> f4326b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public f<n1> f4327c;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4328a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4329b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4330c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4331d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4332e;

        /* renamed from: com.baidu.card.adapter.HorizontalRecommendForumAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0065a implements View.OnClickListener {
            public View$OnClickListenerC0065a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4327c != null) {
                    int adapterPosition = a.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4327c.a(view, null, adapterPosition, adapterPosition);
                }
            }
        }

        public a(View view) {
            super(view);
            this.f4328a = view;
            TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4329b = (BarImageView) this.f4328a.findViewById(R.id.forum_icon);
            this.f4330c = (ImageView) this.f4328a.findViewById(R.id.square_icon);
            this.f4331d = (TextView) this.f4328a.findViewById(R.id.forum_name);
            this.f4332e = (TextView) this.f4328a.findViewById(R.id.desc);
            this.f4328a.setOnClickListener(new View$OnClickListenerC0065a(HorizontalRecommendForumAdapter.this));
        }

        public void a(n nVar) {
            if (nVar == null) {
                return;
            }
            this.f4330c.setVisibility(0);
            this.f4329b.setVisibility(8);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f4330c, R.drawable.ic_icon_pure_square28, null);
            this.f4331d.setText(R.string.forum_square_title);
            this.f4332e.setText(R.string.forum_square_desc_1);
            b();
        }

        public void b() {
            SkinManager.setViewTextColor(this.f4331d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4332e, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f4335a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f4336b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4337c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f4338d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f4339e;

        /* renamed from: f  reason: collision with root package name */
        public n1 f4340f;

        /* renamed from: g  reason: collision with root package name */
        public String f4341g;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a(HorizontalRecommendForumAdapter horizontalRecommendForumAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalRecommendForumAdapter.this.f4327c != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    HorizontalRecommendForumAdapter.this.f4327c.a(view, b.this.f4340f, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f4335a = view;
            this.f4341g = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.f4336b = (BarImageView) this.f4335a.findViewById(R.id.forum_icon);
            this.f4337c = (ImageView) this.f4335a.findViewById(R.id.square_icon);
            this.f4338d = (TextView) this.f4335a.findViewById(R.id.forum_name);
            this.f4339e = (TextView) this.f4335a.findViewById(R.id.desc);
            this.f4335a.setOnClickListener(new a(HorizontalRecommendForumAdapter.this));
        }

        public void b(n1 n1Var) {
            if (n1Var == null) {
                return;
            }
            this.f4340f = n1Var;
            this.f4336b.setShowOval(true);
            this.f4336b.setShowOuterBorder(false);
            this.f4336b.setShowInnerBorder(true);
            this.f4336b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f4336b.setStrokeColorResId(R.color.CAM_X0401);
            this.f4337c.setVisibility(8);
            this.f4336b.setVisibility(0);
            this.f4336b.V(n1Var.B(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(n1Var.D()) <= 10) {
                this.f4338d.setText(n1Var.D());
            } else {
                this.f4338d.setText(StringHelper.cutChineseAndEnglishWithSuffix(n1Var.D(), 8, StringHelper.STRING_MORE));
            }
            this.f4339e.setText(this.f4341g + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
            c();
        }

        public void c() {
            SkinManager.setViewTextColor(this.f4338d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f4339e, R.color.CAM_X0109);
        }
    }

    public HorizontalRecommendForumAdapter(TbPageContext<?> tbPageContext, int i2) {
        this.f4325a = tbPageContext;
    }

    public void d(ArrayList<? extends d.a.m0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f4326b.clear();
        this.f4326b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void e(boolean z) {
    }

    public void f(f<n1> fVar) {
        this.f4327c = fVar;
    }

    public void g(String str) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f4326b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f4326b.get(i2) instanceof n1) {
            return 1;
        }
        return this.f4326b.get(i2) instanceof n ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f4326b;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.m0.g0.b.a aVar = this.f4326b.get(i2);
        if ((viewHolder instanceof a) && (aVar instanceof n)) {
            ((a) viewHolder).a((n) aVar);
        } else if ((viewHolder instanceof b) && (aVar instanceof n1)) {
            n1 n1Var = (n1) aVar;
            ((b) viewHolder).b(n1Var);
            f<n1> fVar = this.f4327c;
            if (fVar != null) {
                fVar.c(viewHolder.itemView, n1Var, i2, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View inflate = this.f4325a.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        if (i2 == 2) {
            return new a(inflate);
        }
        return new b(inflate);
    }
}
