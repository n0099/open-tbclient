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
    private WindowManager ZA;
    private WindowManager.LayoutParams ZB;
    private EditorTools Za;
    private int Zb;
    private TextView Zy;
    private FloatRecordView Zz;

    public SendVoiceView(Context context) {
        super(context);
        this.Zy = null;
        this.Zb = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.Zy = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qv();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Zy.setBackgroundResource(R.drawable.but_talk_s);
            this.Zy.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.Zy.setBackgroundResource(R.drawable.but_talk_n);
        this.Zy.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.Zb;
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
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void qv() {
        this.Zz = new FloatRecordView(getContext());
        this.ZA = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ZB = new WindowManager.LayoutParams();
        this.ZB.type = com.baidu.tieba.v.c.DZ(2002);
        this.ZB.format = 1;
        this.ZB.flags = 56;
        this.ZB.gravity = 17;
        this.ZB.x = 0;
        this.ZB.y = 0;
        this.ZB.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.ZB.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.Zz != null && this.ZA != null && this.ZB != null) {
            this.Zz.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Zz != null && this.ZA != null && this.ZB != null) {
            this.Zz.closeRecordCancel();
            LinearLayout ql = this.Zz.ql();
            if (ql != null && ql.getParent() != null) {
                this.ZA.removeView(ql);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Zz != null && this.ZA != null && this.ZB != null) {
            this.Zz.closeRecordTooShort();
            LinearLayout qk = this.Zz.qk();
            if (qk != null && qk.getParent() != null) {
                this.ZA.removeView(qk);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout ql;
        if (this.Zz != null && this.ZA != null && this.ZB != null && (ql = this.Zz.ql()) != null && ql.getParent() == null) {
            this.ZA.addView(ql, this.ZB);
            this.Zz.showRecordCancel();
        }
    }

    public void qm() {
        LinearLayout qk;
        if (this.Zz != null && this.ZA != null && this.ZB != null && (qk = this.Zz.qk()) != null && qk.getParent() == null) {
            this.ZA.addView(qk, this.ZB);
            this.Zz.qm();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qj;
        if (this.Zz != null && this.ZA != null && this.ZB != null && (qj = this.Zz.qj()) != null && qj.getParent() == null) {
            this.ZA.addView(qj, this.ZB);
            this.Zz.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Zz != null && this.ZA != null && this.ZB != null) {
            this.Zz.stopRecordVoice();
            LinearLayout qj = this.Zz.qj();
            if (qj != null && qj.getParent() != null) {
                this.ZA.removeView(qj);
            }
        }
    }
}
