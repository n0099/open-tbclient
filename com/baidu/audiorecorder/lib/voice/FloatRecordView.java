package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView Fj = null;
    private LinearLayout Fk = null;
    private LinearLayout Fl = null;
    private LinearLayout Fm = null;
    private int Fn = 0;
    private long Fo = 0;
    private int Fp = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Fk = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.Fj = (ImageView) this.Fk.findViewById(R.id.img_msgsend_recording);
        this.Fl = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Fm = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout ls() {
        return this.Fk;
    }

    public LinearLayout lt() {
        return this.Fl;
    }

    public LinearLayout lu() {
        return this.Fm;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Fn = Math.max(i, this.Fn);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Fo > 150) {
            this.Fn = 0;
            this.Fo = uptimeMillis;
        }
        this.Fp++;
        if (this.Fp % 5 == 0) {
            this.Fp = 0;
            if (this.Fn < 2) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Fn < 10) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Fn < 20) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Fn < 30) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Fn < 40) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Fn < 50) {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.Fj.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Fk.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Fk.setVisibility(8);
    }

    public void lv() {
        this.Fl.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Fl.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Fm.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Fm.setVisibility(8);
    }
}
