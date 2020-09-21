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
    private TextView bjl;
    private a bmK;
    private TbImageView bmL;
    private TextView bmM;
    private View bmN;
    private DanceRectView bmO;
    private TextView bmP;
    private TextView bmQ;
    private TextView bmR;
    private TextView bmS;
    private TextView bmT;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void NA();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.bjl != null) {
            this.bjl.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bmK = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.blv) {
                setBackgroundColor(-328966);
            }
            this.bmM.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.blf)) {
                try {
                    jSONArray = new JSONArray(aVar.blf);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString("src", "");
                }
            }
            this.bmL.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bmL.getTag() instanceof String) || !this.bmL.getTag().equals(str)) {
                this.bmL.startLoad("", 10, false, false);
            }
            this.bmL.startLoad(str, 10, false, false);
            if (aVar.blv) {
                this.bmN.setVisibility(0);
                this.bmO.startAnim();
            } else {
                this.bmN.setVisibility(8);
                this.bmO.Rm();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bmP.setVisibility(0);
                this.bmP.setText(aVar.source);
            } else {
                this.bmP.setVisibility(8);
            }
            this.bmQ.setVisibility(8);
            if (this.isHost && aVar.blm > 0.0d) {
                this.bmQ.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.blm));
                this.bmQ.setVisibility(0);
            }
            try {
                this.bmR.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bmR.setText("¥" + aVar.price);
            }
            this.bmT.setVisibility(8);
            this.bmS.setVisibility(8);
            if (aVar.Nv()) {
                this.bmT.setText(aVar.blo + "元券");
                this.bmT.setVisibility(0);
            } else if (aVar.bll > 0.0d) {
                try {
                    if (aVar.bll > Double.parseDouble(aVar.price)) {
                        this.bmS.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bll));
                        this.bmS.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.blp == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.blv) {
                        this.bjl.setBackgroundResource(a.f.live_goods_bg_display_item_action_confirm);
                        this.bjl.setText("取消讲解");
                        this.bjl.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.bjl.setBackgroundResource(a.f.live_goods_bg_display_item_action_cancel);
                    this.bjl.setText("讲解");
                    this.bjl.setTextColor(getResources().getColorStateList(a.d.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.Nv()) {
                    this.bjl.setText("马上抢");
                    return;
                } else {
                    this.bjl.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.bjl.setText("已下架");
        }
    }

    public void release() {
        if (this.bmO != null) {
            this.bmO.Rm();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_goods_item, this);
        setBackgroundColor(0);
        Gg();
        initView();
    }

    private void Gg() {
        this.bmL = (TbImageView) findViewById(a.g.iv_live_goods_item_thumb);
        this.bmM = (TextView) findViewById(a.g.tv_live_goods_item_index);
        this.bmN = findViewById(a.g.layout_live_goods_item_explain);
        this.bmO = (DanceRectView) findViewById(a.g.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_live_goods_item_title);
        this.bmP = (TextView) findViewById(a.g.tv_live_goods_item_source);
        this.bmQ = (TextView) findViewById(a.g.tv_profit);
        this.bmR = (TextView) findViewById(a.g.tv_live_goods_item_price_actual);
        this.bmS = (TextView) findViewById(a.g.tv_live_goods_item_price_quoted);
        this.bmT = (TextView) findViewById(a.g.tv_live_goods_item_coupon);
        this.bjl = (TextView) findViewById(a.g.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds2), getResources().getColor(a.d.live_goods_primary));
        this.bmP.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds6));
        this.bmT.setBackgroundDrawable(gradientDrawable2);
        this.bmN.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.d.live_goods_primary), 204));
        this.bmS.getPaint().setFlags(17);
        Drawable background = this.bjl.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.d.live_goods_primary));
        this.bjl.setBackgroundDrawable(background);
        this.bjl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bmK != null) {
                    LiveGoodsDisplayItemView.this.bmK.NA();
                }
            }
        });
    }
}
