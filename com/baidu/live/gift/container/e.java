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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.k;
import com.baidu.live.gift.g;
import com.baidu.live.q.a;
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
    private k aio;
    private g aip;
    private TextView aiq;
    private TbImageView air;
    private TextView ais;
    private ImageView ait;
    private TextView aiu;
    private CheckBox aiv;
    private LinearLayout aiw;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context, TbPageContext tbPageContext, k kVar, g gVar, String str) {
        super(context);
        this.mContext = context;
        this.mPageContext = tbPageContext;
        this.aio = kVar;
        this.aip = gVar;
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
        this.aiw = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.air = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.air.setDefaultBgResource(a.f.icon_live_gift_default);
        this.air.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.air.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.ais = (TextView) findViewById(a.g.quick_gift_desc);
        this.ait = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aiu = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.r.c.wF().asJ != null) {
            this.air.startLoad(com.baidu.live.r.c.wF().asJ.rj(), 10, false);
            if (com.baidu.live.r.c.wF().asJ.rh() != null) {
                this.mName.setText(com.baidu.live.r.c.wF().asJ.rh().qy());
                this.ais.setText(com.baidu.live.r.c.wF().asJ.rh().qz());
                this.aiu.setText(com.baidu.live.r.c.wF().asJ.rh().getPrice());
            }
        }
        this.aiq = (TextView) findViewById(a.g.quick_gift_send);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aiq.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_bd);
        }
        this.aiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                alaStaticItem.addParams("gifts_value", e.this.aip.getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.aip.qx());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.aip.qy());
                alaStaticItem.addParams("other_params", e.this.otherParams);
                if (e.this.aio != null && e.this.aio.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", e.this.aio.mLiveInfo.feed_id);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                com.baidu.live.gift.b.c.a(e.this.mPageContext, e.this.aio, e.this.aip, e.this.otherParams);
                if (e.this.aiv != null && e.this.aiv.isChecked()) {
                    com.baidu.live.c.oI().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.aiv = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aiv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.aH(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aiw.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aiw.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        sl();
        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
        alaStaticItem.addParams("gifts_value", this.aip.getPrice());
        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aip.qx());
        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aip.qy());
        alaStaticItem.addParams("other_params", this.otherParams);
        if (this.aio != null && this.aio.mLiveInfo != null) {
            alaStaticItem.addParams("feed_id", this.aio.mLiveInfo.feed_id);
        }
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void sl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aiw.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        if (this.aiv != null) {
            if (z) {
                this.aiv.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aiv.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
}
