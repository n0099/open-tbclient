package com.baidu.browser.sailor;

import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements Runnable {
    final /* synthetic */ BdSailor adg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSailor bdSailor) {
        this.adg = bdSailor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
            boolean z = abTestInterface != null ? abTestInterface.getSwitch("no_zeus_under_5", true) : true;
            ZwCrashpad.setEnabled(true);
            String[] strArr = new String[12];
            strArr[0] = WebKitFactory.getCyberSdkVersion();
            strArr[1] = WebKitFactory.getCPUType();
            strArr[2] = WebKitFactory.getCUIDString();
            strArr[3] = BdZeusUtil.checkEmulator();
            strArr[4] = WebKitFactory.getCrashCallback();
            strArr[5] = BdZeusUtil.getTnNumbersFromApk(this.adg.getAppContext());
            strArr[6] = WebKitFactory.getProcessTypeString();
            strArr[7] = z ? "true" : "false";
            strArr[8] = this.adg.getAppContext().getExternalFilesDir("").getAbsolutePath();
            strArr[9] = WebKitFactory.getSdkVersionCode();
            strArr[10] = "0";
            strArr[11] = this.adg.getAppContext() != null ? this.adg.getAppContext().getApplicationInfo().nativeLibraryDir : "0";
            ZwCrashpad.doInit(this.adg.getAppContext(), strArr);
        } catch (Throwable th) {
            Log.e("CRASHPAD", "bdsailor.initWebkit->zwcrashpad doInit fail");
            th.printStackTrace();
        }
    }
}
