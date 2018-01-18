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
    private ImageView axB = null;
    private LinearLayout axC = null;
    private LinearLayout axD = null;
    private LinearLayout axE = null;
    private int axF = 0;
    private long axG = 0;
    private int axH = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.axC = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axB = (ImageView) this.axC.findViewById(d.g.img_msgsend_recording);
        this.axD = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axE = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.axC;
    }

    public LinearLayout td() {
        return this.axD;
    }

    public LinearLayout te() {
        return this.axE;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axF = Math.max(i, this.axF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axG > 150) {
            this.axF = 0;
            this.axG = uptimeMillis;
        }
        this.axH++;
        if (this.axH % 5 == 0) {
            this.axH = 0;
            if (this.axF < 2) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axF < 10) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axF < 20) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axF < 30) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axF < 40) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axF < 50) {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axB.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axC.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axC.setVisibility(8);
    }

    public void tf() {
        this.axD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axD.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axE.setVisibility(8);
    }
}
