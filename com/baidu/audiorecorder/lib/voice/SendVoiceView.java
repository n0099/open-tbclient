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
    private TextView QI;
    private FloatRecordView QJ;
    private WindowManager QK;
    private WindowManager.LayoutParams QL;
    private EditorTools Qh;
    private int Qi;

    public SendVoiceView(Context context) {
        super(context);
        this.QI = null;
        this.Qi = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.i.send_voice_view, this);
            this.QI = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            oK();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.QI.setBackgroundResource(d.f.but_talk_s);
            this.QI.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_no_push));
            return;
        }
        this.QI.setBackgroundResource(d.f.but_talk_n);
        this.QI.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_push_talk));
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
        return this.Qi;
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
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void oK() {
        this.QJ = new FloatRecordView(getContext());
        this.QK = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.QL = new WindowManager.LayoutParams();
        this.QL.type = com.baidu.tieba.u.a.uo(2002);
        this.QL.format = 1;
        this.QL.flags = 56;
        this.QL.gravity = 17;
        this.QL.x = 0;
        this.QL.y = 0;
        this.QL.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.QL.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
        if (this.QJ != null && this.QK != null && this.QL != null) {
            this.QJ.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.QJ != null && this.QK != null && this.QL != null) {
            this.QJ.closeRecordCancel();
            LinearLayout oA = this.QJ.oA();
            if (oA != null && oA.getParent() != null) {
                this.QK.removeView(oA);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.QJ != null && this.QK != null && this.QL != null) {
            this.QJ.closeRecordTooShort();
            LinearLayout oz = this.QJ.oz();
            if (oz != null && oz.getParent() != null) {
                this.QK.removeView(oz);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout oA;
        if (this.QJ != null && this.QK != null && this.QL != null && (oA = this.QJ.oA()) != null && oA.getParent() == null) {
            this.QK.addView(oA, this.QL);
            this.QJ.showRecordCancel();
        }
    }

    public void oB() {
        LinearLayout oz;
        if (this.QJ != null && this.QK != null && this.QL != null && (oz = this.QJ.oz()) != null && oz.getParent() == null) {
            this.QK.addView(oz, this.QL);
            this.QJ.oB();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout oy;
        if (this.QJ != null && this.QK != null && this.QL != null && (oy = this.QJ.oy()) != null && oy.getParent() == null) {
            this.QK.addView(oy, this.QL);
            this.QJ.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.QJ != null && this.QK != null && this.QL != null) {
            this.QJ.stopRecordVoice();
            LinearLayout oy = this.QJ.oy();
            if (oy != null && oy.getParent() != null) {
                this.QK.removeView(oy);
            }
        }
    }
}
