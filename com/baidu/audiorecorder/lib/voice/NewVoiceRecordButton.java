package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class NewVoiceRecordButton extends LinearLayout implements com.baidu.adp.lib.voice.f, l {
    private FrameLayout TO;
    private ImageView TP;
    private RecordingAnimView TQ;
    private TextView TR;
    private TextView TS;
    private EditorTools TT;
    private int TU;
    private boolean TV;
    private com.baidu.tbadk.core.dialog.a TW;
    private VoiceData.VoiceModel mModel;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.TU = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.layou_new_record_button, this);
        this.TO = (FrameLayout) findViewById(R.id.layout_record_button);
        this.TP = (ImageView) findViewById(R.id.iv_record_init);
        this.TQ = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.TQ.setCertainColumnCount(8);
        this.TQ.setColumnColor(R.color.cp_cont_g);
        this.TQ.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.TR = (TextView) findViewById(R.id.tv_duration);
        this.TS = (TextView) findViewById(R.id.tv_tip);
        this.TO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (NewVoiceRecordButton.this.mModel == null) {
                            NewVoiceRecordButton.this.startRecord();
                            return true;
                        }
                        return true;
                    case 1:
                        if (NewVoiceRecordButton.this.mModel == null) {
                            NewVoiceRecordButton.this.stopRecord();
                            return true;
                        }
                        NewVoiceRecordButton.this.qk();
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
    public void qk() {
        if (this.TW == null) {
            this.TW = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.TW.mQ(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    NewVoiceRecordButton.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        this.TW.agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.ake();
            this.mPermissionJudgePolicy.e((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.e((Activity) getContext(), "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgePolicy.ad((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.aZ(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.qo()) {
            this.TV = recorderManager.a(this, -1);
            this.TR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.TP.setVisibility(0);
        this.TQ.qs();
        this.TQ.setVisibility(4);
        this.TS.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.TR.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.TV && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.TV = false;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    reset();
                    return;
                case 52:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.mModel = (VoiceData.VoiceModel) aVar.data;
                        this.TS.setText(getResources().getText(R.string.voice_restart));
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
        this.TS.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.TR.setText("");
        this.TR.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.TP.setVisibility(4);
            this.TQ.setVisibility(0);
            this.TQ.start();
            this.TS.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.TR.setVisibility(0);
        this.TR.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.4
            @Override // java.lang.Runnable
            public void run() {
                if (NewVoiceRecordButton.this.TR != null && !NewVoiceRecordButton.this.TV) {
                    NewVoiceRecordButton.this.TR.setVisibility(4);
                    NewVoiceRecordButton.this.TR.setText("");
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
            this.TS.setText(getResources().getText(R.string.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.TR.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.j(this.TS, R.color.cp_cont_f);
        am.j(this.TR, R.color.common_color_10140);
        am.k(this.TP, R.drawable.ic_post_record);
        this.TQ.onChangeSkinType(i);
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
        if ((i.ab(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
