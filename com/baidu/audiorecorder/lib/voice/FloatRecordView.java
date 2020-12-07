package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView abZ = null;
    private LinearLayout aca = null;
    private LinearLayout acb = null;
    private LinearLayout acc = null;
    private int acd = 0;
    private long ace = 0;
    private int acf = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aca = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.abZ = (ImageView) this.aca.findViewById(R.id.img_msgsend_recording);
        this.acb = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.acc = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout sp() {
        return this.aca;
    }

    public LinearLayout sq() {
        return this.acb;
    }

    public LinearLayout sr() {
        return this.acc;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acd = Math.max(i, this.acd);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ace > 150) {
            this.acd = 0;
            this.ace = uptimeMillis;
        }
        this.acf++;
        if (this.acf % 5 == 0) {
            this.acf = 0;
            if (this.acd < 2) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.acd < 10) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.acd < 20) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.acd < 30) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.acd < 40) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.acd < 50) {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.abZ.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aca.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aca.setVisibility(8);
    }

    public void ss() {
        this.acb.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.acb.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.acc.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.acc.setVisibility(8);
    }
}
