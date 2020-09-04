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
/* loaded from: classes7.dex */
public class LiveGoodsDisplayItemView extends FrameLayout {
    private TextView bgu;
    private a bjR;
    private TbImageView bjS;
    private TextView bjT;
    private View bjU;
    private DanceRectView bjV;
    private TextView bjW;
    private TextView bjX;
    private TextView bjY;
    private TextView bjZ;
    private TextView bka;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes7.dex */
    public interface a {
        void MW();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bgu != null) {
            this.bgu.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bjR = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.biB) {
                setBackgroundColor(-328966);
            }
            this.bjT.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bik)) {
                try {
                    jSONArray = new JSONArray(aVar.bik);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bjS.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bjS.getTag() instanceof String) || !this.bjS.getTag().equals(str)) {
                this.bjS.startLoad("", 10, false, false);
            }
            this.bjS.startLoad(str, 10, false, false);
            if (aVar.biB) {
                this.bjU.setVisibility(0);
                this.bjV.startAnim();
            } else {
                this.bjU.setVisibility(8);
                this.bjV.QC();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bjW.setVisibility(0);
                this.bjW.setText(aVar.source);
            } else {
                this.bjW.setVisibility(8);
            }
            this.bjX.setVisibility(8);
            if (this.isHost && aVar.bis > 0.0d) {
                this.bjX.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bis));
                this.bjX.setVisibility(0);
            }
            try {
                this.bjY.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bjY.setText("¥" + aVar.price);
            }
            this.bka.setVisibility(8);
            this.bjZ.setVisibility(8);
            if (aVar.MR()) {
                this.bka.setText(aVar.biu + "元券");
                this.bka.setVisibility(0);
            } else if (aVar.bir > 0.0d) {
                try {
                    if (aVar.bir > Float.parseFloat(aVar.price)) {
                        this.bjZ.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bir));
                        this.bjZ.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.biv == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.biB) {
                        this.bgu.setBackgroundResource(a.f.live_goods_bg_display_item_action_confirm);
                        this.bgu.setText("取消讲解");
                        this.bgu.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bgu.setBackgroundResource(a.f.live_goods_bg_display_item_action_cancel);
                    this.bgu.setText("讲解");
                    this.bgu.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.MR()) {
                    this.bgu.setText("马上抢");
                    return;
                } else {
                    this.bgu.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bgu.setText("已下架");
        }
    }

    public void release() {
        if (this.bjV != null) {
            this.bjV.QC();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_goods_item, this);
        setBackgroundColor(0);
        FG();
        initView();
    }

    private void FG() {
        this.bjS = (TbImageView) findViewById(a.g.iv_live_goods_item_thumb);
        this.bjT = (TextView) findViewById(a.g.tv_live_goods_item_index);
        this.bjU = findViewById(a.g.layout_live_goods_item_explain);
        this.bjV = (DanceRectView) findViewById(a.g.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_live_goods_item_title);
        this.bjW = (TextView) findViewById(a.g.tv_live_goods_item_source);
        this.bjX = (TextView) findViewById(a.g.tv_profit);
        this.bjY = (TextView) findViewById(a.g.tv_live_goods_item_price_actual);
        this.bjZ = (TextView) findViewById(a.g.tv_live_goods_item_price_quoted);
        this.bka = (TextView) findViewById(a.g.tv_live_goods_item_coupon);
        this.bgu = (TextView) findViewById(a.g.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds2), getResources().getColor(a.d.live_goods_primary));
        this.bjW.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds6));
        this.bka.setBackgroundDrawable(gradientDrawable2);
        this.bjU.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.d.live_goods_primary), 204));
        this.bjZ.getPaint().setFlags(17);
        Drawable background = this.bgu.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.d.live_goods_primary));
        this.bgu.setBackgroundDrawable(background);
        this.bgu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bjR != null) {
                    LiveGoodsDisplayItemView.this.bjR.MW();
                }
            }
        });
    }
}
