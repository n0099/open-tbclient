package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView aaG = null;
    private LinearLayout aaH = null;
    private LinearLayout aaI = null;
    private LinearLayout aaJ = null;
    private int aaK = 0;
    private long aaL = 0;
    private int aaM = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.aaH = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.aaG = (ImageView) this.aaH.findViewById(R.id.img_msgsend_recording);
        this.aaI = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.aaJ = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout sn() {
        return this.aaH;
    }

    public LinearLayout so() {
        return this.aaI;
    }

    public LinearLayout sp() {
        return this.aaJ;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aaK = Math.max(i, this.aaK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aaL > 150) {
            this.aaK = 0;
            this.aaL = uptimeMillis;
        }
        this.aaM++;
        if (this.aaM % 5 == 0) {
            this.aaM = 0;
            if (this.aaK < 2) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.aaK < 10) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.aaK < 20) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.aaK < 30) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.aaK < 40) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.aaK < 50) {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.aaG.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.aaH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.aaH.setVisibility(8);
    }

    public void sq() {
        this.aaI.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.aaI.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.aaJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.aaJ.setVisibility(8);
    }
}
