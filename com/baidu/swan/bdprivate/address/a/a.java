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
public class a extends RecyclerView.Adapter<C0344a> {
    private List<com.baidu.swan.bdprivate.address.c.b> cAU = new ArrayList();
    private b cAV;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface b {
        void b(com.baidu.swan.bdprivate.address.c.b bVar, String str);

        void hx(int i);

        void onItemClick(int i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void setDeliveryChooseListener(b bVar) {
        this.cAV = bVar;
    }

    public void ak(List<com.baidu.swan.bdprivate.address.c.b> list) {
        this.cAU = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cAU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0344a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.f.delivery_choose_item_layout, viewGroup, false);
        a(new C0344a(inflate));
        return new C0344a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0344a c0344a, final int i) {
        final com.baidu.swan.bdprivate.address.c.b bVar = this.cAU.get(i);
        c0344a.cAX.setText(bVar.userName);
        c0344a.cAY.setText(bVar.cBy);
        c0344a.cAZ.setText(bVar.aqC());
        c0344a.cBa.setVisibility(bVar.cBE ? 0 : 8);
        c0344a.cBb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cAV != null) {
                    a.this.cAV.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0344a.cBb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.address.a.a.2
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
        c0344a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cAV != null) {
                    a.this.cAV.onItemClick(i);
                }
            }
        });
        c0344a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cAV != null) {
                    a.this.cAV.hx(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0344a c0344a) {
        if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(b.C0348b.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(b.C0348b.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(b.C0348b.delivery_txt_color_3);
            c0344a.itemView.setBackgroundResource(b.d.delivery_list_item_background_selector);
            c0344a.cAX.setTextColor(color);
            c0344a.cAY.setTextColor(color);
            c0344a.cAZ.setTextColor(color2);
            c0344a.cBa.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0344a.cBa.setCompoundDrawables(drawable, null, null, null);
            c0344a.cBb.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0344a.cBb.setCompoundDrawables(drawable2, null, null, null);
            c0344a.cBc.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0344a extends RecyclerView.ViewHolder {
        private TextView cAX;
        private TextView cAY;
        private TextView cAZ;
        private TextView cBa;
        private TextView cBb;
        private View cBc;
        private View cBd;

        public C0344a(View view) {
            super(view);
            this.cBd = view;
            this.cAX = (TextView) view.findViewById(b.e.addr_user_name);
            this.cAY = (TextView) view.findViewById(b.e.addr_tel_number);
            this.cAZ = (TextView) view.findViewById(b.e.addr_detail_region);
            this.cBc = view.findViewById(b.e.addr_divided_line);
            this.cBa = (TextView) view.findViewById(b.e.addr_current_used);
            this.cBb = (TextView) view.findViewById(b.e.addr_edit);
        }
    }
}
