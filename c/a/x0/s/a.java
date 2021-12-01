package c.a.x0.s;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: c.a.x0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1545a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1545a interfaceC1545a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
