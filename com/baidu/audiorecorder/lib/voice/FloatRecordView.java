package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView BC = null;
    private LinearLayout BD = null;
    private LinearLayout BE = null;
    private LinearLayout BF = null;
    private int BG = 0;
    private long BH = 0;
    private int BI = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.BD = (LinearLayout) LayoutInflater.from(context).inflate(t.h.float_chat_recording_view, (ViewGroup) null);
        this.BC = (ImageView) this.BD.findViewById(t.g.img_msgsend_recording);
        this.BE = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_too_short_view, (ViewGroup) null);
        this.BF = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout ku() {
        return this.BD;
    }

    public LinearLayout kv() {
        return this.BE;
    }

    public LinearLayout kw() {
        return this.BF;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.BG = Math.max(i, this.BG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.BH > 150) {
            this.BG = 0;
            this.BH = uptimeMillis;
        }
        this.BI++;
        if (this.BI % 5 == 0) {
            this.BI = 0;
            if (this.BG < 2) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_zero);
            } else if (this.BG < 10) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_one);
            } else if (this.BG < 20) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_two);
            } else if (this.BG < 30) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_three);
            } else if (this.BG < 40) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_four);
            } else if (this.BG < 50) {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_five);
            } else {
                this.BC.setImageResource(t.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.BD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.BD.setVisibility(8);
    }

    public void kx() {
        this.BE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.BE.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.BF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.BF.setVisibility(8);
    }
}
