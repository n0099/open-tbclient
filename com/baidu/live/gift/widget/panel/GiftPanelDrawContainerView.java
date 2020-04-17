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
    public View aHN;
    public TextView aHO;
    public ImageButton aHP;
    public ImageButton aHQ;
    public ImageButton aHR;
    public AlaGiftDrawPanel aHS;
    private a aHT;
    private AlaGiftDrawPanel.a aHU;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(int i);

        void xX();
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHU = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                GiftPanelDrawContainerView.this.aHO.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Af();
                    GiftPanelDrawContainerView.this.aHO.setVisibility(8);
                    GiftPanelDrawContainerView.this.aHP.setEnabled(false);
                    GiftPanelDrawContainerView.this.aHQ.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aHO.setVisibility(0);
                    GiftPanelDrawContainerView.this.aHP.setEnabled(true);
                    GiftPanelDrawContainerView.this.aHQ.setEnabled(true);
                    GiftPanelDrawContainerView.this.Af();
                }
                if (GiftPanelDrawContainerView.this.aHT != null) {
                    GiftPanelDrawContainerView.this.aHT.bP(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aHT = aVar;
    }

    public void e(boolean z, final String str) {
        if (z) {
            if (this.aHS.getVisibility() == 0) {
                Ag();
            }
            Af();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Ah();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aHS.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ah();
            }
            if (this.aHS != null && this.aHS.getCurrentPointSize() > 0) {
                if (this.aHO != null) {
                    this.aHO.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aHO != null) {
                this.aHO.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        br(true);
        if (this.aHS != null) {
            this.aHS.yW();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aHS != null) {
            this.aHS.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aHS == null) {
            return null;
        }
        l lVar = new l();
        lVar.azU = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.azV.addAll(this.aHS.getPoints());
        lVar.azS = this.aHS.getMeasuredHeight();
        lVar.azR = this.aHS.getMeasuredWidth();
        Rect rect = new Rect();
        this.aHS.getGlobalVisibleRect(rect);
        lVar.azP = rect.left;
        lVar.azQ = rect.top;
        lVar.azW = lVar.azV.size();
        lVar.azY = this.aHS.getGraffitiPointDesDatas();
        lVar.azX = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.azN = screenDimensions[0];
        lVar.azO = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aHP) {
            if (this.aHS != null) {
                this.aHS.yZ();
            }
        } else if (view == this.aHQ) {
            this.aHQ.setEnabled(false);
            this.aHP.setEnabled(false);
            br(false);
            this.aHU.c(0, 0L);
        } else if (view == this.aHR && this.aHT != null) {
            this.aHT.xX();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        xO();
        Ab();
        Ac();
        Ad();
        Ae();
        xQ();
    }

    private void xO() {
        this.aHN = findViewById(a.g.layout_title);
        this.aHO = (TextView) findViewById(a.g.tv_title);
        this.aHP = (ImageButton) findViewById(a.g.btn_revert);
        this.aHQ = (ImageButton) findViewById(a.g.btn_clean);
        this.aHR = (ImageButton) findViewById(a.g.btn_hide);
        this.aHS = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Ab() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHN.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aHN.setLayoutParams(layoutParams);
        this.aHN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Ac() {
        this.aHP.setOnClickListener(this);
        this.aHP.setEnabled(false);
    }

    private void Ad() {
        this.aHQ.setOnClickListener(this);
        this.aHQ.setEnabled(false);
    }

    private void Ae() {
        this.aHR.setOnClickListener(this);
    }

    private void xQ() {
        this.aHS.setGiftDrawEventListener(this.aHU);
        this.aHS.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af() {
        if (this.aHS != null) {
            if (this.aHS.getCurrentPointSize() > 0) {
                this.aHS.setTipImageVisibility(8);
            } else {
                this.aHS.setTipImageVisibility(0);
            }
        }
    }

    private void Ag() {
        if (this.aHS != null) {
            this.aHS.yX();
            this.aHS.yY();
        }
    }

    private void br(boolean z) {
        if (this.aHS != null) {
            this.aHS.br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
