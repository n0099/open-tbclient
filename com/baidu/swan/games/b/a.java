package com.baidu.swan.games.b;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0490a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0490a interfaceC0490a) {
        com.baidu.swan.games.m.a.aOs().a(new InterfaceC0490a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0490a
            public void onSuccess() {
                InterfaceC0490a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0490a
            public void onFail(String str) {
                InterfaceC0490a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0490a interfaceC0490a) {
        if (eVar.azV().isLogin(eVar.azC())) {
            interfaceC0490a.onSuccess();
        } else {
            eVar.azV().a(eVar.azC(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0490a.this.onSuccess();
                    } else {
                        InterfaceC0490a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0490a interfaceC0490a) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null || azJ.azC() == null) {
            interfaceC0490a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(azJ, new InterfaceC0490a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0490a
                public void onSuccess() {
                    a.a(new InterfaceC0490a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0490a
                        public void onSuccess() {
                            InterfaceC0490a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0490a
                        public void onFail(String str) {
                            InterfaceC0490a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0490a
                public void onFail(String str) {
                    InterfaceC0490a.this.onFail(str);
                }
            });
        }
    }
}
