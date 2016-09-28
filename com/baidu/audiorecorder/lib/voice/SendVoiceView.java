package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements ab, ISendVoiceView, ak {
    private TextView EH;
    private int EI;
    private com.baidu.tbadk.editortools.l EJ;
    private FloatRecordView EK;
    private WindowManager EL;
    private WindowManager.LayoutParams EM;

    public SendVoiceView(Context context) {
        super(context);
        this.EH = null;
        this.EI = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(r.h.send_voice_view, this);
            this.EH = (TextView) findViewById(r.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lx();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.EH.setBackgroundResource(r.f.but_talk_s);
            this.EH.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_no_push));
            return;
        }
        this.EH.setBackgroundResource(r.f.but_talk_n);
        this.EH.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void lx() {
        this.EK = new FloatRecordView(getContext());
        this.EL = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.EM = new WindowManager.LayoutParams();
        this.EM.type = 2002;
        this.EM.format = 1;
        this.EM.flags = 56;
        this.EM.gravity = 17;
        this.EM.x = 0;
        this.EM.y = 0;
        this.EM.width = getContext().getResources().getDimensionPixelSize(r.e.ds360);
        this.EM.height = getContext().getResources().getDimensionPixelSize(r.e.ds360);
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
                lr();
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
        if (this.EK != null && this.EL != null && this.EM != null) {
            this.EK.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.EK != null && this.EL != null && this.EM != null) {
            this.EK.closeRecordCancel();
            LinearLayout lq = this.EK.lq();
            if (lq != null && lq.getParent() != null) {
                this.EL.removeView(lq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.EK != null && this.EL != null && this.EM != null) {
            this.EK.closeRecordTooShort();
            LinearLayout lp = this.EK.lp();
            if (lp != null && lp.getParent() != null) {
                this.EL.removeView(lp);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout lq;
        if (this.EK != null && this.EL != null && this.EM != null && (lq = this.EK.lq()) != null && lq.getParent() == null) {
            this.EL.addView(lq, this.EM);
            this.EK.showRecordCancel();
        }
    }

    public void lr() {
        LinearLayout lp;
        if (this.EK != null && this.EL != null && this.EM != null && (lp = this.EK.lp()) != null && lp.getParent() == null) {
            this.EL.addView(lp, this.EM);
            this.EK.lr();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout lo;
        if (this.EK != null && this.EL != null && this.EM != null && (lo = this.EK.lo()) != null && lo.getParent() == null) {
            this.EL.addView(lo, this.EM);
            this.EK.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.EK != null && this.EL != null && this.EM != null) {
            this.EK.stopRecordVoice();
            LinearLayout lo = this.EK.lo();
            if (lo != null && lo.getParent() != null) {
                this.EL.removeView(lo);
            }
        }
    }
}
