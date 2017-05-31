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
    private TextView JS;
    private int JT;
    private com.baidu.tbadk.editortools.j JU;
    private FloatRecordView JV;
    private WindowManager JW;
    private WindowManager.LayoutParams JX;

    public SendVoiceView(Context context) {
        super(context);
        this.JS = null;
        this.JT = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(w.j.send_voice_view, this);
            this.JS = (TextView) findViewById(w.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lP();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.JS.setBackgroundResource(w.g.but_talk_s);
            this.JS.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_no_push));
            return;
        }
        this.JS.setBackgroundResource(w.g.but_talk_n);
        this.JS.setText(TbadkCoreApplication.m9getInst().getContext().getString(w.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
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
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void lP() {
        this.JV = new FloatRecordView(getContext());
        this.JW = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.JX = new WindowManager.LayoutParams();
        this.JX.type = 2002;
        this.JX.format = 1;
        this.JX.flags = 56;
        this.JX.gravity = 17;
        this.JX.x = 0;
        this.JX.y = 0;
        this.JX.width = getContext().getResources().getDimensionPixelSize(w.f.ds360);
        this.JX.height = getContext().getResources().getDimensionPixelSize(w.f.ds360);
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
                lK();
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
        if (this.JV != null && this.JW != null && this.JX != null) {
            this.JV.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordCancel() {
        if (this.JV != null && this.JW != null && this.JX != null) {
            this.JV.closeRecordCancel();
            LinearLayout lJ = this.JV.lJ();
            if (lJ != null && lJ.getParent() != null) {
                this.JW.removeView(lJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void closeRecordTooShort() {
        if (this.JV != null && this.JW != null && this.JX != null) {
            this.JV.closeRecordTooShort();
            LinearLayout lI = this.JV.lI();
            if (lI != null && lI.getParent() != null) {
                this.JW.removeView(lI);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void showRecordCancel() {
        LinearLayout lJ;
        if (this.JV != null && this.JW != null && this.JX != null && (lJ = this.JV.lJ()) != null && lJ.getParent() == null) {
            this.JW.addView(lJ, this.JX);
            this.JV.showRecordCancel();
        }
    }

    public void lK() {
        LinearLayout lI;
        if (this.JV != null && this.JW != null && this.JX != null && (lI = this.JV.lI()) != null && lI.getParent() == null) {
            this.JW.addView(lI, this.JX);
            this.JV.lK();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void startRecordVoice() {
        LinearLayout lH;
        if (this.JV != null && this.JW != null && this.JX != null && (lH = this.JV.lH()) != null && lH.getParent() == null) {
            this.JW.addView(lH, this.JX);
            this.JV.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.aj
    public void stopRecordVoice() {
        if (this.JV != null && this.JW != null && this.JX != null) {
            this.JV.stopRecordVoice();
            LinearLayout lH = this.JV.lH();
            if (lH != null && lH.getParent() != null) {
                this.JW.removeView(lH);
            }
        }
    }
}
