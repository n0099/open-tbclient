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
    public View aRB;
    public TextView aRC;
    public ImageButton aRD;
    public ImageButton aRE;
    public ImageButton aRF;
    public AlaGiftDrawPanel aRG;
    private a aRH;
    private AlaGiftDrawPanel.a aRI;

    /* loaded from: classes4.dex */
    public interface a {
        void Ao();

        void ck(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRI = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.aRC.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Cw();
                    GiftPanelDrawContainerView.this.aRC.setVisibility(8);
                    GiftPanelDrawContainerView.this.aRD.setEnabled(false);
                    GiftPanelDrawContainerView.this.aRE.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aRC.setVisibility(0);
                    GiftPanelDrawContainerView.this.aRD.setEnabled(true);
                    GiftPanelDrawContainerView.this.aRE.setEnabled(true);
                    GiftPanelDrawContainerView.this.Cw();
                }
                if (GiftPanelDrawContainerView.this.aRH != null) {
                    GiftPanelDrawContainerView.this.aRH.ck(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aRH = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.aRG.getVisibility() == 0) {
                Cx();
            }
            Cw();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Cy();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aRG.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Cy();
            }
            if (this.aRG != null && this.aRG.getCurrentPointSize() > 0) {
                if (this.aRC != null) {
                    this.aRC.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aRC != null) {
                this.aRC.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bD(true);
        if (this.aRG != null) {
            this.aRG.Bl();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aRG != null) {
            this.aRG.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aRG == null) {
            return null;
        }
        l lVar = new l();
        lVar.aJj = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aJk.addAll(this.aRG.getPoints());
        lVar.aJh = this.aRG.getMeasuredHeight();
        lVar.aJg = this.aRG.getMeasuredWidth();
        Rect rect = new Rect();
        this.aRG.getGlobalVisibleRect(rect);
        lVar.aJe = rect.left;
        lVar.aJf = rect.top;
        lVar.aJl = lVar.aJk.size();
        lVar.aJn = this.aRG.getGraffitiPointDesDatas();
        lVar.aJm = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aJc = screenDimensions[0];
        lVar.aJd = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRD) {
            if (this.aRG != null) {
                this.aRG.Bo();
            }
        } else if (view == this.aRE) {
            this.aRE.setEnabled(false);
            this.aRD.setEnabled(false);
            bD(false);
            this.aRI.d(0, 0L);
        } else if (view == this.aRF && this.aRH != null) {
            this.aRH.Ao();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        Ad();
        Cs();
        Ct();
        Cu();
        Cv();
        Af();
    }

    private void Ad() {
        this.aRB = findViewById(a.g.layout_title);
        this.aRC = (TextView) findViewById(a.g.tv_title);
        this.aRD = (ImageButton) findViewById(a.g.btn_revert);
        this.aRE = (ImageButton) findViewById(a.g.btn_clean);
        this.aRF = (ImageButton) findViewById(a.g.btn_hide);
        this.aRG = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Cs() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aRB.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aRB.setLayoutParams(layoutParams);
        this.aRB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Ct() {
        this.aRD.setOnClickListener(this);
        this.aRD.setEnabled(false);
    }

    private void Cu() {
        this.aRE.setOnClickListener(this);
        this.aRE.setEnabled(false);
    }

    private void Cv() {
        this.aRF.setOnClickListener(this);
    }

    private void Af() {
        this.aRG.setGiftDrawEventListener(this.aRI);
        this.aRG.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        if (this.aRG != null) {
            if (this.aRG.getCurrentPointSize() > 0) {
                this.aRG.setTipImageVisibility(8);
            } else {
                this.aRG.setTipImageVisibility(0);
            }
        }
    }

    private void Cx() {
        if (this.aRG != null) {
            this.aRG.Bm();
            this.aRG.Bn();
        }
    }

    private void bD(boolean z) {
        if (this.aRG != null) {
            this.aRG.bD(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
