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
    private i axO;
    private int axP;
    private TextView ayp;
    private FloatRecordView ayq;
    private WindowManager ayr;
    private WindowManager.LayoutParams ays;

    public SendVoiceView(Context context) {
        super(context);
        this.ayp = null;
        this.axP = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.ayp = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            to();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ayp.setBackgroundResource(d.f.but_talk_s);
            this.ayp.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.ayp.setBackgroundResource(d.f.but_talk_n);
        this.ayp.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
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
        return this.axP;
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
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void to() {
        this.ayq = new FloatRecordView(getContext());
        this.ayr = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ays = new WindowManager.LayoutParams();
        this.ays.type = 2002;
        this.ays.format = 1;
        this.ays.flags = 56;
        this.ays.gravity = 17;
        this.ays.x = 0;
        this.ays.y = 0;
        this.ays.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.ays.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.ayq != null && this.ayr != null && this.ays != null) {
            this.ayq.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ayq != null && this.ayr != null && this.ays != null) {
            this.ayq.closeRecordCancel();
            LinearLayout te = this.ayq.te();
            if (te != null && te.getParent() != null) {
                this.ayr.removeView(te);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ayq != null && this.ayr != null && this.ays != null) {
            this.ayq.closeRecordTooShort();
            LinearLayout td = this.ayq.td();
            if (td != null && td.getParent() != null) {
                this.ayr.removeView(td);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout te;
        if (this.ayq != null && this.ayr != null && this.ays != null && (te = this.ayq.te()) != null && te.getParent() == null) {
            this.ayr.addView(te, this.ays);
            this.ayq.showRecordCancel();
        }
    }

    public void tf() {
        LinearLayout td;
        if (this.ayq != null && this.ayr != null && this.ays != null && (td = this.ayq.td()) != null && td.getParent() == null) {
            this.ayr.addView(td, this.ays);
            this.ayq.tf();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout tc;
        if (this.ayq != null && this.ayr != null && this.ays != null && (tc = this.ayq.tc()) != null && tc.getParent() == null) {
            this.ayr.addView(tc, this.ays);
            this.ayq.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ayq != null && this.ayr != null && this.ays != null) {
            this.ayq.stopRecordVoice();
            LinearLayout tc = this.ayq.tc();
            if (tc != null && tc.getParent() != null) {
                this.ayr.removeView(tc);
            }
        }
    }
}
