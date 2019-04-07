package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bbk;
    private InterfaceC0189a bbl;

    /* renamed from: com.baidu.swan.games.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0189a {
    }

    public a(@NonNull File file, @NonNull InterfaceC0189a interfaceC0189a) {
        super("48", "game_core", "swan-game-sconsole");
        this.bbk = file;
        this.bbl = interfaceC0189a;
    }
}
