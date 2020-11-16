package com.baidu.live.gift.widget.panel;

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
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View bdA;
    public TextView bdB;
    public ImageButton bdC;
    public ImageButton bdD;
    public ImageButton bdE;
    public AlaGiftDrawPanel bdF;
    private a bdG;
    private AlaGiftDrawPanel.a bdH;

    /* loaded from: classes4.dex */
    public interface a {
        void HA();

        void ef(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdH = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.bdB.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(j)));
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
                if (GiftPanelDrawContainerView.this.bdG != null) {
                    GiftPanelDrawContainerView.this.bdG.ef(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bdG = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bdF.getVisibility() == 0) {
                JJ();
            }
            JI();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.JK();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bdF.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                JK();
            }
            if (this.bdF != null && this.bdF.getCurrentPointSize() > 0) {
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
        if (this.bdF != null) {
            this.bdF.Iw();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bdF != null) {
            this.bdF.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bdF == null) {
            return null;
        }
        k kVar = new k();
        kVar.aUj = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aUk.addAll(this.bdF.getPoints());
        kVar.aUh = this.bdF.getMeasuredHeight();
        kVar.aUg = this.bdF.getMeasuredWidth();
        Rect rect = new Rect();
        this.bdF.getGlobalVisibleRect(rect);
        kVar.aUe = rect.left;
        kVar.aUf = rect.top;
        kVar.aUl = kVar.aUk.size();
        kVar.aUn = this.bdF.getGraffitiPointDesDatas();
        kVar.aUm = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aUc = screenDimensions[0];
        kVar.aUd = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdC) {
            if (this.bdF != null) {
                this.bdF.Iz();
            }
        } else if (view == this.bdD) {
            this.bdD.setEnabled(false);
            this.bdC.setEnabled(false);
            bR(false);
            this.bdH.d(0, 0L);
        } else if (view == this.bdE && this.bdG != null) {
            this.bdG.HA();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_draw_container, (ViewGroup) this, true);
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
        this.bdF = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void JE() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdA.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bdA.setLayoutParams(layoutParams);
        this.bdA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
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
        this.bdF.setGiftDrawEventListener(this.bdH);
        this.bdF.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        if (this.bdF != null) {
            if (this.bdF.getCurrentPointSize() > 0) {
                this.bdF.setTipImageVisibility(8);
            } else {
                this.bdF.setTipImageVisibility(0);
            }
        }
    }

    private void JJ() {
        if (this.bdF != null) {
            this.bdF.Ix();
            this.bdF.Iy();
        }
    }

    private void bR(boolean z) {
        if (this.bdF != null) {
            this.bdF.bR(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
