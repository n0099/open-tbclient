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
    private TextView bpP;
    private a btH;
    private TbImageView btI;
    private TextView btJ;
    private View btK;
    private DanceRectView btL;
    private TextView btM;
    private TextView btN;
    private TextView btO;
    private TextView btP;
    private TextView btQ;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void PD();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bpP != null) {
            this.bpP.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.btH = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bso) {
                setBackgroundColor(-328966);
            }
            this.btJ.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.brY)) {
                try {
                    jSONArray = new JSONArray(aVar.brY);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.btI.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.btI.getTag() instanceof String) || !this.btI.getTag().equals(str)) {
                this.btI.startLoad("", 10, false, false);
            }
            this.btI.startLoad(str, 10, false, false);
            if (aVar.bso) {
                this.btK.setVisibility(0);
                this.btL.startAnim();
            } else {
                this.btK.setVisibility(8);
                this.btL.WE();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.btM.setVisibility(0);
                this.btM.setText(aVar.source);
            } else {
                this.btM.setVisibility(8);
            }
            this.btN.setVisibility(8);
            if (this.isHost && aVar.bsf > 0.0d) {
                this.btN.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bsf));
                this.btN.setVisibility(0);
            }
            try {
                this.btO.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.btO.setText("¥" + aVar.price);
            }
            this.btQ.setVisibility(8);
            this.btP.setVisibility(8);
            if (aVar.Py()) {
                this.btQ.setText(aVar.bsh + "元券");
                this.btQ.setVisibility(0);
            } else if (aVar.bse > 0.0d) {
                try {
                    if (aVar.bse > Double.parseDouble(aVar.price)) {
                        this.btP.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bse));
                        this.btP.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bsi == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bso) {
                        this.bpP.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.bpP.setText("取消讲解");
                        this.bpP.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bpP.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.bpP.setText("讲解");
                    this.bpP.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.Py()) {
                    this.bpP.setText("马上抢");
                    return;
                } else {
                    this.bpP.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bpP.setText("已下架");
        }
    }

    public void release() {
        if (this.btL != null) {
            this.btL.WE();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        HZ();
        initView();
    }

    private void HZ() {
        this.btI = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.btJ = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.btK = findViewById(a.f.layout_live_goods_item_explain);
        this.btL = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.btM = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.btN = (TextView) findViewById(a.f.tv_profit);
        this.btO = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.btP = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.btQ = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.bpP = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.btM.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.btQ.setBackgroundDrawable(gradientDrawable2);
        this.btK.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.btP.getPaint().setFlags(17);
        Drawable background = this.bpP.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.bpP.setBackgroundDrawable(background);
        this.bpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.btH != null) {
                    LiveGoodsDisplayItemView.this.btH.PD();
                }
            }
        });
    }
}
