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
import com.baidu.tieba.ic3;
import com.baidu.tieba.mi3;
import com.baidu.tieba.mq2;
import com.baidu.tieba.o53;
import com.baidu.tieba.sc3;
import com.baidu.tieba.w33;
import com.baidu.tieba.yb3;
/* loaded from: classes4.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public w33 b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0204a implements View.OnClickListener {
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;

            public View$OnClickListenerC0204a(a aVar, Context context, String str) {
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
            TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0917bf);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View$OnClickListenerC0204a(this, context, str));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ w33.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, w33.a aVar, Context context, int i) {
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
        public class C0205b implements mi3.b {
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0205b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.baidu.tieba.mi3.b
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

        public void a(Context context, w33.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091ed5)).setOnClickListener(new a(this, aVar, context, i));
            mi3.e(aVar.a, new C0205b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f09233e), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f092340)).setText(aVar.b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public void m(w33 w33Var) {
        this.b = w33Var;
        notifyDataSetChanged();
    }

    public SwanAppRelatedSwanListAdapter(Context context, w33 w33Var) {
        this.a = context;
        this.b = w33Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        w33 w33Var = this.b;
        if (w33Var == null) {
            return;
        }
        if (viewHolder instanceof b) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            ((b) viewHolder).a(this.a, w33Var.a.get(i2), i);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(this.a, w33Var.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0923, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0924, viewGroup, false));
    }

    public static void l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sc3 sc3Var = new sc3();
        sc3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            sc3Var.a("page", str2);
            sc3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            sc3Var.b = str3;
        }
        mq2.a X = o53.K().q().X();
        sc3Var.a = ic3.n(o53.K().k());
        sc3Var.f = X.I();
        sc3Var.c = X.U();
        sc3Var.b(ic3.k(X.X()));
        sc3Var.d(X.t0().getString("ubc"));
        yb3.b(sc3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        w33 w33Var = this.b;
        if (w33Var == null) {
            return 0;
        }
        return w33Var.a.size() + 1;
    }
}
