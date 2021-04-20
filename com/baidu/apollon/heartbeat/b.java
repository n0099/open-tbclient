package com.baidu.apollon.heartbeat;

import com.baidu.apollon.a.a;
import com.baidu.apollon.utils.LogUtil;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3682a = "b";

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.a.a f3683b = null;

    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3689a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3690b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3691c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f3692d = 4;

        public a() {
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0060b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3694a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3695b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3696c = 3;

        public C0060b() {
        }
    }

    public b() {
        b();
    }

    private void b() {
        com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
        this.f3683b = aVar;
        aVar.getClass();
        aVar.a(new a.b(1, 3, 1, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.1
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3682a;
                LogUtil.i(str, b.f3682a + " Idle ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar2 = this.f3683b;
        aVar2.getClass();
        aVar2.a(new a.b(3, 1, 2, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.2
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3682a;
                LogUtil.i(str, b.f3682a + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar3 = this.f3683b;
        aVar3.getClass();
        aVar3.a(new a.b(3, 2, 3, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.3
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3682a;
                LogUtil.i(str, b.f3682a + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }));
        com.baidu.apollon.a.a aVar4 = this.f3683b;
        aVar4.getClass();
        aVar4.a(new a.b(2, 3, 4, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.4
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3682a;
                LogUtil.i(str, b.f3682a + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar5 = this.f3683b;
        aVar5.getClass();
        aVar5.a(new a.b(2, 1, 2, new a.InterfaceC0058a() { // from class: com.baidu.apollon.heartbeat.b.5
            @Override // com.baidu.apollon.a.a.InterfaceC0058a
            public void a() {
                String str = b.f3682a;
                LogUtil.i(str, b.f3682a + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
    }

    public void a(int i) {
        if (i >= 1 && i <= 4) {
            com.baidu.apollon.a.a aVar = this.f3683b;
            if (aVar != null) {
                aVar.b(i);
                return;
            }
            throw new RuntimeException(f3682a + " sendEvent but the mStateMachine is null.");
        }
        throw new IllegalArgumentException(f3682a + " invalid params eventId:" + i);
    }
}
