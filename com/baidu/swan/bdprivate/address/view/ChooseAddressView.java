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
/* loaded from: classes11.dex */
public class ChooseAddressView extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private RecyclerView ccr;
    private com.baidu.swan.bdprivate.address.a.a cct;
    private View ccu;
    private TextView ccv;
    private CommonEmptyView ccw;
    private View ccx;
    private a.b ccy;
    private SwanAppBdActionBar ccz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
        this.ccz = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.ccr = (RecyclerView) findViewById(b.e.delivery_list);
        this.ccu = findViewById(b.e.delivery_add);
        this.ccx = findViewById(b.e.delivery_add_line);
        this.ccw = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.ccv = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
        this.cct = new com.baidu.swan.bdprivate.address.a.a(context);
        this.ccr.setLayoutManager(new LinearLayoutManager(context));
        this.ccr.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.ccr.setAdapter(this.cct);
        this.ccu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.ccy != null) {
                    ChooseAddressView.this.ccy.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccr.setBackgroundColor(Color.parseColor("#161616"));
            this.ccx.setBackgroundColor(Color.parseColor("#303030"));
            this.ccu.setBackgroundColor(Color.parseColor("#191919"));
            this.ccv.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.ccv.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void ais() {
        a(PageState.EMPTY_DATA);
        this.ccw.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.ccw.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void e(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.ccw.setTitle(getResources().getString(b.g.net_error));
        this.ccw.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.ccw.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.ccw.setVisibility(z ? 8 : 0);
        this.ccr.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.cct;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.ccy = bVar;
        this.cct.setDeliveryChooseListener(this.ccy);
    }

    public void ag(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cct.ac(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        ais();
    }

    public void updateUI() {
        this.cct.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.ccz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int ccB;
        private int ccC;

        public a(int i, int i2) {
            this.ccB = i;
            this.ccC = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.ccC;
            rect.left = this.ccB;
            rect.right = this.ccB;
        }
    }
}
