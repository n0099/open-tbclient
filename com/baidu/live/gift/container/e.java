package com.baidu.live.gift.container;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
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
import com.baidu.live.data.l;
import com.baidu.live.gift.g;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class e extends Dialog {
    private l aiW;
    private g aiX;
    private TextView aiY;
    private TbImageView aiZ;
    private TextView aja;
    private ImageView ajb;
    private TextView ajc;
    private CheckBox ajd;
    private LinearLayout aje;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context, TbPageContext tbPageContext, l lVar, g gVar, String str) {
        super(context);
        this.mContext = context;
        this.mPageContext = tbPageContext;
        this.aiW = lVar;
        this.aiX = gVar;
        this.otherParams = str;
        initView();
    }

    private void initView() {
        setContentView(a.h.view_quick_gift_guide_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        resize();
        this.aje = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aiZ = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aiZ.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aiZ.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aiZ.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.aja = (TextView) findViewById(a.g.quick_gift_desc);
        this.ajb = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.ajc = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.s.c.wW().atv != null) {
            this.aiZ.startLoad(com.baidu.live.s.c.wW().atv.rv(), 10, false);
            if (com.baidu.live.s.c.wW().atv.rt() != null) {
                this.mName.setText(com.baidu.live.s.c.wW().atv.rt().qF());
                this.aja.setText(com.baidu.live.s.c.wW().atv.rt().qG());
                this.ajc.setText(com.baidu.live.s.c.wW().atv.rt().getPrice());
            }
        }
        this.aiY = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aiY.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aiY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", e.this.aiX.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.aiX.qE());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.aiX.qF());
                    alaStaticItem.addParams("other_params", e.this.otherParams);
                    if (e.this.aiW != null && e.this.aiW.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", e.this.aiW.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                com.baidu.live.gift.b.c.a(e.this.mPageContext, e.this.aiW, e.this.aiX, e.this.otherParams);
                if (e.this.ajd != null && e.this.ajd.isChecked()) {
                    com.baidu.live.c.oJ().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.ajd = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.ajd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.aJ(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aje.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aje.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        sB();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.aiX.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aiX.qE());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aiX.qF());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aiW != null && this.aiW.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aiW.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void sB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aje.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(boolean z) {
        if (this.ajd != null) {
            if (z) {
                this.ajd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.ajd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public void resize() {
        int screenWidth = com.baidu.live.gift.b.c.getScreenWidth(this.mContext);
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

    @Override // android.app.Dialog
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
}
