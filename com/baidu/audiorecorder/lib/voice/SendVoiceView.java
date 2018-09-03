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
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView QH;
    private FloatRecordView QI;
    private WindowManager QJ;
    private WindowManager.LayoutParams QK;
    private EditorTools Qg;
    private int Qh;

    public SendVoiceView(Context context) {
        super(context);
        this.QH = null;
        this.Qh = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(f.h.send_voice_view, this);
            this.QH = (TextView) findViewById(f.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            oK();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.QH.setBackgroundResource(f.C0146f.but_talk_s);
            this.QH.setText(TbadkCoreApplication.getInst().getContext().getString(f.j.msglist_no_push));
            return;
        }
        this.QH.setBackgroundResource(f.C0146f.but_talk_n);
        this.QH.setText(TbadkCoreApplication.getInst().getContext().getString(f.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
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
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void oK() {
        this.QI = new FloatRecordView(getContext());
        this.QJ = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.QK = new WindowManager.LayoutParams();
        this.QK.type = com.baidu.tieba.t.b.uv(2002);
        this.QK.format = 1;
        this.QK.flags = 56;
        this.QK.gravity = 17;
        this.QK.x = 0;
        this.QK.y = 0;
        this.QK.width = getContext().getResources().getDimensionPixelSize(f.e.ds360);
        this.QK.height = getContext().getResources().getDimensionPixelSize(f.e.ds360);
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
                oA();
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
        if (this.QI != null && this.QJ != null && this.QK != null) {
            this.QI.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.QI != null && this.QJ != null && this.QK != null) {
            this.QI.closeRecordCancel();
            LinearLayout oz = this.QI.oz();
            if (oz != null && oz.getParent() != null) {
                this.QJ.removeView(oz);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.QI != null && this.QJ != null && this.QK != null) {
            this.QI.closeRecordTooShort();
            LinearLayout oy = this.QI.oy();
            if (oy != null && oy.getParent() != null) {
                this.QJ.removeView(oy);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout oz;
        if (this.QI != null && this.QJ != null && this.QK != null && (oz = this.QI.oz()) != null && oz.getParent() == null) {
            this.QJ.addView(oz, this.QK);
            this.QI.showRecordCancel();
        }
    }

    public void oA() {
        LinearLayout oy;
        if (this.QI != null && this.QJ != null && this.QK != null && (oy = this.QI.oy()) != null && oy.getParent() == null) {
            this.QJ.addView(oy, this.QK);
            this.QI.oA();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout ox;
        if (this.QI != null && this.QJ != null && this.QK != null && (ox = this.QI.ox()) != null && ox.getParent() == null) {
            this.QJ.addView(ox, this.QK);
            this.QI.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.QI != null && this.QJ != null && this.QK != null) {
            this.QI.stopRecordVoice();
            LinearLayout ox = this.QI.ox();
            if (ox != null && ox.getParent() != null) {
                this.QJ.removeView(ox);
            }
        }
    }
}
