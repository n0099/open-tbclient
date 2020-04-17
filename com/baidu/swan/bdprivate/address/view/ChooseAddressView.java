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
    private RecyclerView cBF;
    private com.baidu.swan.bdprivate.address.a.a cBG;
    private View cBH;
    private TextView cBI;
    private CommonEmptyView cBJ;
    private View cBK;
    private a.b cBL;
    private SwanAppBdActionBar cBM;

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
        this.cBM = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cBF = (RecyclerView) findViewById(b.e.delivery_list);
        this.cBH = findViewById(b.e.delivery_add);
        this.cBK = findViewById(b.e.delivery_add_line);
        this.cBJ = (CommonEmptyView) findViewById(b.e.delivery_empty);
        this.cBI = (TextView) findViewById(b.e.delivery_add_txt);
        a(PageState.Normal);
        onNightModeChanged(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
        this.cBG = new com.baidu.swan.bdprivate.address.a.a(context);
        this.cBF.setLayoutManager(new LinearLayoutManager(context));
        this.cBF.addItemDecoration(new a(0, af.dip2px(context, 7.0f)));
        this.cBF.setAdapter(this.cBG);
        this.cBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.ChooseAddressView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChooseAddressView.this.cBL != null) {
                    ChooseAddressView.this.cBL.b(new com.baidu.swan.bdprivate.address.c.b(), "add");
                }
            }
        });
    }

    public void onNightModeChanged(boolean z) {
        if (z) {
            this.cBF.setBackgroundColor(Color.parseColor("#161616"));
            this.cBK.setBackgroundColor(Color.parseColor("#303030"));
            this.cBH.setBackgroundColor(Color.parseColor("#191919"));
            this.cBI.setBackgroundColor(Color.parseColor("#803C76FF"));
            this.cBI.setTextColor(Color.parseColor("#80ffffff"));
        }
    }

    public void aqF() {
        a(PageState.EMPTY_DATA);
        this.cBJ.setTitle(getResources().getString(b.g.delivery_empty_title));
        this.cBJ.setIcon(getResources().getDrawable(b.d.empty_icon_document));
    }

    public void e(View.OnClickListener onClickListener) {
        a(PageState.NET_ERROR);
        this.cBJ.setTitle(getResources().getString(b.g.net_error));
        this.cBJ.setIcon(getResources().getDrawable(b.d.aiapps_empty_icon_network));
        this.cBJ.setTextButtonClickListener(onClickListener);
    }

    private void a(PageState pageState) {
        boolean z = pageState == PageState.Normal;
        this.cBJ.setVisibility(z ? 8 : 0);
        this.cBF.setVisibility(z ? 0 : 8);
    }

    public com.baidu.swan.bdprivate.address.a.a getDeliveryAdapter() {
        return this.cBG;
    }

    public void setDeliveryChooseListener(a.b bVar) {
        this.cBL = bVar;
        this.cBG.setDeliveryChooseListener(this.cBL);
    }

    public void ao(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cBG.ak(list);
            a(PageState.Normal);
            updateUI();
            return;
        }
        aqF();
    }

    public void updateUI() {
        this.cBG.notifyDataSetChanged();
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cBM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int cBO;
        private int cBP;

        public a(int i, int i2) {
            this.cBO = i;
            this.cBP = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.cBP;
            rect.left = this.cBO;
            rect.right = this.cBO;
        }
    }
}
