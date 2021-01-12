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
    private EditorTools acX;
    private int acY;
    private FloatRecordView adA;
    private WindowManager adB;
    private WindowManager.LayoutParams adC;
    private TextView adz;

    public SendVoiceView(Context context) {
        super(context);
        this.adz = null;
        this.acY = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.adz = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sd();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.adz.setBackgroundResource(R.drawable.but_talk_s);
            this.adz.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.adz.setBackgroundResource(R.drawable.but_talk_n);
        this.adz.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
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
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sd() {
        this.adA = new FloatRecordView(getContext());
        this.adB = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.adC = new WindowManager.LayoutParams();
        this.adC.type = com.baidu.tieba.v.c.JX(2002);
        this.adC.format = 1;
        this.adC.flags = 56;
        this.adC.gravity = 17;
        this.adC.x = 0;
        this.adC.y = 0;
        this.adC.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.adC.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                rT();
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
        if (this.adA != null && this.adB != null && this.adC != null) {
            this.adA.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        if (this.adA != null && this.adB != null && this.adC != null) {
            this.adA.closeRecordCancel();
            LinearLayout rS = this.adA.rS();
            if (rS != null && rS.getParent() != null) {
                this.adB.removeView(rS);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        if (this.adA != null && this.adB != null && this.adC != null) {
            this.adA.closeRecordTooShort();
            LinearLayout rR = this.adA.rR();
            if (rR != null && rR.getParent() != null) {
                this.adB.removeView(rR);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        LinearLayout rS;
        if (this.adA != null && this.adB != null && this.adC != null && (rS = this.adA.rS()) != null && rS.getParent() == null) {
            this.adB.addView(rS, this.adC);
            this.adA.showRecordCancel();
        }
    }

    public void rT() {
        LinearLayout rR;
        if (this.adA != null && this.adB != null && this.adC != null && (rR = this.adA.rR()) != null && rR.getParent() == null) {
            this.adB.addView(rR, this.adC);
            this.adA.rT();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        LinearLayout rQ;
        if (this.adA != null && this.adB != null && this.adC != null && (rQ = this.adA.rQ()) != null && rQ.getParent() == null) {
            this.adB.addView(rQ, this.adC);
            this.adA.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        if (this.adA != null && this.adB != null && this.adC != null) {
            this.adA.stopRecordVoice();
            LinearLayout rQ = this.adA.rQ();
            if (rQ != null && rQ.getParent() != null) {
                this.adB.removeView(rQ);
            }
        }
    }
}
