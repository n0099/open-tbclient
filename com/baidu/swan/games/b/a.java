package com.baidu.swan.games.b;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0517a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0517a interfaceC0517a) {
        com.baidu.swan.games.m.a.aXt().a(new InterfaceC0517a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0517a
            public void onSuccess() {
                InterfaceC0517a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0517a
            public void onFail(String str) {
                InterfaceC0517a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0517a interfaceC0517a) {
        if (eVar.aJa().isLogin(eVar.aIH())) {
            interfaceC0517a.onSuccess();
        } else {
            eVar.aJa().a(eVar.aIH(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0517a.this.onSuccess();
                    } else {
                        InterfaceC0517a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0517a interfaceC0517a) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null || aIO.aIH() == null) {
            interfaceC0517a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aIO, new InterfaceC0517a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0517a
                public void onSuccess() {
                    a.a(new InterfaceC0517a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0517a
                        public void onSuccess() {
                            InterfaceC0517a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0517a
                        public void onFail(String str) {
                            InterfaceC0517a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0517a
                public void onFail(String str) {
                    InterfaceC0517a.this.onFail(str);
                }
            });
        }
    }
}
