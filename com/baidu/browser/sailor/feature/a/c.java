package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.BdSailorWebView;
/* loaded from: classes2.dex */
public final class c {
    private com.baidu.browser.sailor.a.c VP;

    public c(BdSailorWebView bdSailorWebView, com.baidu.browser.sailor.a.c cVar) {
        this.VP = cVar;
        cVar.a(bdSailorWebView.getCurrentWebView());
        bdSailorWebView.setLigthappStopBgWorkListenerExt(cVar);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2, String str3) {
        this.VP.addseniorWz(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSeekTo(String str, String str2, String str3) {
        this.VP.audioSeekTo(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSpeedFF(String str, String str2) {
        this.VP.audioSpeedFF(str, str2);
    }

    @JavascriptInterface
    public final void bdLogin(String str, String str2, String str3) {
        this.VP.bdLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void callShare(String str, String str2, String str3) {
        this.VP.callShare(str, str2, str3);
    }

    @JavascriptInterface
    public final void closeWindow() {
        this.VP.closeWindow();
    }

    @JavascriptInterface
    public final void cloudaLaunchCamera(String str, String str2, String str3) {
        this.VP.cloudaLaunchCamera(str, str2, str3);
    }

    @JavascriptInterface
    public final void cloudaLaunchGallery(String str, String str2, String str3) {
        this.VP.cloudaLaunchGallery(str, str2, str3);
    }

    @JavascriptInterface
    public final void consult(String str, String str2, String str3) {
        this.VP.consult(str, str2, str3);
    }

    @JavascriptInterface
    public final void doPolymerPay(String str, String str2, String str3) {
        this.VP.doPolymerPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void doThirdPay(String str, String str2, String str3) {
        this.VP.doThirdPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void dopay(String str, String str2, String str3, boolean z) {
        this.VP.dopay(str, str2, str3, z);
    }

    @JavascriptInterface
    public final void followSite(String str, String str2) {
        this.VP.followSite(str, str2);
    }

    @JavascriptInterface
    public final void followZhida(String str, String str2, String str3) {
        this.VP.followZhida(str, str2, str3);
    }

    @JavascriptInterface
    public final void getBattery(String str, String str2) {
        this.VP.getBattery(str, str2);
    }

    @JavascriptInterface
    public final void getCurrentPosition(String str, String str2) {
        this.VP.getCurrentPosition(str, str2);
    }

    @JavascriptInterface
    public final void getDeviceInfo(String str, String str2) {
        this.VP.getDeviceInfo(str, str2);
    }

    @JavascriptInterface
    public final String getGlobalizationInfo() {
        return this.VP.getGlobalizationInfo();
    }

    @JavascriptInterface
    public final void getNetworkType(String str, String str2) {
        this.VP.getNetworkType(str, str2);
    }

    @JavascriptInterface
    public final void getPushToken(String str, String str2) {
        this.VP.getPushToken(str, str2);
    }

    @JavascriptInterface
    public final void getWebKitPluginInfo(String str, String str2) {
        this.VP.getWebKitPluginInfo(str, str2);
    }

    @JavascriptInterface
    public final void initpay(String str, String str2, String str3) {
        this.VP.initpay(str, str2, str3);
    }

    @JavascriptInterface
    public final void invokeThirdApp(String str, String str2, String str3) {
        this.VP.invokeThirdApp(str, str2, str3);
    }

    @JavascriptInterface
    public final void isLogin(String str, String str2, String str3) {
        this.VP.isLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void launchSeniorVoiceRecognition(String str, String str2, String str3) {
        this.VP.launchSeniorVoiceRecognition(str, str2, str3);
    }

    @JavascriptInterface
    public final void login(String str, String str2, String str3) {
        this.VP.login(str, str2, str3);
    }

    @JavascriptInterface
    public final void playAudio(String str, String str2, String str3, String str4) {
        this.VP.playAudio(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void postFile(String str, String str2, String str3, String str4) {
        this.VP.postFile(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void queryWzStatus(String str, String str2) {
        this.VP.queryWzStatus(str, str2);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2, String str3) {
        this.VP.queryZhidaStatus(str, str2, str3);
    }

    @JavascriptInterface
    public final void setVolume(String str, String str2, String str3) {
        this.VP.setVolume(str, str2, str3);
    }

    @JavascriptInterface
    public final void shareB64Img(String str) {
        this.VP.shareB64Img(str);
    }

    @JavascriptInterface
    public final void startListenBattery(String str, String str2) {
        this.VP.startListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void startListenKeyboard(String str, String str2, String str3) {
        this.VP.startListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void startListenLocation(String str, String str2) {
        this.VP.startListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void startQRcode(String str, String str2, String str3) {
        this.VP.startQRcode(str, str2, str3);
    }

    @JavascriptInterface
    public final void startRecording(String str, String str2, String str3) {
        this.VP.startRecording(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenBattery(String str, String str2) {
        this.VP.stopListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void stopListenKeyboard(String str, String str2, String str3) {
        this.VP.stopListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenLocation(String str, String str2) {
        this.VP.stopListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void stopRecording(String str, String str2) {
        this.VP.stopRecording(str, str2);
    }

    @JavascriptInterface
    public final void unSubscribeZhida(String str, String str2, String str3) {
        this.VP.unSubscribeZhida(str, str2, str3);
    }
}
