package com.baidu.swan.games.b;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0429a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0429a interfaceC0429a) {
        com.baidu.swan.games.m.a.aBW().a(new InterfaceC0429a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0429a
            public void onSuccess() {
                InterfaceC0429a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0429a
            public void onFail(String str) {
                InterfaceC0429a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0429a interfaceC0429a) {
        if (eVar.apZ().isLogin(eVar.apG())) {
            interfaceC0429a.onSuccess();
        } else {
            eVar.apZ().a(eVar.apG(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0429a.this.onSuccess();
                    } else {
                        InterfaceC0429a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0429a interfaceC0429a) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null || apN.apG() == null) {
            interfaceC0429a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(apN, new InterfaceC0429a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                public void onSuccess() {
                    a.a(new InterfaceC0429a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                        public void onSuccess() {
                            InterfaceC0429a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                        public void onFail(String str) {
                            InterfaceC0429a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0429a
                public void onFail(String str) {
                    InterfaceC0429a.this.onFail(str);
                }
            });
        }
    }
}
