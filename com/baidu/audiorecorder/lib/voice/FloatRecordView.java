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
    private ImageView axv = null;
    private LinearLayout axw = null;
    private LinearLayout axx = null;
    private LinearLayout axy = null;
    private int axz = 0;
    private long axA = 0;
    private int axB = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.axw = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axv = (ImageView) this.axw.findViewById(d.g.img_msgsend_recording);
        this.axx = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axy = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout tc() {
        return this.axw;
    }

    public LinearLayout td() {
        return this.axx;
    }

    public LinearLayout te() {
        return this.axy;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axz = Math.max(i, this.axz);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axA > 150) {
            this.axz = 0;
            this.axA = uptimeMillis;
        }
        this.axB++;
        if (this.axB % 5 == 0) {
            this.axB = 0;
            if (this.axz < 2) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axz < 10) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axz < 20) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axz < 30) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axz < 40) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axz < 50) {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axv.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axw.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axw.setVisibility(8);
    }

    public void tf() {
        this.axx.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axx.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axy.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axy.setVisibility(8);
    }
}
