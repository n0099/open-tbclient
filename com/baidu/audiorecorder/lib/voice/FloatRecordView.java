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
    private ImageView aaX = null;
    private LinearLayout aaY = null;
    private LinearLayout aaZ = null;
    private LinearLayout aba = null;
    private int abb = 0;
    private long abd = 0;
    private int abe = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aaY = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.aaX = (ImageView) this.aaY.findViewById(R.id.img_msgsend_recording);
        this.aaZ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aba = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.aaY;
    }

    public LinearLayout so() {
        return this.aaZ;
    }

    public LinearLayout sp() {
        return this.aba;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.abb = Math.max(i, this.abb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abd > 150) {
            this.abb = 0;
            this.abd = uptimeMillis;
        }
        this.abe++;
        if (this.abe % 5 == 0) {
            this.abe = 0;
            if (this.abb < 2) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.abb < 10) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.abb < 20) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.abb < 30) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.abb < 40) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.abb < 50) {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.aaX.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aaY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aaY.setVisibility(8);
    }

    public void sq() {
        this.aaZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.aaZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.aba.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.aba.setVisibility(8);
    }
}
