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
public class e extends Dialog implements z {
    private q aJj;
    private g aJk;
    private TextView aJl;
    private TbImageView aJm;
    private TextView aJn;
    private ImageView aJo;
    private TextView aJp;
    private CheckBox aJq;
    private LinearLayout aJr;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.z
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.z
    public void d(q qVar) {
        this.aJj = qVar;
    }

    @Override // com.baidu.live.gift.z
    public void setGiftItem(g gVar) {
        this.aJk = gVar;
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
        this.aJr = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aJm = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aJm.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aJm.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aJm.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.aJn = (TextView) findViewById(a.g.quick_gift_desc);
        this.aJo = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aJp = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.v.c.Gj().aYX != null) {
            this.aJm.startLoad(com.baidu.live.v.c.Gj().aYX.yk(), 10, false);
            if (com.baidu.live.v.c.Gj().aYX.yi() != null) {
                this.mName.setText(com.baidu.live.v.c.Gj().aYX.yi().xm());
                this.aJn.setText(com.baidu.live.v.c.Gj().aYX.yi().xn());
                this.aJp.setText(com.baidu.live.v.c.Gj().aYX.yi().getPrice());
            }
        }
        this.aJl = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aJl.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", e.this.aJk.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.aJk.xl());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.aJk.xm());
                    alaStaticItem.addParams("other_params", e.this.otherParams);
                    if (e.this.aJj != null && e.this.aJj.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", e.this.aJj.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                n.a(e.this.mPageContext, e.this.aJj, e.this.aJk, e.this.otherParams);
                if (e.this.aJq != null && e.this.aJq.isChecked()) {
                    com.baidu.live.c.uN().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.aJq = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aJq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.bw(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aJr.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aJr.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        zB();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.aJk.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aJk.xl());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aJk.xm());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aJj != null && this.aJj.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aJj.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void zB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aJr.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (this.aJq != null) {
            if (z) {
                this.aJq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aJq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
