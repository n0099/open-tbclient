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
import com.baidu.adp.base.j;
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
/* loaded from: classes7.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private final int[] aeQ;
    private int aeR;
    private final int aeS;
    private final int aeT;
    private final int aeU;
    private final int aeV;
    private final int aeW;
    private int aeX;
    private int aeY;
    private int aeZ;
    private int aed;
    private long aee;
    private EditorTools ael;
    private int aem;
    private com.baidu.tbadk.core.dialog.a aeo;
    private TextView afA;
    private VoiceButton afB;
    private ImageView afC;
    private TextView afD;
    private float afE;
    private float afF;
    private f afG;
    private long afH;
    private long afI;
    private final int[] afJ;
    private final a afK;
    private SweepGradient afL;
    private int afM;
    private int afa;
    private int afb;
    private int afc;
    private int afd;
    private int afe;
    private int aff;
    private int afg;
    private Paint afh;
    private Paint afi;
    private Paint afj;
    private Paint afk;
    private int afl;
    private int afm;
    private int afn;
    private int afo;
    private int afp;
    private int afq;
    private int afr;
    private int afs;
    private final BitmapDrawable aft;
    private final Paint afu;
    private final Rect afv;
    private final RectF afw;
    private TextView afx;
    private TextView afy;
    private TextView afz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.aeY;
        voiceRecordButton.aeY = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.afF >= 360.0f) {
                    VoiceRecordButton.this.afF = 360.0f;
                    VoiceRecordButton.this.aeY = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.afH = uptimeMillis;
                    VoiceRecordButton.this.afI = uptimeMillis + 200;
                    VoiceRecordButton.this.afF += (((float) (uptimeMillis - VoiceRecordButton.this.afH)) / 1000.0f) * VoiceRecordButton.this.afE;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.afI);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.aeX = VoiceRecordButton.this.aeY % 6;
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
        this.aee = 0L;
        this.aeQ = new int[4];
        this.aeX = 0;
        this.aeY = 0;
        this.aeZ = 0;
        this.afa = 0;
        this.afb = 0;
        this.afc = 0;
        this.afd = 0;
        this.afe = 0;
        this.aff = 0;
        this.afg = 0;
        this.afl = -1724676609;
        this.afm = 1546880511;
        this.afn = 674465279;
        this.afo = 255034879;
        this.afp = -1725669966;
        this.afq = 1545887154;
        this.afr = 673471922;
        this.afs = 254041522;
        this.afu = new Paint(1);
        this.afv = new Rect();
        this.afw = new RectF();
        this.aem = 0;
        this.afJ = new int[2];
        this.afK = new a();
        this.aed = 0;
        this.afM = 0;
        this.aeQ[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aeQ[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.aeQ[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.aeQ[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.afb = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.afc = this.afb + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.afd = this.afc + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.afe = this.afd + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.aff = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.afg = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.aff = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.afg = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.aeR = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.aeS = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aeT = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aeU = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aeV = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.aeW = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.afu.setStyle(Paint.Style.STROKE);
        this.afu.setStrokeWidth(this.aeV);
        this.aft = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        N(context);
        sf();
        this.afJ[0] = ap.getColor(R.color.common_color_10151);
        this.afJ[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.afB.getMeasuredWidth();
        int measuredHeight = this.afB.getMeasuredHeight();
        int measuredWidth2 = this.afy.getMeasuredWidth();
        this.afy.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.afy.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.afy.getBottom();
        this.afB.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.aeZ = (measuredWidth / 2) + i6;
        this.afa = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.afA.getMeasuredWidth();
        int measuredHeight2 = this.afA.getMeasuredHeight();
        int top = this.afB.getTop();
        this.afA.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.afx.getMeasuredWidth();
        int measuredHeight3 = this.afx.getMeasuredHeight();
        int right = this.afB.getRight() - this.aeR;
        int bottom2 = this.afB.getBottom() - this.aeS;
        this.afx.layout(this.aff + i6, this.afg + bottom, measuredWidth4 + i6 + this.aff, measuredHeight3 + this.afg + bottom);
        int measuredWidth5 = this.afC.getMeasuredWidth();
        this.afC.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.afC.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.afD.getMeasuredWidth();
        this.afD.layout((i5 - measuredWidth6) >> 1, (this.afx.getTop() - this.afD.getMeasuredHeight()) - this.aeT, (measuredWidth6 + i5) >> 1, (this.afx.getTop() + i2) - this.aeT);
        this.afB.getLeft();
        this.afB.getRight();
        int measuredWidth7 = this.afz.getMeasuredWidth();
        int measuredHeight4 = this.afz.getMeasuredHeight();
        int bottom3 = this.afB.getBottom();
        this.afz.layout((i5 - measuredWidth7) >> 1, this.aeQ[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.aeQ[3]);
        this.afv.set((i5 - this.aft.getIntrinsicWidth()) >> 1, this.afC.getTop() - this.aeU, (i5 + this.aft.getIntrinsicHeight()) >> 1, (this.afC.getTop() + this.aft.getIntrinsicHeight()) - this.aeU);
        this.aft.setBounds(this.afv);
        this.afw.set(this.afC.getLeft() + (this.aeV >> 1) + this.aeW, this.afC.getTop() + (this.aeV >> 1) + this.aeW, (this.afC.getRight() - (this.aeV >> 1)) - this.aeW, (this.afC.getBottom() - (this.aeV >> 1)) - this.aeW);
        if (this.afL == null) {
            this.afL = new SweepGradient(this.afw.centerX(), this.afw.centerY(), this.afJ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.afL.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.afw.centerX(), this.afw.centerY());
            this.afL.setLocalMatrix(matrix);
            this.afu.setShader(this.afL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g(canvas);
        super.dispatchDraw(canvas);
    }

    private void rS() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.aeo == null) {
            this.aeo = new com.baidu.tbadk.core.dialog.a(j.J(getContext()).getPageActivity());
            this.aeo.AB(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sc();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cY(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(j.J(getContext()));
        }
        try {
            this.aeo.bqz();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cY(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void N(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.afy = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.afy, R.color.CAM_X0101, 1);
        this.afz = (TextView) findViewById(R.id.tip_operator);
        this.afA = (TextView) findViewById(R.id.tip_time_out);
        this.afB = (VoiceButton) findViewById(R.id.voice_bnt);
        this.afx = (TextView) findViewById(R.id.restart);
        this.afC = (ImageView) findViewById(R.id.play_img);
        this.afD = (TextView) findViewById(R.id.play_time);
        this.afD.setClickable(false);
        this.afx.setOnClickListener(this);
        this.afC.setOnClickListener(this);
        this.afB.setRecorderView(this);
        sc();
    }

    private void sb() {
        this.afB.setVisibility(4);
        this.afD.setVisibility(0);
        this.afx.setVisibility(0);
        ap.setViewTextColor(this.afD, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.afx, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.afx, R.drawable.but_posts_record_again_selector);
        this.afC.setVisibility(0);
        if (this.mModel != null) {
            this.afD.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.afC.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.afC, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.afz, R.color.CAM_X0108, 1);
        this.afz.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        ap.setImageResource(this.afB, R.drawable.but_posts_record_zero_selector);
        this.afB.setVisibility(0);
        this.aeX = 0;
        this.afC.setVisibility(4);
        this.afD.setVisibility(4);
        this.afx.setVisibility(4);
        this.afA.setVisibility(4);
        ap.setViewTextColor(this.afz, R.color.CAM_X0301, 1);
        this.afz.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sc();
        this.mModel = null;
        this.aeX = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.afy.setText("");
        this.afy.setVisibility(4);
        this.aeX = 0;
        sb();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sc();
            this.afz.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.afC != null && this.afD != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.afD, R.color.CAM_X0106, 1);
                    this.afD.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.afC, R.drawable.but_posts_record_play_selector);
                    this.afC.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.afz.setText(getContext().getString(R.string.voice_play_tip));
                    se();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.afD, R.color.CAM_X0106, 1);
                    ap.setImageResource(this.afC, R.drawable.but_posts_record_stop_selector);
                    this.afC.setContentDescription(getContext().getString(R.string.pause_load));
                    this.afz.setText(getContext().getString(R.string.voice_stop_tip));
                    sd();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.afA, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.afy, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.afz, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.afA.setVisibility(0);
                this.afA.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.afA != null) {
                            VoiceRecordButton.this.afA.setVisibility(4);
                            VoiceRecordButton.this.afA.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.afy.setVisibility(0);
                this.afy.setText(str);
                this.afz.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.afy != null) {
                            VoiceRecordButton.this.afy.setVisibility(4);
                            VoiceRecordButton.this.afy.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.afy.setVisibility(0);
                this.afy.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.afy != null) {
                            VoiceRecordButton.this.afy.setVisibility(4);
                            VoiceRecordButton.this.afy.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sc();
                this.afy.setVisibility(0);
                this.afy.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.afy != null) {
                            VoiceRecordButton.this.afy.setVisibility(4);
                            VoiceRecordButton.this.afy.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.afy.setVisibility(4);
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
        ap.setViewTextColor(this.afy, R.color.CAM_X0101, 1);
        this.afy.setVisibility(0);
        this.afy.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aed = Math.max(i, this.aed);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aee > 200) {
            this.aed = 0;
            this.aee = uptimeMillis;
        }
        if (this.aed < 10) {
            this.aeX = 1;
            invalidate();
        } else if (this.aed < 20) {
            this.aeX = 2;
            invalidate();
        } else if (this.aed < 30) {
            this.aeX = 3;
            invalidate();
        } else if (this.aed < 40) {
            this.aeX = 4;
            invalidate();
        } else {
            this.aeX = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (this.mModel != null && this.afD != null) {
            int i2 = i / 1000;
            if (this.afM != i2) {
                this.afD.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.afM = i2;
        }
    }

    private void sd() {
        if (this.mModel != null) {
            this.aeX = 0;
            this.afE = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.afH = SystemClock.uptimeMillis();
            this.afI = this.afH + 200;
            this.afK.sendEmptyMessageAtTime(1, this.afI);
            invalidate();
        }
    }

    private void se() {
        this.aeX = 0;
        this.aeY = 0;
        this.afE = 0.0f;
        this.afF = 0.0f;
        this.afK.removeMessages(1);
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
                rS();
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
        this.afG = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rH() {
    }

    public void sf() {
        this.afh = new Paint();
        this.afh.setAntiAlias(true);
        this.afh.setStyle(Paint.Style.STROKE);
        this.afh.setStrokeWidth(2.0f);
        this.afi = new Paint();
        this.afi.setAntiAlias(true);
        this.afi.setStyle(Paint.Style.STROKE);
        this.afi.setStrokeWidth(2.0f);
        this.afj = new Paint();
        this.afj.setAntiAlias(true);
        this.afj.setStyle(Paint.Style.STROKE);
        this.afj.setStrokeWidth(2.0f);
        this.afk = new Paint();
        this.afk.setAntiAlias(true);
        this.afk.setStyle(Paint.Style.STROKE);
        this.afk.setStrokeWidth(2.0f);
    }

    public void g(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.afh.setColor(this.afp);
            this.afi.setColor(this.afq);
            this.afj.setColor(this.afr);
            this.afk.setColor(this.afs);
        } else {
            this.afh.setColor(this.afl);
            this.afi.setColor(this.afm);
            this.afj.setColor(this.afn);
            this.afk.setColor(this.afo);
        }
        if (this.aeX == 2) {
            canvas.drawCircle(this.aeZ, this.afa, this.afb, this.afh);
        } else if (this.aeX == 3) {
            canvas.drawCircle(this.aeZ, this.afa, this.afb, this.afh);
            canvas.drawCircle(this.aeZ, this.afa, this.afc, this.afi);
        } else if (this.aeX == 4) {
            canvas.drawCircle(this.aeZ, this.afa, this.afb, this.afh);
            canvas.drawCircle(this.aeZ, this.afa, this.afc, this.afi);
            canvas.drawCircle(this.aeZ, this.afa, this.afd, this.afj);
        } else if (this.aeX == 5) {
            canvas.drawCircle(this.aeZ, this.afa, this.afb, this.afh);
            canvas.drawCircle(this.aeZ, this.afa, this.afc, this.afi);
            canvas.drawCircle(this.aeZ, this.afa, this.afd, this.afj);
            canvas.drawCircle(this.aeZ, this.afa, this.afe, this.afk);
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
                    sb();
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
        return this.aem;
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
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
