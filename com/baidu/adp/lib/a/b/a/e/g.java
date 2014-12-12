package com.baidu.adp.lib.a.b.a.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.adp.lib.a.b.a.d.h;
import com.baidu.adp.lib.a.b.a.d.i;
import com.baidu.adp.lib.a.b.a.d.j;
import com.baidu.adp.lib.a.b.a.d.k;
import com.baidu.adp.lib.a.b.a.d.l;
import com.baidu.adp.lib.a.b.a.d.m;
import com.baidu.adp.lib.a.b.a.d.n;
import com.baidu.adp.lib.a.b.a.d.o;
import com.baidu.adp.lib.a.b.a.d.p;
import com.baidu.adp.lib.a.b.a.d.q;
import com.baidu.adp.lib.a.b.a.d.r;
import com.baidu.adp.lib.a.b.a.d.s;
import com.baidu.adp.lib.a.b.a.d.t;
import com.baidu.adp.lib.a.b.a.d.u;
import com.squareup.wire.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    /* JADX WARN: Removed duplicated region for block: B:110:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h i(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return new com.baidu.adp.lib.a.b.a.d.b(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Bundle) {
            return new com.baidu.adp.lib.a.b.a.d.c((Bundle) obj);
        }
        if (obj instanceof Byte) {
            return new com.baidu.adp.lib.a.b.a.d.d(((Byte) obj).byteValue());
        }
        if (obj instanceof Character) {
            return new com.baidu.adp.lib.a.b.a.d.e(((Character) obj).charValue());
        }
        if (obj instanceof Double) {
            return new com.baidu.adp.lib.a.b.a.d.f(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return new com.baidu.adp.lib.a.b.a.d.g(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return new i(((Integer) obj).intValue());
        }
        if (obj instanceof JSONArray) {
            return new j((JSONArray) obj);
        }
        if (obj instanceof JSONObject) {
            return new k((JSONObject) obj);
        }
        if (obj instanceof Long) {
            return new m(((Long) obj).longValue());
        }
        if (obj instanceof Short) {
            return new s(((Short) obj).shortValue());
        }
        if (obj instanceof String) {
            return new u((String) obj);
        }
        if (obj instanceof SparseArray) {
            return new t((SparseArray) obj);
        }
        if (obj instanceof List) {
            return new l((List) obj);
        }
        if (obj instanceof Queue) {
            return new q((Queue) obj);
        }
        if (obj instanceof Set) {
            return new r((Set) obj);
        }
        if (obj instanceof Map) {
            return new n((Map) obj);
        }
        if (obj instanceof Message) {
            return new p((Message) obj);
        }
        if (obj.getClass().isArray()) {
            return new com.baidu.adp.lib.a.b.a.d.a(obj);
        }
        if (obj instanceof CharSequence) {
            return new u(((CharSequence) obj).toString());
        }
        if (obj instanceof Serializable) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    try {
                        objectOutputStream.writeObject(obj);
                        objectOutputStream.flush();
                        com.baidu.adp.lib.a.b.a.d.a aVar = new com.baidu.adp.lib.a.b.a.d.a(byteArrayOutputStream.toByteArray());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            return aVar;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return aVar;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        o oVar = new o(obj);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            return oVar;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return oVar;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e9) {
                objectOutputStream = null;
                e = e9;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
                if (objectOutputStream != null) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } else if (obj instanceof IBinder) {
            return new o(obj);
        } else {
            if (obj instanceof Parcelable) {
                return new o(obj);
            }
            return new o(obj);
        }
    }
}
