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
/* loaded from: classes8.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.b {
    private EditorTools acZ;
    private TextView adB;
    private FloatRecordView adC;
    private WindowManager adD;
    private WindowManager.LayoutParams adE;
    private int ada;

    public SendVoiceView(Context context) {
        super(context);
        this.adB = null;
        this.ada = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.adB = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sd();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.adB.setBackgroundResource(R.drawable.but_talk_s);
            this.adB.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.adB.setBackgroundResource(R.drawable.but_talk_n);
        this.adB.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.ada;
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
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sd() {
        this.adC = new FloatRecordView(getContext());
        this.adD = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.adE = new WindowManager.LayoutParams();
        this.adE.type = com.baidu.tieba.v.c.LE(2002);
        this.adE.format = 1;
        this.adE.flags = 56;
        this.adE.gravity = 17;
        this.adE.x = 0;
        this.adE.y = 0;
        this.adE.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.adE.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.adC != null && this.adD != null && this.adE != null) {
            this.adC.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        if (this.adC != null && this.adD != null && this.adE != null) {
            this.adC.closeRecordCancel();
            LinearLayout rS = this.adC.rS();
            if (rS != null && rS.getParent() != null) {
                this.adD.removeView(rS);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        if (this.adC != null && this.adD != null && this.adE != null) {
            this.adC.closeRecordTooShort();
            LinearLayout rR = this.adC.rR();
            if (rR != null && rR.getParent() != null) {
                this.adD.removeView(rR);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        LinearLayout rS;
        if (this.adC != null && this.adD != null && this.adE != null && (rS = this.adC.rS()) != null && rS.getParent() == null) {
            this.adD.addView(rS, this.adE);
            this.adC.showRecordCancel();
        }
    }

    public void rT() {
        LinearLayout rR;
        if (this.adC != null && this.adD != null && this.adE != null && (rR = this.adC.rR()) != null && rR.getParent() == null) {
            this.adD.addView(rR, this.adE);
            this.adC.rT();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        LinearLayout rQ;
        if (this.adC != null && this.adD != null && this.adE != null && (rQ = this.adC.rQ()) != null && rQ.getParent() == null) {
            this.adD.addView(rQ, this.adE);
            this.adC.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        if (this.adC != null && this.adD != null && this.adE != null) {
            this.adC.stopRecordVoice();
            LinearLayout rQ = this.adC.rQ();
            if (rQ != null && rQ.getParent() != null) {
                this.adD.removeView(rQ);
            }
        }
    }
}
