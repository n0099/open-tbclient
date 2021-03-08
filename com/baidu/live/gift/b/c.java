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
/* loaded from: classes10.dex */
public class c {
    private a bgh;
    private AlaGiftTabView.a bgi;
    private GiftPanelPackageFragmentView bgj;
    private com.baidu.live.gift.container.c bgk;
    private b bgl;
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

    public GiftPanelPackageFragmentView Hn() {
        return this.bgj;
    }

    public void a(a aVar) {
        this.bgh = aVar;
    }

    public void b(AlaGiftTabView.a aVar) {
        this.bgi = aVar;
    }

    public void gN(String str) {
        if (this.bgj != null) {
            this.bgj.setCountSelectValue(str);
        }
    }

    public void a(boolean z, String str, String str2, String str3, String str4, int i) {
        if (this.bgj != null) {
            this.bgj.setCompositeEnabled(true);
        }
        if (!z) {
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
                return;
            }
            return;
        }
        p(str2, str4, "20".equals(str3) ? "查看道具" : "查看礼物");
        if (this.bgj != null) {
            aa data = this.bgj.getData();
            if (data.DU().equals(str2) && data.aZB != null && !data.aZB.isEmpty()) {
                for (aa.a aVar : data.aZB) {
                    aVar.num -= i;
                }
            }
            this.bgj.setData(data);
        }
    }

    private void p(String str, String str2, String str3) {
        this.bgl = new b(this.mContext);
        this.bgl.a(new b.a() { // from class: com.baidu.live.gift.b.c.1
            @Override // com.baidu.live.gift.b.b.a
            public void gM(String str4) {
                c.this.bgl.dismiss();
                if (c.this.bgh != null) {
                    c.this.bgh.onBack(str4);
                }
            }

            @Override // com.baidu.live.gift.b.b.a
            public void onClose() {
                c.this.bgl.dismiss();
            }
        });
        this.bgl.o(str, str2, str3);
    }

    public void release() {
        if (this.bgl != null) {
            this.bgl.dismiss();
        }
        this.bgh = null;
        this.bgi = null;
    }

    private void initView() {
        this.bgj = new GiftPanelPackageFragmentView(this.mContext);
        this.bgj.setCallback(new GiftPanelPackageFragmentView.a() { // from class: com.baidu.live.gift.b.c.2
            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void onBack() {
                if (c.this.bgh != null) {
                    c.this.bgh.onBack(null);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void gO(String str) {
                if (c.this.bgi != null && !TextUtils.isEmpty(str)) {
                    c.this.bgi.g(str, "", true);
                }
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void Hp() {
                c.this.Ho();
            }

            @Override // com.baidu.live.gift.widget.panel.GiftPanelPackageFragmentView.a
            public void b(String str, String str2, int i, String str3) {
                c.this.a(str, str2, i, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho() {
        final List<l> Fk;
        if (this.bgj != null && this.bgj.getCountSelectView() != null && (Fk = z.Fh().Fk()) != null && !Fk.isEmpty()) {
            this.bgj.setCountSelectInputShowing(true);
            if (this.bgk == null) {
                this.bgk = new com.baidu.live.gift.container.c(this.mContext, 1, new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.b.c.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (c.this.bgk != null) {
                            c.this.bgk.dismiss();
                        }
                        if (c.this.bgj != null) {
                            if (i == Fk.size()) {
                                if (c.this.bgi != null) {
                                    c.this.bgi.c(true, c.this.bgj.getMaxSendNum());
                                    return;
                                }
                                return;
                            }
                            l lVar = (l) Fk.get(i);
                            if (lVar != null) {
                                int number = lVar.getNumber();
                                if (number == -1) {
                                    number = c.this.bgj.getMaxSendNum();
                                }
                                if (number < 1) {
                                    number = 1;
                                }
                                c.this.bgj.setCountSelectValue(String.valueOf(number));
                            }
                        }
                    }
                });
            }
            this.bgk.a(this.bgj.getCountSelectView(), Fk, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.b.c.4
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    if (c.this.bgj != null) {
                        c.this.bgj.setCountSelectInputShowing(false);
                    }
                }
            });
            this.bgk.z(Color.parseColor("#FF65008B"), Color.parseColor("#FF8C008F"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, String str3) {
        if (this.bgj != null) {
            if (i > this.bgj.getMaxSendNum()) {
                BdUtilHelper.showToast(this.mContext.getApplicationContext(), "合成失败，超过能合成的最大数量上限");
                return;
            }
            this.bgj.setCompositeEnabled(false);
            if (this.bgh != null) {
                this.bgh.c(str, str2, i, str3);
            }
        }
    }
}
