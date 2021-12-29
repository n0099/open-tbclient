package c.a.a1.s;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.a1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0029a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC0029a interfaceC0029a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
