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
import com.baidu.tieba.dd3;
import com.baidu.tieba.hj3;
import com.baidu.tieba.hr2;
import com.baidu.tieba.j63;
import com.baidu.tieba.nd3;
import com.baidu.tieba.r43;
import com.baidu.tieba.tc3;
/* loaded from: classes4.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context a;
    public r43 b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0205a implements View.OnClickListener {
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;

            public View$OnClickListenerC0205a(a aVar, Context context, String str) {
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
            TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f091874);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View$OnClickListenerC0205a(this, context, str));
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ r43.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, r43.a aVar, Context context, int i) {
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
        public class C0206b implements hj3.b {
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0206b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.baidu.tieba.hj3.b
            public void a(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08015f));
                } else {
                    this.a.setImageBitmap(bitmap);
                }
            }
        }

        public b(View view2) {
            super(view2);
        }

        public void a(Context context, r43.a aVar, int i) {
            if (aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091f95)).setOnClickListener(new a(this, aVar, context, i));
            hj3.e(aVar.a, new C0206b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f092419), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f09241b)).setText(aVar.b);
        }
    }

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public void n(r43 r43Var) {
        this.b = r43Var;
        notifyDataSetChanged();
    }

    public SwanAppRelatedSwanListAdapter(Context context, r43 r43Var) {
        this.a = context;
        this.b = r43Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        r43 r43Var = this.b;
        if (r43Var == null) {
            return;
        }
        if (viewHolder instanceof b) {
            int i2 = i - 1;
            if (i2 < 0) {
                return;
            }
            ((b) viewHolder).a(this.a, r43Var.a.get(i2), i);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).a(this.a, r43Var.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0956, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0957, viewGroup, false));
    }

    public static void l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nd3 nd3Var = new nd3();
        nd3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            nd3Var.a("page", str2);
            nd3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            nd3Var.b = str3;
        }
        hr2.a X = j63.K().q().X();
        nd3Var.a = dd3.n(j63.K().k());
        nd3Var.f = X.I();
        nd3Var.c = X.U();
        nd3Var.b(dd3.k(X.X()));
        nd3Var.d(X.t0().getString("ubc"));
        tc3.b(nd3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        r43 r43Var = this.b;
        if (r43Var == null) {
            return 0;
        }
        return r43Var.a.size() + 1;
    }
}
