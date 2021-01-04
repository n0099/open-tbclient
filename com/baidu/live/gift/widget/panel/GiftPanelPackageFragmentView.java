package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.gift.aa;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class GiftPanelPackageFragmentView extends RelativeLayout {
    private a bjL;
    private aa bjM;
    private TbImageView bjN;
    private TextView bjO;
    private TextView bjP;
    private GridView bjQ;
    private View bjR;
    private ImageView bjS;
    private TextView bjT;
    private ImageView bjU;
    private ImageView bjV;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void JR();

        void b(String str, String str2, int i, String str3);

        void hw(String str);

        void onBack();
    }

    public GiftPanelPackageFragmentView(Context context) {
        super(context);
        init();
    }

    public GiftPanelPackageFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public View getCountSelectView() {
        return this.bjR;
    }

    public void setCallback(a aVar) {
        this.bjL = aVar;
    }

    public aa getData() {
        return this.bjM;
    }

    public void setData(aa aaVar) {
        this.bjM = aaVar;
        if (aaVar != null) {
            if (this.mTitleTextView != null) {
                if (aaVar.aXF != null && aaVar.aXF.aXT.equals("20")) {
                    this.mTitleTextView.setText("道具碎片");
                } else {
                    this.mTitleTextView.setText("礼物碎片");
                }
            }
            if (this.bjN != null && (TextUtils.isEmpty(this.bjN.getUrl()) || !this.bjN.getUrl().equals(aaVar.getThumbnail_url()))) {
                this.bjN.startLoad(!TextUtils.isEmpty(aaVar.getThumbnail_url()) ? aaVar.getThumbnail_url() : "", 10, false, false);
            }
            if (this.bjO != null) {
                this.bjO.setText(!TextUtils.isEmpty(aaVar.Gy()) ? aaVar.Gy() : "");
            }
            if (this.bjP != null) {
                String price = aaVar.getPrice();
                try {
                    long parseLong = Long.parseLong(aaVar.getPrice());
                    if (parseLong >= 100000000) {
                        price = (parseLong / 100000000) + "亿";
                    } else if (parseLong >= 10000000) {
                        price = (parseLong / 10000000) + "千万";
                    } else if (parseLong >= 10000) {
                        price = (parseLong / 10000) + "万";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.bjP.setText(!TextUtils.isEmpty(price) ? String.format("价值 %s T豆", price) : "");
            }
            com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
            if (fragmentsAdapter == null) {
                fragmentsAdapter = new com.baidu.live.gift.b.a();
                this.bjQ.setAdapter((ListAdapter) fragmentsAdapter);
            }
            fragmentsAdapter.setData(aaVar.aZG);
            int dimensionPixelOffset = (aaVar.aZG == null || aaVar.aZG.size() <= 4) ? getResources().getDimensionPixelOffset(a.d.sdk_ds144) : -1;
            ViewGroup.LayoutParams layoutParams = this.bjQ.getLayoutParams();
            if (layoutParams.height != dimensionPixelOffset) {
                layoutParams.height = dimensionPixelOffset;
                this.bjQ.setLayoutParams(layoutParams);
            }
            boolean z = getMaxSendNum() > 0;
            if (this.bjR != null) {
                this.bjR.setEnabled(z);
            }
            if (this.bjS != null) {
                if (z) {
                    this.bjS.setColorFilter((ColorFilter) null);
                } else {
                    this.bjS.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
                }
            }
            if (this.bjT != null) {
                this.bjT.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bjU != null) {
                this.bjU.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bjV != null) {
                this.bjV.setImageResource(z ? a.e.live_gift_panel_fragment_composite_bg_normal : a.e.live_gift_panel_fragment_composite_bg_disabled);
                this.bjV.setEnabled(z);
            }
        }
    }

    public void setCountSelectInputShowing(boolean z) {
        if (this.bjU != null) {
            this.bjU.setImageResource(z ? a.e.sdk_icon_tabbar_arrow_down : a.e.sdk_icon_tabbar_arrow_up);
        }
    }

    public void setCountSelectValue(String str) {
        if (this.bjT != null) {
            this.bjT.setText(str);
        }
    }

    public int getMaxSendNum() {
        List<aa.a> data;
        int i = 0;
        com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
        if (fragmentsAdapter != null && (data = fragmentsAdapter.getData()) != null) {
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            Iterator<aa.a> it = data.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = Math.min(it.next().num, i);
            }
        }
        return i;
    }

    public void setCompositeEnabled(boolean z) {
        if (this.bjV != null) {
            this.bjV.setEnabled(z);
        }
    }

    public void reset() {
        this.bjN.startLoad("", 10, false, false);
        this.bjO.setText("");
        this.bjP.setText("");
        com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
        if (fragmentsAdapter != null) {
            fragmentsAdapter.reset();
        }
        setCountSelectValue("1");
    }

    private void init() {
        setBackgroundResource(a.e.live_gift_panel_package_fragment_bg);
        setClickable(true);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_package_fragment, (ViewGroup) this, true);
        Lo();
        Lp();
        Lq();
    }

    private void Lo() {
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        findViewById(a.f.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bjL != null) {
                    GiftPanelPackageFragmentView.this.bjL.onBack();
                }
            }
        });
    }

    private void Lp() {
        this.bjN = (TbImageView) findViewById(a.f.iv_target_thumb);
        this.bjO = (TextView) findViewById(a.f.tv_target_name);
        this.bjP = (TextView) findViewById(a.f.tv_target_price);
        this.bjQ = (GridView) findViewById(a.f.gv);
        this.bjN.setDefaultBgResource(a.c.sdk_transparent);
        this.bjN.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.bjQ.setNumColumns(4);
        this.bjQ.setVerticalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds320) - (getResources().getDimensionPixelOffset(a.d.sdk_ds144) * 2));
        this.bjQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.live.gift.b.a fragmentsAdapter;
                if (GiftPanelPackageFragmentView.this.bjL != null && (fragmentsAdapter = GiftPanelPackageFragmentView.this.getFragmentsAdapter()) != null) {
                    fragmentsAdapter.er(i);
                    aa.a item = fragmentsAdapter.getItem(i);
                    if (item != null && !TextUtils.isEmpty(item.aZI)) {
                        GiftPanelPackageFragmentView.this.bjL.hw(item.aZI);
                    }
                }
            }
        });
    }

    private void Lq() {
        this.bjR = findViewById(a.f.layout_count_select);
        this.bjS = (ImageView) findViewById(a.f.iv_count_select_bg);
        this.bjT = (TextView) findViewById(a.f.tv_count_select);
        this.bjU = (ImageView) findViewById(a.f.iv_count_select_arrow);
        this.bjR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bjL != null) {
                    GiftPanelPackageFragmentView.this.bjL.JR();
                }
            }
        });
        this.bjV = (ImageView) findViewById(a.f.iv_composite);
        this.bjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (GiftPanelPackageFragmentView.this.bjL != null && GiftPanelPackageFragmentView.this.bjM != null) {
                    a aVar = GiftPanelPackageFragmentView.this.bjL;
                    String Gx = GiftPanelPackageFragmentView.this.bjM.Gx();
                    if (GiftPanelPackageFragmentView.this.bjM.aXF != null) {
                        str = GiftPanelPackageFragmentView.this.bjM.aXF.aXT;
                    } else {
                        str = "";
                    }
                    aVar.b(Gx, str, JavaTypesHelper.toInt(GiftPanelPackageFragmentView.this.bjT.getText().toString(), 1), GiftPanelPackageFragmentView.this.bjM.getThumbnail_url());
                }
            }
        });
        setCountSelectValue("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.b.a getFragmentsAdapter() {
        if (this.bjQ == null) {
            return null;
        }
        ListAdapter adapter = this.bjQ.getAdapter();
        return adapter instanceof com.baidu.live.gift.b.a ? (com.baidu.live.gift.b.a) adapter : null;
    }
}
