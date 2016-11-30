package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView Es = null;
    private LinearLayout Et = null;
    private LinearLayout Eu = null;
    private LinearLayout Ev = null;
    private int Ew = 0;
    private long Ex = 0;
    private int Ey = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Et = (LinearLayout) LayoutInflater.from(context).inflate(r.h.float_chat_recording_view, (ViewGroup) null);
        this.Es = (ImageView) this.Et.findViewById(r.g.img_msgsend_recording);
        this.Eu = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Ev = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lr() {
        return this.Et;
    }

    public LinearLayout ls() {
        return this.Eu;
    }

    public LinearLayout lt() {
        return this.Ev;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ew = Math.max(i, this.Ew);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ex > 150) {
            this.Ew = 0;
            this.Ex = uptimeMillis;
        }
        this.Ey++;
        if (this.Ey % 5 == 0) {
            this.Ey = 0;
            if (this.Ew < 2) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_zero);
            } else if (this.Ew < 10) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_one);
            } else if (this.Ew < 20) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_two);
            } else if (this.Ew < 30) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_three);
            } else if (this.Ew < 40) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_four);
            } else if (this.Ew < 50) {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_five);
            } else {
                this.Es.setImageResource(r.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Et.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Et.setVisibility(8);
    }

    public void lu() {
        this.Eu.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Eu.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Ev.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Ev.setVisibility(8);
    }
}
