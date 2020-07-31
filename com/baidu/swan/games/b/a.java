package com.baidu.swan.games.b;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0442a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0442a interfaceC0442a) {
        com.baidu.swan.games.m.a.aFD().a(new InterfaceC0442a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0442a
            public void onSuccess() {
                InterfaceC0442a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0442a
            public void onFail(String str) {
                InterfaceC0442a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0442a interfaceC0442a) {
        if (eVar.arI().isLogin(eVar.arp())) {
            interfaceC0442a.onSuccess();
        } else {
            eVar.arI().a(eVar.arp(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0442a.this.onSuccess();
                    } else {
                        InterfaceC0442a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0442a interfaceC0442a) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null || arw.arp() == null) {
            interfaceC0442a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(arw, new InterfaceC0442a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0442a
                public void onSuccess() {
                    a.a(new InterfaceC0442a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0442a
                        public void onSuccess() {
                            InterfaceC0442a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0442a
                        public void onFail(String str) {
                            InterfaceC0442a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0442a
                public void onFail(String str) {
                    InterfaceC0442a.this.onFail(str);
                }
            });
        }
    }
}
