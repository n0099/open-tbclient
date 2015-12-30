package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView KP = null;
    private LinearLayout KQ = null;
    private LinearLayout KR = null;
    private LinearLayout KS = null;
    private int KT = 0;
    private long KU = 0;
    private int KV = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.KQ = (LinearLayout) LayoutInflater.from(context).inflate(n.h.float_chat_recording_view, (ViewGroup) null);
        this.KP = (ImageView) this.KQ.findViewById(n.g.img_msgsend_recording);
        this.KR = (LinearLayout) LayoutInflater.from(context).inflate(n.h.floating_chat_too_short_view, (ViewGroup) null);
        this.KS = (LinearLayout) LayoutInflater.from(context).inflate(n.h.floating_chat_cancel_view, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    public LinearLayout nU() {
        return this.KQ;
    }

    public LinearLayout nV() {
        return this.KR;
    }

    public LinearLayout nW() {
        return this.KS;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KT = Math.max(i, this.KT);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KU > 150) {
            this.KT = 0;
            this.KU = uptimeMillis;
        }
        this.KV++;
        if (this.KV % 5 == 0) {
            this.KV = 0;
            if (this.KT < 2) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_zero);
            } else if (this.KT < 10) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_one);
            } else if (this.KT < 20) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_two);
            } else if (this.KT < 30) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_three);
            } else if (this.KT < 40) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_four);
            } else if (this.KT < 50) {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_five);
            } else {
                this.KP.setImageResource(n.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.KQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.KQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordTooShort() {
        this.KR.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.KR.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.KS.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.KS.setVisibility(8);
    }
}
