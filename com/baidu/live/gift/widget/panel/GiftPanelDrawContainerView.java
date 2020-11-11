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
    public View bfo;
    public TextView bfp;
    public ImageButton bfq;
    public ImageButton bfr;
    public ImageButton bft;
    public AlaGiftDrawPanel bfu;
    private a bfv;
    private AlaGiftDrawPanel.a bfw;

    /* loaded from: classes4.dex */
    public interface a {
        void Ij();

        void ej(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfw = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.bfp.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Kr();
                    GiftPanelDrawContainerView.this.bfp.setVisibility(8);
                    GiftPanelDrawContainerView.this.bfq.setEnabled(false);
                    GiftPanelDrawContainerView.this.bfr.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bfp.setVisibility(0);
                    GiftPanelDrawContainerView.this.bfq.setEnabled(true);
                    GiftPanelDrawContainerView.this.bfr.setEnabled(true);
                    GiftPanelDrawContainerView.this.Kr();
                }
                if (GiftPanelDrawContainerView.this.bfv != null) {
                    GiftPanelDrawContainerView.this.bfv.ej(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bfv = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bfu.getVisibility() == 0) {
                Ks();
            }
            Kr();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Kt();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bfu.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Kt();
            }
            if (this.bfu != null && this.bfu.getCurrentPointSize() > 0) {
                if (this.bfp != null) {
                    this.bfp.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bfp != null) {
                this.bfp.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bP(true);
        if (this.bfu != null) {
            this.bfu.Jf();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bfu != null) {
            this.bfu.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bfu == null) {
            return null;
        }
        k kVar = new k();
        kVar.aVU = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aVV.addAll(this.bfu.getPoints());
        kVar.aVS = this.bfu.getMeasuredHeight();
        kVar.aVR = this.bfu.getMeasuredWidth();
        Rect rect = new Rect();
        this.bfu.getGlobalVisibleRect(rect);
        kVar.aVP = rect.left;
        kVar.aVQ = rect.top;
        kVar.aVW = kVar.aVV.size();
        kVar.aVY = this.bfu.getGraffitiPointDesDatas();
        kVar.aVX = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aVN = screenDimensions[0];
        kVar.aVO = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bfq) {
            if (this.bfu != null) {
                this.bfu.Ji();
            }
        } else if (view == this.bfr) {
            this.bfr.setEnabled(false);
            this.bfq.setEnabled(false);
            bP(false);
            this.bfw.d(0, 0L);
        } else if (view == this.bft && this.bfv != null) {
            this.bfv.Ij();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_draw_container, (ViewGroup) this, true);
        HZ();
        Kn();
        Ko();
        Kp();
        Kq();
        Ib();
    }

    private void HZ() {
        this.bfo = findViewById(a.f.layout_title);
        this.bfp = (TextView) findViewById(a.f.tv_title);
        this.bfq = (ImageButton) findViewById(a.f.btn_revert);
        this.bfr = (ImageButton) findViewById(a.f.btn_clean);
        this.bft = (ImageButton) findViewById(a.f.btn_hide);
        this.bfu = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void Kn() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bfo.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bfo.setLayoutParams(layoutParams);
        this.bfo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Ko() {
        this.bfq.setOnClickListener(this);
        this.bfq.setEnabled(false);
    }

    private void Kp() {
        this.bfr.setOnClickListener(this);
        this.bfr.setEnabled(false);
    }

    private void Kq() {
        this.bft.setOnClickListener(this);
    }

    private void Ib() {
        this.bfu.setGiftDrawEventListener(this.bfw);
        this.bfu.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
        if (this.bfu != null) {
            if (this.bfu.getCurrentPointSize() > 0) {
                this.bfu.setTipImageVisibility(8);
            } else {
                this.bfu.setTipImageVisibility(0);
            }
        }
    }

    private void Ks() {
        if (this.bfu != null) {
            this.bfu.Jg();
            this.bfu.Jh();
        }
    }

    private void bP(boolean z) {
        if (this.bfu != null) {
            this.bfu.bP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
