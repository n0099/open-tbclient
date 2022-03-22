package c.a.p0.q4.n;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: c.a.p0.q4.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1343a {
        float a();

        void b(float f2);

        void onFinish();

        void onProgress(float f2);
    }

    void a();

    boolean b();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    void invalidate();

    void reset();

    void setMaxDuration(int i);

    void setMinDuration(int i);

    void setOnProgressListener(InterfaceC1343a interfaceC1343a);

    void setProgress(long j);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i);

    void start();

    void stop();
}
