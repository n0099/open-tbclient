package com.baidu.swan.apps.inlinewidget.f.a;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class q extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private AudioManager bqA;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avA() {
        return "setVolume";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (command.obj != null) {
            if (!aVar.awk()) {
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
                        Log.e(avA(), "setVolume param type error");
                    }
                }
            }
        }
    }

    private void a(double d, Context context) {
        if (this.bqA == null) {
            this.bqA = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.bqA != null) {
            int round = (int) Math.round(this.bqA.getStreamMaxVolume(3) * d);
            if (round == this.bqA.getStreamVolume(3)) {
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
            this.bqA.setStreamVolume(3, round, 0);
        }
    }
}
