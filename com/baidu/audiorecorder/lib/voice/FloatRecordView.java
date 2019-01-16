package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView SX = null;
    private LinearLayout SY = null;
    private LinearLayout SZ = null;
    private LinearLayout Ta = null;
    private int Tb = 0;
    private long Tc = 0;
    private int Td = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.SY = (LinearLayout) LayoutInflater.from(context).inflate(e.h.float_chat_recording_view, (ViewGroup) null);
        this.SX = (ImageView) this.SY.findViewById(e.g.img_msgsend_recording);
        this.SZ = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Ta = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_cancel_view, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
    }

    public LinearLayout pM() {
        return this.SY;
    }

    public LinearLayout pN() {
        return this.SZ;
    }

    public LinearLayout pO() {
        return this.Ta;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Tb = Math.max(i, this.Tb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tc > 150) {
            this.Tb = 0;
            this.Tc = uptimeMillis;
        }
        this.Td++;
        if (this.Td % 5 == 0) {
            this.Td = 0;
            if (this.Tb < 2) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_zero);
            } else if (this.Tb < 10) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_one);
            } else if (this.Tb < 20) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_two);
            } else if (this.Tb < 30) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_three);
            } else if (this.Tb < 40) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_four);
            } else if (this.Tb < 50) {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_five);
            } else {
                this.SX.setImageResource(e.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.SY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.SY.setVisibility(8);
    }

    public void pP() {
        this.SZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.SZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Ta.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Ta.setVisibility(8);
    }
}
