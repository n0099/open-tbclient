package com.baidu.cyberplayer.sdk.a;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.context.ICyberMediaContext;
import com.baidu.searchbox.playerserver.ab.IPlayConfigABTest;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements IPlayConfigABTest {
    public ICyberMediaContext a = CyberPlayerManager.getCyberMediaContext();

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public JSONObject getRawSwitch() {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getRawSwitch();
        }
        return null;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public double getSwitch(String str, double d) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getSwitch(str, d);
        }
        return 0.0d;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public int getSwitch(String str, int i) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getSwitch(str, i);
        }
        return 0;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public long getSwitch(String str, long j) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getSwitch(str, j);
        }
        return 0L;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public String getSwitch(String str, String str2) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getSwitch(str, str2);
        }
        return null;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public boolean getSwitch(String str, boolean z) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().getSwitch(str, z);
        }
        return false;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public boolean has(String str) {
        ICyberMediaContext iCyberMediaContext = this.a;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.a.getAbTestInterface().has(str);
        }
        return false;
    }
}
