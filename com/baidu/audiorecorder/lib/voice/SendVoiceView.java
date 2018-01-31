package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements s, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private i axQ;
    private int axR;
    private TextView ayr;
    private FloatRecordView ays;
    private WindowManager ayt;
    private WindowManager.LayoutParams ayu;

    public SendVoiceView(Context context) {
        super(context);
        this.ayr = null;
        this.axR = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayr = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            tp();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayr.setBackgroundResource(d.f.but_talk_s);
            this.ayr.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayr.setBackgroundResource(d.f.but_talk_n);
        this.ayr.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void ti() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void tp() {
        this.ays = new FloatRecordView(getContext());
        this.ayt = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ayu = new WindowManager.LayoutParams();
        this.ayu.type = 2002;
        this.ayu.format = 1;
        this.ayu.flags = 56;
        this.ayu.gravity = 17;
        this.ayu.x = 0;
        this.ayu.y = 0;
        this.ayu.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ayu.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                tg();
            }
        }
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

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        if (this.ays != null && this.ayt != null && this.ayu != null) {
            this.ays.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ays != null && this.ayt != null && this.ayu != null) {
            this.ays.closeRecordCancel();
            LinearLayout tf = this.ays.tf();
            if (tf != null && tf.getParent() != null) {
                this.ayt.removeView(tf);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ays != null && this.ayt != null && this.ayu != null) {
            this.ays.closeRecordTooShort();
            LinearLayout te = this.ays.te();
            if (te != null && te.getParent() != null) {
                this.ayt.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout tf;
        if (this.ays != null && this.ayt != null && this.ayu != null && (tf = this.ays.tf()) != null && tf.getParent() == null) {
            this.ayt.addView(tf, this.ayu);
            this.ays.showRecordCancel();
        }
    }

    public void tg() {
        LinearLayout te;
        if (this.ays != null && this.ayt != null && this.ayu != null && (te = this.ays.te()) != null && te.getParent() == null) {
            this.ayt.addView(te, this.ayu);
            this.ays.tg();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout td;
        if (this.ays != null && this.ayt != null && this.ayu != null && (td = this.ays.td()) != null && td.getParent() == null) {
            this.ayt.addView(td, this.ayu);
            this.ays.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ays != null && this.ayt != null && this.ayu != null) {
            this.ays.stopRecordVoice();
            LinearLayout td = this.ays.td();
            if (td != null && td.getParent() != null) {
                this.ayt.removeView(td);
            }
        }
    }
}
