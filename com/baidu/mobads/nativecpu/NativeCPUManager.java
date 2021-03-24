package com.baidu.mobads.nativecpu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.cpu.CPUWebAdRequestParam;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class NativeCPUManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8373a = "NativeCPUManager";

    /* renamed from: b  reason: collision with root package name */
    public CPUAdListener f8374b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8375c;

    /* renamed from: e  reason: collision with root package name */
    public a f8377e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mobads.nativecpu.a.a f8378f;

    /* renamed from: d  reason: collision with root package name */
    public int f8376d = 10;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f8379g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f8380h = new HashMap();

    /* loaded from: classes2.dex */
    public interface CPUAdListener {
        void onAdClick();

        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onAdStatusChanged(String str);

        void onNoAd(String str, int i);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes2.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                if (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null) {
                    return message;
                }
                Object obj = data.get("msg");
                return obj instanceof String ? (String) obj : message;
            }
            return null;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (IXAdEvent.AD_LOADED.equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.f8374b != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : NativeCPUManager.this.f8378f.b()) {
                        arrayList.add(new com.baidu.mobads.nativecpu.a.b(NativeCPUManager.this.f8375c, obj, NativeCPUManager.this));
                    }
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new b(this, arrayList));
                }
            } else if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                NativeCPUManager.this.f8378f.a();
                String a2 = a(iOAdEvent);
                int code = iOAdEvent.getCode();
                if (NativeCPUManager.this.f8374b != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this, a2, code));
                }
            } else if ("AdEmptyList".equals(iOAdEvent.getType())) {
                String str = (String) iOAdEvent.getData().get("message");
                int code2 = iOAdEvent.getCode();
                if (NativeCPUManager.this.f8374b != null) {
                    NativeCPUManager.this.f8374b.onNoAd(str, code2);
                }
            } else if ("AdUserClick".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.f8374b != null) {
                    NativeCPUManager.this.f8374b.onAdClick();
                }
            } else if ("AdStatusChange".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.f8374b != null) {
                    NativeCPUManager.this.f8374b.onAdStatusChanged(iOAdEvent.getMessage());
                }
            } else if ("vdieoCacheSucc".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.f8374b != null) {
                    NativeCPUManager.this.f8374b.onVideoDownloadSuccess();
                }
            } else if ("vdieoCacheFailed".equals(iOAdEvent.getType()) && NativeCPUManager.this.f8374b != null) {
                NativeCPUManager.this.f8374b.onVideoDownloadFailed();
            }
        }
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.f8378f = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.f8374b = cPUAdListener;
            this.f8375c = context;
            this.f8377e = new a();
            com.baidu.mobads.nativecpu.a.a aVar = new com.baidu.mobads.nativecpu.a.a(context, str);
            this.f8378f = aVar;
            aVar.a(this.f8377e);
            return;
        }
        q.a().e(f8373a, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", XAdErrorCode.INTERFACE_USE_PROBLEM.getCode());
        }
    }

    public Map<String, Object> getLpStyleParams() {
        return this.f8380h;
    }

    public void loadAd(int i, int i2, boolean z) {
        a(i, new int[]{i2}, z);
    }

    public void setLpDarkMode(boolean z) {
        if (z) {
            this.f8380h.put("preferscolortheme", "dark");
        } else {
            this.f8380h.put("preferscolortheme", CPUWebAdRequestParam.LIGHT_MODE);
        }
    }

    public void setLpFontSize(CpuLpFontSize cpuLpFontSize) {
        this.f8380h.put("prefersfontsize", cpuLpFontSize.getValue());
    }

    public void setLpStyleParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8380h.put(str, str2);
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 20) {
            this.f8376d = i;
        } else {
            q.a().e(f8373a, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.f8379g.clear();
        this.f8379g.putAll(cPUAdRequest.getExtras());
    }

    public void setRequestTimeoutMillis(int i) {
        com.baidu.mobads.nativecpu.a.a aVar = this.f8378f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private void a(int i, int[] iArr, boolean z) {
        if (i > 0 && iArr != null) {
            com.baidu.mobads.nativecpu.a.a aVar = this.f8378f;
            if (aVar != null) {
                aVar.a(i, this.f8376d, iArr, z, this.f8379g);
                return;
            }
            return;
        }
        q.a().e(f8373a, "LoadAd with terrible params!");
    }
}
