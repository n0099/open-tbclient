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
    private ImageView Cx = null;
    private LinearLayout Cy = null;
    private LinearLayout Cz = null;
    private LinearLayout CA = null;
    private int CB = 0;
    private long CC = 0;
    private int CD = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Cy = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.Cx = (ImageView) this.Cy.findViewById(R.id.img_msgsend_recording);
        this.Cz = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.CA = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout kZ() {
        return this.Cy;
    }

    public LinearLayout la() {
        return this.Cz;
    }

    public LinearLayout lb() {
        return this.CA;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.CB = Math.max(i, this.CB);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.CC > 150) {
            this.CB = 0;
            this.CC = uptimeMillis;
        }
        this.CD++;
        if (this.CD % 5 == 0) {
            this.CD = 0;
            if (this.CB < 2) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.CB < 10) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.CB < 20) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.CB < 30) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.CB < 40) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.CB < 50) {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.Cx.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Cy.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Cy.setVisibility(8);
    }

    public void lc() {
        this.Cz.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Cz.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.CA.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.CA.setVisibility(8);
    }
}
