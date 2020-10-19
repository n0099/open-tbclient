package com.baidu.location.e;

import java.util.Map;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public abstract class f {
    public String h = null;
    public int i = 1;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;
    public static int g = a.g;

    /* renamed from: a  reason: collision with root package name */
    private static String f1949a = "10.0.0.172";
    private static int b = 80;
    protected static int p = 0;

    public abstract void a();

    public void a(ExecutorService executorService) {
        try {
            executorService.execute(new g(this));
        } catch (Throwable th) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, String str) {
        try {
            executorService.execute(new j(this, str));
        } catch (Throwable th) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new h(this, str, z));
        } catch (Throwable th) {
            a(false);
        }
    }

    public abstract void a(boolean z);

    public void b(String str) {
        try {
            new i(this, str).start();
        } catch (Throwable th) {
            a(false);
        }
    }
}
