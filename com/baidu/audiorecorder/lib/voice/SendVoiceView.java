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
    private TextView aaW;
    private FloatRecordView aaX;
    private WindowManager aaY;
    private WindowManager.LayoutParams aaZ;
    private EditorTools aay;
    private int aaz;

    public SendVoiceView(Context context) {
        super(context);
        this.aaW = null;
        this.aaz = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.aaW = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            su();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.aaW.setBackgroundResource(R.drawable.but_talk_s);
            this.aaW.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.aaW.setBackgroundResource(R.drawable.but_talk_n);
        this.aaW.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.aaz;
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
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void su() {
        this.aaX = new FloatRecordView(getContext());
        this.aaY = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.aaZ = new WindowManager.LayoutParams();
        this.aaZ.type = com.baidu.tieba.v.c.IG(2002);
        this.aaZ.format = 1;
        this.aaZ.flags = 56;
        this.aaZ.gravity = 17;
        this.aaZ.x = 0;
        this.aaZ.y = 0;
        this.aaZ.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.aaZ.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.aaX != null && this.aaY != null && this.aaZ != null) {
            this.aaX.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.aaX != null && this.aaY != null && this.aaZ != null) {
            this.aaX.closeRecordCancel();
            LinearLayout sk = this.aaX.sk();
            if (sk != null && sk.getParent() != null) {
                this.aaY.removeView(sk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.aaX != null && this.aaY != null && this.aaZ != null) {
            this.aaX.closeRecordTooShort();
            LinearLayout sj = this.aaX.sj();
            if (sj != null && sj.getParent() != null) {
                this.aaY.removeView(sj);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sk;
        if (this.aaX != null && this.aaY != null && this.aaZ != null && (sk = this.aaX.sk()) != null && sk.getParent() == null) {
            this.aaY.addView(sk, this.aaZ);
            this.aaX.showRecordCancel();
        }
    }

    public void sl() {
        LinearLayout sj;
        if (this.aaX != null && this.aaY != null && this.aaZ != null && (sj = this.aaX.sj()) != null && sj.getParent() == null) {
            this.aaY.addView(sj, this.aaZ);
            this.aaX.sl();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout si;
        if (this.aaX != null && this.aaY != null && this.aaZ != null && (si = this.aaX.si()) != null && si.getParent() == null) {
            this.aaY.addView(si, this.aaZ);
            this.aaX.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.aaX != null && this.aaY != null && this.aaZ != null) {
            this.aaX.stopRecordVoice();
            LinearLayout si = this.aaX.si();
            if (si != null && si.getParent() != null) {
                this.aaY.removeView(si);
            }
        }
    }
}
