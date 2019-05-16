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
    private ImageView Tp = null;
    private LinearLayout Tq = null;
    private LinearLayout Tr = null;
    private LinearLayout Ts = null;
    private int Tt = 0;
    private long Tu = 0;
    private int Tv = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Tq = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.Tp = (ImageView) this.Tq.findViewById(R.id.img_msgsend_recording);
        this.Tr = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Ts = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.Tq;
    }

    public LinearLayout pK() {
        return this.Tr;
    }

    public LinearLayout pL() {
        return this.Ts;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Tt = Math.max(i, this.Tt);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tu > 150) {
            this.Tt = 0;
            this.Tu = uptimeMillis;
        }
        this.Tv++;
        if (this.Tv % 5 == 0) {
            this.Tv = 0;
            if (this.Tt < 2) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Tt < 10) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Tt < 20) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Tt < 30) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Tt < 40) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Tt < 50) {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.Tp.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Tq.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Tq.setVisibility(8);
    }

    public void pM() {
        this.Tr.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Tr.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Ts.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Ts.setVisibility(8);
    }
}
