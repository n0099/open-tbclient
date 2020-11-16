package com.baidu.live.yuyingift.widget.panel;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel;
import com.baidu.live.yuyingift.panel.a;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public AlaGiftDrawPanel bQf;
    private a bQg;
    private AlaGiftDrawPanel.a bQh;
    public View bdA;
    public TextView bdB;
    public ImageButton bdC;
    public ImageButton bdD;
    public ImageButton bdE;

    /* loaded from: classes4.dex */
    public interface a {
        void HA();

        void ef(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQh = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.bdB.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.JI();
                    GiftPanelDrawContainerView.this.bdB.setVisibility(8);
                    GiftPanelDrawContainerView.this.bdC.setEnabled(false);
                    GiftPanelDrawContainerView.this.bdD.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bdB.setVisibility(0);
                    GiftPanelDrawContainerView.this.bdC.setEnabled(true);
                    GiftPanelDrawContainerView.this.bdD.setEnabled(true);
                    GiftPanelDrawContainerView.this.JI();
                }
                if (GiftPanelDrawContainerView.this.bQg != null) {
                    GiftPanelDrawContainerView.this.bQg.ef(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bQg = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bQf.getVisibility() == 0) {
                JJ();
            }
            JI();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.JK();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bQf.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                JK();
            }
            if (this.bQf != null && this.bQf.getCurrentPointSize() > 0) {
                if (this.bdB != null) {
                    this.bdB.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bdB != null) {
                this.bdB.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bR(true);
        if (this.bQf != null) {
            this.bQf.Iw();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bQf != null) {
            this.bQf.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bQf == null) {
            return null;
        }
        k kVar = new k();
        kVar.aUj = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aUk.addAll(this.bQf.getPoints());
        kVar.aUh = this.bQf.getMeasuredHeight();
        kVar.aUg = this.bQf.getMeasuredWidth();
        Rect rect = new Rect();
        this.bQf.getGlobalVisibleRect(rect);
        kVar.aUe = rect.left;
        kVar.aUf = rect.top;
        kVar.aUl = kVar.aUk.size();
        kVar.aUn = this.bQf.getGraffitiPointDesDatas();
        kVar.aUm = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aUc = screenDimensions[0];
        kVar.aUd = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdC) {
            if (this.bQf != null) {
                this.bQf.Iz();
            }
        } else if (view == this.bdD) {
            this.bdD.setEnabled(false);
            this.bdC.setEnabled(false);
            bR(false);
            this.bQh.d(0, 0L);
        } else if (view == this.bdE && this.bQg != null) {
            this.bQg.HA();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
        Hq();
        JE();
        JF();
        JG();
        JH();
        Hs();
    }

    private void Hq() {
        this.bdA = findViewById(a.f.layout_title);
        this.bdB = (TextView) findViewById(a.f.tv_title);
        this.bdC = (ImageButton) findViewById(a.f.btn_revert);
        this.bdD = (ImageButton) findViewById(a.f.btn_clean);
        this.bdE = (ImageButton) findViewById(a.f.btn_hide);
        this.bQf = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void JE() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdA.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bdA.setLayoutParams(layoutParams);
        this.bdA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void JF() {
        this.bdC.setOnClickListener(this);
        this.bdC.setEnabled(false);
    }

    private void JG() {
        this.bdD.setOnClickListener(this);
        this.bdD.setEnabled(false);
    }

    private void JH() {
        this.bdE.setOnClickListener(this);
    }

    private void Hs() {
        this.bQf.setGiftDrawEventListener(this.bQh);
        this.bQf.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0237a.class);
        List<AlaWheatInfoData> list = null;
        if (runTask != null && runTask.getData() != null) {
            list = ((a.InterfaceC0237a) runTask.getData()).WQ().bQN;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void Xf() {
        if (this.bQh != null && this.bQf != null && this.bQf.getCurrentPointSize() > 0) {
            this.bQh.d(this.bQf.getCurrentPointSize(), this.bQf.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        if (this.bQf != null) {
            if (this.bQf.getCurrentPointSize() > 0) {
                this.bQf.setTipImageVisibility(8);
            } else {
                this.bQf.setTipImageVisibility(0);
            }
        }
    }

    private void JJ() {
        if (this.bQf != null) {
            this.bQf.Ix();
            this.bQf.Iy();
        }
    }

    private void bR(boolean z) {
        if (this.bQf != null) {
            this.bQf.bR(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
