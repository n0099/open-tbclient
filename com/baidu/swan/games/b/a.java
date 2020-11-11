package com.baidu.swan.games.b;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0528a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0528a interfaceC0528a) {
        com.baidu.swan.games.m.a.aWg().a(new InterfaceC0528a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0528a
            public void onSuccess() {
                InterfaceC0528a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0528a
            public void onFail(String str) {
                InterfaceC0528a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0528a interfaceC0528a) {
        if (eVar.aHH().isLogin(eVar.aHo())) {
            interfaceC0528a.onSuccess();
        } else {
            eVar.aHH().a(eVar.aHo(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0528a.this.onSuccess();
                    } else {
                        InterfaceC0528a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0528a interfaceC0528a) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null || aHv.aHo() == null) {
            interfaceC0528a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aHv, new InterfaceC0528a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0528a
                public void onSuccess() {
                    a.a(new InterfaceC0528a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0528a
                        public void onSuccess() {
                            InterfaceC0528a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0528a
                        public void onFail(String str) {
                            InterfaceC0528a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0528a
                public void onFail(String str) {
                    InterfaceC0528a.this.onFail(str);
                }
            });
        }
    }
}
