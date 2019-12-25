package com.baidu.mobads.command.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.l;
import java.io.File;
import java.net.URL;
/* loaded from: classes7.dex */
public class a extends b {
    public a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
    }

    public void a() {
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        XAdSDKFoundationFacade.getInstance().getIoUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        try {
            String appPackageName = this.c.getAppPackageName();
            this.e.i("XAdDownloadAPKCommand", "download pkg = " + appPackageName);
            if ((appPackageName == null || appPackageName.equals("")) && !TextUtils.isEmpty(this.c.getOriginClickUrl())) {
                this.e.i("XAdDownloadAPKCommand", "start to download but package is empty");
                appPackageName = commonUtils.getMD5(this.c.getOriginClickUrl());
            }
            IOAdDownloader adsApkDownloader = d.a(this.a).getAdsApkDownloader(appPackageName);
            com.baidu.mobads.openad.b.b a = com.baidu.mobads.openad.b.b.a(appPackageName);
            if (a != null && adsApkDownloader != null) {
                com.baidu.mobads.command.a a2 = a.a();
                IOAdDownloader.DownloadStatus state = adsApkDownloader.getState();
                this.e.d("XAdDownloadAPKCommand", "startDownload>> downloader exist: state=" + state);
                if (state == IOAdDownloader.DownloadStatus.CANCELLED || state == IOAdDownloader.DownloadStatus.ERROR || state == IOAdDownloader.DownloadStatus.PAUSED) {
                    adsApkDownloader.resume();
                    uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                    return;
                } else if (state == IOAdDownloader.DownloadStatus.COMPLETED) {
                    if (a(this.a, a2)) {
                        uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                        b(a2);
                        return;
                    }
                    adsApkDownloader.cancel();
                    adsApkDownloader.removeObservers();
                    com.baidu.mobads.openad.b.b.b(appPackageName);
                    d.a(this.a).removeAdsApkDownloader(appPackageName);
                } else if (state == IOAdDownloader.DownloadStatus.DOWNLOADING || state == IOAdDownloader.DownloadStatus.INITING) {
                    commonUtils.sendDownloadAdLog(this.a, 529, "downloading", this.b != null ? this.b.getProdInfo().getProdType() : "", appPackageName, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
                    a(this.a, adsApkDownloader.getTitle() + adsApkDownloader.getState().getMessage(), 0, Boolean.valueOf(this.c.isPopNotif()));
                    return;
                }
            } else {
                if (adsApkDownloader != null) {
                    adsApkDownloader.cancel();
                    adsApkDownloader.removeObservers();
                }
                com.baidu.mobads.openad.b.b.b(appPackageName);
                d.a(this.a).removeAdsApkDownloader(appPackageName);
            }
            com.baidu.mobads.command.a a3 = com.baidu.mobads.command.a.a(this.a, appPackageName);
            if (a3 != null) {
                if (a3.g == IOAdDownloader.DownloadStatus.COMPLETED && a(this.a, a3)) {
                    b(a3);
                    return;
                }
                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
            } else if (b()) {
                commonUtils.sendDownloadAdLog(this.a, 529, "alreadyinstalled1", this.b != null ? this.b.getProdInfo().getProdType() : "", appPackageName, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
                XAdSDKFoundationFacade.getInstance().getPackageUtils().openApp(this.a, this.c.getAppPackageName());
                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.a, this.e).startMonitor();
                return;
            } else {
                String appName = this.c.getAppName();
                a3 = new com.baidu.mobads.command.a(appPackageName, ((appName == null || appName.equals("")) && ((appName = this.c.getTitle()) == null || appName.equals(""))) ? "您点击的应用" : appName);
                a3.a(this.c.getQueryKey(), this.c.getAdId(), this.c.getClickThroughUrl(), this.c.isAutoOpen());
                a3.m = this.c.isPopNotif();
                a3.a(commonUtils.getMD5(a3.j) + ".apk", l.a(this.a));
                if (this.b != null) {
                    a3.b(this.b.getAdRequestInfo().getApid(), this.b.getProdInfo().getProdType());
                }
                a3.f = com.baidu.mobads.openad.b.b.c(appPackageName);
                a3.s = this.c.isActionOnlyWifi() ? false : true;
                a3.a(System.currentTimeMillis());
                a3.b(this.c.getAppSize());
                a3.a(this.c.isTooLarge());
            }
            a3.t = System.currentTimeMillis();
            IOAdDownloader createAdsApkDownloader = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.a).createAdsApkDownloader(new URL(a3.j), a3.c, a3.b, 3, a3.a, a3.i);
            if (this.c.getAPOOpen() && this.c.getPage() != null && !this.c.getPage().equals("")) {
                a3.w = true;
                a3.x = this.c.getPage();
            }
            createAdsApkDownloader.addObserver(new com.baidu.mobads.openad.b.b(this.a, a3));
            if (!a3.s && systemUtils.is3GConnected(this.a).booleanValue()) {
                commonUtils.sendDownloadAdLog(this.a, 529, "waitwifi", this.b != null ? this.b.getProdInfo().getProdType() : "", appPackageName, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
                createAdsApkDownloader.pause();
                a(this.a, createAdsApkDownloader.getTitle() + " 将在连入Wifi后开始下载", 0, Boolean.valueOf(this.c.isPopNotif()));
                return;
            }
            commonUtils.sendDownloadAdLog(this.a, 527, "realstart", this.b != null ? this.b.getProdInfo().getProdType() : "", appPackageName, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
            createAdsApkDownloader.start();
        } catch (Exception e) {
            this.e.e("XAdDownloadAPKCommand", e);
            com.baidu.mobads.c.a.a().a("ad app download failed: " + e.toString());
        }
    }

    public void a(Context context, String str, int i, Boolean bool) {
        if (bool.booleanValue()) {
            Toast.makeText(context, str, i).show();
        }
    }

    private boolean b() {
        return XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(this.a, this.c.getAppPackageName());
    }

    protected boolean a(Context context, com.baidu.mobads.command.a aVar) {
        boolean isInstalled = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(context, aVar.i);
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        if (isInstalled) {
            commonUtils.sendDownloadAdLog(this.a, 529, "alreadyinstalled", this.b != null ? this.b.getProdInfo().getProdType() : "", aVar.i, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
            XAdSDKFoundationFacade.getInstance().getPackageUtils().openApp(context, aVar.i);
            return true;
        }
        commonUtils.sendDownloadAdLog(this.a, 529, "alreadydownloaded", this.b != null ? this.b.getProdInfo().getProdType() : "", aVar.i, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
        String str = aVar.c + aVar.b;
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            XAdSDKFoundationFacade.getInstance().getPackageUtils().b(context, str);
            return true;
        }
        return false;
    }

    private void b(com.baidu.mobads.command.a aVar) {
        if (com.baidu.mobads.production.b.f() != null) {
            IXAppInfo a = a(aVar);
            if (a != null) {
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.a, this.e).addAppInfoForMonitor(a);
            } else {
                this.e.e("addAppInfoForMonitor error, appInfo is null");
            }
        }
    }

    public static IXAppInfo a(com.baidu.mobads.command.a aVar) {
        IXAdContainerFactory f;
        if (aVar == null || (f = com.baidu.mobads.production.b.f()) == null) {
            return null;
        }
        IXAppInfo createAppInfo = f.createAppInfo();
        createAppInfo.setAdId(aVar.g());
        createAppInfo.setAppSize(aVar.e());
        createAppInfo.setClickTime(aVar.c());
        createAppInfo.setPackageName(aVar.d());
        createAppInfo.setQk(aVar.h());
        createAppInfo.setProd(aVar.i());
        createAppInfo.setTooLarge(aVar.f());
        return createAppInfo;
    }
}
