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
import com.baidu.tieba.ca3;
import com.baidu.tieba.ei3;
import com.baidu.tieba.oi3;
import com.baidu.tieba.so3;
import com.baidu.tieba.sw2;
import com.baidu.tieba.ub3;
import com.baidu.tieba.yi3;
/* loaded from: classes4.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public ca3 b;

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
            TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f091783);
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
            public final /* synthetic */ ca3.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, ca3.a aVar, Context context, int i) {
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
        public class C0214b implements so3.b {
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0214b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.baidu.tieba.so3.b
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

        public void b(Context context, ca3.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091e7f)).setOnClickListener(new a(this, aVar, context, i));
            so3.e(aVar.a, new C0214b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0922dd), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0922df)).setText(aVar.b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public void m(ca3 ca3Var) {
        this.b = ca3Var;
        notifyDataSetChanged();
    }

    public SwanAppRelatedSwanListAdapter(Context context, ca3 ca3Var) {
        this.a = context;
        this.b = ca3Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ca3 ca3Var = this.b;
        if (ca3Var == null) {
            return;
        }
        if (viewHolder instanceof b) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            ((b) viewHolder).b(this.a, ca3Var.a.get(i2), i);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).b(this.a, ca3Var.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d090d, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d090e, viewGroup, false));
    }

    public static void l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        yi3 yi3Var = new yi3();
        yi3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            yi3Var.a("page", str2);
            yi3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            yi3Var.b = str3;
        }
        sw2.a W = ub3.K().q().W();
        yi3Var.a = oi3.n(ub3.K().k());
        yi3Var.f = W.H();
        yi3Var.c = W.T();
        yi3Var.b(oi3.k(W.W()));
        yi3Var.d(W.s0().getString("ubc"));
        ei3.b(yi3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ca3 ca3Var = this.b;
        if (ca3Var == null) {
            return 0;
        }
        return ca3Var.a.size() + 1;
    }
}
