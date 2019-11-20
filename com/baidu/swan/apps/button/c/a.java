package com.baidu.swan.apps.button.c;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void b(@NonNull com.baidu.swan.apps.button.view.a aVar) {
        c(aVar);
        if (aVar instanceof com.baidu.swan.apps.button.view.a.a) {
            a((com.baidu.swan.apps.button.view.a.a) aVar);
        }
        if (aVar instanceof com.baidu.swan.apps.button.view.button.a) {
            a((com.baidu.swan.apps.button.view.button.a) aVar);
        }
    }

    public static <M extends com.baidu.swan.apps.button.b.a<M>> com.baidu.swan.apps.view.container.c.a a(M m, M m2) {
        com.baidu.swan.apps.view.container.c.a aVar = new com.baidu.swan.apps.view.container.c.a();
        if (m != m2) {
            if (m != null && m2 != null) {
                m.a(m2, aVar);
            } else {
                aVar.fG(63);
            }
        }
        return aVar;
    }

    private static void c(@NonNull com.baidu.swan.apps.button.view.a aVar) {
        View view = aVar.getView();
        com.baidu.swan.apps.button.b.a model = aVar.getModel();
        b(view, model);
        a(view, model);
    }

    private static void a(@NonNull com.baidu.swan.apps.button.view.a.a aVar) {
        a(aVar.getView(), aVar.getModel());
    }

    private static void a(@NonNull com.baidu.swan.apps.button.view.button.a aVar) {
    }

    private static void a(@NonNull View view, @NonNull com.baidu.swan.apps.button.b.a aVar) {
        view.setPadding(z.S((float) aVar.LJ), z.S((float) aVar.LK), z.S((float) aVar.LM), z.S((float) aVar.LN));
        float f = aVar.aED;
        if (f >= 0.0f && f <= 1.0f) {
            view.setAlpha(f);
        }
    }

    private static void b(@NonNull View view, @NonNull com.baidu.swan.apps.button.b.a aVar) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(aVar.backgroundColor);
        gradientDrawable.setCornerRadius(aVar.aEC);
        gradientDrawable.setStroke(aVar.borderWidth, aVar.borderColor);
        view.setBackground(gradientDrawable);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(@NonNull TextView textView, @NonNull com.baidu.swan.apps.button.b.b.a aVar) {
        int S;
        char c;
        int i;
        boolean z;
        boolean z2;
        textView.setText(aVar.text);
        try {
            textView.setTextColor(Color.parseColor(aVar.Tz));
        } catch (Exception e) {
            c.e("SwanAppNativeViewUtils", "text color occurs exception", e);
        }
        int i2 = aVar.textSize;
        if (i2 > 0) {
            textView.setTextSize(1, i2);
        }
        if (z.S((float) aVar.fH) > 0) {
            textView.setLineSpacing((S - textView.getLineHeight()) + textView.getLineSpacingExtra(), 1.0f);
        }
        String str = aVar.textAlign;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals(HorizontalTranslateLayout.RIGHT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i = GravityCompat.END;
                break;
            case 1:
                i = 1;
                break;
            default:
                i = GravityCompat.START;
                break;
        }
        textView.setGravity(i | 16);
        String str2 = aVar.fontWeight;
        TextPaint paint = textView.getPaint();
        switch (str2.hashCode()) {
            case -1039745817:
                if (str2.equals("normal")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3029637:
                if (str2.equals("bold")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                if (paint != null) {
                    paint.setFakeBoldText(true);
                    break;
                }
                break;
            default:
                if (paint != null) {
                    paint.setFakeBoldText(false);
                    break;
                }
                break;
        }
        String str3 = aVar.aEE;
        switch (str3.hashCode()) {
            case -1039745817:
                if (str3.equals("normal")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case -1039592053:
                if (str3.equals("nowrap")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        switch (z2) {
            case false:
                textView.setSingleLine(false);
                return;
            case true:
                textView.setSingleLine(true);
                return;
            default:
                return;
        }
    }
}
