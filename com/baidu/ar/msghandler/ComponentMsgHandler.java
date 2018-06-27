package com.baidu.ar.msghandler;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.ar.a.a;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.imu.ImuStateMachine;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ComponentMsgHandler implements d {
    private static a.InterfaceC0032a c = new a.InterfaceC0032a() { // from class: com.baidu.ar.msghandler.ComponentMsgHandler.1
        @Override // com.baidu.ar.a.a.InterfaceC0032a
        public void a() {
        }

        @Override // com.baidu.ar.a.a.InterfaceC0032a
        public void a(float f, float f2, float f3, float f4) {
            ARLog.e("acc  x " + f + " , y : " + f2 + " , z " + f3);
            ComponentMsgHandler.sendAccelerationToLua(f, f2, f3, f4);
        }
    };
    private Context a;
    private b b;

    public ComponentMsgHandler(Context context) {
        this.a = context.getApplicationContext();
        this.b = new b(context);
    }

    public static void sendAccelerationToLua(float f, float f2, float f3, float f4) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", 10000);
        hashMap.put("max_acc", Float.valueOf(f4));
        sendMessageToLua(hashMap);
    }

    public static void sendMessageToLua(HashMap hashMap) {
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.msghandler.d
    public void parseComponentData(HashMap<String, Object> hashMap) {
        int i = 1;
        if (hashMap != null) {
            int obj2Int = MsgParamsUtil.obj2Int(hashMap.get("id"), -1);
            Log.e("lua  ", " ArBridge.LuaSdkBridgeMessageType = " + obj2Int);
            switch (obj2Int) {
                case 4100:
                    if (ARConfig.getARType() == 5) {
                        Bundle bundle = new Bundle();
                        bundle.putFloat("x", ((Float) hashMap.get("x")).floatValue());
                        bundle.putFloat("y", ((Float) hashMap.get("y")).floatValue());
                        bundle.putInt("type", ((Integer) hashMap.get("type")).intValue());
                        bundle.putFloat("distance", ((Float) hashMap.get("distance")).floatValue());
                        bundle.putBoolean("is_from_lua", true);
                        SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_GUESTURE_INTERACTION, bundle);
                        return;
                    }
                    return;
                case ComponentMessageType.MSG_TYPE_SLAM_START /* 4200 */:
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_START_FROM_LUA);
                    return;
                case 10001:
                    com.baidu.ar.a.b.a(this.a).a(c);
                    return;
                case 10002:
                    com.baidu.ar.a.b.a(this.a).a();
                    return;
                case 10004:
                    com.baidu.ar.a.b.a(this.a).a(true);
                    return;
                case ComponentMessageType.MST_TYPE_OPEN_ALGO_TRACK /* 10101 */:
                    if (ARConfig.getARType() == 0) {
                        TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.OPEN_TRACK_ALGO);
                        return;
                    }
                    return;
                case 10102:
                    if (ARConfig.getARType() == 0) {
                        TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.CLOSE_TRACK_ALGO);
                        return;
                    }
                    return;
                case 20001:
                    Bundle bundle2 = new Bundle();
                    if (hashMap != null && hashMap.containsKey("type")) {
                        int intValue = ((Integer) hashMap.get("type")).intValue();
                        bundle2.putInt("type", intValue);
                        i = intValue;
                    }
                    if (hashMap == null || !hashMap.containsKey("resume_original_position")) {
                        bundle2.putInt("resume_original_position", 0);
                    } else {
                        bundle2.putInt("resume_original_position", ((Integer) hashMap.get("resume_original_position")).intValue());
                    }
                    if (ARConfig.getARType() == 0) {
                        ArBridge.getInstance().setImuType(i);
                        TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_IMU_OPEN, bundle2);
                        return;
                    } else if (ARConfig.getARType() == 5) {
                        SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_IMU_OPEN, bundle2);
                        return;
                    } else if (ARConfig.getARType() == 8) {
                        ImuStateMachine.a().a(ImuStateMachine.EVENT.IMU_OPEN, bundle2);
                        return;
                    } else {
                        return;
                    }
                case ComponentMessageType.MSG_TYPE_SHOW_DIALOG /* 21111 */:
                case ComponentMessageType.MSG_TYPE_SHOW_TOAST /* 21113 */:
                    if (this.b != null) {
                        this.b.parseComponentData(hashMap);
                        return;
                    }
                    return;
                case 30000:
                    int intValue2 = ((Integer) hashMap.get(MsgConstants.MSG_EXTRA_VIEW_VISIBLE)).intValue();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(MsgConstants.MSG_EXTRA_VIEW_VISIBLE_ID, intValue2);
                    e.a().a(obj2Int, bundle3);
                    return;
                default:
                    com.baidu.ar.base.d.a(hashMap);
                    return;
            }
        }
    }

    @Override // com.baidu.ar.msghandler.d
    public void release() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
    }
}
