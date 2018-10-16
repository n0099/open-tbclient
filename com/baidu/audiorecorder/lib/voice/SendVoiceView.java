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
    private EditorTools SY;
    private int SZ;
    private WindowManager TA;
    private WindowManager.LayoutParams TB;
    private TextView Ty;
    private FloatRecordView Tz;

    public SendVoiceView(Context context) {
        super(context);
        this.Ty = null;
        this.SZ = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(e.h.send_voice_view, this);
            this.Ty = (TextView) findViewById(e.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pX();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Ty.setBackgroundResource(e.f.but_talk_s);
            this.Ty.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_no_push));
            return;
        }
        this.Ty.setBackgroundResource(e.f.but_talk_n);
        this.Ty.setText(TbadkCoreApplication.getInst().getContext().getString(e.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
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
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pX() {
        this.Tz = new FloatRecordView(getContext());
        this.TA = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.TB = new WindowManager.LayoutParams();
        this.TB.type = com.baidu.tieba.t.b.vs(2002);
        this.TB.format = 1;
        this.TB.flags = 56;
        this.TB.gravity = 17;
        this.TB.x = 0;
        this.TB.y = 0;
        this.TB.width = getContext().getResources().getDimensionPixelSize(e.C0175e.ds360);
        this.TB.height = getContext().getResources().getDimensionPixelSize(e.C0175e.ds360);
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
                pO();
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
        if (this.Tz != null && this.TA != null && this.TB != null) {
            this.Tz.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Tz != null && this.TA != null && this.TB != null) {
            this.Tz.closeRecordCancel();
            LinearLayout pN = this.Tz.pN();
            if (pN != null && pN.getParent() != null) {
                this.TA.removeView(pN);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Tz != null && this.TA != null && this.TB != null) {
            this.Tz.closeRecordTooShort();
            LinearLayout pM = this.Tz.pM();
            if (pM != null && pM.getParent() != null) {
                this.TA.removeView(pM);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pN;
        if (this.Tz != null && this.TA != null && this.TB != null && (pN = this.Tz.pN()) != null && pN.getParent() == null) {
            this.TA.addView(pN, this.TB);
            this.Tz.showRecordCancel();
        }
    }

    public void pO() {
        LinearLayout pM;
        if (this.Tz != null && this.TA != null && this.TB != null && (pM = this.Tz.pM()) != null && pM.getParent() == null) {
            this.TA.addView(pM, this.TB);
            this.Tz.pO();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pL;
        if (this.Tz != null && this.TA != null && this.TB != null && (pL = this.Tz.pL()) != null && pL.getParent() == null) {
            this.TA.addView(pL, this.TB);
            this.Tz.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Tz != null && this.TA != null && this.TB != null) {
            this.Tz.stopRecordVoice();
            LinearLayout pL = this.Tz.pL();
            if (pL != null && pL.getParent() != null) {
                this.TA.removeView(pL);
            }
        }
    }
}
