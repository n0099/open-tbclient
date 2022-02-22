package c.a.b1.s;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.b1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0031a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC0031a interfaceC0031a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
