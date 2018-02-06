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
    private ImageView axD = null;
    private LinearLayout axE = null;
    private LinearLayout axF = null;
    private LinearLayout axG = null;
    private int axH = 0;
    private long axI = 0;
    private int axJ = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.axE = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axD = (ImageView) this.axE.findViewById(d.g.img_msgsend_recording);
        this.axF = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axG = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.axE;
    }

    public LinearLayout td() {
        return this.axF;
    }

    public LinearLayout te() {
        return this.axG;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axH = Math.max(i, this.axH);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axI > 150) {
            this.axH = 0;
            this.axI = uptimeMillis;
        }
        this.axJ++;
        if (this.axJ % 5 == 0) {
            this.axJ = 0;
            if (this.axH < 2) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axH < 10) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axH < 20) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axH < 30) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axH < 40) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axH < 50) {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axD.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axE.setVisibility(8);
    }

    public void tf() {
        this.axF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axF.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axG.setVisibility(8);
    }
}
