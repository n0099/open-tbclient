package com.baidu.live.gift.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.g;
import com.baidu.live.gift.n;
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
/* loaded from: classes10.dex */
public class f extends Dialog implements ah {
    private ab aED;
    private TextView akM;
    private g bdT;
    private TextView bdU;
    private TbImageView bdV;
    private ImageView bdW;
    private TextView bdX;
    private CheckBox bdY;
    private LinearLayout bdZ;
    private Context mContext;
    private TextView mName;
    private TbPageContext mPageContext;
    private String otherParams;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.live.gift.ah
    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.gift.ah
    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    @Override // com.baidu.live.gift.ah
    public void setGiftItem(g gVar) {
        this.bdT = gVar;
    }

    @Override // com.baidu.live.gift.ah
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    @Override // com.baidu.live.gift.ah
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
        this.bdZ = (LinearLayout) findViewById(a.f.quick_gift_panel_layout);
        this.bdV = (TbImageView) findViewById(a.f.quick_gift_icon);
        this.bdV.setDefaultBgResource(a.e.icon_live_gift_default);
        this.bdV.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.bdV.setAutoChangeStyle(false);
        this.mName = (TextView) findViewById(a.f.quick_gift_name);
        this.akM = (TextView) findViewById(a.f.quick_gift_desc);
        this.bdW = (ImageView) findViewById(a.f.quick_gift_amount_icon);
        this.bdX = (TextView) findViewById(a.f.quick_gift_amount_count);
        if (com.baidu.live.ae.e.QC().bCD != null) {
            this.bdV.startLoad(com.baidu.live.ae.e.QC().bCD.EX(), 10, false);
            if (com.baidu.live.ae.e.QC().bCD.EV() != null) {
                this.mName.setText(com.baidu.live.ae.e.QC().bCD.EV().DV());
                this.akM.setText(com.baidu.live.ae.e.QC().bCD.EV().DW());
                this.bdX.setText(com.baidu.live.ae.e.QC().bCD.EV().getPrice());
            }
        }
        this.bdU = (TextView) findViewById(a.f.quick_gift_send);
        this.bdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_CLCIK);
                    alaStaticItem.addParams("gifts_value", f.this.bdT.getPrice());
                    alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, f.this.bdT.DU());
                    alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, f.this.bdT.DV());
                    alaStaticItem.addParams("other_params", f.this.otherParams);
                    if (f.this.aED != null && f.this.aED.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", f.this.aED.mLiveInfo.feed_id);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                n.a(f.this.mPageContext, f.this.aED, f.this.bdT, f.this.otherParams);
                if (f.this.bdY != null && f.this.bdY.isChecked()) {
                    com.baidu.live.d.xf().putBoolean("quick_gift_guide_show", false);
                }
                f.this.dismiss();
            }
        });
        this.bdY = (CheckBox) findViewById(a.f.quick_gift_licence);
        this.bdY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.gift.container.f.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                f.this.bW(z);
            }
        });
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.bdZ.setBackgroundResource(a.e.sdk_161823_radius20);
        } else {
            this.bdZ.setBackgroundResource(a.e.tab_scrollview_bg);
        }
        GG();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.QUICK_GIFT_DIALOG_SHOW);
            alaStaticItem.addParams("gifts_value", this.bdT.getPrice());
            alaStaticItem.addParams(SdkStaticKeys.KEY_GIFTS_ID, this.bdT.DU());
            alaStaticItem.addParams(QMStaticKeys.KEY_QM_GIFTS_NAME, this.bdT.DV());
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.aED != null && this.aED.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aED.mLiveInfo.feed_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void GG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, BdUtilHelper.dip2px(this.mContext, 200.0f), 0.0f);
        translateAnimation.setDuration(250L);
        this.bdZ.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(boolean z) {
        if (this.bdY != null) {
            if (z) {
                this.bdY.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.bdY.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    @Override // com.baidu.live.gift.ah
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

    @Override // android.app.Dialog, com.baidu.live.gift.ah
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

    @Override // android.app.Dialog, com.baidu.live.gift.ah
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog, com.baidu.live.gift.ah
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
