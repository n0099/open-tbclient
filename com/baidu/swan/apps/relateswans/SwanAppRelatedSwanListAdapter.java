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
import com.baidu.tieba.ai3;
import com.baidu.tieba.eo3;
import com.baidu.tieba.ew2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.ki3;
import com.baidu.tieba.o93;
import com.baidu.tieba.qh3;
/* loaded from: classes4.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public o93 b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0202a implements View.OnClickListener {
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;

            public View$OnClickListenerC0202a(a aVar, Context context, String str) {
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

        public void a(Context context, String str) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0917b7);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View$OnClickListenerC0202a(this, context, str));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ o93.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, o93.a aVar, Context context, int i) {
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
        public class C0203b implements eo3.b {
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0203b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.baidu.tieba.eo3.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08015a));
                } else {
                    this.a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view2) {
            super(view2);
        }

        public void a(Context context, o93.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091ee8)).setOnClickListener(new a(this, aVar, context, i));
            eo3.e(aVar.a, new C0203b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f092369), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f09236b)).setText(aVar.b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public void m(o93 o93Var) {
        this.b = o93Var;
        notifyDataSetChanged();
    }

    public SwanAppRelatedSwanListAdapter(Context context, o93 o93Var) {
        this.a = context;
        this.b = o93Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        o93 o93Var = this.b;
        if (o93Var == null) {
            return;
        }
        if (viewHolder instanceof b) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            ((b) viewHolder).a(this.a, o93Var.a.get(i2), i);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(this.a, o93Var.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0934, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0935, viewGroup, false));
    }

    public static void l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ki3 ki3Var = new ki3();
        ki3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            ki3Var.a("page", str2);
            ki3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            ki3Var.b = str3;
        }
        ew2.a W = gb3.K().q().W();
        ki3Var.a = ai3.n(gb3.K().k());
        ki3Var.f = W.H();
        ki3Var.c = W.T();
        ki3Var.b(ai3.k(W.W()));
        ki3Var.d(W.s0().getString("ubc"));
        qh3.b(ki3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        o93 o93Var = this.b;
        if (o93Var == null) {
            return 0;
        }
        return o93Var.a.size() + 1;
    }
}
