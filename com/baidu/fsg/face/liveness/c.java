package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5972a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5973b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5974c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f5975d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f5976e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f5977f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5978a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5979b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5980c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5981d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f5982e;

        /* renamed from: f  reason: collision with root package name */
        public String f5983f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5984g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5985h = true;
        public boolean i = false;

        public a() {
            this.msgMap.put(1, c.f5974c);
            this.msgMap.put(2, c.f5975d);
            this.msgMap.put(-306, c.f5976e);
        }
    }

    public c(Context context) {
        this.f5977f = context;
    }

    public void a() {
    }
}
