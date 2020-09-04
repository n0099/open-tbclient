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
/* loaded from: classes7.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View aWQ;
    public TextView aWR;
    public ImageButton aWS;
    public ImageButton aWT;
    public ImageButton aWU;
    public AlaGiftDrawPanel aWV;
    private a aWW;
    private AlaGiftDrawPanel.a aWX;

    /* loaded from: classes7.dex */
    public interface a {
        void FR();

        void dZ(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWX = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.aWR.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.HZ();
                    GiftPanelDrawContainerView.this.aWR.setVisibility(8);
                    GiftPanelDrawContainerView.this.aWS.setEnabled(false);
                    GiftPanelDrawContainerView.this.aWT.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aWR.setVisibility(0);
                    GiftPanelDrawContainerView.this.aWS.setEnabled(true);
                    GiftPanelDrawContainerView.this.aWT.setEnabled(true);
                    GiftPanelDrawContainerView.this.HZ();
                }
                if (GiftPanelDrawContainerView.this.aWW != null) {
                    GiftPanelDrawContainerView.this.aWW.dZ(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aWW = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.aWV.getVisibility() == 0) {
                Ia();
            }
            HZ();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Ib();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aWV.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ib();
            }
            if (this.aWV != null && this.aWV.getCurrentPointSize() > 0) {
                if (this.aWR != null) {
                    this.aWR.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aWR != null) {
                this.aWR.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bI(true);
        if (this.aWV != null) {
            this.aWV.GO();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aWV != null) {
            this.aWV.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aWV == null) {
            return null;
        }
        l lVar = new l();
        lVar.aOw = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aOx.addAll(this.aWV.getPoints());
        lVar.aOu = this.aWV.getMeasuredHeight();
        lVar.aOt = this.aWV.getMeasuredWidth();
        Rect rect = new Rect();
        this.aWV.getGlobalVisibleRect(rect);
        lVar.aOr = rect.left;
        lVar.aOs = rect.top;
        lVar.aOy = lVar.aOx.size();
        lVar.aOA = this.aWV.getGraffitiPointDesDatas();
        lVar.aOz = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aOp = screenDimensions[0];
        lVar.aOq = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aWS) {
            if (this.aWV != null) {
                this.aWV.GR();
            }
        } else if (view == this.aWT) {
            this.aWT.setEnabled(false);
            this.aWS.setEnabled(false);
            bI(false);
            this.aWX.d(0, 0L);
        } else if (view == this.aWU && this.aWW != null) {
            this.aWW.FR();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        FG();
        HV();
        HW();
        HX();
        HY();
        FI();
    }

    private void FG() {
        this.aWQ = findViewById(a.g.layout_title);
        this.aWR = (TextView) findViewById(a.g.tv_title);
        this.aWS = (ImageButton) findViewById(a.g.btn_revert);
        this.aWT = (ImageButton) findViewById(a.g.btn_clean);
        this.aWU = (ImageButton) findViewById(a.g.btn_hide);
        this.aWV = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void HV() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWQ.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aWQ.setLayoutParams(layoutParams);
        this.aWQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void HW() {
        this.aWS.setOnClickListener(this);
        this.aWS.setEnabled(false);
    }

    private void HX() {
        this.aWT.setOnClickListener(this);
        this.aWT.setEnabled(false);
    }

    private void HY() {
        this.aWU.setOnClickListener(this);
    }

    private void FI() {
        this.aWV.setGiftDrawEventListener(this.aWX);
        this.aWV.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ() {
        if (this.aWV != null) {
            if (this.aWV.getCurrentPointSize() > 0) {
                this.aWV.setTipImageVisibility(8);
            } else {
                this.aWV.setTipImageVisibility(0);
            }
        }
    }

    private void Ia() {
        if (this.aWV != null) {
            this.aWV.GP();
            this.aWV.GQ();
        }
    }

    private void bI(boolean z) {
        if (this.aWV != null) {
            this.aWV.bI(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
