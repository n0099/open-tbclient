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
    private ImageView La = null;
    private LinearLayout Lb = null;
    private LinearLayout Lc = null;
    private LinearLayout Ld = null;
    private int Le = 0;
    private long Lf = 0;
    private int Lg = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Lb = (LinearLayout) LayoutInflater.from(context).inflate(d.j.float_chat_recording_view, (ViewGroup) null);
        this.La = (ImageView) this.Lb.findViewById(d.h.img_msgsend_recording);
        this.Lc = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Ld = (LinearLayout) LayoutInflater.from(context).inflate(d.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lL() {
        return this.Lb;
    }

    public LinearLayout lM() {
        return this.Lc;
    }

    public LinearLayout lN() {
        return this.Ld;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Le = Math.max(i, this.Le);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lf > 150) {
            this.Le = 0;
            this.Lf = uptimeMillis;
        }
        this.Lg++;
        if (this.Lg % 5 == 0) {
            this.Lg = 0;
            if (this.Le < 2) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_zero);
            } else if (this.Le < 10) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_one);
            } else if (this.Le < 20) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_two);
            } else if (this.Le < 30) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_three);
            } else if (this.Le < 40) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_four);
            } else if (this.Le < 50) {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_five);
            } else {
                this.La.setImageResource(d.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Lb.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Lb.setVisibility(8);
    }

    public void lO() {
        this.Lc.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Lc.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Ld.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Ld.setVisibility(8);
    }
}
