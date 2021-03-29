package com.baidu.apollon.heartbeat;

import com.baidu.apollon.a.a;
import com.baidu.apollon.utils.LogUtil;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3647a = "b";

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.a.a f3648b = null;

    /* loaded from: classes.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3654a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3655b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3656c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f3657d = 4;

        public a() {
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0061b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f3659a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3660b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3661c = 3;

        public C0061b() {
        }
    }

    public b() {
        b();
    }

    private void b() {
        com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
        this.f3648b = aVar;
        aVar.getClass();
        aVar.a(new a.b(1, 3, 1, new a.InterfaceC0059a() { // from class: com.baidu.apollon.heartbeat.b.1
            @Override // com.baidu.apollon.a.a.InterfaceC0059a
            public void a() {
                String str = b.f3647a;
                LogUtil.i(str, b.f3647a + " Idle ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar2 = this.f3648b;
        aVar2.getClass();
        aVar2.a(new a.b(3, 1, 2, new a.InterfaceC0059a() { // from class: com.baidu.apollon.heartbeat.b.2
            @Override // com.baidu.apollon.a.a.InterfaceC0059a
            public void a() {
                String str = b.f3647a;
                LogUtil.i(str, b.f3647a + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar3 = this.f3648b;
        aVar3.getClass();
        aVar3.a(new a.b(3, 2, 3, new a.InterfaceC0059a() { // from class: com.baidu.apollon.heartbeat.b.3
            @Override // com.baidu.apollon.a.a.InterfaceC0059a
            public void a() {
                String str = b.f3647a;
                LogUtil.i(str, b.f3647a + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }));
        com.baidu.apollon.a.a aVar4 = this.f3648b;
        aVar4.getClass();
        aVar4.a(new a.b(2, 3, 4, new a.InterfaceC0059a() { // from class: com.baidu.apollon.heartbeat.b.4
            @Override // com.baidu.apollon.a.a.InterfaceC0059a
            public void a() {
                String str = b.f3647a;
                LogUtil.i(str, b.f3647a + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().a(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar5 = this.f3648b;
        aVar5.getClass();
        aVar5.a(new a.b(2, 1, 2, new a.InterfaceC0059a() { // from class: com.baidu.apollon.heartbeat.b.5
            @Override // com.baidu.apollon.a.a.InterfaceC0059a
            public void a() {
                String str = b.f3647a;
                LogUtil.i(str, b.f3647a + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
    }

    public void a(int i) {
        if (i >= 1 && i <= 4) {
            com.baidu.apollon.a.a aVar = this.f3648b;
            if (aVar != null) {
                aVar.b(i);
                return;
            }
            throw new RuntimeException(f3647a + " sendEvent but the mStateMachine is null.");
        }
        throw new IllegalArgumentException(f3647a + " invalid params eventId:" + i);
    }
}
