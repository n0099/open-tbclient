package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import java.io.ByteArrayInputStream;
import java.security.Key;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class b {
    private static final String a = "0123456789ABCDEF";
    private String b;
    private i c = new i();

    /* loaded from: classes.dex */
    public class a {
        public static final int a = 2;
        public static final String b = "-----BEGIN CERTIFICATE-----\nMIIChzCCAfACAQAwDQYJKoZIhvcNAQEEBQAwgYsxCzAJBgNVBAYTAkNOMRAwDgYD\nVQQIEwdiZWlqaW5nMRAwDgYDVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEO\nMAwGA1UECxMFYmFpZHUxFjAUBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG\n9w0BCQEWEXBhc3MtcmRAYmFpZHUuY29tMB4XDTEzMDMyMjA5NTYyM1oXDTIzMDMy\nMDA5NTYyM1owgYsxCzAJBgNVBAYTAkNOMRAwDgYDVQQIEwdiZWlqaW5nMRAwDgYD\nVQQHEwdiZWlqaW5nMQ4wDAYDVQQKEwViYWlkdTEOMAwGA1UECxMFYmFpZHUxFjAU\nBgNVBAMTDXd3dy5iYWlkdS5jb20xIDAeBgkqhkiG9w0BCQEWEXBhc3MtcmRAYmFp\nZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzxh67pGWcTONjkofu\nhx8fSPeTDql3mRx6/jzEQv6klkMhLn1XDIU/NoBlzFeiAUZm2orn1JP9R9FxwNiU\n7uPtf5n2eYt//XtYcyJwOK0j4xl2MajLZCITufJ9SQGrDZK/onVCrokIVTlu2Sd1\nJVyXf1wwLx5+1LHjacEstrGCLwIDAQABMA0GCSqGSIb3DQEBBAUAA4GBAFaJ31WX\nD5F1MOFVQtK5Z22eaClL1NZaqjlt7IC22ovWhfO836K07YrYgF97w3DdAsJxXpG+\ny/y8HAvAnPN5IzI1Or6nMgEVZLawkkbvttbcAkhW4fleZPsn06aVYZ1sSxQok/k/\nZOj/cz22nU8JgmiJL0ZChHeHyC3VusOHtUW3\n-----END CERTIFICATE-----";
    }

    /* renamed from: com.baidu.sapi2.utils.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0021b {
        public static final int a = 1;
        public static final String b = "-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----";
    }

    public b() {
        this.b = "kf1t9tsczk16vc8z";
        this.b = b();
    }

    public String a() {
        return this.b;
    }

    public String a(String str, String str2) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes("UTF-8");
        if (bytes.length % 116 == 0) {
            length = bytes.length / 116;
        } else {
            length = (bytes.length / 116) + 1;
        }
        for (int i = 0; i < length; i++) {
            if (1 == length) {
                jSONArray.put(Base64.encode(a(publicKey, bytes), "UTF-8"));
            } else if (i != length - 1) {
                byte[] bArr = new byte[116];
                System.arraycopy(bytes, i * 116, bArr, 0, 116);
                jSONArray.put(Base64.encode(a(publicKey, bArr), "UTF-8"));
            } else {
                int length2 = bytes.length - (i * 116);
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i * 116, bArr2, 0, length2);
                jSONArray.put(Base64.encode(a(publicKey, bArr2), "UTF-8"));
            }
        }
        return Base64.encode(jSONArray.toString().getBytes("UTF-8"), "UTF-8");
    }

    public String a(String str) {
        return new String(this.c.a(Base64.decode(str.getBytes()), new StringBuffer(this.b).reverse().toString(), this.b), "UTF-8");
    }

    private String b() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return sb.toString();
    }

    private byte[] a(Key key, byte[] bArr) {
        Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public static String b(String str) {
        try {
            return new String(new i().a(Base64.decode(str.getBytes()), new StringBuffer(g.K).reverse().toString(), g.K), "UTF-8").trim();
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    public static String c(String str) {
        try {
            return Base64.encode(new i().a(str, new StringBuffer(g.K).reverse().toString(), g.K), "UTF-8");
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    public static byte[] d(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(a.charAt((b >> 4) & 15)).append(a.charAt(b & 15));
        }
        return sb.toString();
    }

    public static String e(String str) {
        byte[] a2;
        if (str == null || (a2 = d.a(String.valueOf(TextUtils.getReverse(str, 0, str.length())), a.b)) == null) {
            return null;
        }
        return a(a2);
    }
}
