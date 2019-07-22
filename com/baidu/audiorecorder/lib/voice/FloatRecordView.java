package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView TH = null;
    private LinearLayout TI = null;
    private LinearLayout TJ = null;
    private LinearLayout TK = null;
    private int TL = 0;
    private long TM = 0;
    private int TO = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.TI = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.TH = (ImageView) this.TI.findViewById(R.id.img_msgsend_recording);
        this.TJ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.TK = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qf() {
        return this.TI;
    }

    public LinearLayout qg() {
        return this.TJ;
    }

    public LinearLayout qh() {
        return this.TK;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.TL = Math.max(i, this.TL);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.TM > 150) {
            this.TL = 0;
            this.TM = uptimeMillis;
        }
        this.TO++;
        if (this.TO % 5 == 0) {
            this.TO = 0;
            if (this.TL < 2) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.TL < 10) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.TL < 20) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.TL < 30) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.TL < 40) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.TL < 50) {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.TH.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.TI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.TI.setVisibility(8);
    }

    public void qi() {
        this.TJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.TJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.TK.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.TK.setVisibility(8);
    }
}
