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
    private ImageView VC = null;
    private LinearLayout VD = null;
    private LinearLayout VE = null;
    private LinearLayout VF = null;
    private int VG = 0;
    private long VH = 0;
    private int VI = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.VD = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.VC = (ImageView) this.VD.findViewById(d.g.img_msgsend_recording);
        this.VE = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.VF = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.VD;
    }

    public LinearLayout qP() {
        return this.VE;
    }

    public LinearLayout qQ() {
        return this.VF;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.VG = Math.max(i, this.VG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.VH > 150) {
            this.VG = 0;
            this.VH = uptimeMillis;
        }
        this.VI++;
        if (this.VI % 5 == 0) {
            this.VI = 0;
            if (this.VG < 2) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.VG < 10) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.VG < 20) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.VG < 30) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.VG < 40) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.VG < 50) {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.VC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.VD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.VD.setVisibility(8);
    }

    public void qR() {
        this.VE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.VE.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.VF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.VF.setVisibility(8);
    }
}
