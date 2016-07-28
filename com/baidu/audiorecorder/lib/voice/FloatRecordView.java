package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView Cd = null;
    private LinearLayout Ce = null;
    private LinearLayout Cf = null;
    private LinearLayout Cg = null;
    private int Ch = 0;
    private long Ci = 0;
    private int Cj = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Ce = (LinearLayout) LayoutInflater.from(context).inflate(u.h.float_chat_recording_view, (ViewGroup) null);
        this.Cd = (ImageView) this.Ce.findViewById(u.g.img_msgsend_recording);
        this.Cf = (LinearLayout) LayoutInflater.from(context).inflate(u.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Cg = (LinearLayout) LayoutInflater.from(context).inflate(u.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout kt() {
        return this.Ce;
    }

    public LinearLayout ku() {
        return this.Cf;
    }

    public LinearLayout kv() {
        return this.Cg;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Ch = Math.max(i, this.Ch);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ci > 150) {
            this.Ch = 0;
            this.Ci = uptimeMillis;
        }
        this.Cj++;
        if (this.Cj % 5 == 0) {
            this.Cj = 0;
            if (this.Ch < 2) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_zero);
            } else if (this.Ch < 10) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_one);
            } else if (this.Ch < 20) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_two);
            } else if (this.Ch < 30) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_three);
            } else if (this.Ch < 40) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_four);
            } else if (this.Ch < 50) {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_five);
            } else {
                this.Cd.setImageResource(u.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Ce.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Ce.setVisibility(8);
    }

    public void kw() {
        this.Cf.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Cf.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Cg.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Cg.setVisibility(8);
    }
}
