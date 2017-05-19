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
    private ImageView JN = null;
    private LinearLayout JO = null;
    private LinearLayout JP = null;
    private LinearLayout JQ = null;
    private int JR = 0;
    private long JS = 0;
    private int JT = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.JO = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.JN = (ImageView) this.JO.findViewById(w.h.img_msgsend_recording);
        this.JP = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.JQ = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lP() {
        return this.JO;
    }

    public LinearLayout lQ() {
        return this.JP;
    }

    public LinearLayout lR() {
        return this.JQ;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.JR = Math.max(i, this.JR);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JS > 150) {
            this.JR = 0;
            this.JS = uptimeMillis;
        }
        this.JT++;
        if (this.JT % 5 == 0) {
            this.JT = 0;
            if (this.JR < 2) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.JR < 10) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.JR < 20) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.JR < 30) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.JR < 40) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.JR < 50) {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.JN.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.JO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.JO.setVisibility(8);
    }

    public void lS() {
        this.JP.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.JP.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.JQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.JQ.setVisibility(8);
    }
}
