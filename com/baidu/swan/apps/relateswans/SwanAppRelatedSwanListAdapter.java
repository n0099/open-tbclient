package com.baidu.swan.apps.relateswans;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.s;
import d.b.g0.a.p1.a;
import d.b.g0.a.r1.d;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
/* loaded from: classes3.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f12411a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.p1.a f12412b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0171a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f12413e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f12414f;

            public View$OnClickListenerC0171a(a aVar, Context context, String str) {
                this.f12413e = context;
                this.f12414f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchemeRouter.invoke(this.f12413e, this.f12414f);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", "more", PrefetchEvent.STATE_CLICK);
            }
        }

        public a(View view) {
            super(view);
        }

        public void a(Context context, String str) {
            TextView textView = (TextView) this.itemView.findViewById(f.more_relate_swan_app);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View$OnClickListenerC0171a(this, context, str));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0755a f12415e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f12416f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f12417g;

            public a(b bVar, a.C0755a c0755a, Context context, int i) {
                this.f12415e = c0755a;
                this.f12416f = context;
                this.f12417g = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(this.f12415e.f45464c)) {
                    return;
                }
                SchemeRouter.invoke(this.f12416f, this.f12415e.f45464c);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", String.valueOf(this.f12417g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0172b implements s.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f12418a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f12419b;

            public C0172b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.f12418a = swanAppRoundedImageView;
                this.f12419b = context;
            }

            @Override // d.b.g0.a.i2.s.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.f12418a.setImageDrawable(this.f12419b.getResources().getDrawable(e.aiapps_default_grey_icon));
                } else {
                    this.f12418a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view) {
            super(view);
        }

        public void a(Context context, a.C0755a c0755a, int i) {
            if (c0755a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0755a, context, i));
            s.e(c0755a.f45462a, new C0172b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0755a.f45463b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47253d = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f47255f = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f47251b = str3;
        }
        b.a J = d.e().s().J();
        fVar.f47250a = h.n(d.e().h());
        fVar.f47254e = J.G();
        fVar.f47252c = J.S();
        fVar.b(h.l(J.V()));
        fVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.b.g0.a.z1.d.a(fVar);
    }

    public void d(d.b.g0.a.p1.a aVar) {
        this.f12412b = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        d.b.g0.a.p1.a aVar = this.f12412b;
        if (aVar == null) {
            return 0;
        }
        return aVar.f45460a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        d.b.g0.a.p1.a aVar = this.f12412b;
        if (aVar == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f12411a, aVar.f45461b);
                return;
            }
            return;
        }
        int i2 = i - 1;
        if (i2 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f12411a, aVar.f45460a.get(i2), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_item, viewGroup, false));
    }

    public SwanAppRelatedSwanListAdapter(Context context, d.b.g0.a.p1.a aVar) {
        this.f12411a = context;
        this.f12412b = aVar;
    }
}
