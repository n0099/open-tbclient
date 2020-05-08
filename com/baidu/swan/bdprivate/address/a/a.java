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
public class a extends RecyclerView.Adapter<C0365a> {
    private List<com.baidu.swan.bdprivate.address.c.b> cBa = new ArrayList();
    private b cBb;
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
        this.cBb = bVar;
    }

    public void ak(List<com.baidu.swan.bdprivate.address.c.b> list) {
        this.cBa = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cBa.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0365a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.f.delivery_choose_item_layout, viewGroup, false);
        a(new C0365a(inflate));
        return new C0365a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0365a c0365a, final int i) {
        final com.baidu.swan.bdprivate.address.c.b bVar = this.cBa.get(i);
        c0365a.cBd.setText(bVar.userName);
        c0365a.cBe.setText(bVar.cBE);
        c0365a.cBf.setText(bVar.aqB());
        c0365a.cBg.setVisibility(bVar.cBK ? 0 : 8);
        c0365a.cBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cBb != null) {
                    a.this.cBb.b(bVar, IMTrack.DbBuilder.ACTION_UPDATE);
                }
            }
        });
        c0365a.cBh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.address.a.a.2
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
        c0365a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cBb != null) {
                    a.this.cBb.onItemClick(i);
                }
            }
        });
        c0365a.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.address.a.a.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.cBb != null) {
                    a.this.cBb.hx(i);
                    return false;
                }
                return false;
            }
        });
    }

    public void a(C0365a c0365a) {
        if (com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
            int color = AppRuntime.getAppContext().getResources().getColor(b.C0369b.delivery_txt_color_1);
            int color2 = AppRuntime.getAppContext().getResources().getColor(b.C0369b.delivery_txt_color_2);
            int color3 = AppRuntime.getAppContext().getResources().getColor(b.C0369b.delivery_txt_color_3);
            c0365a.itemView.setBackgroundResource(b.d.delivery_list_item_background_selector);
            c0365a.cBd.setTextColor(color);
            c0365a.cBe.setTextColor(color);
            c0365a.cBf.setTextColor(color2);
            c0365a.cBg.setTextColor(color);
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_default_used);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c0365a.cBg.setCompoundDrawables(drawable, null, null, null);
            c0365a.cBh.setTextColor(color);
            Drawable drawable2 = AppRuntime.getAppContext().getResources().getDrawable(b.d.delivery_edit);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            c0365a.cBh.setCompoundDrawables(drawable2, null, null, null);
            c0365a.cBi.setBackgroundColor(color3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.address.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0365a extends RecyclerView.ViewHolder {
        private TextView cBd;
        private TextView cBe;
        private TextView cBf;
        private TextView cBg;
        private TextView cBh;
        private View cBi;
        private View cBj;

        public C0365a(View view) {
            super(view);
            this.cBj = view;
            this.cBd = (TextView) view.findViewById(b.e.addr_user_name);
            this.cBe = (TextView) view.findViewById(b.e.addr_tel_number);
            this.cBf = (TextView) view.findViewById(b.e.addr_detail_region);
            this.cBi = view.findViewById(b.e.addr_divided_line);
            this.cBg = (TextView) view.findViewById(b.e.addr_current_used);
            this.cBh = (TextView) view.findViewById(b.e.addr_edit);
        }
    }
}
