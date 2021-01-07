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
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class LiveGoodsDisplayItemView extends FrameLayout {
    private a bBQ;
    private TextView bBR;
    private View bBS;
    private DanceRectView bBT;
    private TextView bBU;
    private TextView bBV;
    private TextView bBW;
    private TextView bBX;
    private TextView bBY;
    private TbImageView bgj;
    private TextView bxZ;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void Sr();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bxZ != null) {
            this.bxZ.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bBQ = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bAz) {
                setBackgroundColor(-328966);
            }
            this.bBR.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bAj)) {
                try {
                    jSONArray = new JSONArray(aVar.bAj);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bgj.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bgj.getTag() instanceof String) || !this.bgj.getTag().equals(str)) {
                this.bgj.startLoad("", 10, false, false);
            }
            this.bgj.startLoad(str, 10, false, false);
            if (aVar.bAz) {
                this.bBS.setVisibility(0);
                this.bBT.startAnim();
            } else {
                this.bBS.setVisibility(8);
                this.bBT.ZG();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bBU.setVisibility(0);
                this.bBU.setText(aVar.source);
            } else {
                this.bBU.setVisibility(8);
            }
            this.bBV.setVisibility(8);
            if (this.isHost && aVar.bAq > 0.0d) {
                this.bBV.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bAq));
                this.bBV.setVisibility(0);
            }
            try {
                this.bBW.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bBW.setText("¥" + aVar.price);
            }
            this.bBY.setVisibility(8);
            this.bBX.setVisibility(8);
            if (aVar.Sm()) {
                this.bBY.setText(aVar.bAs + "元券");
                this.bBY.setVisibility(0);
            } else if (aVar.bAp > 0.0d) {
                try {
                    if (aVar.bAp > Double.parseDouble(aVar.price)) {
                        this.bBX.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bAp));
                        this.bBX.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bAt == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bAz) {
                        this.bxZ.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.bxZ.setText("取消讲解");
                        this.bxZ.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bxZ.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.bxZ.setText("讲解");
                    this.bxZ.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.Sm()) {
                    this.bxZ.setText("马上抢");
                    return;
                } else {
                    this.bxZ.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bxZ.setText("已下架");
        }
    }

    public void release() {
        if (this.bBT != null) {
            this.bBT.ZG();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        IJ();
        initView();
    }

    private void IJ() {
        this.bgj = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.bBR = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.bBS = findViewById(a.f.layout_live_goods_item_explain);
        this.bBT = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bBU = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bBV = (TextView) findViewById(a.f.tv_profit);
        this.bBW = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bBX = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bBY = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.bxZ = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bBU.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bBY.setBackgroundDrawable(gradientDrawable2);
        this.bBS.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bBX.getPaint().setFlags(17);
        Drawable background = this.bxZ.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.bxZ.setBackgroundDrawable(background);
        this.bxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bBQ != null) {
                    LiveGoodsDisplayItemView.this.bBQ.Sr();
                }
            }
        });
    }
}
