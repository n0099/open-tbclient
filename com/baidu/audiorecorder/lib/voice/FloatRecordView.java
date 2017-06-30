package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class FloatRecordView implements aj {
    private ImageView JA = null;
    private LinearLayout JB = null;
    private LinearLayout JC = null;
    private LinearLayout JD = null;
    private int JE = 0;
    private long JF = 0;
    private int JG = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.JB = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.JA = (ImageView) this.JB.findViewById(w.h.img_msgsend_recording);
        this.JC = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.JD = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lF() {
        return this.JB;
    }

    public LinearLayout lG() {
        return this.JC;
    }

    public LinearLayout lH() {
        return this.JD;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.JE = Math.max(i, this.JE);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JF > 150) {
            this.JE = 0;
            this.JF = uptimeMillis;
        }
        this.JG++;
        if (this.JG % 5 == 0) {
            this.JG = 0;
            if (this.JE < 2) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.JE < 10) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.JE < 20) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.JE < 30) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.JE < 40) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.JE < 50) {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.JA.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.JB.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.JB.setVisibility(8);
    }

    public void lI() {
        this.JC.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.JC.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.JD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.JD.setVisibility(8);
    }
}
