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
    public View aWO;
    public TextView aWP;
    public ImageButton aWQ;
    public ImageButton aWR;
    public ImageButton aWS;
    public AlaGiftDrawPanel aWT;
    private a aWU;
    private AlaGiftDrawPanel.a aWV;

    /* loaded from: classes7.dex */
    public interface a {
        void FR();

        void dZ(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWV = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.aWP.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.HZ();
                    GiftPanelDrawContainerView.this.aWP.setVisibility(8);
                    GiftPanelDrawContainerView.this.aWQ.setEnabled(false);
                    GiftPanelDrawContainerView.this.aWR.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aWP.setVisibility(0);
                    GiftPanelDrawContainerView.this.aWQ.setEnabled(true);
                    GiftPanelDrawContainerView.this.aWR.setEnabled(true);
                    GiftPanelDrawContainerView.this.HZ();
                }
                if (GiftPanelDrawContainerView.this.aWU != null) {
                    GiftPanelDrawContainerView.this.aWU.dZ(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aWU = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.aWT.getVisibility() == 0) {
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
                            GiftPanelDrawContainerView.this.aWT.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ib();
            }
            if (this.aWT != null && this.aWT.getCurrentPointSize() > 0) {
                if (this.aWP != null) {
                    this.aWP.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aWP != null) {
                this.aWP.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bI(true);
        if (this.aWT != null) {
            this.aWT.GO();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aWT != null) {
            this.aWT.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aWT == null) {
            return null;
        }
        l lVar = new l();
        lVar.aOu = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aOv.addAll(this.aWT.getPoints());
        lVar.aOs = this.aWT.getMeasuredHeight();
        lVar.aOr = this.aWT.getMeasuredWidth();
        Rect rect = new Rect();
        this.aWT.getGlobalVisibleRect(rect);
        lVar.aOp = rect.left;
        lVar.aOq = rect.top;
        lVar.aOw = lVar.aOv.size();
        lVar.aOy = this.aWT.getGraffitiPointDesDatas();
        lVar.aOx = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aOn = screenDimensions[0];
        lVar.aOo = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aWQ) {
            if (this.aWT != null) {
                this.aWT.GR();
            }
        } else if (view == this.aWR) {
            this.aWR.setEnabled(false);
            this.aWQ.setEnabled(false);
            bI(false);
            this.aWV.d(0, 0L);
        } else if (view == this.aWS && this.aWU != null) {
            this.aWU.FR();
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
        this.aWO = findViewById(a.g.layout_title);
        this.aWP = (TextView) findViewById(a.g.tv_title);
        this.aWQ = (ImageButton) findViewById(a.g.btn_revert);
        this.aWR = (ImageButton) findViewById(a.g.btn_clean);
        this.aWS = (ImageButton) findViewById(a.g.btn_hide);
        this.aWT = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void HV() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWO.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aWO.setLayoutParams(layoutParams);
        this.aWO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void HW() {
        this.aWQ.setOnClickListener(this);
        this.aWQ.setEnabled(false);
    }

    private void HX() {
        this.aWR.setOnClickListener(this);
        this.aWR.setEnabled(false);
    }

    private void HY() {
        this.aWS.setOnClickListener(this);
    }

    private void FI() {
        this.aWT.setGiftDrawEventListener(this.aWV);
        this.aWT.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ() {
        if (this.aWT != null) {
            if (this.aWT.getCurrentPointSize() > 0) {
                this.aWT.setTipImageVisibility(8);
            } else {
                this.aWT.setTipImageVisibility(0);
            }
        }
    }

    private void Ia() {
        if (this.aWT != null) {
            this.aWT.GP();
            this.aWT.GQ();
        }
    }

    private void bI(boolean z) {
        if (this.aWT != null) {
            this.aWT.bI(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
