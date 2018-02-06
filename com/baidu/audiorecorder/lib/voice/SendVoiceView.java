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
    private i axP;
    private int axQ;
    private TextView ayq;
    private FloatRecordView ayr;
    private WindowManager ays;
    private WindowManager.LayoutParams ayt;

    public SendVoiceView(Context context) {
        super(context);
        this.ayq = null;
        this.axQ = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayq = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            to();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayq.setBackgroundResource(d.f.but_talk_s);
            this.ayq.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayq.setBackgroundResource(d.f.but_talk_n);
        this.ayq.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
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
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void to() {
        this.ayr = new FloatRecordView(getContext());
        this.ays = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ayt = new WindowManager.LayoutParams();
        this.ayt.type = 2002;
        this.ayt.format = 1;
        this.ayt.flags = 56;
        this.ayt.gravity = 17;
        this.ayt.x = 0;
        this.ayt.y = 0;
        this.ayt.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ayt.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                tf();
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
        if (this.ayr != null && this.ays != null && this.ayt != null) {
            this.ayr.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ayr != null && this.ays != null && this.ayt != null) {
            this.ayr.closeRecordCancel();
            LinearLayout te = this.ayr.te();
            if (te != null && te.getParent() != null) {
                this.ays.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ayr != null && this.ays != null && this.ayt != null) {
            this.ayr.closeRecordTooShort();
            LinearLayout td = this.ayr.td();
            if (td != null && td.getParent() != null) {
                this.ays.removeView(td);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout te;
        if (this.ayr != null && this.ays != null && this.ayt != null && (te = this.ayr.te()) != null && te.getParent() == null) {
            this.ays.addView(te, this.ayt);
            this.ayr.showRecordCancel();
        }
    }

    public void tf() {
        LinearLayout td;
        if (this.ayr != null && this.ays != null && this.ayt != null && (td = this.ayr.td()) != null && td.getParent() == null) {
            this.ays.addView(td, this.ayt);
            this.ayr.tf();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout tc;
        if (this.ayr != null && this.ays != null && this.ayt != null && (tc = this.ayr.tc()) != null && tc.getParent() == null) {
            this.ays.addView(tc, this.ayt);
            this.ayr.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ayr != null && this.ays != null && this.ayt != null) {
            this.ayr.stopRecordVoice();
            LinearLayout tc = this.ayr.tc();
            if (tc != null && tc.getParent() != null) {
                this.ays.removeView(tc);
            }
        }
    }
}
