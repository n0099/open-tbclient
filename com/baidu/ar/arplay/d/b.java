package com.baidu.ar.arplay.d;

import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.d.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class b {
    private static b fS = null;
    private ViewGroup fT;
    private View.OnTouchListener fU;
    private View.OnTouchListener fV;
    private String fW;
    private ViewGroup fY;
    private WebView fZ;
    private Context mContext;
    private List<com.baidu.ar.arplay.d.a> fX = new ArrayList();
    private Handler ga = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.arplay.d.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final com.baidu.ar.arplay.d.a l;
            super.handleMessage(message);
            a.C0076a c0076a = message.obj instanceof a.C0076a ? (a.C0076a) message.obj : null;
            switch (message.what) {
                case 103:
                    b.this.a(c0076a);
                    return;
                case 104:
                    if (c0076a == null || (l = b.this.l(c0076a.dz)) == null || c0076a.fR == null) {
                        return;
                    }
                    l.evaluateJavascript(c0076a.fR, new ValueCallback<String>() { // from class: com.baidu.ar.arplay.d.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        /* renamed from: H */
                        public void onReceiveValue(String str) {
                            l.invalidate();
                            l.setIsNeedRender(true);
                            b.this.k(((Integer) l.getTag()).intValue());
                        }
                    });
                    return;
                case 105:
                    com.baidu.ar.arplay.d.a l2 = b.this.l(message.arg1);
                    if (l2 != null) {
                        l2.setIsNeedRender(true);
                        l2.invalidate();
                        return;
                    }
                    return;
                case 106:
                    b.this.b(c0076a);
                    return;
                default:
                    return;
            }
        }
    };
    WebViewClient gb = new WebViewClient() { // from class: com.baidu.ar.arplay.d.b.6
        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            int intValue = ((Integer) webView.getTag()).intValue();
            b.this.j(intValue);
            b.this.m(intValue);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null) {
                a aVar = new a();
                aVar.dL = webResourceError.getErrorCode();
                if (webResourceError.getDescription() != null) {
                    aVar.gh = webResourceError.getDescription().toString();
                }
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                a aVar = new a();
                aVar.dL = webResourceResponse.getStatusCode();
                aVar.gh = webResourceResponse.getReasonPhrase();
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                a aVar = new a();
                aVar.dL = sslError.getPrimaryError();
                aVar.gh = "ssl error!";
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    private WebChromeClient gc = new WebChromeClient() { // from class: com.baidu.ar.arplay.d.b.7
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                b.this.m(((com.baidu.ar.arplay.d.a) webView).getWebViewData().dz);
            }
        }
    };

    /* loaded from: classes12.dex */
    public class a {
        public String gh;
        public String gg = "android";
        public int dL = 0;

        public a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a aVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_load_failed");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("platform", aVar.gg);
        hashMap3.put("error_code", Integer.valueOf(aVar.dL));
        hashMap3.put("error_msg", aVar.gh);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        m(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0076a c0076a) {
        if (c0076a == null || !isValid()) {
            return;
        }
        com.baidu.ar.arplay.d.a e = e(c0076a.width, c0076a.height);
        e.setWebViewData(c0076a);
        d.bs().b(c0076a.dz, c0076a.width, c0076a.height);
        e.setTag(Integer.valueOf(c0076a.dz));
        String str = c0076a.url;
        if (!c0076a.fQ) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        e.loadUrl(str);
        e.invalidate();
        e.setIsNeedRender(true);
        e(c0076a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0076a c0076a) {
        if (c0076a == null || !bq()) {
            return;
        }
        if (this.fZ == null) {
            this.fZ = new WebView(this.mContext);
            this.fZ.setBackgroundColor(17170445);
            WebSettings settings = this.fZ.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.fZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b.this.fV != null) {
                        return b.this.fV.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
            this.fY.addView(this.fZ, layoutParams);
        }
        String str = c0076a.url;
        if (!c0076a.fQ) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        this.fZ.loadUrl(str);
        this.fZ.invalidate();
    }

    public static b bp() {
        if (fS == null) {
            synchronized (b.class) {
                if (fS == null) {
                    fS = new b();
                }
            }
        }
        return fS;
    }

    private boolean bq() {
        if (this.mContext == null || this.fY == null) {
            Log.e("GLWebView", "Native WebView context or root is null!");
            return false;
        }
        return true;
    }

    private com.baidu.ar.arplay.d.a e(int i, int i2) {
        final com.baidu.ar.arplay.d.a aVar = new com.baidu.ar.arplay.d.a(this.mContext);
        ViewGroup.LayoutParams layoutParams = null;
        if (this.fT instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else if (this.fT instanceof LinearLayout) {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
        } else if (this.fT instanceof RelativeLayout) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
        }
        aVar.setBackgroundColor(17170445);
        aVar.setWebViewClient(this.gb);
        aVar.setWebChromeClient(this.gc);
        aVar.setHorizontalScrollBarEnabled(false);
        aVar.setVerticalScrollBarEnabled(false);
        WebSettings settings = aVar.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            aVar.addJavascriptInterface(new Object() { // from class: com.baidu.ar.arplay.d.b.4
                @JavascriptInterface
                public void updateFinish(String str) {
                    if (aVar == null) {
                        return;
                    }
                    b.this.m(((Integer) aVar.getTag()).intValue());
                }
            }, "NativeCallback");
        }
        aVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.fU != null) {
                    return b.this.fU.onTouch(view, motionEvent);
                }
                return false;
            }
        });
        this.fT.addView(aVar, layoutParams);
        this.fX.add(aVar);
        return aVar;
    }

    private boolean isValid() {
        if (this.mContext == null || this.fT == null) {
            Log.e("GLWebView", "GLWebView context or root is null!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.arplay.d.a l(int i) {
        for (com.baidu.ar.arplay.d.a aVar : this.fX) {
            if (aVar != null && aVar.getWebViewData() != null && aVar.getWebViewData().dz == i) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i) {
        Message obtainMessage = this.ga.obtainMessage();
        obtainMessage.what = 105;
        obtainMessage.arg1 = i;
        this.ga.sendMessage(obtainMessage);
    }

    public void G(String str) {
        this.fW = str;
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.fT = viewGroup;
        this.fU = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPEngine.c() { // from class: com.baidu.ar.arplay.d.b.2
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.c
            public boolean c(int i, int i2) {
                b.this.m(i);
                return true;
            }
        });
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.fY = viewGroup;
        this.fV = onTouchListener;
    }

    public void c(a.C0076a c0076a) {
        Message obtainMessage = this.ga.obtainMessage();
        obtainMessage.what = 103;
        obtainMessage.obj = c0076a;
        this.ga.sendMessage(obtainMessage);
    }

    public void d(a.C0076a c0076a) {
        Message obtainMessage = this.ga.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = c0076a;
        this.ga.sendMessage(obtainMessage);
    }

    public void e(a.C0076a c0076a) {
        Message obtainMessage = this.ga.obtainMessage();
        obtainMessage.what = 104;
        obtainMessage.obj = c0076a;
        com.baidu.ar.arplay.d.a l = l(c0076a.dz);
        if (l != null) {
            l.setWebViewData(c0076a);
            this.ga.sendMessage(obtainMessage);
        }
    }

    public void release() {
        this.mContext = null;
        d.bs().release();
        if (this.fX != null) {
            for (com.baidu.ar.arplay.d.a aVar : this.fX) {
                if (aVar != null) {
                    if (aVar.getParent() == this.fT) {
                        this.fT.removeView(aVar);
                    }
                    aVar.destroy();
                }
            }
            this.fX.clear();
            this.fX = null;
        }
        ARPEngine.getInstance().setHtmlUpdateCallback(null);
        if (this.ga != null) {
            this.ga.removeCallbacksAndMessages(null);
            this.ga = null;
        }
        fS = null;
        this.fZ = null;
        this.fV = null;
    }
}
