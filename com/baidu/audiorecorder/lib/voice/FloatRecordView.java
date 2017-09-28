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
    private ImageView Jn = null;
    private LinearLayout Jo = null;
    private LinearLayout Jp = null;
    private LinearLayout Jq = null;
    private int Jr = 0;
    private long Js = 0;
    private int Jt = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Jo = (LinearLayout) LayoutInflater.from(context).inflate(d.j.float_chat_recording_view, (ViewGroup) null);
        this.Jn = (ImageView) this.Jo.findViewById(d.h.img_msgsend_recording);
        this.Jp = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Jq = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lF() {
        return this.Jo;
    }

    public LinearLayout lG() {
        return this.Jp;
    }

    public LinearLayout lH() {
        return this.Jq;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Jr = Math.max(i, this.Jr);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Js > 150) {
            this.Jr = 0;
            this.Js = uptimeMillis;
        }
        this.Jt++;
        if (this.Jt % 5 == 0) {
            this.Jt = 0;
            if (this.Jr < 2) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_zero);
            } else if (this.Jr < 10) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_one);
            } else if (this.Jr < 20) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_two);
            } else if (this.Jr < 30) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_three);
            } else if (this.Jr < 40) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_four);
            } else if (this.Jr < 50) {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_five);
            } else {
                this.Jn.setImageResource(d.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Jo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Jo.setVisibility(8);
    }

    public void lI() {
        this.Jp.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Jp.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Jq.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Jq.setVisibility(8);
    }
}
