package com.baidu.live.alablmsdk.d.b;

import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    public int azL;
    public int azM;
    public int azN;
    public int azO;
    public int azP;
    public int azQ = -1;
    public int azR = -1;
    public String mAppId;
    public int mPlayType;

    public void y(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        if (hashMap != null) {
            if (hashMap.containsKey("yy_rtc_app_id_key") && (obj9 = hashMap.get("yy_rtc_app_id_key")) != null) {
                this.mAppId = (String) obj9;
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mAppid " + this.mAppId, "");
            }
            if (hashMap.containsKey("yy_rtc_room_mode_key") && (obj8 = hashMap.get("yy_rtc_room_mode_key")) != null) {
                this.azL = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mRoomMode " + this.azL, "");
            }
            if (hashMap.containsKey("yy_rtc_media_mode_key") && (obj7 = hashMap.get("yy_rtc_media_mode_key")) != null) {
                this.azM = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mMediaMode " + this.azM, "");
            }
            if (hashMap.containsKey("yy_rtc_audio_config_key") && (obj6 = hashMap.get("yy_rtc_audio_config_key")) != null) {
                this.azN = ((Integer) obj6).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mAudioConfig " + this.azN, "");
            }
            if (hashMap.containsKey("yy_rtc_commu_mode_key") && (obj5 = hashMap.get("yy_rtc_commu_mode_key")) != null) {
                this.azO = ((Integer) obj5).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mCommuMode " + this.azO, "");
            }
            if (hashMap.containsKey("yy_rtc_scenario_mode_key") && (obj4 = hashMap.get("yy_rtc_scenario_mode_key")) != null) {
                this.azP = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mScenarioMode " + this.azP, "");
            }
            if (hashMap.containsKey("yy_rtc_publish_codec_mode") && (obj3 = hashMap.get("yy_rtc_publish_codec_mode")) != null) {
                this.azQ = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mPublishMode " + this.azQ, "");
            }
            if (hashMap.containsKey("yy_rtc_publish_play_type_key") && (obj2 = hashMap.get("yy_rtc_publish_play_type_key")) != null) {
                this.mPlayType = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mPlayType " + this.mPlayType, "");
            }
            if (hashMap.containsKey("yy_rtc_sound_effect_type_key") && (obj = hashMap.get("yy_rtc_sound_effect_type_key")) != null) {
                this.azR = ((Integer) obj).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mSoundEffect " + this.azR, "");
            }
        }
    }
}
