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
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter<C0304a> {
    private List<com.baidu.swan.bdprivate.address.c.b> bXC = new ArrayList();
    private b bXD;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void b(com.baidu.swan.bdprivate.address.c.b bVar, String str);

        void gZ(int i);

        void onItemClick(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.bXD = bVar;
    }

    public void ac(List<com.baidu.swan.bdprivate.address.c.b> list) {
        this.bXC = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bXC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0304a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.f.delivery_choose_item_layout, viewGroup, false);
        a(new C0304a(inflate));
        return new C0304a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0304a c0304a, final int i) {
        final com.baidu.swan.bdprivate.address.c.b bVar = this.bXC.get(i);
        c0304a.bXF.setText(bVar.userName);
        c0304a.bXG.setText(bVar.bYg);
        c0304a.bXH.setText(bVar.agb());
        c0304a.bXI.setVisibility(bVar.bYm ? 0 : 8);
        c0304a.bXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bXD != null) {
                    a.this.bXD.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0304a.bXJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.address.a.a.2
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
        c0304a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bXD != null) {
                    a.this.bXD.onItemClick(i);
                }
            }
        });
        c0304a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.bXD != null) {
                    a.this.bXD.gZ(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0304a c0304a) {
        if (com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(b.C0308b.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(b.C0308b.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(b.C0308b.delivery_txt_color_3);
            c0304a.itemView.setBackgroundResource(b.d.delivery_list_item_background_selector);
            c0304a.bXF.setTextColor(color);
            c0304a.bXG.setTextColor(color);
            c0304a.bXH.setTextColor(color2);
            c0304a.bXI.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0304a.bXI.setCompoundDrawables(drawable, null, null, null);
            c0304a.bXJ.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0304a.bXJ.setCompoundDrawables(drawable2, null, null, null);
            c0304a.bXK.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0304a extends RecyclerView.ViewHolder {
        private TextView bXF;
        private TextView bXG;
        private TextView bXH;
        private TextView bXI;
        private TextView bXJ;
        private View bXK;
        private View bXL;

        public C0304a(View view) {
            super(view);
            this.bXL = view;
            this.bXF = (TextView) view.findViewById(b.e.addr_user_name);
            this.bXG = (TextView) view.findViewById(b.e.addr_tel_number);
            this.bXH = (TextView) view.findViewById(b.e.addr_detail_region);
            this.bXK = view.findViewById(b.e.addr_divided_line);
            this.bXI = (TextView) view.findViewById(b.e.addr_current_used);
            this.bXJ = (TextView) view.findViewById(b.e.addr_edit);
        }
    }
}
