package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5889a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5890b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5891c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f5892d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f5893e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f5894f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5895a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5896b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5897c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5898d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f5899e;

        /* renamed from: f  reason: collision with root package name */
        public String f5900f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5901g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5902h = true;

        /* renamed from: i  reason: collision with root package name */
        public boolean f5903i = false;

        public a() {
            this.msgMap.put(1, c.f5891c);
            this.msgMap.put(2, c.f5892d);
            this.msgMap.put(-306, c.f5893e);
        }
    }

    public c(Context context) {
        this.f5894f = context;
    }

    public void a() {
    }
}
