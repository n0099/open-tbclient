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
    private ImageView aaW = null;
    private LinearLayout aaX = null;
    private LinearLayout aaY = null;
    private LinearLayout aaZ = null;
    private int aba = 0;
    private long abb = 0;
    private int abd = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aaX = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.aaW = (ImageView) this.aaX.findViewById(R.id.img_msgsend_recording);
        this.aaY = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aaZ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.aaX;
    }

    public LinearLayout so() {
        return this.aaY;
    }

    public LinearLayout sp() {
        return this.aaZ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aba = Math.max(i, this.aba);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abb > 150) {
            this.aba = 0;
            this.abb = uptimeMillis;
        }
        this.abd++;
        if (this.abd % 5 == 0) {
            this.abd = 0;
            if (this.aba < 2) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.aba < 10) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.aba < 20) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.aba < 30) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.aba < 40) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.aba < 50) {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.aaW.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aaX.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aaX.setVisibility(8);
    }

    public void sq() {
        this.aaY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.aaY.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.aaZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.aaZ.setVisibility(8);
    }
}
