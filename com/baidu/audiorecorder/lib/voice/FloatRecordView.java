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
    private ImageView Jo = null;
    private LinearLayout Jp = null;
    private LinearLayout Jq = null;
    private LinearLayout Jr = null;
    private int Js = 0;
    private long Jt = 0;
    private int Ju = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Jp = (LinearLayout) LayoutInflater.from(context).inflate(d.j.float_chat_recording_view, (ViewGroup) null);
        this.Jo = (ImageView) this.Jp.findViewById(d.h.img_msgsend_recording);
        this.Jq = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Jr = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.Jp;
    }

    public LinearLayout lG() {
        return this.Jq;
    }

    public LinearLayout lH() {
        return this.Jr;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Js = Math.max(i, this.Js);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Jt > 150) {
            this.Js = 0;
            this.Jt = uptimeMillis;
        }
        this.Ju++;
        if (this.Ju % 5 == 0) {
            this.Ju = 0;
            if (this.Js < 2) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_zero);
            } else if (this.Js < 10) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_one);
            } else if (this.Js < 20) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_two);
            } else if (this.Js < 30) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_three);
            } else if (this.Js < 40) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_four);
            } else if (this.Js < 50) {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_five);
            } else {
                this.Jo.setImageResource(d.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Jp.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Jp.setVisibility(8);
    }

    public void lI() {
        this.Jq.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Jq.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Jr.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Jr.setVisibility(8);
    }
}
