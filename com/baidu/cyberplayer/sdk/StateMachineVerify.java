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
public class StateMachineVerify {
    public static final int DEFAULT_RECORDER_MAX_NUM = 30;
    public static final Map<String, ArrayList<State>> STATE_MATCH_MAP;
    public static final String TAG = "StateMachineVerify";
    public State currentState;
    public boolean mEnableForbid;
    public boolean mEnableRecord;
    public boolean mEnableRecordAllCall;
    public TraceRecorder mStateTrace;

    /* loaded from: classes3.dex */
    public enum State {
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
    public class TraceRecorder {
        public Pair<String, State> mLastCall;
        public State mLastState;
        public final int mMaxSize;
        public final ArrayDeque<Pair<String, String>> mTraceQueue = new ArrayDeque<>();

        public TraceRecorder(int i) {
            this.mMaxSize = i;
        }

        public String getAllRecordMsg() {
            JSONObject jSONObject = new JSONObject();
            Iterator<Pair<String, String>> it = this.mTraceQueue.iterator();
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

        public synchronized void push(State state, long j) {
            if (this.mTraceQueue.size() >= this.mMaxSize) {
                this.mTraceQueue.pop();
            }
            this.mLastState = state;
            ArrayDeque<Pair<String, String>> arrayDeque = this.mTraceQueue;
            String valueOf = String.valueOf(j);
            arrayDeque.add(new Pair<>(valueOf, "State to " + state.toString()));
        }

        public synchronized void push(String str, long j) {
            Pair<String, State> pair = new Pair<>(str, this.mLastState);
            if (this.mLastCall != null && this.mLastCall.equals(pair)) {
                return;
            }
            this.mLastCall = pair;
            ArrayDeque<Pair<String, String>> arrayDeque = this.mTraceQueue;
            String valueOf = String.valueOf(j);
            arrayDeque.add(new Pair<>(valueOf, "Func:" + str));
        }

        public synchronized void push(String str, State state, long j) {
            if (this.mTraceQueue.size() >= this.mMaxSize) {
                this.mTraceQueue.pop();
            }
            CyberLog.e(StateMachineVerify.TAG, "ErrorCall:" + ("(" + j + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ": " + state.toString() + SmallTailInfo.EMOTION_SUFFIX));
            this.mTraceQueue.add(new Pair<>(String.valueOf(j), "func:" + str + " on " + state.toString()));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        STATE_MATCH_MAP = hashMap;
        hashMap.put("setDataSource", new ArrayList(Arrays.asList(State.IDLE)));
        STATE_MATCH_MAP.put("setAudioSessionId", new ArrayList<>(Arrays.asList(State.IDLE)));
        STATE_MATCH_MAP.put("prepareAsync", new ArrayList<>(Arrays.asList(State.INITIALIZED, State.STOPPED)));
        STATE_MATCH_MAP.put(DownloadStatisticConstants.UBC_TYPE_PAUSE, new ArrayList<>(Arrays.asList(State.STARTED, State.PAUSED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("start", new ArrayList<>(Arrays.asList(State.PREPARED, State.STARTED, State.PAUSED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("seekTo", new ArrayList<>(Arrays.asList(State.PREPARED, State.STARTED, State.PAUSED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("stop", new ArrayList<>(Arrays.asList(State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("getVideoWidth", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("getVideoHeight", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("isOnPlaying", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("setLooping", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("setVolume", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("getCurrentPosition", new ArrayList<>(Arrays.asList(State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE)));
        STATE_MATCH_MAP.put("reset", new ArrayList<>(Arrays.asList(State.IDLE, State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.STOPPED, State.PLAYBACK_COMPLETE, State.ERROR)));
        STATE_MATCH_MAP.put("setSpeed", new ArrayList<>(Arrays.asList(State.INITIALIZED, State.PREPARED, State.STARTED, State.PAUSED, State.PLAYBACK_COMPLETE, State.ERROR)));
    }

    public StateMachineVerify(boolean z, boolean z2) {
        this.currentState = State.IDLE;
        this.mEnableForbid = false;
        this.mEnableRecord = false;
        this.mEnableRecordAllCall = false;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("state_record_max", 30);
        this.mEnableRecordAllCall = CyberCfgManager.getInstance().getCfgBoolValueFast("enable_mp_record_all_call", false);
        this.mEnableRecord = z;
        this.mEnableForbid = z2;
        this.currentState = State.IDLE;
        if (z) {
            this.mStateTrace = new TraceRecorder(cfgIntValue);
            CyberLog.d(TAG, "enable Mediaplayer State Record");
        }
        if (this.mEnableForbid) {
            CyberLog.d(TAG, "enable Mediaplayer Error State Forbid Call");
        }
        if (isEnableVerify()) {
            logMap();
        }
    }

    private void exceptionCallRecord(String str, State state, long j) {
        TraceRecorder traceRecorder = this.mStateTrace;
        if (traceRecorder != null) {
            traceRecorder.push(str, state, j);
        }
    }

    private boolean isEnableVerify() {
        if (!this.mEnableRecord && !this.mEnableForbid) {
            return false;
        }
        return true;
    }

    public String getAllStateVerifyRecord() {
        if (!this.mEnableRecord) {
            return "";
        }
        String str = "" + this.mStateTrace.getAllRecordMsg();
        CyberLog.e(TAG, "RecordMsg: " + str);
        return str;
    }

    public State getState() {
        return this.currentState;
    }

    private void logMap() {
        CyberLog.d(TAG, "================ Mediaplayer Interface State Table Start ================");
        for (Map.Entry<String, ArrayList<State>> entry : STATE_MATCH_MAP.entrySet()) {
            String str = entry.getKey() + ": ";
            int size = entry.getValue().size();
            for (int i = 0; i < size; i++) {
                str = str + entry.getValue().get(i).toString();
                if (i < size - 1) {
                    str = str + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            CyberLog.d(TAG, str);
        }
        CyberLog.d(TAG, "================ Mediaplayer Interface State Table End ================");
    }

    private void normalCallRecord(String str, long j) {
        TraceRecorder traceRecorder = this.mStateTrace;
        if (traceRecorder != null) {
            traceRecorder.push(str, j);
        }
    }

    private void stateTraceRecord(State state, long j) {
        TraceRecorder traceRecorder = this.mStateTrace;
        if (traceRecorder != null) {
            traceRecorder.push(state, j);
        }
    }

    private boolean verifyMethodCall(String str, State state) {
        boolean verifyFromStateTable = verifyFromStateTable(str, state);
        if (this.mEnableRecordAllCall) {
            normalCallRecord(str, System.currentTimeMillis());
        }
        if (!verifyFromStateTable && this.mEnableRecord) {
            exceptionCallRecord(str, state, System.currentTimeMillis());
        }
        return verifyFromStateTable;
    }

    private boolean verifyFromStateTable(String str, State state) {
        boolean z;
        ArrayList<State> arrayList = STATE_MATCH_MAP.get(str);
        if (arrayList != null) {
            z = arrayList.contains(state);
            if (!z) {
                CyberLog.e(TAG, "ErrorCall:" + str + " in " + state.toString());
            }
        } else {
            z = false;
        }
        if (arrayList != null && !z) {
            return false;
        }
        return true;
    }

    public boolean methodCall(String str) {
        String str2;
        boolean z = true;
        if (isEnableVerify()) {
            boolean verifyMethodCall = verifyMethodCall(str, this.currentState);
            if (this.mEnableForbid && !verifyMethodCall) {
                z = false;
            }
            if (z) {
                str2 = UniversalToast.ToastCallbackWithAction.PARAMS_RESULT_KEY;
            } else {
                str2 = "forbid";
            }
            if (str.compareTo("getCurrentPosition") != 0) {
                CyberLog.d(TAG, "methodCall:" + str + ", current state:" + this.currentState + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
        }
        return z;
    }

    public synchronized void setState(State state) {
        if (this.currentState != state) {
            CyberLog.d(TAG, "State Change:" + this.currentState.toString() + " to " + state.toString());
        }
        this.currentState = state;
        stateTraceRecord(state, System.currentTimeMillis());
    }
}
