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
    public AlaGiftDrawPanel bWD;
    private a bWE;
    private AlaGiftDrawPanel.a bWF;
    private a.InterfaceC0237a bWn;
    public View beB;
    public TextView beC;
    public ImageButton beD;
    public ImageButton beE;
    public ImageButton beF;

    /* loaded from: classes10.dex */
    public interface a {
        void EY();

        void cR(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWF = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void g(int i, long j) {
                GiftPanelDrawContainerView.this.beC.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.Hq();
                    GiftPanelDrawContainerView.this.beC.setVisibility(8);
                    GiftPanelDrawContainerView.this.beD.setEnabled(false);
                    GiftPanelDrawContainerView.this.beE.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.beC.setVisibility(0);
                    GiftPanelDrawContainerView.this.beD.setEnabled(true);
                    GiftPanelDrawContainerView.this.beE.setEnabled(true);
                    GiftPanelDrawContainerView.this.Hq();
                }
                if (GiftPanelDrawContainerView.this.bWE != null) {
                    GiftPanelDrawContainerView.this.bWE.cR(i);
                }
            }
        };
        init();
    }

    public void setGiftPanelCallback(a.InterfaceC0237a interfaceC0237a) {
        this.bWn = interfaceC0237a;
    }

    public void setCallback(a aVar) {
        this.bWE = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bWD.getVisibility() == 0) {
                Hr();
            }
            Hq();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.Hs();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bWD.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                Hs();
            }
            if (this.bWD != null && this.bWD.getCurrentPointSize() > 0) {
                if (this.beC != null) {
                    this.beC.setVisibility(0);
                    return;
                }
                return;
            } else if (this.beC != null) {
                this.beC.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bV(true);
        if (this.bWD != null) {
            this.bWD.Gc();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bWD != null) {
            this.bWD.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bWD == null) {
            return null;
        }
        k kVar = new k();
        kVar.aUg = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aUh.addAll(this.bWD.getPoints());
        kVar.aUe = this.bWD.getMeasuredHeight();
        kVar.aUd = this.bWD.getMeasuredWidth();
        Rect rect = new Rect();
        this.bWD.getGlobalVisibleRect(rect);
        kVar.aUb = rect.left;
        kVar.aUc = rect.top;
        kVar.aUi = kVar.aUh.size();
        kVar.aUk = this.bWD.getGraffitiPointDesDatas();
        kVar.aUj = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aTZ = screenDimensions[0];
        kVar.aUa = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.beD) {
            if (this.bWD != null) {
                this.bWD.Gf();
            }
        } else if (view == this.beE) {
            this.beE.setEnabled(false);
            this.beD.setEnabled(false);
            bV(false);
            this.bWF.g(0, 0L);
        } else if (view == this.beF && this.bWE != null) {
            this.bWE.EY();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
        EO();
        Hm();
        Hn();
        Ho();
        Hp();
        EQ();
    }

    private void EO() {
        this.beB = findViewById(a.f.layout_title);
        this.beC = (TextView) findViewById(a.f.tv_title);
        this.beD = (ImageButton) findViewById(a.f.btn_revert);
        this.beE = (ImageButton) findViewById(a.f.btn_clean);
        this.beF = (ImageButton) findViewById(a.f.btn_hide);
        this.bWD = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void Hm() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beB.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.d.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.beB.setLayoutParams(layoutParams);
        this.beB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Hn() {
        this.beD.setOnClickListener(this);
        this.beD.setEnabled(false);
    }

    private void Ho() {
        this.beE.setOnClickListener(this);
        this.beE.setEnabled(false);
    }

    private void Hp() {
        this.beF.setOnClickListener(this);
    }

    private void EQ() {
        this.bWD.setGiftDrawEventListener(this.bWF);
        this.bWD.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        List<AlaWheatInfoData> list = null;
        if (this.bWn != null) {
            list = this.bWn.WM().bXq;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void Xq() {
        if (this.bWF != null && this.bWD != null && this.bWD.getCurrentPointSize() > 0) {
            this.bWF.g(this.bWD.getCurrentPointSize(), this.bWD.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq() {
        if (this.bWD != null) {
            if (this.bWD.getCurrentPointSize() > 0) {
                this.bWD.setTipImageVisibility(8);
            } else {
                this.bWD.setTipImageVisibility(0);
            }
        }
    }

    private void Hr() {
        if (this.bWD != null) {
            this.bWD.Gd();
            this.bWD.Ge();
        }
    }

    private void bV(boolean z) {
        if (this.bWD != null) {
            this.bWD.bV(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hs() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
