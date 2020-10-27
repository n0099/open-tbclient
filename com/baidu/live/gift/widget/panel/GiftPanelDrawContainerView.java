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
import com.baidu.live.gift.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View bdS;
    public TextView bdT;
    public ImageButton bdU;
    public ImageButton bdV;
    public ImageButton bdW;
    public AlaGiftDrawPanel bdX;
    private a bdY;
    private AlaGiftDrawPanel.a bdZ;

    /* loaded from: classes4.dex */
    public interface a {
        void HI();

        void ej(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdZ = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void e(int i, long j) {
                GiftPanelDrawContainerView.this.bdT.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.JR();
                    GiftPanelDrawContainerView.this.bdT.setVisibility(8);
                    GiftPanelDrawContainerView.this.bdU.setEnabled(false);
                    GiftPanelDrawContainerView.this.bdV.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bdT.setVisibility(0);
                    GiftPanelDrawContainerView.this.bdU.setEnabled(true);
                    GiftPanelDrawContainerView.this.bdV.setEnabled(true);
                    GiftPanelDrawContainerView.this.JR();
                }
                if (GiftPanelDrawContainerView.this.bdY != null) {
                    GiftPanelDrawContainerView.this.bdY.ej(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bdY = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bdX.getVisibility() == 0) {
                JS();
            }
            JR();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.JT();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bdX.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                JT();
            }
            if (this.bdX != null && this.bdX.getCurrentPointSize() > 0) {
                if (this.bdT != null) {
                    this.bdT.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bdT != null) {
                this.bdT.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bO(true);
        if (this.bdX != null) {
            this.bdX.IE();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bdX != null) {
            this.bdX.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.bdX == null) {
            return null;
        }
        l lVar = new l();
        lVar.aUC = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aUD.addAll(this.bdX.getPoints());
        lVar.aUA = this.bdX.getMeasuredHeight();
        lVar.aUz = this.bdX.getMeasuredWidth();
        Rect rect = new Rect();
        this.bdX.getGlobalVisibleRect(rect);
        lVar.aUx = rect.left;
        lVar.aUy = rect.top;
        lVar.aUE = lVar.aUD.size();
        lVar.aUG = this.bdX.getGraffitiPointDesDatas();
        lVar.aUF = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aUv = screenDimensions[0];
        lVar.aUw = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdU) {
            if (this.bdX != null) {
                this.bdX.IH();
            }
        } else if (view == this.bdV) {
            this.bdV.setEnabled(false);
            this.bdU.setEnabled(false);
            bO(false);
            this.bdZ.e(0, 0L);
        } else if (view == this.bdW && this.bdY != null) {
            this.bdY.HI();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        Hy();
        JN();
        JO();
        JP();
        JQ();
        HA();
    }

    private void Hy() {
        this.bdS = findViewById(a.g.layout_title);
        this.bdT = (TextView) findViewById(a.g.tv_title);
        this.bdU = (ImageButton) findViewById(a.g.btn_revert);
        this.bdV = (ImageButton) findViewById(a.g.btn_clean);
        this.bdW = (ImageButton) findViewById(a.g.btn_hide);
        this.bdX = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void JN() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdS.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bdS.setLayoutParams(layoutParams);
        this.bdS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void JO() {
        this.bdU.setOnClickListener(this);
        this.bdU.setEnabled(false);
    }

    private void JP() {
        this.bdV.setOnClickListener(this);
        this.bdV.setEnabled(false);
    }

    private void JQ() {
        this.bdW.setOnClickListener(this);
    }

    private void HA() {
        this.bdX.setGiftDrawEventListener(this.bdZ);
        this.bdX.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR() {
        if (this.bdX != null) {
            if (this.bdX.getCurrentPointSize() > 0) {
                this.bdX.setTipImageVisibility(8);
            } else {
                this.bdX.setTipImageVisibility(0);
            }
        }
    }

    private void JS() {
        if (this.bdX != null) {
            this.bdX.IF();
            this.bdX.IG();
        }
    }

    private void bO(boolean z) {
        if (this.bdX != null) {
            this.bdX.bO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
