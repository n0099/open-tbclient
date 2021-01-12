package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.b {
    private ImageView acL = null;
    private LinearLayout acM = null;
    private LinearLayout acN = null;
    private LinearLayout acO = null;
    private int acP = 0;
    private long acQ = 0;
    private int acR = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.acM = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.acL = (ImageView) this.acM.findViewById(R.id.img_msgsend_recording);
        this.acN = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.acO = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.acM;
    }

    public LinearLayout rR() {
        return this.acN;
    }

    public LinearLayout rS() {
        return this.acO;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acP = Math.max(i, this.acP);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acQ > 150) {
            this.acP = 0;
            this.acQ = uptimeMillis;
        }
        this.acR++;
        if (this.acR % 5 == 0) {
            this.acR = 0;
            if (this.acP < 2) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.acP < 10) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.acP < 20) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.acP < 30) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.acP < 40) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.acP < 50) {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.acL.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        this.acM.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        this.acM.setVisibility(8);
    }

    public void rT() {
        this.acN.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        this.acN.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        this.acO.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        this.acO.setVisibility(8);
    }
}
