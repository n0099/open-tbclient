package com.baidu.live.yuyingift.widget.panel;

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
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel;
import com.baidu.live.yuyingift.panel.a;
import java.util.List;
/* loaded from: classes11.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View bjs;
    public TextView bjt;
    public ImageButton bju;
    public ImageButton bjv;
    public ImageButton bjw;
    private a.InterfaceC0246a caZ;
    public AlaGiftDrawPanel cbp;
    private a cbq;
    private AlaGiftDrawPanel.a cbr;

    /* loaded from: classes11.dex */
    public interface a {
        void IT();

        void ex(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbr = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void g(int i, long j) {
                GiftPanelDrawContainerView.this.bjt.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
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
                if (GiftPanelDrawContainerView.this.cbq != null) {
                    GiftPanelDrawContainerView.this.cbq.ex(i);
                }
            }
        };
        init();
    }

    public void setGiftPanelCallback(a.InterfaceC0246a interfaceC0246a) {
        this.caZ = interfaceC0246a;
    }

    public void setCallback(a aVar) {
        this.cbq = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.cbp.getVisibility() == 0) {
                Lm();
            }
            Ll();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Ln();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.cbp.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Ln();
            }
            if (this.cbp != null && this.cbp.getCurrentPointSize() > 0) {
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
        if (this.cbp != null) {
            this.cbp.JX();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.cbp != null) {
            this.cbp.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.cbp == null) {
            return null;
        }
        k kVar = new k();
        kVar.aYT = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aYU.addAll(this.cbp.getPoints());
        kVar.aYR = this.cbp.getMeasuredHeight();
        kVar.aYQ = this.cbp.getMeasuredWidth();
        Rect rect = new Rect();
        this.cbp.getGlobalVisibleRect(rect);
        kVar.aYO = rect.left;
        kVar.aYP = rect.top;
        kVar.aYV = kVar.aYU.size();
        kVar.aYX = this.cbp.getGraffitiPointDesDatas();
        kVar.aYW = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aYM = screenDimensions[0];
        kVar.aYN = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bju) {
            if (this.cbp != null) {
                this.cbp.Ka();
            }
        } else if (view == this.bjv) {
            this.bjv.setEnabled(false);
            this.bju.setEnabled(false);
            bZ(false);
            this.cbr.g(0, 0L);
        } else if (view == this.bjw && this.cbq != null) {
            this.cbq.IT();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
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
        this.cbp = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void Lh() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjs.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bjs.setLayoutParams(layoutParams);
        this.bjs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.2
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
        this.cbp.setGiftDrawEventListener(this.cbr);
        this.cbp.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        List<AlaWheatInfoData> list = null;
        if (this.caZ != null) {
            list = this.caZ.aaF().ccd;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void abj() {
        if (this.cbr != null && this.cbp != null && this.cbp.getCurrentPointSize() > 0) {
            this.cbr.g(this.cbp.getCurrentPointSize(), this.cbp.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ll() {
        if (this.cbp != null) {
            if (this.cbp.getCurrentPointSize() > 0) {
                this.cbp.setTipImageVisibility(8);
            } else {
                this.cbp.setTipImageVisibility(0);
            }
        }
    }

    private void Lm() {
        if (this.cbp != null) {
            this.cbp.JY();
            this.cbp.JZ();
        }
    }

    private void bZ(boolean z) {
        if (this.cbp != null) {
            this.cbp.bZ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
