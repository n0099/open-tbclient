package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes11.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView ZB;
    private FloatRecordView ZC;
    private WindowManager ZD;
    private WindowManager.LayoutParams ZE;
    private EditorTools Zd;
    private int Ze;

    public SendVoiceView(Context context) {
        super(context);
        this.ZB = null;
        this.Ze = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.ZB = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qv();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ZB.setBackgroundResource(R.drawable.but_talk_s);
            this.ZB.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.ZB.setBackgroundResource(R.drawable.but_talk_n);
        this.ZB.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void qv() {
        this.ZC = new FloatRecordView(getContext());
        this.ZD = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ZE = new WindowManager.LayoutParams();
        this.ZE.type = com.baidu.tieba.v.c.DZ(2002);
        this.ZE.format = 1;
        this.ZE.flags = 56;
        this.ZE.gravity = 17;
        this.ZE.x = 0;
        this.ZE.y = 0;
        this.ZE.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.ZE.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qm();
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
        if (this.ZC != null && this.ZD != null && this.ZE != null) {
            this.ZC.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ZC != null && this.ZD != null && this.ZE != null) {
            this.ZC.closeRecordCancel();
            LinearLayout ql = this.ZC.ql();
            if (ql != null && ql.getParent() != null) {
                this.ZD.removeView(ql);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ZC != null && this.ZD != null && this.ZE != null) {
            this.ZC.closeRecordTooShort();
            LinearLayout qk = this.ZC.qk();
            if (qk != null && qk.getParent() != null) {
                this.ZD.removeView(qk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout ql;
        if (this.ZC != null && this.ZD != null && this.ZE != null && (ql = this.ZC.ql()) != null && ql.getParent() == null) {
            this.ZD.addView(ql, this.ZE);
            this.ZC.showRecordCancel();
        }
    }

    public void qm() {
        LinearLayout qk;
        if (this.ZC != null && this.ZD != null && this.ZE != null && (qk = this.ZC.qk()) != null && qk.getParent() == null) {
            this.ZD.addView(qk, this.ZE);
            this.ZC.qm();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qj;
        if (this.ZC != null && this.ZD != null && this.ZE != null && (qj = this.ZC.qj()) != null && qj.getParent() == null) {
            this.ZD.addView(qj, this.ZE);
            this.ZC.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ZC != null && this.ZD != null && this.ZE != null) {
            this.ZC.stopRecordVoice();
            LinearLayout qj = this.ZC.qj();
            if (qj != null && qj.getParent() != null) {
                this.ZD.removeView(qj);
            }
        }
    }
}
