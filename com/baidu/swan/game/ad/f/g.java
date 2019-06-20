package com.baidu.swan.game.ad.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes2.dex */
public class g {
    private a bdC;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int realHeight;
    @V8JavascriptField
    public int realWidth;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes2.dex */
    public interface a {
        void iD(String str);
    }

    public g(@NonNull JsObject jsObject) {
        a(jsObject);
    }

    private void a(@NonNull JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            String propertyName = jsObject.getPropertyName(i);
            if (!TextUtils.isEmpty(propertyName)) {
                char c = 65535;
                switch (propertyName.hashCode()) {
                    case -1221029593:
                        if (propertyName.equals("height")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 115029:
                        if (propertyName.equals("top")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3317767:
                        if (propertyName.equals(CustomDialogData.POS_LEFT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 113126854:
                        if (propertyName.equals("width")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.left = jsObject.toInteger(i);
                        continue;
                    case 1:
                        this.top = jsObject.toInteger(i);
                        continue;
                    case 2:
                        this.width = jsObject.toInteger(i);
                        continue;
                    case 3:
                        this.height = jsObject.toInteger(i);
                        continue;
                }
            }
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BannerAdStyle", "onFieldChangedCallback fieldName=" + str);
        }
        if (this.bdC != null) {
            this.bdC.iD(str);
        }
    }

    public void a(a aVar) {
        this.bdC = aVar;
    }
}
