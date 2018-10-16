package com.baidu.ar.msghandler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.BrowserBean;
import com.baidu.ar.imu.ImuStateMachine;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.ar.util.ARLog;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.baiduarsdk.b.a {
    private Context a;
    private int b;
    private boolean c;
    private ComponentMsgHandler d;
    private DownloadMsgHandler e;
    private f f;
    private List<d> g;
    private DuMixCallback h;

    public a(Context context) {
        super(context);
        this.b = 0;
        this.c = false;
        this.a = context.getApplicationContext();
        this.b = ARConfig.getARType();
        this.g = new ArrayList();
        this.d = new ComponentMsgHandler(context);
        this.c = true;
    }

    public static void a(int i) {
        switch (i) {
            case -90:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_LANDSCAPE_LEFT, null);
                return;
            case 0:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_PORTRAIT, null);
                return;
            case 90:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_LANDSCAPE_RIGHT, null);
                return;
            default:
                return;
        }
    }

    private void a(HashMap<String, Object> hashMap) {
        if (this.h != null) {
            BrowserBean browserBean = new BrowserBean();
            browserBean.setType(((Integer) hashMap.get("type")).intValue());
            browserBean.setUrl((String) hashMap.get("url"));
            this.h.onStateChange(MsgField.MSG_OPEN_URL, browserBean);
        }
    }

    private void b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("id");
            String str2 = (String) hashMap.get("type");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            StatisticHelper.getInstance().statisticInfo(str2, str);
        }
    }

    private void c(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) != 3010 || this.e == null) {
            return;
        }
        this.e.onDownloadError();
    }

    private void d(HashMap<String, Object> hashMap) {
        if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) != 9001 || this.e == null) {
            return;
        }
        this.f.a(hashMap);
    }

    private void e(HashMap<String, Object> hashMap) {
        try {
            if (MsgParamsUtil.obj2Int(hashMap.get("id"), -1) == 5001 && this.h != null) {
                int intValue = ((Integer) hashMap.get("open")).intValue();
                if (intValue == 0) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.PADDLE_GESTURE_CLOSE);
                    this.h.onStateChange(MsgField.MSG_PADDLE_ENABLE, false);
                } else if (intValue == 1) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.PADDLE_GESTURE_OPEN);
                    this.h.onStateChange(MsgField.MSG_PADDLE_ENABLE, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.baiduarsdk.b.a
    public void a() {
        super.a();
        if (this.c) {
            ArBridge.getInstance().removeMessageHandeler(this);
            this.c = false;
        }
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
        for (d dVar : this.g) {
            dVar.release();
        }
        this.g.clear();
        this.h = null;
    }

    @Override // com.baidu.baiduarsdk.b.a, com.baidu.baiduarsdk.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        int i3 = 0;
        super.a(i, i2, hashMap);
        switch (i) {
            case 9:
                if (StatisticConstants.getIsFirst3DModelLoad()) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.FRIST_LOADING_3D_MODEL_SUCCESS);
                    StatisticConstants.setIsFirst3DModelLoad(false);
                } else {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.LOADING_3D_MODEL_SUCCESS);
                }
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.LOAD_MODEL_FINISH);
                    return;
                } else if (this.b == 8) {
                    ImuStateMachine.a().a(ImuStateMachine.EVENT.LOAD_MODEL_FINISH);
                    return;
                } else {
                    Bundle bundle = new Bundle();
                    if (hashMap != null && hashMap.containsKey("show_immediately")) {
                        i3 = ((Integer) hashMap.get("show_immediately")).intValue();
                    }
                    bundle.putInt("show_immediately", i3);
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.LOAD_MODEL_FINISH, bundle);
                    return;
                }
            case 201:
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.MODEL_APPEAR);
                    return;
                } else if (this.b == 8) {
                    ImuStateMachine.a().a(ImuStateMachine.EVENT.MODEL_APPEAR);
                    return;
                } else {
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.MODEL_APPEAR);
                    return;
                }
            case 202:
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.MODEL_DISAPPEAR);
                    return;
                } else if (this.b == 8) {
                    ImuStateMachine.a().a(ImuStateMachine.EVENT.MODEL_DISAPPEAR);
                    return;
                } else {
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.MODEL_DISAPPEAR);
                    return;
                }
            case 301:
                if (hashMap == null || !hashMap.containsKey("type")) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("type", intValue);
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_IMU_OPEN, bundle2);
                    return;
                } else if (this.b == 8) {
                    ImuStateMachine.a().a(ImuStateMachine.EVENT.IMU_OPEN, bundle2);
                    return;
                } else {
                    ArBridge.getInstance().setImuType(intValue);
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_IMU_OPEN, bundle2);
                    return;
                }
            case 303:
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_IMU_CLOSE);
                    return;
                } else if (this.b == 8) {
                    ImuStateMachine.a().a(ImuStateMachine.EVENT.IMU_CLOSE);
                    return;
                } else {
                    TrackStateMachine.getInstance().processEvent(TrackStateMachine.EVENT.TRACK_IMU_CLOSE);
                    return;
                }
            case ArBridge.MessageType.MSG_TYPE_OPEN_URL /* 1301 */:
                a(hashMap);
                return;
            case 1801:
                b(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                c(hashMap);
                d(hashMap);
                e(hashMap);
                if (this.d != null) {
                    this.d.parseComponentData(hashMap);
                }
                for (d dVar : this.g) {
                    dVar.parseComponentData(hashMap);
                }
                return;
            case 4100:
                Bundle bundle3 = new Bundle();
                bundle3.putFloat(Config.EVENT_HEAT_X, ((Float) hashMap.get(Config.EVENT_HEAT_X)).floatValue());
                bundle3.putFloat("y", ((Float) hashMap.get("y")).floatValue());
                bundle3.putInt("type", ((Integer) hashMap.get("type")).intValue());
                bundle3.putFloat("distance", ((Float) hashMap.get("distance")).floatValue());
                if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_GUESTURE_INTERACTION, bundle3);
                    return;
                }
                return;
            case 5001:
                ARLog.e("bdar: MSG_TYPE_RES_REQUEST:" + hashMap);
                if (this.e != null) {
                    this.e.parseAndExcuteDownloadMsg(hashMap);
                    return;
                }
                return;
            case ArBridge.MessageType.MSG_TYPE_MODEL_LOAD_PROGRESS /* 6001 */:
                ARLog.e("bdar: MSG_TYPE_MODEL_LOAD_PROGRESS:" + ((Integer) hashMap.get("progress")).intValue());
                return;
            default:
                return;
        }
    }

    public void a(DuMixCallback duMixCallback) {
        this.h = duMixCallback;
    }

    public void a(com.baidu.ar.bean.c cVar) {
        if (this.e != null) {
            this.e.setResConfigs(cVar);
        }
    }

    public void a(DownloadMsgHandler downloadMsgHandler) {
        this.e = downloadMsgHandler;
    }

    public void a(d dVar) {
        this.g.add(dVar);
    }

    public void a(f fVar) {
        this.f = fVar;
    }
}
