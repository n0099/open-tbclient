package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends LinearLayout implements com.baidu.adp.lib.voice.f, s {
    private FrameLayout IN;
    private ImageView IO;
    private RecordingAnimView IP;
    private TextView IQ;
    private TextView IR;
    private i IS;
    private int IT;
    private boolean IU;
    private com.baidu.tbadk.core.dialog.a IW;
    private VoiceData.VoiceModel mModel;

    public e(Context context) {
        super(context);
        this.IT = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layou_new_record_button, this);
        this.IN = (FrameLayout) findViewById(d.g.layout_record_button);
        this.IO = (ImageView) findViewById(d.g.iv_record_init);
        this.IP = (RecordingAnimView) findViewById(d.g.record_anim_view);
        this.IP.setCertainColumnCount(8);
        this.IP.setColumnColor(d.C0095d.cp_cont_g);
        this.IP.setColumnWidth(getResources().getDimensionPixelSize(d.e.ds4));
        this.IQ = (TextView) findViewById(d.g.tv_duration);
        this.IR = (TextView) findViewById(d.g.tv_tip);
        this.IN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.e.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (e.this.mModel == null) {
                            e.this.startRecord();
                            return true;
                        }
                        return true;
                    case 1:
                        if (e.this.mModel == null) {
                            e.this.stopRecord();
                            return true;
                        }
                        e.this.lD();
                        return true;
                    default:
                        return true;
                }
            }
        });
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD() {
        if (this.IW == null) {
            this.IW = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.IW.cS(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.e.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    e.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.Y(getContext()));
        }
        this.IW.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.lH()) {
            this.IU = recorderManager.a(this, -1);
            this.IQ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.IO.setVisibility(0);
        this.IP.lK();
        this.IP.setVisibility(4);
        this.IR.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.IQ.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.IU && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.IU = false;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    reset();
                    return;
                case d.l.View_translationY /* 52 */:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.mModel = (VoiceData.VoiceModel) aVar.data;
                        this.IR.setText(getResources().getText(d.j.voice_restart));
                        return;
                    }
                    reset();
                    return;
                default:
                    return;
            }
        }
    }

    private void reset() {
        this.mModel = null;
        this.IR.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.IQ.setText("");
        this.IQ.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.IO.setVisibility(4);
            this.IP.setVisibility(0);
            this.IP.start();
            this.IR.setText(getResources().getText(d.j.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.IQ.setVisibility(0);
        this.IQ.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.4
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.IQ != null && !e.this.IU) {
                    e.this.IQ.setVisibility(4);
                    e.this.IQ.setText("");
                }
            }
        }, 2000L);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            this.mModel = new VoiceData.VoiceModel();
            this.mModel.duration = i;
            this.mModel.isLocal = true;
            this.mModel.voiceId = str;
            this.mModel.voice_status = 1;
            this.IR.setText(getResources().getText(d.j.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.IQ.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.i(this.IR, d.C0095d.cp_cont_f);
        aj.i(this.IQ, d.C0095d.common_color_10140);
        aj.j(this.IO, d.f.ic_post_record);
        this.IP.onChangeSkinType(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.i.Y(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
