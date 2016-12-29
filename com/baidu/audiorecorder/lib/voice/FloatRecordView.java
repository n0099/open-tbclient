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
    private ImageView Et = null;
    private LinearLayout Eu = null;
    private LinearLayout Ev = null;
    private LinearLayout Ew = null;
    private int Ex = 0;
    private long Ey = 0;
    private int Ez = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Eu = (LinearLayout) LayoutInflater.from(context).inflate(r.h.float_chat_recording_view, (ViewGroup) null);
        this.Et = (ImageView) this.Eu.findViewById(r.g.img_msgsend_recording);
        this.Ev = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Ew = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.Eu;
    }

    public LinearLayout ls() {
        return this.Ev;
    }

    public LinearLayout lt() {
        return this.Ew;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ex = Math.max(i, this.Ex);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ey > 150) {
            this.Ex = 0;
            this.Ey = uptimeMillis;
        }
        this.Ez++;
        if (this.Ez % 5 == 0) {
            this.Ez = 0;
            if (this.Ex < 2) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_zero);
            } else if (this.Ex < 10) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_one);
            } else if (this.Ex < 20) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_two);
            } else if (this.Ex < 30) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_three);
            } else if (this.Ex < 40) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_four);
            } else if (this.Ex < 50) {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_five);
            } else {
                this.Et.setImageResource(r.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Eu.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Eu.setVisibility(8);
    }

    public void lu() {
        this.Ev.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Ev.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Ew.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Ew.setVisibility(8);
    }
}
