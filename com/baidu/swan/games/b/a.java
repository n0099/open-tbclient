package com.baidu.swan.games.b;
/* loaded from: classes25.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0538a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0538a interfaceC0538a) {
        com.baidu.swan.games.m.a.aYD().a(new InterfaceC0538a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0538a
            public void onSuccess() {
                InterfaceC0538a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0538a
            public void onFail(String str) {
                InterfaceC0538a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0538a interfaceC0538a) {
        if (eVar.aKh().isLogin(eVar.aJO())) {
            interfaceC0538a.onSuccess();
        } else {
            eVar.aKh().a(eVar.aJO(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0538a.this.onSuccess();
                    } else {
                        InterfaceC0538a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0538a interfaceC0538a) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null || aJV.aJO() == null) {
            interfaceC0538a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aJV, new InterfaceC0538a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0538a
                public void onSuccess() {
                    a.a(new InterfaceC0538a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0538a
                        public void onSuccess() {
                            InterfaceC0538a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0538a
                        public void onFail(String str) {
                            InterfaceC0538a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0538a
                public void onFail(String str) {
                    InterfaceC0538a.this.onFail(str);
                }
            });
        }
    }
}
