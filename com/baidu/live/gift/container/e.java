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
import com.baidu.live.data.m;
import com.baidu.live.gift.g;
import com.baidu.live.gift.n;
import com.baidu.live.gift.x;
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
public class e extends Dialog implements x {
    private m ale;
    private g alf;
    private TextView alg;
    private TbImageView alh;
    private TextView ali;
    private ImageView alj;
    private TextView alk;
    private CheckBox alm;
    private LinearLayout aln;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.x
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.x
    public void d(m mVar) {
        this.ale = mVar;
    }

    @Override // com.baidu.live.gift.x
    public void a(g gVar) {
        this.alf = gVar;
    }

    @Override // com.baidu.live.gift.x
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.gift.x
    public void initView() {
        setContentView(a.h.view_quick_gift_guide_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        resize();
        this.aln = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.alh = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.alh.setDefaultBgResource(a.f.icon_live_gift_default);
        this.alh.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.alh.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.ali = (TextView) findViewById(a.g.quick_gift_desc);
        this.alj = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.alk = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.v.c.zq().axN != null) {
            this.alh.startLoad(com.baidu.live.v.c.zq().axN.sw(), 10, false);
            if (com.baidu.live.v.c.zq().axN.su() != null) {
                this.mName.setText(com.baidu.live.v.c.zq().axN.su().ry());
                this.ali.setText(com.baidu.live.v.c.zq().axN.su().rz());
                this.alk.setText(com.baidu.live.v.c.zq().axN.su().getPrice());
            }
        }
        this.alg = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.alg.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.alg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", e.this.alf.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.alf.rx());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.alf.ry());
                    alaStaticItem.addParams("other_params", e.this.otherParams);
                    if (e.this.ale != null && e.this.ale.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", e.this.ale.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                n.a(e.this.mPageContext, e.this.ale, e.this.alf, e.this.otherParams);
                if (e.this.alm != null && e.this.alm.isChecked()) {
                    com.baidu.live.c.pr().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.alm = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.alm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.aM(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aln.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aln.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        tN();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.alf.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.alf.rx());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.alf.ry());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.ale != null && this.ale.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.ale.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void tN() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aln.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(boolean z) {
        if (this.alm != null) {
            if (z) {
                this.alm.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.alm.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.live.gift.x
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

    @Override // android.app.Dialog, com.baidu.live.gift.x
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

    @Override // android.app.Dialog, com.baidu.live.gift.x
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog, com.baidu.live.gift.x
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
