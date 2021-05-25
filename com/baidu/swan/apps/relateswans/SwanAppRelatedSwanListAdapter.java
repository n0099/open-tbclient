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
import d.a.l0.a.a2.d;
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.g;
import d.a.l0.a.j2.k;
import d.a.l0.a.v2.t;
import d.a.l0.a.y1.a;
/* loaded from: classes3.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f11041a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.y1.a f11042b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0156a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f11043e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f11044f;

            public View$OnClickListenerC0156a(a aVar, Context context, String str) {
                this.f11043e = context;
                this.f11044f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchemeRouter.invoke(this.f11043e, this.f11044f);
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
            textView.setOnClickListener(new View$OnClickListenerC0156a(this, context, str));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0921a f11045e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f11046f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f11047g;

            public a(b bVar, a.C0921a c0921a, Context context, int i2) {
                this.f11045e = c0921a;
                this.f11046f = context;
                this.f11047g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(this.f11045e.f45903c)) {
                    return;
                }
                SchemeRouter.invoke(this.f11046f, this.f11045e.f45903c);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", String.valueOf(this.f11047g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0157b implements t.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f11048a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f11049b;

            public C0157b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.f11048a = swanAppRoundedImageView;
                this.f11049b = context;
            }

            @Override // d.a.l0.a.v2.t.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.f11048a.setImageDrawable(this.f11049b.getResources().getDrawable(e.aiapps_default_grey_icon));
                } else {
                    this.f11048a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view) {
            super(view);
        }

        public void a(Context context, a.C0921a c0921a, int i2) {
            if (c0921a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0921a, context, i2));
            t.e(c0921a.f45901a, new C0157b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0921a.f45902b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43189e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f43191g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f43186b = str3;
        }
        b.a L = d.g().r().L();
        fVar.f43185a = k.m(d.g().l());
        fVar.f43190f = L.H();
        fVar.f43187c = L.T();
        fVar.b(k.k(L.W()));
        fVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.a.l0.a.j2.d.b(fVar);
    }

    public void d(d.a.l0.a.y1.a aVar) {
        this.f11042b = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        d.a.l0.a.y1.a aVar = this.f11042b;
        if (aVar == null) {
            return 0;
        }
        return aVar.f45899a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.l0.a.y1.a aVar = this.f11042b;
        if (aVar == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f11041a, aVar.f45900b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f11041a, aVar.f45899a.get(i3), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_item, viewGroup, false));
    }

    public SwanAppRelatedSwanListAdapter(Context context, d.a.l0.a.y1.a aVar) {
        this.f11041a = context;
        this.f11042b = aVar;
    }
}
