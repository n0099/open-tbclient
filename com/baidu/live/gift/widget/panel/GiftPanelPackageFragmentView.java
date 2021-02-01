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
/* loaded from: classes11.dex */
public class GiftPanelPackageFragmentView extends RelativeLayout {
    private a bic;
    private aa bie;
    private TbImageView bif;
    private TextView bih;
    private TextView bii;
    private GridView bij;
    private View bik;
    private ImageView bil;
    private TextView bim;
    private ImageView bin;
    private ImageView bio;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void Hm();

        void b(String str, String str2, int i, String str3);

        void gI(String str);

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
        return this.bik;
    }

    public void setCallback(a aVar) {
        this.bic = aVar;
    }

    public aa getData() {
        return this.bie;
    }

    public void setData(aa aaVar) {
        this.bie = aaVar;
        if (aaVar != null) {
            if (this.mTitleTextView != null) {
                if (aaVar.aVX != null && aaVar.aVX.aWl.equals("20")) {
                    this.mTitleTextView.setText("道具碎片");
                } else {
                    this.mTitleTextView.setText("礼物碎片");
                }
            }
            if (this.bif != null && (TextUtils.isEmpty(this.bif.getUrl()) || !this.bif.getUrl().equals(aaVar.getThumbnail_url()))) {
                this.bif.startLoad(!TextUtils.isEmpty(aaVar.getThumbnail_url()) ? aaVar.getThumbnail_url() : "", 10, false, false);
            }
            if (this.bih != null) {
                this.bih.setText(!TextUtils.isEmpty(aaVar.DS()) ? aaVar.DS() : "");
            }
            if (this.bii != null) {
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
                this.bii.setText(!TextUtils.isEmpty(price) ? String.format("价值 %s T豆", price) : "");
            }
            com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
            if (fragmentsAdapter == null) {
                fragmentsAdapter = new com.baidu.live.gift.b.a();
                this.bij.setAdapter((ListAdapter) fragmentsAdapter);
            }
            fragmentsAdapter.setData(aaVar.aYb);
            int dimensionPixelOffset = (aaVar.aYb == null || aaVar.aYb.size() <= 4) ? getResources().getDimensionPixelOffset(a.d.sdk_ds144) : -1;
            ViewGroup.LayoutParams layoutParams = this.bij.getLayoutParams();
            if (layoutParams.height != dimensionPixelOffset) {
                layoutParams.height = dimensionPixelOffset;
                this.bij.setLayoutParams(layoutParams);
            }
            boolean z = getMaxSendNum() > 0;
            if (this.bik != null) {
                this.bik.setEnabled(z);
            }
            if (this.bil != null) {
                if (z) {
                    this.bil.setColorFilter((ColorFilter) null);
                } else {
                    this.bil.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
                }
            }
            if (this.bim != null) {
                this.bim.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bin != null) {
                this.bin.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bio != null) {
                this.bio.setImageResource(z ? a.e.live_gift_panel_fragment_composite_bg_normal : a.e.live_gift_panel_fragment_composite_bg_disabled);
                this.bio.setEnabled(z);
            }
        }
    }

    public void setCountSelectInputShowing(boolean z) {
        if (this.bin != null) {
            this.bin.setImageResource(z ? a.e.sdk_icon_tabbar_arrow_down : a.e.sdk_icon_tabbar_arrow_up);
        }
    }

    public void setCountSelectValue(String str) {
        if (this.bim != null) {
            this.bim.setText(str);
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
        if (this.bio != null) {
            this.bio.setEnabled(z);
        }
    }

    public void reset() {
        this.bif.startLoad("", 10, false, false);
        this.bih.setText("");
        this.bii.setText("");
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
        IJ();
        IK();
        IL();
    }

    private void IJ() {
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        findViewById(a.f.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bic != null) {
                    GiftPanelPackageFragmentView.this.bic.onBack();
                }
            }
        });
    }

    private void IK() {
        this.bif = (TbImageView) findViewById(a.f.iv_target_thumb);
        this.bih = (TextView) findViewById(a.f.tv_target_name);
        this.bii = (TextView) findViewById(a.f.tv_target_price);
        this.bij = (GridView) findViewById(a.f.gv);
        this.bif.setDefaultBgResource(a.c.sdk_transparent);
        this.bif.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.bij.setNumColumns(4);
        this.bij.setVerticalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds320) - (getResources().getDimensionPixelOffset(a.d.sdk_ds144) * 2));
        this.bij.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.live.gift.b.a fragmentsAdapter;
                if (GiftPanelPackageFragmentView.this.bic != null && (fragmentsAdapter = GiftPanelPackageFragmentView.this.getFragmentsAdapter()) != null) {
                    fragmentsAdapter.cQ(i);
                    aa.a item = fragmentsAdapter.getItem(i);
                    if (item != null && !TextUtils.isEmpty(item.aYd)) {
                        GiftPanelPackageFragmentView.this.bic.gI(item.aYd);
                    }
                }
            }
        });
    }

    private void IL() {
        this.bik = findViewById(a.f.layout_count_select);
        this.bil = (ImageView) findViewById(a.f.iv_count_select_bg);
        this.bim = (TextView) findViewById(a.f.tv_count_select);
        this.bin = (ImageView) findViewById(a.f.iv_count_select_arrow);
        this.bik.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.bic != null) {
                    GiftPanelPackageFragmentView.this.bic.Hm();
                }
            }
        });
        this.bio = (ImageView) findViewById(a.f.iv_composite);
        this.bio.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (GiftPanelPackageFragmentView.this.bic != null && GiftPanelPackageFragmentView.this.bie != null) {
                    a aVar = GiftPanelPackageFragmentView.this.bic;
                    String DR = GiftPanelPackageFragmentView.this.bie.DR();
                    if (GiftPanelPackageFragmentView.this.bie.aVX != null) {
                        str = GiftPanelPackageFragmentView.this.bie.aVX.aWl;
                    } else {
                        str = "";
                    }
                    aVar.b(DR, str, JavaTypesHelper.toInt(GiftPanelPackageFragmentView.this.bim.getText().toString(), 1), GiftPanelPackageFragmentView.this.bie.getThumbnail_url());
                }
            }
        });
        setCountSelectValue("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.b.a getFragmentsAdapter() {
        if (this.bij == null) {
            return null;
        }
        ListAdapter adapter = this.bij.getAdapter();
        return adapter instanceof com.baidu.live.gift.b.a ? (com.baidu.live.gift.b.a) adapter : null;
    }
}
