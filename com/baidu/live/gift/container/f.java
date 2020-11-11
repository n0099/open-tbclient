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
import com.baidu.live.data.w;
import com.baidu.live.gift.af;
import com.baidu.live.gift.g;
import com.baidu.live.gift.m;
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
/* loaded from: classes4.dex */
public class f extends Dialog implements af {
    private w aES;
    private TextView aiQ;
    private g baH;
    private TextView baI;
    private TbImageView baJ;
    private ImageView baK;
    private TextView baL;
    private CheckBox baM;
    private LinearLayout baN;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.af
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.af
    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    @Override // com.baidu.live.gift.af
    public void setGiftItem(g gVar) {
        this.baH = gVar;
    }

    @Override // com.baidu.live.gift.af
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.gift.af
    public void initView() {
        try {
            View findViewById = findViewById(getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
            if (findViewById != null) {
                findViewById.setBackgroundColor(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(a.g.view_quick_gift_guide_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        resize();
        this.baN = (LinearLayout) findViewById(a.f.quick_gift_panel_layout);
        this.baJ = (TbImageView) findViewById(a.f.quick_gift_icon);
        this.baJ.setDefaultBgResource(a.e.icon_live_gift_default);
        this.baJ.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.baJ.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.f.quick_gift_name);
        this.aiQ = (TextView) findViewById(a.f.quick_gift_desc);
        this.baK = (ImageView) findViewById(a.f.quick_gift_amount_icon);
        this.baL = (TextView) findViewById(a.f.quick_gift_amount_count);
        if (com.baidu.live.aa.e.Qe().bue != null) {
            this.baJ.startLoad(com.baidu.live.aa.e.Qe().bue.GS(), 10, false);
            if (com.baidu.live.aa.e.Qe().bue.GQ() != null) {
                this.mName.setText(com.baidu.live.aa.e.Qe().bue.GQ().FU());
                this.aiQ.setText(com.baidu.live.aa.e.Qe().bue.GQ().FV());
                this.baL.setText(com.baidu.live.aa.e.Qe().bue.GQ().getPrice());
            }
        }
        this.baI = (TextView) findViewById(a.f.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.baI.setBackgroundResource(a.e.ala_live_follow_btn_radius_40_selector_bd);
        }
        this.baI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", f.this.baH.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, f.this.baH.FT());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, f.this.baH.FU());
                    alaStaticItem.addParams("other_params", f.this.otherParams);
                    if (f.this.aES != null && f.this.aES.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", f.this.aES.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                m.a(f.this.mPageContext, f.this.aES, f.this.baH, f.this.otherParams);
                if (f.this.baM != null && f.this.baM.isChecked()) {
                    com.baidu.live.d.AZ().putBoolean("quick_gift_guide_show", false);
                }
                f.this.dismiss();
            }
        });
        this.baM = (CheckBox) findViewById(a.f.quick_gift_licence);
        this.baM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.f.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                f.this.bM(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.baN.setBackgroundResource(a.e.sdk_161823_radius20);
        } else {
            this.baN.setBackgroundResource(a.e.tab_scrollview_bg);
        }
        Iy();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.baH.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.baH.FT());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.baH.FU());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aES != null && this.aES.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aES.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void Iy() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.baN.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (this.baM != null) {
            if (z) {
                this.baM.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.baM.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.live.gift.af
    public void resize() {
        int screenWidth = m.getScreenWidth(this.mContext);
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

    @Override // android.app.Dialog, com.baidu.live.gift.af
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

    @Override // android.app.Dialog, com.baidu.live.gift.af
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog, com.baidu.live.gift.af
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
