package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5989a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5990b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5991c = ResUtils.string("error_msg_get_userinfo_failure");

    /* renamed from: d  reason: collision with root package name */
    public static final String f5992d = ResUtils.string("error_msg_upload_failure");

    /* renamed from: e  reason: collision with root package name */
    public static final String f5993e = ResUtils.string("error_msg_image_file_empty");

    /* renamed from: f  reason: collision with root package name */
    public Context f5994f;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.fsg.face.base.c.a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f5995a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f5996b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f5997c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f5998d = -306;

        /* renamed from: e  reason: collision with root package name */
        public String f5999e;

        /* renamed from: f  reason: collision with root package name */
        public String f6000f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6001g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6002h = true;

        /* renamed from: i  reason: collision with root package name */
        public boolean f6003i = false;

        public a() {
            this.msgMap.put(1, c.f5991c);
            this.msgMap.put(2, c.f5992d);
            this.msgMap.put(-306, c.f5993e);
        }
    }

    public c(Context context) {
        this.f5994f = context;
    }

    public void a() {
    }
}
