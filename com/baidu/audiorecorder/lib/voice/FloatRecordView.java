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
    private ImageView IF = null;
    private LinearLayout IG = null;
    private LinearLayout IH = null;
    private LinearLayout II = null;
    private int IJ = 0;
    private long IK = 0;
    private int IL = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.IG = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.IF = (ImageView) this.IG.findViewById(d.g.img_msgsend_recording);
        this.IH = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.II = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.IG;
    }

    public LinearLayout lA() {
        return this.IH;
    }

    public LinearLayout lB() {
        return this.II;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IJ = Math.max(i, this.IJ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IK > 150) {
            this.IJ = 0;
            this.IK = uptimeMillis;
        }
        this.IL++;
        if (this.IL % 5 == 0) {
            this.IL = 0;
            if (this.IJ < 2) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.IJ < 10) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.IJ < 20) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.IJ < 30) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.IJ < 40) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.IJ < 50) {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.IF.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.IG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.IG.setVisibility(8);
    }

    public void lC() {
        this.IH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.IH.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.II.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.II.setVisibility(8);
    }
}
