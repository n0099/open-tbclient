package com.baidu.swan.apps.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.q53;
import com.baidu.tieba.r53;
import java.util.List;
/* loaded from: classes4.dex */
public class SwanContextMenuView extends FrameLayout implements q53.g {
    public final Context a;
    public boolean b;
    public ListView c;
    public b d;
    public boolean e;

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public final Context a;
        public List<r53> b;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* loaded from: classes4.dex */
        public class a {
            public ImageView a;
            public TextView b;

            public a(b bVar) {
            }
        }

        public b(Context context, List<r53> list) {
            this.b = list;
            this.a = context;
        }

        public void a(int i) {
            r53 r53Var = this.b.get(i);
            r53.a d = r53Var.d();
            if (d != null) {
                d.a(r53Var);
            }
        }

        public void c(List<r53> list) {
            this.b = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        public final void b(View view2, int i) {
            if (getCount() == 1) {
                view2.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081449));
            } else if (i == 0) {
                view2.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08144a));
            } else if (i == getCount() - 1) {
                view2.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081447));
            } else {
                view2.setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081448));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            a aVar;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0936, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09120b);
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09123b);
                b(view2, i);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            r53 r53Var = this.b.get(i);
            aVar.b.setText(r53Var.e());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            if (r53Var.b() != null) {
                aVar.a.setVisibility(0);
                aVar.a.setImageDrawable(r53Var.b());
                layoutParams.setMarginStart(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0707f6));
            } else {
                aVar.a.setVisibility(8);
                layoutParams.setMarginStart(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0707f5));
            }
            aVar.b.setLayoutParams(layoutParams);
            if (SwanContextMenuView.this.e) {
                ((LinearLayout) view2).setGravity(17);
                layoutParams.width = -2;
                if (r53Var.b() != null) {
                    layoutParams2.setMarginStart(0);
                    aVar.a.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.setMarginStart(0);
                    aVar.b.setLayoutParams(layoutParams);
                }
            }
            return view2;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            SwanContextMenuView.this.d.a(i);
        }
    }

    public SwanContextMenuView(Context context) {
        super(context);
        this.b = false;
        this.a = context;
        b();
    }

    public void c(List<r53> list) {
        if (!this.b) {
            b bVar = this.d;
            if (bVar == null) {
                b bVar2 = new b(this.a, list);
                this.d = bVar2;
                this.c.setAdapter((ListAdapter) bVar2);
            } else {
                bVar.c(list);
            }
            this.b = true;
        }
    }

    public void setLayoutInCenter(boolean z) {
        this.e = z;
    }

    public SwanContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.a = context;
        b();
    }

    public SwanContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.a = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081446));
        ListView listView = new ListView(this.a);
        this.c = listView;
        listView.setCacheColorHint(0);
        this.c.setDivider(getResources().getDrawable(R.color.obfuscated_res_0x7f060ae2));
        this.c.setDividerHeight(1);
        this.c.setSelector(new ColorDrawable(0));
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        this.c.setOnItemClickListener(new a());
    }
}
