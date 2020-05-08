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
/* loaded from: classes3.dex */
public class b {
    private static b gr = null;
    private ViewGroup gs;
    private View.OnTouchListener gt;
    private View.OnTouchListener gu;
    private String gv;
    private ViewGroup gx;
    private WebView gy;
    private Context mContext;
    private List<com.baidu.ar.arplay.d.a> gw = new ArrayList();
    private Handler gz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.arplay.d.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final com.baidu.ar.arplay.d.a n;
            super.handleMessage(message);
            a.C0074a c0074a = message.obj instanceof a.C0074a ? (a.C0074a) message.obj : null;
            switch (message.what) {
                case 103:
                    b.this.a(c0074a);
                    return;
                case 104:
                    if (c0074a == null || (n = b.this.n(c0074a.dL)) == null || c0074a.gq == null) {
                        return;
                    }
                    n.evaluateJavascript(c0074a.gq, new ValueCallback<String>() { // from class: com.baidu.ar.arplay.d.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        /* renamed from: H */
                        public void onReceiveValue(String str) {
                            n.invalidate();
                            n.setIsNeedRender(true);
                            b.this.m(((Integer) n.getTag()).intValue());
                        }
                    });
                    return;
                case 105:
                    com.baidu.ar.arplay.d.a n2 = b.this.n(message.arg1);
                    if (n2 != null) {
                        n2.setIsNeedRender(true);
                        n2.invalidate();
                        return;
                    }
                    return;
                case 106:
                    b.this.b(c0074a);
                    return;
                default:
                    return;
            }
        }
    };
    WebViewClient gA = new WebViewClient() { // from class: com.baidu.ar.arplay.d.b.6
        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            int intValue = ((Integer) webView.getTag()).intValue();
            b.this.l(intValue);
            b.this.o(intValue);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null) {
                a aVar = new a();
                aVar.dX = webResourceError.getErrorCode();
                if (webResourceError.getDescription() != null) {
                    aVar.gG = webResourceError.getDescription().toString();
                }
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                a aVar = new a();
                aVar.dX = webResourceResponse.getStatusCode();
                aVar.gG = webResourceResponse.getReasonPhrase();
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                a aVar = new a();
                aVar.dX = sslError.getPrimaryError();
                aVar.gG = "ssl error!";
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    private WebChromeClient gB = new WebChromeClient() { // from class: com.baidu.ar.arplay.d.b.7
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                b.this.o(((com.baidu.ar.arplay.d.a) webView).getWebViewData().dL);
            }
        }
    };

    /* loaded from: classes3.dex */
    public class a {
        public String gG;
        public String gF = "android";
        public int dX = 0;

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
        hashMap3.put("platform", aVar.gF);
        hashMap3.put("error_code", Integer.valueOf(aVar.dX));
        hashMap3.put("error_msg", aVar.gG);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        o(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0074a c0074a) {
        if (c0074a == null || !isValid()) {
            return;
        }
        com.baidu.ar.arplay.d.a e = e(c0074a.width, c0074a.height);
        e.setWebViewData(c0074a);
        d.aW().b(c0074a.dL, c0074a.width, c0074a.height);
        e.setTag(Integer.valueOf(c0074a.dL));
        String str = c0074a.url;
        if (!c0074a.gp) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        e.loadUrl(str);
        e.invalidate();
        e.setIsNeedRender(true);
        e(c0074a);
    }

    public static b aT() {
        if (gr == null) {
            synchronized (b.class) {
                if (gr == null) {
                    gr = new b();
                }
            }
        }
        return gr;
    }

    private boolean aU() {
        if (this.mContext == null || this.gx == null) {
            Log.e("GLWebView", "Native WebView context or root is null!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0074a c0074a) {
        if (c0074a == null || !aU()) {
            return;
        }
        if (this.gy == null) {
            this.gy = new WebView(this.mContext);
            this.gy.setBackgroundColor(17170445);
            WebSettings settings = this.gy.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.gy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b.this.gu != null) {
                        return b.this.gu.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
            this.gx.addView(this.gy, layoutParams);
        }
        String str = c0074a.url;
        if (!c0074a.gp) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        this.gy.loadUrl(str);
        this.gy.invalidate();
    }

    private com.baidu.ar.arplay.d.a e(int i, int i2) {
        final com.baidu.ar.arplay.d.a aVar = new com.baidu.ar.arplay.d.a(this.mContext);
        ViewGroup.LayoutParams layoutParams = null;
        if (this.gs instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else if (this.gs instanceof LinearLayout) {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
        } else if (this.gs instanceof RelativeLayout) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
        }
        aVar.setBackgroundColor(17170445);
        aVar.setWebViewClient(this.gA);
        aVar.setWebChromeClient(this.gB);
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
                    b.this.o(((Integer) aVar.getTag()).intValue());
                }
            }, "NativeCallback");
        }
        aVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.gt != null) {
                    return b.this.gt.onTouch(view, motionEvent);
                }
                return false;
            }
        });
        this.gs.addView(aVar, layoutParams);
        this.gw.add(aVar);
        return aVar;
    }

    private boolean isValid() {
        if (this.mContext == null || this.gs == null) {
            Log.e("GLWebView", "GLWebView context or root is null!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.arplay.d.a n(int i) {
        for (com.baidu.ar.arplay.d.a aVar : this.gw) {
            if (aVar != null && aVar.getWebViewData() != null && aVar.getWebViewData().dL == i) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i) {
        Message obtainMessage = this.gz.obtainMessage();
        obtainMessage.what = 105;
        obtainMessage.arg1 = i;
        this.gz.sendMessage(obtainMessage);
    }

    public void G(String str) {
        this.gv = str;
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gs = viewGroup;
        this.gt = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPEngine.d() { // from class: com.baidu.ar.arplay.d.b.2
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.d
            public boolean c(int i, int i2) {
                b.this.o(i);
                return true;
            }
        });
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gx = viewGroup;
        this.gu = onTouchListener;
    }

    public void c(a.C0074a c0074a) {
        Message obtainMessage = this.gz.obtainMessage();
        obtainMessage.what = 103;
        obtainMessage.obj = c0074a;
        this.gz.sendMessage(obtainMessage);
    }

    public void d(a.C0074a c0074a) {
        Message obtainMessage = this.gz.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = c0074a;
        this.gz.sendMessage(obtainMessage);
    }

    public void e(a.C0074a c0074a) {
        Message obtainMessage = this.gz.obtainMessage();
        obtainMessage.what = 104;
        obtainMessage.obj = c0074a;
        com.baidu.ar.arplay.d.a n = n(c0074a.dL);
        if (n != null) {
            n.setWebViewData(c0074a);
            this.gz.sendMessage(obtainMessage);
        }
    }

    public void release() {
        this.mContext = null;
        d.aW().release();
        if (this.gw != null) {
            for (com.baidu.ar.arplay.d.a aVar : this.gw) {
                if (aVar != null) {
                    if (aVar.getParent() == this.gs) {
                        this.gs.removeView(aVar);
                    }
                    aVar.destroy();
                }
            }
            this.gw.clear();
            this.gw = null;
        }
        ARPEngine.getInstance().setHtmlUpdateCallback(null);
        if (this.gz != null) {
            this.gz.removeCallbacksAndMessages(null);
            this.gz = null;
        }
        gr = null;
        this.gy = null;
        this.gu = null;
    }
}
