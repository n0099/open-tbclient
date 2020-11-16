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
/* loaded from: classes23.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView abO;
    private FloatRecordView abP;
    private WindowManager abQ;
    private WindowManager.LayoutParams abR;
    private EditorTools abp;
    private int abq;

    public SendVoiceView(Context context) {
        super(context);
        this.abO = null;
        this.abq = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.abO = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sz();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.abO.setBackgroundResource(R.drawable.but_talk_s);
            this.abO.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.abO.setBackgroundResource(R.drawable.but_talk_n);
        this.abO.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.abq;
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
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sz() {
        this.abP = new FloatRecordView(getContext());
        this.abQ = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.abR = new WindowManager.LayoutParams();
        this.abR.type = com.baidu.tieba.w.c.KY(2002);
        this.abR.format = 1;
        this.abR.flags = 56;
        this.abR.gravity = 17;
        this.abR.x = 0;
        this.abR.y = 0;
        this.abR.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.abR.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                sq();
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
        if (this.abP != null && this.abQ != null && this.abR != null) {
            this.abP.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.abP != null && this.abQ != null && this.abR != null) {
            this.abP.closeRecordCancel();
            LinearLayout sp = this.abP.sp();
            if (sp != null && sp.getParent() != null) {
                this.abQ.removeView(sp);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.abP != null && this.abQ != null && this.abR != null) {
            this.abP.closeRecordTooShort();
            LinearLayout so = this.abP.so();
            if (so != null && so.getParent() != null) {
                this.abQ.removeView(so);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sp;
        if (this.abP != null && this.abQ != null && this.abR != null && (sp = this.abP.sp()) != null && sp.getParent() == null) {
            this.abQ.addView(sp, this.abR);
            this.abP.showRecordCancel();
        }
    }

    public void sq() {
        LinearLayout so;
        if (this.abP != null && this.abQ != null && this.abR != null && (so = this.abP.so()) != null && so.getParent() == null) {
            this.abQ.addView(so, this.abR);
            this.abP.sq();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout sn;
        if (this.abP != null && this.abQ != null && this.abR != null && (sn = this.abP.sn()) != null && sn.getParent() == null) {
            this.abQ.addView(sn, this.abR);
            this.abP.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.abP != null && this.abQ != null && this.abR != null) {
            this.abP.stopRecordVoice();
            LinearLayout sn = this.abP.sn();
            if (sn != null && sn.getParent() != null) {
                this.abQ.removeView(sn);
            }
        }
    }
}
