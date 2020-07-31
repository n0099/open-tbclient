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
import com.baidu.live.data.q;
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
/* loaded from: classes4.dex */
public class f extends Dialog implements z {
    private g aNm;
    private TextView aNn;
    private TbImageView aNo;
    private ImageView aNp;
    private TextView aNq;
    private CheckBox aNr;
    private LinearLayout aNs;
    private TextView agR;
    private q avf;
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
    public void d(q qVar) {
        this.avf = qVar;
    }

    @Override // com.baidu.live.gift.z
    public void setGiftItem(g gVar) {
        this.aNm = gVar;
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
        this.aNs = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aNo = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aNo.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aNo.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aNo.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.agR = (TextView) findViewById(a.g.quick_gift_desc);
        this.aNp = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aNq = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.v.c.Hx().bex != null) {
            this.aNo.startLoad(com.baidu.live.v.c.Hx().bex.zm(), 10, false);
            if (com.baidu.live.v.c.Hx().bex.zk() != null) {
                this.mName.setText(com.baidu.live.v.c.Hx().bex.zk().yp());
                this.agR.setText(com.baidu.live.v.c.Hx().bex.zk().yq());
                this.aNq.setText(com.baidu.live.v.c.Hx().bex.zk().getPrice());
            }
        }
        this.aNn = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aNn.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", f.this.aNm.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, f.this.aNm.yo());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, f.this.aNm.yp());
                    alaStaticItem.addParams("other_params", f.this.otherParams);
                    if (f.this.avf != null && f.this.avf.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", f.this.avf.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                n.a(f.this.mPageContext, f.this.avf, f.this.aNm, f.this.otherParams);
                if (f.this.aNr != null && f.this.aNr.isChecked()) {
                    com.baidu.live.c.vf().putBoolean("quick_gift_guide_show", false);
                }
                f.this.dismiss();
            }
        });
        this.aNr = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aNr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.f.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                f.this.bz(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aNs.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aNs.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        AD();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.aNm.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aNm.yo());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aNm.yp());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.avf != null && this.avf.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.avf.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void AD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aNs.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        if (this.aNr != null) {
            if (z) {
                this.aNr.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aNr.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
