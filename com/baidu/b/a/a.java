package com.baidu.b.a;

import com.baidu.b.a.a.a;
import com.baidu.b.a.h.e;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    public static final Map<String, String> YV = new HashMap();

    /* renamed from: com.baidu.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0056a {

        /* renamed from: com.baidu.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0057a {
            public static final String YW = e.bI(a.C0058a.META_ERROR_NETWORK);
            public static final String YX = e.bI(a.C0058a.META_ERROR_CONNECTION);
            public static final String YY = e.bI(a.C0058a.META_ERROR_PARAMS);
            public static final String YZ = e.bI(a.C0058a.META_ERROR_RESPONSE);
            public static final String Za = e.bI(a.C0058a.DOWNLOAD_SUCCESS);
            public static final String Zb = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWORK);
            public static final String Zc = e.bI(a.C0058a.DOWNLOAD_ERROR_MD5);
            public static final String Zd = e.bI(a.C0058a.DOWNLOAD_ERROR_PATH);
            public static final String Ze = e.bI(a.C0058a.DOWNLOAD_ERROR_CREATEFILE);
            public static final String Zf = e.bI(a.C0058a.DOWNLOAD_ERROR_NOSPACE);
            public static final String Zg = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWROK_CHANGE);
            public static final String Zh = e.bI(a.C0058a.DOWNLOAD_ERROR_WRITE);
            public static final String Zi = e.bI(a.C0058a.DOWNLOAD_PAUSED);
            public static final String Zj = e.bI(a.C0058a.DOWNLOAD_RESUMED);
            public static final String Zk = e.bI(a.C0058a.DOWNLOAD_CANCELED);
            public static final String Zl = e.bI(a.C0058a.DOWNLOAD_ERROR_DUPLICATED);
            public static final String Zm = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWROK_LIMIT);
            public static final String Zn = e.bI(a.C0058a.DOWNLOAD_ERROR_MISS_PARAM);
            public static final String Zo = e.bI(a.C0058a.INSTALL_SUCCESS);
            public static final String Zp = e.bI(a.C0058a.INSTALL_ERROR);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static final String Zq = com.baidu.b.a.g.a.se().sf() + "&action=";
        public static final String Zr = com.baidu.b.a.g.a.se().sg() + "&action=";
        public static final String Zs = Zq + "api";
        public static final String Zt = Zr + "api";
    }

    static {
        YV.put("1", b.Zs);
        YV.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, b.Zs);
        YV.put("17", b.Zs);
        YV.put("18", b.Zs);
        YV.put("20", b.Zs);
        YV.put("21", b.Zt);
        YV.put("30", b.Zs);
        YV.put("32", b.Zs);
        YV.put("33", b.Zs);
        YV.put("38", b.Zs);
        YV.put("42", b.Zs);
    }
}
