package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView VB = null;
    private LinearLayout VC = null;
    private LinearLayout VD = null;
    private LinearLayout VE = null;
    private int VF = 0;
    private long VG = 0;
    private int VH = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.VC = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.VB = (ImageView) this.VC.findViewById(d.g.img_msgsend_recording);
        this.VD = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.VE = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qO() {
        return this.VC;
    }

    public LinearLayout qP() {
        return this.VD;
    }

    public LinearLayout qQ() {
        return this.VE;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.VF = Math.max(i, this.VF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.VG > 150) {
            this.VF = 0;
            this.VG = uptimeMillis;
        }
        this.VH++;
        if (this.VH % 5 == 0) {
            this.VH = 0;
            if (this.VF < 2) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.VF < 10) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.VF < 20) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.VF < 30) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.VF < 40) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.VF < 50) {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.VB.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.VC.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.VC.setVisibility(8);
    }

    public void qR() {
        this.VD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.VD.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.VE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.VE.setVisibility(8);
    }
}
