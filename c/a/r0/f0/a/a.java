package c.a.r0.f0.a;

import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: c.a.r0.f0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0852a {
        void a();

        void b();
    }

    boolean a(QmFilterItem qmFilterItem);

    void b(InterfaceC0852a interfaceC0852a);

    void c(TbMultiMediaData tbMultiMediaData);

    long d();

    void e(float f2);

    boolean f();

    void g(boolean z);

    long getFrom();

    TbMediaTrackConfig getMediaTrackConfig();

    float getRatio();

    boolean isPlaying();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void start();
}
