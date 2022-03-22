package c.a.v0.q;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: c.a.v0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1617a {
        void onCompletion();

        boolean onError(int i, int i2, Object obj);

        boolean onInfo(int i, int i2, Object obj);
    }

    void release();

    void setListener(InterfaceC1617a interfaceC1617a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
