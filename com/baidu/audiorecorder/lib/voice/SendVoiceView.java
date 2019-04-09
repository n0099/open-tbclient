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
    private EditorTools VO;
    private int VP;
    private TextView Wp;
    private FloatRecordView Wq;
    private WindowManager Wr;
    private WindowManager.LayoutParams Ws;

    public SendVoiceView(Context context) {
        super(context);
        this.Wp = null;
        this.VP = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.h.send_voice_view, this);
            this.Wp = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            rb();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Wp.setBackgroundResource(d.f.but_talk_s);
            this.Wp.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_no_push));
            return;
        }
        this.Wp.setBackgroundResource(d.f.but_talk_n);
        this.Wp.setText(TbadkCoreApplication.getInst().getContext().getString(d.j.msglist_push_talk));
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
        return this.VP;
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
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void rb() {
        this.Wq = new FloatRecordView(getContext());
        this.Wr = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Ws = new WindowManager.LayoutParams();
        this.Ws.type = com.baidu.tieba.t.c.Ag(2002);
        this.Ws.format = 1;
        this.Ws.flags = 56;
        this.Ws.gravity = 17;
        this.Ws.x = 0;
        this.Ws.y = 0;
        this.Ws.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Ws.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.Wq != null && this.Wr != null && this.Ws != null) {
            this.Wq.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Wq != null && this.Wr != null && this.Ws != null) {
            this.Wq.closeRecordCancel();
            LinearLayout qQ = this.Wq.qQ();
            if (qQ != null && qQ.getParent() != null) {
                this.Wr.removeView(qQ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Wq != null && this.Wr != null && this.Ws != null) {
            this.Wq.closeRecordTooShort();
            LinearLayout qP = this.Wq.qP();
            if (qP != null && qP.getParent() != null) {
                this.Wr.removeView(qP);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qQ;
        if (this.Wq != null && this.Wr != null && this.Ws != null && (qQ = this.Wq.qQ()) != null && qQ.getParent() == null) {
            this.Wr.addView(qQ, this.Ws);
            this.Wq.showRecordCancel();
        }
    }

    public void qR() {
        LinearLayout qP;
        if (this.Wq != null && this.Wr != null && this.Ws != null && (qP = this.Wq.qP()) != null && qP.getParent() == null) {
            this.Wr.addView(qP, this.Ws);
            this.Wq.qR();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qO;
        if (this.Wq != null && this.Wr != null && this.Ws != null && (qO = this.Wq.qO()) != null && qO.getParent() == null) {
            this.Wr.addView(qO, this.Ws);
            this.Wq.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Wq != null && this.Wr != null && this.Ws != null) {
            this.Wq.stopRecordVoice();
            LinearLayout qO = this.Wq.qO();
            if (qO != null && qO.getParent() != null) {
                this.Wr.removeView(qO);
            }
        }
    }
}
