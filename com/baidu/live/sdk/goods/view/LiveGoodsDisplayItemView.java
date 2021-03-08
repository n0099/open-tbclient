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
    private a bCh;
    private TextView bCi;
    private View bCj;
    private DanceRectView bCk;
    private TextView bCl;
    private TextView bCm;
    private TextView bCn;
    private TextView bCo;
    private TextView bCp;
    private TbImageView bgc;
    private TextView byp;
    private boolean isHost;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void PY();
    }

    public LiveGoodsDisplayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setHost(boolean z) {
        this.isHost = z;
        if (this.byp != null) {
            this.byp.setClickable(z);
        }
    }

    public void setCallback(a aVar) {
        this.bCh = aVar;
    }

    public void setData(int i, com.baidu.live.sdk.goods.a.a aVar) {
        JSONArray jSONArray;
        if (aVar != null) {
            setBackgroundColor(0);
            if (aVar.bAP) {
                setBackgroundColor(-328966);
            }
            this.bCi.setText(String.valueOf(i));
            String str = "";
            if (!TextUtils.isEmpty(aVar.bAz)) {
                try {
                    jSONArray = new JSONArray(aVar.bAz);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    str = jSONArray.optJSONObject(0).optString(UserAccountActionItem.KEY_SRC, "");
                }
            }
            this.bgc.setTag(str);
            if (TextUtils.isEmpty(str) || !(this.bgc.getTag() instanceof String) || !this.bgc.getTag().equals(str)) {
                this.bgc.startLoad("", 10, false, false);
            }
            this.bgc.startLoad(str, 10, false, false);
            if (aVar.bAP) {
                this.bCj.setVisibility(0);
                this.bCk.startAnim();
            } else {
                this.bCj.setVisibility(8);
                this.bCk.Xz();
            }
            this.mTitleTextView.setText(aVar.title);
            if (!TextUtils.isEmpty(aVar.source)) {
                this.bCl.setVisibility(0);
                this.bCl.setText(aVar.source);
            } else {
                this.bCl.setVisibility(8);
            }
            this.bCm.setVisibility(8);
            if (this.isHost && aVar.bAG > 0.0d) {
                this.bCm.setText("每单赚¥" + UtilHelper.formalDecimalForTwo(aVar.bAG));
                this.bCm.setVisibility(0);
            }
            try {
                this.bCn.setText("¥" + UtilHelper.formalDecimalForTwo(Float.parseFloat(aVar.price)));
            } catch (Throwable th) {
                this.bCn.setText("¥" + aVar.price);
            }
            this.bCp.setVisibility(8);
            this.bCo.setVisibility(8);
            if (aVar.PT()) {
                this.bCp.setText(aVar.bAI + "元券");
                this.bCp.setVisibility(0);
            } else if (aVar.bAF > 0.0d) {
                try {
                    if (aVar.bAF > Double.parseDouble(aVar.price)) {
                        this.bCo.setText("¥" + UtilHelper.formalDecimalForTwo(aVar.bAF));
                        this.bCo.setVisibility(0);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aVar.bAJ == 1) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChildAt(i2).setAlpha(1.0f);
                }
                if (this.isHost) {
                    if (aVar.bAP) {
                        this.byp.setBackgroundResource(a.e.live_goods_bg_display_item_action_confirm);
                        this.byp.setText("取消讲解");
                        this.byp.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_cancel));
                        return;
                    }
                    this.byp.setBackgroundResource(a.e.live_goods_bg_display_item_action_cancel);
                    this.byp.setText("讲解");
                    this.byp.setTextColor(getResources().getColorStateList(a.c.live_goods_bg_display_item_action_text_confirm));
                    return;
                } else if (aVar.PT()) {
                    this.byp.setText("马上抢");
                    return;
                } else {
                    this.byp.setText("购买");
                    return;
                }
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).setAlpha(0.2f);
            }
            this.byp.setText("已下架");
        }
    }

    public void release() {
        if (this.bCk != null) {
            this.bCk.Xz();
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_goods_item, this);
        setBackgroundColor(0);
        Gh();
        initView();
    }

    private void Gh() {
        this.bgc = (TbImageView) findViewById(a.f.iv_live_goods_item_thumb);
        this.bCi = (TextView) findViewById(a.f.tv_live_goods_item_index);
        this.bCj = findViewById(a.f.layout_live_goods_item_explain);
        this.bCk = (DanceRectView) findViewById(a.f.drv_live_goods_item_explain);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_live_goods_item_title);
        this.bCl = (TextView) findViewById(a.f.tv_live_goods_item_source);
        this.bCm = (TextView) findViewById(a.f.tv_profit);
        this.bCn = (TextView) findViewById(a.f.tv_live_goods_item_price_actual);
        this.bCo = (TextView) findViewById(a.f.tv_live_goods_item_price_quoted);
        this.bCp = (TextView) findViewById(a.f.tv_live_goods_item_coupon);
        this.byp = (TextView) findViewById(a.f.tv_live_goods_item_action);
    }

    private void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.d.sdk_ds2), getResources().getColor(a.c.live_goods_primary));
        this.bCl.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-4640);
        gradientDrawable2.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds6));
        this.bCp.setBackgroundDrawable(gradientDrawable2);
        this.bCj.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(a.c.live_goods_primary), 204));
        this.bCo.getPaint().setFlags(17);
        Drawable background = this.byp.getBackground();
        if (!(background instanceof GradientDrawable)) {
            background = new GradientDrawable();
        }
        ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds30));
        ((GradientDrawable) background).setColor(getResources().getColor(a.c.live_goods_primary));
        this.byp.setBackgroundDrawable(background);
        this.byp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LiveGoodsDisplayItemView.this.bCh != null) {
                    LiveGoodsDisplayItemView.this.bCh.PY();
                }
            }
        });
    }
}
