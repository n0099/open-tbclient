package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class PatchVideoNative {

    /* renamed from: a  reason: collision with root package name */
    public Context f8047a;

    /* renamed from: b  reason: collision with root package name */
    public String f8048b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f8049c;

    /* renamed from: d  reason: collision with root package name */
    public IPatchVideoNativeListener f8050d;

    /* renamed from: e  reason: collision with root package name */
    public a f8051e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mobads.i.b f8052f;

    /* renamed from: g  reason: collision with root package name */
    public e f8053g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8054h;

    /* loaded from: classes2.dex */
    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(NativeErrorCode nativeErrorCode);

        void onAdLoad(String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    public PatchVideoNative(Context context, String str, RelativeLayout relativeLayout, IPatchVideoNativeListener iPatchVideoNativeListener) {
        this.f8047a = context;
        this.f8048b = str;
        this.f8049c = relativeLayout;
        this.f8050d = iPatchVideoNativeListener;
        this.f8051e = new a(context, str, new b(this));
    }

    public long getCurrentPosition() {
        com.baidu.mobads.i.b bVar = this.f8052f;
        if (bVar != null) {
            return bVar.a();
        }
        return 0L;
    }

    public long getDuration() {
        com.baidu.mobads.i.b bVar = this.f8052f;
        if (bVar != null) {
            return bVar.b();
        }
        return 0L;
    }

    public void requestAd(RequestParameters requestParameters) {
        a aVar = this.f8051e;
        if (aVar != null) {
            aVar.a(requestParameters);
        }
    }

    public void setVideoMute(boolean z) {
        this.f8054h = z;
        com.baidu.mobads.i.b bVar = this.f8052f;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.f8050d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.f8050d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.f8050d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NativeErrorCode nativeErrorCode) {
        IPatchVideoNativeListener iPatchVideoNativeListener = this.f8050d;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdFailed(nativeErrorCode);
        }
    }
}
