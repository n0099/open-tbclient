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
    private ImageView IH = null;
    private LinearLayout II = null;
    private LinearLayout IJ = null;
    private LinearLayout IK = null;
    private int IL = 0;
    private long IM = 0;
    private int IN = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.II = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.IH = (ImageView) this.II.findViewById(d.g.img_msgsend_recording);
        this.IJ = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.IK = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lz() {
        return this.II;
    }

    public LinearLayout lA() {
        return this.IJ;
    }

    public LinearLayout lB() {
        return this.IK;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IL = Math.max(i, this.IL);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IM > 150) {
            this.IL = 0;
            this.IM = uptimeMillis;
        }
        this.IN++;
        if (this.IN % 5 == 0) {
            this.IN = 0;
            if (this.IL < 2) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.IL < 10) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.IL < 20) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.IL < 30) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.IL < 40) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.IL < 50) {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.IH.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.II.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.II.setVisibility(8);
    }

    public void lC() {
        this.IJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.IJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.IK.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.IK.setVisibility(8);
    }
}
