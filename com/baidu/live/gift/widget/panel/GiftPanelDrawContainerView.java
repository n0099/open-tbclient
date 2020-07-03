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
/* loaded from: classes3.dex */
public class GiftPanelDrawContainerView extends LinearLayout implements View.OnClickListener {
    public View aQi;
    public TextView aQj;
    public ImageButton aQk;
    public ImageButton aQl;
    public ImageButton aQm;
    public AlaGiftDrawPanel aQn;
    private a aQo;
    private AlaGiftDrawPanel.a aQp;

    /* loaded from: classes3.dex */
    public interface a {
        void ce(int i);

        void zM();
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQp = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.aQj.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.BU();
                    GiftPanelDrawContainerView.this.aQj.setVisibility(8);
                    GiftPanelDrawContainerView.this.aQk.setEnabled(false);
                    GiftPanelDrawContainerView.this.aQl.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aQj.setVisibility(0);
                    GiftPanelDrawContainerView.this.aQk.setEnabled(true);
                    GiftPanelDrawContainerView.this.aQl.setEnabled(true);
                    GiftPanelDrawContainerView.this.BU();
                }
                if (GiftPanelDrawContainerView.this.aQo != null) {
                    GiftPanelDrawContainerView.this.aQo.ce(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aQo = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.aQn.getVisibility() == 0) {
                BV();
            }
            BU();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.BW();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aQn.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                BW();
            }
            if (this.aQn != null && this.aQn.getCurrentPointSize() > 0) {
                if (this.aQj != null) {
                    this.aQj.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aQj != null) {
                this.aQj.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bA(true);
        if (this.aQn != null) {
            this.aQn.AJ();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aQn != null) {
            this.aQn.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aQn == null) {
            return null;
        }
        l lVar = new l();
        lVar.aHO = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aHP.addAll(this.aQn.getPoints());
        lVar.aHM = this.aQn.getMeasuredHeight();
        lVar.aHL = this.aQn.getMeasuredWidth();
        Rect rect = new Rect();
        this.aQn.getGlobalVisibleRect(rect);
        lVar.aHJ = rect.left;
        lVar.aHK = rect.top;
        lVar.aHQ = lVar.aHP.size();
        lVar.aHS = this.aQn.getGraffitiPointDesDatas();
        lVar.aHR = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aHH = screenDimensions[0];
        lVar.aHI = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQk) {
            if (this.aQn != null) {
                this.aQn.AM();
            }
        } else if (view == this.aQl) {
            this.aQl.setEnabled(false);
            this.aQk.setEnabled(false);
            bA(false);
            this.aQp.d(0, 0L);
        } else if (view == this.aQm && this.aQo != null) {
            this.aQo.zM();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        zB();
        BQ();
        BR();
        BS();
        BT();
        zD();
    }

    private void zB() {
        this.aQi = findViewById(a.g.layout_title);
        this.aQj = (TextView) findViewById(a.g.tv_title);
        this.aQk = (ImageButton) findViewById(a.g.btn_revert);
        this.aQl = (ImageButton) findViewById(a.g.btn_clean);
        this.aQm = (ImageButton) findViewById(a.g.btn_hide);
        this.aQn = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void BQ() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQi.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aQi.setLayoutParams(layoutParams);
        this.aQi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void BR() {
        this.aQk.setOnClickListener(this);
        this.aQk.setEnabled(false);
    }

    private void BS() {
        this.aQl.setOnClickListener(this);
        this.aQl.setEnabled(false);
    }

    private void BT() {
        this.aQm.setOnClickListener(this);
    }

    private void zD() {
        this.aQn.setGiftDrawEventListener(this.aQp);
        this.aQn.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() {
        if (this.aQn != null) {
            if (this.aQn.getCurrentPointSize() > 0) {
                this.aQn.setTipImageVisibility(8);
            } else {
                this.aQn.setTipImageVisibility(0);
            }
        }
    }

    private void BV() {
        if (this.aQn != null) {
            this.aQn.AK();
            this.aQn.AL();
        }
    }

    private void bA(boolean z) {
        if (this.aQn != null) {
            this.aQn.bA(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
