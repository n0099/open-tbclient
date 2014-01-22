package com.baidu.sapi2.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
/* loaded from: classes.dex */
public class e implements Serializable {
    private static final long a = 6374381828722046732L;
    private final transient Cookie b;
    private transient BasicClientCookie c;

    public e(Cookie cookie) {
        this.b = cookie;
    }

    public Cookie a() {
        Cookie cookie = this.b;
        if (this.c != null) {
            return this.c;
        }
        return cookie;
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.b.getName());
        objectOutputStream.writeObject(this.b.getValue());
        objectOutputStream.writeObject(this.b.getComment());
        objectOutputStream.writeObject(this.b.getDomain());
        objectOutputStream.writeObject(this.b.getExpiryDate());
        objectOutputStream.writeObject(this.b.getPath());
        objectOutputStream.writeInt(this.b.getVersion());
        objectOutputStream.writeBoolean(this.b.isSecure());
    }

    private void a(ObjectInputStream objectInputStream) {
        this.c = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.c.setComment((String) objectInputStream.readObject());
        this.c.setDomain((String) objectInputStream.readObject());
        this.c.setExpiryDate((Date) objectInputStream.readObject());
        this.c.setPath((String) objectInputStream.readObject());
        this.c.setVersion(objectInputStream.readInt());
        this.c.setSecure(objectInputStream.readBoolean());
    }
}
