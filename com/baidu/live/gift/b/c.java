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
/* loaded from: classes10.dex */
public class c {
    private GiftPanelPackageFragmentView bbA;
    private com.baidu.live.gift.container.c bbB;
    private b bbC;
    private a bby;
    private AlaGiftTabView.a bbz;
    private final Activity mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void c(String str, String str2, int i, String str3);

        void onBack(String str);
    }

    public c(Activity activity) {
        this.mContext = activity;
        initView();
    }

    public GiftPanelPackageFragmentView FU() {
        return this.bbA;
    }

    public void a(a aVar) {
        this.bby = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bbz = aVar;
    }

    public void gj(String str) {
        if (this.bbA != null) {
            this.bbA.setCountSelectValue(str);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i) {
        if (this.bbA != null) {
            this.bbA.setCompositeEnabled(true);
        }
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
                return;
            }
            return;
        }
        p(str2, str4, "20".equals(str3) ? "查看道具" : "查看礼物");
        if (this.bbA != null) {
            aa data = this.bbA.getData();
            if (data.CC().equals(str2) && data.aUT != null && !data.aUT.isEmpty()) {
                for (aa.a aVar : data.aUT) {
                    aVar.num -= i;
                }
            }
            this.bbA.setData(data);
        }
    }

    private void p(String str, String str2, String str3) {
        this.bbC = new b(this.mContext);
        this.bbC.a(new b.a() { // from class: com.baidu.live.gift.b.c.1
            @Override // com.baidu.live.gift.b.b.a
            public void gi(String str4) {
                c.this.bbC.dismiss();
                if (c.this.bby != null) {
                    c.this.bby.onBack(str4);
                }
            }

            @Override // com.baidu.live.gift.b.b.a
            public void onClose() {
                c.this.bbC.dismiss();
            }
        });
        this.bbC.o(str, str2, str3);
    }

    public void release() {
        if (this.bbC != null) {
            this.bbC.dismiss();
        }
        this.bby = null;
        this.bbz = null;
    }

    private void initView() {
        this.bbA = new GiftPanelPackageFragmentView(this.mContext);
        this.bbA.setCallback(new GiftPanelPackageFragmentView.a() { // from class: com.baidu.live.gift.b.c.2
            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void onBack() {
                if (c.this.bby != null) {
                    c.this.bby.onBack(null);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void gk(String str) {
                if (c.this.bbz != null && !TextUtils.isEmpty(str)) {
                    c.this.bbz.g(str, "", true);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void FW() {
                c.this.FV();
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void b(String str, String str2, int i, String str3) {
                c.this.a(str, str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FV() {
        final List<k> DR;
        if (this.bbA != null && this.bbA.getCountSelectView() != null && (DR = z.DO().DR()) != null && !DR.isEmpty()) {
            this.bbA.setCountSelectInputShowing(true);
            if (this.bbB == null) {
                this.bbB = new com.baidu.live.gift.container.c(this.mContext, 1, new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.b.c.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (c.this.bbB != null) {
                            c.this.bbB.dismiss();
                        }
                        if (c.this.bbA != null) {
                            if (i == DR.size()) {
                                if (c.this.bbz != null) {
                                    c.this.bbz.c(true, c.this.bbA.getMaxSendNum());
                                    return;
                                }
                                return;
                            }
                            k kVar = (k) DR.get(i);
                            if (kVar != null) {
                                int number = kVar.getNumber();
                                if (number == -1) {
                                    number = c.this.bbA.getMaxSendNum();
                                }
                                if (number < 1) {
                                    number = 1;
                                }
                                c.this.bbA.setCountSelectValue(String.valueOf(number));
                            }
                        }
                    }
                });
            }
            this.bbB.a(this.bbA.getCountSelectView(), DR, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.b.c.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (c.this.bbA != null) {
                        c.this.bbA.setCountSelectInputShowing(false);
                    }
                }
            });
            this.bbB.z(Color.parseColor("#FF65008B"), Color.parseColor("#FF8C008F"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, String str3) {
        if (this.bbA != null) {
            if (i > this.bbA.getMaxSendNum()) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), "合成失败，超过能合成的最大数量上限");
                return;
            }
            this.bbA.setCompositeEnabled(false);
            if (this.bby != null) {
                this.bby.c(str, str2, i, str3);
            }
        }
    }
}
