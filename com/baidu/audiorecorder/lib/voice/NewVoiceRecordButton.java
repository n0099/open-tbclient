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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes24.dex */
public class NewVoiceRecordButton extends LinearLayout implements com.baidu.adp.lib.voice.f, n {
    private FrameLayout acg;
    private ImageView ach;
    private RecordingAnimView aci;
    private TextView acj;
    private TextView acm;
    private EditorTools acn;
    private int aco;
    private boolean acp;
    private com.baidu.tbadk.core.dialog.a acq;
    private VoiceData.VoiceModel mModel;
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.aco = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.layou_new_record_button, this);
        this.acg = (FrameLayout) findViewById(R.id.layout_record_button);
        this.ach = (ImageView) findViewById(R.id.iv_record_init);
        this.aci = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.aci.setCertainColumnCount(8);
        this.aci.setColumnColor(R.color.CAM_X0111);
        this.aci.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.acj = (TextView) findViewById(R.id.tv_duration);
        this.acm = (TextView) findViewById(R.id.tv_tip);
        this.acg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.1
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
                        NewVoiceRecordButton.this.st();
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
    public void st() {
        if (this.acq == null) {
            this.acq = new com.baidu.tbadk.core.dialog.a(i.J(getContext()).getPageActivity());
            this.acq.Bq(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.3
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
            }).b(i.J(getContext()));
        }
        this.acq.brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.mPermissionJudgePolicy.startRequestPermission((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CI(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.sx()) {
            this.acp = recorderManager.a(this, -1);
            this.acj.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.ach.setVisibility(0);
        this.aci.sB();
        this.aci.setVisibility(4);
        this.acm.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.acj.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.acp && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.acp = false;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 1:
                    TiebaStatic.log(new ar("c12612").al("obj_locate", 6));
                    return;
                case 9:
                    reset();
                    return;
                case 52:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.mModel = (VoiceData.VoiceModel) aVar.data;
                        this.acm.setText(getResources().getText(R.string.voice_restart));
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
        this.acm.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.acj.setText("");
        this.acj.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.ach.setVisibility(4);
            this.aci.setVisibility(0);
            this.aci.start();
            this.acm.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.acj.setVisibility(0);
        this.acj.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.NewVoiceRecordButton.4
            @Override // java.lang.Runnable
            public void run() {
                if (NewVoiceRecordButton.this.acj != null && !NewVoiceRecordButton.this.acp) {
                    NewVoiceRecordButton.this.acj.setVisibility(4);
                    NewVoiceRecordButton.this.acj.setText("");
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
            this.acm.setText(getResources().getText(R.string.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.acj.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.acm, R.color.CAM_X0106, 1, i);
        ap.setViewTextColor(this.acj, R.color.CAM_X0302, 1, i);
        ap.setBackgroundResource(this.ach, R.drawable.ic_post_record, i);
        this.aci.onChangeSkinType(i);
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
        if ((i.J(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
