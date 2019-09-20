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
    private ImageView TG = null;
    private LinearLayout TH = null;
    private LinearLayout TI = null;
    private LinearLayout TJ = null;
    private int TK = 0;
    private long TL = 0;
    private int TM = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.TH = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.TG = (ImageView) this.TH.findViewById(R.id.img_msgsend_recording);
        this.TI = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.TJ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qg() {
        return this.TH;
    }

    public LinearLayout qh() {
        return this.TI;
    }

    public LinearLayout qi() {
        return this.TJ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.TK = Math.max(i, this.TK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.TL > 150) {
            this.TK = 0;
            this.TL = uptimeMillis;
        }
        this.TM++;
        if (this.TM % 5 == 0) {
            this.TM = 0;
            if (this.TK < 2) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.TK < 10) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.TK < 20) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.TK < 30) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.TK < 40) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.TK < 50) {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.TG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.TH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.TH.setVisibility(8);
    }

    public void qj() {
        this.TI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.TI.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.TJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.TJ.setVisibility(8);
    }
}
