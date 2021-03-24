package com.baidu.mobads.command;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f8180a;

    /* renamed from: f  reason: collision with root package name */
    public String f8185f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8186g;

    /* renamed from: b  reason: collision with root package name */
    public long f8181b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f8182c = 0;

    /* renamed from: d  reason: collision with root package name */
    public IOAdDownloader.DownloadStatus f8183d = IOAdDownloader.DownloadStatus.NONE;

    /* renamed from: e  reason: collision with root package name */
    public Object f8184e = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8187h = true;
    public int i = 0;
    public boolean j = false;
    public boolean k = false;
    public String l = null;
    public final IXAdLogger m = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(String str, String str2) {
        this.f8185f = str;
        this.f8180a = str2;
    }

    public static String a() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }
}
