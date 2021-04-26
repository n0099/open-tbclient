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
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.s;
import d.a.h0.a.p1.a;
import d.a.h0.a.r1.d;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
/* loaded from: classes3.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f11923a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.p1.a f11924b;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0170a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f11925e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f11926f;

            public View$OnClickListenerC0170a(a aVar, Context context, String str) {
                this.f11925e = context;
                this.f11926f = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchemeRouter.invoke(this.f11925e, this.f11926f);
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
            textView.setOnClickListener(new View$OnClickListenerC0170a(this, context, str));
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0727a f11927e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f11928f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f11929g;

            public a(b bVar, a.C0727a c0727a, Context context, int i2) {
                this.f11927e = c0727a;
                this.f11928f = context;
                this.f11929g = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(this.f11927e.f43533c)) {
                    return;
                }
                SchemeRouter.invoke(this.f11928f, this.f11927e.f43533c);
                SwanAppRelatedSwanListAdapter.c("aboutrelated", String.valueOf(this.f11929g), PrefetchEvent.STATE_CLICK);
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0171b implements s.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppRoundedImageView f11930a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f11931b;

            public C0171b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.f11930a = swanAppRoundedImageView;
                this.f11931b = context;
            }

            @Override // d.a.h0.a.i2.s.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.f11930a.setImageDrawable(this.f11931b.getResources().getDrawable(e.aiapps_default_grey_icon));
                } else {
                    this.f11930a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view) {
            super(view);
        }

        public void a(Context context, a.C0727a c0727a, int i2) {
            if (c0727a == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(f.related_swan_app)).setOnClickListener(new a(this, c0727a, context, i2));
            s.e(c0727a.f43531a, new C0171b(this, (SwanAppRoundedImageView) this.itemView.findViewById(f.swan_app_icon), context));
            ((TextView) this.itemView.findViewById(f.swan_app_name)).setText(c0727a.f43532b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45414d = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f45416f = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f45412b = str3;
        }
        b.a J = d.e().p().J();
        fVar.f45411a = h.n(d.e().j());
        fVar.f45415e = J.G();
        fVar.f45413c = J.S();
        fVar.b(h.l(J.V()));
        fVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.a.h0.a.z1.d.a(fVar);
    }

    public void d(d.a.h0.a.p1.a aVar) {
        this.f11924b = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        d.a.h0.a.p1.a aVar = this.f11924b;
        if (aVar == null) {
            return 0;
        }
        return aVar.f43529a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return i2 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        d.a.h0.a.p1.a aVar = this.f11924b;
        if (aVar == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.f11923a, aVar.f43530b);
                return;
            }
            return;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return;
        }
        ((b) viewHolder).a(this.f11923a, aVar.f43529a.get(i3), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(g.swan_app_related_swan_item, viewGroup, false));
    }

    public SwanAppRelatedSwanListAdapter(Context context, d.a.h0.a.p1.a aVar) {
        this.f11923a = context;
        this.f11924b = aVar;
    }
}
