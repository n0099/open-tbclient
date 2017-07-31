package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView KY = null;
    private LinearLayout KZ = null;
    private LinearLayout La = null;
    private LinearLayout Lb = null;
    private int Lc = 0;
    private long Ld = 0;
    private int Le = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.KZ = (LinearLayout) LayoutInflater.from(context).inflate(d.j.float_chat_recording_view, (ViewGroup) null);
        this.KY = (ImageView) this.KZ.findViewById(d.h.img_msgsend_recording);
        this.La = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Lb = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lM() {
        return this.KZ;
    }

    public LinearLayout lN() {
        return this.La;
    }

    public LinearLayout lO() {
        return this.Lb;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Lc = Math.max(i, this.Lc);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ld > 150) {
            this.Lc = 0;
            this.Ld = uptimeMillis;
        }
        this.Le++;
        if (this.Le % 5 == 0) {
            this.Le = 0;
            if (this.Lc < 2) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_zero);
            } else if (this.Lc < 10) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_one);
            } else if (this.Lc < 20) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_two);
            } else if (this.Lc < 30) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_three);
            } else if (this.Lc < 40) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_four);
            } else if (this.Lc < 50) {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_five);
            } else {
                this.KY.setImageResource(d.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.KZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.KZ.setVisibility(8);
    }

    public void lP() {
        this.La.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.La.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Lb.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Lb.setVisibility(8);
    }
}
