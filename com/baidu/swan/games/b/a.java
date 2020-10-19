package com.baidu.swan.games.b;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0502a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0502a interfaceC0502a) {
        com.baidu.swan.games.m.a.aRM().a(new InterfaceC0502a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onSuccess() {
                InterfaceC0502a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0502a
            public void onFail(String str) {
                InterfaceC0502a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0502a interfaceC0502a) {
        if (eVar.aDn().isLogin(eVar.aCU())) {
            interfaceC0502a.onSuccess();
        } else {
            eVar.aDn().a(eVar.aCU(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0502a.this.onSuccess();
                    } else {
                        InterfaceC0502a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0502a interfaceC0502a) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null || aDb.aCU() == null) {
            interfaceC0502a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aDb, new InterfaceC0502a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0502a
                public void onSuccess() {
                    a.a(new InterfaceC0502a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0502a
                        public void onSuccess() {
                            InterfaceC0502a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0502a
                        public void onFail(String str) {
                            InterfaceC0502a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0502a
                public void onFail(String str) {
                    InterfaceC0502a.this.onFail(str);
                }
            });
        }
    }
}
