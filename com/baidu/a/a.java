package com.baidu.a;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes14.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static C0016a Zi = new C0016a();
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "audioplayplugin");
        this.channel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        char c = 65535;
        switch (str.hashCode()) {
            case 3443508:
                if (str.equals(AlaStaticKeys.ALA_STATIC_VALUE_PLAY)) {
                    c = 3;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c = 4;
                    break;
                }
                break;
            case 1046116283:
                if (str.equals(MissionEvent.MESSAGE_CREATE)) {
                    c = 0;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c = 2;
                    break;
                }
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    Zi.a(((TbPageContextSupport) currentActivity).getPageContext(), (String) methodCall.argument("personal_center"));
                }
                result.success(true);
                return;
            case 1:
                Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity2 instanceof TbPageContextSupport) {
                    Zi.b(((TbPageContextSupport) currentActivity2).getPageContext(), (String) methodCall.argument("personal_center"));
                }
                result.success(true);
                return;
            case 2:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 3:
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.voiceId = (String) methodCall.argument("url");
                voiceModel.duration = Integer.valueOf((String) methodCall.argument("duration")).intValue();
                if (!Zi.isPlaying(voiceModel)) {
                    Zi.a(voiceModel);
                    Zi.qD();
                }
                result.success(true);
                return;
            case 4:
                Zi.Zk.stopPlay();
                result.success(true);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
    }

    /* renamed from: com.baidu.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private static class C0016a implements VoiceManager.b {
        String Zj;
        VoiceManager Zk;
        VoiceData.VoiceModel Zl;

        private C0016a() {
            this.Zj = "";
            this.Zk = VoiceManager.instance();
        }

        void a(VoiceData.VoiceModel voiceModel) {
            this.Zl = voiceModel;
        }

        boolean isPlaying(VoiceData.VoiceModel voiceModel) {
            return this.Zk.isPlaying(voiceModel);
        }

        boolean cN(String str) {
            return this.Zj != null && this.Zj.equals(str);
        }

        boolean a(TbPageContext tbPageContext, String str) {
            if (cN(str)) {
                return false;
            }
            this.Zj = str;
            this.Zk.onCreate(tbPageContext);
            return true;
        }

        void b(TbPageContext tbPageContext, String str) {
            if (cN(str)) {
                this.Zk.onDestory(tbPageContext);
                this.Zj = null;
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void qC() {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void b(VoiceData.VoiceModel voiceModel) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void aY(int i) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void onShowErr(int i, String str) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public VoiceData.VoiceModel getVoiceModel() {
            return this.Zl;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public VoiceManager.b getRealView() {
            return null;
        }

        void qD() {
            this.Zk.startPlay(this);
        }
    }
}
