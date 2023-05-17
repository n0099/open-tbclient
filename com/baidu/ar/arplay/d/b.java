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
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.d.a;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static volatile b gf;
    public ViewGroup gg;
    public View.OnTouchListener gh;
    public View.OnTouchListener gi;
    public String gj;
    public ViewGroup gl;
    public WebView gm;
    public Context mContext;
    public List<com.baidu.ar.arplay.d.a> gk = new ArrayList();
    public Handler gn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.arplay.d.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final com.baidu.ar.arplay.d.a n;
            String str;
            super.handleMessage(message);
            Object obj = message.obj;
            a.C0052a c0052a = obj instanceof a.C0052a ? (a.C0052a) obj : null;
            switch (message.what) {
                case 103:
                    b.this.a(c0052a);
                    return;
                case 104:
                    if (c0052a == null || (n = b.this.n(c0052a.dM)) == null || (str = c0052a.ge) == null) {
                        return;
                    }
                    n.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.baidu.ar.arplay.d.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        /* renamed from: K */
                        public void onReceiveValue(String str2) {
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
                    b.this.b(c0052a);
                    return;
                default:
                    return;
            }
        }
    };
    public WebViewClient go = new WebViewClient() { // from class: com.baidu.ar.arplay.d.b.6
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
                aVar.dY = webResourceError.getErrorCode();
                if (webResourceError.getDescription() != null) {
                    aVar.gu = webResourceError.getDescription().toString();
                }
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                a aVar = new a();
                aVar.dY = webResourceResponse.getStatusCode();
                aVar.gu = webResourceResponse.getReasonPhrase();
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                a aVar = new a();
                aVar.dY = sslError.getPrimaryError();
                aVar.gu = "ssl error!";
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    public WebChromeClient gp = new WebChromeClient() { // from class: com.baidu.ar.arplay.d.b.7
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                b.this.o(((com.baidu.ar.arplay.d.a) webView).getWebViewData().dM);
            }
        }
    };

    /* loaded from: classes.dex */
    public class a {
        public String gu;
        public String gt = "android";
        public int dY = 0;

        public a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, a aVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_load_failed");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        HashMap hashMap3 = new HashMap();
        hashMap3.put(Constants.PARAM_PLATFORM, aVar.gt);
        hashMap3.put("error_code", Integer.valueOf(aVar.dY));
        hashMap3.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, aVar.gu);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
        o(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0052a c0052a) {
        if (c0052a == null || !isValid()) {
            return;
        }
        com.baidu.ar.arplay.d.a e = e(c0052a.width, c0052a.height);
        e.setWebViewData(c0052a);
        d.bp().b(c0052a.dM, c0052a.width, c0052a.height);
        e.setTag(Integer.valueOf(c0052a.dM));
        String str = c0052a.url;
        if (!c0052a.gd) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        e.loadUrl(str);
        e.invalidate();
        e.setIsNeedRender(true);
        e(c0052a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0052a c0052a) {
        if (c0052a == null || !bn()) {
            return;
        }
        if (this.gm == null) {
            WebView webView = new WebView(this.mContext);
            this.gm = webView;
            webView.setBackgroundColor(17170445);
            WebSettings settings = this.gm.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.gm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (b.this.gi != null) {
                        return b.this.gi.onTouch(view2, motionEvent);
                    }
                    return false;
                }
            });
            this.gl.addView(this.gm, layoutParams);
        }
        String str = c0052a.url;
        if (!c0052a.gd) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        this.gm.loadUrl(str);
        this.gm.invalidate();
    }

    public static b bm() {
        if (gf == null) {
            synchronized (b.class) {
                if (gf == null) {
                    gf = new b();
                }
            }
        }
        return gf;
    }

    private boolean bn() {
        if (this.mContext == null || this.gl == null) {
            Log.e("GLWebView", "Native WebView context or root is null!");
            return false;
        }
        return true;
    }

    private com.baidu.ar.arplay.d.a e(int i, int i2) {
        final com.baidu.ar.arplay.d.a aVar = new com.baidu.ar.arplay.d.a(this.mContext);
        ViewGroup viewGroup = this.gg;
        ViewGroup.LayoutParams layoutParams = viewGroup instanceof FrameLayout ? new FrameLayout.LayoutParams(i, i2) : viewGroup instanceof LinearLayout ? new LinearLayout.LayoutParams(i, i2) : viewGroup instanceof RelativeLayout ? new RelativeLayout.LayoutParams(i, i2) : null;
        aVar.setBackgroundColor(17170445);
        aVar.setWebViewClient(this.go);
        aVar.setWebChromeClient(this.gp);
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
                    com.baidu.ar.arplay.d.a aVar2 = aVar;
                    if (aVar2 == null) {
                        return;
                    }
                    b.this.o(((Integer) aVar2.getTag()).intValue());
                }
            }, "NativeCallback");
        }
        aVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (b.this.gh != null) {
                    return b.this.gh.onTouch(view2, motionEvent);
                }
                return false;
            }
        });
        this.gg.addView(aVar, layoutParams);
        this.gk.add(aVar);
        return aVar;
    }

    private boolean isValid() {
        if (this.mContext == null || this.gg == null) {
            Log.e("GLWebView", "GLWebView context or root is null!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.arplay.d.a n(int i) {
        for (com.baidu.ar.arplay.d.a aVar : this.gk) {
            if (aVar != null && aVar.getWebViewData() != null && aVar.getWebViewData().dM == i) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i) {
        Message obtainMessage = this.gn.obtainMessage();
        obtainMessage.what = 105;
        obtainMessage.arg1 = i;
        this.gn.sendMessage(obtainMessage);
    }

    public void J(String str) {
        this.gj = str;
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gg = viewGroup;
        this.gh = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPDataInteraction.a() { // from class: com.baidu.ar.arplay.d.b.2
            @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.a
            public boolean c(int i, int i2) {
                b.this.o(i);
                return true;
            }
        });
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gl = viewGroup;
        this.gi = onTouchListener;
    }

    public void c(a.C0052a c0052a) {
        Message obtainMessage = this.gn.obtainMessage();
        obtainMessage.what = 103;
        obtainMessage.obj = c0052a;
        this.gn.sendMessage(obtainMessage);
    }

    public void d(a.C0052a c0052a) {
        Message obtainMessage = this.gn.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = c0052a;
        this.gn.sendMessage(obtainMessage);
    }

    public void e(a.C0052a c0052a) {
        Message obtainMessage = this.gn.obtainMessage();
        obtainMessage.what = 104;
        obtainMessage.obj = c0052a;
        com.baidu.ar.arplay.d.a n = n(c0052a.dM);
        if (n != null) {
            n.setWebViewData(c0052a);
            this.gn.sendMessage(obtainMessage);
        }
    }

    public void release() {
        this.mContext = null;
        d.bp().release();
        ARPEngine.getInstance().setHtmlUpdateCallback(null);
        Handler handler = this.gn;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            runOnUiThread(new Runnable() { // from class: com.baidu.ar.arplay.d.b.8
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.ar.arplay.c.b.b(b.class.getName(), "remove webviewList in ui thread");
                    if (b.this.gk != null) {
                        for (com.baidu.ar.arplay.d.a aVar : b.this.gk) {
                            if (aVar != null) {
                                if (aVar.getParent() == b.this.gg) {
                                    b.this.gg.removeView(aVar);
                                }
                                aVar.destroy();
                            }
                        }
                        b.this.gk.clear();
                        b.this.gk = null;
                    }
                }
            });
            this.gn = null;
        }
        gf = null;
        this.gm = null;
        this.gi = null;
    }

    public void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.gn.post(runnable);
        }
    }
}
