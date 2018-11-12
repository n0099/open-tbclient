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
    private ImageView SM = null;
    private LinearLayout SO = null;
    private LinearLayout SQ = null;
    private LinearLayout SR = null;
    private int SS = 0;
    private long ST = 0;
    private int SU = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.SO = (LinearLayout) LayoutInflater.from(context).inflate(e.h.float_chat_recording_view, (ViewGroup) null);
        this.SM = (ImageView) this.SO.findViewById(e.g.img_msgsend_recording);
        this.SQ = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_too_short_view, (ViewGroup) null);
        this.SR = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout pJ() {
        return this.SO;
    }

    public LinearLayout pK() {
        return this.SQ;
    }

    public LinearLayout pL() {
        return this.SR;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.SS = Math.max(i, this.SS);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ST > 150) {
            this.SS = 0;
            this.ST = uptimeMillis;
        }
        this.SU++;
        if (this.SU % 5 == 0) {
            this.SU = 0;
            if (this.SS < 2) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_zero);
            } else if (this.SS < 10) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_one);
            } else if (this.SS < 20) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_two);
            } else if (this.SS < 30) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_three);
            } else if (this.SS < 40) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_four);
            } else if (this.SS < 50) {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_five);
            } else {
                this.SM.setImageResource(e.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.SO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.SO.setVisibility(8);
    }

    public void pM() {
        this.SQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.SQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.SR.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.SR.setVisibility(8);
    }
}
