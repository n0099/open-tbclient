package com.baidu.swan.bdprivate.address.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.swan.bdprivate.address.a.a;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
import java.util.List;
/* loaded from: classes9.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private RecyclerView bYb;
    private com.baidu.swan.bdprivate.address.a.a bYc;
    private View bYd;
    private TextView bYe;
    private CommonEmptyView bYf;
    private View bYg;
    private a.b bYh;
    private SwanAppBdActionBar bYi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum PageState {
        Normal,
        EMPTY_DATA,
        NET_ERROR
    }

    public ChooseAddressView(Context context) {
        super(context);
        init(context);
    }

    public ChooseAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(b.f.delivery_choose_layout, this);
        this.bYi = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.bYb = (RecyclerView) findViewById(b.e.delivery_list);
        this.bYd = findViewById(b.e.delivery_add);
        this.bYg = findViewById(b.e.delivery_add_line);
        this.bYf = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.bYe = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
        this.bYc = new com.baidu.swan.bdprivate.address.a.a(context);
        this.bYb.setLayoutManager(new LinearLayoutManager(context));
        this.bYb.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.bYb.setAdapter(this.bYc);
        this.bYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.bYh != null) {
                    ChooseAddressView.this.bYh.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.bYb.setBackgroundColor(Color.parseColor("#161616"));
            this.bYg.setBackgroundColor(Color.parseColor("#303030"));
            this.bYd.setBackgroundColor(Color.parseColor("#191919"));
            this.bYe.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.bYe.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void afL() {
        a(PageState.EMPTY_DATA);
        this.bYf.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.bYf.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void f(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.bYf.setTitle(getResources().getString(b.g.net_error));
        this.bYf.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.bYf.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.bYf.setVisibility(z ? 8 : 0);
        this.bYb.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.bYc;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.bYh = bVar;
        this.bYc.setDeliveryChooseListener(this.bYh);
    }

    public void ah(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.bYc.ad(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        afL();
    }

    public void updateUI() {
        this.bYc.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.bYi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int bYk;
        private int bYl;

        public a(int i, int i2) {
            this.bYk = i;
            this.bYl = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.bYl;
            rect.left = this.bYk;
            rect.right = this.bYk;
        }
    }
}
