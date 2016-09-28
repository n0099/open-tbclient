package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class FloatRecordView implements ak {
    private ImageView Eq = null;
    private LinearLayout Er = null;
    private LinearLayout Es = null;
    private LinearLayout Et = null;
    private int Eu = 0;
    private long Ev = 0;
    private int Ew = 0;

    public FloatRecordView(Context context) {
        a(context, null);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.Er = (LinearLayout) LayoutInflater.from(context).inflate(r.h.float_chat_recording_view, (ViewGroup) null);
        this.Eq = (ImageView) this.Er.findViewById(r.g.img_msgsend_recording);
        this.Es = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_too_short_view, (ViewGroup) null);
        this.Et = (LinearLayout) LayoutInflater.from(context).inflate(r.h.floating_chat_cancel_view, (ViewGroup) null);
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

    public LinearLayout lo() {
        return this.Er;
    }

    public LinearLayout lp() {
        return this.Es;
    }

    public LinearLayout lq() {
        return this.Et;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Eu = Math.max(i, this.Eu);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ev > 150) {
            this.Eu = 0;
            this.Ev = uptimeMillis;
        }
        this.Ew++;
        if (this.Ew % 5 == 0) {
            this.Ew = 0;
            if (this.Eu < 2) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_zero);
            } else if (this.Eu < 10) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_one);
            } else if (this.Eu < 20) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_two);
            } else if (this.Eu < 30) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_three);
            } else if (this.Eu < 40) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_four);
            } else if (this.Eu < 50) {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_five);
            } else {
                this.Eq.setImageResource(r.f.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        this.Er.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        this.Er.setVisibility(8);
    }

    public void lr() {
        this.Es.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        this.Es.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        this.Et.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        this.Et.setVisibility(8);
    }
}
