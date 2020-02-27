package com.baidu.media.transcoder;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.baidu.media.transcoder.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0126a {
        void a(a aVar);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(a aVar, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(a aVar, int i, int i2, Object obj);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void b(a aVar);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void c(a aVar);
    }

    void prepareAsync();

    int probe();

    void release();

    void setDataSource(String str);

    void setNativeLogLevel(int i);

    void setOption(String str, String str2);

    void setOutputFile(String str);

    void start();

    void stop();
}
