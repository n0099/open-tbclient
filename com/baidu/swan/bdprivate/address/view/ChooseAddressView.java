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
    private RecyclerView ccF;
    private com.baidu.swan.bdprivate.address.a.a ccG;
    private View ccH;
    private TextView ccI;
    private CommonEmptyView ccJ;
    private View ccK;
    private a.b ccL;
    private SwanAppBdActionBar ccM;

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
        this.ccM = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.ccF = (RecyclerView) findViewById(b.e.delivery_list);
        this.ccH = findViewById(b.e.delivery_add);
        this.ccK = findViewById(b.e.delivery_add_line);
        this.ccJ = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.ccI = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
        this.ccG = new com.baidu.swan.bdprivate.address.a.a(context);
        this.ccF.setLayoutManager(new LinearLayoutManager(context));
        this.ccF.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.ccF.setAdapter(this.ccG);
        this.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.ccL != null) {
                    ChooseAddressView.this.ccL.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.ccF.setBackgroundColor(Color.parseColor("#161616"));
            this.ccK.setBackgroundColor(Color.parseColor("#303030"));
            this.ccH.setBackgroundColor(Color.parseColor("#191919"));
            this.ccI.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.ccI.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void aix() {
        a(PageState.EMPTY_DATA);
        this.ccJ.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.ccJ.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void e(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.ccJ.setTitle(getResources().getString(b.g.net_error));
        this.ccJ.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.ccJ.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.ccJ.setVisibility(z ? 8 : 0);
        this.ccF.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.ccG;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.ccL = bVar;
        this.ccG.setDeliveryChooseListener(this.ccL);
    }

    public void ag(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.ccG.ac(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        aix();
    }

    public void updateUI() {
        this.ccG.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.ccM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int ccO;
        private int ccP;

        public a(int i, int i2) {
            this.ccO = i;
            this.ccP = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.ccP;
            rect.left = this.ccO;
            rect.right = this.ccO;
        }
    }
}
