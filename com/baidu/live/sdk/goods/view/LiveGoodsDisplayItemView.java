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
/* loaded from: classes10.dex */
public class LiveGoodsDisplayItemView extends FrameLayout {
    private TbImageView bbt;
    private TextView btl;
    private a bxe;
    private TextView bxf;
    private View bxg;
    private DanceRectView bxh;
    private TextView bxi;
    private TextView bxj;
    private TextView bxk;
    private TextView bxl;
    private TextView bxm;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void Ow();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.btl != null) {
            this.btl.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bxe = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bvN) {
                setBackgroundColor(-328966);
            }
            this.bxf.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bvx)) {
                try {
                    jSONArray = new JSONArray(aVar.bvx);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC, "");
                }
            }
            this.bbt.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bbt.getTag() instanceof String) || !this.bbt.getTag().equals(str)) {
                this.bbt.startLoad("", 10, false, false);
            }
            this.bbt.startLoad(str, 10, false, false);
            if (aVar.bvN) {
                this.bxg.setVisibility(0);
                this.bxh.startAnim();
            } else {
                this.bxg.setVisibility(8);
                this.bxh.VN();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bxi.setVisibility(0);
                this.bxi.setText(aVar.source);
            } else {
                this.bxi.setVisibility(8);
            }
            this.bxj.setVisibility(8);
            if (this.isHost && aVar.bvE > 0.0d) {
                this.bxj.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bvE));
                this.bxj.setVisibility(0);
            }
            try {
                this.bxk.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bxk.setText("¥" + aVar.price);
            }
            this.bxm.setVisibility(8);
            this.bxl.setVisibility(8);
            if (aVar.Or()) {
                this.bxm.setText(aVar.bvG + "元券");
                this.bxm.setVisibility(0);
            } else if (aVar.bvD > 0.0d) {
                try {
                    if (aVar.bvD > Double.parseDouble(aVar.price)) {
                        this.bxl.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bvD));
                        this.bxl.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bvH == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bvN) {
                        this.btl.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.btl.setText("取消讲解");
                        this.btl.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.btl.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.btl.setText("讲解");
                    this.btl.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.Or()) {
                    this.btl.setText("马上抢");
                    return;
                } else {
                    this.btl.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.btl.setText("已下架");
        }
    }

    public void release() {
        if (this.bxh != null) {
            this.bxh.VN();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        EO();
        initView();
    }

    private void EO() {
        this.bbt = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.bxf = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.bxg = findViewById(a.f.layout_live_goods_item_explain);
        this.bxh = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bxi = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bxj = (TextView) findViewById(a.f.tv_profit);
        this.bxk = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bxl = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bxm = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.btl = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bxi.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bxm.setBackgroundDrawable(gradientDrawable2);
        this.bxg.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bxl.getPaint().setFlags(17);
        Drawable background = this.btl.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.btl.setBackgroundDrawable(background);
        this.btl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bxe != null) {
                    LiveGoodsDisplayItemView.this.bxe.Ow();
                }
            }
        });
    }
}
