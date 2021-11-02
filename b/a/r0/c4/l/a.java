package b.a.r0.c4.l;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: b.a.r0.c4.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0783a {
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

    void setOnProgressListener(InterfaceC0783a interfaceC0783a);

    void setProgress(long j);

    void setShowDeleteLastTip(boolean z);

    void setVisibility(int i2);

    void start();

    void stop();
}
