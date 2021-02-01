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
    private ImageView acF = null;
    private LinearLayout acG = null;
    private LinearLayout acH = null;
    private LinearLayout acI = null;
    private int acJ = 0;
    private long acK = 0;
    private int acL = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.acG = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.acF = (ImageView) this.acG.findViewById(R.id.img_msgsend_recording);
        this.acH = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.acI = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout rO() {
        return this.acG;
    }

    public LinearLayout rP() {
        return this.acH;
    }

    public LinearLayout rQ() {
        return this.acI;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acJ = Math.max(i, this.acJ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acK > 150) {
            this.acJ = 0;
            this.acK = uptimeMillis;
        }
        this.acL++;
        if (this.acL % 5 == 0) {
            this.acL = 0;
            if (this.acJ < 2) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.acJ < 10) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.acJ < 20) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.acJ < 30) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.acJ < 40) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.acJ < 50) {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.acF.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        this.acG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        this.acG.setVisibility(8);
    }

    public void rR() {
        this.acH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        this.acH.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        this.acI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        this.acI.setVisibility(8);
    }
}
