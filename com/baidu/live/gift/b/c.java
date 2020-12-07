package com.baidu.live.gift.b;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.b;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView;
import com.baidu.live.gift.z;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private final Activity beD;
    private a beE;
    private AlaGiftTabView.a beF;
    private GiftPanelPackageFragmentView beG;
    private com.baidu.live.gift.container.c beH;
    private b beI;

    /* loaded from: classes4.dex */
    public interface a {
        void c(String str, String str2, int i, String str3);

        void onBack(String str);
    }

    public c(Activity activity) {
        this.beD = activity;
        initView();
    }

    public GiftPanelPackageFragmentView Kn() {
        return this.beG;
    }

    public void a(a aVar) {
        this.beE = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.beF = aVar;
    }

    public void hK(String str) {
        if (this.beG != null) {
            this.beG.setCountSelectValue(str);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i) {
        if (this.beG != null) {
            this.beG.setCompositeEnabled(true);
        }
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.beD.getApplicationContext(), str);
                return;
            }
            return;
        }
        p(str2, str4, "20".equals(str3) ? "查看道具" : "查看礼物");
        if (this.beG != null) {
            aa data = this.beG.getData();
            if (data.GX().equals(str2) && data.aYb != null && !data.aYb.isEmpty()) {
                for (aa.a aVar : data.aYb) {
                    aVar.num -= i;
                }
            }
            this.beG.setData(data);
        }
    }

    private void p(String str, String str2, String str3) {
        this.beI = new b(this.beD);
        this.beI.a(new b.a() { // from class: com.baidu.live.gift.b.c.1
            @Override // com.baidu.live.gift.b.b.a
            public void hJ(String str4) {
                c.this.beI.dismiss();
                if (c.this.beE != null) {
                    c.this.beE.onBack(str4);
                }
            }

            @Override // com.baidu.live.gift.b.b.a
            public void onClose() {
                c.this.beI.dismiss();
            }
        });
        this.beI.o(str, str2, str3);
    }

    public void release() {
        if (this.beI != null) {
            this.beI.dismiss();
        }
        this.beE = null;
        this.beF = null;
    }

    private void initView() {
        this.beG = new GiftPanelPackageFragmentView(this.beD);
        this.beG.setCallback(new GiftPanelPackageFragmentView.a() { // from class: com.baidu.live.gift.b.c.2
            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void onBack() {
                if (c.this.beE != null) {
                    c.this.beE.onBack(null);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void hL(String str) {
                if (c.this.beF != null && !TextUtils.isEmpty(str)) {
                    c.this.beF.f(str, "", true);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void Kp() {
                c.this.Ko();
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void b(String str, String str2, int i, String str3) {
                c.this.a(str, str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        final List<j> Il;
        if (this.beG != null && this.beG.getCountSelectView() != null && (Il = z.Ii().Il()) != null && !Il.isEmpty()) {
            this.beG.setCountSelectInputShowing(true);
            if (this.beH == null) {
                this.beH = new com.baidu.live.gift.container.c(this.beD, 1, new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.b.c.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (c.this.beH != null) {
                            c.this.beH.dismiss();
                        }
                        if (c.this.beG != null) {
                            if (i == Il.size()) {
                                if (c.this.beF != null) {
                                    c.this.beF.c(true, c.this.beG.getMaxSendNum());
                                    return;
                                }
                                return;
                            }
                            j jVar = (j) Il.get(i);
                            if (jVar != null) {
                                int number = jVar.getNumber();
                                if (number == -1) {
                                    number = c.this.beG.getMaxSendNum();
                                }
                                if (number < 1) {
                                    number = 1;
                                }
                                c.this.beG.setCountSelectValue(String.valueOf(number));
                            }
                        }
                    }
                });
            }
            this.beH.a(this.beG.getCountSelectView(), Il, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.b.c.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (c.this.beG != null) {
                        c.this.beG.setCountSelectInputShowing(false);
                    }
                }
            });
            this.beH.z(Color.parseColor("#FF65008B"), Color.parseColor("#FF8C008F"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, String str3) {
        if (this.beG != null) {
            if (i > this.beG.getMaxSendNum()) {
                BdUtilHelper.showToast(this.beD.getApplicationContext(), "合成失败，超过能合成的最大数量上限");
                return;
            }
            this.beG.setCompositeEnabled(false);
            if (this.beE != null) {
                this.beE.c(str, str2, i, str3);
            }
        }
    }
}
