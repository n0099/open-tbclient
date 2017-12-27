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
    private ImageView axC = null;
    private LinearLayout axD = null;
    private LinearLayout axE = null;
    private LinearLayout axF = null;
    private int axG = 0;
    private long axH = 0;
    private int axI = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.axD = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axC = (ImageView) this.axD.findViewById(d.g.img_msgsend_recording);
        this.axE = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axF = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.axD;
    }

    public LinearLayout td() {
        return this.axE;
    }

    public LinearLayout te() {
        return this.axF;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axG = Math.max(i, this.axG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axH > 150) {
            this.axG = 0;
            this.axH = uptimeMillis;
        }
        this.axI++;
        if (this.axI % 5 == 0) {
            this.axI = 0;
            if (this.axG < 2) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axG < 10) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axG < 20) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axG < 30) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axG < 40) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axG < 50) {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axC.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axD.setVisibility(8);
    }

    public void tf() {
        this.axE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axE.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axF.setVisibility(8);
    }
}
