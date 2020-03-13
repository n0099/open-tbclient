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
    private a.b ccA;
    private SwanAppBdActionBar ccB;
    private RecyclerView ccu;
    private com.baidu.swan.bdprivate.address.a.a ccv;
    private View ccw;
    private TextView ccx;
    private CommonEmptyView ccy;
    private View ccz;

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
        this.ccB = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.ccu = (RecyclerView) findViewById(b.e.delivery_list);
        this.ccw = findViewById(b.e.delivery_add);
        this.ccz = findViewById(b.e.delivery_add_line);
        this.ccy = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.ccx = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        this.ccv = new com.baidu.swan.bdprivate.address.a.a(context);
        this.ccu.setLayoutManager(new LinearLayoutManager(context));
        this.ccu.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.ccu.setAdapter(this.ccv);
        this.ccw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.ccA != null) {
                    ChooseAddressView.this.ccA.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccu.setBackgroundColor(Color.parseColor("#161616"));
            this.ccz.setBackgroundColor(Color.parseColor("#303030"));
            this.ccw.setBackgroundColor(Color.parseColor("#191919"));
            this.ccx.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.ccx.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void aiu() {
        a(PageState.EMPTY_DATA);
        this.ccy.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.ccy.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void e(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.ccy.setTitle(getResources().getString(b.g.net_error));
        this.ccy.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.ccy.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.ccy.setVisibility(z ? 8 : 0);
        this.ccu.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.ccv;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.ccA = bVar;
        this.ccv.setDeliveryChooseListener(this.ccA);
    }

    public void ag(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.ccv.ac(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        aiu();
    }

    public void updateUI() {
        this.ccv.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.ccB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int ccD;
        private int ccE;

        public a(int i, int i2) {
            this.ccD = i;
            this.ccE = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.ccE;
            rect.left = this.ccD;
            rect.right = this.ccD;
        }
    }
}
