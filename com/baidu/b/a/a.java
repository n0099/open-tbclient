package com.baidu.b.a;

import com.baidu.b.a.a.a;
import com.baidu.b.a.h.e;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    public static final Map<String, String> YM = new HashMap();

    /* renamed from: com.baidu.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0056a {

        /* renamed from: com.baidu.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0057a {
            public static final String YN = e.bI(a.C0058a.META_ERROR_NETWORK);
            public static final String YO = e.bI(a.C0058a.META_ERROR_CONNECTION);
            public static final String YP = e.bI(a.C0058a.META_ERROR_PARAMS);
            public static final String YQ = e.bI(a.C0058a.META_ERROR_RESPONSE);
            public static final String YR = e.bI(a.C0058a.DOWNLOAD_SUCCESS);
            public static final String YS = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWORK);
            public static final String YT = e.bI(a.C0058a.DOWNLOAD_ERROR_MD5);
            public static final String YU = e.bI(a.C0058a.DOWNLOAD_ERROR_PATH);
            public static final String YV = e.bI(a.C0058a.DOWNLOAD_ERROR_CREATEFILE);
            public static final String YW = e.bI(a.C0058a.DOWNLOAD_ERROR_NOSPACE);
            public static final String YX = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWROK_CHANGE);
            public static final String YY = e.bI(a.C0058a.DOWNLOAD_ERROR_WRITE);
            public static final String YZ = e.bI(a.C0058a.DOWNLOAD_PAUSED);
            public static final String Za = e.bI(a.C0058a.DOWNLOAD_RESUMED);
            public static final String Zb = e.bI(a.C0058a.DOWNLOAD_CANCELED);
            public static final String Zc = e.bI(a.C0058a.DOWNLOAD_ERROR_DUPLICATED);
            public static final String Zd = e.bI(a.C0058a.DOWNLOAD_ERROR_NETWROK_LIMIT);
            public static final String Ze = e.bI(a.C0058a.DOWNLOAD_ERROR_MISS_PARAM);
            public static final String Zf = e.bI(a.C0058a.INSTALL_SUCCESS);
            public static final String Zg = e.bI(a.C0058a.INSTALL_ERROR);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static final String Zh = com.baidu.b.a.g.a.sa().sb() + "&action=";
        public static final String Zi = com.baidu.b.a.g.a.sa().sc() + "&action=";
        public static final String Zj = Zh + "api";
        public static final String Zk = Zi + "api";
    }

    static {
        YM.put("1", b.Zj);
        YM.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, b.Zj);
        YM.put("17", b.Zj);
        YM.put("18", b.Zj);
        YM.put("20", b.Zj);
        YM.put("21", b.Zk);
        YM.put("30", b.Zj);
        YM.put("32", b.Zj);
        YM.put("33", b.Zj);
        YM.put("38", b.Zj);
        YM.put("42", b.Zj);
    }
}
