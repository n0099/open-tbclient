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
    private ImageView Kj = null;
    private LinearLayout Kk = null;
    private LinearLayout Kl = null;
    private LinearLayout Km = null;
    private int Kn = 0;
    private long Ko = 0;
    private int Kp = 0;

    public FloatRecordView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            b(viewGroup);
        }
    }

    private void b(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), com.baidu.tieba.w.float_record_view, viewGroup);
        this.Kk = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer);
        this.Kk.setVisibility(8);
        this.Kj = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_msgsend_recording);
        this.Kl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_short);
        this.Km = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_cancel);
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
        this.Kn = Math.max(i, this.Kn);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Ko > 150) {
            this.Kn = 0;
            this.Ko = uptimeMillis;
        }
        this.Kp++;
        if (this.Kp % 5 == 0) {
            this.Kp = 0;
            if (this.Kn < 2) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_zero);
            } else if (this.Kn < 10) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_one);
            } else if (this.Kn < 20) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_two);
            } else if (this.Kn < 30) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            } else if (this.Kn < 40) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_four);
            } else if (this.Kn < 50) {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_five);
            } else {
                this.Kj.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.av
    public void startRecordVoice() {
        this.Kk.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void stopRecordVoice() {
        this.Kk.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordTooShort() {
        this.Kl.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordTooShort() {
        this.Kl.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordCancel() {
        this.Km.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordCancel() {
        this.Km.setVisibility(8);
    }
}
