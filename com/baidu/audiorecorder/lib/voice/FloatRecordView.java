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
    private ImageView JB = null;
    private LinearLayout JC = null;
    private LinearLayout JD = null;
    private LinearLayout JE = null;
    private int JF = 0;
    private long JG = 0;
    private int JH = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.JC = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.JB = (ImageView) this.JC.findViewById(w.h.img_msgsend_recording);
        this.JD = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.JE = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lH() {
        return this.JC;
    }

    public LinearLayout lI() {
        return this.JD;
    }

    public LinearLayout lJ() {
        return this.JE;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.JF = Math.max(i, this.JF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JG > 150) {
            this.JF = 0;
            this.JG = uptimeMillis;
        }
        this.JH++;
        if (this.JH % 5 == 0) {
            this.JH = 0;
            if (this.JF < 2) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.JF < 10) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.JF < 20) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.JF < 30) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.JF < 40) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.JF < 50) {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.JB.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.JC.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.JC.setVisibility(8);
    }

    public void lK() {
        this.JD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.JD.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.JE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.JE.setVisibility(8);
    }
}
