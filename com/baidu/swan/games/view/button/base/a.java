package com.baidu.swan.games.view.button.base;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class a {
    private InterfaceC0255a bEn;
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
    public HashSet<String> bEm = new HashSet<>();

    /* renamed from: com.baidu.swan.games.view.button.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0255a {
        void YH();
    }

    public a(@NonNull JsObject jsObject) {
        n(jsObject);
    }

    private void n(@NonNull JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            String propertyName = jsObject.getPropertyName(i);
            if (!TextUtils.isEmpty(propertyName)) {
                char c = 65535;
                switch (propertyName.hashCode()) {
                    case -1267206133:
                        if (propertyName.equals("opacity")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -1221029593:
                        if (propertyName.equals("height")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1217487446:
                        if (propertyName.equals("hidden")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case -1065511464:
                        if (propertyName.equals("textAlign")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -734428249:
                        if (propertyName.equals("fontWeight")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -515807685:
                        if (propertyName.equals("lineHeight")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 115029:
                        if (propertyName.equals(VerticalTranslateLayout.TOP)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3317767:
                        if (propertyName.equals("left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 94842723:
                        if (propertyName.equals("color")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 113126854:
                        if (propertyName.equals("width")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 365601008:
                        if (propertyName.equals("fontSize")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 722830999:
                        if (propertyName.equals("borderColor")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 741115130:
                        if (propertyName.equals("borderWidth")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1287124693:
                        if (propertyName.equals("backgroundColor")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1349188574:
                        if (propertyName.equals("borderRadius")) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.left = jsObject.toInteger(i);
                        break;
                    case 1:
                        this.top = jsObject.toInteger(i);
                        break;
                    case 2:
                        this.width = jsObject.toInteger(i);
                        break;
                    case 3:
                        this.height = jsObject.toInteger(i);
                        break;
                    case 4:
                        this.backgroundColor = jsObject.toString(i);
                        break;
                    case 5:
                        this.borderColor = jsObject.toString(i);
                        break;
                    case 6:
                        this.borderRadius = jsObject.toDouble(i);
                        break;
                    case 7:
                        this.borderWidth = jsObject.toInteger(i);
                        break;
                    case '\b':
                        this.fontSize = jsObject.toDouble(i);
                        break;
                    case '\t':
                        this.lineHeight = jsObject.toInteger(i);
                        break;
                    case '\n':
                        this.textAlign = jsObject.toString(i);
                        break;
                    case 11:
                        this.fontWeight = jsObject.toString(i);
                        break;
                    case '\f':
                        this.hidden = jsObject.toBoolean(i);
                        break;
                    case '\r':
                        this.opacity = jsObject.toDouble(i);
                        break;
                    case 14:
                        this.color = jsObject.toString(i);
                        break;
                }
                this.bEm.add(propertyName);
            }
        }
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
        }
        if (this.bEn != null) {
            this.bEn.YH();
        }
    }

    public void a(InterfaceC0255a interfaceC0255a) {
        this.bEn = interfaceC0255a;
    }

    public static int ge(@ColorInt int i) {
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
