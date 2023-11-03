package com.baidu.swan.bdprivate.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.tieba.R;
import com.baidu.tieba.q53;
import com.baidu.tieba.rm1;
/* loaded from: classes4.dex */
public class BdContextMenuView extends FrameLayout implements q53.g {
    public b a;
    public Context b;
    public ListView c;

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i);
    }

    public void setLayoutInCenter(boolean z) {
    }

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            BdContextMenuView.this.a.a(i);
        }
    }

    static {
        boolean z = rm1.a;
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.b = context;
        b();
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        b();
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080155));
        ListView listView = new ListView(this.b);
        this.c = listView;
        listView.setCacheColorHint(0);
        this.c.setDivider(getResources().getDrawable(R.color.obfuscated_res_0x7f06040f));
        this.c.setDividerHeight(1);
        this.c.setSelector(new ColorDrawable(0));
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        this.c.setOnItemClickListener(new a());
    }
}
