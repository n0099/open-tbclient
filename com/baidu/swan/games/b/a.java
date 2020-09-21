package com.baidu.swan.games.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0485a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0485a interfaceC0485a) {
        com.baidu.swan.games.m.a.aPd().a(new InterfaceC0485a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0485a
            public void onSuccess() {
                InterfaceC0485a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0485a
            public void onFail(String str) {
                InterfaceC0485a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0485a interfaceC0485a) {
        if (eVar.aAE().isLogin(eVar.aAl())) {
            interfaceC0485a.onSuccess();
        } else {
            eVar.aAE().a(eVar.aAl(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0485a.this.onSuccess();
                    } else {
                        InterfaceC0485a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0485a interfaceC0485a) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null || aAs.aAl() == null) {
            interfaceC0485a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aAs, new InterfaceC0485a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0485a
                public void onSuccess() {
                    a.a(new InterfaceC0485a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0485a
                        public void onSuccess() {
                            InterfaceC0485a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0485a
                        public void onFail(String str) {
                            InterfaceC0485a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0485a
                public void onFail(String str) {
                    InterfaceC0485a.this.onFail(str);
                }
            });
        }
    }
}
