package c.a.s0.l0.a;

import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: c.a.s0.l0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1145a {
        void a();

        void b();

        void c();
    }

    boolean a(QmFilterItem qmFilterItem);

    void b(InterfaceC1145a interfaceC1145a);

    void c(TbMultiMediaData tbMultiMediaData);

    long d();

    void e();

    void f(float f2);

    boolean g();

    long getCurrentPlayTime();

    long getFrom();

    TbMediaTrackConfig getMediaTrackConfig();

    float getRatio();

    void h(boolean z);

    boolean isPlaying();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void start();
}
