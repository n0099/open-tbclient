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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes6.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools TB;
    private int TC;
    private TextView Ue;
    private FloatRecordView Uf;
    private WindowManager Ug;
    private WindowManager.LayoutParams Uh;

    public SendVoiceView(Context context) {
        super(context);
        this.Ue = null;
        this.TC = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Ue = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pW();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Ue.setBackgroundResource(R.drawable.but_talk_s);
            this.Ue.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Ue.setBackgroundResource(R.drawable.but_talk_n);
        this.Ue.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
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
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pW() {
        this.Uf = new FloatRecordView(getContext());
        this.Ug = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Uh = new WindowManager.LayoutParams();
        this.Uh.type = com.baidu.tieba.t.c.Bo(2002);
        this.Uh.format = 1;
        this.Uh.flags = 56;
        this.Uh.gravity = 17;
        this.Uh.x = 0;
        this.Uh.y = 0;
        this.Uh.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Uh.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                pM();
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
        if (this.Uf != null && this.Ug != null && this.Uh != null) {
            this.Uf.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Uf != null && this.Ug != null && this.Uh != null) {
            this.Uf.closeRecordCancel();
            LinearLayout pL = this.Uf.pL();
            if (pL != null && pL.getParent() != null) {
                this.Ug.removeView(pL);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Uf != null && this.Ug != null && this.Uh != null) {
            this.Uf.closeRecordTooShort();
            LinearLayout pK = this.Uf.pK();
            if (pK != null && pK.getParent() != null) {
                this.Ug.removeView(pK);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pL;
        if (this.Uf != null && this.Ug != null && this.Uh != null && (pL = this.Uf.pL()) != null && pL.getParent() == null) {
            this.Ug.addView(pL, this.Uh);
            this.Uf.showRecordCancel();
        }
    }

    public void pM() {
        LinearLayout pK;
        if (this.Uf != null && this.Ug != null && this.Uh != null && (pK = this.Uf.pK()) != null && pK.getParent() == null) {
            this.Ug.addView(pK, this.Uh);
            this.Uf.pM();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pJ;
        if (this.Uf != null && this.Ug != null && this.Uh != null && (pJ = this.Uf.pJ()) != null && pJ.getParent() == null) {
            this.Ug.addView(pJ, this.Uh);
            this.Uf.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Uf != null && this.Ug != null && this.Uh != null) {
            this.Uf.stopRecordVoice();
            LinearLayout pJ = this.Uf.pJ();
            if (pJ != null && pJ.getParent() != null) {
                this.Ug.removeView(pJ);
            }
        }
    }
}
