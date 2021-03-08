package com.baidu.mobads.nativecpu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class NativeCPUManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2426a = NativeCPUManager.class.getSimpleName();
    private CPUAdListener b;
    private Context c;
    private a e;
    private com.baidu.mobads.nativecpu.a.a f;
    private int d = 10;
    private Map<String, Object> g = new HashMap();
    private Map<String, Object> h = new HashMap();

    /* loaded from: classes4.dex */
    public interface CPUAdListener {
        void onAdClick();

        void onAdError(String str, int i);

        void onAdLoaded(List<IBasicCPUData> list);

        void onAdStatusChanged(String str);

        void onNoAd(String str, int i);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.f = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.b = cPUAdListener;
            this.c = context;
            this.e = new a();
            this.f = new com.baidu.mobads.nativecpu.a.a(context, str);
            this.f.a(this.e);
            return;
        }
        q.a().e(f2426a, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", XAdErrorCode.INTERFACE_USE_PROBLEM.getCode());
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        a(i, new int[]{i2}, z);
    }

    private void a(int i, int[] iArr, boolean z) {
        if (i > 0 && iArr != null) {
            if (this.f != null) {
                this.f.a(i, this.d, iArr, z, this.g);
                return;
            }
            return;
        }
        q.a().e(f2426a, "LoadAd with terrible params!");
    }

    public void setRequestTimeoutMillis(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    public void setLpFontSize(CpuLpFontSize cpuLpFontSize) {
        this.h.put("prefersfontsize", cpuLpFontSize.getValue());
    }

    public void setLpDarkMode(boolean z) {
        if (z) {
            this.h.put("preferscolortheme", "dark");
        } else {
            this.h.put("preferscolortheme", "light");
        }
    }

    public void setLpStyleParam(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.h.put(str, str2);
        }
    }

    public Map<String, Object> getLpStyleParams() {
        return this.h;
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest != null && cPUAdRequest.getExtras() != null) {
            this.g.clear();
            this.g.putAll(cPUAdRequest.getExtras());
        }
    }

    public void setPageSize(int i) {
        if (i > 0 && i <= 20) {
            this.d = i;
        } else {
            q.a().e(f2426a, "Input page size is wrong which should be in (0,20]!");
        }
    }

    /* loaded from: classes4.dex */
    class a implements IOAdEventListener {
        public a() {
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (IXAdEvent.AD_LOADED.equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.b != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : NativeCPUManager.this.f.b()) {
                        arrayList.add(new com.baidu.mobads.nativecpu.a.b(NativeCPUManager.this.c, obj, NativeCPUManager.this));
                    }
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new b(this, arrayList));
                }
            } else if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                NativeCPUManager.this.f.a();
                String a2 = a(iOAdEvent);
                int code = iOAdEvent.getCode();
                if (NativeCPUManager.this.b != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new c(this, a2, code));
                }
            } else if ("AdEmptyList".equals(iOAdEvent.getType())) {
                String str = (String) iOAdEvent.getData().get("message");
                int code2 = iOAdEvent.getCode();
                if (NativeCPUManager.this.b != null) {
                    NativeCPUManager.this.b.onNoAd(str, code2);
                }
            } else if ("AdUserClick".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.b != null) {
                    NativeCPUManager.this.b.onAdClick();
                }
            } else if ("AdStatusChange".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.b != null) {
                    NativeCPUManager.this.b.onAdStatusChanged(iOAdEvent.getMessage());
                }
            } else if ("vdieoCacheSucc".equals(iOAdEvent.getType())) {
                if (NativeCPUManager.this.b != null) {
                    NativeCPUManager.this.b.onVideoDownloadSuccess();
                }
            } else if ("vdieoCacheFailed".equals(iOAdEvent.getType()) && NativeCPUManager.this.b != null) {
                NativeCPUManager.this.b.onVideoDownloadFailed();
            }
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            if (TextUtils.isEmpty(message) && (data = iOAdEvent.getData()) != null) {
                Object obj = data.get("msg");
                if (obj instanceof String) {
                    return (String) obj;
                }
            }
            return message;
        }
    }
}
