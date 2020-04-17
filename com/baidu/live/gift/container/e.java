package com.baidu.live.gift.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.n;
import com.baidu.live.gift.g;
import com.baidu.live.gift.y;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends Dialog implements y {
    private n aDE;
    private g aDF;
    private TextView aDG;
    private TbImageView aDH;
    private TextView aDI;
    private ImageView aDJ;
    private TextView aDK;
    private CheckBox aDL;
    private LinearLayout aDM;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.y
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.y
    public void d(n nVar) {
        this.aDE = nVar;
    }

    @Override // com.baidu.live.gift.y
    public void setGiftItem(g gVar) {
        this.aDF = gVar;
    }

    @Override // com.baidu.live.gift.y
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.gift.y
    public void initView() {
        setContentView(a.h.view_quick_gift_guide_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        resize();
        this.aDM = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aDH = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aDH.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aDH.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aDH.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.aDI = (TextView) findViewById(a.g.quick_gift_desc);
        this.aDJ = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aDK = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.v.c.Et().aRE != null) {
            this.aDH.startLoad(com.baidu.live.v.c.Et().aRE.wU(), 10, false);
            if (com.baidu.live.v.c.Et().aRE.wS() != null) {
                this.mName.setText(com.baidu.live.v.c.Et().aRE.wS().vW());
                this.aDI.setText(com.baidu.live.v.c.Et().aRE.wS().vX());
                this.aDK.setText(com.baidu.live.v.c.Et().aRE.wS().getPrice());
            }
        }
        this.aDG = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aDG.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", e.this.aDF.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.aDF.vV());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.aDF.vW());
                    alaStaticItem.addParams("other_params", e.this.otherParams);
                    if (e.this.aDE != null && e.this.aDE.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", e.this.aDE.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                com.baidu.live.gift.n.a(e.this.mPageContext, e.this.aDE, e.this.aDF, e.this.otherParams);
                if (e.this.aDL != null && e.this.aDL.isChecked()) {
                    com.baidu.live.c.tH().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.aDL = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aDL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.bo(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aDM.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aDM.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        ym();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.aDF.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aDF.vV());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aDF.vW());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aDE != null && this.aDE.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aDE.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void ym() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aDM.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (this.aDL != null) {
            if (z) {
                this.aDL.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aDL.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.live.gift.y
    public void resize() {
        int screenWidth = com.baidu.live.gift.n.getScreenWidth(this.mContext);
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            getWindow().setGravity(17);
            attributes.width = realScreenHeight;
        } else {
            getWindow().setGravity(81);
            attributes.width = screenWidth;
        }
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Dialog, com.baidu.live.gift.y
    public void show() {
        super.show();
        ShowUtil.windowCount++;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (ShowUtil.windowCount > 0) {
            ShowUtil.windowCount--;
        }
    }

    @Override // android.app.Dialog, com.baidu.live.gift.y
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog, com.baidu.live.gift.y
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
