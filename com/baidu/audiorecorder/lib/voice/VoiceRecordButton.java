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
/* loaded from: classes24.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private final int[] acQ;
    private int acR;
    private final int acS;
    private final int acT;
    private final int acU;
    private final int acV;
    private final int acW;
    private int acX;
    private int acY;
    private int acZ;
    private int acd;
    private long ace;
    private EditorTools acn;
    private int aco;
    private com.baidu.tbadk.core.dialog.a acq;
    private TextView adA;
    private TextView adB;
    private VoiceButton adC;
    private ImageView adD;
    private TextView adE;
    private float adF;
    private float adG;
    private f adH;
    private long adI;
    private long adJ;
    private final int[] adK;
    private final a adL;
    private SweepGradient adM;
    private int adN;
    private int ada;
    private int adb;
    private int adc;
    private int ade;
    private int adf;
    private int adg;
    private int adh;
    private Paint adi;
    private Paint adj;
    private Paint adk;
    private Paint adl;
    private int adm;
    private int adn;
    private int ado;
    private int adp;
    private int adq;
    private int adr;
    private int ads;
    private int adt;
    private final BitmapDrawable adu;
    private final Paint adv;
    private final Rect adw;
    private final RectF adx;
    private TextView ady;
    private TextView adz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.acY;
        voiceRecordButton.acY = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.adG >= 360.0f) {
                    VoiceRecordButton.this.adG = 360.0f;
                    VoiceRecordButton.this.acY = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.adI = uptimeMillis;
                    VoiceRecordButton.this.adJ = uptimeMillis + 200;
                    VoiceRecordButton.this.adG += (((float) (uptimeMillis - VoiceRecordButton.this.adI)) / 1000.0f) * VoiceRecordButton.this.adF;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.adJ);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.acX = VoiceRecordButton.this.acY % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton M(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ace = 0L;
        this.acQ = new int[4];
        this.acX = 0;
        this.acY = 0;
        this.acZ = 0;
        this.ada = 0;
        this.adb = 0;
        this.adc = 0;
        this.ade = 0;
        this.adf = 0;
        this.adg = 0;
        this.adh = 0;
        this.adm = -1724676609;
        this.adn = 1546880511;
        this.ado = 674465279;
        this.adp = 255034879;
        this.adq = -1725669966;
        this.adr = 1545887154;
        this.ads = 673471922;
        this.adt = 254041522;
        this.adv = new Paint(1);
        this.adw = new Rect();
        this.adx = new RectF();
        this.aco = 0;
        this.adK = new int[2];
        this.adL = new a();
        this.acd = 0;
        this.adN = 0;
        this.acQ[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.acQ[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.acQ[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.acQ[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.adb = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.adc = this.adb + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ade = this.adc + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.adf = this.ade + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.adg = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.adh = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.adg = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.adh = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.acR = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.acS = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.acT = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.acU = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.acV = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.acW = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.adv.setStyle(Paint.Style.STROKE);
        this.adv.setStrokeWidth(this.acV);
        this.adu = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        N(context);
        sG();
        this.adK[0] = ap.getColor(R.color.common_color_10151);
        this.adK[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.adC.getMeasuredWidth();
        int measuredHeight = this.adC.getMeasuredHeight();
        int measuredWidth2 = this.adz.getMeasuredWidth();
        this.adz.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.adz.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.adz.getBottom();
        this.adC.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.acZ = (measuredWidth / 2) + i6;
        this.ada = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.adB.getMeasuredWidth();
        int measuredHeight2 = this.adB.getMeasuredHeight();
        int top = this.adC.getTop();
        this.adB.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ady.getMeasuredWidth();
        int measuredHeight3 = this.ady.getMeasuredHeight();
        int right = this.adC.getRight() - this.acR;
        int bottom2 = this.adC.getBottom() - this.acS;
        this.ady.layout(this.adg + i6, this.adh + bottom, measuredWidth4 + i6 + this.adg, measuredHeight3 + this.adh + bottom);
        int measuredWidth5 = this.adD.getMeasuredWidth();
        this.adD.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.adD.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.adE.getMeasuredWidth();
        this.adE.layout((i5 - measuredWidth6) >> 1, (this.ady.getTop() - this.adE.getMeasuredHeight()) - this.acT, (measuredWidth6 + i5) >> 1, (this.ady.getTop() + i2) - this.acT);
        this.adC.getLeft();
        this.adC.getRight();
        int measuredWidth7 = this.adA.getMeasuredWidth();
        int measuredHeight4 = this.adA.getMeasuredHeight();
        int bottom3 = this.adC.getBottom();
        this.adA.layout((i5 - measuredWidth7) >> 1, this.acQ[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.acQ[3]);
        this.adw.set((i5 - this.adu.getIntrinsicWidth()) >> 1, this.adD.getTop() - this.acU, (i5 + this.adu.getIntrinsicHeight()) >> 1, (this.adD.getTop() + this.adu.getIntrinsicHeight()) - this.acU);
        this.adu.setBounds(this.adw);
        this.adx.set(this.adD.getLeft() + (this.acV >> 1) + this.acW, this.adD.getTop() + (this.acV >> 1) + this.acW, (this.adD.getRight() - (this.acV >> 1)) - this.acW, (this.adD.getBottom() - (this.acV >> 1)) - this.acW);
        if (this.adM == null) {
            this.adM = new SweepGradient(this.adx.centerX(), this.adx.centerY(), this.adK, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.adM.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.adx.centerX(), this.adx.centerY());
            this.adM.setLocalMatrix(matrix);
            this.adv.setShader(this.adM);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void st() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.acq == null) {
            this.acq = new com.baidu.tbadk.core.dialog.a(i.J(getContext()).getPageActivity());
            this.acq.Bq(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sE();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.db(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.J(getContext()));
        }
        try {
            this.acq.brv();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.db(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void N(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.adz = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.adz, R.color.CAM_X0101, 1);
        this.adA = (TextView) findViewById(R.id.tip_operator);
        this.adB = (TextView) findViewById(R.id.tip_time_out);
        this.adC = (VoiceButton) findViewById(R.id.voice_bnt);
        this.ady = (TextView) findViewById(R.id.restart);
        this.adD = (ImageView) findViewById(R.id.play_img);
        this.adE = (TextView) findViewById(R.id.play_time);
        this.adE.setClickable(false);
        this.ady.setOnClickListener(this);
        this.adD.setOnClickListener(this);
        this.adC.setRecorderView(this);
        sE();
    }

    private void sD() {
        this.adC.setVisibility(4);
        this.adE.setVisibility(0);
        this.ady.setVisibility(0);
        ap.setViewTextColor(this.adE, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.ady, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.ady, R.drawable.but_posts_record_again_selector);
        this.adD.setVisibility(0);
        if (this.mModel != null) {
            this.adE.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.adD.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.adD, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.adA, R.color.CAM_X0108, 1);
        this.adA.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sE() {
        ap.setImageResource(this.adC, R.drawable.but_posts_record_zero_selector);
        this.adC.setVisibility(0);
        this.acX = 0;
        this.adD.setVisibility(4);
        this.adE.setVisibility(4);
        this.ady.setVisibility(4);
        this.adB.setVisibility(4);
        ap.setViewTextColor(this.adA, R.color.CAM_X0301, 1);
        this.adA.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sE();
        this.mModel = null;
        this.acX = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.adz.setText("");
        this.adz.setVisibility(4);
        this.acX = 0;
        sD();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sE();
            this.adA.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.adD != null && this.adE != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.adE, R.color.CAM_X0106, 1);
                    this.adE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.adD, R.drawable.but_posts_record_play_selector);
                    this.adD.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.adA.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.adE, R.color.CAM_X0106, 1);
                    ap.setImageResource(this.adD, R.drawable.but_posts_record_stop_selector);
                    this.adD.setContentDescription(getContext().getString(R.string.pause_load));
                    this.adA.setText(getContext().getString(R.string.voice_stop_tip));
                    sF();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.adB, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.adz, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.adA, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.adB.setVisibility(0);
                this.adB.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.adB != null) {
                            VoiceRecordButton.this.adB.setVisibility(4);
                            VoiceRecordButton.this.adB.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.adz.setVisibility(0);
                this.adz.setText(str);
                this.adA.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.adz != null) {
                            VoiceRecordButton.this.adz.setVisibility(4);
                            VoiceRecordButton.this.adz.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.adz.setVisibility(0);
                this.adz.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.adz != null) {
                            VoiceRecordButton.this.adz.setVisibility(4);
                            VoiceRecordButton.this.adz.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sE();
                this.adz.setVisibility(0);
                this.adz.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.adz != null) {
                            VoiceRecordButton.this.adz.setVisibility(4);
                            VoiceRecordButton.this.adz.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.adz.setVisibility(4);
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
        ap.setViewTextColor(this.adz, R.color.CAM_X0101, 1);
        this.adz.setVisibility(0);
        this.adz.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acd = Math.max(i, this.acd);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ace > 200) {
            this.acd = 0;
            this.ace = uptimeMillis;
        }
        if (this.acd < 10) {
            this.acX = 1;
            invalidate();
        } else if (this.acd < 20) {
            this.acX = 2;
            invalidate();
        } else if (this.acd < 30) {
            this.acX = 3;
            invalidate();
        } else if (this.acd < 40) {
            this.acX = 4;
            invalidate();
        } else {
            this.acX = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (this.mModel != null && this.adE != null) {
            int i2 = i / 1000;
            if (this.adN != i2) {
                this.adE.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.adN = i2;
        }
    }

    private void sF() {
        if (this.mModel != null) {
            this.acX = 0;
            this.adF = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.adI = SystemClock.uptimeMillis();
            this.adJ = this.adI + 200;
            this.adL.sendEmptyMessageAtTime(1, this.adJ);
            invalidate();
        }
    }

    private void stopProgress() {
        this.acX = 0;
        this.acY = 0;
        this.adF = 0.0f;
        this.adG = 0.0f;
        this.adL.removeMessages(1);
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
                st();
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
        this.adH = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void si() {
    }

    public void sG() {
        this.adi = new Paint();
        this.adi.setAntiAlias(true);
        this.adi.setStyle(Paint.Style.STROKE);
        this.adi.setStrokeWidth(2.0f);
        this.adj = new Paint();
        this.adj.setAntiAlias(true);
        this.adj.setStyle(Paint.Style.STROKE);
        this.adj.setStrokeWidth(2.0f);
        this.adk = new Paint();
        this.adk.setAntiAlias(true);
        this.adk.setStyle(Paint.Style.STROKE);
        this.adk.setStrokeWidth(2.0f);
        this.adl = new Paint();
        this.adl.setAntiAlias(true);
        this.adl.setStyle(Paint.Style.STROKE);
        this.adl.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.adi.setColor(this.adq);
            this.adj.setColor(this.adr);
            this.adk.setColor(this.ads);
            this.adl.setColor(this.adt);
        } else {
            this.adi.setColor(this.adm);
            this.adj.setColor(this.adn);
            this.adk.setColor(this.ado);
            this.adl.setColor(this.adp);
        }
        if (this.acX == 2) {
            canvas.drawCircle(this.acZ, this.ada, this.adb, this.adi);
        } else if (this.acX == 3) {
            canvas.drawCircle(this.acZ, this.ada, this.adb, this.adi);
            canvas.drawCircle(this.acZ, this.ada, this.adc, this.adj);
        } else if (this.acX == 4) {
            canvas.drawCircle(this.acZ, this.ada, this.adb, this.adi);
            canvas.drawCircle(this.acZ, this.ada, this.adc, this.adj);
            canvas.drawCircle(this.acZ, this.ada, this.ade, this.adk);
        } else if (this.acX == 5) {
            canvas.drawCircle(this.acZ, this.ada, this.adb, this.adi);
            canvas.drawCircle(this.acZ, this.ada, this.adc, this.adj);
            canvas.drawCircle(this.acZ, this.ada, this.ade, this.adk);
            canvas.drawCircle(this.acZ, this.ada, this.adf, this.adl);
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
                    sD();
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
    public void su() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
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
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
