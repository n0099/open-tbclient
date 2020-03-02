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
    private SwanAppBdActionBar ccA;
    private RecyclerView cct;
    private com.baidu.swan.bdprivate.address.a.a ccu;
    private View ccv;
    private TextView ccw;
    private CommonEmptyView ccx;
    private View ccy;
    private a.b ccz;

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
        this.ccA = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cct = (RecyclerView) findViewById(b.e.delivery_list);
        this.ccv = findViewById(b.e.delivery_add);
        this.ccy = findViewById(b.e.delivery_add_line);
        this.ccx = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.ccw = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        this.ccu = new com.baidu.swan.bdprivate.address.a.a(context);
        this.cct.setLayoutManager(new LinearLayoutManager(context));
        this.cct.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.cct.setAdapter(this.ccu);
        this.ccv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.ccz != null) {
                    ChooseAddressView.this.ccz.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.cct.setBackgroundColor(Color.parseColor("#161616"));
            this.ccy.setBackgroundColor(Color.parseColor("#303030"));
            this.ccv.setBackgroundColor(Color.parseColor("#191919"));
            this.ccw.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.ccw.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void aiu() {
        a(PageState.EMPTY_DATA);
        this.ccx.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.ccx.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void e(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.ccx.setTitle(getResources().getString(b.g.net_error));
        this.ccx.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.ccx.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.ccx.setVisibility(z ? 8 : 0);
        this.cct.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.ccu;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.ccz = bVar;
        this.ccu.setDeliveryChooseListener(this.ccz);
    }

    public void ag(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.ccu.ac(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        aiu();
    }

    public void updateUI() {
        this.ccu.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.ccA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int ccC;
        private int ccD;

        public a(int i, int i2) {
            this.ccC = i;
            this.ccD = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.ccD;
            rect.left = this.ccC;
            rect.right = this.ccC;
        }
    }
}
