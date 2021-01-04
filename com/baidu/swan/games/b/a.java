package com.baidu.swan.games.b;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0531a {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(final InterfaceC0531a interfaceC0531a) {
        com.baidu.swan.games.m.a.baX().a(new InterfaceC0531a() { // from class: com.baidu.swan.games.b.a.1
            @Override // com.baidu.swan.games.b.a.InterfaceC0531a
            public void onSuccess() {
                InterfaceC0531a.this.onSuccess();
            }

            @Override // com.baidu.swan.games.b.a.InterfaceC0531a
            public void onFail(String str) {
                InterfaceC0531a.this.onFail(str);
            }
        });
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, final InterfaceC0531a interfaceC0531a) {
        if (eVar.aMx().isLogin(eVar.aMe())) {
            interfaceC0531a.onSuccess();
        } else {
            eVar.aMx().a(eVar.aMe(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.b.a.2
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        InterfaceC0531a.this.onSuccess();
                    } else {
                        InterfaceC0531a.this.onFail("login error");
                    }
                }
            });
        }
    }

    public static void b(final InterfaceC0531a interfaceC0531a) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null || aMl.aMe() == null) {
            interfaceC0531a.onFail("SwanApp is null or SwanActivity is null");
        } else {
            a(aMl, new InterfaceC0531a() { // from class: com.baidu.swan.games.b.a.3
                @Override // com.baidu.swan.games.b.a.InterfaceC0531a
                public void onSuccess() {
                    a.a(new InterfaceC0531a() { // from class: com.baidu.swan.games.b.a.3.1
                        @Override // com.baidu.swan.games.b.a.InterfaceC0531a
                        public void onSuccess() {
                            InterfaceC0531a.this.onSuccess();
                        }

                        @Override // com.baidu.swan.games.b.a.InterfaceC0531a
                        public void onFail(String str) {
                            InterfaceC0531a.this.onFail(str);
                        }
                    });
                }

                @Override // com.baidu.swan.games.b.a.InterfaceC0531a
                public void onFail(String str) {
                    InterfaceC0531a.this.onFail(str);
                }
            });
        }
    }
}
