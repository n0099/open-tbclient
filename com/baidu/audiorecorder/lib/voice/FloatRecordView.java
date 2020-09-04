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
    private ImageView aao = null;
    private LinearLayout aap = null;
    private LinearLayout aaq = null;
    private LinearLayout aar = null;
    private int aas = 0;
    private long aat = 0;
    private int aau = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aap = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.aao = (ImageView) this.aap.findViewById(R.id.img_msgsend_recording);
        this.aaq = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aar = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.aap;
    }

    public LinearLayout sj() {
        return this.aaq;
    }

    public LinearLayout sk() {
        return this.aar;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aas = Math.max(i, this.aas);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aat > 150) {
            this.aas = 0;
            this.aat = uptimeMillis;
        }
        this.aau++;
        if (this.aau % 5 == 0) {
            this.aau = 0;
            if (this.aas < 2) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.aas < 10) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.aas < 20) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.aas < 30) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.aas < 40) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.aas < 50) {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.aao.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aap.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aap.setVisibility(8);
    }

    public void sl() {
        this.aaq.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.aaq.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.aar.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.aar.setVisibility(8);
    }
}
