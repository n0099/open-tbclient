package com.baidu.swan.games.view.button.base;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class a {
    @V8JavascriptField
    public String backgroundColor;
    @V8JavascriptField
    public String borderColor;
    @V8JavascriptField
    public double borderRadius;
    @V8JavascriptField
    public int borderWidth;
    @V8JavascriptField
    public String color;
    private InterfaceC0460a dnY;
    @V8JavascriptField
    public String fontWeight;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public boolean hidden;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int lineHeight;
    @V8JavascriptField
    public String textAlign;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;
    @V8JavascriptField
    public double fontSize = 16.0d;
    @V8JavascriptField
    public double opacity = 1.0d;

    /* renamed from: com.baidu.swan.games.view.button.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0460a {
        void aHP();
    }

    public a(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        m(cVar);
    }

    private void m(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        this.left = cVar.optInt("left", this.left);
        this.top = cVar.optInt(VerticalTranslateLayout.TOP, this.top);
        this.width = cVar.optInt("width", this.width);
        this.height = cVar.optInt("height", this.height);
        this.backgroundColor = cVar.optString("backgroundColor", this.backgroundColor);
        this.borderColor = cVar.optString("borderColor", this.borderColor);
        this.borderRadius = cVar.optDouble("borderRadius", this.borderRadius);
        this.borderWidth = cVar.optInt("borderWidth", this.borderWidth);
        this.fontSize = cVar.optDouble("fontSize", this.fontSize);
        this.lineHeight = cVar.optInt("lineHeight", this.lineHeight);
        this.textAlign = cVar.optString("textAlign", this.textAlign);
        this.fontWeight = cVar.optString("fontWeight", this.fontWeight);
        this.hidden = cVar.optBoolean("hidden", this.hidden);
        this.opacity = cVar.optDouble("opacity", this.opacity);
        this.color = cVar.optString("color", this.color);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
        }
        if (this.dnY != null) {
            this.dnY.aHP();
        }
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.dnY = interfaceC0460a;
    }

    public static int jc(@ColorInt int i) {
        int i2 = (16711680 & i) >> 16;
        int i3 = (65280 & i) >> 8;
        int i4 = i & 255;
        float f = (((-16777216) & i) >>> 24) / 255.0f;
        if (f > 0.0f) {
            return Color.argb(255, (int) ((i2 * f) + 0.5d), (int) ((i3 * f) + 0.5d), (int) ((f * i4) + 0.5d));
        }
        return i;
    }

    public String toString() {
        return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
    }
}
