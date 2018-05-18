package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView JC = null;
    private LinearLayout JD = null;
    private LinearLayout JE = null;
    private LinearLayout JF = null;
    private int JG = 0;
    private long JH = 0;
    private int JI = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.JD = (LinearLayout) LayoutInflater.from(context).inflate(d.i.float_chat_recording_view, (ViewGroup) null);
        this.JC = (ImageView) this.JD.findViewById(d.g.img_msgsend_recording);
        this.JE = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_too_short_view, (ViewGroup) null);
        this.JF = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lH() {
        return this.JD;
    }

    public LinearLayout lI() {
        return this.JE;
    }

    public LinearLayout lJ() {
        return this.JF;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.JG = Math.max(i, this.JG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JH > 150) {
            this.JG = 0;
            this.JH = uptimeMillis;
        }
        this.JI++;
        if (this.JI % 5 == 0) {
            this.JI = 0;
            if (this.JG < 2) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.JG < 10) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.JG < 20) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.JG < 30) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.JG < 40) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.JG < 50) {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.JC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.JD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.JD.setVisibility(8);
    }

    public void lK() {
        this.JE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.JE.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.JF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.JF.setVisibility(8);
    }
}
