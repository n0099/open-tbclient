package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes18.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private EditorTools aaA;
    private int aaB;
    private com.baidu.tbadk.core.dialog.a aaD;
    private int aas;
    private long aat;
    private int abA;
    private int abB;
    private int abC;
    private int abD;
    private int abE;
    private int abF;
    private int abG;
    private final BitmapDrawable abH;
    private final Paint abI;
    private final Rect abJ;
    private final RectF abK;
    private TextView abL;
    private TextView abM;
    private TextView abN;
    private TextView abO;
    private VoiceButton abP;
    private ImageView abQ;
    private TextView abR;
    private float abS;
    private float abT;
    private f abU;
    private long abV;
    private long abW;
    private final int[] abX;
    private final a abY;
    private SweepGradient abZ;
    private final int[] abd;
    private int abe;
    private final int abf;
    private final int abg;
    private final int abh;
    private final int abi;
    private final int abj;
    private int abk;
    private int abl;
    private int abm;
    private int abn;
    private int abo;
    private int abp;
    private int abq;
    private int abr;
    private int abt;
    private int abu;
    private Paint abv;
    private Paint abw;
    private Paint abx;
    private Paint aby;
    private int abz;
    private int aca;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.abl;
        voiceRecordButton.abl = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.abT >= 360.0f) {
                    VoiceRecordButton.this.abT = 360.0f;
                    VoiceRecordButton.this.abl = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.abV = uptimeMillis;
                    VoiceRecordButton.this.abW = uptimeMillis + 200;
                    VoiceRecordButton.this.abT += (((float) (uptimeMillis - VoiceRecordButton.this.abV)) / 1000.0f) * VoiceRecordButton.this.abS;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.abW);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abk = VoiceRecordButton.this.abl % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton L(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aat = 0L;
        this.abd = new int[4];
        this.abk = 0;
        this.abl = 0;
        this.abm = 0;
        this.abn = 0;
        this.abo = 0;
        this.abp = 0;
        this.abq = 0;
        this.abr = 0;
        this.abt = 0;
        this.abu = 0;
        this.abz = -1724676609;
        this.abA = 1546880511;
        this.abB = 674465279;
        this.abC = 255034879;
        this.abD = -1725669966;
        this.abE = 1545887154;
        this.abF = 673471922;
        this.abG = 254041522;
        this.abI = new Paint(1);
        this.abJ = new Rect();
        this.abK = new RectF();
        this.aaB = 0;
        this.abX = new int[2];
        this.abY = new a();
        this.aas = 0;
        this.aca = 0;
        this.abd[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.abd[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.abd[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.abd[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.abo = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.abp = this.abo + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abq = this.abp + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.abr = this.abq + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.abt = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.abu = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.abt = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.abu = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abe = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.abf = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abg = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abh = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abi = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abj = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.abI.setStyle(Paint.Style.STROKE);
        this.abI.setStrokeWidth(this.abi);
        this.abH = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sy();
        this.abX[0] = ap.getColor(R.color.common_color_10151);
        this.abX[1] = ap.getColor(R.color.common_color_10152);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.abP.getMeasuredWidth();
        int measuredHeight = this.abP.getMeasuredHeight();
        int measuredWidth2 = this.abM.getMeasuredWidth();
        this.abM.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.abM.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.abM.getBottom();
        this.abP.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.abm = (measuredWidth / 2) + i6;
        this.abn = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.abO.getMeasuredWidth();
        int measuredHeight2 = this.abO.getMeasuredHeight();
        int top = this.abP.getTop();
        this.abO.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.abL.getMeasuredWidth();
        int measuredHeight3 = this.abL.getMeasuredHeight();
        int right = this.abP.getRight() - this.abe;
        int bottom2 = this.abP.getBottom() - this.abf;
        this.abL.layout(this.abt + i6, this.abu + bottom, measuredWidth4 + i6 + this.abt, measuredHeight3 + this.abu + bottom);
        int measuredWidth5 = this.abQ.getMeasuredWidth();
        this.abQ.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.abQ.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.abR.getMeasuredWidth();
        this.abR.layout((i5 - measuredWidth6) >> 1, (this.abL.getTop() - this.abR.getMeasuredHeight()) - this.abg, (measuredWidth6 + i5) >> 1, (this.abL.getTop() + i2) - this.abg);
        this.abP.getLeft();
        this.abP.getRight();
        int measuredWidth7 = this.abN.getMeasuredWidth();
        int measuredHeight4 = this.abN.getMeasuredHeight();
        int bottom3 = this.abP.getBottom();
        this.abN.layout((i5 - measuredWidth7) >> 1, this.abd[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.abd[3]);
        this.abJ.set((i5 - this.abH.getIntrinsicWidth()) >> 1, this.abQ.getTop() - this.abh, (i5 + this.abH.getIntrinsicHeight()) >> 1, (this.abQ.getTop() + this.abH.getIntrinsicHeight()) - this.abh);
        this.abH.setBounds(this.abJ);
        this.abK.set(this.abQ.getLeft() + (this.abi >> 1) + this.abj, this.abQ.getTop() + (this.abi >> 1) + this.abj, (this.abQ.getRight() - (this.abi >> 1)) - this.abj, (this.abQ.getBottom() - (this.abi >> 1)) - this.abj);
        if (this.abZ == null) {
            this.abZ = new SweepGradient(this.abK.centerX(), this.abK.centerY(), this.abX, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.abZ.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.abK.centerX(), this.abK.centerY());
            this.abZ.setLocalMatrix(matrix);
            this.abI.setShader(this.abZ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sm() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.aaD == null) {
            this.aaD = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.aaD.zA(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sw();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cU(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.I(getContext()));
        }
        try {
            this.aaD.bhg();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cU(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.abM = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.abM, R.color.cp_cont_a, 1);
        this.abN = (TextView) findViewById(R.id.tip_operator);
        this.abO = (TextView) findViewById(R.id.tip_time_out);
        this.abP = (VoiceButton) findViewById(R.id.voice_bnt);
        this.abL = (TextView) findViewById(R.id.restart);
        this.abQ = (ImageView) findViewById(R.id.play_img);
        this.abR = (TextView) findViewById(R.id.play_time);
        this.abR.setClickable(false);
        this.abL.setOnClickListener(this);
        this.abQ.setOnClickListener(this);
        this.abP.setRecorderView(this);
        sw();
    }

    private void sv() {
        this.abP.setVisibility(4);
        this.abR.setVisibility(0);
        this.abL.setVisibility(0);
        ap.setViewTextColor(this.abR, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.abL, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.abL, R.drawable.but_posts_record_again_selector);
        this.abQ.setVisibility(0);
        if (this.mModel != null) {
            this.abR.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.abQ.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.abQ, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.abN, R.color.cp_cont_c, 1);
        this.abN.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw() {
        ap.setImageResource(this.abP, R.drawable.but_posts_record_zero_selector);
        this.abP.setVisibility(0);
        this.abk = 0;
        this.abQ.setVisibility(4);
        this.abR.setVisibility(4);
        this.abL.setVisibility(4);
        this.abO.setVisibility(4);
        ap.setViewTextColor(this.abN, R.color.cp_cont_c, 1);
        this.abN.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sw();
        this.mModel = null;
        this.abk = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.abM.setText("");
        this.abM.setVisibility(4);
        this.abk = 0;
        sv();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sw();
            this.abN.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.abQ != null && this.abR != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.abR, R.color.cp_cont_f, 1);
                    this.abR.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.abQ, R.drawable.but_posts_record_play_selector);
                    this.abQ.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.abN.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.abR, R.color.cp_cont_f, 1);
                    ap.setImageResource(this.abQ, R.drawable.but_posts_record_stop_selector);
                    this.abQ.setContentDescription(getContext().getString(R.string.pause_load));
                    this.abN.setText(getContext().getString(R.string.voice_stop_tip));
                    sx();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.abO, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.abM, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.abN, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.abO.setVisibility(0);
                this.abO.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abO != null) {
                            VoiceRecordButton.this.abO.setVisibility(4);
                            VoiceRecordButton.this.abO.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.abM.setVisibility(0);
                this.abM.setText(str);
                this.abN.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abM != null) {
                            VoiceRecordButton.this.abM.setVisibility(4);
                            VoiceRecordButton.this.abM.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.abM.setVisibility(0);
                this.abM.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abM != null) {
                            VoiceRecordButton.this.abM.setVisibility(4);
                            VoiceRecordButton.this.abM.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sw();
                this.abM.setVisibility(0);
                this.abM.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abM != null) {
                            VoiceRecordButton.this.abM.setVisibility(4);
                            VoiceRecordButton.this.abM.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.abM.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        c(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        ap.setViewTextColor(this.abM, R.color.cp_cont_a, 1);
        this.abM.setVisibility(0);
        this.abM.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aas = Math.max(i, this.aas);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aat > 200) {
            this.aas = 0;
            this.aat = uptimeMillis;
        }
        if (this.aas < 10) {
            this.abk = 1;
            invalidate();
        } else if (this.aas < 20) {
            this.abk = 2;
            invalidate();
        } else if (this.aas < 30) {
            this.abk = 3;
            invalidate();
        } else if (this.aas < 40) {
            this.abk = 4;
            invalidate();
        } else {
            this.abk = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bb(int i) {
        if (this.mModel != null && this.abR != null) {
            int i2 = i / 1000;
            if (this.aca != i2) {
                this.abR.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aca = i2;
        }
    }

    private void sx() {
        if (this.mModel != null) {
            this.abk = 0;
            this.abS = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.abV = SystemClock.uptimeMillis();
            this.abW = this.abV + 200;
            this.abY.sendEmptyMessageAtTime(1, this.abW);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abk = 0;
        this.abl = 0;
        this.abS = 0.0f;
        this.abT = 0.0f;
        this.abY.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            int id = view.getId();
            if (id == R.id.restart) {
                voiceManager.stopPlay();
                sm();
            } else if (id == R.id.play_img && this.mModel != null) {
                if (this.mModel.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.mModel.voice_status.intValue() == 1) {
                    voiceManager.setAllowChangeVoiceMode(false);
                    voiceManager.startPlay(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().stopPlay();
            } else {
                return;
            }
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() != null) {
            getVoiceManager().stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    public void setCallback(f fVar) {
        this.abU = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sb() {
    }

    public void sy() {
        this.abv = new Paint();
        this.abv.setAntiAlias(true);
        this.abv.setStyle(Paint.Style.STROKE);
        this.abv.setStrokeWidth(2.0f);
        this.abw = new Paint();
        this.abw.setAntiAlias(true);
        this.abw.setStyle(Paint.Style.STROKE);
        this.abw.setStrokeWidth(2.0f);
        this.abx = new Paint();
        this.abx.setAntiAlias(true);
        this.abx.setStyle(Paint.Style.STROKE);
        this.abx.setStrokeWidth(2.0f);
        this.aby = new Paint();
        this.aby.setAntiAlias(true);
        this.aby.setStyle(Paint.Style.STROKE);
        this.aby.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.abv.setColor(this.abD);
            this.abw.setColor(this.abE);
            this.abx.setColor(this.abF);
            this.aby.setColor(this.abG);
        } else {
            this.abv.setColor(this.abz);
            this.abw.setColor(this.abA);
            this.abx.setColor(this.abB);
            this.aby.setColor(this.abC);
        }
        if (this.abk == 2) {
            canvas.drawCircle(this.abm, this.abn, this.abo, this.abv);
        } else if (this.abk == 3) {
            canvas.drawCircle(this.abm, this.abn, this.abo, this.abv);
            canvas.drawCircle(this.abm, this.abn, this.abp, this.abw);
        } else if (this.abk == 4) {
            canvas.drawCircle(this.abm, this.abn, this.abo, this.abv);
            canvas.drawCircle(this.abm, this.abn, this.abp, this.abw);
            canvas.drawCircle(this.abm, this.abn, this.abq, this.abx);
        } else if (this.abk == 5) {
            canvas.drawCircle(this.abm, this.abn, this.abo, this.abv);
            canvas.drawCircle(this.abm, this.abn, this.abp, this.abw);
            canvas.drawCircle(this.abm, this.abn, this.abq, this.abx);
            canvas.drawCircle(this.abm, this.abn, this.abr, this.aby);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 9) {
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            if (aVar.code == 52) {
                if (aVar.data instanceof VoiceData.VoiceModel) {
                    sv();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
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
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
