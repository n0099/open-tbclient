package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.lightapp.BdLightappKernelClient;
/* loaded from: classes11.dex */
public final class c {
    private BdLightappKernelClient acE;

    public c(BdSailorWebView bdSailorWebView, BdLightappKernelClient bdLightappKernelClient) {
        this.acE = bdLightappKernelClient;
        bdLightappKernelClient.setCurrentWebiew(bdSailorWebView.getCurrentWebView());
        bdSailorWebView.setLigthappStopBgWorkListenerExt(bdLightappKernelClient);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2, String str3) {
        this.acE.addseniorWz(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSeekTo(String str, String str2, String str3) {
        this.acE.audioSeekTo(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSpeedFF(String str, String str2) {
        this.acE.audioSpeedFF(str, str2);
    }

    @JavascriptInterface
    public final void bdLogin(String str, String str2, String str3) {
        this.acE.bdLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void callShare(String str, String str2, String str3) {
        this.acE.callShare(str, str2, str3);
    }

    @JavascriptInterface
    public final void closeWindow() {
        this.acE.closeWindow();
    }

    @JavascriptInterface
    public final void cloudaLaunchCamera(String str, String str2, String str3) {
        this.acE.cloudaLaunchCamera(str, str2, str3);
    }

    @JavascriptInterface
    public final void cloudaLaunchGallery(String str, String str2, String str3) {
        this.acE.cloudaLaunchGallery(str, str2, str3);
    }

    @JavascriptInterface
    public final void consult(String str, String str2, String str3) {
        this.acE.consult(str, str2, str3);
    }

    @JavascriptInterface
    public final void doPolymerPay(String str, String str2, String str3) {
        this.acE.doPolymerPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void doThirdPay(String str, String str2, String str3) {
        this.acE.doThirdPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void dopay(String str, String str2, String str3, boolean z) {
        this.acE.dopay(str, str2, str3, z);
    }

    @JavascriptInterface
    public final void followSite(String str, String str2) {
        this.acE.followSite(str, str2);
    }

    @JavascriptInterface
    public final void followZhida(String str, String str2, String str3) {
        this.acE.followZhida(str, str2, str3);
    }

    @JavascriptInterface
    public final void getBattery(String str, String str2) {
        this.acE.getBattery(str, str2);
    }

    @JavascriptInterface
    public final void getCurrentPosition(String str, String str2) {
        this.acE.getCurrentPosition(str, str2);
    }

    @JavascriptInterface
    public final void getDeviceInfo(String str, String str2) {
        this.acE.getDeviceInfo(str, str2);
    }

    @JavascriptInterface
    public final String getGlobalizationInfo() {
        return this.acE.getGlobalizationInfo();
    }

    @JavascriptInterface
    public final void getNetworkType(String str, String str2) {
        this.acE.getNetworkType(str, str2);
    }

    @JavascriptInterface
    public final void getPushToken(String str, String str2) {
        this.acE.getPushToken(str, str2);
    }

    @JavascriptInterface
    public final void getWebKitPluginInfo(String str, String str2) {
        this.acE.getWebKitPluginInfo(str, str2);
    }

    @JavascriptInterface
    public final void initpay(String str, String str2, String str3) {
        this.acE.initpay(str, str2, str3);
    }

    @JavascriptInterface
    public final void invokeThirdApp(String str, String str2, String str3) {
        this.acE.invokeThirdApp(str, str2, str3);
    }

    @JavascriptInterface
    public final void isLogin(String str, String str2, String str3) {
        this.acE.isLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void launchSeniorVoiceRecognition(String str, String str2, String str3) {
        this.acE.launchSeniorVoiceRecognition(str, str2, str3);
    }

    @JavascriptInterface
    public final void login(String str, String str2, String str3) {
        this.acE.login(str, str2, str3);
    }

    @JavascriptInterface
    public final void playAudio(String str, String str2, String str3, String str4) {
        this.acE.playAudio(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void postFile(String str, String str2, String str3, String str4) {
        this.acE.postFile(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void queryWzStatus(String str, String str2) {
        this.acE.queryWzStatus(str, str2);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2, String str3) {
        this.acE.queryZhidaStatus(str, str2, str3);
    }

    @JavascriptInterface
    public final void setVolume(String str, String str2, String str3) {
        this.acE.setVolume(str, str2, str3);
    }

    @JavascriptInterface
    public final void shareB64Img(String str) {
        this.acE.shareB64Img(str);
    }

    @JavascriptInterface
    public final void startListenBattery(String str, String str2) {
        this.acE.startListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void startListenKeyboard(String str, String str2, String str3) {
        this.acE.startListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void startListenLocation(String str, String str2) {
        this.acE.startListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void startQRcode(String str, String str2, String str3) {
        this.acE.startQRcode(str, str2, str3);
    }

    @JavascriptInterface
    public final void startRecording(String str, String str2, String str3) {
        this.acE.startRecording(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenBattery(String str, String str2) {
        this.acE.stopListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void stopListenKeyboard(String str, String str2, String str3) {
        this.acE.stopListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenLocation(String str, String str2) {
        this.acE.stopListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void stopRecording(String str, String str2) {
        this.acE.stopRecording(str, str2);
    }

    @JavascriptInterface
    public final void unSubscribeZhida(String str, String str2, String str3) {
        this.acE.unSubscribeZhida(str, str2, str3);
    }
}
