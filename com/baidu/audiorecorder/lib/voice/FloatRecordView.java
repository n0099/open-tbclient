package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView FC = null;
    private LinearLayout FD = null;
    private LinearLayout FE = null;
    private LinearLayout FF = null;
    private int FG = 0;
    private long FH = 0;
    private int FI = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.FD = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.FC = (ImageView) this.FD.findViewById(R.id.img_msgsend_recording);
        this.FE = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.FF = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lH() {
        return this.FD;
    }

    public LinearLayout lI() {
        return this.FE;
    }

    public LinearLayout lJ() {
        return this.FF;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.FG = Math.max(i, this.FG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.FH > 150) {
            this.FG = 0;
            this.FH = uptimeMillis;
        }
        this.FI++;
        if (this.FI % 5 == 0) {
            this.FI = 0;
            if (this.FG < 2) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.FG < 10) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.FG < 20) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.FG < 30) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.FG < 40) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.FG < 50) {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.FC.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.FD.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.FD.setVisibility(8);
    }

    public void lK() {
        this.FE.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.FE.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.FF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.FF.setVisibility(8);
    }
}
