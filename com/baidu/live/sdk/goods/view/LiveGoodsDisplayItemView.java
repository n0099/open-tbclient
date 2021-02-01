package com.baidu.live.sdk.goods.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.DanceRectView;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class LiveGoodsDisplayItemView extends FrameLayout {
    private a bAH;
    private TextView bAI;
    private View bAJ;
    private DanceRectView bAK;
    private TextView bAL;
    private TextView bAM;
    private TextView bAN;
    private TextView bAO;
    private TextView bAP;
    private TbImageView beA;
    private TextView bwP;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void PV();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bwP != null) {
            this.bwP.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bAH = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bzp) {
                setBackgroundColor(-328966);
            }
            this.bAI.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.byZ)) {
                try {
                    jSONArray = new JSONArray(aVar.byZ);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC, "");
                }
            }
            this.beA.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.beA.getTag() instanceof String) || !this.beA.getTag().equals(str)) {
                this.beA.startLoad("", 10, false, false);
            }
            this.beA.startLoad(str, 10, false, false);
            if (aVar.bzp) {
                this.bAJ.setVisibility(0);
                this.bAK.startAnim();
            } else {
                this.bAJ.setVisibility(8);
                this.bAK.Xw();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bAL.setVisibility(0);
                this.bAL.setText(aVar.source);
            } else {
                this.bAL.setVisibility(8);
            }
            this.bAM.setVisibility(8);
            if (this.isHost && aVar.bzg > 0.0d) {
                this.bAM.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bzg));
                this.bAM.setVisibility(0);
            }
            try {
                this.bAN.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bAN.setText("¥" + aVar.price);
            }
            this.bAP.setVisibility(8);
            this.bAO.setVisibility(8);
            if (aVar.PQ()) {
                this.bAP.setText(aVar.bzi + "元券");
                this.bAP.setVisibility(0);
            } else if (aVar.bzf > 0.0d) {
                try {
                    if (aVar.bzf > Double.parseDouble(aVar.price)) {
                        this.bAO.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bzf));
                        this.bAO.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bzj == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bzp) {
                        this.bwP.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.bwP.setText("取消讲解");
                        this.bwP.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bwP.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.bwP.setText("讲解");
                    this.bwP.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.PQ()) {
                    this.bwP.setText("马上抢");
                    return;
                } else {
                    this.bwP.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bwP.setText("已下架");
        }
    }

    public void release() {
        if (this.bAK != null) {
            this.bAK.Xw();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        Ge();
        initView();
    }

    private void Ge() {
        this.beA = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.bAI = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.bAJ = findViewById(a.f.layout_live_goods_item_explain);
        this.bAK = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bAL = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bAM = (TextView) findViewById(a.f.tv_profit);
        this.bAN = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bAO = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bAP = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.bwP = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bAL.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bAP.setBackgroundDrawable(gradientDrawable2);
        this.bAJ.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bAO.getPaint().setFlags(17);
        Drawable background = this.bwP.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.bwP.setBackgroundDrawable(background);
        this.bwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bAH != null) {
                    LiveGoodsDisplayItemView.this.bAH.PV();
                }
            }
        });
    }
}
