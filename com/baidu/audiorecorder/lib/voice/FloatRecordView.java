package com.baidu.audiorecorder.lib.voice;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.chat.av;
/* loaded from: classes.dex */
public class FloatRecordView implements av {
    private ImageView Kd = null;
    private LinearLayout Ke = null;
    private LinearLayout Kf = null;
    private LinearLayout Kg = null;
    private int Kh = 0;
    private long Ki = 0;
    private int Kj = 0;

    public FloatRecordView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            b(viewGroup);
        }
    }

    private void b(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(viewGroup.getContext(), com.baidu.tieba.r.float_record_view, viewGroup);
        this.Ke = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.lay_msgsend_voicelayer);
        this.Ke.setVisibility(8);
        this.Kd = (ImageView) inflate.findViewById(com.baidu.tieba.q.img_msgsend_recording);
        this.Kf = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.lay_msgsend_voicelayer_short);
        this.Kg = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.lay_msgsend_voicelayer_cancel);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                showRecordTooShort();
            }
        }
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

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.Kh = Math.max(i, this.Kh);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ki > 150) {
            this.Kh = 0;
            this.Ki = uptimeMillis;
        }
        this.Kj++;
        if (this.Kj % 5 == 0) {
            this.Kj = 0;
            if (this.Kh < 2) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_zero);
            } else if (this.Kh < 10) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_one);
            } else if (this.Kh < 20) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_two);
            } else if (this.Kh < 30) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_three);
            } else if (this.Kh < 40) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_four);
            } else if (this.Kh < 50) {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_five);
            } else {
                this.Kd.setImageResource(com.baidu.tieba.p.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.av
    public void startRecordVoice() {
        this.Ke.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void stopRecordVoice() {
        this.Ke.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordTooShort() {
        this.Kf.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordTooShort() {
        this.Kf.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordCancel() {
        this.Kg.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordCancel() {
        this.Kg.setVisibility(8);
    }
}
