package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView PT = null;
    private LinearLayout PU = null;
    private LinearLayout PV = null;
    private LinearLayout PW = null;
    private int PY = 0;
    private long PZ = 0;
    private int Qa = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.PU = (LinearLayout) LayoutInflater.from(context).inflate(f.h.float_chat_recording_view, (ViewGroup) null);
        this.PT = (ImageView) this.PU.findViewById(f.g.img_msgsend_recording);
        this.PV = (LinearLayout) LayoutInflater.from(context).inflate(f.h.floating_chat_too_short_view, (ViewGroup) null);
        this.PW = (LinearLayout) LayoutInflater.from(context).inflate(f.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout ox() {
        return this.PU;
    }

    public LinearLayout oy() {
        return this.PV;
    }

    public LinearLayout oz() {
        return this.PW;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.PY = Math.max(i, this.PY);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.PZ > 150) {
            this.PY = 0;
            this.PZ = uptimeMillis;
        }
        this.Qa++;
        if (this.Qa % 5 == 0) {
            this.Qa = 0;
            if (this.PY < 2) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_zero);
            } else if (this.PY < 10) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_one);
            } else if (this.PY < 20) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_two);
            } else if (this.PY < 30) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_three);
            } else if (this.PY < 40) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_four);
            } else if (this.PY < 50) {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_five);
            } else {
                this.PT.setImageResource(f.C0146f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.PU.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.PU.setVisibility(8);
    }

    public void oA() {
        this.PV.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.PV.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.PW.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.PW.setVisibility(8);
    }
}
