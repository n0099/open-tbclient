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
    private ImageView Kt = null;
    private LinearLayout Ku = null;
    private LinearLayout Kv = null;
    private LinearLayout Kw = null;
    private int Kx = 0;
    private long Ky = 0;
    private int Kz = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Ku = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.Kt = (ImageView) this.Ku.findViewById(w.h.img_msgsend_recording);
        this.Kv = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.Kw = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout mh() {
        return this.Ku;
    }

    public LinearLayout mi() {
        return this.Kv;
    }

    public LinearLayout mj() {
        return this.Kw;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kx = Math.max(i, this.Kx);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ky > 150) {
            this.Kx = 0;
            this.Ky = uptimeMillis;
        }
        this.Kz++;
        if (this.Kz % 5 == 0) {
            this.Kz = 0;
            if (this.Kx < 2) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.Kx < 10) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.Kx < 20) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.Kx < 30) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.Kx < 40) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.Kx < 50) {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.Kt.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.Ku.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.Ku.setVisibility(8);
    }

    public void mk() {
        this.Kv.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.Kv.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.Kw.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.Kw.setVisibility(8);
    }
}
