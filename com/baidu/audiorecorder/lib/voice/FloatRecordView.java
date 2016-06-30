package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView BD = null;
    private LinearLayout BE = null;
    private LinearLayout BF = null;
    private LinearLayout BG = null;
    private int BH = 0;
    private long BI = 0;
    private int BJ = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.BE = (LinearLayout) LayoutInflater.from(context).inflate(u.h.float_chat_recording_view, (ViewGroup) null);
        this.BD = (ImageView) this.BE.findViewById(u.g.img_msgsend_recording);
        this.BF = (LinearLayout) LayoutInflater.from(context).inflate(u.h.floating_chat_too_short_view, (ViewGroup) null);
        this.BG = (LinearLayout) LayoutInflater.from(context).inflate(u.h.floating_chat_cancel_view, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    public LinearLayout kx() {
        return this.BE;
    }

    public LinearLayout ky() {
        return this.BF;
    }

    public LinearLayout kz() {
        return this.BG;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.BH = Math.max(i, this.BH);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.BI > 150) {
            this.BH = 0;
            this.BI = uptimeMillis;
        }
        this.BJ++;
        if (this.BJ % 5 == 0) {
            this.BJ = 0;
            if (this.BH < 2) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_zero);
            } else if (this.BH < 10) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_one);
            } else if (this.BH < 20) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_two);
            } else if (this.BH < 30) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_three);
            } else if (this.BH < 40) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_four);
            } else if (this.BH < 50) {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_five);
            } else {
                this.BD.setImageResource(u.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.BE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.BE.setVisibility(8);
    }

    public void kA() {
        this.BF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.BF.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.BG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.BG.setVisibility(8);
    }
}
