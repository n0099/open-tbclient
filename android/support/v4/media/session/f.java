package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
class f {
    public static int X(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long Y(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long Z(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float aa(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long ab(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence ac(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long ad(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> ae(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long af(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static Object a(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }

    /* loaded from: classes2.dex */
    static final class a {
        public static String ag(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static CharSequence ah(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static int ai(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle getExtras(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        public static Object a(String str, CharSequence charSequence, int i, Bundle bundle) {
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }
    }
}
