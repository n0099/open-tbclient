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
    private TextView bgr;
    private a bjO;
    private TbImageView bjP;
    private TextView bjQ;
    private View bjR;
    private DanceRectView bjS;
    private TextView bjT;
    private TextView bjU;
    private TextView bjV;
    private TextView bjW;
    private TextView bjX;
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
        if (this.bgr != null) {
            this.bgr.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bjO = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.biy) {
                setBackgroundColor(-328966);
            }
            this.bjQ.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bih)) {
                try {
                    jSONArray = new JSONArray(aVar.bih);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bjP.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bjP.getTag() instanceof String) || !this.bjP.getTag().equals(str)) {
                this.bjP.startLoad("", 10, false, false);
            }
            this.bjP.startLoad(str, 10, false, false);
            if (aVar.biy) {
                this.bjR.setVisibility(0);
                this.bjS.startAnim();
            } else {
                this.bjR.setVisibility(8);
                this.bjS.QC();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bjT.setVisibility(0);
                this.bjT.setText(aVar.source);
            } else {
                this.bjT.setVisibility(8);
            }
            this.bjU.setVisibility(8);
            if (this.isHost && aVar.bip > 0.0d) {
                this.bjU.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bip));
                this.bjU.setVisibility(0);
            }
            try {
                this.bjV.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bjV.setText("¥" + aVar.price);
            }
            this.bjX.setVisibility(8);
            this.bjW.setVisibility(8);
            if (aVar.MR()) {
                this.bjX.setText(aVar.bir + "元券");
                this.bjX.setVisibility(0);
            } else if (aVar.bin > 0.0d) {
                try {
                    if (aVar.bin > Float.parseFloat(aVar.price)) {
                        this.bjW.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bin));
                        this.bjW.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bis == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.biy) {
                        this.bgr.setBackgroundResource(a.f.live_goods_bg_display_item_action_confirm);
                        this.bgr.setText("取消讲解");
                        this.bgr.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bgr.setBackgroundResource(a.f.live_goods_bg_display_item_action_cancel);
                    this.bgr.setText("讲解");
                    this.bgr.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.MR()) {
                    this.bgr.setText("马上抢");
                    return;
                } else {
                    this.bgr.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bgr.setText("已下架");
        }
    }

    public void release() {
        if (this.bjS != null) {
            this.bjS.QC();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_goods_item, this);
        setBackgroundColor(0);
        FG();
        initView();
    }

    private void FG() {
        this.bjP = (TbImageView) findViewById(a.g.iv_live_goods_item_thumb);
        this.bjQ = (TextView) findViewById(a.g.tv_live_goods_item_index);
        this.bjR = findViewById(a.g.layout_live_goods_item_explain);
        this.bjS = (DanceRectView) findViewById(a.g.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_live_goods_item_title);
        this.bjT = (TextView) findViewById(a.g.tv_live_goods_item_source);
        this.bjU = (TextView) findViewById(a.g.tv_profit);
        this.bjV = (TextView) findViewById(a.g.tv_live_goods_item_price_actual);
        this.bjW = (TextView) findViewById(a.g.tv_live_goods_item_price_quoted);
        this.bjX = (TextView) findViewById(a.g.tv_live_goods_item_coupon);
        this.bgr = (TextView) findViewById(a.g.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds2), getResources().getColor(a.d.live_goods_primary));
        this.bjT.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds6));
        this.bjX.setBackgroundDrawable(gradientDrawable2);
        this.bjR.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.d.live_goods_primary), 204));
        this.bjW.getPaint().setFlags(17);
        Drawable background = this.bgr.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.d.live_goods_primary));
        this.bgr.setBackgroundDrawable(background);
        this.bgr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bjO != null) {
                    LiveGoodsDisplayItemView.this.bjO.MW();
                }
            }
        });
    }
}
