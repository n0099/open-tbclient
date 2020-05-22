package com.baidu.swan.apps.p.e.a;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class q extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    private AudioManager aYA;

    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        if (command.obj != null) {
            if (!aVar.aeC()) {
                a(aVar, command.what, "Not Set!! Volume: " + command.obj, true);
            } else if (command.obj instanceof Double) {
                try {
                    double doubleValue = ((Double) command.obj).doubleValue();
                    a(aVar, command.what, "Volume: " + command.obj, true);
                    if (doubleValue > 1.0d) {
                        doubleValue = 1.0d;
                    }
                    if (doubleValue < 0.0d) {
                        doubleValue = 0.0d;
                    }
                    a(doubleValue, aVar.getContext());
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e(aek(), "setVolume param type error");
                    }
                }
            }
        }
    }

    private void a(double d, Context context) {
        if (this.aYA == null) {
            this.aYA = (AudioManager) context.getSystemService("audio");
        }
        if (this.aYA != null) {
            int round = (int) Math.round(this.aYA.getStreamMaxVolume(3) * d);
            if (round == this.aYA.getStreamVolume(3)) {
                if (DEBUG) {
                    Log.d("【InlineCommand】", "Setting same volume level, ignore : (" + round + ")");
                    return;
                }
                return;
            }
            if (d > 0.0d && round == 0) {
                round = 1;
            }
            if (DEBUG) {
                Log.d("【InlineCommand】", "setVolumeInt" + round);
            }
            this.aYA.setStreamVolume(3, round, 0);
        }
    }
}
