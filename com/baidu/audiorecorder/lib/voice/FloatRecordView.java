package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FloatRecordView implements aj {
    private ImageView Kv = null;
    private LinearLayout Kw = null;
    private LinearLayout Kx = null;
    private LinearLayout Ky = null;
    private int Kz = 0;
    private long KA = 0;
    private int KB = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Kw = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.Kv = (ImageView) this.Kw.findViewById(w.h.img_msgsend_recording);
        this.Kx = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Ky = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout mi() {
        return this.Kw;
    }

    public LinearLayout mj() {
        return this.Kx;
    }

    public LinearLayout mk() {
        return this.Ky;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kz = Math.max(i, this.Kz);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KA > 150) {
            this.Kz = 0;
            this.KA = uptimeMillis;
        }
        this.KB++;
        if (this.KB % 5 == 0) {
            this.KB = 0;
            if (this.Kz < 2) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.Kz < 10) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.Kz < 20) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.Kz < 30) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.Kz < 40) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.Kz < 50) {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.Kv.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.Kw.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.Kw.setVisibility(8);
    }

    public void ml() {
        this.Kx.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.Kx.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.Ky.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.Ky.setVisibility(8);
    }
}
