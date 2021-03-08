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
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.gift.aa;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class GiftPanelPackageFragmentView extends RelativeLayout {
    private a bjE;
    private aa bjF;
    private TbImageView bjG;
    private TextView bjH;
    private TextView bjI;
    private GridView bjJ;
    private View bjK;
    private ImageView bjL;
    private TextView bjM;
    private ImageView bjN;
    private ImageView bjO;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void Hp();

        void b(String str, String str2, int i, String str3);

        void gO(String str);

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
        return this.bjK;
    }

    public void setCallback(a aVar) {
        this.bjE = aVar;
    }

    public aa getData() {
        return this.bjF;
    }

    public void setData(aa aaVar) {
        this.bjF = aaVar;
        if (aaVar != null) {
            if (this.mTitleTextView != null) {
                if (aaVar.aXx != null && aaVar.aXx.aXL.equals("20")) {
                    this.mTitleTextView.setText("道具碎片");
                } else {
                    this.mTitleTextView.setText("礼物碎片");
                }
            }
            if (this.bjG != null && (TextUtils.isEmpty(this.bjG.getUrl()) || !this.bjG.getUrl().equals(aaVar.getThumbnail_url()))) {
                this.bjG.startLoad(!TextUtils.isEmpty(aaVar.getThumbnail_url()) ? aaVar.getThumbnail_url() : "", 10, false, false);
            }
            if (this.bjH != null) {
                this.bjH.setText(!TextUtils.isEmpty(aaVar.DV()) ? aaVar.DV() : "");
            }
            if (this.bjI != null) {
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
                this.bjI.setText(!TextUtils.isEmpty(price) ? String.format("价值 %s T豆", price) : "");
            }
            com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
            if (fragmentsAdapter == null) {
                fragmentsAdapter = new com.baidu.live.gift.b.a();
                this.bjJ.setAdapter((ListAdapter) fragmentsAdapter);
            }
            fragmentsAdapter.setData(aaVar.aZB);
            int dimensionPixelOffset = (aaVar.aZB == null || aaVar.aZB.size() <= 4) ? getResources().getDimensionPixelOffset(a.d.sdk_ds144) : -1;
            ViewGroup.LayoutParams layoutParams = this.bjJ.getLayoutParams();
            if (layoutParams.height != dimensionPixelOffset) {
                layoutParams.height = dimensionPixelOffset;
                this.bjJ.setLayoutParams(layoutParams);
            }
            boolean z = getMaxSendNum() > 0;
            if (this.bjK != null) {
                this.bjK.setEnabled(z);
            }
            if (this.bjL != null) {
                if (z) {
                    this.bjL.setColorFilter((ColorFilter) null);
                } else {
                    this.bjL.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
                }
            }
            if (this.bjM != null) {
                this.bjM.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bjN != null) {
                this.bjN.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bjO != null) {
                this.bjO.setImageResource(z ? a.e.live_gift_panel_fragment_composite_bg_normal : a.e.live_gift_panel_fragment_composite_bg_disabled);
                this.bjO.setEnabled(z);
            }
        }
    }

    public void setCountSelectInputShowing(boolean z) {
        if (this.bjN != null) {
            this.bjN.setImageResource(z ? a.e.sdk_icon_tabbar_arrow_down : a.e.sdk_icon_tabbar_arrow_up);
        }
    }

    public void setCountSelectValue(String str) {
        if (this.bjM != null) {
            this.bjM.setText(str);
        }
    }

    public int getMaxSendNum() {
        List<aa.a> data;
        int i = 0;
        com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
        if (fragmentsAdapter != null && (data = fragmentsAdapter.getData()) != null) {
            int i2 = Integer.MAX_VALUE;
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
        if (this.bjO != null) {
            this.bjO.setEnabled(z);
        }
    }

    public void reset() {
        this.bjG.startLoad("", 10, false, false);
        this.bjH.setText("");
        this.bjI.setText("");
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
        IM();
        IN();
        IO();
    }

    private void IM() {
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        findViewById(a.f.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bjE != null) {
                    GiftPanelPackageFragmentView.this.bjE.onBack();
                }
            }
        });
    }

    private void IN() {
        this.bjG = (TbImageView) findViewById(a.f.iv_target_thumb);
        this.bjH = (TextView) findViewById(a.f.tv_target_name);
        this.bjI = (TextView) findViewById(a.f.tv_target_price);
        this.bjJ = (GridView) findViewById(a.f.gv);
        this.bjG.setDefaultBgResource(a.c.sdk_transparent);
        this.bjG.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.bjJ.setNumColumns(4);
        this.bjJ.setVerticalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds320) - (getResources().getDimensionPixelOffset(a.d.sdk_ds144) * 2));
        this.bjJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.live.gift.b.a fragmentsAdapter;
                if (GiftPanelPackageFragmentView.this.bjE != null && (fragmentsAdapter = GiftPanelPackageFragmentView.this.getFragmentsAdapter()) != null) {
                    fragmentsAdapter.cR(i);
                    aa.a item = fragmentsAdapter.getItem(i);
                    if (item != null && !TextUtils.isEmpty(item.aZD)) {
                        GiftPanelPackageFragmentView.this.bjE.gO(item.aZD);
                    }
                }
            }
        });
    }

    private void IO() {
        this.bjK = findViewById(a.f.layout_count_select);
        this.bjL = (ImageView) findViewById(a.f.iv_count_select_bg);
        this.bjM = (TextView) findViewById(a.f.tv_count_select);
        this.bjN = (ImageView) findViewById(a.f.iv_count_select_arrow);
        this.bjK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bjE != null) {
                    GiftPanelPackageFragmentView.this.bjE.Hp();
                }
            }
        });
        this.bjO = (ImageView) findViewById(a.f.iv_composite);
        this.bjO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (GiftPanelPackageFragmentView.this.bjE != null && GiftPanelPackageFragmentView.this.bjF != null) {
                    a aVar = GiftPanelPackageFragmentView.this.bjE;
                    String DU = GiftPanelPackageFragmentView.this.bjF.DU();
                    if (GiftPanelPackageFragmentView.this.bjF.aXx != null) {
                        str = GiftPanelPackageFragmentView.this.bjF.aXx.aXL;
                    } else {
                        str = "";
                    }
                    aVar.b(DU, str, JavaTypesHelper.toInt(GiftPanelPackageFragmentView.this.bjM.getText().toString(), 1), GiftPanelPackageFragmentView.this.bjF.getThumbnail_url());
                }
            }
        });
        setCountSelectValue("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.b.a getFragmentsAdapter() {
        if (this.bjJ == null) {
            return null;
        }
        ListAdapter adapter = this.bjJ.getAdapter();
        return adapter instanceof com.baidu.live.gift.b.a ? (com.baidu.live.gift.b.a) adapter : null;
    }
}
