package com.baidu.swan.games.b;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0511a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0511a interfaceC0511a) {
        com.baidu.swan.games.m.a.aXq().a(new InterfaceC0511a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0511a
            public void onSuccess() {
                InterfaceC0511a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0511a
            public void onFail(String str) {
                InterfaceC0511a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0511a interfaceC0511a) {
        if (eVar.aIX().isLogin(eVar.aIE())) {
            interfaceC0511a.onSuccess();
        } else {
            eVar.aIX().a(eVar.aIE(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0511a.this.onSuccess();
                    } else {
                        InterfaceC0511a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0511a interfaceC0511a) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null || aIL.aIE() == null) {
            interfaceC0511a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aIL, new InterfaceC0511a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0511a
                public void onSuccess() {
                    a.a(new InterfaceC0511a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0511a
                        public void onSuccess() {
                            InterfaceC0511a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0511a
                        public void onFail(String str) {
                            InterfaceC0511a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0511a
                public void onFail(String str) {
                    InterfaceC0511a.this.onFail(str);
                }
            });
        }
    }
}
