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
import d.a.i0.a.a2.d;
import d.a.i0.a.e;
import d.a.i0.a.f;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.g;
import d.a.i0.a.j2.k;
import d.a.i0.a.v2.t;
import d.a.i0.a.y1.a;
/* loaded from: classes3.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f11140a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.y1.a f11141b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0155a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f11142e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f11143f;

            public View$OnClickListenerC0155a(a aVar, Context context, String str) {
                this.f11142e = context;
                this.f11143f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchemeRouter.invoke(this.f11142e, this.f11143f);
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
            textView.setOnClickListener(new View$OnClickListenerC0155a(this, context, str));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0910a f11144e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f11145f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f11146g;

            public a(b bVar, a.C0910a c0910a, Context context, int i2) {
                this.f11144e = c0910a;
                this.f11145f = context;
                this.f11146g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(this.f11144e.f45727c)) {
                    return;
                }
                SchemeRouter.invoke(this.f11145f, this.f11144e.f45727c);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", String.valueOf(this.f11146g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0156b implements t.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f11147a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f11148b;

            public C0156b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.f11147a = swanAppRoundedImageView;
                this.f11148b = context;
            }

            @Override // d.a.i0.a.v2.t.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.f11147a.setImageDrawable(this.f11148b.getResources().getDrawable(e.aiapps_default_grey_icon));
                } else {
                    this.f11147a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view) {
            super(view);
        }

        public void a(Context context, a.C0910a c0910a, int i2) {
            if (c0910a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0910a, context, i2));
            t.e(c0910a.f45725a, new C0156b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0910a.f45726b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
        fVar.f43015e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f43017g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f43012b = str3;
        }
        b.a L = d.g().r().L();
        fVar.f43011a = k.m(d.g().l());
        fVar.f43016f = L.H();
        fVar.f43013c = L.T();
        fVar.b(k.k(L.W()));
        fVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.a.i0.a.j2.d.b(fVar);
    }

    public void d(d.a.i0.a.y1.a aVar) {
        this.f11141b = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        d.a.i0.a.y1.a aVar = this.f11141b;
        if (aVar == null) {
            return 0;
        }
        return aVar.f45723a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.i0.a.y1.a aVar = this.f11141b;
        if (aVar == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f11140a, aVar.f45724b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f11140a, aVar.f45723a.get(i3), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_item, viewGroup, false));
    }

    public SwanAppRelatedSwanListAdapter(Context context, d.a.i0.a.y1.a aVar) {
        this.f11140a = context;
        this.f11141b = aVar;
    }
}
