package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.lightapp.BdLightappKernelClient;
/* loaded from: classes8.dex */
public final class c {
    private BdLightappKernelClient adc;

    public c(BdSailorWebView bdSailorWebView, BdLightappKernelClient bdLightappKernelClient) {
        this.adc = bdLightappKernelClient;
        bdLightappKernelClient.setCurrentWebiew(bdSailorWebView.getCurrentWebView());
        bdSailorWebView.setLigthappStopBgWorkListenerExt(bdLightappKernelClient);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2, String str3) {
        this.adc.addseniorWz(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSeekTo(String str, String str2, String str3) {
        this.adc.audioSeekTo(str, str2, str3);
    }

    @JavascriptInterface
    public final void audioSpeedFF(String str, String str2) {
        this.adc.audioSpeedFF(str, str2);
    }

    @JavascriptInterface
    public final void bdLogin(String str, String str2, String str3) {
        this.adc.bdLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void callShare(String str, String str2, String str3) {
        this.adc.callShare(str, str2, str3);
    }

    @JavascriptInterface
    public final void closeWindow() {
        this.adc.closeWindow();
    }

    @JavascriptInterface
    public final void cloudaLaunchCamera(String str, String str2, String str3) {
        this.adc.cloudaLaunchCamera(str, str2, str3);
    }

    @JavascriptInterface
    public final void cloudaLaunchGallery(String str, String str2, String str3) {
        this.adc.cloudaLaunchGallery(str, str2, str3);
    }

    @JavascriptInterface
    public final void consult(String str, String str2, String str3) {
        this.adc.consult(str, str2, str3);
    }

    @JavascriptInterface
    public final void doPolymerPay(String str, String str2, String str3) {
        this.adc.doPolymerPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void doThirdPay(String str, String str2, String str3) {
        this.adc.doThirdPay(str, str2, str3);
    }

    @JavascriptInterface
    public final void dopay(String str, String str2, String str3, boolean z) {
        this.adc.dopay(str, str2, str3, z);
    }

    @JavascriptInterface
    public final void followSite(String str, String str2) {
        this.adc.followSite(str, str2);
    }

    @JavascriptInterface
    public final void followZhida(String str, String str2, String str3) {
        this.adc.followZhida(str, str2, str3);
    }

    @JavascriptInterface
    public final void getBattery(String str, String str2) {
        this.adc.getBattery(str, str2);
    }

    @JavascriptInterface
    public final void getCurrentPosition(String str, String str2) {
        this.adc.getCurrentPosition(str, str2);
    }

    @JavascriptInterface
    public final void getDeviceInfo(String str, String str2) {
        this.adc.getDeviceInfo(str, str2);
    }

    @JavascriptInterface
    public final String getGlobalizationInfo() {
        return this.adc.getGlobalizationInfo();
    }

    @JavascriptInterface
    public final void getNetworkType(String str, String str2) {
        this.adc.getNetworkType(str, str2);
    }

    @JavascriptInterface
    public final void getPushToken(String str, String str2) {
        this.adc.getPushToken(str, str2);
    }

    @JavascriptInterface
    public final void getWebKitPluginInfo(String str, String str2) {
        this.adc.getWebKitPluginInfo(str, str2);
    }

    @JavascriptInterface
    public final void initpay(String str, String str2, String str3) {
        this.adc.initpay(str, str2, str3);
    }

    @JavascriptInterface
    public final void invokeThirdApp(String str, String str2, String str3) {
        this.adc.invokeThirdApp(str, str2, str3);
    }

    @JavascriptInterface
    public final void isLogin(String str, String str2, String str3) {
        this.adc.isLogin(str, str2, str3);
    }

    @JavascriptInterface
    public final void launchSeniorVoiceRecognition(String str, String str2, String str3) {
        this.adc.launchSeniorVoiceRecognition(str, str2, str3);
    }

    @JavascriptInterface
    public final void login(String str, String str2, String str3) {
        this.adc.login(str, str2, str3);
    }

    @JavascriptInterface
    public final void playAudio(String str, String str2, String str3, String str4) {
        this.adc.playAudio(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void postFile(String str, String str2, String str3, String str4) {
        this.adc.postFile(str, str2, str3, str4);
    }

    @JavascriptInterface
    public final void queryWzStatus(String str, String str2) {
        this.adc.queryWzStatus(str, str2);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2, String str3) {
        this.adc.queryZhidaStatus(str, str2, str3);
    }

    @JavascriptInterface
    public final void setVolume(String str, String str2, String str3) {
        this.adc.setVolume(str, str2, str3);
    }

    @JavascriptInterface
    public final void shareB64Img(String str) {
        this.adc.shareB64Img(str);
    }

    @JavascriptInterface
    public final void startListenBattery(String str, String str2) {
        this.adc.startListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void startListenKeyboard(String str, String str2, String str3) {
        this.adc.startListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void startListenLocation(String str, String str2) {
        this.adc.startListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void startQRcode(String str, String str2, String str3) {
        this.adc.startQRcode(str, str2, str3);
    }

    @JavascriptInterface
    public final void startRecording(String str, String str2, String str3) {
        this.adc.startRecording(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenBattery(String str, String str2) {
        this.adc.stopListenBattery(str, str2);
    }

    @JavascriptInterface
    public final void stopListenKeyboard(String str, String str2, String str3) {
        this.adc.stopListenKeyboard(str, str2, str3);
    }

    @JavascriptInterface
    public final void stopListenLocation(String str, String str2) {
        this.adc.stopListenLocation(str, str2);
    }

    @JavascriptInterface
    public final void stopRecording(String str, String str2) {
        this.adc.stopRecording(str, str2);
    }

    @JavascriptInterface
    public final void unSubscribeZhida(String str, String str2, String str3) {
        this.adc.unSubscribeZhida(str, str2, str3);
    }
}
