package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes6.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools VN;
    private int VO;
    private TextView Wo;
    private FloatRecordView Wp;
    private WindowManager Wq;
    private WindowManager.LayoutParams Wr;

    public SendVoiceView(Context context) {
        super(context);
        this.Wo = null;
        this.VO = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.Wo = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            rb();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Wo.setBackgroundResource(d.f.but_talk_s);
            this.Wo.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.Wo.setBackgroundResource(d.f.but_talk_n);
        this.Wo.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void rb() {
        this.Wp = new FloatRecordView(getContext());
        this.Wq = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Wr = new WindowManager.LayoutParams();
        this.Wr.type = com.baidu.tieba.t.c.Ag(2002);
        this.Wr.format = 1;
        this.Wr.flags = 56;
        this.Wr.gravity = 17;
        this.Wr.x = 0;
        this.Wr.y = 0;
        this.Wr.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Wr.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                qR();
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
        if (this.Wp != null && this.Wq != null && this.Wr != null) {
            this.Wp.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Wp != null && this.Wq != null && this.Wr != null) {
            this.Wp.closeRecordCancel();
            LinearLayout qQ = this.Wp.qQ();
            if (qQ != null && qQ.getParent() != null) {
                this.Wq.removeView(qQ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Wp != null && this.Wq != null && this.Wr != null) {
            this.Wp.closeRecordTooShort();
            LinearLayout qP = this.Wp.qP();
            if (qP != null && qP.getParent() != null) {
                this.Wq.removeView(qP);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qQ;
        if (this.Wp != null && this.Wq != null && this.Wr != null && (qQ = this.Wp.qQ()) != null && qQ.getParent() == null) {
            this.Wq.addView(qQ, this.Wr);
            this.Wp.showRecordCancel();
        }
    }

    public void qR() {
        LinearLayout qP;
        if (this.Wp != null && this.Wq != null && this.Wr != null && (qP = this.Wp.qP()) != null && qP.getParent() == null) {
            this.Wq.addView(qP, this.Wr);
            this.Wp.qR();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qO;
        if (this.Wp != null && this.Wq != null && this.Wr != null && (qO = this.Wp.qO()) != null && qO.getParent() == null) {
            this.Wq.addView(qO, this.Wr);
            this.Wp.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Wp != null && this.Wq != null && this.Wr != null) {
            this.Wp.stopRecordVoice();
            LinearLayout qO = this.Wp.qO();
            if (qO != null && qO.getParent() != null) {
                this.Wq.removeView(qO);
            }
        }
    }
}
