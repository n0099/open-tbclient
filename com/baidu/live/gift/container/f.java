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
import com.baidu.live.data.r;
import com.baidu.live.gift.g;
import com.baidu.live.gift.n;
import com.baidu.live.gift.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class f extends Dialog implements z {
    private r aAh;
    private TextView aSA;
    private TbImageView aSB;
    private ImageView aSC;
    private TextView aSD;
    private CheckBox aSE;
    private LinearLayout aSF;
    private g aSz;
    private TextView aia;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.z
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.z
    public void d(r rVar) {
        this.aAh = rVar;
    }

    @Override // com.baidu.live.gift.z
    public void setGiftItem(g gVar) {
        this.aSz = gVar;
    }

    @Override // com.baidu.live.gift.z
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.gift.z
    public void initView() {
        setContentView(a.h.view_quick_gift_guide_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        resize();
        this.aSF = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aSB = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aSB.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aSB.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aSB.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.aia = (TextView) findViewById(a.g.quick_gift_desc);
        this.aSC = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aSD = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.w.c.Np().bki != null) {
            this.aSB.startLoad(com.baidu.live.w.c.Np().bki.EP(), 10, false);
            if (com.baidu.live.w.c.Np().bki.EN() != null) {
                this.mName.setText(com.baidu.live.w.c.Np().bki.EN().DS());
                this.aia.setText(com.baidu.live.w.c.Np().bki.EN().DT());
                this.aSD.setText(com.baidu.live.w.c.Np().bki.EN().getPrice());
            }
        }
        this.aSA = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aSA.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", f.this.aSz.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, f.this.aSz.DR());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, f.this.aSz.DS());
                    alaStaticItem.addParams("other_params", f.this.otherParams);
                    if (f.this.aAh != null && f.this.aAh.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", f.this.aAh.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                n.a(f.this.mPageContext, f.this.aAh, f.this.aSz, f.this.otherParams);
                if (f.this.aSE != null && f.this.aSE.isChecked()) {
                    com.baidu.live.c.AD().putBoolean("quick_gift_guide_show", false);
                }
                f.this.dismiss();
            }
        });
        this.aSE = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aSE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.f.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                f.this.bE(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aSF.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aSF.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        Gg();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.aSz.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aSz.DR());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aSz.DS());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aAh != null && this.aAh.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aAh.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void Gg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aSF.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (this.aSE != null) {
            if (z) {
                this.aSE.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSE.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.live.gift.z
    public void resize() {
        int screenWidth = n.getScreenWidth(this.mContext);
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

    @Override // android.app.Dialog, com.baidu.live.gift.z
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

    @Override // android.app.Dialog, com.baidu.live.gift.z
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog, com.baidu.live.gift.z
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
