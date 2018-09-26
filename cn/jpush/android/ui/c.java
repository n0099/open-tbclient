package cn.jpush.android.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v4.view.PointerIconCompat;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public final class c extends WebViewClient {
    private final cn.jpush.android.data.b a;
    private final Context b;
    private boolean c = false;

    public c(cn.jpush.android.data.b bVar, Context context) {
        this.a = bVar;
        this.b = context;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.c) {
            sslErrorHandler.proceed();
        } else if (this.b == null || this.b.getClass().isAssignableFrom(Activity.class)) {
            sslErrorHandler.cancel();
        } else {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
                builder.setTitle("提示");
                builder.setMessage("SSL 证书异常，是否继续加载？");
                builder.setNegativeButton("否", new d(this, sslErrorHandler));
                builder.setPositiveButton("是", new e(this, sslErrorHandler));
                builder.setCancelable(false);
                builder.create().show();
            } catch (Throwable th) {
                sslErrorHandler.cancel();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context = webView.getContext();
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.d.a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", str);
            if (this.a.F) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                cn.jpush.android.a.e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                return true;
            } else if (str.endsWith(".mp3")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "audio/*");
                webView.getContext().startActivity(intent);
                return true;
            } else if (str.endsWith(".mp4") || str.endsWith(".3gp")) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(str), "video/*");
                webView.getContext().startActivity(intent2);
                return true;
            } else if (str.endsWith(".apk")) {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else {
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    cn.jpush.android.a.e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                } else if (str.startsWith("mailto")) {
                    if (str.lastIndexOf("direct=") < 0 && !str.startsWith("mailto")) {
                        str = str.indexOf("?") > 0 ? str + "&direct=false" : str + "?direct=false";
                        str.lastIndexOf("direct=");
                    }
                    int indexOf = str.indexOf("?");
                    String substring = str.substring(0, indexOf);
                    String substring2 = str.substring(indexOf);
                    Intent intent3 = null;
                    if (substring.startsWith("mailto")) {
                        String[] split = substring.split(":");
                        if (split.length == 2) {
                            int indexOf2 = substring2.indexOf("&content=");
                            String substring3 = substring2.substring(substring2.indexOf("title=") + 6, indexOf2);
                            String substring4 = substring2.substring(indexOf2 + 9);
                            String[] strArr = {split[1]};
                            intent3 = new Intent("android.intent.action.SEND");
                            intent3.setType("plain/text");
                            intent3.putExtra("android.intent.extra.EMAIL", strArr);
                            intent3.putExtra("android.intent.extra.SUBJECT", substring3);
                            intent3.putExtra("android.intent.extra.TEXT", substring4);
                        }
                    }
                    if (intent3 != null) {
                        context.startActivity(intent3);
                    }
                    cn.jpush.android.a.e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
