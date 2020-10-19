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
/* loaded from: classes24.dex */
public class SendVoiceView extends LinearLayout implements n, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView abI;
    private FloatRecordView abJ;
    private WindowManager abK;
    private WindowManager.LayoutParams abL;
    private EditorTools abj;
    private int abk;

    public SendVoiceView(Context context) {
        super(context);
        this.abI = null;
        this.abk = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.abI = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sz();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.abI.setBackgroundResource(R.drawable.but_talk_s);
            this.abI.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.abI.setBackgroundResource(R.drawable.but_talk_n);
        this.abI.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.abk;
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
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sz() {
        this.abJ = new FloatRecordView(getContext());
        this.abK = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.abL = new WindowManager.LayoutParams();
        this.abL.type = com.baidu.tieba.v.c.JQ(2002);
        this.abL.format = 1;
        this.abL.flags = 56;
        this.abL.gravity = 17;
        this.abL.x = 0;
        this.abL.y = 0;
        this.abL.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.abL.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.abJ != null && this.abK != null && this.abL != null) {
            this.abJ.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.abJ != null && this.abK != null && this.abL != null) {
            this.abJ.closeRecordCancel();
            LinearLayout sp = this.abJ.sp();
            if (sp != null && sp.getParent() != null) {
                this.abK.removeView(sp);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.abJ != null && this.abK != null && this.abL != null) {
            this.abJ.closeRecordTooShort();
            LinearLayout so = this.abJ.so();
            if (so != null && so.getParent() != null) {
                this.abK.removeView(so);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sp;
        if (this.abJ != null && this.abK != null && this.abL != null && (sp = this.abJ.sp()) != null && sp.getParent() == null) {
            this.abK.addView(sp, this.abL);
            this.abJ.showRecordCancel();
        }
    }

    public void sq() {
        LinearLayout so;
        if (this.abJ != null && this.abK != null && this.abL != null && (so = this.abJ.so()) != null && so.getParent() == null) {
            this.abK.addView(so, this.abL);
            this.abJ.sq();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout sn;
        if (this.abJ != null && this.abK != null && this.abL != null && (sn = this.abJ.sn()) != null && sn.getParent() == null) {
            this.abK.addView(sn, this.abL);
            this.abJ.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.abJ != null && this.abK != null && this.abL != null) {
            this.abJ.stopRecordVoice();
            LinearLayout sn = this.abJ.sn();
            if (sn != null && sn.getParent() != null) {
                this.abK.removeView(sn);
            }
        }
    }
}
