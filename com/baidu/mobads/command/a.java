package com.baidu.mobads.command;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3304a;
    public String f;
    public boolean g;

    /* renamed from: b  reason: collision with root package name */
    public long f3305b = -1;
    public int c = 0;
    public IOAdDownloader.DownloadStatus d = IOAdDownloader.DownloadStatus.NONE;
    public Object e = null;
    public boolean h = true;
    public int i = 0;
    public boolean j = false;
    public boolean k = false;
    public String l = null;
    protected final IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(String str, String str2) {
        this.f = str;
        this.f3304a = str2;
    }

    public static String a() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }
}
