package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView Fe = null;
    private LinearLayout Ff = null;
    private LinearLayout Fg = null;
    private LinearLayout Fh = null;
    private int Fi = 0;
    private long Fj = 0;
    private int Fk = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Ff = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.Fe = (ImageView) this.Ff.findViewById(R.id.img_msgsend_recording);
        this.Fg = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Fh = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lr() {
        return this.Ff;
    }

    public LinearLayout ls() {
        return this.Fg;
    }

    public LinearLayout lt() {
        return this.Fh;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Fi = Math.max(i, this.Fi);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Fj > 150) {
            this.Fi = 0;
            this.Fj = uptimeMillis;
        }
        this.Fk++;
        if (this.Fk % 5 == 0) {
            this.Fk = 0;
            if (this.Fi < 2) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Fi < 10) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Fi < 20) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Fi < 30) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Fi < 40) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Fi < 50) {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.Fe.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Ff.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Ff.setVisibility(8);
    }

    public void lu() {
        this.Fg.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Fg.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Fh.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Fh.setVisibility(8);
    }
}
