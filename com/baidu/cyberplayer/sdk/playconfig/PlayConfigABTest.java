package com.baidu.cyberplayer.sdk.playconfig;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.context.ICyberMediaContext;
import com.baidu.searchbox.playerserver.ab.IPlayConfigABTest;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PlayConfigABTest implements IPlayConfigABTest {
    public ICyberMediaContext cyberMediaContext = CyberPlayerManager.getCyberMediaContext();

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public JSONObject getRawSwitch() {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getRawSwitch();
        }
        return null;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public double getSwitch(String str, double d) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getSwitch(str, d);
        }
        return 0.0d;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public int getSwitch(String str, int i) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getSwitch(str, i);
        }
        return 0;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public long getSwitch(String str, long j) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getSwitch(str, j);
        }
        return 0L;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public String getSwitch(String str, String str2) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getSwitch(str, str2);
        }
        return null;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public boolean getSwitch(String str, boolean z) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().getSwitch(str, z);
        }
        return false;
    }

    @Override // com.baidu.searchbox.playerserver.ab.IPlayConfigABTest
    public boolean has(String str) {
        ICyberMediaContext iCyberMediaContext = this.cyberMediaContext;
        if (iCyberMediaContext != null && iCyberMediaContext.getAbTestInterface() != null) {
            return this.cyberMediaContext.getAbTestInterface().has(str);
        }
        return false;
    }
}
