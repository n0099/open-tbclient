package com.baidu.apollon.heartbeat;

import com.baidu.apollon.a.a;
import com.baidu.apollon.utils.LogUtil;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3732a = "b";

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.a.a f3733b = null;

    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3739a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3740b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3741c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f3742d = 4;

        public a() {
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0060b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3744a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3745b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3746c = 3;

        public C0060b() {
        }
    }

    public b() {
        b();
    }

    private void b() {
        com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
        this.f3733b = aVar;
        aVar.getClass();
        aVar.a(new a.b(1, 3, 1, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.1
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3732a;
                LogUtil.i(str, b.f3732a + " Idle ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar2 = this.f3733b;
        aVar2.getClass();
        aVar2.a(new a.b(3, 1, 2, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.2
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3732a;
                LogUtil.i(str, b.f3732a + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar3 = this.f3733b;
        aVar3.getClass();
        aVar3.a(new a.b(3, 2, 3, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.3
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3732a;
                LogUtil.i(str, b.f3732a + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }));
        com.baidu.apollon.a.a aVar4 = this.f3733b;
        aVar4.getClass();
        aVar4.a(new a.b(2, 3, 4, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.4
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3732a;
                LogUtil.i(str, b.f3732a + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar5 = this.f3733b;
        aVar5.getClass();
        aVar5.a(new a.b(2, 1, 2, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.5
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3732a;
                LogUtil.i(str, b.f3732a + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
    }

    public void a(int i2) {
        if (i2 >= 1 && i2 <= 4) {
            com.baidu.apollon.a.a aVar = this.f3733b;
            if (aVar != null) {
                aVar.b(i2);
                return;
            }
            throw new RuntimeException(f3732a + " sendEvent but the mStateMachine is null.");
        }
        throw new IllegalArgumentException(f3732a + " invalid params eventId:" + i2);
    }
}
