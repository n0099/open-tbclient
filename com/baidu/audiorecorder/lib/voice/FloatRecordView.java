package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView Su = null;
    private LinearLayout Sv = null;
    private LinearLayout Sw = null;
    private LinearLayout Sx = null;
    private int Sy = 0;
    private long Sz = 0;
    private int SA = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Sv = (LinearLayout) LayoutInflater.from(context).inflate(e.h.float_chat_recording_view, (ViewGroup) null);
        this.Su = (ImageView) this.Sv.findViewById(e.g.img_msgsend_recording);
        this.Sw = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Sx = (LinearLayout) LayoutInflater.from(context).inflate(e.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout pD() {
        return this.Sv;
    }

    public LinearLayout pE() {
        return this.Sw;
    }

    public LinearLayout pF() {
        return this.Sx;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Sy = Math.max(i, this.Sy);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Sz > 150) {
            this.Sy = 0;
            this.Sz = uptimeMillis;
        }
        this.SA++;
        if (this.SA % 5 == 0) {
            this.SA = 0;
            if (this.Sy < 2) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_zero);
            } else if (this.Sy < 10) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_one);
            } else if (this.Sy < 20) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_two);
            } else if (this.Sy < 30) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_three);
            } else if (this.Sy < 40) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_four);
            } else if (this.Sy < 50) {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_five);
            } else {
                this.Su.setImageResource(e.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Sv.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Sv.setVisibility(8);
    }

    public void pG() {
        this.Sw.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Sw.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Sx.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Sx.setVisibility(8);
    }
}
