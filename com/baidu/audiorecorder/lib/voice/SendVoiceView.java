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
/* loaded from: classes18.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools aaA;
    private int aaB;
    private TextView aaY;
    private FloatRecordView aaZ;
    private WindowManager aba;
    private WindowManager.LayoutParams abb;

    public SendVoiceView(Context context) {
        super(context);
        this.aaY = null;
        this.aaB = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.aaY = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            su();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.aaY.setBackgroundResource(R.drawable.but_talk_s);
            this.aaY.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.aaY.setBackgroundResource(R.drawable.but_talk_n);
        this.aaY.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.aaB;
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
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void su() {
        this.aaZ = new FloatRecordView(getContext());
        this.aba = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.abb = new WindowManager.LayoutParams();
        this.abb.type = com.baidu.tieba.v.c.IG(2002);
        this.abb.format = 1;
        this.abb.flags = 56;
        this.abb.gravity = 17;
        this.abb.x = 0;
        this.abb.y = 0;
        this.abb.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.abb.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                sl();
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
        if (this.aaZ != null && this.aba != null && this.abb != null) {
            this.aaZ.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.aaZ != null && this.aba != null && this.abb != null) {
            this.aaZ.closeRecordCancel();
            LinearLayout sk = this.aaZ.sk();
            if (sk != null && sk.getParent() != null) {
                this.aba.removeView(sk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.aaZ != null && this.aba != null && this.abb != null) {
            this.aaZ.closeRecordTooShort();
            LinearLayout sj = this.aaZ.sj();
            if (sj != null && sj.getParent() != null) {
                this.aba.removeView(sj);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sk;
        if (this.aaZ != null && this.aba != null && this.abb != null && (sk = this.aaZ.sk()) != null && sk.getParent() == null) {
            this.aba.addView(sk, this.abb);
            this.aaZ.showRecordCancel();
        }
    }

    public void sl() {
        LinearLayout sj;
        if (this.aaZ != null && this.aba != null && this.abb != null && (sj = this.aaZ.sj()) != null && sj.getParent() == null) {
            this.aba.addView(sj, this.abb);
            this.aaZ.sl();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout si;
        if (this.aaZ != null && this.aba != null && this.abb != null && (si = this.aaZ.si()) != null && si.getParent() == null) {
            this.aba.addView(si, this.abb);
            this.aaZ.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.aaZ != null && this.aba != null && this.abb != null) {
            this.aaZ.stopRecordVoice();
            LinearLayout si = this.aaZ.si();
            if (si != null && si.getParent() != null) {
                this.aba.removeView(si);
            }
        }
    }
}
