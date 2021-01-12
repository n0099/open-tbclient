package com.baidu.swan.games.b;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0514a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0514a interfaceC0514a) {
        com.baidu.swan.games.m.a.aXe().a(new InterfaceC0514a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onSuccess() {
                InterfaceC0514a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0514a
            public void onFail(String str) {
                InterfaceC0514a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0514a interfaceC0514a) {
        if (eVar.aIE().isLogin(eVar.aIl())) {
            interfaceC0514a.onSuccess();
        } else {
            eVar.aIE().a(eVar.aIl(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0514a.this.onSuccess();
                    } else {
                        InterfaceC0514a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0514a interfaceC0514a) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null || aIs.aIl() == null) {
            interfaceC0514a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aIs, new InterfaceC0514a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0514a
                public void onSuccess() {
                    a.a(new InterfaceC0514a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0514a
                        public void onSuccess() {
                            InterfaceC0514a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0514a
                        public void onFail(String str) {
                            InterfaceC0514a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0514a
                public void onFail(String str) {
                    InterfaceC0514a.this.onFail(str);
                }
            });
        }
    }
}
