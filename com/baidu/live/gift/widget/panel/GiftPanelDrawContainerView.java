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
    public View aNC;
    public TextView aND;
    public ImageButton aNE;
    public ImageButton aNF;
    public ImageButton aNG;
    public AlaGiftDrawPanel aNH;
    private a aNI;
    private AlaGiftDrawPanel.a aNJ;

    /* loaded from: classes3.dex */
    public interface a {
        void bW(int i);

        void zm();
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNJ = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                GiftPanelDrawContainerView.this.aND.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Bu();
                    GiftPanelDrawContainerView.this.aND.setVisibility(8);
                    GiftPanelDrawContainerView.this.aNE.setEnabled(false);
                    GiftPanelDrawContainerView.this.aNF.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aND.setVisibility(0);
                    GiftPanelDrawContainerView.this.aNE.setEnabled(true);
                    GiftPanelDrawContainerView.this.aNF.setEnabled(true);
                    GiftPanelDrawContainerView.this.Bu();
                }
                if (GiftPanelDrawContainerView.this.aNI != null) {
                    GiftPanelDrawContainerView.this.aNI.bW(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aNI = aVar;
    }

    public void e(boolean z, final String str) {
        if (z) {
            if (this.aNH.getVisibility() == 0) {
                Bv();
            }
            Bu();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Bw();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aNH.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Bw();
            }
            if (this.aNH != null && this.aNH.getCurrentPointSize() > 0) {
                if (this.aND != null) {
                    this.aND.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aND != null) {
                this.aND.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bA(true);
        if (this.aNH != null) {
            this.aNH.Aj();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aNH != null) {
            this.aNH.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aNH == null) {
            return null;
        }
        l lVar = new l();
        lVar.aFs = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aFt.addAll(this.aNH.getPoints());
        lVar.aFq = this.aNH.getMeasuredHeight();
        lVar.aFp = this.aNH.getMeasuredWidth();
        Rect rect = new Rect();
        this.aNH.getGlobalVisibleRect(rect);
        lVar.aFn = rect.left;
        lVar.aFo = rect.top;
        lVar.aFu = lVar.aFt.size();
        lVar.aFw = this.aNH.getGraffitiPointDesDatas();
        lVar.aFv = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aFl = screenDimensions[0];
        lVar.aFm = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aNE) {
            if (this.aNH != null) {
                this.aNH.Am();
            }
        } else if (view == this.aNF) {
            this.aNF.setEnabled(false);
            this.aNE.setEnabled(false);
            bA(false);
            this.aNJ.c(0, 0L);
        } else if (view == this.aNG && this.aNI != null) {
            this.aNI.zm();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        zb();
        Bq();
        Br();
        Bs();
        Bt();
        zd();
    }

    private void zb() {
        this.aNC = findViewById(a.g.layout_title);
        this.aND = (TextView) findViewById(a.g.tv_title);
        this.aNE = (ImageButton) findViewById(a.g.btn_revert);
        this.aNF = (ImageButton) findViewById(a.g.btn_clean);
        this.aNG = (ImageButton) findViewById(a.g.btn_hide);
        this.aNH = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Bq() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNC.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aNC.setLayoutParams(layoutParams);
        this.aNC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Br() {
        this.aNE.setOnClickListener(this);
        this.aNE.setEnabled(false);
    }

    private void Bs() {
        this.aNF.setOnClickListener(this);
        this.aNF.setEnabled(false);
    }

    private void Bt() {
        this.aNG.setOnClickListener(this);
    }

    private void zd() {
        this.aNH.setGiftDrawEventListener(this.aNJ);
        this.aNH.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu() {
        if (this.aNH != null) {
            if (this.aNH.getCurrentPointSize() > 0) {
                this.aNH.setTipImageVisibility(8);
            } else {
                this.aNH.setTipImageVisibility(0);
            }
        }
    }

    private void Bv() {
        if (this.aNH != null) {
            this.aNH.Ak();
            this.aNH.Al();
        }
    }

    private void bA(boolean z) {
        if (this.aNH != null) {
            this.aNH.bA(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
