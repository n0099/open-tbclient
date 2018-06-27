package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView PW = null;
    private LinearLayout PY = null;
    private LinearLayout PZ = null;
    private LinearLayout Qa = null;
    private int Qb = 0;
    private long Qc = 0;
    private int Qd = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.PY = (LinearLayout) LayoutInflater.from(context).inflate(d.i.float_chat_recording_view, (ViewGroup) null);
        this.PW = (ImageView) this.PY.findViewById(d.g.img_msgsend_recording);
        this.PZ = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_too_short_view, (ViewGroup) null);
        this.Qa = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout oy() {
        return this.PY;
    }

    public LinearLayout oz() {
        return this.PZ;
    }

    public LinearLayout oA() {
        return this.Qa;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Qb = Math.max(i, this.Qb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Qc > 150) {
            this.Qb = 0;
            this.Qc = uptimeMillis;
        }
        this.Qd++;
        if (this.Qd % 5 == 0) {
            this.Qd = 0;
            if (this.Qb < 2) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.Qb < 10) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.Qb < 20) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.Qb < 30) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.Qb < 40) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.Qb < 50) {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.PW.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.PY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.PY.setVisibility(8);
    }

    public void oB() {
        this.PZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.PZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Qa.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Qa.setVisibility(8);
    }
}
