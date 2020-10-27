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
    private TextView bow;
    private a bsm;
    private TbImageView bsn;
    private TextView bso;
    private View bsp;
    private DanceRectView bsq;
    private TextView bsr;
    private TextView bss;
    private TextView bst;
    private TextView bsu;
    private TextView bsv;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void Pd();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bow != null) {
            this.bow.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bsm = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bqV) {
                setBackgroundColor(-328966);
            }
            this.bso.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bqF)) {
                try {
                    jSONArray = new JSONArray(aVar.bqF);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bsn.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bsn.getTag() instanceof String) || !this.bsn.getTag().equals(str)) {
                this.bsn.startLoad("", 10, false, false);
            }
            this.bsn.startLoad(str, 10, false, false);
            if (aVar.bqV) {
                this.bsp.setVisibility(0);
                this.bsq.startAnim();
            } else {
                this.bsp.setVisibility(8);
                this.bsq.Ue();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bsr.setVisibility(0);
                this.bsr.setText(aVar.source);
            } else {
                this.bsr.setVisibility(8);
            }
            this.bss.setVisibility(8);
            if (this.isHost && aVar.bqM > 0.0d) {
                this.bss.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bqM));
                this.bss.setVisibility(0);
            }
            try {
                this.bst.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bst.setText("¥" + aVar.price);
            }
            this.bsv.setVisibility(8);
            this.bsu.setVisibility(8);
            if (aVar.OY()) {
                this.bsv.setText(aVar.bqO + "元券");
                this.bsv.setVisibility(0);
            } else if (aVar.bqL > 0.0d) {
                try {
                    if (aVar.bqL > Double.parseDouble(aVar.price)) {
                        this.bsu.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bqL));
                        this.bsu.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bqP == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bqV) {
                        this.bow.setBackgroundResource(a.f.live_goods_bg_display_item_action_confirm);
                        this.bow.setText("取消讲解");
                        this.bow.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bow.setBackgroundResource(a.f.live_goods_bg_display_item_action_cancel);
                    this.bow.setText("讲解");
                    this.bow.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.OY()) {
                    this.bow.setText("马上抢");
                    return;
                } else {
                    this.bow.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bow.setText("已下架");
        }
    }

    public void release() {
        if (this.bsq != null) {
            this.bsq.Ue();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_goods_item, this);
        setBackgroundColor(0);
        Hy();
        initView();
    }

    private void Hy() {
        this.bsn = (TbImageView) findViewById(a.g.iv_live_goods_item_thumb);
        this.bso = (TextView) findViewById(a.g.tv_live_goods_item_index);
        this.bsp = findViewById(a.g.layout_live_goods_item_explain);
        this.bsq = (DanceRectView) findViewById(a.g.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_live_goods_item_title);
        this.bsr = (TextView) findViewById(a.g.tv_live_goods_item_source);
        this.bss = (TextView) findViewById(a.g.tv_profit);
        this.bst = (TextView) findViewById(a.g.tv_live_goods_item_price_actual);
        this.bsu = (TextView) findViewById(a.g.tv_live_goods_item_price_quoted);
        this.bsv = (TextView) findViewById(a.g.tv_live_goods_item_coupon);
        this.bow = (TextView) findViewById(a.g.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds2), getResources().getColor(a.d.live_goods_primary));
        this.bsr.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds6));
        this.bsv.setBackgroundDrawable(gradientDrawable2);
        this.bsp.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.d.live_goods_primary), 204));
        this.bsu.getPaint().setFlags(17);
        Drawable background = this.bow.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.d.live_goods_primary));
        this.bow.setBackgroundDrawable(background);
        this.bow.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bsm != null) {
                    LiveGoodsDisplayItemView.this.bsm.Pd();
                }
            }
        });
    }
}
