package com.baidu.swan.facade.init;

import com.baidu.browser.sailor.ISailorAbTestInterface;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DefaultSailorAbTest implements ISailorAbTestInterface {
    @Override // com.baidu.webkit.sdk.IABTestInterface
    public JSONObject getRawSwitch() {
        return new JSONObject();
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public double getSwitch(String str, double d2) {
        return d2;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public int getSwitch(String str, int i2) {
        return i2;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public long getSwitch(String str, long j) {
        return j;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public String getSwitch(String str, String str2) {
        return str2;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public boolean getSwitch(String str, boolean z) {
        return z;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public boolean has(String str) {
        return false;
    }
}
