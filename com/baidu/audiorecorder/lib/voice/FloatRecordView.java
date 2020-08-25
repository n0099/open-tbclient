package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView aam = null;
    private LinearLayout aan = null;
    private LinearLayout aao = null;
    private LinearLayout aap = null;
    private int aaq = 0;
    private long aar = 0;
    private int aas = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aan = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.aam = (ImageView) this.aan.findViewById(R.id.img_msgsend_recording);
        this.aao = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aap = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout si() {
        return this.aan;
    }

    public LinearLayout sj() {
        return this.aao;
    }

    public LinearLayout sk() {
        return this.aap;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aaq = Math.max(i, this.aaq);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aar > 150) {
            this.aaq = 0;
            this.aar = uptimeMillis;
        }
        this.aas++;
        if (this.aas % 5 == 0) {
            this.aas = 0;
            if (this.aaq < 2) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.aaq < 10) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.aaq < 20) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.aaq < 30) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.aaq < 40) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.aaq < 50) {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.aam.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aan.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aan.setVisibility(8);
    }

    public void sl() {
        this.aao.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.aao.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.aap.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.aap.setVisibility(8);
    }
}
