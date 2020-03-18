package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes11.dex */
public class h {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public h(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
            if (acI == null) {
                a(c, false, oo("internal error"));
                return;
            }
            try {
                boolean optBoolean = c.optBoolean("mixWithOther", false);
                acI.acY().a("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (DEBUG) {
                    Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + optBoolean);
                }
                a(c, true, "setInnerAudioOption:ok");
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("InnerAudioOptionApi", "set swanApp global var error");
                a(c, false, oo("internal error"));
            }
        }
    }

    private void a(com.baidu.swan.games.binding.model.c cVar, boolean z, String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        com.baidu.swan.games.utils.b.a(cVar, z, bVar);
    }

    private String oo(String str) {
        return String.format("setInnerAudioOption:fail %s", str);
    }
}
