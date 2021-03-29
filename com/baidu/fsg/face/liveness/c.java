package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5937a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5938b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5939c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f5940d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f5941e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f5942f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5943a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5944b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5945c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5946d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f5947e;

        /* renamed from: f  reason: collision with root package name */
        public String f5948f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5949g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5950h = true;
        public boolean i = false;

        public a() {
            this.msgMap.put(1, c.f5939c);
            this.msgMap.put(2, c.f5940d);
            this.msgMap.put(-306, c.f5941e);
        }
    }

    public c(Context context) {
        this.f5942f = context;
    }

    public void a() {
    }
}
