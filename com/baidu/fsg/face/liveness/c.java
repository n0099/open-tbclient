package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6135a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6136b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f6137c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f6138d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f6139e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f6140f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6141a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f6142b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6143c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6144d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f6145e;

        /* renamed from: f  reason: collision with root package name */
        public String f6146f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6147g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6148h = true;

        /* renamed from: i  reason: collision with root package name */
        public boolean f6149i = false;

        public a() {
            this.msgMap.put(1, c.f6137c);
            this.msgMap.put(2, c.f6138d);
            this.msgMap.put(-306, c.f6139e);
        }
    }

    public c(Context context) {
        this.f6140f = context;
    }

    public void a() {
    }
}
