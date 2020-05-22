package com.baidu.swan.games.b;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0423a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0423a interfaceC0423a) {
        com.baidu.swan.games.m.a.aAQ().a(new InterfaceC0423a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onSuccess() {
                InterfaceC0423a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0423a
            public void onFail(String str) {
                InterfaceC0423a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0423a interfaceC0423a) {
        if (eVar.aoS().isLogin(eVar.aoz())) {
            interfaceC0423a.onSuccess();
        } else {
            eVar.aoS().a(eVar.aoz(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0423a.this.onSuccess();
                    } else {
                        InterfaceC0423a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0423a interfaceC0423a) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null || aoG.aoz() == null) {
            interfaceC0423a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aoG, new InterfaceC0423a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0423a
                public void onSuccess() {
                    a.a(new InterfaceC0423a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0423a
                        public void onSuccess() {
                            InterfaceC0423a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0423a
                        public void onFail(String str) {
                            InterfaceC0423a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0423a
                public void onFail(String str) {
                    InterfaceC0423a.this.onFail(str);
                }
            });
        }
    }
}
