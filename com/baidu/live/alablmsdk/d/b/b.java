package com.baidu.live.alablmsdk.d.b;

import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    public int aBl;
    public int aBm;
    public int aBn;
    public int aBo;
    public int aBp;
    public int aBq = -1;
    public int aBr = -1;
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
                this.aBl = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mRoomMode " + this.aBl, "");
            }
            if (hashMap.containsKey("yy_rtc_media_mode_key") && (obj7 = hashMap.get("yy_rtc_media_mode_key")) != null) {
                this.aBm = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mMediaMode " + this.aBm, "");
            }
            if (hashMap.containsKey("yy_rtc_audio_config_key") && (obj6 = hashMap.get("yy_rtc_audio_config_key")) != null) {
                this.aBn = ((Integer) obj6).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mAudioConfig " + this.aBn, "");
            }
            if (hashMap.containsKey("yy_rtc_commu_mode_key") && (obj5 = hashMap.get("yy_rtc_commu_mode_key")) != null) {
                this.aBo = ((Integer) obj5).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mCommuMode " + this.aBo, "");
            }
            if (hashMap.containsKey("yy_rtc_scenario_mode_key") && (obj4 = hashMap.get("yy_rtc_scenario_mode_key")) != null) {
                this.aBp = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mScenarioMode " + this.aBp, "");
            }
            if (hashMap.containsKey("yy_rtc_publish_codec_mode") && (obj3 = hashMap.get("yy_rtc_publish_codec_mode")) != null) {
                this.aBq = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mPublishMode " + this.aBq, "");
            }
            if (hashMap.containsKey("yy_rtc_publish_play_type_key") && (obj2 = hashMap.get("yy_rtc_publish_play_type_key")) != null) {
                this.mPlayType = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mPlayType " + this.mPlayType, "");
            }
            if (hashMap.containsKey("yy_rtc_sound_effect_type_key") && (obj = hashMap.get("yy_rtc_sound_effect_type_key")) != null) {
                this.aBr = ((Integer) obj).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag(" yyParamsBean.mSoundEffect " + this.aBr, "");
            }
        }
    }
}
