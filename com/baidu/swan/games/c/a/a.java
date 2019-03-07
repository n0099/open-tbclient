package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.c;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = c.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bbg;
    private InterfaceC0160a bbh;

    /* renamed from: com.baidu.swan.games.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0160a {
    }

    public a(@NonNull File file, @NonNull InterfaceC0160a interfaceC0160a) {
        super("48", "game_core", "swan-game-sconsole");
        this.bbg = file;
        this.bbh = interfaceC0160a;
    }
}
