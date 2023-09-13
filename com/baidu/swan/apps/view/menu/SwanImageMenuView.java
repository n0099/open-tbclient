package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.view.SwanAppRoundCornerListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ou2;
import com.baidu.tieba.ra3;
import com.baidu.tieba.sa3;
import com.baidu.tieba.ua3;
import com.baidu.tieba.uq3;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanImageMenuView extends FrameLayout implements ra3.g {
    public boolean a;
    public c b;
    public Context c;
    public SwanAppRoundCornerListView d;
    public uq3 e;
    public View f;
    public int g;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            SwanImageMenuView.this.b.b(i);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SwanImageMenuView.this.e != null) {
                SwanImageMenuView.this.e.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BaseAdapter {
        public List<sa3> a;
        public Context b;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public c(Context context, List<sa3> list) {
            this.a = list;
            this.b = context;
        }

        public final void c(@NonNull View view2, int i) {
            if (i == 0) {
                view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08145b));
            } else {
                view2.setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08145a));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public sa3 getItem(int i) {
            return this.a.get(i);
        }

        public void b(int i) {
            sa3 sa3Var = this.a.get(i);
            sa3.a d = sa3Var.d();
            if (d != null) {
                d.a(sa3Var);
            }
        }

        public void d(List<sa3> list) {
            this.a = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.a.size();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            View inflate;
            sa3 item = getItem(i);
            if (item instanceof ua3) {
                inflate = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d092b, null);
                String i2 = ((ua3) item).i();
                if (!TextUtils.isEmpty(i2)) {
                    ((SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f090ffc)).setImageURI(i2);
                }
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918cf)).setText(item.e());
            } else {
                inflate = View.inflate(this.b, R.layout.obfuscated_res_0x7f0d00d7, null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924c8);
                textView.setTextColor(this.b.getResources().getColor(R.color.obfuscated_res_0x7f060407));
                textView.setText(item.e());
            }
            c(inflate, i);
            return inflate;
        }
    }

    public SwanImageMenuView(Context context) {
        super(context);
        this.a = false;
        this.g = -1;
        this.c = context;
        c();
    }

    public void d(List<sa3> list) {
        if (this.a) {
            return;
        }
        c cVar = this.b;
        if (cVar == null) {
            c cVar2 = new c(this.c, list);
            this.b = cVar2;
            this.d.setAdapter((ListAdapter) cVar2);
        } else {
            cVar.d(list);
        }
        this.a = true;
    }

    public void setMenu(uq3 uq3Var) {
        this.e = uq3Var;
    }

    public SwanImageMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.g = -1;
        this.c = context;
        c();
    }

    public SwanImageMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.g = -1;
        this.c = context;
        c();
    }

    public final void c() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d092a, (ViewGroup) null);
        SwanAppRoundCornerListView swanAppRoundCornerListView = (SwanAppRoundCornerListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091551);
        this.d = swanAppRoundCornerListView;
        swanAppRoundCornerListView.setOnItemClickListener(new a());
        this.d.setSelector(new ColorDrawable(0));
        ((TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09192d)).setOnClickListener(new b());
        addView(linearLayout);
        if (ou2.M().a()) {
            View view2 = new View(this.c);
            this.f = view2;
            view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f08145c);
            this.f.setVisibility(8);
            addView(this.f);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = getMeasuredHeight();
        View view2 = this.f;
        if (view2 != null && this.g != measuredHeight) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, measuredHeight));
            this.f.setVisibility(0);
            this.g = measuredHeight;
        }
    }
}
