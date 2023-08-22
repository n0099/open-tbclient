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
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ao3;
import com.baidu.tieba.aw2;
import com.baidu.tieba.cb3;
import com.baidu.tieba.gi3;
import com.baidu.tieba.k93;
import com.baidu.tieba.mh3;
import com.baidu.tieba.wh3;
/* loaded from: classes4.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public k93 b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0213a implements View.OnClickListener {
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;

            public View$OnClickListenerC0213a(a aVar, Context context, String str) {
                this.a = context;
                this.b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SchemeRouter.invoke(this.a, this.b);
                SwanAppRelatedSwanListAdapter.l("aboutrelated", "more", "click");
            }
        }

        public a(View view2) {
            super(view2);
        }

        public void b(Context context, String str) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0917ae);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View$OnClickListenerC0213a(this, context, str));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ k93.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, k93.a aVar, Context context, int i) {
                this.a = aVar;
                this.b = context;
                this.c = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TextUtils.isEmpty(this.a.c)) {
                    return;
                }
                SchemeRouter.invoke(this.b, this.a.c);
                SwanAppRelatedSwanListAdapter.l("aboutrelated", String.valueOf(this.c), "click");
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0214b implements ao3.b {
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0214b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.baidu.tieba.ao3.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080159));
                } else {
                    this.a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view2) {
            super(view2);
        }

        public void b(Context context, k93.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091ebf)).setOnClickListener(new a(this, aVar, context, i));
            ao3.e(aVar.a, new C0214b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f092329), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f09232b)).setText(aVar.b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public void m(k93 k93Var) {
        this.b = k93Var;
        notifyDataSetChanged();
    }

    public SwanAppRelatedSwanListAdapter(Context context, k93 k93Var) {
        this.a = context;
        this.b = k93Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        k93 k93Var = this.b;
        if (k93Var == null) {
            return;
        }
        if (viewHolder instanceof b) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            ((b) viewHolder).b(this.a, k93Var.a.get(i2), i);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).b(this.a, k93Var.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d091f, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0920, viewGroup, false));
    }

    public static void l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gi3 gi3Var = new gi3();
        gi3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            gi3Var.a("page", str2);
            gi3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            gi3Var.b = str3;
        }
        aw2.a W = cb3.K().q().W();
        gi3Var.a = wh3.n(cb3.K().k());
        gi3Var.f = W.H();
        gi3Var.c = W.T();
        gi3Var.b(wh3.k(W.W()));
        gi3Var.d(W.s0().getString("ubc"));
        mh3.b(gi3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        k93 k93Var = this.b;
        if (k93Var == null) {
            return 0;
        }
        return k93Var.a.size() + 1;
    }
}
