package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView CZ = null;
    private LinearLayout Da = null;
    private LinearLayout Db = null;
    private LinearLayout Dc = null;
    private int Dd = 0;
    private long De = 0;
    private int Df = 0;

    public FloatRecordView(Context context) {
        c(context, null);
    }

    private void c(Context context, ViewGroup viewGroup) {
        this.Da = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.CZ = (ImageView) this.Da.findViewById(R.id.img_msgsend_recording);
        this.Db = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.Dc = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout kZ() {
        return this.Da;
    }

    public LinearLayout la() {
        return this.Db;
    }

    public LinearLayout lb() {
        return this.Dc;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Dd = Math.max(i, this.Dd);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.De > 150) {
            this.Dd = 0;
            this.De = uptimeMillis;
        }
        this.Df++;
        if (this.Df % 5 == 0) {
            this.Df = 0;
            if (this.Dd < 2) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (this.Dd < 10) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (this.Dd < 20) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (this.Dd < 30) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (this.Dd < 40) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (this.Dd < 50) {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.CZ.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.Da.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.Da.setVisibility(8);
    }

    public void lc() {
        this.Db.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.Db.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.Dc.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.Dc.setVisibility(8);
    }
}
