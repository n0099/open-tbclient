package b.a.x0.s;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: b.a.x0.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1481a {
        void onCompletion();

        boolean onError(int i2, int i3, Object obj);

        boolean onInfo(int i2, int i3, Object obj);
    }

    void release();

    void setListener(InterfaceC1481a interfaceC1481a);

    void setSource(ArrayList<String> arrayList);

    void start();
}
