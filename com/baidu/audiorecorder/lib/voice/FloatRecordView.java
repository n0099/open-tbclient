package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView Le = null;
    private LinearLayout Lf = null;
    private LinearLayout Lg = null;
    private LinearLayout Lh = null;
    private int Li = 0;
    private long Lj = 0;
    private int Lk = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Lf = (LinearLayout) LayoutInflater.from(context).inflate(t.h.float_chat_recording_view, (ViewGroup) null);
        this.Le = (ImageView) this.Lf.findViewById(t.g.img_msgsend_recording);
        this.Lg = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Lh = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout oo() {
        return this.Lf;
    }

    public LinearLayout op() {
        return this.Lg;
    }

    public LinearLayout oq() {
        return this.Lh;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Li = Math.max(i, this.Li);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lj > 150) {
            this.Li = 0;
            this.Lj = uptimeMillis;
        }
        this.Lk++;
        if (this.Lk % 5 == 0) {
            this.Lk = 0;
            if (this.Li < 2) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_zero);
            } else if (this.Li < 10) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_one);
            } else if (this.Li < 20) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_two);
            } else if (this.Li < 30) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_three);
            } else if (this.Li < 40) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_four);
            } else if (this.Li < 50) {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_five);
            } else {
                this.Le.setImageResource(t.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Lf.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Lf.setVisibility(8);
    }

    public void or() {
        this.Lg.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Lg.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Lh.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Lh.setVisibility(8);
    }
}
