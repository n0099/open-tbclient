package com.baidu.swan.apps.af;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.a;
import com.baidu.swan.apps.ap.s;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes10.dex */
public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private com.baidu.swan.apps.af.a dmG;
    private Context mContext;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, com.baidu.swan.apps.af.a aVar) {
        this.mContext = context;
        this.dmG = aVar;
    }

    public void b(com.baidu.swan.apps.af.a aVar) {
        this.dmG = aVar;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swan_app_related_swan_head_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(a.g.swan_app_related_swan_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.dmG != null) {
            if (viewHolder instanceof b) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    ((b) viewHolder).a(this.mContext, this.dmG.dmC.get(i2), i);
                }
            } else if (viewHolder instanceof a) {
                ((a) viewHolder).af(this.mContext, this.dmG.dmD);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dmG == null) {
            return 0;
        }
        return this.dmG.dmC.size() + 1;
    }

    /* loaded from: classes10.dex */
    static class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }

        void a(final Context context, final a.C0371a c0371a, final int i) {
            if (c0371a != null) {
                ((RelativeLayout) this.itemView.findViewById(a.f.related_swan_app)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.af.c.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(c0371a.dmE)) {
                            SchemeRouter.invoke(context, c0371a.dmE);
                            c.P("aboutrelated", String.valueOf(i), "click");
                        }
                    }
                });
                final SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.itemView.findViewById(a.f.swan_app_icon);
                s.a(c0371a.iconUrl, new s.a() { // from class: com.baidu.swan.apps.af.c.b.2
                    @Override // com.baidu.swan.apps.ap.s.a
                    public void g(String str, Bitmap bitmap) {
                        if (bitmap == null) {
                            swanAppRoundedImageView.setImageDrawable(context.getResources().getDrawable(a.e.aiapps_default_grey_icon));
                        } else {
                            swanAppRoundedImageView.setImageBitmap(bitmap);
                        }
                    }
                });
                ((TextView) this.itemView.findViewById(a.f.swan_app_name)).setText(c0371a.appName);
            }
        }
    }

    /* loaded from: classes10.dex */
    static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        void af(final Context context, final String str) {
            TextView textView = (TextView) this.itemView.findViewById(a.f.more_relate_swan_app);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.af.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SchemeRouter.invoke(context, str);
                    c.P("aboutrelated", "more", "click");
                }
            });
        }
    }

    public static void P(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.u("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            b.a aHy = d.aHq().aHm().aHy();
            fVar.mFrom = h.ky(d.aHq().afE());
            fVar.mAppId = aHy.getAppId();
            fVar.mSource = aHy.ayD();
            fVar.ch(h.td(aHy.ayF()));
            fVar.tm(aHy.ayJ().getString("ubc"));
            com.baidu.swan.apps.statistic.d.b(fVar);
        }
    }
}
