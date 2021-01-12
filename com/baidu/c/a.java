package com.baidu.c;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
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
/* loaded from: classes6.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static C0087a acj = new C0087a();
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "audioplayplugin");
        this.channel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
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
                    acj.a(((TbPageContextSupport) currentActivity).getPageContext(), (String) methodCall.argument("page_name"));
                }
                result.success(true);
                return;
            case 1:
                Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity2 instanceof TbPageContextSupport) {
                    acj.b(((TbPageContextSupport) currentActivity2).getPageContext(), (String) methodCall.argument("page_name"));
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
                if (!acj.isPlaying(voiceModel)) {
                    acj.a(voiceModel);
                    acj.rK();
                }
                result.success(true);
                return;
            case 4:
                acj.acn.stopPlay();
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

    /* renamed from: com.baidu.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0087a implements VoiceManager.b {
        String acm;
        VoiceManager acn;
        VoiceData.VoiceModel aco;

        private C0087a() {
            this.acm = "";
            this.acn = VoiceManager.instance();
        }

        void a(VoiceData.VoiceModel voiceModel) {
            this.aco = voiceModel;
        }

        boolean isPlaying(VoiceData.VoiceModel voiceModel) {
            return this.acn.isPlaying(voiceModel);
        }

        boolean cT(String str) {
            return this.acm != null && this.acm.equals(str);
        }

        boolean a(TbPageContext tbPageContext, String str) {
            if (cT(str)) {
                return false;
            }
            this.acm = str;
            this.acn.onCreate(tbPageContext);
            return true;
        }

        void b(TbPageContext tbPageContext, String str) {
            if (cT(str)) {
                this.acn.onDestory(tbPageContext);
                this.acm = null;
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void rJ() {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void b(VoiceData.VoiceModel voiceModel) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void bj(int i) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public void onShowErr(int i, String str) {
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public VoiceData.VoiceModel getVoiceModel() {
            return this.aco;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.b
        public VoiceManager.b getRealView() {
            return null;
        }

        void rK() {
            this.acn.startPlay(this);
        }
    }
}
