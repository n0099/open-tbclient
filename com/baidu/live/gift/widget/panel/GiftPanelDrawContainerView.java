package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View bhJ;
    public TextView bhK;
    public ImageButton bhL;
    public ImageButton bhM;
    public ImageButton bhN;
    public AlaGiftDrawPanel bhO;
    private a bhP;
    private AlaGiftDrawPanel.a bhQ;

    /* loaded from: classes11.dex */
    public interface a {
        void Go();

        void cW(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhQ = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void h(int i, long j) {
                GiftPanelDrawContainerView.this.bhK.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.IG();
                    GiftPanelDrawContainerView.this.bhK.setVisibility(8);
                    GiftPanelDrawContainerView.this.bhL.setEnabled(false);
                    GiftPanelDrawContainerView.this.bhM.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bhK.setVisibility(0);
                    GiftPanelDrawContainerView.this.bhL.setEnabled(true);
                    GiftPanelDrawContainerView.this.bhM.setEnabled(true);
                    GiftPanelDrawContainerView.this.IG();
                }
                if (GiftPanelDrawContainerView.this.bhP != null) {
                    GiftPanelDrawContainerView.this.bhP.cW(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bhP = aVar;
    }

    public void l(boolean z, final String str) {
        if (z) {
            if (this.bhO.getVisibility() == 0) {
                IH();
            }
            IG();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.II();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bhO.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                II();
            }
            if (this.bhO != null && this.bhO.getCurrentPointSize() > 0) {
                if (this.bhK != null) {
                    this.bhK.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bhK != null) {
                this.bhK.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        ca(true);
        if (this.bhO != null) {
            this.bhO.Hs();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bhO != null) {
            this.bhO.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bhO == null) {
            return null;
        }
        k kVar = new k();
        kVar.aXl = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aXm.addAll(this.bhO.getPoints());
        kVar.aXj = this.bhO.getMeasuredHeight();
        kVar.aXi = this.bhO.getMeasuredWidth();
        Rect rect = new Rect();
        this.bhO.getGlobalVisibleRect(rect);
        kVar.aXg = rect.left;
        kVar.aXh = rect.top;
        kVar.aXn = kVar.aXm.size();
        kVar.aXp = this.bhO.getGraffitiPointDesDatas();
        kVar.aXo = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aXe = screenDimensions[0];
        kVar.aXf = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bhL) {
            if (this.bhO != null) {
                this.bhO.Hv();
            }
        } else if (view == this.bhM) {
            this.bhM.setEnabled(false);
            this.bhL.setEnabled(false);
            ca(false);
            this.bhQ.h(0, 0L);
        } else if (view == this.bhN && this.bhP != null) {
            this.bhP.Go();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_draw_container, (ViewGroup) this, true);
        Ge();
        IC();
        ID();
        IE();
        IF();
        Gg();
    }

    private void Ge() {
        this.bhJ = findViewById(a.f.layout_title);
        this.bhK = (TextView) findViewById(a.f.tv_title);
        this.bhL = (ImageButton) findViewById(a.f.btn_revert);
        this.bhM = (ImageButton) findViewById(a.f.btn_clean);
        this.bhN = (ImageButton) findViewById(a.f.btn_hide);
        this.bhO = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void IC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bhJ.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bhJ.setLayoutParams(layoutParams);
        this.bhJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void ID() {
        this.bhL.setOnClickListener(this);
        this.bhL.setEnabled(false);
    }

    private void IE() {
        this.bhM.setOnClickListener(this);
        this.bhM.setEnabled(false);
    }

    private void IF() {
        this.bhN.setOnClickListener(this);
    }

    private void Gg() {
        this.bhO.setGiftDrawEventListener(this.bhQ);
        this.bhO.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IG() {
        if (this.bhO != null) {
            if (this.bhO.getCurrentPointSize() > 0) {
                this.bhO.setTipImageVisibility(8);
            } else {
                this.bhO.setTipImageVisibility(0);
            }
        }
    }

    private void IH() {
        if (this.bhO != null) {
            this.bhO.Ht();
            this.bhO.Hu();
        }
    }

    private void ca(boolean z) {
        if (this.bhO != null) {
            this.bhO.ca(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
