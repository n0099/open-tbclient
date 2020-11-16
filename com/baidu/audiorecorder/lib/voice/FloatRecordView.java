package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView abd = null;
    private LinearLayout abe = null;
    private LinearLayout abf = null;
    private LinearLayout abg = null;
    private int abh = 0;
    private long abi = 0;
    private int abj = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.abe = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.abd = (ImageView) this.abe.findViewById(R.id.img_msgsend_recording);
        this.abf = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.abg = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout sn() {
        return this.abe;
    }

    public LinearLayout so() {
        return this.abf;
    }

    public LinearLayout sp() {
        return this.abg;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.abh = Math.max(i, this.abh);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abi > 150) {
            this.abh = 0;
            this.abi = uptimeMillis;
        }
        this.abj++;
        if (this.abj % 5 == 0) {
            this.abj = 0;
            if (this.abh < 2) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.abh < 10) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.abh < 20) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.abh < 30) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.abh < 40) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.abh < 50) {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.abd.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.abe.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.abe.setVisibility(8);
    }

    public void sq() {
        this.abf.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.abf.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.abg.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.abg.setVisibility(8);
    }
}
