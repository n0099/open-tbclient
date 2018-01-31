package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FloatRecordView implements com.baidu.tieba.im.chat.c {
    private ImageView axE = null;
    private LinearLayout axF = null;
    private LinearLayout axG = null;
    private LinearLayout axH = null;
    private int axI = 0;
    private long axJ = 0;
    private int axK = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.axF = (LinearLayout) LayoutInflater.from(context).inflate(d.h.float_chat_recording_view, (ViewGroup) null);
        this.axE = (ImageView) this.axF.findViewById(d.g.img_msgsend_recording);
        this.axG = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_too_short_view, (ViewGroup) null);
        this.axH = (LinearLayout) LayoutInflater.from(context).inflate(d.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout td() {
        return this.axF;
    }

    public LinearLayout te() {
        return this.axG;
    }

    public LinearLayout tf() {
        return this.axH;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axI = Math.max(i, this.axI);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axJ > 150) {
            this.axI = 0;
            this.axJ = uptimeMillis;
        }
        this.axK++;
        if (this.axK % 5 == 0) {
            this.axK = 0;
            if (this.axI < 2) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_zero);
            } else if (this.axI < 10) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_one);
            } else if (this.axI < 20) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_two);
            } else if (this.axI < 30) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_three);
            } else if (this.axI < 40) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_four);
            } else if (this.axI < 50) {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_five);
            } else {
                this.axE.setImageResource(d.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        this.axF.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        this.axF.setVisibility(8);
    }

    public void tg() {
        this.axG.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        this.axG.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        this.axH.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        this.axH.setVisibility(8);
    }
}
