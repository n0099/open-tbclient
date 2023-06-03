package com.baidu.cyberplayer.sdk;

import android.util.Pair;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {
    public static final Map<String, ArrayList<a>> a;
    public a b;
    public b c;
    public boolean d;
    public boolean e;
    public boolean f;

    /* loaded from: classes3.dex */
    public enum a {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACK_COMPLETE,
        ERROR,
        END
    }

    /* loaded from: classes3.dex */
    public class b {
        public final int b;
        public final ArrayDeque<Pair<String, String>> c = new ArrayDeque<>();
        public Pair<String, a> d;
        public a e;

        public b(int i) {
            this.b = i;
        }

        public String a() {
            JSONObject jSONObject = new JSONObject();
            Iterator<Pair<String, String>> it = this.c.iterator();
            while (it.hasNext()) {
                Pair<String, String> next = it.next();
                try {
                    jSONObject.accumulate((String) next.first, next.second);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }

        public synchronized void a(a aVar, long j) {
            if (this.c.size() >= this.b) {
                this.c.pop();
            }
            this.e = aVar;
            ArrayDeque<Pair<String, String>> arrayDeque = this.c;
            String valueOf = String.valueOf(j);
            arrayDeque.add(new Pair<>(valueOf, "State to " + aVar.toString()));
        }

        public synchronized void a(String str, long j) {
            Pair<String, a> pair = new Pair<>(str, this.e);
            if (this.d != null && this.d.equals(pair)) {
                return;
            }
            this.d = pair;
            ArrayDeque<Pair<String, String>> arrayDeque = this.c;
            String valueOf = String.valueOf(j);
            arrayDeque.add(new Pair<>(valueOf, "Func:" + str));
        }

        public synchronized void a(String str, a aVar, long j) {
            if (this.c.size() >= this.b) {
                this.c.pop();
            }
            CyberLog.e("StateMachineVerify", "ErrorCall:" + ("(" + j + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ": " + aVar.toString() + SmallTailInfo.EMOTION_SUFFIX));
            this.c.add(new Pair<>(String.valueOf(j), "func:" + str + " on " + aVar.toString()));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("setDataSource", new ArrayList(Arrays.asList(a.IDLE)));
        a.put("setAudioSessionId", new ArrayList<>(Arrays.asList(a.IDLE)));
        a.put("prepareAsync", new ArrayList<>(Arrays.asList(a.INITIALIZED, a.STOPPED)));
        a.put(DownloadStatisticConstants.UBC_TYPE_PAUSE, new ArrayList<>(Arrays.asList(a.STARTED, a.PAUSED, a.PLAYBACK_COMPLETE)));
        a.put("start", new ArrayList<>(Arrays.asList(a.PREPARED, a.STARTED, a.PAUSED, a.PLAYBACK_COMPLETE)));
        a.put("seekTo", new ArrayList<>(Arrays.asList(a.PREPARED, a.STARTED, a.PAUSED, a.PLAYBACK_COMPLETE)));
        a.put("stop", new ArrayList<>(Arrays.asList(a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("getVideoWidth", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("getVideoHeight", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("isOnPlaying", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("setLooping", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("setVolume", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("getCurrentPosition", new ArrayList<>(Arrays.asList(a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE)));
        a.put("reset", new ArrayList<>(Arrays.asList(a.IDLE, a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.STOPPED, a.PLAYBACK_COMPLETE, a.ERROR)));
        a.put("setSpeed", new ArrayList<>(Arrays.asList(a.INITIALIZED, a.PREPARED, a.STARTED, a.PAUSED, a.PLAYBACK_COMPLETE, a.ERROR)));
    }

    public p(boolean z, boolean z2) {
        this.b = a.IDLE;
        this.d = false;
        this.e = false;
        this.f = false;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("state_record_max", 30);
        this.f = CyberCfgManager.getInstance().a("enable_mp_record_all_call", false);
        this.e = z;
        this.d = z2;
        this.b = a.IDLE;
        if (z) {
            this.c = new b(cfgIntValue);
            CyberLog.d("StateMachineVerify", "enable Mediaplayer State Record");
        }
        if (this.d) {
            CyberLog.d("StateMachineVerify", "enable Mediaplayer Error State Forbid Call");
        }
        if (c()) {
            d();
        }
    }

    private void a(a aVar, long j) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(aVar, j);
        }
    }

    private void a(String str, long j) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(str, j);
        }
    }

    private void a(String str, a aVar, long j) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(str, aVar, j);
        }
    }

    private boolean a(String str, a aVar) {
        boolean b2 = b(str, aVar);
        if (this.f) {
            a(str, System.currentTimeMillis());
        }
        if (!b2 && this.e) {
            a(str, aVar, System.currentTimeMillis());
        }
        return b2;
    }

    private boolean b(String str, a aVar) {
        boolean z;
        ArrayList<a> arrayList = a.get(str);
        if (arrayList != null) {
            z = arrayList.contains(aVar);
            if (!z) {
                CyberLog.e("StateMachineVerify", "ErrorCall:" + str + " in " + aVar.toString());
            }
        } else {
            z = false;
        }
        if (arrayList != null && !z) {
            return false;
        }
        return true;
    }

    private boolean c() {
        if (!this.e && !this.d) {
            return false;
        }
        return true;
    }

    public a a() {
        return this.b;
    }

    public String b() {
        if (!this.e) {
            return "";
        }
        String str = "" + this.c.a();
        CyberLog.e("StateMachineVerify", "RecordMsg: " + str);
        return str;
    }

    private void d() {
        CyberLog.d("StateMachineVerify", "================ Mediaplayer Interface State Table Start ================");
        for (Map.Entry<String, ArrayList<a>> entry : a.entrySet()) {
            String str = entry.getKey() + ": ";
            int size = entry.getValue().size();
            for (int i = 0; i < size; i++) {
                str = str + entry.getValue().get(i).toString();
                if (i < size - 1) {
                    str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            CyberLog.d("StateMachineVerify", str);
        }
        CyberLog.d("StateMachineVerify", "================ Mediaplayer Interface State Table End ================");
    }

    public synchronized void a(a aVar) {
        if (this.b != aVar) {
            CyberLog.d("StateMachineVerify", "State Change:" + this.b.toString() + " to " + aVar.toString());
        }
        this.b = aVar;
        a(aVar, System.currentTimeMillis());
    }

    public boolean a(String str) {
        String str2;
        boolean z = true;
        if (c()) {
            boolean a2 = a(str, this.b);
            if (this.d && !a2) {
                z = false;
            }
            if (z) {
                str2 = UniversalToast.ToastCallbackWithAction.PARAMS_RESULT_KEY;
            } else {
                str2 = "forbid";
            }
            if (str.compareTo("getCurrentPosition") != 0) {
                CyberLog.d("StateMachineVerify", "methodCall:" + str + ", current state:" + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
        }
        return z;
    }
}
