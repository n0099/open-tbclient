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
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<C0302a> {
    private List<com.baidu.swan.bdprivate.address.c.b> bXq = new ArrayList();
    private b bXr;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface b {
        void b(com.baidu.swan.bdprivate.address.c.b bVar, String str);

        void gZ(int i);

        void onItemClick(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.bXr = bVar;
    }

    public void ad(List<com.baidu.swan.bdprivate.address.c.b> list) {
        this.bXq = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bXq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0302a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.f.delivery_choose_item_layout, viewGroup, false);
        a(new C0302a(inflate));
        return new C0302a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0302a c0302a, final int i) {
        final com.baidu.swan.bdprivate.address.c.b bVar = this.bXq.get(i);
        c0302a.bXt.setText(bVar.userName);
        c0302a.bXu.setText(bVar.bXU);
        c0302a.bXv.setText(bVar.afI());
        c0302a.bXw.setVisibility(bVar.bYa ? 0 : 8);
        c0302a.bXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bXr != null) {
                    a.this.bXr.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0302a.bXx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.address.a.a.2
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
        c0302a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bXr != null) {
                    a.this.bXr.onItemClick(i);
                }
            }
        });
        c0302a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.bXr != null) {
                    a.this.bXr.gZ(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0302a c0302a) {
        if (com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(b.C0306b.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(b.C0306b.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(b.C0306b.delivery_txt_color_3);
            c0302a.itemView.setBackgroundResource(b.d.delivery_list_item_background_selector);
            c0302a.bXt.setTextColor(color);
            c0302a.bXu.setTextColor(color);
            c0302a.bXv.setTextColor(color2);
            c0302a.bXw.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0302a.bXw.setCompoundDrawables(drawable, null, null, null);
            c0302a.bXx.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0302a.bXx.setCompoundDrawables(drawable2, null, null, null);
            c0302a.bXy.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0302a extends RecyclerView.ViewHolder {
        private TextView bXt;
        private TextView bXu;
        private TextView bXv;
        private TextView bXw;
        private TextView bXx;
        private View bXy;
        private View bXz;

        public C0302a(View view) {
            super(view);
            this.bXz = view;
            this.bXt = (TextView) view.findViewById(b.e.addr_user_name);
            this.bXu = (TextView) view.findViewById(b.e.addr_tel_number);
            this.bXv = (TextView) view.findViewById(b.e.addr_detail_region);
            this.bXy = view.findViewById(b.e.addr_divided_line);
            this.bXw = (TextView) view.findViewById(b.e.addr_current_used);
            this.bXx = (TextView) view.findViewById(b.e.addr_edit);
        }
    }
}
