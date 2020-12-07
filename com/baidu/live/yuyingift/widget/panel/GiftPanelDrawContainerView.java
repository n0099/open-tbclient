package com.baidu.live.yuyingift.widget.panel;

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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes4.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public AlaGiftDrawPanel bVp;
    private a bVq;
    private AlaGiftDrawPanel.a bVr;
    public View bhJ;
    public TextView bhK;
    public ImageButton bhL;
    public ImageButton bhM;
    public ImageButton bhN;

    /* loaded from: classes4.dex */
    public interface a {
        void Jr();

        void ez(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVr = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.yuyingift.graffitigift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.bhK.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.h.ala_gift_draw_title_drawing), Long.valueOf(GiftPanelDrawContainerView.this.getSelectWheatsCount() * j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.LM();
                    GiftPanelDrawContainerView.this.bhK.setVisibility(8);
                    GiftPanelDrawContainerView.this.bhL.setEnabled(false);
                    GiftPanelDrawContainerView.this.bhM.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.bhK.setVisibility(0);
                    GiftPanelDrawContainerView.this.bhL.setEnabled(true);
                    GiftPanelDrawContainerView.this.bhM.setEnabled(true);
                    GiftPanelDrawContainerView.this.LM();
                }
                if (GiftPanelDrawContainerView.this.bVq != null) {
                    GiftPanelDrawContainerView.this.bVq.ez(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bVq = aVar;
    }

    public void h(boolean z, final String str) {
        if (z) {
            if (this.bVp.getVisibility() == 0) {
                LN();
            }
            LM();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.LO();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.bVp.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                LO();
            }
            if (this.bVp != null && this.bVp.getCurrentPointSize() > 0) {
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
        if (this.bVp != null) {
            this.bVp.Kw();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.bVp != null) {
            this.bVp.setAlaGiftItem(gVar);
        }
    }

    public k getGraffitiData() {
        if (this.bVp == null) {
            return null;
        }
        k kVar = new k();
        kVar.aXo = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        kVar.aXp.addAll(this.bVp.getPoints());
        kVar.aXm = this.bVp.getMeasuredHeight();
        kVar.aXl = this.bVp.getMeasuredWidth();
        Rect rect = new Rect();
        this.bVp.getGlobalVisibleRect(rect);
        kVar.aXj = rect.left;
        kVar.aXk = rect.top;
        kVar.aXq = kVar.aXp.size();
        kVar.aXs = this.bVp.getGraffitiPointDesDatas();
        kVar.aXr = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        kVar.aXh = screenDimensions[0];
        kVar.aXi = screenDimensions[1];
        return kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bhL) {
            if (this.bVp != null) {
                this.bVp.Kz();
            }
        } else if (view == this.bhM) {
            this.bhM.setEnabled(false);
            this.bhL.setEnabled(false);
            ca(false);
            this.bVr.d(0, 0L);
        } else if (view == this.bhN && this.bVq != null) {
            this.bVq.Jr();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_live_gift_panel_draw_container, (ViewGroup) this, true);
        Jh();
        LI();
        LJ();
        LK();
        LL();
        Jj();
    }

    private void Jh() {
        this.bhJ = findViewById(a.f.layout_title);
        this.bhK = (TextView) findViewById(a.f.tv_title);
        this.bhL = (ImageButton) findViewById(a.f.btn_revert);
        this.bhM = (ImageButton) findViewById(a.f.btn_clean);
        this.bhN = (ImageButton) findViewById(a.f.btn_hide);
        this.bVp = (AlaGiftDrawPanel) findViewById(a.f.panel_draw);
    }

    private void LI() {
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

    private void LJ() {
        this.bhL.setOnClickListener(this);
        this.bhL.setEnabled(false);
    }

    private void LK() {
        this.bhM.setOnClickListener(this);
        this.bhM.setEnabled(false);
    }

    private void LL() {
        this.bhN.setOnClickListener(this);
    }

    private void Jj() {
        this.bVp.setGiftDrawEventListener(this.bVr);
        this.bVp.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectWheatsCount() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501048, a.InterfaceC0246a.class);
        List<AlaWheatInfoData> list = null;
        if (runTask != null && runTask.getData() != null) {
            list = ((a.InterfaceC0246a) runTask.getData()).Zp().bVX;
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void ZE() {
        if (this.bVr != null && this.bVp != null && this.bVp.getCurrentPointSize() > 0) {
            this.bVr.d(this.bVp.getCurrentPointSize(), this.bVp.getTotalPrice());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LM() {
        if (this.bVp != null) {
            if (this.bVp.getCurrentPointSize() > 0) {
                this.bVp.setTipImageVisibility(8);
            } else {
                this.bVp.setTipImageVisibility(0);
            }
        }
    }

    private void LN() {
        if (this.bVp != null) {
            this.bVp.Kx();
            this.bVp.Ky();
        }
    }

    private void ca(boolean z) {
        if (this.bVp != null) {
            this.bVp.ca(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LO() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.h.ala_gift_noimage_tip));
    }
}
