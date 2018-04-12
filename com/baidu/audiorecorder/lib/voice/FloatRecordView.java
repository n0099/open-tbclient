package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView JG = null;
    private LinearLayout JH = null;
    private LinearLayout JI = null;
    private LinearLayout JJ = null;
    private int JK = 0;
    private long JL = 0;
    private int JM = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.JH = (LinearLayout) LayoutInflater.from(context).inflate(d.i.float_chat_recording_view, (ViewGroup) null);
        this.JG = (ImageView) this.JH.findViewById(d.g.img_msgsend_recording);
        this.JI = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_too_short_view, (ViewGroup) null);
        this.JJ = (LinearLayout) LayoutInflater.from(context).inflate(d.i.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lI() {
        return this.JH;
    }

    public LinearLayout lJ() {
        return this.JI;
    }

    public LinearLayout lK() {
        return this.JJ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.JK = Math.max(i, this.JK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JL > 150) {
            this.JK = 0;
            this.JL = uptimeMillis;
        }
        this.JM++;
        if (this.JM % 5 == 0) {
            this.JM = 0;
            if (this.JK < 2) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.JK < 10) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.JK < 20) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.JK < 30) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.JK < 40) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.JK < 50) {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.JG.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.JH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.JH.setVisibility(8);
    }

    public void lL() {
        this.JI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.JI.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.JJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.JJ.setVisibility(8);
    }
}
