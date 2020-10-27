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
    private TextView abJ;
    private FloatRecordView abK;
    private WindowManager abL;
    private WindowManager.LayoutParams abM;
    private EditorTools abk;
    private int abl;

    public SendVoiceView(Context context) {
        super(context);
        this.abJ = null;
        this.abl = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.abJ = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            sz();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.abJ.setBackgroundResource(R.drawable.but_talk_s);
            this.abJ.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.abJ.setBackgroundResource(R.drawable.but_talk_n);
        this.abJ.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.abl;
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
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }

    private void sz() {
        this.abK = new FloatRecordView(getContext());
        this.abL = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.abM = new WindowManager.LayoutParams();
        this.abM.type = com.baidu.tieba.v.c.Ki(2002);
        this.abM.format = 1;
        this.abM.flags = 56;
        this.abM.gravity = 17;
        this.abM.x = 0;
        this.abM.y = 0;
        this.abM.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.abM.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
        if (this.abK != null && this.abL != null && this.abM != null) {
            this.abK.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.abK != null && this.abL != null && this.abM != null) {
            this.abK.closeRecordCancel();
            LinearLayout sp = this.abK.sp();
            if (sp != null && sp.getParent() != null) {
                this.abL.removeView(sp);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.abK != null && this.abL != null && this.abM != null) {
            this.abK.closeRecordTooShort();
            LinearLayout so = this.abK.so();
            if (so != null && so.getParent() != null) {
                this.abL.removeView(so);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout sp;
        if (this.abK != null && this.abL != null && this.abM != null && (sp = this.abK.sp()) != null && sp.getParent() == null) {
            this.abL.addView(sp, this.abM);
            this.abK.showRecordCancel();
        }
    }

    public void sq() {
        LinearLayout so;
        if (this.abK != null && this.abL != null && this.abM != null && (so = this.abK.so()) != null && so.getParent() == null) {
            this.abL.addView(so, this.abM);
            this.abK.sq();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout sn;
        if (this.abK != null && this.abL != null && this.abM != null && (sn = this.abK.sn()) != null && sn.getParent() == null) {
            this.abL.addView(sn, this.abM);
            this.abK.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.abK != null && this.abL != null && this.abM != null) {
            this.abK.stopRecordVoice();
            LinearLayout sn = this.abK.sn();
            if (sn != null && sn.getParent() != null) {
                this.abL.removeView(sn);
            }
        }
    }
}
