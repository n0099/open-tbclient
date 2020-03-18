package com.baidu.swan.bdprivate.address.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends RecyclerView.Adapter<C0314a> {
    private List<com.baidu.swan.bdprivate.address.c.b> cbT = new ArrayList();
    private b cbU;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface b {
        void b(com.baidu.swan.bdprivate.address.c.b bVar, String str);

        void hq(int i);

        void onItemClick(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.cbU = bVar;
    }

    public void ac(List<com.baidu.swan.bdprivate.address.c.b> list) {
        this.cbT = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cbT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0314a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.f.delivery_choose_item_layout, viewGroup, false);
        a(new C0314a(inflate));
        return new C0314a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0314a c0314a, final int i) {
        final com.baidu.swan.bdprivate.address.c.b bVar = this.cbT.get(i);
        c0314a.cbW.setText(bVar.userName);
        c0314a.cbX.setText(bVar.ccy);
        c0314a.cbY.setText(bVar.aiu());
        c0314a.cbZ.setVisibility(bVar.ccE ? 0 : 8);
        c0314a.cca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cbU != null) {
                    a.this.cbU.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0314a.cca.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.address.a.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(0.3f);
                    return false;
                } else if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
        });
        c0314a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cbU != null) {
                    a.this.cbU.onItemClick(i);
                }
            }
        });
        c0314a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cbU != null) {
                    a.this.cbU.hq(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0314a c0314a) {
        if (com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(b.C0318b.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(b.C0318b.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(b.C0318b.delivery_txt_color_3);
            c0314a.itemView.setBackgroundResource(b.d.delivery_list_item_background_selector);
            c0314a.cbW.setTextColor(color);
            c0314a.cbX.setTextColor(color);
            c0314a.cbY.setTextColor(color2);
            c0314a.cbZ.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0314a.cbZ.setCompoundDrawables(drawable, null, null, null);
            c0314a.cca.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0314a.cca.setCompoundDrawables(drawable2, null, null, null);
            c0314a.ccb.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0314a extends RecyclerView.ViewHolder {
        private TextView cbW;
        private TextView cbX;
        private TextView cbY;
        private TextView cbZ;
        private TextView cca;
        private View ccb;
        private View ccc;

        public C0314a(View view) {
            super(view);
            this.ccc = view;
            this.cbW = (TextView) view.findViewById(b.e.addr_user_name);
            this.cbX = (TextView) view.findViewById(b.e.addr_tel_number);
            this.cbY = (TextView) view.findViewById(b.e.addr_detail_region);
            this.ccb = view.findViewById(b.e.addr_divided_line);
            this.cbZ = (TextView) view.findViewById(b.e.addr_current_used);
            this.cca = (TextView) view.findViewById(b.e.addr_edit);
        }
    }
}
