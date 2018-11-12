package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.BdSailorWebView;
/* loaded from: classes2.dex */
public final class c {
    private com.baidu.browser.sailor.a.c VR;

    public c(BdSailorWebView bdSailorWebView, com.baidu.browser.sailor.a.c cVar) {
        this.VR = cVar;
        cVar.a(bdSailorWebView.getCurrentWebView());
        bdSailorWebView.setLigthappStopBgWorkListenerExt(cVar);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2, String str3) {
        this.VR.addseniorWz(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSeekTo(String str, String str2, String str3) {
        this.VR.audioSeekTo(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSpeedFF(String str, String str2) {
        this.VR.audioSpeedFF(str, str2);
    }

    @JavascriptInterface
    public final void bdLogin(String str, String str2, String str3) {
        this.VR.bdLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void callShare(String str, String str2, String str3) {
        this.VR.callShare(str, str2, str3);
    }

    @JavascriptInterface
    public final void closeWindow() {
        this.VR.closeWindow();
    }

    @JavascriptInterface
    public final void cloudaLaunchCamera(String str, String str2, String str3) {
        this.VR.cloudaLaunchCamera(str, str2, str3);
    }

    @JavascriptInterface
    public final void cloudaLaunchGallery(String str, String str2, String str3) {
        this.VR.cloudaLaunchGallery(str, str2, str3);
    }

    @JavascriptInterface
    public final void consult(String str, String str2, String str3) {
        this.VR.consult(str, str2, str3);
    }

    @JavascriptInterface
    public final void doPolymerPay(String str, String str2, String str3) {
        this.VR.doPolymerPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void doThirdPay(String str, String str2, String str3) {
        this.VR.doThirdPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void dopay(String str, String str2, String str3, boolean z) {
        this.VR.dopay(str, str2, str3, z);
    }

    @JavascriptInterface
    public final void followSite(String str, String str2) {
        this.VR.followSite(str, str2);
    }

    @JavascriptInterface
    public final void followZhida(String str, String str2, String str3) {
        this.VR.followZhida(str, str2, str3);
    }

    @JavascriptInterface
    public final void getBattery(String str, String str2) {
        this.VR.getBattery(str, str2);
    }

    @JavascriptInterface
    public final void getCurrentPosition(String str, String str2) {
        this.VR.getCurrentPosition(str, str2);
    }

    @JavascriptInterface
    public final void getDeviceInfo(String str, String str2) {
        this.VR.getDeviceInfo(str, str2);
    }

    @JavascriptInterface
    public final String getGlobalizationInfo() {
        return this.VR.getGlobalizationInfo();
    }

    @JavascriptInterface
    public final void getNetworkType(String str, String str2) {
        this.VR.getNetworkType(str, str2);
    }

    @JavascriptInterface
    public final void getPushToken(String str, String str2) {
        this.VR.getPushToken(str, str2);
    }

    @JavascriptInterface
    public final void getWebKitPluginInfo(String str, String str2) {
        this.VR.getWebKitPluginInfo(str, str2);
    }

    @JavascriptInterface
    public final void initpay(String str, String str2, String str3) {
        this.VR.initpay(str, str2, str3);
    }

    @JavascriptInterface
    public final void invokeThirdApp(String str, String str2, String str3) {
        this.VR.invokeThirdApp(str, str2, str3);
    }

    @JavascriptInterface
    public final void isLogin(String str, String str2, String str3) {
        this.VR.isLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void launchSeniorVoiceRecognition(String str, String str2, String str3) {
        this.VR.launchSeniorVoiceRecognition(str, str2, str3);
    }

    @JavascriptInterface
    public final void login(String str, String str2, String str3) {
        this.VR.login(str, str2, str3);
    }

    @JavascriptInterface
    public final void playAudio(String str, String str2, String str3, String str4) {
        this.VR.playAudio(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void postFile(String str, String str2, String str3, String str4) {
        this.VR.postFile(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void queryWzStatus(String str, String str2) {
        this.VR.queryWzStatus(str, str2);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2, String str3) {
        this.VR.queryZhidaStatus(str, str2, str3);
    }

    @JavascriptInterface
    public final void setVolume(String str, String str2, String str3) {
        this.VR.setVolume(str, str2, str3);
    }

    @JavascriptInterface
    public final void shareB64Img(String str) {
        this.VR.shareB64Img(str);
    }

    @JavascriptInterface
    public final void startListenBattery(String str, String str2) {
        this.VR.startListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void startListenKeyboard(String str, String str2, String str3) {
        this.VR.startListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void startListenLocation(String str, String str2) {
        this.VR.startListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void startQRcode(String str, String str2, String str3) {
        this.VR.startQRcode(str, str2, str3);
    }

    @JavascriptInterface
    public final void startRecording(String str, String str2, String str3) {
        this.VR.startRecording(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenBattery(String str, String str2) {
        this.VR.stopListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void stopListenKeyboard(String str, String str2, String str3) {
        this.VR.stopListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenLocation(String str, String str2) {
        this.VR.stopListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void stopRecording(String str, String str2) {
        this.VR.stopRecording(str, str2);
    }

    @JavascriptInterface
    public final void unSubscribeZhida(String str, String str2, String str3) {
        this.VR.unSubscribeZhida(str, str2, str3);
    }
}
