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
/* loaded from: classes23.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private final int[] abS;
    private int abT;
    private final int abU;
    private final int abV;
    private final int abW;
    private final int abX;
    private final int abY;
    private int abZ;
    private int abh;
    private long abi;
    private EditorTools abp;
    private int abq;
    private com.baidu.tbadk.core.dialog.a abt;
    private final Rect acA;
    private final RectF acB;
    private TextView acC;
    private TextView acD;
    private TextView acE;
    private TextView acF;
    private VoiceButton acG;
    private ImageView acH;
    private TextView acI;
    private float acJ;
    private float acK;
    private f acL;
    private long acM;
    private long acN;
    private final int[] acO;
    private final a acP;
    private SweepGradient acQ;
    private int acR;
    private int aca;
    private int acb;
    private int acc;
    private int acd;
    private int ace;
    private int acf;
    private int acg;
    private int ach;
    private int aci;
    private Paint acj;
    private Paint acm;
    private Paint acn;
    private Paint aco;
    private int acp;
    private int acq;
    private int acr;
    private int acs;
    private int act;
    private int acu;
    private int acv;
    private int acx;
    private final BitmapDrawable acy;
    private final Paint acz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.aca;
        voiceRecordButton.aca = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.acK >= 360.0f) {
                    VoiceRecordButton.this.acK = 360.0f;
                    VoiceRecordButton.this.aca = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.acM = uptimeMillis;
                    VoiceRecordButton.this.acN = uptimeMillis + 200;
                    VoiceRecordButton.this.acK += (((float) (uptimeMillis - VoiceRecordButton.this.acM)) / 1000.0f) * VoiceRecordButton.this.acJ;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.acN);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abZ = VoiceRecordButton.this.aca % 6;
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
        this.abi = 0L;
        this.abS = new int[4];
        this.abZ = 0;
        this.aca = 0;
        this.acb = 0;
        this.acc = 0;
        this.acd = 0;
        this.ace = 0;
        this.acf = 0;
        this.acg = 0;
        this.ach = 0;
        this.aci = 0;
        this.acp = -1724676609;
        this.acq = 1546880511;
        this.acr = 674465279;
        this.acs = 255034879;
        this.act = -1725669966;
        this.acu = 1545887154;
        this.acv = 673471922;
        this.acx = 254041522;
        this.acz = new Paint(1);
        this.acA = new Rect();
        this.acB = new RectF();
        this.abq = 0;
        this.acO = new int[2];
        this.acP = new a();
        this.abh = 0;
        this.acR = 0;
        this.abS[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.abS[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.abS[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.abS[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.acd = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.ace = this.acd + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.acf = this.ace + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.acg = this.acf + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ach = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.aci = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ach = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.aci = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abT = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.abU = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abV = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abW = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abX = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abY = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.acz.setStyle(Paint.Style.STROKE);
        this.acz.setStrokeWidth(this.abX);
        this.acy = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sD();
        this.acO[0] = ap.getColor(R.color.common_color_10151);
        this.acO[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.acG.getMeasuredWidth();
        int measuredHeight = this.acG.getMeasuredHeight();
        int measuredWidth2 = this.acD.getMeasuredWidth();
        this.acD.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.acD.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.acD.getBottom();
        this.acG.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.acb = (measuredWidth / 2) + i6;
        this.acc = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.acF.getMeasuredWidth();
        int measuredHeight2 = this.acF.getMeasuredHeight();
        int top = this.acG.getTop();
        this.acF.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.acC.getMeasuredWidth();
        int measuredHeight3 = this.acC.getMeasuredHeight();
        int right = this.acG.getRight() - this.abT;
        int bottom2 = this.acG.getBottom() - this.abU;
        this.acC.layout(this.ach + i6, this.aci + bottom, measuredWidth4 + i6 + this.ach, measuredHeight3 + this.aci + bottom);
        int measuredWidth5 = this.acH.getMeasuredWidth();
        this.acH.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.acH.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.acI.getMeasuredWidth();
        this.acI.layout((i5 - measuredWidth6) >> 1, (this.acC.getTop() - this.acI.getMeasuredHeight()) - this.abV, (measuredWidth6 + i5) >> 1, (this.acC.getTop() + i2) - this.abV);
        this.acG.getLeft();
        this.acG.getRight();
        int measuredWidth7 = this.acE.getMeasuredWidth();
        int measuredHeight4 = this.acE.getMeasuredHeight();
        int bottom3 = this.acG.getBottom();
        this.acE.layout((i5 - measuredWidth7) >> 1, this.abS[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.abS[3]);
        this.acA.set((i5 - this.acy.getIntrinsicWidth()) >> 1, this.acH.getTop() - this.abW, (i5 + this.acy.getIntrinsicHeight()) >> 1, (this.acH.getTop() + this.acy.getIntrinsicHeight()) - this.abW);
        this.acy.setBounds(this.acA);
        this.acB.set(this.acH.getLeft() + (this.abX >> 1) + this.abY, this.acH.getTop() + (this.abX >> 1) + this.abY, (this.acH.getRight() - (this.abX >> 1)) - this.abY, (this.acH.getBottom() - (this.abX >> 1)) - this.abY);
        if (this.acQ == null) {
            this.acQ = new SweepGradient(this.acB.centerX(), this.acB.centerY(), this.acO, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.acQ.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.acB.centerX(), this.acB.centerY());
            this.acQ.setLocalMatrix(matrix);
            this.acz.setShader(this.acQ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sr() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.abt == null) {
            this.abt = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.abt.AJ(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sB();
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
            }).b(i.I(getContext()));
        }
        try {
            this.abt.bog();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cY(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.acD = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.acD, R.color.CAM_X0101, 1);
        this.acE = (TextView) findViewById(R.id.tip_operator);
        this.acF = (TextView) findViewById(R.id.tip_time_out);
        this.acG = (VoiceButton) findViewById(R.id.voice_bnt);
        this.acC = (TextView) findViewById(R.id.restart);
        this.acH = (ImageView) findViewById(R.id.play_img);
        this.acI = (TextView) findViewById(R.id.play_time);
        this.acI.setClickable(false);
        this.acC.setOnClickListener(this);
        this.acH.setOnClickListener(this);
        this.acG.setRecorderView(this);
        sB();
    }

    private void sA() {
        this.acG.setVisibility(4);
        this.acI.setVisibility(0);
        this.acC.setVisibility(0);
        ap.setViewTextColor(this.acI, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.acC, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.acC, R.drawable.but_posts_record_again_selector);
        this.acH.setVisibility(0);
        if (this.mModel != null) {
            this.acI.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.acH.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.acH, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.acE, R.color.CAM_X0108, 1);
        this.acE.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB() {
        ap.setImageResource(this.acG, R.drawable.but_posts_record_zero_selector);
        this.acG.setVisibility(0);
        this.abZ = 0;
        this.acH.setVisibility(4);
        this.acI.setVisibility(4);
        this.acC.setVisibility(4);
        this.acF.setVisibility(4);
        ap.setViewTextColor(this.acE, R.color.CAM_X0301, 1);
        this.acE.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sB();
        this.mModel = null;
        this.abZ = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.acD.setText("");
        this.acD.setVisibility(4);
        this.abZ = 0;
        sA();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sB();
            this.acE.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.acH != null && this.acI != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.acI, R.color.CAM_X0106, 1);
                    this.acI.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.acH, R.drawable.but_posts_record_play_selector);
                    this.acH.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.acE.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.acI, R.color.CAM_X0106, 1);
                    ap.setImageResource(this.acH, R.drawable.but_posts_record_stop_selector);
                    this.acH.setContentDescription(getContext().getString(R.string.pause_load));
                    this.acE.setText(getContext().getString(R.string.voice_stop_tip));
                    sC();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.acF, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.acD, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.acE, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.acF.setVisibility(0);
                this.acF.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acF != null) {
                            VoiceRecordButton.this.acF.setVisibility(4);
                            VoiceRecordButton.this.acF.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.acD.setVisibility(0);
                this.acD.setText(str);
                this.acE.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acD != null) {
                            VoiceRecordButton.this.acD.setVisibility(4);
                            VoiceRecordButton.this.acD.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.acD.setVisibility(0);
                this.acD.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acD != null) {
                            VoiceRecordButton.this.acD.setVisibility(4);
                            VoiceRecordButton.this.acD.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sB();
                this.acD.setVisibility(0);
                this.acD.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acD != null) {
                            VoiceRecordButton.this.acD.setVisibility(4);
                            VoiceRecordButton.this.acD.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.acD.setVisibility(4);
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
        ap.setViewTextColor(this.acD, R.color.CAM_X0101, 1);
        this.acD.setVisibility(0);
        this.acD.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.abh = Math.max(i, this.abh);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abi > 200) {
            this.abh = 0;
            this.abi = uptimeMillis;
        }
        if (this.abh < 10) {
            this.abZ = 1;
            invalidate();
        } else if (this.abh < 20) {
            this.abZ = 2;
            invalidate();
        } else if (this.abh < 30) {
            this.abZ = 3;
            invalidate();
        } else if (this.abh < 40) {
            this.abZ = 4;
            invalidate();
        } else {
            this.abZ = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (this.mModel != null && this.acI != null) {
            int i2 = i / 1000;
            if (this.acR != i2) {
                this.acI.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.acR = i2;
        }
    }

    private void sC() {
        if (this.mModel != null) {
            this.abZ = 0;
            this.acJ = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.acM = SystemClock.uptimeMillis();
            this.acN = this.acM + 200;
            this.acP.sendEmptyMessageAtTime(1, this.acN);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abZ = 0;
        this.aca = 0;
        this.acJ = 0.0f;
        this.acK = 0.0f;
        this.acP.removeMessages(1);
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
                sr();
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
        this.acL = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void sD() {
        this.acj = new Paint();
        this.acj.setAntiAlias(true);
        this.acj.setStyle(Paint.Style.STROKE);
        this.acj.setStrokeWidth(2.0f);
        this.acm = new Paint();
        this.acm.setAntiAlias(true);
        this.acm.setStyle(Paint.Style.STROKE);
        this.acm.setStrokeWidth(2.0f);
        this.acn = new Paint();
        this.acn.setAntiAlias(true);
        this.acn.setStyle(Paint.Style.STROKE);
        this.acn.setStrokeWidth(2.0f);
        this.aco = new Paint();
        this.aco.setAntiAlias(true);
        this.aco.setStyle(Paint.Style.STROKE);
        this.aco.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.acj.setColor(this.act);
            this.acm.setColor(this.acu);
            this.acn.setColor(this.acv);
            this.aco.setColor(this.acx);
        } else {
            this.acj.setColor(this.acp);
            this.acm.setColor(this.acq);
            this.acn.setColor(this.acr);
            this.aco.setColor(this.acs);
        }
        if (this.abZ == 2) {
            canvas.drawCircle(this.acb, this.acc, this.acd, this.acj);
        } else if (this.abZ == 3) {
            canvas.drawCircle(this.acb, this.acc, this.acd, this.acj);
            canvas.drawCircle(this.acb, this.acc, this.ace, this.acm);
        } else if (this.abZ == 4) {
            canvas.drawCircle(this.acb, this.acc, this.acd, this.acj);
            canvas.drawCircle(this.acb, this.acc, this.ace, this.acm);
            canvas.drawCircle(this.acb, this.acc, this.acf, this.acn);
        } else if (this.abZ == 5) {
            canvas.drawCircle(this.acb, this.acc, this.acd, this.acj);
            canvas.drawCircle(this.acb, this.acc, this.ace, this.acm);
            canvas.drawCircle(this.acb, this.acc, this.acf, this.acn);
            canvas.drawCircle(this.acb, this.acc, this.acg, this.aco);
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
                    sA();
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
        return this.abq;
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
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
