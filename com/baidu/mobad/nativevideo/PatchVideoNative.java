package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
public class PatchVideoNative {

    /* renamed from: a  reason: collision with root package name */
    private Context f2328a;
    private String b;
    private RelativeLayout c;
    private IPatchVideoNativeListener d;
    private a e;
    private com.baidu.mobads.i.b f;
    private e g;
    private boolean h;

    /* loaded from: classes4.dex */
    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(NativeErrorCode nativeErrorCode);

        void onAdLoad(String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    public PatchVideoNative(Context context, String str, RelativeLayout relativeLayout, IPatchVideoNativeListener iPatchVideoNativeListener) {
        this.f2328a = context;
        this.b = str;
        this.c = relativeLayout;
        this.d = iPatchVideoNativeListener;
        this.e = new a(this.f2328a, this.b, new b(this));
    }

    public void requestAd(RequestParameters requestParameters) {
        if (this.e != null) {
            this.e.a(requestParameters);
        }
    }

    public void setVideoMute(boolean z) {
        this.h = z;
        if (this.f != null) {
            this.f.a(this.h);
        }
    }

    public long getCurrentPosition() {
        if (this.f != null) {
            return this.f.a();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NativeErrorCode nativeErrorCode) {
        if (this.d != null) {
            this.d.onAdFailed(nativeErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            this.d.playCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            this.d.playError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.d != null) {
            this.d.onAdShow();
        }
    }
}
