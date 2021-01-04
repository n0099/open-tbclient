package com.baidu.live.gift.b;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.k;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView;
import com.baidu.live.gift.z;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private a bgo;
    private AlaGiftTabView.a bgp;
    private GiftPanelPackageFragmentView bgq;
    private com.baidu.live.gift.container.c bgr;
    private b bgt;
    private final Activity mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void c(String str, String str2, int i, String str3);

        void onBack(String str);
    }

    public c(Activity activity) {
        this.mContext = activity;
        initView();
    }

    public GiftPanelPackageFragmentView JP() {
        return this.bgq;
    }

    public void a(a aVar) {
        this.bgo = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bgp = aVar;
    }

    public void hv(String str) {
        if (this.bgq != null) {
            this.bgq.setCountSelectValue(str);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i) {
        if (this.bgq != null) {
            this.bgq.setCompositeEnabled(true);
        }
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
                return;
            }
            return;
        }
        q(str2, str4, "20".equals(str3) ? "查看道具" : "查看礼物");
        if (this.bgq != null) {
            aa data = this.bgq.getData();
            if (data.Gx().equals(str2) && data.aZG != null && !data.aZG.isEmpty()) {
                for (aa.a aVar : data.aZG) {
                    aVar.num -= i;
                }
            }
            this.bgq.setData(data);
        }
    }

    private void q(String str, String str2, String str3) {
        this.bgt = new b(this.mContext);
        this.bgt.a(new b.a() { // from class: com.baidu.live.gift.b.c.1
            @Override // com.baidu.live.gift.b.b.a
            public void hu(String str4) {
                c.this.bgt.dismiss();
                if (c.this.bgo != null) {
                    c.this.bgo.onBack(str4);
                }
            }

            @Override // com.baidu.live.gift.b.b.a
            public void onClose() {
                c.this.bgt.dismiss();
            }
        });
        this.bgt.p(str, str2, str3);
    }

    public void release() {
        if (this.bgt != null) {
            this.bgt.dismiss();
        }
        this.bgo = null;
        this.bgp = null;
    }

    private void initView() {
        this.bgq = new GiftPanelPackageFragmentView(this.mContext);
        this.bgq.setCallback(new GiftPanelPackageFragmentView.a() { // from class: com.baidu.live.gift.b.c.2
            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void onBack() {
                if (c.this.bgo != null) {
                    c.this.bgo.onBack(null);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void hw(String str) {
                if (c.this.bgp != null && !TextUtils.isEmpty(str)) {
                    c.this.bgp.g(str, "", true);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void JR() {
                c.this.JQ();
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void b(String str, String str2, int i, String str3) {
                c.this.a(str, str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ() {
        final List<k> HM;
        if (this.bgq != null && this.bgq.getCountSelectView() != null && (HM = z.HJ().HM()) != null && !HM.isEmpty()) {
            this.bgq.setCountSelectInputShowing(true);
            if (this.bgr == null) {
                this.bgr = new com.baidu.live.gift.container.c(this.mContext, 1, new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.b.c.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (c.this.bgr != null) {
                            c.this.bgr.dismiss();
                        }
                        if (c.this.bgq != null) {
                            if (i == HM.size()) {
                                if (c.this.bgp != null) {
                                    c.this.bgp.c(true, c.this.bgq.getMaxSendNum());
                                    return;
                                }
                                return;
                            }
                            k kVar = (k) HM.get(i);
                            if (kVar != null) {
                                int number = kVar.getNumber();
                                if (number == -1) {
                                    number = c.this.bgq.getMaxSendNum();
                                }
                                if (number < 1) {
                                    number = 1;
                                }
                                c.this.bgq.setCountSelectValue(String.valueOf(number));
                            }
                        }
                    }
                });
            }
            this.bgr.a(this.bgq.getCountSelectView(), HM, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.b.c.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (c.this.bgq != null) {
                        c.this.bgq.setCountSelectInputShowing(false);
                    }
                }
            });
            this.bgr.z(Color.parseColor("#FF65008B"), Color.parseColor("#FF8C008F"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, String str3) {
        if (this.bgq != null) {
            if (i > this.bgq.getMaxSendNum()) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), "合成失败，超过能合成的最大数量上限");
                return;
            }
            this.bgq.setCompositeEnabled(false);
            if (this.bgo != null) {
                this.bgo.c(str, str2, i, str3);
            }
        }
    }
}
