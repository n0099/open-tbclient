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
    private TextView bmY;
    private View bqA;
    private DanceRectView bqB;
    private TextView bqC;
    private TextView bqD;
    private TextView bqE;
    private TextView bqF;
    private TextView bqG;
    private a bqx;
    private TbImageView bqy;
    private TextView bqz;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void OF();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bmY != null) {
            this.bmY.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bqx = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bpi) {
                setBackgroundColor(-328966);
            }
            this.bqz.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.boS)) {
                try {
                    jSONArray = new JSONArray(aVar.boS);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bqy.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bqy.getTag() instanceof String) || !this.bqy.getTag().equals(str)) {
                this.bqy.startLoad("", 10, false, false);
            }
            this.bqy.startLoad(str, 10, false, false);
            if (aVar.bpi) {
                this.bqA.setVisibility(0);
                this.bqB.startAnim();
            } else {
                this.bqA.setVisibility(8);
                this.bqB.Tf();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bqC.setVisibility(0);
                this.bqC.setText(aVar.source);
            } else {
                this.bqC.setVisibility(8);
            }
            this.bqD.setVisibility(8);
            if (this.isHost && aVar.boZ > 0.0d) {
                this.bqD.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.boZ));
                this.bqD.setVisibility(0);
            }
            try {
                this.bqE.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bqE.setText("¥" + aVar.price);
            }
            this.bqG.setVisibility(8);
            this.bqF.setVisibility(8);
            if (aVar.OA()) {
                this.bqG.setText(aVar.bpb + "元券");
                this.bqG.setVisibility(0);
            } else if (aVar.boY > 0.0d) {
                try {
                    if (aVar.boY > Double.parseDouble(aVar.price)) {
                        this.bqF.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.boY));
                        this.bqF.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bpc == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bpi) {
                        this.bmY.setBackgroundResource(a.f.live_goods_bg_display_item_action_confirm);
                        this.bmY.setText("取消讲解");
                        this.bmY.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bmY.setBackgroundResource(a.f.live_goods_bg_display_item_action_cancel);
                    this.bmY.setText("讲解");
                    this.bmY.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.OA()) {
                    this.bmY.setText("马上抢");
                    return;
                } else {
                    this.bmY.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bmY.setText("已下架");
        }
    }

    public void release() {
        if (this.bqB != null) {
            this.bqB.Tf();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_goods_item, this);
        setBackgroundColor(0);
        Hc();
        initView();
    }

    private void Hc() {
        this.bqy = (TbImageView) findViewById(a.g.iv_live_goods_item_thumb);
        this.bqz = (TextView) findViewById(a.g.tv_live_goods_item_index);
        this.bqA = findViewById(a.g.layout_live_goods_item_explain);
        this.bqB = (DanceRectView) findViewById(a.g.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_live_goods_item_title);
        this.bqC = (TextView) findViewById(a.g.tv_live_goods_item_source);
        this.bqD = (TextView) findViewById(a.g.tv_profit);
        this.bqE = (TextView) findViewById(a.g.tv_live_goods_item_price_actual);
        this.bqF = (TextView) findViewById(a.g.tv_live_goods_item_price_quoted);
        this.bqG = (TextView) findViewById(a.g.tv_live_goods_item_coupon);
        this.bmY = (TextView) findViewById(a.g.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds2), getResources().getColor(a.d.live_goods_primary));
        this.bqC.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds6));
        this.bqG.setBackgroundDrawable(gradientDrawable2);
        this.bqA.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.d.live_goods_primary), 204));
        this.bqF.getPaint().setFlags(17);
        Drawable background = this.bmY.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.d.live_goods_primary));
        this.bmY.setBackgroundDrawable(background);
        this.bmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bqx != null) {
                    LiveGoodsDisplayItemView.this.bqx.OF();
                }
            }
        });
    }
}
