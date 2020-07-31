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
/* loaded from: classes11.dex */
public class b {
    private static b gD = null;
    private ViewGroup gE;
    private View.OnTouchListener gF;
    private View.OnTouchListener gG;
    private String gH;
    private ViewGroup gJ;
    private WebView gK;
    private Context mContext;
    private List<com.baidu.ar.arplay.d.a> gI = new ArrayList();
    private Handler gL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.arplay.d.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final com.baidu.ar.arplay.d.a o;
            super.handleMessage(message);
            a.C0078a c0078a = message.obj instanceof a.C0078a ? (a.C0078a) message.obj : null;
            switch (message.what) {
                case 103:
                    b.this.a(c0078a);
                    return;
                case 104:
                    if (c0078a == null || (o = b.this.o(c0078a.dX)) == null || c0078a.gC == null) {
                        return;
                    }
                    o.evaluateJavascript(c0078a.gC, new ValueCallback<String>() { // from class: com.baidu.ar.arplay.d.b.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        /* renamed from: H */
                        public void onReceiveValue(String str) {
                            o.invalidate();
                            o.setIsNeedRender(true);
                            b.this.n(((Integer) o.getTag()).intValue());
                        }
                    });
                    return;
                case 105:
                    com.baidu.ar.arplay.d.a o2 = b.this.o(message.arg1);
                    if (o2 != null) {
                        o2.setIsNeedRender(true);
                        o2.invalidate();
                        return;
                    }
                    return;
                case 106:
                    b.this.b(c0078a);
                    return;
                default:
                    return;
            }
        }
    };
    WebViewClient gM = new WebViewClient() { // from class: com.baidu.ar.arplay.d.b.6
        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            int intValue = ((Integer) webView.getTag()).intValue();
            b.this.m(intValue);
            b.this.p(intValue);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null) {
                a aVar = new a();
                aVar.ej = webResourceError.getErrorCode();
                if (webResourceError.getDescription() != null) {
                    aVar.gS = webResourceError.getDescription().toString();
                }
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (webResourceResponse != null) {
                a aVar = new a();
                aVar.ej = webResourceResponse.getStatusCode();
                aVar.gS = webResourceResponse.getReasonPhrase();
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                a aVar = new a();
                aVar.ej = sslError.getPrimaryError();
                aVar.gS = "ssl error!";
                b.this.a(((Integer) webView.getTag()).intValue(), aVar);
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    private WebChromeClient gN = new WebChromeClient() { // from class: com.baidu.ar.arplay.d.b.7
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (i == 100) {
                b.this.p(((com.baidu.ar.arplay.d.a) webView).getWebViewData().dX);
            }
        }
    };

    /* loaded from: classes11.dex */
    public class a {
        public String gS;
        public String gR = "android";
        public int ej = 0;

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
        hashMap3.put("platform", aVar.gR);
        hashMap3.put("error_code", Integer.valueOf(aVar.ej));
        hashMap3.put("error_msg", aVar.gS);
        hashMap2.put("data", hashMap3);
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        p(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0078a c0078a) {
        if (c0078a == null || !isValid()) {
            return;
        }
        com.baidu.ar.arplay.d.a e = e(c0078a.width, c0078a.height);
        e.setWebViewData(c0078a);
        d.bk().b(c0078a.dX, c0078a.width, c0078a.height);
        e.setTag(Integer.valueOf(c0078a.dX));
        String str = c0078a.url;
        if (!c0078a.gB) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        e.loadUrl(str);
        e.invalidate();
        e.setIsNeedRender(true);
        e(c0078a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0078a c0078a) {
        if (c0078a == null || !bi()) {
            return;
        }
        if (this.gK == null) {
            this.gK = new WebView(this.mContext);
            this.gK.setBackgroundColor(17170445);
            WebSettings settings = this.gK.getSettings();
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            settings.setJavaScriptEnabled(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.gK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (b.this.gG != null) {
                        return b.this.gG.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
            this.gJ.addView(this.gK, layoutParams);
        }
        String str = c0078a.url;
        if (!c0078a.gB) {
            str = "file://" + this.mContext.getFilesDir().getAbsolutePath().concat(File.separator) + "ar/" + str;
        }
        this.gK.loadUrl(str);
        this.gK.invalidate();
    }

    public static b bh() {
        if (gD == null) {
            synchronized (b.class) {
                if (gD == null) {
                    gD = new b();
                }
            }
        }
        return gD;
    }

    private boolean bi() {
        if (this.mContext == null || this.gJ == null) {
            Log.e("GLWebView", "Native WebView context or root is null!");
            return false;
        }
        return true;
    }

    private com.baidu.ar.arplay.d.a e(int i, int i2) {
        final com.baidu.ar.arplay.d.a aVar = new com.baidu.ar.arplay.d.a(this.mContext);
        ViewGroup.LayoutParams layoutParams = null;
        if (this.gE instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else if (this.gE instanceof LinearLayout) {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
        } else if (this.gE instanceof RelativeLayout) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
        }
        aVar.setBackgroundColor(17170445);
        aVar.setWebViewClient(this.gM);
        aVar.setWebChromeClient(this.gN);
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
                    b.this.p(((Integer) aVar.getTag()).intValue());
                }
            }, "NativeCallback");
        }
        aVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.arplay.d.b.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (b.this.gF != null) {
                    return b.this.gF.onTouch(view, motionEvent);
                }
                return false;
            }
        });
        this.gE.addView(aVar, layoutParams);
        this.gI.add(aVar);
        return aVar;
    }

    private boolean isValid() {
        if (this.mContext == null || this.gE == null) {
            Log.e("GLWebView", "GLWebView context or root is null!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_load_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "webView_operation_update_finish");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("texture_id", Integer.valueOf(i));
        hashMap.put("event_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.ar.arplay.d.a o(int i) {
        for (com.baidu.ar.arplay.d.a aVar : this.gI) {
            if (aVar != null && aVar.getWebViewData() != null && aVar.getWebViewData().dX == i) {
                return aVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i) {
        Message obtainMessage = this.gL.obtainMessage();
        obtainMessage.what = 105;
        obtainMessage.arg1 = i;
        this.gL.sendMessage(obtainMessage);
    }

    public void G(String str) {
        this.gH = str;
    }

    public void a(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gE = viewGroup;
        this.gF = onTouchListener;
        ARPEngine.getInstance().setHtmlUpdateCallback(new ARPEngine.d() { // from class: com.baidu.ar.arplay.d.b.2
            @Override // com.baidu.ar.arplay.core.engine.ARPEngine.d
            public boolean c(int i, int i2) {
                b.this.p(i);
                return true;
            }
        });
    }

    public void b(Context context, ViewGroup viewGroup, View.OnTouchListener onTouchListener) {
        this.mContext = context;
        this.gJ = viewGroup;
        this.gG = onTouchListener;
    }

    public void c(a.C0078a c0078a) {
        Message obtainMessage = this.gL.obtainMessage();
        obtainMessage.what = 103;
        obtainMessage.obj = c0078a;
        this.gL.sendMessage(obtainMessage);
    }

    public void d(a.C0078a c0078a) {
        Message obtainMessage = this.gL.obtainMessage();
        obtainMessage.what = 106;
        obtainMessage.obj = c0078a;
        this.gL.sendMessage(obtainMessage);
    }

    public void e(a.C0078a c0078a) {
        Message obtainMessage = this.gL.obtainMessage();
        obtainMessage.what = 104;
        obtainMessage.obj = c0078a;
        com.baidu.ar.arplay.d.a o = o(c0078a.dX);
        if (o != null) {
            o.setWebViewData(c0078a);
            this.gL.sendMessage(obtainMessage);
        }
    }

    public void release() {
        this.mContext = null;
        d.bk().release();
        if (this.gI != null) {
            for (com.baidu.ar.arplay.d.a aVar : this.gI) {
                if (aVar != null) {
                    if (aVar.getParent() == this.gE) {
                        this.gE.removeView(aVar);
                    }
                    aVar.destroy();
                }
            }
            this.gI.clear();
            this.gI = null;
        }
        ARPEngine.getInstance().setHtmlUpdateCallback(null);
        if (this.gL != null) {
            this.gL.removeCallbacksAndMessages(null);
            this.gL = null;
        }
        gD = null;
        this.gK = null;
        this.gG = null;
    }
}
