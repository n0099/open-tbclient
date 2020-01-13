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
/* loaded from: classes9.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView FU;
    private FloatRecordView FV;
    private WindowManager FW;
    private WindowManager.LayoutParams FX;
    private EditorTools Fv;
    private int Fw;

    public SendVoiceView(Context context) {
        super(context);
        this.FU = null;
        this.Fw = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.FU = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lE();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.FU.setBackgroundResource(R.drawable.but_talk_s);
            this.FU.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.FU.setBackgroundResource(R.drawable.but_talk_n);
        this.FU.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.Fw;
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
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void lE() {
        this.FV = new FloatRecordView(getContext());
        this.FW = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.FX = new WindowManager.LayoutParams();
        this.FX.type = com.baidu.tieba.u.c.Dh(2002);
        this.FX.format = 1;
        this.FX.flags = 56;
        this.FX.gravity = 17;
        this.FX.x = 0;
        this.FX.y = 0;
        this.FX.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.FX.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                lv();
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
        if (this.FV != null && this.FW != null && this.FX != null) {
            this.FV.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.FV != null && this.FW != null && this.FX != null) {
            this.FV.closeRecordCancel();
            LinearLayout lu = this.FV.lu();
            if (lu != null && lu.getParent() != null) {
                this.FW.removeView(lu);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.FV != null && this.FW != null && this.FX != null) {
            this.FV.closeRecordTooShort();
            LinearLayout lt = this.FV.lt();
            if (lt != null && lt.getParent() != null) {
                this.FW.removeView(lt);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lu;
        if (this.FV != null && this.FW != null && this.FX != null && (lu = this.FV.lu()) != null && lu.getParent() == null) {
            this.FW.addView(lu, this.FX);
            this.FV.showRecordCancel();
        }
    }

    public void lv() {
        LinearLayout lt;
        if (this.FV != null && this.FW != null && this.FX != null && (lt = this.FV.lt()) != null && lt.getParent() == null) {
            this.FW.addView(lt, this.FX);
            this.FV.lv();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout ls;
        if (this.FV != null && this.FW != null && this.FX != null && (ls = this.FV.ls()) != null && ls.getParent() == null) {
            this.FW.addView(ls, this.FX);
            this.FV.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.FV != null && this.FW != null && this.FX != null) {
            this.FV.stopRecordVoice();
            LinearLayout ls = this.FV.ls();
            if (ls != null && ls.getParent() != null) {
                this.FW.removeView(ls);
            }
        }
    }
}
