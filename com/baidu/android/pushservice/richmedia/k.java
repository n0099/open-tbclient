package com.baidu.android.pushservice.richmedia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
class k extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaViewActivity f635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MediaViewActivity mediaViewActivity) {
        this.f635a = mediaViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String substring;
        if (str.startsWith("tel:")) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                this.f635a.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.e("MediaViewActivity", "Error dialing " + str + ": " + e.toString());
            }
        } else if (str.startsWith("geo:")) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                this.f635a.startActivity(intent2);
            } catch (ActivityNotFoundException e2) {
                Log.e("MediaViewActivity", "Error showing map " + str + ": " + e2.toString());
            }
        } else if (str.startsWith("mailto:")) {
            try {
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setData(Uri.parse(str));
                this.f635a.startActivity(intent3);
            } catch (ActivityNotFoundException e3) {
                Log.e("MediaViewActivity", "Error sending email " + str + ": " + e3.toString());
            }
        } else if (str.startsWith("sms:")) {
            try {
                Intent intent4 = new Intent("android.intent.action.VIEW");
                int indexOf = str.indexOf(63);
                if (indexOf == -1) {
                    substring = str.substring(4);
                } else {
                    substring = str.substring(4, indexOf);
                    String query = Uri.parse(str).getQuery();
                    if (query != null && query.startsWith("body=")) {
                        intent4.putExtra("sms_body", query.substring(5));
                    }
                }
                intent4.setData(Uri.parse("sms:" + substring));
                intent4.putExtra("address", substring);
                intent4.setType("vnd.android-dir/mms-sms");
                this.f635a.startActivity(intent4);
            } catch (ActivityNotFoundException e4) {
                Log.e("MediaViewActivity", "Error sending sms " + str + ":" + e4.toString());
            }
        }
        try {
            Intent intent5 = new Intent("android.intent.action.VIEW");
            intent5.setData(Uri.parse(str));
            this.f635a.startActivity(intent5);
            return true;
        } catch (ActivityNotFoundException e5) {
            Log.e("MediaViewActivity", "Error loading url " + str, e5);
            return true;
        }
    }
}
