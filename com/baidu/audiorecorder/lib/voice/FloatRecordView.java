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
    private ImageView IG = null;
    private LinearLayout IH = null;
    private LinearLayout II = null;
    private LinearLayout IJ = null;
    private int IK = 0;
    private long IL = 0;
    private int IM = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.IH = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.IG = (ImageView) this.IH.findViewById(d.g.img_msgsend_recording);
        this.II = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.IJ = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.IH;
    }

    public LinearLayout lA() {
        return this.II;
    }

    public LinearLayout lB() {
        return this.IJ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IK = Math.max(i, this.IK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IL > 150) {
            this.IK = 0;
            this.IL = uptimeMillis;
        }
        this.IM++;
        if (this.IM % 5 == 0) {
            this.IM = 0;
            if (this.IK < 2) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.IK < 10) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.IK < 20) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.IK < 30) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.IK < 40) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.IK < 50) {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.IG.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.IH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.IH.setVisibility(8);
    }

    public void lC() {
        this.II.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.II.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.IJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.IJ.setVisibility(8);
    }
}
