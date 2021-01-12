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
/* loaded from: classes10.dex */
public class GiftPanelPackageFragmentView extends RelativeLayout {
    private a beU;
    private aa beV;
    private TbImageView beW;
    private TextView beX;
    private TextView beY;
    private GridView beZ;
    private View bfa;
    private ImageView bfc;
    private TextView bfd;
    private ImageView bfe;
    private ImageView bff;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void FW();

        void b(String str, String str2, int i, String str3);

        void gk(String str);

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
        return this.bfa;
    }

    public void setCallback(a aVar) {
        this.beU = aVar;
    }

    public aa getData() {
        return this.beV;
    }

    public void setData(aa aaVar) {
        this.beV = aaVar;
        if (aaVar != null) {
            if (this.mTitleTextView != null) {
                if (aaVar.aSS != null && aaVar.aSS.aTg.equals("20")) {
                    this.mTitleTextView.setText("道具碎片");
                } else {
                    this.mTitleTextView.setText("礼物碎片");
                }
            }
            if (this.beW != null && (TextUtils.isEmpty(this.beW.getUrl()) || !this.beW.getUrl().equals(aaVar.getThumbnail_url()))) {
                this.beW.startLoad(!TextUtils.isEmpty(aaVar.getThumbnail_url()) ? aaVar.getThumbnail_url() : "", 10, false, false);
            }
            if (this.beX != null) {
                this.beX.setText(!TextUtils.isEmpty(aaVar.CD()) ? aaVar.CD() : "");
            }
            if (this.beY != null) {
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
                this.beY.setText(!TextUtils.isEmpty(price) ? String.format("价值 %s T豆", price) : "");
            }
            com.baidu.live.gift.b.a fragmentsAdapter = getFragmentsAdapter();
            if (fragmentsAdapter == null) {
                fragmentsAdapter = new com.baidu.live.gift.b.a();
                this.beZ.setAdapter((ListAdapter) fragmentsAdapter);
            }
            fragmentsAdapter.setData(aaVar.aUT);
            int dimensionPixelOffset = (aaVar.aUT == null || aaVar.aUT.size() <= 4) ? getResources().getDimensionPixelOffset(a.d.sdk_ds144) : -1;
            ViewGroup.LayoutParams layoutParams = this.beZ.getLayoutParams();
            if (layoutParams.height != dimensionPixelOffset) {
                layoutParams.height = dimensionPixelOffset;
                this.beZ.setLayoutParams(layoutParams);
            }
            boolean z = getMaxSendNum() > 0;
            if (this.bfa != null) {
                this.bfa.setEnabled(z);
            }
            if (this.bfc != null) {
                if (z) {
                    this.bfc.setColorFilter((ColorFilter) null);
                } else {
                    this.bfc.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
                }
            }
            if (this.bfd != null) {
                this.bfd.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bfe != null) {
                this.bfe.setAlpha(z ? 1.0f : 0.5f);
            }
            if (this.bff != null) {
                this.bff.setImageResource(z ? a.e.live_gift_panel_fragment_composite_bg_normal : a.e.live_gift_panel_fragment_composite_bg_disabled);
                this.bff.setEnabled(z);
            }
        }
    }

    public void setCountSelectInputShowing(boolean z) {
        if (this.bfe != null) {
            this.bfe.setImageResource(z ? a.e.sdk_icon_tabbar_arrow_down : a.e.sdk_icon_tabbar_arrow_up);
        }
    }

    public void setCountSelectValue(String str) {
        if (this.bfd != null) {
            this.bfd.setText(str);
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
        if (this.bff != null) {
            this.bff.setEnabled(z);
        }
    }

    public void reset() {
        this.beW.startLoad("", 10, false, false);
        this.beX.setText("");
        this.beY.setText("");
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
        Ht();
        Hu();
        Hv();
    }

    private void Ht() {
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        findViewById(a.f.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.beU != null) {
                    GiftPanelPackageFragmentView.this.beU.onBack();
                }
            }
        });
    }

    private void Hu() {
        this.beW = (TbImageView) findViewById(a.f.iv_target_thumb);
        this.beX = (TextView) findViewById(a.f.tv_target_name);
        this.beY = (TextView) findViewById(a.f.tv_target_price);
        this.beZ = (GridView) findViewById(a.f.gv);
        this.beW.setDefaultBgResource(a.c.sdk_transparent);
        this.beW.setDefaultErrorResource(a.e.sdk_shape_transparent);
        this.beZ.setNumColumns(4);
        this.beZ.setVerticalSpacing(getResources().getDimensionPixelOffset(a.d.sdk_ds320) - (getResources().getDimensionPixelOffset(a.d.sdk_ds144) * 2));
        this.beZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.live.gift.b.a fragmentsAdapter;
                if (GiftPanelPackageFragmentView.this.beU != null && (fragmentsAdapter = GiftPanelPackageFragmentView.this.getFragmentsAdapter()) != null) {
                    fragmentsAdapter.cL(i);
                    aa.a item = fragmentsAdapter.getItem(i);
                    if (item != null && !TextUtils.isEmpty(item.aUV)) {
                        GiftPanelPackageFragmentView.this.beU.gk(item.aUV);
                    }
                }
            }
        });
    }

    private void Hv() {
        this.bfa = findViewById(a.f.layout_count_select);
        this.bfc = (ImageView) findViewById(a.f.iv_count_select_bg);
        this.bfd = (TextView) findViewById(a.f.tv_count_select);
        this.bfe = (ImageView) findViewById(a.f.iv_count_select_arrow);
        this.bfa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftPanelPackageFragmentView.this.beU != null) {
                    GiftPanelPackageFragmentView.this.beU.FW();
                }
            }
        });
        this.bff = (ImageView) findViewById(a.f.iv_composite);
        this.bff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (GiftPanelPackageFragmentView.this.beU != null && GiftPanelPackageFragmentView.this.beV != null) {
                    a aVar = GiftPanelPackageFragmentView.this.beU;
                    String CC = GiftPanelPackageFragmentView.this.beV.CC();
                    if (GiftPanelPackageFragmentView.this.beV.aSS != null) {
                        str = GiftPanelPackageFragmentView.this.beV.aSS.aTg;
                    } else {
                        str = "";
                    }
                    aVar.b(CC, str, JavaTypesHelper.toInt(GiftPanelPackageFragmentView.this.bfd.getText().toString(), 1), GiftPanelPackageFragmentView.this.beV.getThumbnail_url());
                }
            }
        });
        setCountSelectValue("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.gift.b.a getFragmentsAdapter() {
        if (this.beZ == null) {
            return null;
        }
        ListAdapter adapter = this.beZ.getAdapter();
        return adapter instanceof com.baidu.live.gift.b.a ? (com.baidu.live.gift.b.a) adapter : null;
    }
}
