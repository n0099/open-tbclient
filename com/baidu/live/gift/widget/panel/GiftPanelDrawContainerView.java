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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View aHT;
    public TextView aHU;
    public ImageButton aHV;
    public ImageButton aHW;
    public ImageButton aHX;
    public AlaGiftDrawPanel aHY;
    private a aHZ;
    private AlaGiftDrawPanel.a aIa;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(int i);

        void xW();
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIa = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                GiftPanelDrawContainerView.this.aHU.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Ae();
                    GiftPanelDrawContainerView.this.aHU.setVisibility(8);
                    GiftPanelDrawContainerView.this.aHV.setEnabled(false);
                    GiftPanelDrawContainerView.this.aHW.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aHU.setVisibility(0);
                    GiftPanelDrawContainerView.this.aHV.setEnabled(true);
                    GiftPanelDrawContainerView.this.aHW.setEnabled(true);
                    GiftPanelDrawContainerView.this.Ae();
                }
                if (GiftPanelDrawContainerView.this.aHZ != null) {
                    GiftPanelDrawContainerView.this.aHZ.bP(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aHZ = aVar;
    }

    public void e(boolean z, final String str) {
        if (z) {
            if (this.aHY.getVisibility() == 0) {
                Af();
            }
            Ae();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Ag();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aHY.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ag();
            }
            if (this.aHY != null && this.aHY.getCurrentPointSize() > 0) {
                if (this.aHU != null) {
                    this.aHU.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aHU != null) {
                this.aHU.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        br(true);
        if (this.aHY != null) {
            this.aHY.yV();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aHY != null) {
            this.aHY.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aHY == null) {
            return null;
        }
        l lVar = new l();
        lVar.aAa = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aAb.addAll(this.aHY.getPoints());
        lVar.azY = this.aHY.getMeasuredHeight();
        lVar.azX = this.aHY.getMeasuredWidth();
        Rect rect = new Rect();
        this.aHY.getGlobalVisibleRect(rect);
        lVar.azV = rect.left;
        lVar.azW = rect.top;
        lVar.aAc = lVar.aAb.size();
        lVar.aAe = this.aHY.getGraffitiPointDesDatas();
        lVar.aAd = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.azT = screenDimensions[0];
        lVar.azU = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aHV) {
            if (this.aHY != null) {
                this.aHY.yY();
            }
        } else if (view == this.aHW) {
            this.aHW.setEnabled(false);
            this.aHV.setEnabled(false);
            br(false);
            this.aIa.c(0, 0L);
        } else if (view == this.aHX && this.aHZ != null) {
            this.aHZ.xW();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        xN();
        Aa();
        Ab();
        Ac();
        Ad();
        xP();
    }

    private void xN() {
        this.aHT = findViewById(a.g.layout_title);
        this.aHU = (TextView) findViewById(a.g.tv_title);
        this.aHV = (ImageButton) findViewById(a.g.btn_revert);
        this.aHW = (ImageButton) findViewById(a.g.btn_clean);
        this.aHX = (ImageButton) findViewById(a.g.btn_hide);
        this.aHY = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Aa() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHT.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aHT.setLayoutParams(layoutParams);
        this.aHT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Ab() {
        this.aHV.setOnClickListener(this);
        this.aHV.setEnabled(false);
    }

    private void Ac() {
        this.aHW.setOnClickListener(this);
        this.aHW.setEnabled(false);
    }

    private void Ad() {
        this.aHX.setOnClickListener(this);
    }

    private void xP() {
        this.aHY.setGiftDrawEventListener(this.aIa);
        this.aHY.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ae() {
        if (this.aHY != null) {
            if (this.aHY.getCurrentPointSize() > 0) {
                this.aHY.setTipImageVisibility(8);
            } else {
                this.aHY.setTipImageVisibility(0);
            }
        }
    }

    private void Af() {
        if (this.aHY != null) {
            this.aHY.yW();
            this.aHY.yX();
        }
    }

    private void br(boolean z) {
        if (this.aHY != null) {
            this.aHY.br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ag() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
