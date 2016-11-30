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
    private TextView EJ;
    private int EK;
    private com.baidu.tbadk.editortools.l EL;
    private FloatRecordView EM;
    private WindowManager EN;
    private WindowManager.LayoutParams EO;

    public SendVoiceView(Context context) {
        super(context);
        this.EJ = null;
        this.EK = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(r.h.send_voice_view, this);
            this.EJ = (TextView) findViewById(r.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lA();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.EJ.setBackgroundResource(r.f.but_talk_s);
            this.EJ.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_no_push));
            return;
        }
        this.EJ.setBackgroundResource(r.f.but_talk_n);
        this.EJ.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
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
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void lA() {
        this.EM = new FloatRecordView(getContext());
        this.EN = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.EO = new WindowManager.LayoutParams();
        this.EO.type = 2002;
        this.EO.format = 1;
        this.EO.flags = 56;
        this.EO.gravity = 17;
        this.EO.x = 0;
        this.EO.y = 0;
        this.EO.width = getContext().getResources().getDimensionPixelSize(r.e.ds360);
        this.EO.height = getContext().getResources().getDimensionPixelSize(r.e.ds360);
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
                lu();
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
        if (this.EM != null && this.EN != null && this.EO != null) {
            this.EM.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.EM != null && this.EN != null && this.EO != null) {
            this.EM.closeRecordCancel();
            LinearLayout lt = this.EM.lt();
            if (lt != null && lt.getParent() != null) {
                this.EN.removeView(lt);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.EM != null && this.EN != null && this.EO != null) {
            this.EM.closeRecordTooShort();
            LinearLayout ls = this.EM.ls();
            if (ls != null && ls.getParent() != null) {
                this.EN.removeView(ls);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout lt;
        if (this.EM != null && this.EN != null && this.EO != null && (lt = this.EM.lt()) != null && lt.getParent() == null) {
            this.EN.addView(lt, this.EO);
            this.EM.showRecordCancel();
        }
    }

    public void lu() {
        LinearLayout ls;
        if (this.EM != null && this.EN != null && this.EO != null && (ls = this.EM.ls()) != null && ls.getParent() == null) {
            this.EN.addView(ls, this.EO);
            this.EM.lu();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout lr;
        if (this.EM != null && this.EN != null && this.EO != null && (lr = this.EM.lr()) != null && lr.getParent() == null) {
            this.EN.addView(lr, this.EO);
            this.EM.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.EM != null && this.EN != null && this.EO != null) {
            this.EM.stopRecordVoice();
            LinearLayout lr = this.EM.lr();
            if (lr != null && lr.getParent() != null) {
                this.EN.removeView(lr);
            }
        }
    }
}
