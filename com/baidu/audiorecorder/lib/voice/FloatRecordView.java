package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class FloatRecordView implements aj {
    private ImageView KS = null;
    private LinearLayout KT = null;
    private LinearLayout KU = null;
    private LinearLayout KV = null;
    private int KW = 0;
    private long KX = 0;
    private int KY = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.KT = (LinearLayout) LayoutInflater.from(context).inflate(w.j.float_chat_recording_view, (ViewGroup) null);
        this.KS = (ImageView) this.KT.findViewById(w.h.img_msgsend_recording);
        this.KU = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_too_short_view, (ViewGroup) null);
        this.KV = (LinearLayout) LayoutInflater.from(context).inflate(w.j.floating_chat_cancel_view, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    public LinearLayout md() {
        return this.KT;
    }

    public LinearLayout me() {
        return this.KU;
    }

    public LinearLayout mf() {
        return this.KV;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.KW = Math.max(i, this.KW);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.KX > 150) {
            this.KW = 0;
            this.KX = uptimeMillis;
        }
        this.KY++;
        if (this.KY % 5 == 0) {
            this.KY = 0;
            if (this.KW < 2) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_zero);
            } else if (this.KW < 10) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_one);
            } else if (this.KW < 20) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_two);
            } else if (this.KW < 30) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_three);
            } else if (this.KW < 40) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_four);
            } else if (this.KW < 50) {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_five);
            } else {
                this.KS.setImageResource(w.g.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        this.KT.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        this.KT.setVisibility(8);
    }

    public void mg() {
        this.KU.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        this.KU.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        this.KV.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        this.KV.setVisibility(8);
    }
}
