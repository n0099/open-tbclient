package com.baidu.live.aj;

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.k;
import com.baidu.live.data.m;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class b {
    public static Bitmap a(Context context, String str, int i, boolean z, int i2) {
        return a(context, str, i, 0, 0, z, i2);
    }

    public static Bitmap a(Context context, String str, int i, int i2, int i3, boolean z, int i4) {
        try {
            if (i <= 0) {
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
            ImageView imageView = (ImageView) inflate.findViewById(a.f.sdk_ala_guard_icon_img);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView.getLayoutParams();
            textView.setText(i + "");
            TextView textView2 = (TextView) inflate.findViewById(a.f.sdk_ala_guard_text);
            GradientDrawable gradientDrawable = (GradientDrawable) findViewById.getBackground();
            if (z) {
                textView2.setTextColor(context.getResources().getColor(a.c.sdk_color_guard_name_gold_text));
                if (com.baidu.live.ae.a.Qj().bAS.aQa == null || com.baidu.live.ae.a.Qj().bAS.aQa.cB(i) == null) {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_color_guard_bd_gold_start), context.getResources().getColor(a.c.sdk_color_guard_bd_gold_mid), context.getResources().getColor(a.c.sdk_color_guard_bd_gold_end)});
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_color_guard_level_gold_text));
                    gradientDrawable.setStroke(1, context.getResources().getColor(a.c.sdk_color_guard_border_gold_text));
                    if (i >= 16) {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, 1.0f), 0, 0);
                    } else {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, -1.0f), 0, 0);
                    }
                } else {
                    m.a cB = com.baidu.live.ae.a.Qj().bAS.aQa.cB(i);
                    int[] iArr = new int[3];
                    iArr[0] = Color.parseColor(cB.Bq() == null ? "#F9B34A" : cB.Bq());
                    iArr[1] = Color.parseColor(cB.Bt() == null ? "#FFEDAC" : cB.Bt());
                    iArr[2] = Color.parseColor(cB.Br() == null ? "#E69111" : cB.Br());
                    a(gradientDrawable, iArr);
                    textView.setTextColor(Color.parseColor(cB.Bs() == null ? "#E45E00" : cB.Bs()));
                    gradientDrawable.setStroke(1, Color.parseColor(cB.Bu() == null ? "#FFE8A7" : cB.Bu()));
                    if (cB.Bp() != null) {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, Integer.parseInt(cB.Bp())), 0, 0);
                    }
                }
                if (i4 > 0 && i4 < 4) {
                    m mVar = com.baidu.live.ae.a.Qj().bAS.aQb;
                    if (mVar != null) {
                        m.a cB2 = mVar.cB(i4);
                        int[] iArr2 = new int[3];
                        iArr2[0] = Color.parseColor(cB2.Bq() == null ? "#F9B34A" : cB2.Bq());
                        iArr2[1] = Color.parseColor(cB2.Bt() == null ? "#FFEDAC" : cB2.Bt());
                        iArr2[2] = Color.parseColor(cB2.Br() == null ? "#E69111" : cB2.Br());
                        a(gradientDrawable, iArr2);
                        textView.setTextColor(Color.parseColor(cB2.Bs() == null ? "#E45E00" : cB2.Bs()));
                        gradientDrawable.setStroke(1, Color.parseColor(cB2.Bu() == null ? "#FFE8A7" : cB2.Bu()));
                        if (cB2.Bp() != null) {
                            layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, Integer.parseInt(cB2.Bp())), 0, 0);
                        }
                    }
                    switch (i4) {
                        case 1:
                            imageView.setImageResource(a.e.ala_sdk_guard_top1_icon);
                            break;
                        case 2:
                            imageView.setImageResource(a.e.ala_sdk_guard_top2_icon);
                            break;
                        case 3:
                            imageView.setImageResource(a.e.ala_sdk_guard_top3_icon);
                            break;
                    }
                } else if (i >= 1 && i <= 3) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_1_3);
                } else if (i >= 4 && i <= 6) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_4_6);
                } else if (i >= 7 && i <= 9) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_7_9);
                } else if (i >= 10 && i <= 12) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_10_12);
                } else if (i >= 13 && i <= 15) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_13_15);
                } else if (i >= 16 && i <= 18) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_16_18);
                } else if (i >= 19) {
                    imageView.setImageResource(a.e.ala_sdk_guard_gold_icon_19_20);
                }
                gradientDrawable.setStroke(1, Color.parseColor("#ffe900"));
            } else {
                textView2.setTextColor(context.getResources().getColor(a.c.sdk_white_alpha100));
                if (com.baidu.live.ae.a.Qj().bAS.aPZ != null && com.baidu.live.ae.a.Qj().bAS.aPZ.cz(i) != null) {
                    k.a cz = com.baidu.live.ae.a.Qj().bAS.aPZ.cz(i);
                    int[] iArr3 = new int[2];
                    iArr3[0] = Color.parseColor(cz.Bq() == null ? "#FF90B5" : cz.Bq());
                    iArr3[1] = Color.parseColor(cz.Br() == null ? "#FFADC6" : cz.Bq());
                    a(gradientDrawable, iArr3);
                    textView.setTextColor(Color.parseColor(cz.Bs() == null ? "#FF2F87" : cz.Bs()));
                    if (cz.Bp() != null) {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, Integer.parseInt(cz.Bp())), 0, 0);
                    }
                } else {
                    a(gradientDrawable, new int[]{context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_start_color), context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_end_color)});
                    textView.setTextColor(context.getResources().getColor(a.c.sdk_ala_guard_level_bg_1_3_text_color));
                    if (i >= 16) {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, 1.0f), 0, 0);
                    } else {
                        layoutParams2.setMargins(0, BdUtilHelper.dip2px(context, -1.0f), 0, 0);
                    }
                }
                gradientDrawable.setStroke(0, Color.parseColor("#ffe900"));
                if (i >= 1 && i <= 3) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_1_3);
                } else if (i >= 4 && i <= 6) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_4_6);
                } else if (i >= 7 && i <= 9) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_7_9);
                } else if (i >= 10 && i <= 12) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_10_12);
                } else if (i >= 13 && i <= 15) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_13_15);
                } else if (i >= 16 && i <= 18) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_16_18);
                } else if (i >= 19) {
                    imageView.setImageResource(a.e.ala_sdk_guard_level_bg_19_20);
                }
            }
            findViewById.setBackgroundDrawable(gradientDrawable);
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
