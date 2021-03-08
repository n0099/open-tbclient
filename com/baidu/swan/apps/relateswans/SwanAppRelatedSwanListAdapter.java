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
/* loaded from: classes8.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private com.baidu.swan.apps.relateswans.a dvW;
    private Context mContext;

    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
    }

    public SwanAppRelatedSwanListAdapter(Context context, com.baidu.swan.apps.relateswans.a aVar) {
        this.mContext = context;
        this.dvW = aVar;
    }

    public void b(com.baidu.swan.apps.relateswans.a aVar) {
        this.dvW = aVar;
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
        if (this.dvW != null) {
            if (viewHolder instanceof b) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    ((b) viewHolder).a(this.mContext, this.dvW.dvS.get(i2), i);
                }
            } else if (viewHolder instanceof a) {
                ((a) viewHolder).aj(this.mContext, this.dvW.dvT);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dvW == null) {
            return 0;
        }
        return this.dvW.dvS.size() + 1;
    }

    /* loaded from: classes8.dex */
    static class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }

        void a(final Context context, final a.C0453a c0453a, final int i) {
            if (c0453a != null) {
                ((RelativeLayout) this.itemView.findViewById(a.f.related_swan_app)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(c0453a.dvU)) {
                            SchemeRouter.invoke(context, c0453a.dvU);
                            SwanAppRelatedSwanListAdapter.V("aboutrelated", String.valueOf(i), "click");
                        }
                    }
                });
                final SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.itemView.findViewById(a.f.swan_app_icon);
                s.a(c0453a.iconUrl, new s.a() { // from class: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter.b.2
                    @Override // com.baidu.swan.apps.ao.s.a
                    public void f(String str, Bitmap bitmap) {
                        if (bitmap == null) {
                            swanAppRoundedImageView.setImageDrawable(context.getResources().getDrawable(a.e.aiapps_default_grey_icon));
                        } else {
                            swanAppRoundedImageView.setImageBitmap(bitmap);
                        }
                    }
                });
                ((TextView) this.itemView.findViewById(a.f.swan_app_name)).setText(c0453a.appName);
            }
        }
    }

    /* loaded from: classes8.dex */
    static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        void aj(final Context context, final String str) {
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
                fVar.s("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            b.a aIR = d.aIJ().aIF().aIR();
            fVar.mFrom = h.jv(d.aIJ().getFrameType());
            fVar.mAppId = aIR.getAppId();
            fVar.mSource = aIR.azd();
            fVar.ck(h.sR(aIR.azf()));
            fVar.ta(aIR.azj().getString("ubc"));
            com.baidu.swan.apps.statistic.d.b(fVar);
        }
    }
}
