package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView IW = null;
    private LinearLayout IX = null;
    private LinearLayout IY = null;
    private LinearLayout IZ = null;
    private int Ja = 0;
    private long Jb = 0;
    private int Jc = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.IX = (LinearLayout) LayoutInflater.from(context).inflate(d.j.float_chat_recording_view, (ViewGroup) null);
        this.IW = (ImageView) this.IX.findViewById(d.h.img_msgsend_recording);
        this.IY = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_too_short_view, (ViewGroup) null);
        this.IZ = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lD() {
        return this.IX;
    }

    public LinearLayout lE() {
        return this.IY;
    }

    public LinearLayout lF() {
        return this.IZ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Ja = Math.max(i, this.Ja);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Jb > 150) {
            this.Ja = 0;
            this.Jb = uptimeMillis;
        }
        this.Jc++;
        if (this.Jc % 5 == 0) {
            this.Jc = 0;
            if (this.Ja < 2) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_zero);
            } else if (this.Ja < 10) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_one);
            } else if (this.Ja < 20) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_two);
            } else if (this.Ja < 30) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_three);
            } else if (this.Ja < 40) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_four);
            } else if (this.Ja < 50) {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_five);
            } else {
                this.IW.setImageResource(d.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.IX.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.IX.setVisibility(8);
    }

    public void lG() {
        this.IY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.IY.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.IZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.IZ.setVisibility(8);
    }
}
