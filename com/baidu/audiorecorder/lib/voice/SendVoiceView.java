package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView QK;
    private FloatRecordView QL;
    private WindowManager QM;
    private WindowManager.LayoutParams QN;
    private EditorTools Qj;
    private int Qk;

    public SendVoiceView(Context context) {
        super(context);
        this.QK = null;
        this.Qk = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.i.send_voice_view, this);
            this.QK = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            oK();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.QK.setBackgroundResource(d.f.but_talk_s);
            this.QK.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_no_push));
            return;
        }
        this.QK.setBackgroundResource(d.f.but_talk_n);
        this.QK.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void oK() {
        this.QL = new FloatRecordView(getContext());
        this.QM = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.QN = new WindowManager.LayoutParams();
        this.QN.type = com.baidu.tieba.u.a.uw(2002);
        this.QN.format = 1;
        this.QN.flags = 56;
        this.QN.gravity = 17;
        this.QN.x = 0;
        this.QN.y = 0;
        this.QN.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.QN.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                oB();
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
        if (this.QL != null && this.QM != null && this.QN != null) {
            this.QL.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.QL != null && this.QM != null && this.QN != null) {
            this.QL.closeRecordCancel();
            LinearLayout oA = this.QL.oA();
            if (oA != null && oA.getParent() != null) {
                this.QM.removeView(oA);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.QL != null && this.QM != null && this.QN != null) {
            this.QL.closeRecordTooShort();
            LinearLayout oz = this.QL.oz();
            if (oz != null && oz.getParent() != null) {
                this.QM.removeView(oz);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout oA;
        if (this.QL != null && this.QM != null && this.QN != null && (oA = this.QL.oA()) != null && oA.getParent() == null) {
            this.QM.addView(oA, this.QN);
            this.QL.showRecordCancel();
        }
    }

    public void oB() {
        LinearLayout oz;
        if (this.QL != null && this.QM != null && this.QN != null && (oz = this.QL.oz()) != null && oz.getParent() == null) {
            this.QM.addView(oz, this.QN);
            this.QL.oB();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout oy;
        if (this.QL != null && this.QM != null && this.QN != null && (oy = this.QL.oy()) != null && oy.getParent() == null) {
            this.QM.addView(oy, this.QN);
            this.QL.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.QL != null && this.QM != null && this.QN != null) {
            this.QL.stopRecordVoice();
            LinearLayout oy = this.QL.oy();
            if (oy != null && oy.getParent() != null) {
                this.QM.removeView(oy);
            }
        }
    }
}
