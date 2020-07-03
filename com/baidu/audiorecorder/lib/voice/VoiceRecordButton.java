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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes11.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private int ZP;
    private long ZQ;
    private EditorTools ZX;
    private int ZY;
    private final int[] aaA;
    private int aaB;
    private final int aaC;
    private final int aaD;
    private final int aaE;
    private final int aaF;
    private final int aaG;
    private int aaH;
    private int aaI;
    private int aaJ;
    private int aaK;
    private int aaL;
    private int aaM;
    private int aaN;
    private int aaO;
    private int aaP;
    private int aaQ;
    private Paint aaR;
    private Paint aaS;
    private Paint aaT;
    private Paint aaU;
    private int aaV;
    private int aaW;
    private int aaX;
    private int aaY;
    private int aaZ;
    private com.baidu.tbadk.core.dialog.a aaa;
    private int aba;
    private int abb;
    private int abd;
    private final BitmapDrawable abe;
    private final Paint abf;
    private final Rect abg;
    private final RectF abh;
    private TextView abi;
    private TextView abj;
    private TextView abk;
    private TextView abl;
    private VoiceButton abm;
    private ImageView abn;
    private TextView abo;
    private float abp;
    private float abq;
    private f abr;
    private long abt;
    private long abu;
    private final int[] abv;
    private final a abw;
    private SweepGradient abx;
    private int aby;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.aaI;
        voiceRecordButton.aaI = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.abq >= 360.0f) {
                    VoiceRecordButton.this.abq = 360.0f;
                    VoiceRecordButton.this.aaI = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.abt = uptimeMillis;
                    VoiceRecordButton.this.abu = uptimeMillis + 200;
                    VoiceRecordButton.this.abq += (((float) (uptimeMillis - VoiceRecordButton.this.abt)) / 1000.0f) * VoiceRecordButton.this.abp;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.abu);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.aaH = VoiceRecordButton.this.aaI % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton J(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = 0L;
        this.aaA = new int[4];
        this.aaH = 0;
        this.aaI = 0;
        this.aaJ = 0;
        this.aaK = 0;
        this.aaL = 0;
        this.aaM = 0;
        this.aaN = 0;
        this.aaO = 0;
        this.aaP = 0;
        this.aaQ = 0;
        this.aaV = -1724676609;
        this.aaW = 1546880511;
        this.aaX = 674465279;
        this.aaY = 255034879;
        this.aaZ = -1725669966;
        this.aba = 1545887154;
        this.abb = 673471922;
        this.abd = 254041522;
        this.abf = new Paint(1);
        this.abg = new Rect();
        this.abh = new RectF();
        this.ZY = 0;
        this.abv = new int[2];
        this.abw = new a();
        this.ZP = 0;
        this.aby = 0;
        this.aaA[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aaA[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.aaA[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.aaA[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.aaL = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.aaM = this.aaL + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aaN = this.aaM + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.aaO = this.aaN + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.aaP = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.aaQ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.aaP = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.aaQ = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.aaB = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.aaC = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aaD = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aaE = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aaF = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.aaG = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.abf.setStyle(Paint.Style.STROKE);
        this.abf.setStrokeWidth(this.aaF);
        this.abe = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        K(context);
        qX();
        this.abv[0] = an.getColor(R.color.common_color_10151);
        this.abv[1] = an.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.abm.getMeasuredWidth();
        int measuredHeight = this.abm.getMeasuredHeight();
        int measuredWidth2 = this.abj.getMeasuredWidth();
        this.abj.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.abj.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.abj.getBottom();
        this.abm.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.aaJ = (measuredWidth / 2) + i6;
        this.aaK = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.abl.getMeasuredWidth();
        int measuredHeight2 = this.abl.getMeasuredHeight();
        int top2 = this.abm.getTop();
        this.abl.layout((i5 - measuredWidth3) >> 1, top2 - measuredHeight2, (measuredWidth3 + i5) >> 1, top2);
        int measuredWidth4 = this.abi.getMeasuredWidth();
        int measuredHeight3 = this.abi.getMeasuredHeight();
        int right = this.abm.getRight() - this.aaB;
        int bottom2 = this.abm.getBottom() - this.aaC;
        this.abi.layout(this.aaP + i6, this.aaQ + bottom, measuredWidth4 + i6 + this.aaP, measuredHeight3 + this.aaQ + bottom);
        int measuredWidth5 = this.abn.getMeasuredWidth();
        this.abn.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.abn.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.abo.getMeasuredWidth();
        this.abo.layout((i5 - measuredWidth6) >> 1, (this.abi.getTop() - this.abo.getMeasuredHeight()) - this.aaD, (measuredWidth6 + i5) >> 1, (this.abi.getTop() + i2) - this.aaD);
        this.abm.getLeft();
        this.abm.getRight();
        int measuredWidth7 = this.abk.getMeasuredWidth();
        int measuredHeight4 = this.abk.getMeasuredHeight();
        int bottom3 = this.abm.getBottom();
        this.abk.layout((i5 - measuredWidth7) >> 1, this.aaA[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.aaA[3]);
        this.abg.set((i5 - this.abe.getIntrinsicWidth()) >> 1, this.abn.getTop() - this.aaE, (i5 + this.abe.getIntrinsicHeight()) >> 1, (this.abn.getTop() + this.abe.getIntrinsicHeight()) - this.aaE);
        this.abe.setBounds(this.abg);
        this.abh.set(this.abn.getLeft() + (this.aaF >> 1) + this.aaG, this.abn.getTop() + (this.aaF >> 1) + this.aaG, (this.abn.getRight() - (this.aaF >> 1)) - this.aaG, (this.abn.getBottom() - (this.aaF >> 1)) - this.aaG);
        if (this.abx == null) {
            this.abx = new SweepGradient(this.abh.centerX(), this.abh.centerY(), this.abv, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.abx.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.abh.centerX(), this.abh.centerY());
            this.abx.setLocalMatrix(matrix);
            this.abf.setShader(this.abx);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qK() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.aaa == null) {
            this.aaa = new com.baidu.tbadk.core.dialog.a(i.G(getContext()).getPageActivity());
            this.aaa.we(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qU();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cP(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.G(getContext()));
        }
        try {
            this.aaa.aUN();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cP(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.abj = (TextView) findViewById(R.id.tip_error);
        an.setViewTextColor(this.abj, R.color.cp_cont_a, 1);
        this.abk = (TextView) findViewById(R.id.tip_operator);
        this.abl = (TextView) findViewById(R.id.tip_time_out);
        this.abm = (VoiceButton) findViewById(R.id.voice_bnt);
        this.abi = (TextView) findViewById(R.id.restart);
        this.abn = (ImageView) findViewById(R.id.play_img);
        this.abo = (TextView) findViewById(R.id.play_time);
        this.abo.setClickable(false);
        this.abi.setOnClickListener(this);
        this.abn.setOnClickListener(this);
        this.abm.setRecorderView(this);
        qU();
    }

    private void qT() {
        this.abm.setVisibility(4);
        this.abo.setVisibility(0);
        this.abi.setVisibility(0);
        an.setViewTextColor(this.abo, R.color.cp_cont_f, 1);
        an.setViewTextColor(this.abi, R.color.cp_cont_f, 1);
        an.setBackgroundResource(this.abi, R.drawable.but_posts_record_again_selector);
        this.abn.setVisibility(0);
        if (this.mModel != null) {
            this.abo.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.abn.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            an.setImageResource(this.abn, R.drawable.but_posts_record_play_selector);
        }
        an.setViewTextColor(this.abk, R.color.cp_cont_c, 1);
        this.abk.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU() {
        an.setImageResource(this.abm, R.drawable.but_posts_record_zero_selector);
        this.abm.setVisibility(0);
        this.aaH = 0;
        this.abn.setVisibility(4);
        this.abo.setVisibility(4);
        this.abi.setVisibility(4);
        this.abl.setVisibility(4);
        an.setViewTextColor(this.abk, R.color.cp_cont_c, 1);
        this.abk.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qU();
        this.mModel = null;
        this.aaH = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.abj.setText("");
        this.abj.setVisibility(4);
        this.aaH = 0;
        qT();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qU();
            this.abk.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.abn != null && this.abo != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    an.setViewTextColor(this.abo, R.color.cp_cont_f, 1);
                    this.abo.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    an.setImageResource(this.abn, R.drawable.but_posts_record_play_selector);
                    this.abn.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.abk.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    an.setViewTextColor(this.abo, R.color.cp_cont_f, 1);
                    an.setImageResource(this.abn, R.drawable.but_posts_record_stop_selector);
                    this.abn.setContentDescription(getContext().getString(R.string.pause_load));
                    this.abk.setText(getContext().getString(R.string.voice_stop_tip));
                    qV();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        an.setViewTextColor(this.abl, R.color.cp_cont_a, 1);
        an.setViewTextColor(this.abj, R.color.cp_cont_a, 1);
        an.setViewTextColor(this.abk, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.abl.setVisibility(0);
                this.abl.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abl != null) {
                            VoiceRecordButton.this.abl.setVisibility(4);
                            VoiceRecordButton.this.abl.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.abj.setVisibility(0);
                this.abj.setText(str);
                this.abk.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abj != null) {
                            VoiceRecordButton.this.abj.setVisibility(4);
                            VoiceRecordButton.this.abj.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.abj.setVisibility(0);
                this.abj.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abj != null) {
                            VoiceRecordButton.this.abj.setVisibility(4);
                            VoiceRecordButton.this.abj.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qU();
                this.abj.setVisibility(0);
                this.abj.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abj != null) {
                            VoiceRecordButton.this.abj.setVisibility(4);
                            VoiceRecordButton.this.abj.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.abj.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        an.setViewTextColor(this.abj, R.color.cp_cont_a, 1);
        this.abj.setVisibility(0);
        this.abj.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.ZP = Math.max(i, this.ZP);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ZQ > 200) {
            this.ZP = 0;
            this.ZQ = uptimeMillis;
        }
        if (this.ZP < 10) {
            this.aaH = 1;
            invalidate();
        } else if (this.ZP < 20) {
            this.aaH = 2;
            invalidate();
        } else if (this.ZP < 30) {
            this.aaH = 3;
            invalidate();
        } else if (this.ZP < 40) {
            this.aaH = 4;
            invalidate();
        } else {
            this.aaH = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (this.mModel != null && this.abo != null) {
            int i2 = i / 1000;
            if (this.aby != i2) {
                this.abo.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aby = i2;
        }
    }

    private void qV() {
        if (this.mModel != null) {
            this.aaH = 0;
            this.abp = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.abt = SystemClock.uptimeMillis();
            this.abu = this.abt + 200;
            this.abw.sendEmptyMessageAtTime(1, this.abu);
            invalidate();
        }
    }

    private void stopProgress() {
        this.aaH = 0;
        this.aaI = 0;
        this.abp = 0.0f;
        this.abq = 0.0f;
        this.abw.removeMessages(1);
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
                qK();
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
        this.abr = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qW() {
    }

    public void qX() {
        this.aaR = new Paint();
        this.aaR.setAntiAlias(true);
        this.aaR.setStyle(Paint.Style.STROKE);
        this.aaR.setStrokeWidth(2.0f);
        this.aaS = new Paint();
        this.aaS.setAntiAlias(true);
        this.aaS.setStyle(Paint.Style.STROKE);
        this.aaS.setStrokeWidth(2.0f);
        this.aaT = new Paint();
        this.aaT.setAntiAlias(true);
        this.aaT.setStyle(Paint.Style.STROKE);
        this.aaT.setStrokeWidth(2.0f);
        this.aaU = new Paint();
        this.aaU.setAntiAlias(true);
        this.aaU.setStyle(Paint.Style.STROKE);
        this.aaU.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.aaR.setColor(this.aaZ);
            this.aaS.setColor(this.aba);
            this.aaT.setColor(this.abb);
            this.aaU.setColor(this.abd);
        } else {
            this.aaR.setColor(this.aaV);
            this.aaS.setColor(this.aaW);
            this.aaT.setColor(this.aaX);
            this.aaU.setColor(this.aaY);
        }
        if (this.aaH == 2) {
            canvas.drawCircle(this.aaJ, this.aaK, this.aaL, this.aaR);
        } else if (this.aaH == 3) {
            canvas.drawCircle(this.aaJ, this.aaK, this.aaL, this.aaR);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaM, this.aaS);
        } else if (this.aaH == 4) {
            canvas.drawCircle(this.aaJ, this.aaK, this.aaL, this.aaR);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaM, this.aaS);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaN, this.aaT);
        } else if (this.aaH == 5) {
            canvas.drawCircle(this.aaJ, this.aaK, this.aaL, this.aaR);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaM, this.aaS);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaN, this.aaT);
            canvas.drawCircle(this.aaJ, this.aaK, this.aaO, this.aaU);
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
                    qT();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
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
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
