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
    public View bjs;
    public TextView bjt;
    public ImageButton bju;
    public ImageButton bjv;
    public ImageButton bjw;
    public AlaGiftDrawPanel bjx;
    private a bjy;
    private AlaGiftDrawPanel.a bjz;

    /* loaded from: classes11.dex */
    public interface a {
        void IT();

        void ex(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjz = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void g(int i, long j) {
                GiftPanelDrawContainerView.this.bjt.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Ll();
                    GiftPanelDrawContainerView.this.bjt.setVisibility(8);
                    GiftPanelDrawContainerView.this.bju.setEnabled(false);
                    GiftPanelDrawContainerView.this.bjv.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bjt.setVisibility(0);
                    GiftPanelDrawContainerView.this.bju.setEnabled(true);
                    GiftPanelDrawContainerView.this.bjv.setEnabled(true);
                    GiftPanelDrawContainerView.this.Ll();
                }
                if (GiftPanelDrawContainerView.this.bjy != null) {
                    GiftPanelDrawContainerView.this.bjy.ex(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bjy = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bjx.getVisibility() == 0) {
                Lm();
            }
            Ll();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Ln();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bjx.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ln();
            }
            if (this.bjx != null && this.bjx.getCurrentPointSize() > 0) {
                if (this.bjt != null) {
                    this.bjt.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bjt != null) {
                this.bjt.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bZ(true);
        if (this.bjx != null) {
            this.bjx.JX();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bjx != null) {
            this.bjx.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bjx == null) {
            return null;
        }
        k kVar = new k();
        kVar.aYT = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aYU.addAll(this.bjx.getPoints());
        kVar.aYR = this.bjx.getMeasuredHeight();
        kVar.aYQ = this.bjx.getMeasuredWidth();
        Rect rect = new Rect();
        this.bjx.getGlobalVisibleRect(rect);
        kVar.aYO = rect.left;
        kVar.aYP = rect.top;
        kVar.aYV = kVar.aYU.size();
        kVar.aYX = this.bjx.getGraffitiPointDesDatas();
        kVar.aYW = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aYM = screenDimensions[0];
        kVar.aYN = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bju) {
            if (this.bjx != null) {
                this.bjx.Ka();
            }
        } else if (view == this.bjv) {
            this.bjv.setEnabled(false);
            this.bju.setEnabled(false);
            bZ(false);
            this.bjz.g(0, 0L);
        } else if (view == this.bjw && this.bjy != null) {
            this.bjy.IT();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_draw_container, (ViewGroup) this, true);
        IJ();
        Lh();
        Li();
        Lj();
        Lk();
        IL();
    }

    private void IJ() {
        this.bjs = findViewById(a.f.layout_title);
        this.bjt = (TextView) findViewById(a.f.tv_title);
        this.bju = (ImageButton) findViewById(a.f.btn_revert);
        this.bjv = (ImageButton) findViewById(a.f.btn_clean);
        this.bjw = (ImageButton) findViewById(a.f.btn_hide);
        this.bjx = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void Lh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjs.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bjs.setLayoutParams(layoutParams);
        this.bjs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Li() {
        this.bju.setOnClickListener(this);
        this.bju.setEnabled(false);
    }

    private void Lj() {
        this.bjv.setOnClickListener(this);
        this.bjv.setEnabled(false);
    }

    private void Lk() {
        this.bjw.setOnClickListener(this);
    }

    private void IL() {
        this.bjx.setGiftDrawEventListener(this.bjz);
        this.bjx.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ll() {
        if (this.bjx != null) {
            if (this.bjx.getCurrentPointSize() > 0) {
                this.bjx.setTipImageVisibility(8);
            } else {
                this.bjx.setTipImageVisibility(0);
            }
        }
    }

    private void Lm() {
        if (this.bjx != null) {
            this.bjx.JY();
            this.bjx.JZ();
        }
    }

    private void bZ(boolean z) {
        if (this.bjx != null) {
            this.bjx.bZ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        BdUtilHelper.showToast(getContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
