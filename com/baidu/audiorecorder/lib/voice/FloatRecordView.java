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
    private ImageView PU = null;
    private LinearLayout PV = null;
    private LinearLayout PW = null;
    private LinearLayout PY = null;
    private int PZ = 0;
    private long Qa = 0;
    private int Qb = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.PV = (LinearLayout) LayoutInflater.from(context).inflate(d.i.float_chat_recording_view, (ViewGroup) null);
        this.PU = (ImageView) this.PV.findViewById(d.g.img_msgsend_recording);
        this.PW = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_too_short_view, (ViewGroup) null);
        this.PY = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.PV;
    }

    public LinearLayout oz() {
        return this.PW;
    }

    public LinearLayout oA() {
        return this.PY;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.PZ = Math.max(i, this.PZ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Qa > 150) {
            this.PZ = 0;
            this.Qa = uptimeMillis;
        }
        this.Qb++;
        if (this.Qb % 5 == 0) {
            this.Qb = 0;
            if (this.PZ < 2) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.PZ < 10) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.PZ < 20) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.PZ < 30) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.PZ < 40) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.PZ < 50) {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.PU.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.PV.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.PV.setVisibility(8);
    }

    public void oB() {
        this.PW.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.PW.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.PY.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.PY.setVisibility(8);
    }
}
