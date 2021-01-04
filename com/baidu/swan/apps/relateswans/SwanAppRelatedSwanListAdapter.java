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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.s;
import com.baidu.swan.apps.relateswans.a;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes9.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private com.baidu.swan.apps.relateswans.a dwX;
    private Context mContext;

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public SwanAppRelatedSwanListAdapter(Context context, com.baidu.swan.apps.relateswans.a aVar) {
        this.mContext = context;
        this.dwX = aVar;
    }

    public void b(com.baidu.swan.apps.relateswans.a aVar) {
        this.dwX = aVar;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swan_app_related_swan_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.dwX != null) {
            if (viewHolder instanceof b) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    ((b) viewHolder).a(this.mContext, this.dwX.dwT.get(i2), i);
                }
            } else if (viewHolder instanceof a) {
                ((a) viewHolder).al(this.mContext, this.dwX.dwU);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dwX == null) {
            return 0;
        }
        return this.dwX.dwT.size() + 1;
    }

    /* loaded from: classes9.dex */
    static class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }

        void a(final Context context, final a.C0467a c0467a, final int i) {
            if (c0467a != null) {
                ((RelativeLayout) this.itemView.findViewById(a.f.related_swan_app)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(c0467a.dwV)) {
                            SchemeRouter.invoke(context, c0467a.dwV);
                            SwanAppRelatedSwanListAdapter.V("aboutrelated", String.valueOf(i), "click");
                        }
                    }
                });
                final SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.itemView.findViewById(a.f.swan_app_icon);
                s.a(c0467a.iconUrl, new s.a() { // from class: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter.b.2
                    @Override // com.baidu.swan.apps.ao.s.a
                    public void g(String str, Bitmap bitmap) {
                        if (bitmap == null) {
                            swanAppRoundedImageView.setImageDrawable(context.getResources().getDrawable(a.e.aiapps_default_grey_icon));
                        } else {
                            swanAppRoundedImageView.setImageBitmap(bitmap);
                        }
                    }
                });
                ((TextView) this.itemView.findViewById(a.f.swan_app_name)).setText(c0467a.appName);
            }
        }
    }

    /* loaded from: classes9.dex */
    static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        void al(final Context context, final String str) {
            TextView textView = (TextView) this.itemView.findViewById(a.f.more_relate_swan_app);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SchemeRouter.invoke(context, str);
                    SwanAppRelatedSwanListAdapter.V("aboutrelated", "more", "click");
                }
            });
        }
    }

    public static void V(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.t("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            b.a aMo = d.aMg().aMc().aMo();
            fVar.mFrom = h.kX(d.aMg().ajk());
            fVar.mAppId = aMo.getAppId();
            fVar.mSource = aMo.aCv();
            fVar.cl(h.tC(aMo.aCx()));
            fVar.tL(aMo.aCB().getString("ubc"));
            com.baidu.swan.apps.statistic.d.b(fVar);
        }
    }
}
