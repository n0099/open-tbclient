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
    private ImageView Ll = null;
    private LinearLayout Lm = null;
    private LinearLayout Ln = null;
    private LinearLayout Lo = null;
    private int Lp = 0;
    private long Lq = 0;
    private int Lr = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Lm = (LinearLayout) LayoutInflater.from(context).inflate(t.h.float_chat_recording_view, (ViewGroup) null);
        this.Ll = (ImageView) this.Lm.findViewById(t.g.img_msgsend_recording);
        this.Ln = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Lo = (LinearLayout) LayoutInflater.from(context).inflate(t.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout oh() {
        return this.Lm;
    }

    public LinearLayout oi() {
        return this.Ln;
    }

    public LinearLayout oj() {
        return this.Lo;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Lp = Math.max(i, this.Lp);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Lq > 150) {
            this.Lp = 0;
            this.Lq = uptimeMillis;
        }
        this.Lr++;
        if (this.Lr % 5 == 0) {
            this.Lr = 0;
            if (this.Lp < 2) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_zero);
            } else if (this.Lp < 10) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_one);
            } else if (this.Lp < 20) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_two);
            } else if (this.Lp < 30) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_three);
            } else if (this.Lp < 40) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_four);
            } else if (this.Lp < 50) {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_five);
            } else {
                this.Ll.setImageResource(t.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Lm.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Lm.setVisibility(8);
    }

    public void ok() {
        this.Ln.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Ln.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Lo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Lo.setVisibility(8);
    }
}
