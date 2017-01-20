package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FloatRecordView implements aj {
    private ImageView DE = null;
    private LinearLayout DF = null;
    private LinearLayout DG = null;
    private LinearLayout DH = null;
    private int DI = 0;
    private long DJ = 0;
    private int DK = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.DF = (LinearLayout) LayoutInflater.from(context).inflate(r.j.float_chat_recording_view, (ViewGroup) null);
        this.DE = (ImageView) this.DF.findViewById(r.h.img_msgsend_recording);
        this.DG = (LinearLayout) LayoutInflater.from(context).inflate(r.j.floating_chat_too_short_view, (ViewGroup) null);
        this.DH = (LinearLayout) LayoutInflater.from(context).inflate(r.j.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lj() {
        return this.DF;
    }

    public LinearLayout lk() {
        return this.DG;
    }

    public LinearLayout ll() {
        return this.DH;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.DI = Math.max(i, this.DI);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.DJ > 150) {
            this.DI = 0;
            this.DJ = uptimeMillis;
        }
        this.DK++;
        if (this.DK % 5 == 0) {
            this.DK = 0;
            if (this.DI < 2) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_zero);
            } else if (this.DI < 10) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_one);
            } else if (this.DI < 20) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_two);
            } else if (this.DI < 30) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_three);
            } else if (this.DI < 40) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_four);
            } else if (this.DI < 50) {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_five);
            } else {
                this.DE.setImageResource(r.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.DF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.DF.setVisibility(8);
    }

    public void lm() {
        this.DG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.DG.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.DH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.DH.setVisibility(8);
    }
}
