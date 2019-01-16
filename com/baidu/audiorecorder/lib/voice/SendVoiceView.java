package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView TK;
    private FloatRecordView TL;
    private WindowManager TM;
    private WindowManager.LayoutParams TO;
    private EditorTools Tj;
    private int Tk;

    public SendVoiceView(Context context) {
        super(context);
        this.TK = null;
        this.Tk = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(e.h.send_voice_view, this);
            this.TK = (TextView) findViewById(e.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pY();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.TK.setBackgroundResource(e.f.but_talk_s);
            this.TK.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_no_push));
            return;
        }
        this.TK.setBackgroundResource(e.f.but_talk_n);
        this.TK.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
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
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pY() {
        this.TL = new FloatRecordView(getContext());
        this.TM = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.TO = new WindowManager.LayoutParams();
        this.TO.type = com.baidu.tieba.u.b.wy(2002);
        this.TO.format = 1;
        this.TO.flags = 56;
        this.TO.gravity = 17;
        this.TO.x = 0;
        this.TO.y = 0;
        this.TO.width = getContext().getResources().getDimensionPixelSize(e.C0210e.ds360);
        this.TO.height = getContext().getResources().getDimensionPixelSize(e.C0210e.ds360);
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
                pP();
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
        if (this.TL != null && this.TM != null && this.TO != null) {
            this.TL.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.TL != null && this.TM != null && this.TO != null) {
            this.TL.closeRecordCancel();
            LinearLayout pO = this.TL.pO();
            if (pO != null && pO.getParent() != null) {
                this.TM.removeView(pO);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.TL != null && this.TM != null && this.TO != null) {
            this.TL.closeRecordTooShort();
            LinearLayout pN = this.TL.pN();
            if (pN != null && pN.getParent() != null) {
                this.TM.removeView(pN);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pO;
        if (this.TL != null && this.TM != null && this.TO != null && (pO = this.TL.pO()) != null && pO.getParent() == null) {
            this.TM.addView(pO, this.TO);
            this.TL.showRecordCancel();
        }
    }

    public void pP() {
        LinearLayout pN;
        if (this.TL != null && this.TM != null && this.TO != null && (pN = this.TL.pN()) != null && pN.getParent() == null) {
            this.TM.addView(pN, this.TO);
            this.TL.pP();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pM;
        if (this.TL != null && this.TM != null && this.TO != null && (pM = this.TL.pM()) != null && pM.getParent() == null) {
            this.TM.addView(pM, this.TO);
            this.TL.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.TL != null && this.TM != null && this.TO != null) {
            this.TL.stopRecordVoice();
            LinearLayout pM = this.TL.pM();
            if (pM != null && pM.getParent() != null) {
                this.TM.removeView(pM);
            }
        }
    }
}
