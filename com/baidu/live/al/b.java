package com.baidu.live.al;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class b {
    public static Bitmap a(Context context, String str, int i, boolean z, int i2) {
        return a(context, str, i, 0, 0, z, i2);
    }

    public static Bitmap a(Context context, String str, int i, int i2, int i3, boolean z, int i4) {
        try {
            if (i <= 0 || i > 11) {
                Log.i(">>>>>>", "l:" + i);
                return null;
            }
            View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(a.g.sdk_ala_guard_icon_compose_layout, (ViewGroup) null, false);
            View findViewById = inflate.findViewById(a.f.sdk_ala_guard_ll);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            if (i2 > 0 && i3 > 0) {
                layoutParams.width = context.getResources().getDimensionPixelOffset(i2);
                layoutParams.height = context.getResources().getDimensionPixelOffset(i3);
                findViewById.setLayoutParams(layoutParams);
            } else if (i3 > 0) {
                layoutParams.height = context.getResources().getDimensionPixelOffset(i3);
                findViewById.setLayoutParams(layoutParams);
            } else if (i2 > 0) {
                layoutParams.width = context.getResources().getDimensionPixelOffset(i2);
                findViewById.setLayoutParams(layoutParams);
            }
            TextView textView = (TextView) inflate.findViewById(a.f.sdk_ala_guard_icon);
            textView.setText(i + "");
            GradientDrawable gradientDrawable = (GradientDrawable) findViewById.getBackground();
            if (z) {
                a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_gold_bg_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_gold_bg_end_color)});
                if (i4 > 0 && i4 < 4) {
                    switch (i4) {
                        case 1:
                            textView.setBackgroundResource(a.e.ala_sdk_guard_top1_icon);
                            break;
                        case 2:
                            textView.setBackgroundResource(a.e.ala_sdk_guard_top2_icon);
                            break;
                        case 3:
                            textView.setBackgroundResource(a.e.ala_sdk_guard_top3_icon);
                            break;
                    }
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    textView.setBackgroundResource(a.e.ala_sdk_guard_gold_bg);
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_gold_text_color));
                }
                gradientDrawable.setStroke(1, Color.parseColor("#ffe900"));
            } else {
                if (i >= 1 && i <= 3) {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_end_color)});
                    textView.setBackgroundResource(a.e.ala_sdk_guard_level_bg_1_3);
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_text_color));
                } else if (i >= 4 && i <= 6) {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_bg_4_6_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_bg_4_6_end_color)});
                    textView.setBackgroundResource(a.e.ala_sdk_guard_level_bg_4_6);
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_bg_4_6_text_color));
                } else if (i >= 7 && i <= 9) {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_bg_7_9_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_bg_7_9_end_color)});
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_bg_7_9_text_color));
                    textView.setBackgroundResource(a.e.ala_sdk_guard_level_bg_7_9);
                } else if (i >= 10 && i <= 11) {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_bg_10_11_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_bg_10_11_end_color)});
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_bg_10_11_text_color));
                    textView.setBackgroundResource(a.e.ala_sdk_guard_level_bg_10_11);
                }
                gradientDrawable.setStroke(0, Color.parseColor("#ffe900"));
            }
            findViewById.setBackgroundDrawable(gradientDrawable);
            TextView textView2 = (TextView) inflate.findViewById(a.f.sdk_ala_guard_text);
            if (TextUtils.isEmpty(str)) {
                textView2.setText("真爱团");
            } else {
                textView2.setText(str);
            }
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            inflate.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(GradientDrawable gradientDrawable, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable.setColor(iArr[0]);
        }
    }
}
