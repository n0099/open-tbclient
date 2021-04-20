package com.baidu.mobads.container.util;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class CommonAlertDialog extends Dialog {
    public TextView mCloseView;
    public TextView mContinueView;
    public TextView mMessageView;
    public LinearLayout mPercentLayout;

    @SuppressLint({"ResourceAsColor"})
    public CommonAlertDialog(Context context) {
        super(context);
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(17170445);
        this.mPercentLayout = new LinearLayout(context);
        float dp2px = dp2px(context, 6.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px}, null, null));
        try {
            shapeDrawable.getPaint().setColor(Color.parseColor("#ffffff"));
        } catch (Exception unused) {
        }
        this.mPercentLayout.setBackgroundDrawable(shapeDrawable);
        this.mPercentLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.mMessageView = textView;
        textView.setText("观看完整视频可以获得额外奖励哦！");
        this.mMessageView.setTextColor(Color.parseColor("#999999"));
        this.mMessageView.setTextSize(2, 15.0f);
        this.mMessageView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dp2px2 = dp2px(context, 44.0f);
        this.mMessageView.setPadding(dp2px2, dp2px(context, 18.0f), dp2px2, dp2px(context, 18.0f));
        this.mPercentLayout.addView(this.mMessageView, 0, layoutParams);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#e0e0e0"));
        this.mPercentLayout.addView(view, 1, new LinearLayout.LayoutParams(-1, dp2px(context, 0.5f)));
        LinearLayout linearLayout = new LinearLayout(context);
        this.mPercentLayout.addView(linearLayout, 2, new LinearLayout.LayoutParams(-1, dp2px(context, 43.5f)));
        TextView textView2 = new TextView(context);
        this.mContinueView = textView2;
        textView2.setText("继续观看");
        this.mContinueView.setTextColor(Color.parseColor("#3C76FF"));
        this.mContinueView.setTextSize(2, 17.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dp2px(context, 127.5f), -1);
        this.mContinueView.setPadding(dp2px(context, 34.0f), dp2px(context, 12.7f), 0, 0);
        layoutParams2.gravity = 16;
        linearLayout.addView(this.mContinueView, 0, layoutParams2);
        View view2 = new View(context);
        view2.setBackgroundColor(Color.parseColor("#e0e0e0"));
        linearLayout.addView(view2, 1, new LinearLayout.LayoutParams(dp2px(context, 0.5f), -1));
        TextView textView3 = new TextView(context);
        this.mCloseView = textView3;
        textView3.setTextColor(Color.parseColor("#999999"));
        this.mCloseView.setTextSize(2, 17.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dp2px(context, 126.0f), -1);
        this.mCloseView.setPadding(dp2px(context, 30.5f), dp2px(context, 12.7f), 0, 0);
        linearLayout.addView(this.mCloseView, 2, layoutParams3);
        setContentView(this.mPercentLayout);
        getWindow().setLayout(dp2px(context, 285.0f), dp2px(context, 145.0f));
    }

    private int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.mCloseView.setText(str);
        this.mCloseView.setOnClickListener(onClickListener);
    }

    public void setPositiveButton(View.OnClickListener onClickListener) {
        this.mContinueView.setOnClickListener(onClickListener);
    }
}
