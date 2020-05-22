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
    private ImageView Zh = null;
    private LinearLayout Zi = null;
    private LinearLayout Zj = null;
    private LinearLayout Zk = null;
    private int Zl = 0;
    private long Zm = 0;
    private int Zn = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Zi = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.Zh = (ImageView) this.Zi.findViewById(R.id.img_msgsend_recording);
        this.Zj = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Zk = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qp() {
        return this.Zi;
    }

    public LinearLayout qq() {
        return this.Zj;
    }

    public LinearLayout qr() {
        return this.Zk;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Zl = Math.max(i, this.Zl);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Zm > 150) {
            this.Zl = 0;
            this.Zm = uptimeMillis;
        }
        this.Zn++;
        if (this.Zn % 5 == 0) {
            this.Zn = 0;
            if (this.Zl < 2) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Zl < 10) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Zl < 20) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Zl < 30) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Zl < 40) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Zl < 50) {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.Zh.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Zi.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Zi.setVisibility(8);
    }

    public void qs() {
        this.Zj.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Zj.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Zk.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Zk.setVisibility(8);
    }
}
