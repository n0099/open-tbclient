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
    public View bhJ;
    public TextView bhK;
    public ImageButton bhL;
    public ImageButton bhM;
    public ImageButton bhN;
    public AlaGiftDrawPanel caF;
    private a caG;
    private AlaGiftDrawPanel.a caH;
    private a.InterfaceC0238a cap;

    /* loaded from: classes11.dex */
    public interface a {
        void Go();

        void cW(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caH = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void h(int i, long j) {
                GiftPanelDrawContainerView.this.bhK.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
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
                if (GiftPanelDrawContainerView.this.caG != null) {
                    GiftPanelDrawContainerView.this.caG.cW(i);
                }
            }
        };
        init();
    }

    public void setGiftPanelCallback(a.InterfaceC0238a interfaceC0238a) {
        this.cap = interfaceC0238a;
    }

    public void setCallback(a aVar) {
        this.caG = aVar;
    }

    public void l(boolean z, final String str) {
        if (z) {
            if (this.caF.getVisibility() == 0) {
                IH();
            }
            IG();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.II();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.caF.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                II();
            }
            if (this.caF != null && this.caF.getCurrentPointSize() > 0) {
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
        if (this.caF != null) {
            this.caF.Hs();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.caF != null) {
            this.caF.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.caF == null) {
            return null;
        }
        k kVar = new k();
        kVar.aXl = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aXm.addAll(this.caF.getPoints());
        kVar.aXj = this.caF.getMeasuredHeight();
        kVar.aXi = this.caF.getMeasuredWidth();
        Rect rect = new Rect();
        this.caF.getGlobalVisibleRect(rect);
        kVar.aXg = rect.left;
        kVar.aXh = rect.top;
        kVar.aXn = kVar.aXm.size();
        kVar.aXp = this.caF.getGraffitiPointDesDatas();
        kVar.aXo = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aXe = screenDimensions[0];
        kVar.aXf = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bhL) {
            if (this.caF != null) {
                this.caF.Hv();
            }
        } else if (view == this.bhM) {
            this.bhM.setEnabled(false);
            this.bhL.setEnabled(false);
            ca(false);
            this.caH.h(0, 0L);
        } else if (view == this.bhN && this.caG != null) {
            this.caG.Go();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
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
        this.caF = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void IC() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bhJ.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bhJ.setLayoutParams(layoutParams);
        this.bhJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.2
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
        this.caF.setGiftDrawEventListener(this.caH);
        this.caF.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        List<AlaWheatInfoData> list = null;
        if (this.cap != null) {
            list = this.cap.YC().cbt;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void Zg() {
        if (this.caH != null && this.caF != null && this.caF.getCurrentPointSize() > 0) {
            this.caH.h(this.caF.getCurrentPointSize(), this.caF.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IG() {
        if (this.caF != null) {
            if (this.caF.getCurrentPointSize() > 0) {
                this.caF.setTipImageVisibility(8);
            } else {
                this.caF.setTipImageVisibility(0);
            }
        }
    }

    private void IH() {
        if (this.caF != null) {
            this.caF.Ht();
            this.caF.Hu();
        }
    }

    private void ca(boolean z) {
        if (this.caF != null) {
            this.caF.ca(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
