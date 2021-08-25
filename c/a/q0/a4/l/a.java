package c.a.q0.a4.l;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: c.a.q0.a4.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0746a {
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

    void setOnProgressListener(InterfaceC0746a interfaceC0746a);

    void setProgress(long j2);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i2);

    void start();

    void stop();
}
