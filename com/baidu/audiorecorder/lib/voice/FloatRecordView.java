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
    private ImageView ZG = null;
    private LinearLayout ZH = null;
    private LinearLayout ZI = null;
    private LinearLayout ZJ = null;
    private int ZK = 0;
    private long ZL = 0;
    private int ZM = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.ZH = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.ZG = (ImageView) this.ZH.findViewById(R.id.img_msgsend_recording);
        this.ZI = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.ZJ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout qJ() {
        return this.ZH;
    }

    public LinearLayout qK() {
        return this.ZI;
    }

    public LinearLayout qL() {
        return this.ZJ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.ZK = Math.max(i, this.ZK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ZL > 150) {
            this.ZK = 0;
            this.ZL = uptimeMillis;
        }
        this.ZM++;
        if (this.ZM % 5 == 0) {
            this.ZM = 0;
            if (this.ZK < 2) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.ZK < 10) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.ZK < 20) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.ZK < 30) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.ZK < 40) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.ZK < 50) {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.ZG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.ZH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.ZH.setVisibility(8);
    }

    public void qM() {
        this.ZI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.ZI.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.ZJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.ZJ.setVisibility(8);
    }
}
