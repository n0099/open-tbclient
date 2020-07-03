package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.lightapp.BdLightappKernelClient;
/* loaded from: classes11.dex */
public final class c {
    private BdLightappKernelClient adj;

    public c(BdSailorWebView bdSailorWebView, BdLightappKernelClient bdLightappKernelClient) {
        this.adj = bdLightappKernelClient;
        bdLightappKernelClient.setCurrentWebiew(bdSailorWebView.getCurrentWebView());
        bdSailorWebView.setLigthappStopBgWorkListenerExt(bdLightappKernelClient);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2, String str3) {
        this.adj.addseniorWz(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSeekTo(String str, String str2, String str3) {
        this.adj.audioSeekTo(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSpeedFF(String str, String str2) {
        this.adj.audioSpeedFF(str, str2);
    }

    @JavascriptInterface
    public final void bdLogin(String str, String str2, String str3) {
        this.adj.bdLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void callShare(String str, String str2, String str3) {
        this.adj.callShare(str, str2, str3);
    }

    @JavascriptInterface
    public final void closeWindow() {
        this.adj.closeWindow();
    }

    @JavascriptInterface
    public final void cloudaLaunchCamera(String str, String str2, String str3) {
        this.adj.cloudaLaunchCamera(str, str2, str3);
    }

    @JavascriptInterface
    public final void cloudaLaunchGallery(String str, String str2, String str3) {
        this.adj.cloudaLaunchGallery(str, str2, str3);
    }

    @JavascriptInterface
    public final void consult(String str, String str2, String str3) {
        this.adj.consult(str, str2, str3);
    }

    @JavascriptInterface
    public final void doPolymerPay(String str, String str2, String str3) {
        this.adj.doPolymerPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void doThirdPay(String str, String str2, String str3) {
        this.adj.doThirdPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void dopay(String str, String str2, String str3, boolean z) {
        this.adj.dopay(str, str2, str3, z);
    }

    @JavascriptInterface
    public final void followSite(String str, String str2) {
        this.adj.followSite(str, str2);
    }

    @JavascriptInterface
    public final void followZhida(String str, String str2, String str3) {
        this.adj.followZhida(str, str2, str3);
    }

    @JavascriptInterface
    public final void getBattery(String str, String str2) {
        this.adj.getBattery(str, str2);
    }

    @JavascriptInterface
    public final void getCurrentPosition(String str, String str2) {
        this.adj.getCurrentPosition(str, str2);
    }

    @JavascriptInterface
    public final void getDeviceInfo(String str, String str2) {
        this.adj.getDeviceInfo(str, str2);
    }

    @JavascriptInterface
    public final String getGlobalizationInfo() {
        return this.adj.getGlobalizationInfo();
    }

    @JavascriptInterface
    public final void getNetworkType(String str, String str2) {
        this.adj.getNetworkType(str, str2);
    }

    @JavascriptInterface
    public final void getPushToken(String str, String str2) {
        this.adj.getPushToken(str, str2);
    }

    @JavascriptInterface
    public final void getWebKitPluginInfo(String str, String str2) {
        this.adj.getWebKitPluginInfo(str, str2);
    }

    @JavascriptInterface
    public final void initpay(String str, String str2, String str3) {
        this.adj.initpay(str, str2, str3);
    }

    @JavascriptInterface
    public final void invokeThirdApp(String str, String str2, String str3) {
        this.adj.invokeThirdApp(str, str2, str3);
    }

    @JavascriptInterface
    public final void isLogin(String str, String str2, String str3) {
        this.adj.isLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void launchSeniorVoiceRecognition(String str, String str2, String str3) {
        this.adj.launchSeniorVoiceRecognition(str, str2, str3);
    }

    @JavascriptInterface
    public final void login(String str, String str2, String str3) {
        this.adj.login(str, str2, str3);
    }

    @JavascriptInterface
    public final void playAudio(String str, String str2, String str3, String str4) {
        this.adj.playAudio(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void postFile(String str, String str2, String str3, String str4) {
        this.adj.postFile(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void queryWzStatus(String str, String str2) {
        this.adj.queryWzStatus(str, str2);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2, String str3) {
        this.adj.queryZhidaStatus(str, str2, str3);
    }

    @JavascriptInterface
    public final void setVolume(String str, String str2, String str3) {
        this.adj.setVolume(str, str2, str3);
    }

    @JavascriptInterface
    public final void shareB64Img(String str) {
        this.adj.shareB64Img(str);
    }

    @JavascriptInterface
    public final void startListenBattery(String str, String str2) {
        this.adj.startListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void startListenKeyboard(String str, String str2, String str3) {
        this.adj.startListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void startListenLocation(String str, String str2) {
        this.adj.startListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void startQRcode(String str, String str2, String str3) {
        this.adj.startQRcode(str, str2, str3);
    }

    @JavascriptInterface
    public final void startRecording(String str, String str2, String str3) {
        this.adj.startRecording(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenBattery(String str, String str2) {
        this.adj.stopListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void stopListenKeyboard(String str, String str2, String str3) {
        this.adj.stopListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenLocation(String str, String str2) {
        this.adj.stopListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void stopRecording(String str, String str2) {
        this.adj.stopRecording(str, str2);
    }

    @JavascriptInterface
    public final void unSubscribeZhida(String str, String str2, String str3) {
        this.adj.unSubscribeZhida(str, str2, str3);
    }
}
