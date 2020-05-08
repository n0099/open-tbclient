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
    private ImageView YR = null;
    private LinearLayout YS = null;
    private LinearLayout YT = null;
    private LinearLayout YU = null;
    private int YV = 0;
    private long YW = 0;
    private int YX = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.YS = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.YR = (ImageView) this.YS.findViewById(R.id.img_msgsend_recording);
        this.YT = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.YU = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qj() {
        return this.YS;
    }

    public LinearLayout qk() {
        return this.YT;
    }

    public LinearLayout ql() {
        return this.YU;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.YV = Math.max(i, this.YV);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.YW > 150) {
            this.YV = 0;
            this.YW = uptimeMillis;
        }
        this.YX++;
        if (this.YX % 5 == 0) {
            this.YX = 0;
            if (this.YV < 2) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.YV < 10) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.YV < 20) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.YV < 30) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.YV < 40) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.YV < 50) {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.YR.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.YS.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.YS.setVisibility(8);
    }

    public void qm() {
        this.YT.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.YT.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.YU.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.YU.setVisibility(8);
    }
}
