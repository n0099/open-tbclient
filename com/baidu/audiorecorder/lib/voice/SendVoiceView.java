package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements z, ISendVoiceView, ak {
    private TextView KQ;
    private int KR;
    private com.baidu.tbadk.editortools.k KS;
    private FloatRecordView KT;
    private WindowManager KU;
    private WindowManager.LayoutParams KV;

    public SendVoiceView(Context context) {
        super(context);
        this.KQ = null;
        this.KR = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(n.g.send_voice_view, this);
            this.KQ = (TextView) findViewById(n.f.tex_send_voice);
            oE();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.KQ.setBackgroundResource(n.e.but_talk_s);
            this.KQ.setText(TbadkCoreApplication.m411getInst().getContext().getString(n.i.msglist_no_push));
            return;
        }
        this.KQ.setBackgroundResource(n.e.but_talk_n);
        this.KQ.setText(TbadkCoreApplication.m411getInst().getContext().getString(n.i.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }

    private void oE() {
        this.KT = new FloatRecordView(getContext());
        this.KU = (WindowManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("window");
        this.KV = new WindowManager.LayoutParams();
        this.KV.type = 2002;
        this.KV.format = 1;
        this.KV.flags = 56;
        this.KV.gravity = 17;
        this.KV.x = 0;
        this.KV.y = 0;
        this.KV.width = getContext().getResources().getDimensionPixelSize(n.d.im_msg_voice_layer_width);
        this.KV.height = getContext().getResources().getDimensionPixelSize(n.d.im_msg_voice_layer_height);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                showRecordTooShort();
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        if (this.KT != null && this.KU != null && this.KV != null) {
            this.KT.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.KT != null && this.KU != null && this.KV != null) {
            this.KT.closeRecordCancel();
            LinearLayout oy = this.KT.oy();
            if (oy != null && oy.getParent() != null) {
                this.KU.removeView(oy);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.KT != null && this.KU != null && this.KV != null) {
            this.KT.closeRecordTooShort();
            LinearLayout ox = this.KT.ox();
            if (ox != null && ox.getParent() != null) {
                this.KU.removeView(ox);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout oy;
        if (this.KT != null && this.KU != null && this.KV != null && (oy = this.KT.oy()) != null && oy.getParent() == null) {
            this.KU.addView(oy, this.KV);
            this.KT.showRecordCancel();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordTooShort() {
        LinearLayout ox;
        if (this.KT != null && this.KU != null && this.KV != null && (ox = this.KT.ox()) != null && ox.getParent() == null) {
            this.KU.addView(ox, this.KV);
            this.KT.showRecordTooShort();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout ow;
        if (this.KT != null && this.KU != null && this.KV != null && (ow = this.KT.ow()) != null && ow.getParent() == null) {
            this.KU.addView(ow, this.KV);
            this.KT.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.KT != null && this.KU != null && this.KV != null) {
            this.KT.stopRecordVoice();
            LinearLayout ow = this.KT.ow();
            if (ow != null && ow.getParent() != null) {
                this.KU.removeView(ow);
            }
        }
    }
}
