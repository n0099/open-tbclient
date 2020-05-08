package com.baidu.swan.apps.r.e.a;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class q extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    private AudioManager aRn;

    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String abj() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        if (command.obj != null) {
            if (!aVar.abz()) {
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
                        Log.e(abj(), "setVolume param type error");
                    }
                }
            }
        }
    }

    private void a(double d, Context context) {
        if (this.aRn == null) {
            this.aRn = (AudioManager) context.getSystemService("audio");
        }
        if (this.aRn != null) {
            int round = (int) Math.round(this.aRn.getStreamMaxVolume(3) * d);
            if (round == this.aRn.getStreamVolume(3)) {
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
            this.aRn.setStreamVolume(3, round, 0);
        }
    }
}
