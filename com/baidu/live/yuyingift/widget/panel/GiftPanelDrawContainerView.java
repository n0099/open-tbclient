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
/* loaded from: classes10.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View bjl;
    public TextView bjm;
    public ImageButton bjn;
    public ImageButton bjo;
    public ImageButton bjp;
    private a.InterfaceC0244a cbQ;
    public AlaGiftDrawPanel ccg;
    private a cch;
    private AlaGiftDrawPanel.a cci;

    /* loaded from: classes10.dex */
    public interface a {
        void Gr();

        void cX(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cci = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void h(int i, long j) {
                GiftPanelDrawContainerView.this.bjm.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.IJ();
                    GiftPanelDrawContainerView.this.bjm.setVisibility(8);
                    GiftPanelDrawContainerView.this.bjn.setEnabled(false);
                    GiftPanelDrawContainerView.this.bjo.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bjm.setVisibility(0);
                    GiftPanelDrawContainerView.this.bjn.setEnabled(true);
                    GiftPanelDrawContainerView.this.bjo.setEnabled(true);
                    GiftPanelDrawContainerView.this.IJ();
                }
                if (GiftPanelDrawContainerView.this.cch != null) {
                    GiftPanelDrawContainerView.this.cch.cX(i);
                }
            }
        };
        init();
    }

    public void setGiftPanelCallback(a.InterfaceC0244a interfaceC0244a) {
        this.cbQ = interfaceC0244a;
    }

    public void setCallback(a aVar) {
        this.cch = aVar;
    }

    public void l(boolean z, final String str) {
        if (z) {
            if (this.ccg.getVisibility() == 0) {
                IK();
            }
            IJ();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.IL();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.ccg.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                IL();
            }
            if (this.ccg != null && this.ccg.getCurrentPointSize() > 0) {
                if (this.bjm != null) {
                    this.bjm.setVisibility(0);
                    return;
                }
                return;
            } else if (this.bjm != null) {
                this.bjm.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        ca(true);
        if (this.ccg != null) {
            this.ccg.Hv();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.ccg != null) {
            this.ccg.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.ccg == null) {
            return null;
        }
        k kVar = new k();
        kVar.aYL = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aYM.addAll(this.ccg.getPoints());
        kVar.aYJ = this.ccg.getMeasuredHeight();
        kVar.aYI = this.ccg.getMeasuredWidth();
        Rect rect = new Rect();
        this.ccg.getGlobalVisibleRect(rect);
        kVar.aYG = rect.left;
        kVar.aYH = rect.top;
        kVar.aYN = kVar.aYM.size();
        kVar.aYP = this.ccg.getGraffitiPointDesDatas();
        kVar.aYO = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aYE = screenDimensions[0];
        kVar.aYF = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bjn) {
            if (this.ccg != null) {
                this.ccg.Hy();
            }
        } else if (view == this.bjo) {
            this.bjo.setEnabled(false);
            this.bjn.setEnabled(false);
            ca(false);
            this.cci.h(0, 0L);
        } else if (view == this.bjp && this.cch != null) {
            this.cch.Gr();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
        Gh();
        IF();
        IG();
        IH();
        II();
        Gj();
    }

    private void Gh() {
        this.bjl = findViewById(a.f.layout_title);
        this.bjm = (TextView) findViewById(a.f.tv_title);
        this.bjn = (ImageButton) findViewById(a.f.btn_revert);
        this.bjo = (ImageButton) findViewById(a.f.btn_clean);
        this.bjp = (ImageButton) findViewById(a.f.btn_hide);
        this.ccg = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void IF() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjl.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.bjl.setLayoutParams(layoutParams);
        this.bjl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void IG() {
        this.bjn.setOnClickListener(this);
        this.bjn.setEnabled(false);
    }

    private void IH() {
        this.bjo.setOnClickListener(this);
        this.bjo.setEnabled(false);
    }

    private void II() {
        this.bjp.setOnClickListener(this);
    }

    private void Gj() {
        this.ccg.setGiftDrawEventListener(this.cci);
        this.ccg.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        List<AlaWheatInfoData> list = null;
        if (this.cbQ != null) {
            list = this.cbQ.YF().ccU;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void Zj() {
        if (this.cci != null && this.ccg != null && this.ccg.getCurrentPointSize() > 0) {
            this.cci.h(this.ccg.getCurrentPointSize(), this.ccg.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ() {
        if (this.ccg != null) {
            if (this.ccg.getCurrentPointSize() > 0) {
                this.ccg.setTipImageVisibility(8);
            } else {
                this.ccg.setTipImageVisibility(0);
            }
        }
    }

    private void IK() {
        if (this.ccg != null) {
            this.ccg.Hw();
            this.ccg.Hx();
        }
    }

    private void ca(boolean z) {
        if (this.ccg != null) {
            this.ccg.ca(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
