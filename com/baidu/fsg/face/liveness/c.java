package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5932a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5933b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5934c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f5935d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f5936e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f5937f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5938a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5939b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5940c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5941d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f5942e;

        /* renamed from: f  reason: collision with root package name */
        public String f5943f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5944g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5945h = true;

        /* renamed from: i  reason: collision with root package name */
        public boolean f5946i = false;

        public a() {
            this.msgMap.put(1, c.f5934c);
            this.msgMap.put(2, c.f5935d);
            this.msgMap.put(-306, c.f5936e);
        }
    }

    public c(Context context) {
        this.f5937f = context;
    }

    public void a() {
    }
}
