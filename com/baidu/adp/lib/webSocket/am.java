package com.baidu.adp.lib.webSocket;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private an f530a = null;
    private int b = 1;
    private String c;
    private byte[] d;

    public am(byte[] bArr, an anVar) {
        a(bArr, anVar);
    }

    private void a(byte[] bArr, an anVar) {
        if (bArr == null) {
            throw new InvalidParameterException("WebSocketSendData data null");
        }
        this.b = 2;
        this.d = bArr;
        this.f530a = anVar;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public byte[] c() {
        return this.d;
    }

    public an d() {
        return this.f530a;
    }
}
