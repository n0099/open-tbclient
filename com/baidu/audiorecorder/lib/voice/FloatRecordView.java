package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView To = null;
    private LinearLayout Tp = null;
    private LinearLayout Tq = null;
    private LinearLayout Tr = null;
    private int Ts = 0;
    private long Tt = 0;
    private int Tu = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Tp = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.To = (ImageView) this.Tp.findViewById(R.id.img_msgsend_recording);
        this.Tq = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Tr = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.Tp;
    }

    public LinearLayout pK() {
        return this.Tq;
    }

    public LinearLayout pL() {
        return this.Tr;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Ts = Math.max(i, this.Ts);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tt > 150) {
            this.Ts = 0;
            this.Tt = uptimeMillis;
        }
        this.Tu++;
        if (this.Tu % 5 == 0) {
            this.Tu = 0;
            if (this.Ts < 2) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Ts < 10) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Ts < 20) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Ts < 30) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Ts < 40) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Ts < 50) {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.To.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Tp.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Tp.setVisibility(8);
    }

    public void pM() {
        this.Tq.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Tq.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Tr.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Tr.setVisibility(8);
    }
}
