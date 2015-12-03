package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView Kz = null;
    private LinearLayout KA = null;
    private LinearLayout KB = null;
    private LinearLayout KC = null;
    private int KD = 0;
    private long KE = 0;
    private int KF = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.KA = (LinearLayout) LayoutInflater.from(context).inflate(n.g.float_chat_recording_view, (ViewGroup) null);
        this.Kz = (ImageView) this.KA.findViewById(n.f.img_msgsend_recording);
        this.KB = (LinearLayout) LayoutInflater.from(context).inflate(n.g.floating_chat_too_short_view, (ViewGroup) null);
        this.KC = (LinearLayout) LayoutInflater.from(context).inflate(n.g.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout ow() {
        return this.KA;
    }

    public LinearLayout ox() {
        return this.KB;
    }

    public LinearLayout oy() {
        return this.KC;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KD = Math.max(i, this.KD);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KE > 150) {
            this.KD = 0;
            this.KE = uptimeMillis;
        }
        this.KF++;
        if (this.KF % 5 == 0) {
            this.KF = 0;
            if (this.KD < 2) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_zero);
            } else if (this.KD < 10) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_one);
            } else if (this.KD < 20) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_two);
            } else if (this.KD < 30) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_three);
            } else if (this.KD < 40) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_four);
            } else if (this.KD < 50) {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_five);
            } else {
                this.Kz.setImageResource(n.e.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.KA.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.KA.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordTooShort() {
        this.KB.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.KB.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.KC.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.KC.setVisibility(8);
    }
}
