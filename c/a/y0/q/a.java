package c.a.y0.q;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: c.a.y0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1628a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1628a interfaceC1628a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
