package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public class XVideoAutoPlayOnlyWifiView extends RelativeLayout {
    public static final int BUTTON_HEIGHT = 30;
    public static final int BUTTON_WIDTH = 90;
    public static final int RADIUS_BUTTON = 7;
    public static final int TEXT_VIEW_ID = 289342983;
    public OnListener listener;

    /* loaded from: classes2.dex */
    public interface OnListener {
        void onClick();
    }

    public XVideoAutoPlayOnlyWifiView(Context context) {
        super(context);
        setBackgroundColor(-16777216);
        TextView textView = new TextView(context);
        textView.setText("正在使用非Wi-Fi网络，播放将产生流量费用");
        textView.setId(TEXT_VIEW_ID);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(textView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(context, 90), ScreenUtils.getPixel(context, 30));
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = ScreenUtils.getPixel(context, 10);
        Button button = new Button(context);
        button.setText("继续播放");
        button.setBackgroundColor(0);
        button.setTextColor(-1);
        button.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(ScreenUtils.getPixel(context, 7));
        button.setBackground(gradientDrawable);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.landingpage.XVideoAutoPlayOnlyWifiView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnListener onListener = XVideoAutoPlayOnlyWifiView.this.listener;
                if (onListener != null) {
                    onListener.onClick();
                }
            }
        });
        addView(button, layoutParams2);
    }

    public void setListener(OnListener onListener) {
        this.listener = onListener;
    }
}
