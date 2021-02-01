package com.baidu.live.gift.b;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.l;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView;
import com.baidu.live.gift.z;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private a beF;
    private AlaGiftTabView.a beG;
    private GiftPanelPackageFragmentView beH;
    private com.baidu.live.gift.container.c beI;
    private b beJ;
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

    public GiftPanelPackageFragmentView Hk() {
        return this.beH;
    }

    public void a(a aVar) {
        this.beF = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.beG = aVar;
    }

    public void gH(String str) {
        if (this.beH != null) {
            this.beH.setCountSelectValue(str);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i) {
        if (this.beH != null) {
            this.beH.setCompositeEnabled(true);
        }
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
                return;
            }
            return;
        }
        p(str2, str4, "20".equals(str3) ? "查看道具" : "查看礼物");
        if (this.beH != null) {
            aa data = this.beH.getData();
            if (data.DR().equals(str2) && data.aYb != null && !data.aYb.isEmpty()) {
                for (aa.a aVar : data.aYb) {
                    aVar.num -= i;
                }
            }
            this.beH.setData(data);
        }
    }

    private void p(String str, String str2, String str3) {
        this.beJ = new b(this.mContext);
        this.beJ.a(new b.a() { // from class: com.baidu.live.gift.b.c.1
            @Override // com.baidu.live.gift.b.b.a
            public void gG(String str4) {
                c.this.beJ.dismiss();
                if (c.this.beF != null) {
                    c.this.beF.onBack(str4);
                }
            }

            @Override // com.baidu.live.gift.b.b.a
            public void onClose() {
                c.this.beJ.dismiss();
            }
        });
        this.beJ.o(str, str2, str3);
    }

    public void release() {
        if (this.beJ != null) {
            this.beJ.dismiss();
        }
        this.beF = null;
        this.beG = null;
    }

    private void initView() {
        this.beH = new GiftPanelPackageFragmentView(this.mContext);
        this.beH.setCallback(new GiftPanelPackageFragmentView.a() { // from class: com.baidu.live.gift.b.c.2
            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void onBack() {
                if (c.this.beF != null) {
                    c.this.beF.onBack(null);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void gI(String str) {
                if (c.this.beG != null && !TextUtils.isEmpty(str)) {
                    c.this.beG.g(str, "", true);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void Hm() {
                c.this.Hl();
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void b(String str, String str2, int i, String str3) {
                c.this.a(str, str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        final List<l> Fh;
        if (this.beH != null && this.beH.getCountSelectView() != null && (Fh = z.Fe().Fh()) != null && !Fh.isEmpty()) {
            this.beH.setCountSelectInputShowing(true);
            if (this.beI == null) {
                this.beI = new com.baidu.live.gift.container.c(this.mContext, 1, new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.b.c.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (c.this.beI != null) {
                            c.this.beI.dismiss();
                        }
                        if (c.this.beH != null) {
                            if (i == Fh.size()) {
                                if (c.this.beG != null) {
                                    c.this.beG.c(true, c.this.beH.getMaxSendNum());
                                    return;
                                }
                                return;
                            }
                            l lVar = (l) Fh.get(i);
                            if (lVar != null) {
                                int number = lVar.getNumber();
                                if (number == -1) {
                                    number = c.this.beH.getMaxSendNum();
                                }
                                if (number < 1) {
                                    number = 1;
                                }
                                c.this.beH.setCountSelectValue(String.valueOf(number));
                            }
                        }
                    }
                });
            }
            this.beI.a(this.beH.getCountSelectView(), Fh, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.b.c.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (c.this.beH != null) {
                        c.this.beH.setCountSelectInputShowing(false);
                    }
                }
            });
            this.beI.z(Color.parseColor("#FF65008B"), Color.parseColor("#FF8C008F"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, String str3) {
        if (this.beH != null) {
            if (i > this.beH.getMaxSendNum()) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), "合成失败，超过能合成的最大数量上限");
                return;
            }
            this.beH.setCompositeEnabled(false);
            if (this.beF != null) {
                this.beF.c(str, str2, i, str3);
            }
        }
    }
}
