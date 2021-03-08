package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.b {
    private ImageView adY = null;
    private LinearLayout adZ = null;
    private LinearLayout aea = null;
    private LinearLayout aeb = null;
    private int aed = 0;
    private long aee = 0;
    private int aef = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.adZ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.adY = (ImageView) this.adZ.findViewById(R.id.img_msgsend_recording);
        this.aea = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aeb = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout rO() {
        return this.adZ;
    }

    public LinearLayout rP() {
        return this.aea;
    }

    public LinearLayout rQ() {
        return this.aeb;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aed = Math.max(i, this.aed);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aee > 150) {
            this.aed = 0;
            this.aee = uptimeMillis;
        }
        this.aef++;
        if (this.aef % 5 == 0) {
            this.aef = 0;
            if (this.aed < 2) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.aed < 10) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.aed < 20) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.aed < 30) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.aed < 40) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.aed < 50) {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.adY.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        this.adZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        this.adZ.setVisibility(8);
    }

    public void rR() {
        this.aea.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        this.aea.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        this.aeb.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        this.aeb.setVisibility(8);
    }
}
