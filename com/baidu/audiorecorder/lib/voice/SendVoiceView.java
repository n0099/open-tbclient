package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.aj;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements com.baidu.tbadk.editortools.y, ISendVoiceView, aj {
    private TextView Ke;
    private int Kf;
    private com.baidu.tbadk.editortools.j Kg;
    private FloatRecordView Kh;
    private WindowManager Ki;
    private WindowManager.LayoutParams Kj;

    public SendVoiceView(Context context) {
        super(context);
        this.Ke = null;
        this.Kf = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.Ke = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lX();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Ke.setBackgroundResource(w.g.but_talk_s);
            this.Ke.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.Ke.setBackgroundResource(w.g.but_talk_n);
        this.Ke.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void lX() {
        this.Kh = new FloatRecordView(getContext());
        this.Ki = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.Kj = new WindowManager.LayoutParams();
        this.Kj.type = 2002;
        this.Kj.format = 1;
        this.Kj.flags = 56;
        this.Kj.gravity = 17;
        this.Kj.x = 0;
        this.Kj.y = 0;
        this.Kj.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.Kj.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
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
                lS();
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
        if (this.Kh != null && this.Ki != null && this.Kj != null) {
            this.Kh.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.Kh != null && this.Ki != null && this.Kj != null) {
            this.Kh.closeRecordCancel();
            LinearLayout lR = this.Kh.lR();
            if (lR != null && lR.getParent() != null) {
                this.Ki.removeView(lR);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.Kh != null && this.Ki != null && this.Kj != null) {
            this.Kh.closeRecordTooShort();
            LinearLayout lQ = this.Kh.lQ();
            if (lQ != null && lQ.getParent() != null) {
                this.Ki.removeView(lQ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout lR;
        if (this.Kh != null && this.Ki != null && this.Kj != null && (lR = this.Kh.lR()) != null && lR.getParent() == null) {
            this.Ki.addView(lR, this.Kj);
            this.Kh.showRecordCancel();
        }
    }

    public void lS() {
        LinearLayout lQ;
        if (this.Kh != null && this.Ki != null && this.Kj != null && (lQ = this.Kh.lQ()) != null && lQ.getParent() == null) {
            this.Ki.addView(lQ, this.Kj);
            this.Kh.lS();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout lP;
        if (this.Kh != null && this.Ki != null && this.Kj != null && (lP = this.Kh.lP()) != null && lP.getParent() == null) {
            this.Ki.addView(lP, this.Kj);
            this.Kh.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.Kh != null && this.Ki != null && this.Kj != null) {
            this.Kh.stopRecordVoice();
            LinearLayout lP = this.Kh.lP();
            if (lP != null && lP.getParent() != null) {
                this.Ki.removeView(lP);
            }
        }
    }
}
