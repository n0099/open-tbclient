package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes7.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.b {
    private TextView aeM;
    private FloatRecordView aeN;
    private WindowManager aeO;
    private WindowManager.LayoutParams aeP;
    private EditorTools ael;
    private int aem;

    public SendVoiceView(Context context) {
        super(context);
        this.aeM = null;
        this.aem = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.aeM = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sa();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.aeM.setBackgroundResource(R.drawable.but_talk_s);
            this.aeM.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.aeM.setBackgroundResource(R.drawable.but_talk_n);
        this.aeM.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sa() {
        this.aeN = new FloatRecordView(getContext());
        this.aeO = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.aeP = new WindowManager.LayoutParams();
        this.aeP.type = com.baidu.tieba.v.c.Kw(2002);
        this.aeP.format = 1;
        this.aeP.flags = 56;
        this.aeP.gravity = 17;
        this.aeP.x = 0;
        this.aeP.y = 0;
        this.aeP.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.aeP.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                rR();
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
        if (this.aeN != null && this.aeO != null && this.aeP != null) {
            this.aeN.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        if (this.aeN != null && this.aeO != null && this.aeP != null) {
            this.aeN.closeRecordCancel();
            LinearLayout rQ = this.aeN.rQ();
            if (rQ != null && rQ.getParent() != null) {
                this.aeO.removeView(rQ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        if (this.aeN != null && this.aeO != null && this.aeP != null) {
            this.aeN.closeRecordTooShort();
            LinearLayout rP = this.aeN.rP();
            if (rP != null && rP.getParent() != null) {
                this.aeO.removeView(rP);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        LinearLayout rQ;
        if (this.aeN != null && this.aeO != null && this.aeP != null && (rQ = this.aeN.rQ()) != null && rQ.getParent() == null) {
            this.aeO.addView(rQ, this.aeP);
            this.aeN.showRecordCancel();
        }
    }

    public void rR() {
        LinearLayout rP;
        if (this.aeN != null && this.aeO != null && this.aeP != null && (rP = this.aeN.rP()) != null && rP.getParent() == null) {
            this.aeO.addView(rP, this.aeP);
            this.aeN.rR();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        LinearLayout rO;
        if (this.aeN != null && this.aeO != null && this.aeP != null && (rO = this.aeN.rO()) != null && rO.getParent() == null) {
            this.aeO.addView(rO, this.aeP);
            this.aeN.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        if (this.aeN != null && this.aeO != null && this.aeP != null) {
            this.aeN.stopRecordVoice();
            LinearLayout rO = this.aeN.rO();
            if (rO != null && rO.getParent() != null) {
                this.aeO.removeView(rO);
            }
        }
    }
}
