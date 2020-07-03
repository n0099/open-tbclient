package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView ZL = null;
    private LinearLayout ZM = null;
    private LinearLayout ZN = null;
    private LinearLayout ZO = null;
    private int ZP = 0;
    private long ZQ = 0;
    private int ZR = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.ZM = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.ZL = (ImageView) this.ZM.findViewById(R.id.img_msgsend_recording);
        this.ZN = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.ZO = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qG() {
        return this.ZM;
    }

    public LinearLayout qH() {
        return this.ZN;
    }

    public LinearLayout qI() {
        return this.ZO;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.ZP = Math.max(i, this.ZP);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ZQ > 150) {
            this.ZP = 0;
            this.ZQ = uptimeMillis;
        }
        this.ZR++;
        if (this.ZR % 5 == 0) {
            this.ZR = 0;
            if (this.ZP < 2) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.ZP < 10) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.ZP < 20) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.ZP < 30) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.ZP < 40) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.ZP < 50) {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.ZL.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.ZM.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.ZM.setVisibility(8);
    }

    public void qJ() {
        this.ZN.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.ZN.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.ZO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.ZO.setVisibility(8);
    }
}
