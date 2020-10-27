package com.baidu.swan.apps.inlinewidget.f.a;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class q extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private AudioManager bph;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String ata() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (command.obj != null) {
            if (!aVar.atK()) {
                a(aVar, command.what, "Not Set!! Volume: " + command.obj, false);
            } else if (command.obj instanceof Double) {
                try {
                    double doubleValue = ((Double) command.obj).doubleValue();
                    a(aVar, command.what, "Volume: " + command.obj, false);
                    if (doubleValue > 1.0d) {
                        doubleValue = 1.0d;
                    }
                    if (doubleValue < 0.0d) {
                        doubleValue = 0.0d;
                    }
                    a(doubleValue, aVar.getContext());
                } catch (Exception e) {
                    if (DEBUG) {
                        Log.e(ata(), "setVolume param type error");
                    }
                }
            }
        }
    }

    private void a(double d, Context context) {
        if (this.bph == null) {
            this.bph = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bph != null) {
            int round = (int) Math.round(this.bph.getStreamMaxVolume(3) * d);
            if (round == this.bph.getStreamVolume(3)) {
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
            this.bph.setStreamVolume(3, round, 0);
        }
    }
}
