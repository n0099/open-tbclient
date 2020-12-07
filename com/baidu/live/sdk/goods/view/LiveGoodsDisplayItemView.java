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
    private TbImageView bey;
    private TextView btm;
    private a bxf;
    private TextView bxg;
    private View bxh;
    private DanceRectView bxi;
    private TextView bxj;
    private TextView bxk;
    private TextView bxl;
    private TextView bxm;
    private TextView bxn;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void Ro();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.btm != null) {
            this.btm.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bxf = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bvO) {
                setBackgroundColor(-328966);
            }
            this.bxg.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bvy)) {
                try {
                    jSONArray = new JSONArray(aVar.bvy);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bey.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bey.getTag() instanceof String) || !this.bey.getTag().equals(str)) {
                this.bey.startLoad("", 10, false, false);
            }
            this.bey.startLoad(str, 10, false, false);
            if (aVar.bvO) {
                this.bxh.setVisibility(0);
                this.bxi.startAnim();
            } else {
                this.bxh.setVisibility(8);
                this.bxi.Yv();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bxj.setVisibility(0);
                this.bxj.setText(aVar.source);
            } else {
                this.bxj.setVisibility(8);
            }
            this.bxk.setVisibility(8);
            if (this.isHost && aVar.bvF > 0.0d) {
                this.bxk.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bvF));
                this.bxk.setVisibility(0);
            }
            try {
                this.bxl.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bxl.setText("¥" + aVar.price);
            }
            this.bxn.setVisibility(8);
            this.bxm.setVisibility(8);
            if (aVar.Rj()) {
                this.bxn.setText(aVar.bvH + "元券");
                this.bxn.setVisibility(0);
            } else if (aVar.bvE > 0.0d) {
                try {
                    if (aVar.bvE > Double.parseDouble(aVar.price)) {
                        this.bxm.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bvE));
                        this.bxm.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bvI == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bvO) {
                        this.btm.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.btm.setText("取消讲解");
                        this.btm.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.btm.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.btm.setText("讲解");
                    this.btm.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.Rj()) {
                    this.btm.setText("马上抢");
                    return;
                } else {
                    this.btm.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.btm.setText("已下架");
        }
    }

    public void release() {
        if (this.bxi != null) {
            this.bxi.Yv();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        Jh();
        initView();
    }

    private void Jh() {
        this.bey = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.bxg = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.bxh = findViewById(a.f.layout_live_goods_item_explain);
        this.bxi = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bxj = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bxk = (TextView) findViewById(a.f.tv_profit);
        this.bxl = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bxm = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bxn = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.btm = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bxj.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bxn.setBackgroundDrawable(gradientDrawable2);
        this.bxh.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bxm.getPaint().setFlags(17);
        Drawable background = this.btm.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.btm.setBackgroundDrawable(background);
        this.btm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bxf != null) {
                    LiveGoodsDisplayItemView.this.bxf.Ro();
                }
            }
        });
    }
}
