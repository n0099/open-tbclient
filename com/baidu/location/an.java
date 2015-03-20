package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an {

    /* renamed from: goto  reason: not valid java name */
    private static an f43goto;

    /* renamed from: try  reason: not valid java name */
    private a f53try;

    /* renamed from: int  reason: not valid java name */
    private String f51int = null;

    /* renamed from: byte  reason: not valid java name */
    private String f44byte = null;

    /* renamed from: else  reason: not valid java name */
    private String f48else = null;

    /* renamed from: new  reason: not valid java name */
    public String f52new = null;
    private boolean a = false;

    /* renamed from: case  reason: not valid java name */
    private String f45case = null;

    /* renamed from: do  reason: not valid java name */
    private String f47do = null;

    /* renamed from: char  reason: not valid java name */
    private long f46char = 0;

    /* renamed from: for  reason: not valid java name */
    private long f49for = 0;

    /* renamed from: if  reason: not valid java name */
    private long f50if = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        boolean dL = false;
        String dJ = null;
        Messenger dK = null;

        public a() {
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = c.m256byte();
            if (an.this.f45case == null) {
                an.this.f45case = Jni.j("none");
            }
            this.cZ.add(new BasicNameValuePair("erpt[0]", an.this.f45case));
            if (an.this.f47do == null) {
                an.this.f47do = "none";
            }
            this.cZ.add(new BasicNameValuePair("erpt[1]", Jni.j(an.this.f47do)));
            if (this.dJ == null) {
                this.dJ = "none";
            }
            this.cZ.add(new BasicNameValuePair("erpt[2]", Jni.j(this.dJ)));
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append("&t1=");
            stringBuffer.append(an.this.f50if);
            stringBuffer.append("&t2=");
            stringBuffer.append(an.this.f46char);
            String a6 = z.bc().a6();
            if (a6 != null) {
                stringBuffer.append(a6);
            }
            this.cZ.add(new BasicNameValuePair("erpt[3]", Jni.j(stringBuffer.toString())));
            an.this.f45case = null;
            an.this.f47do = null;
            an.this.f46char = 0L;
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (this.cZ != null) {
                this.cZ.clear();
            }
            try {
                this.dK.send(z ? Message.obtain((Handler) null, (int) a0.P) : Message.obtain((Handler) null, (int) a0.b));
            } catch (Exception e) {
            }
            this.dL = false;
        }

        /* renamed from: try  reason: not valid java name */
        public void m185try(Message message) {
            this.dK = message.replyTo;
            if (this.dL) {
                try {
                    this.dK.send(Message.obtain((Handler) null, (int) a0.b));
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            this.dL = true;
            this.dJ = message.getData().getString("errInfo");
            R();
        }
    }

    private an() {
        this.f53try = null;
        this.f53try = new a();
    }

    public static an a() {
        if (f43goto == null) {
            f43goto = new an();
        }
        return f43goto;
    }

    public void a(Message message) {
        if (this.f45case == null || this.f47do == null) {
            this.f45case = this.f51int;
            this.f47do = this.f44byte;
        }
        this.f53try.m185try(message);
    }

    public void a(String str) {
        this.f48else = str;
        this.a = true;
        this.f49for = System.currentTimeMillis();
    }

    /* renamed from: do  reason: not valid java name */
    public void m182do() {
        this.f45case = this.f51int;
        this.f47do = this.f44byte;
        this.f46char = System.currentTimeMillis();
    }

    /* renamed from: if  reason: not valid java name */
    public void m183if() {
        this.f45case = null;
        this.f47do = null;
        this.f46char = 0L;
    }

    /* renamed from: if  reason: not valid java name */
    public void m184if(String str) {
        if (this.a) {
            this.f51int = this.f48else;
            this.a = false;
            this.f50if = this.f49for;
        }
        this.f44byte = str;
    }
}
