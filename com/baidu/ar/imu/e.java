package com.baidu.ar.imu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.bean.TrackRes;
import com.baidu.ar.imu.ImuStateMachine;
import com.baidu.ar.imu.b;
import com.baidu.ar.parser.ParserJson;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends com.baidu.ar.base.b {
    private a s;
    private String t;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private WeakReference<e> a;

        public a(e eVar) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(eVar);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = this.a.get();
            if (eVar == null) {
                return;
            }
            switch (message.what) {
                case MsgConstants.IMU_MSG_ID_MODEL_LOADED /* 801 */:
                    com.baidu.ar.base.d.a((int) MsgField.IMSG_MODEL_LOADED, MsgField.SMSG_MODEL_LOADED);
                    if (eVar.j) {
                        return;
                    }
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.START_AR_ANIM);
                    eVar.j = true;
                    return;
                case MsgConstants.IMU_MODEL_SHOWING /* 804 */:
                    com.baidu.ar.base.d.a(2101, MsgField.SMSG_MODE_SHOWING);
                    return;
                case MsgConstants.IMU_IMU_OPEN /* 8010 */:
                    if (message.getData().getInt("type") == 1) {
                        eVar.a();
                        return;
                    }
                    return;
                case 30000:
                    eVar.c(message.getData());
                    return;
                default:
                    return;
            }
        }
    }

    public e(Context context) {
        super(context);
        this.s = null;
        ImuStateMachine.a().b();
        ImuStateMachine.a().a(this.k);
        this.k.a(new b.InterfaceC0039b() { // from class: com.baidu.ar.imu.e.1
            @Override // com.baidu.ar.imu.b.InterfaceC0039b
            public void a(float[] fArr) {
                Bundle bundle = new Bundle();
                bundle.putFloatArray("RMatrix", fArr);
                ImuStateMachine.a().a(bundle);
            }
        });
        if (this.s == null) {
            this.s = new a(this);
        }
        ImuStateMachine.a().a(this.s);
    }

    private void m() {
        if (this.s != null) {
            this.s.removeCallbacksAndMessages(null);
            this.s.a();
            this.s = null;
        }
        ImuStateMachine.a().a((Handler) null);
    }

    @Override // com.baidu.ar.base.b
    public void b(String str) {
        super.b(str);
        if (!TextUtils.isEmpty(this.t) && TextUtils.equals(this.t, str)) {
            ImuStateMachine.a().a(ImuStateMachine.EVENT.DOWNLOAD_RES_FINISH);
        } else if (TextUtils.isEmpty(str)) {
            com.baidu.ar.base.d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = (String) jSONObject.opt("unzip_path");
                String str3 = (String) jSONObject.opt("defalt_json");
                String str4 = (String) jSONObject.opt("target_json");
                String str5 = (String) jSONObject.opt("res_config");
                String str6 = str2 + File.separator + ARFileUtils.AR_UNZIP_ROOT_DIR;
                TrackRes parseCaseConfig = ParserJson.parseCaseConfig(str2, str3, str4);
                if (parseCaseConfig == null) {
                    com.baidu.ar.base.d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
                    return;
                }
                com.baidu.ar.bean.c a2 = com.baidu.ar.parser.a.a(str2, str5);
                this.h = parseCaseConfig;
                this.q = a2;
                if (this.i != null) {
                    this.i.a(this.q);
                } else {
                    ARLog.e("ARMessageHandler is null");
                }
                com.baidu.ar.base.d.a((int) MsgField.IMSG_TRACKED_TIPS_INFO, parseCaseConfig);
                HashMap hashMap = new HashMap();
                if (this.h != null) {
                    System.out.print("initCase in track: " + Arrays.toString(hashMap.entrySet().toArray()) + "\n");
                    a(str6);
                }
                ImuStateMachine.a().a(ImuStateMachine.EVENT.DOWNLOAD_RES_FINISH);
                this.t = str;
                a(true);
            } catch (JSONException e) {
                com.baidu.ar.base.d.a((int) MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR);
            }
        }
    }

    @Override // com.baidu.ar.base.b
    public void d() {
        super.d();
        ImuStateMachine.a(ImuStateMachine.STATE.RESUME);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.RESUME_AR);
        }
        com.baidu.ar.msghandler.e.a().a(this.s);
    }

    @Override // com.baidu.ar.base.b
    public void e() {
        super.e();
        ImuStateMachine.a(ImuStateMachine.STATE.PAUSE);
        if (this.j) {
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.INTERRUPT_AR);
        }
    }

    @Override // com.baidu.ar.base.b
    public void f() {
        super.f();
        m();
        ImuStateMachine.a(ImuStateMachine.STATE.DESTROY);
        ImuStateMachine.c();
    }

    @Override // com.baidu.ar.base.b
    public void j() {
        super.j();
        h();
        m();
    }
}
