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
import com.baidu.live.data.i;
import com.baidu.live.gift.g;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class e extends Dialog {
    private i aaj;
    private g aak;
    private TextView aal;
    private TbImageView aam;
    private TextView aan;
    private ImageView aao;
    private TextView aap;
    private CheckBox aaq;
    private LinearLayout aar;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public e(@NonNull Context context, TbPageContext tbPageContext, i iVar, g gVar, String str) {
        super(context);
        this.mContext = context;
        this.mPageContext = tbPageContext;
        this.aaj = iVar;
        this.aak = gVar;
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
        this.aar = (LinearLayout) findViewById(a.g.quick_gift_panel_layout);
        this.aam = (TbImageView) findViewById(a.g.quick_gift_icon);
        this.aam.setDefaultBgResource(a.f.icon_live_gift_default);
        this.aam.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.aam.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.g.quick_gift_name);
        this.aan = (TextView) findViewById(a.g.quick_gift_desc);
        this.aao = (ImageView) findViewById(a.g.quick_gift_amount_icon);
        this.aap = (TextView) findViewById(a.g.quick_gift_amount_count);
        if (com.baidu.live.l.c.uH().akF != null) {
            this.aam.startLoad(com.baidu.live.l.c.uH().akF.pH(), 10, false);
            if (com.baidu.live.l.c.uH().akF.pF() != null) {
                this.mName.setText(com.baidu.live.l.c.uH().akF.pF().pd());
                this.aan.setText(com.baidu.live.l.c.uH().akF.pF().pe());
                this.aap.setText(com.baidu.live.l.c.uH().akF.pF().getPrice());
            }
        }
        this.aal = (TextView) findViewById(a.g.quick_gift_send);
        this.aal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                alaStaticItem.addParams("gifts_value", e.this.aak.getPrice());
                alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, e.this.aak.pc());
                alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, e.this.aak.pd());
                alaStaticItem.addParams("other_params", e.this.otherParams);
                if (e.this.aaj != null && e.this.aaj.mLiveInfo != null) {
                    alaStaticItem.addParams("feed_id", e.this.aaj.mLiveInfo.feed_id);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                com.baidu.live.gift.b.c.a(e.this.mPageContext, e.this.aaj, e.this.aak, e.this.otherParams);
                if (e.this.aaq != null && e.this.aaq.isChecked()) {
                    com.baidu.live.c.np().putBoolean("quick_gift_guide_show", false);
                }
                e.this.dismiss();
            }
        });
        this.aaq = (CheckBox) findViewById(a.g.quick_gift_licence);
        this.aaq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.e.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                e.this.ar(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.aar.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
        } else {
            this.aar.setBackgroundResource(a.f.tab_scrollview_bg);
        }
        qB();
        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
        alaStaticItem.addParams("gifts_value", this.aak.getPrice());
        alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.aak.pc());
        alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.aak.pd());
        alaStaticItem.addParams("other_params", this.otherParams);
        if (this.aaj != null && this.aaj.mLiveInfo != null) {
            alaStaticItem.addParams("feed_id", this.aaj.mLiveInfo.feed_id);
        }
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void qB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.aar.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(boolean z) {
        if (this.aaq != null) {
            if (z) {
                this.aaq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aaq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
