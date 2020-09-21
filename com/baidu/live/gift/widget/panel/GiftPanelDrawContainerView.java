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
    public View aZk;
    public TextView aZl;
    public ImageButton aZm;
    public ImageButton aZn;
    public ImageButton aZo;
    public AlaGiftDrawPanel aZp;
    private a aZq;
    private AlaGiftDrawPanel.a aZr;

    /* loaded from: classes4.dex */
    public interface a {
        void Gr();

        void ed(int i);
    }

    public GiftPanelDrawContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZr = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.3
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void d(int i, long j) {
                GiftPanelDrawContainerView.this.aZl.setText(String.format(GiftPanelDrawContainerView.this.getResources().getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i <= 0) {
                    GiftPanelDrawContainerView.this.IB();
                    GiftPanelDrawContainerView.this.aZl.setVisibility(8);
                    GiftPanelDrawContainerView.this.aZm.setEnabled(false);
                    GiftPanelDrawContainerView.this.aZn.setEnabled(false);
                } else {
                    GiftPanelDrawContainerView.this.aZl.setVisibility(0);
                    GiftPanelDrawContainerView.this.aZm.setEnabled(true);
                    GiftPanelDrawContainerView.this.aZn.setEnabled(true);
                    GiftPanelDrawContainerView.this.IB();
                }
                if (GiftPanelDrawContainerView.this.aZq != null) {
                    GiftPanelDrawContainerView.this.aZq.ed(i);
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.aZq = aVar;
    }

    public void f(boolean z, final String str) {
        if (z) {
            if (this.aZp.getVisibility() == 0) {
                IC();
            }
            IB();
            if (!TextUtils.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i) {
                        super.onLoaded((AnonymousClass1) bdImage, str2, i);
                        if (bdImage == null || bdImage.getRawBitmap() == null) {
                            GiftPanelDrawContainerView.this.ID();
                        } else if (str2 != null && str2.equals(str)) {
                            GiftPanelDrawContainerView.this.aZp.setGiftBitmp(bdImage.getRawBitmap());
                        }
                    }
                }, null);
            } else {
                ID();
            }
            if (this.aZp != null && this.aZp.getCurrentPointSize() > 0) {
                if (this.aZl != null) {
                    this.aZl.setVisibility(0);
                    return;
                }
                return;
            } else if (this.aZl != null) {
                this.aZl.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        bJ(true);
        if (this.aZp != null) {
            this.aZp.Ho();
        }
    }

    public void setGiftItem(g gVar) {
        if (this.aZp != null) {
            this.aZp.setAlaGiftItem(gVar);
        }
    }

    public l getGraffitiData() {
        if (this.aZp == null) {
            return null;
        }
        l lVar = new l();
        lVar.aQv = BdUtilHelper.dip2px(getContext().getApplicationContext(), 32.0f);
        lVar.aQw.addAll(this.aZp.getPoints());
        lVar.aQt = this.aZp.getMeasuredHeight();
        lVar.aQs = this.aZp.getMeasuredWidth();
        Rect rect = new Rect();
        this.aZp.getGlobalVisibleRect(rect);
        lVar.aQq = rect.left;
        lVar.aQr = rect.top;
        lVar.aQx = lVar.aQw.size();
        lVar.aQz = this.aZp.getGraffitiPointDesDatas();
        lVar.aQy = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext().getApplicationContext());
        lVar.aQo = screenDimensions[0];
        lVar.aQp = screenDimensions[1];
        return lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZm) {
            if (this.aZp != null) {
                this.aZp.Hr();
            }
        } else if (view == this.aZn) {
            this.aZn.setEnabled(false);
            this.aZm.setEnabled(false);
            bJ(false);
            this.aZr.d(0, 0L);
        } else if (view == this.aZo && this.aZq != null) {
            this.aZq.Gr();
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.live_gift_panel_draw_container, (ViewGroup) this, true);
        Gg();
        Ix();
        Iy();
        Iz();
        IA();
        Gi();
    }

    private void Gg() {
        this.aZk = findViewById(a.g.layout_title);
        this.aZl = (TextView) findViewById(a.g.tv_title);
        this.aZm = (ImageButton) findViewById(a.g.btn_revert);
        this.aZn = (ImageButton) findViewById(a.g.btn_clean);
        this.aZo = (ImageButton) findViewById(a.g.btn_hide);
        this.aZp = (AlaGiftDrawPanel) findViewById(a.g.panel_draw);
    }

    private void Ix() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZk.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        this.aZk.setLayoutParams(layoutParams);
        this.aZk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.widget.panel.GiftPanelDrawContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private void Iy() {
        this.aZm.setOnClickListener(this);
        this.aZm.setEnabled(false);
    }

    private void Iz() {
        this.aZn.setOnClickListener(this);
        this.aZn.setEnabled(false);
    }

    private void IA() {
        this.aZo.setOnClickListener(this);
    }

    private void Gi() {
        this.aZp.setGiftDrawEventListener(this.aZr);
        this.aZp.setGiftCountRange(10, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        if (this.aZp != null) {
            if (this.aZp.getCurrentPointSize() > 0) {
                this.aZp.setTipImageVisibility(8);
            } else {
                this.aZp.setTipImageVisibility(0);
            }
        }
    }

    private void IC() {
        if (this.aZp != null) {
            this.aZp.Hp();
            this.aZp.Hq();
        }
    }

    private void bJ(boolean z) {
        if (this.aZp != null) {
            this.aZp.bJ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        BdUtilHelper.showToast(getContext().getApplicationContext(), getResources().getString(a.i.ala_gift_noimage_tip));
    }
}
