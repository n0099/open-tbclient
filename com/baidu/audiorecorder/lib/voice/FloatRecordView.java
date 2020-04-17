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
    private ImageView YO = null;
    private LinearLayout YP = null;
    private LinearLayout YQ = null;
    private LinearLayout YR = null;
    private int YS = 0;
    private long YT = 0;
    private int YU = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.YP = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.YO = (ImageView) this.YP.findViewById(R.id.img_msgsend_recording);
        this.YQ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.YR = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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
        return this.YP;
    }

    public LinearLayout qk() {
        return this.YQ;
    }

    public LinearLayout ql() {
        return this.YR;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.YS = Math.max(i, this.YS);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.YT > 150) {
            this.YS = 0;
            this.YT = uptimeMillis;
        }
        this.YU++;
        if (this.YU % 5 == 0) {
            this.YU = 0;
            if (this.YS < 2) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.YS < 10) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.YS < 20) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.YS < 30) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.YS < 40) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.YS < 50) {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.YO.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.YP.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.YP.setVisibility(8);
    }

    public void qm() {
        this.YQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.YQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.YR.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.YR.setVisibility(8);
    }
}
