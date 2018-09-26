package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes3.dex */
public class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final String c = ResUtils.string("error_msg_get_userinfo_failure");
    public static final String d = ResUtils.string("error_msg_upload_failure");
    public static final String e = ResUtils.string("error_msg_image_file_empty");
    private Context f;

    public c(Context context) {
        this.f = context;
    }

    public void a() {
    }

    /* loaded from: classes3.dex */
    public class a extends com.baidu.fsg.face.base.c.a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 5;
        public static final int d = -306;
        public String e;
        public String f;
        public boolean g;
        public boolean h = true;
        public boolean i = false;

        a() {
            this.msgMap.put(1, c.c);
            this.msgMap.put(2, c.d);
            this.msgMap.put(-306, c.e);
        }
    }
}
