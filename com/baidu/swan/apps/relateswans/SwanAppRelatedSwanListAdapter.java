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
/* loaded from: classes2.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f12412a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.p1.a f12413b;

    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0172a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f12414e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f12415f;

            public View$OnClickListenerC0172a(a aVar, Context context, String str) {
                this.f12414e = context;
                this.f12415f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchemeRouter.invoke(this.f12414e, this.f12415f);
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
            textView.setOnClickListener(new View$OnClickListenerC0172a(this, context, str));
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0756a f12416e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f12417f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f12418g;

            public a(b bVar, a.C0756a c0756a, Context context, int i) {
                this.f12416e = c0756a;
                this.f12417f = context;
                this.f12418g = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(this.f12416e.f45465c)) {
                    return;
                }
                SchemeRouter.invoke(this.f12417f, this.f12416e.f45465c);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", String.valueOf(this.f12418g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0173b implements s.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f12419a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f12420b;

            public C0173b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.f12419a = swanAppRoundedImageView;
                this.f12420b = context;
            }

            @Override // d.b.g0.a.i2.s.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.f12419a.setImageDrawable(this.f12420b.getResources().getDrawable(e.aiapps_default_grey_icon));
                } else {
                    this.f12419a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view) {
            super(view);
        }

        public void a(Context context, a.C0756a c0756a, int i) {
            if (c0756a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0756a, context, i));
            s.e(c0756a.f45463a, new C0173b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0756a.f45464b);
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
        fVar.f47254d = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f47256f = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f47252b = str3;
        }
        b.a J = d.e().s().J();
        fVar.f47251a = h.n(d.e().h());
        fVar.f47255e = J.G();
        fVar.f47253c = J.S();
        fVar.b(h.l(J.V()));
        fVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.b.g0.a.z1.d.a(fVar);
    }

    public void d(d.b.g0.a.p1.a aVar) {
        this.f12413b = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        d.b.g0.a.p1.a aVar = this.f12413b;
        if (aVar == null) {
            return 0;
        }
        return aVar.f45461a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        d.b.g0.a.p1.a aVar = this.f12413b;
        if (aVar == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f12412a, aVar.f45462b);
                return;
            }
            return;
        }
        int i2 = i - 1;
        if (i2 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f12412a, aVar.f45461a.get(i2), i);
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
        this.f12412a = context;
        this.f12413b = aVar;
    }
}
