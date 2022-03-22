package c.a.p0.m0.c;

import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: c.a.p0.m0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1224a {
        void b(long j);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(String str);

        boolean b();
    }

    boolean a(QmFilterItem qmFilterItem);

    boolean b(QmStickerItem qmStickerItem);

    boolean c();

    boolean d();

    c.a.p0.f0.c.a e();

    c.a.p0.f0.b.a f();

    boolean onDestroy();

    boolean onPause();

    boolean onResume();

    boolean startRecord();

    boolean stopRecord();
}
