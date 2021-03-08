package com.baidu.browser.sailor.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f1322a = null;

    /* JADX WARN: Removed duplicated region for block: B:36:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                dataInputStream = new DataInputStream(new FileInputStream(str));
                try {
                    byte[] bArr = new byte[131072];
                    while (true) {
                        int read = dataInputStream.read(bArr);
                        if (read == -1) {
                            String a2 = a(messageDigest.digest(), "");
                            try {
                                dataInputStream.close();
                                return a2;
                            } catch (Exception e) {
                                return a2;
                            }
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        dataInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            dataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static boolean a() {
        String processTypeString = WebKitFactory.getProcessTypeString();
        if (TextUtils.isEmpty(processTypeString) || !processTypeString.equals("1")) {
            WebViewFactoryProvider provider = WebViewFactory.getProvider();
            return (provider != null ? (Boolean) provider.getStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE) : false).booleanValue();
        }
        return false;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (activeNetworkInfo.isAvailable()) {
                return 1 == type;
            }
        }
        return false;
    }

    public static boolean a(View view) {
        ViewParent parent;
        if (view != null && (parent = view.getParent()) != null && view.getVisibility() == 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            int childCount = viewGroup.getChildCount();
            if (indexOfChild == childCount - 1) {
                return true;
            }
            for (int i = indexOfChild + 1; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0 && childAt.getHeight() > 0 && childAt.getWidth() > 0 && view.getHeight() > 0 && view.getWidth() > 0 && childAt.getWidth() >= view.getWidth() && childAt.getHeight() >= view.getHeight()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(new String(a.a(str.getBytes())), "UTF-8");
        } catch (Exception e) {
            Log.printStackTrace(e);
            return "";
        }
    }
}
