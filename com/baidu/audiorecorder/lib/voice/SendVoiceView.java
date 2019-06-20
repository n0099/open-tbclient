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
    private EditorTools TA;
    private int TB;
    private TextView Ud;
    private FloatRecordView Ue;
    private WindowManager Uf;
    private WindowManager.LayoutParams Ug;

    public SendVoiceView(Context context) {
        super(context);
        this.Ud = null;
        this.TB = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Ud = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            pW();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Ud.setBackgroundResource(R.drawable.but_talk_s);
            this.Ud.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Ud.setBackgroundResource(R.drawable.but_talk_n);
        this.Ud.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.TB;
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
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void pW() {
        this.Ue = new FloatRecordView(getContext());
        this.Uf = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Ug = new WindowManager.LayoutParams();
        this.Ug.type = com.baidu.tieba.t.c.Bo(2002);
        this.Ug.format = 1;
        this.Ug.flags = 56;
        this.Ug.gravity = 17;
        this.Ug.x = 0;
        this.Ug.y = 0;
        this.Ug.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.Ug.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.Ue != null && this.Uf != null && this.Ug != null) {
            this.Ue.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Ue != null && this.Uf != null && this.Ug != null) {
            this.Ue.closeRecordCancel();
            LinearLayout pL = this.Ue.pL();
            if (pL != null && pL.getParent() != null) {
                this.Uf.removeView(pL);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Ue != null && this.Uf != null && this.Ug != null) {
            this.Ue.closeRecordTooShort();
            LinearLayout pK = this.Ue.pK();
            if (pK != null && pK.getParent() != null) {
                this.Uf.removeView(pK);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout pL;
        if (this.Ue != null && this.Uf != null && this.Ug != null && (pL = this.Ue.pL()) != null && pL.getParent() == null) {
            this.Uf.addView(pL, this.Ug);
            this.Ue.showRecordCancel();
        }
    }

    public void pM() {
        LinearLayout pK;
        if (this.Ue != null && this.Uf != null && this.Ug != null && (pK = this.Ue.pK()) != null && pK.getParent() == null) {
            this.Uf.addView(pK, this.Ug);
            this.Ue.pM();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout pJ;
        if (this.Ue != null && this.Uf != null && this.Ug != null && (pJ = this.Ue.pJ()) != null && pJ.getParent() == null) {
            this.Uf.addView(pJ, this.Ug);
            this.Ue.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Ue != null && this.Uf != null && this.Ug != null) {
            this.Ue.stopRecordVoice();
            LinearLayout pJ = this.Ue.pJ();
            if (pJ != null && pJ.getParent() != null) {
                this.Uf.removeView(pJ);
            }
        }
    }
}
