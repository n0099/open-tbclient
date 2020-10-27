package com.baidu.swan.games.b;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0516a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0516a interfaceC0516a) {
        com.baidu.swan.games.m.a.aTG().a(new InterfaceC0516a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0516a
            public void onSuccess() {
                InterfaceC0516a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0516a
            public void onFail(String str) {
                InterfaceC0516a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0516a interfaceC0516a) {
        if (eVar.aFh().isLogin(eVar.aEO())) {
            interfaceC0516a.onSuccess();
        } else {
            eVar.aFh().a(eVar.aEO(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0516a.this.onSuccess();
                    } else {
                        InterfaceC0516a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0516a interfaceC0516a) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null || aEV.aEO() == null) {
            interfaceC0516a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aEV, new InterfaceC0516a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0516a
                public void onSuccess() {
                    a.a(new InterfaceC0516a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0516a
                        public void onSuccess() {
                            InterfaceC0516a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0516a
                        public void onFail(String str) {
                            InterfaceC0516a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0516a
                public void onFail(String str) {
                    InterfaceC0516a.this.onFail(str);
                }
            });
        }
    }
}
