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
    public View bcE;
    public TextView bcF;
    public ImageButton bcG;
    public ImageButton bcH;
    public ImageButton bcI;
    public AlaGiftDrawPanel bcJ;
    private a bcK;
    private AlaGiftDrawPanel.a bcL;

    /* loaded from: classes4.dex */
    public interface a {
        void Hn();

        void ei(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcL = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void e(int i, long j) {
                GiftPanelDrawContainerView.this.bcF.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Jy();
                    GiftPanelDrawContainerView.this.bcF.setVisibility(8);
                    GiftPanelDrawContainerView.this.bcG.setEnabled(false);
                    GiftPanelDrawContainerView.this.bcH.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bcF.setVisibility(0);
                    GiftPanelDrawContainerView.this.bcG.setEnabled(true);
                    GiftPanelDrawContainerView.this.bcH.setEnabled(true);
                    GiftPanelDrawContainerView.this.Jy();
                }
                if (GiftPanelDrawContainerView.this.bcK != null) {
                    GiftPanelDrawContainerView.this.bcK.ei(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bcK = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.bcJ.getVisibility() == 0) {
                Jz();
            }
            Jy();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.JA();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bcJ.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                JA();
            }
            if (this.bcJ != null && this.bcJ.getCurrentPointSize() > 0) {
                if (this.bcF != null) {
                    this.bcF.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bcF != null) {
                this.bcF.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bN(true);
        if (this.bcJ != null) {
            this.bcJ.Il();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bcJ != null) {
            this.bcJ.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.bcJ == null) {
            return null;
        }
        l lVar = new l();
        lVar.aTG = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aTH.addAll(this.bcJ.getPoints());
        lVar.aTE = this.bcJ.getMeasuredHeight();
        lVar.aTD = this.bcJ.getMeasuredWidth();
        Rect rect = new Rect();
        this.bcJ.getGlobalVisibleRect(rect);
        lVar.aTB = rect.left;
        lVar.aTC = rect.top;
        lVar.aTI = lVar.aTH.size();
        lVar.aTK = this.bcJ.getGraffitiPointDesDatas();
        lVar.aTJ = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aTz = screenDimensions[0];
        lVar.aTA = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcG) {
            if (this.bcJ != null) {
                this.bcJ.Io();
            }
        } else if (view == this.bcH) {
            this.bcH.setEnabled(false);
            this.bcG.setEnabled(false);
            bN(false);
            this.bcL.e(0, 0L);
        } else if (view == this.bcI && this.bcK != null) {
            this.bcK.Hn();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        Hc();
        Ju();
        Jv();
        Jw();
        Jx();
        He();
    }

    private void Hc() {
        this.bcE = findViewById(a.g.layout_title);
        this.bcF = (TextView) findViewById(a.g.tv_title);
        this.bcG = (ImageButton) findViewById(a.g.btn_revert);
        this.bcH = (ImageButton) findViewById(a.g.btn_clean);
        this.bcI = (ImageButton) findViewById(a.g.btn_hide);
        this.bcJ = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Ju() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcE.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bcE.setLayoutParams(layoutParams);
        this.bcE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Jv() {
        this.bcG.setOnClickListener(this);
        this.bcG.setEnabled(false);
    }

    private void Jw() {
        this.bcH.setOnClickListener(this);
        this.bcH.setEnabled(false);
    }

    private void Jx() {
        this.bcI.setOnClickListener(this);
    }

    private void He() {
        this.bcJ.setGiftDrawEventListener(this.bcL);
        this.bcJ.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        if (this.bcJ != null) {
            if (this.bcJ.getCurrentPointSize() > 0) {
                this.bcJ.setTipImageVisibility(8);
            } else {
                this.bcJ.setTipImageVisibility(0);
            }
        }
    }

    private void Jz() {
        if (this.bcJ != null) {
            this.bcJ.Im();
            this.bcJ.In();
        }
    }

    private void bN(boolean z) {
        if (this.bcJ != null) {
            this.bcJ.bN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
