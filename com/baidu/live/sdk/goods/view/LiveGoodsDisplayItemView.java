package com.baidu.live.sdk.goods.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.DanceRectView;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class LiveGoodsDisplayItemView extends FrameLayout {
    private TextView boe;
    private a brV;
    private TbImageView brW;
    private TextView brX;
    private View brY;
    private DanceRectView brZ;
    private TextView bsa;
    private TextView bsb;
    private TextView bsc;
    private TextView bsd;
    private TextView bse;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void OU();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.boe != null) {
            this.boe.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.brV = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bqD) {
                setBackgroundColor(-328966);
            }
            this.brX.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bqn)) {
                try {
                    jSONArray = new JSONArray(aVar.bqn);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.brW.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.brW.getTag() instanceof String) || !this.brW.getTag().equals(str)) {
                this.brW.startLoad("", 10, false, false);
            }
            this.brW.startLoad(str, 10, false, false);
            if (aVar.bqD) {
                this.brY.setVisibility(0);
                this.brZ.startAnim();
            } else {
                this.brY.setVisibility(8);
                this.brZ.VV();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bsa.setVisibility(0);
                this.bsa.setText(aVar.source);
            } else {
                this.bsa.setVisibility(8);
            }
            this.bsb.setVisibility(8);
            if (this.isHost && aVar.bqu > 0.0d) {
                this.bsb.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bqu));
                this.bsb.setVisibility(0);
            }
            try {
                this.bsc.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bsc.setText("¥" + aVar.price);
            }
            this.bse.setVisibility(8);
            this.bsd.setVisibility(8);
            if (aVar.OP()) {
                this.bse.setText(aVar.bqw + "元券");
                this.bse.setVisibility(0);
            } else if (aVar.bqt > 0.0d) {
                try {
                    if (aVar.bqt > Double.parseDouble(aVar.price)) {
                        this.bsd.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bqt));
                        this.bsd.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bqx == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bqD) {
                        this.boe.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.boe.setText("取消讲解");
                        this.boe.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.boe.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.boe.setText("讲解");
                    this.boe.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.OP()) {
                    this.boe.setText("马上抢");
                    return;
                } else {
                    this.boe.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.boe.setText("已下架");
        }
    }

    public void release() {
        if (this.brZ != null) {
            this.brZ.VV();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        Hq();
        initView();
    }

    private void Hq() {
        this.brW = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.brX = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.brY = findViewById(a.f.layout_live_goods_item_explain);
        this.brZ = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bsa = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bsb = (TextView) findViewById(a.f.tv_profit);
        this.bsc = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bsd = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bse = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.boe = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bsa.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bse.setBackgroundDrawable(gradientDrawable2);
        this.brY.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bsd.getPaint().setFlags(17);
        Drawable background = this.boe.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.boe.setBackgroundDrawable(background);
        this.boe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.brV != null) {
                    LiveGoodsDisplayItemView.this.brV.OU();
                }
            }
        });
    }
}
