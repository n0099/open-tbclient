package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.b {
    private ImageView acN = null;
    private LinearLayout acO = null;
    private LinearLayout acP = null;
    private LinearLayout acQ = null;
    private int acR = 0;
    private long acS = 0;
    private int acT = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.acO = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.acN = (ImageView) this.acO.findViewById(R.id.img_msgsend_recording);
        this.acP = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.acQ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout rQ() {
        return this.acO;
    }

    public LinearLayout rR() {
        return this.acP;
    }

    public LinearLayout rS() {
        return this.acQ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acR = Math.max(i, this.acR);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acS > 150) {
            this.acR = 0;
            this.acS = uptimeMillis;
        }
        this.acT++;
        if (this.acT % 5 == 0) {
            this.acT = 0;
            if (this.acR < 2) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.acR < 10) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.acR < 20) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.acR < 30) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.acR < 40) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.acR < 50) {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.acN.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        this.acO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        this.acO.setVisibility(8);
    }

    public void rT() {
        this.acP.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        this.acP.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        this.acQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        this.acQ.setVisibility(8);
    }
}
