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
    private ImageView Kl = null;
    private LinearLayout Km = null;
    private LinearLayout Kn = null;
    private LinearLayout Ko = null;
    private int Kp = 0;
    private long Kq = 0;
    private int Kr = 0;

    public FloatRecordView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            b(viewGroup);
        }
    }

    private void b(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), com.baidu.tieba.w.float_record_view, viewGroup);
        this.Km = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer);
        this.Km.setVisibility(8);
        this.Kl = (ImageView) inflate.findViewById(com.baidu.tieba.v.img_msgsend_recording);
        this.Kn = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_short);
        this.Ko = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voicelayer_cancel);
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
        this.Kp = Math.max(i, this.Kp);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Kq > 150) {
            this.Kp = 0;
            this.Kq = uptimeMillis;
        }
        this.Kr++;
        if (this.Kr % 5 == 0) {
            this.Kr = 0;
            if (this.Kp < 2) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_zero);
            } else if (this.Kp < 10) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_one);
            } else if (this.Kp < 20) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_two);
            } else if (this.Kp < 30) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            } else if (this.Kp < 40) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_four);
            } else if (this.Kp < 50) {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_five);
            } else {
                this.Kl.setImageResource(com.baidu.tieba.u.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.av
    public void startRecordVoice() {
        this.Km.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void stopRecordVoice() {
        this.Km.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordTooShort() {
        this.Kn.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordTooShort() {
        this.Kn.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void showRecordCancel() {
        this.Ko.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.av
    public void closeRecordCancel() {
        this.Ko.setVisibility(8);
    }
}
