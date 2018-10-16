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
    private ImageView SK = null;
    private LinearLayout SL = null;
    private LinearLayout SM = null;
    private LinearLayout SO = null;
    private int SQ = 0;
    private long SR = 0;
    private int SS = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.SL = (LinearLayout) LayoutInflater.from(context).inflate(e.h.float_chat_recording_view, (ViewGroup) null);
        this.SK = (ImageView) this.SL.findViewById(e.g.img_msgsend_recording);
        this.SM = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_too_short_view, (ViewGroup) null);
        this.SO = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout pL() {
        return this.SL;
    }

    public LinearLayout pM() {
        return this.SM;
    }

    public LinearLayout pN() {
        return this.SO;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.SQ = Math.max(i, this.SQ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.SR > 150) {
            this.SQ = 0;
            this.SR = uptimeMillis;
        }
        this.SS++;
        if (this.SS % 5 == 0) {
            this.SS = 0;
            if (this.SQ < 2) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_zero);
            } else if (this.SQ < 10) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_one);
            } else if (this.SQ < 20) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_two);
            } else if (this.SQ < 30) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_three);
            } else if (this.SQ < 40) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_four);
            } else if (this.SQ < 50) {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_five);
            } else {
                this.SK.setImageResource(e.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.SL.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.SL.setVisibility(8);
    }

    public void pO() {
        this.SM.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.SM.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.SO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.SO.setVisibility(8);
    }
}
