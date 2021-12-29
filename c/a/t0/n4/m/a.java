package c.a.t0.n4.m;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: c.a.t0.n4.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1240a {
        float a();

        void b(float f2);

        void onFinish();

        void onProgress(float f2);
    }

    void deleteLast();

    int getMaxDuration();

    float getProgress();

    int getSlideNum();

    void invalidate();

    boolean isShowingDeleteLastTip();

    void reset();

    void setMaxDuration(int i2);

    void setMinDuration(int i2);

    void setOnProgressListener(InterfaceC1240a interfaceC1240a);

    void setProgress(long j2);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i2);

    void start();

    void stop();
}
