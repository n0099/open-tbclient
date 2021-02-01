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
    private EditorTools acR;
    private int acS;
    private TextView adt;
    private FloatRecordView adu;
    private WindowManager adv;
    private WindowManager.LayoutParams adw;

    public SendVoiceView(Context context) {
        super(context);
        this.adt = null;
        this.acS = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.adt = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sa();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.adt.setBackgroundResource(R.drawable.but_talk_s);
            this.adt.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.adt.setBackgroundResource(R.drawable.but_talk_n);
        this.adt.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.acS;
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
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sa() {
        this.adu = new FloatRecordView(getContext());
        this.adv = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.adw = new WindowManager.LayoutParams();
        this.adw.type = com.baidu.tieba.v.c.Kr(2002);
        this.adw.format = 1;
        this.adw.flags = 56;
        this.adw.gravity = 17;
        this.adw.x = 0;
        this.adw.y = 0;
        this.adw.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.adw.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.adu != null && this.adv != null && this.adw != null) {
            this.adu.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordCancel() {
        if (this.adu != null && this.adv != null && this.adw != null) {
            this.adu.closeRecordCancel();
            LinearLayout rQ = this.adu.rQ();
            if (rQ != null && rQ.getParent() != null) {
                this.adv.removeView(rQ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void closeRecordTooShort() {
        if (this.adu != null && this.adv != null && this.adw != null) {
            this.adu.closeRecordTooShort();
            LinearLayout rP = this.adu.rP();
            if (rP != null && rP.getParent() != null) {
                this.adv.removeView(rP);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void showRecordCancel() {
        LinearLayout rQ;
        if (this.adu != null && this.adv != null && this.adw != null && (rQ = this.adu.rQ()) != null && rQ.getParent() == null) {
            this.adv.addView(rQ, this.adw);
            this.adu.showRecordCancel();
        }
    }

    public void rR() {
        LinearLayout rP;
        if (this.adu != null && this.adv != null && this.adw != null && (rP = this.adu.rP()) != null && rP.getParent() == null) {
            this.adv.addView(rP, this.adw);
            this.adu.rR();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void startRecordVoice() {
        LinearLayout rO;
        if (this.adu != null && this.adv != null && this.adw != null && (rO = this.adu.rO()) != null && rO.getParent() == null) {
            this.adv.addView(rO, this.adw);
            this.adu.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.b
    public void stopRecordVoice() {
        if (this.adu != null && this.adv != null && this.adw != null) {
            this.adu.stopRecordVoice();
            LinearLayout rO = this.adu.rO();
            if (rO != null && rO.getParent() != null) {
                this.adv.removeView(rO);
            }
        }
    }
}
