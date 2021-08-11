package c.a.v0.s;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: c.a.v0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1424a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1424a interfaceC1424a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
