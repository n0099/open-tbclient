package com.baidu.swan.games.utils.so;
/* loaded from: classes2.dex */
final class a implements b {
    private a() {
    }

    public static a Yp() {
        return new a();
    }

    @Override // com.baidu.swan.games.utils.so.b
    public void load(String str) {
        System.load(str);
    }

    @Override // com.baidu.swan.games.utils.so.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
