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
    private ImageView axu = null;
    private LinearLayout axv = null;
    private LinearLayout axw = null;
    private LinearLayout axx = null;
    private int axy = 0;
    private long axz = 0;
    private int axA = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.axv = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axu = (ImageView) this.axv.findViewById(d.g.img_msgsend_recording);
        this.axw = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axx = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.axv;
    }

    public LinearLayout td() {
        return this.axw;
    }

    public LinearLayout te() {
        return this.axx;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axy = Math.max(i, this.axy);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axz > 150) {
            this.axy = 0;
            this.axz = uptimeMillis;
        }
        this.axA++;
        if (this.axA % 5 == 0) {
            this.axA = 0;
            if (this.axy < 2) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axy < 10) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axy < 20) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axy < 30) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axy < 40) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axy < 50) {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axu.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axv.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axv.setVisibility(8);
    }

    public void tf() {
        this.axw.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axw.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axx.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axx.setVisibility(8);
    }
}
