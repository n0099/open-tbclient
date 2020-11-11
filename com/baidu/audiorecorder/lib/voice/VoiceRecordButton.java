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
    private final int[] abN;
    private int abO;
    private final int abP;
    private final int abQ;
    private final int abR;
    private final int abS;
    private final int abT;
    private int abU;
    private int abV;
    private int abW;
    private int abX;
    private int abY;
    private int abZ;
    private int abb;
    private long abd;
    private EditorTools abk;
    private int abl;
    private com.baidu.tbadk.core.dialog.a abn;
    private TextView acA;
    private VoiceButton acB;
    private ImageView acC;
    private TextView acD;
    private float acE;
    private float acF;
    private f acG;
    private long acH;
    private long acI;
    private final int[] acJ;
    private final a acK;
    private SweepGradient acL;
    private int acM;
    private int aca;
    private int acb;
    private int acc;
    private int acd;
    private Paint ace;
    private Paint acf;
    private Paint acg;
    private Paint ach;
    private int aci;
    private int acj;
    private int acm;
    private int acn;
    private int aco;
    private int acp;
    private int acq;
    private int acr;
    private final BitmapDrawable acs;
    private final Paint act;
    private final Rect acu;
    private final RectF acv;
    private TextView acx;
    private TextView acy;
    private TextView acz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.abV;
        voiceRecordButton.abV = i + 1;
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
                if (VoiceRecordButton.this.acF >= 360.0f) {
                    VoiceRecordButton.this.acF = 360.0f;
                    VoiceRecordButton.this.abV = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.acH = uptimeMillis;
                    VoiceRecordButton.this.acI = uptimeMillis + 200;
                    VoiceRecordButton.this.acF += (((float) (uptimeMillis - VoiceRecordButton.this.acH)) / 1000.0f) * VoiceRecordButton.this.acE;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.acI);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abU = VoiceRecordButton.this.abV % 6;
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
        this.abd = 0L;
        this.abN = new int[4];
        this.abU = 0;
        this.abV = 0;
        this.abW = 0;
        this.abX = 0;
        this.abY = 0;
        this.abZ = 0;
        this.aca = 0;
        this.acb = 0;
        this.acc = 0;
        this.acd = 0;
        this.aci = -1724676609;
        this.acj = 1546880511;
        this.acm = 674465279;
        this.acn = 255034879;
        this.aco = -1725669966;
        this.acp = 1545887154;
        this.acq = 673471922;
        this.acr = 254041522;
        this.act = new Paint(1);
        this.acu = new Rect();
        this.acv = new RectF();
        this.abl = 0;
        this.acJ = new int[2];
        this.acK = new a();
        this.abb = 0;
        this.acM = 0;
        this.abN[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.abN[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.abN[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.abN[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.abY = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.abZ = this.abY + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aca = this.abZ + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.acb = this.aca + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.acc = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.acd = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.acc = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.acd = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abO = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.abP = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abQ = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abR = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abS = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abT = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.act.setStyle(Paint.Style.STROKE);
        this.act.setStrokeWidth(this.abS);
        this.acs = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sD();
        this.acJ[0] = ap.getColor(R.color.common_color_10151);
        this.acJ[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.acB.getMeasuredWidth();
        int measuredHeight = this.acB.getMeasuredHeight();
        int measuredWidth2 = this.acy.getMeasuredWidth();
        this.acy.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.acy.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.acy.getBottom();
        this.acB.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.abW = (measuredWidth / 2) + i6;
        this.abX = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.acA.getMeasuredWidth();
        int measuredHeight2 = this.acA.getMeasuredHeight();
        int top = this.acB.getTop();
        this.acA.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.acx.getMeasuredWidth();
        int measuredHeight3 = this.acx.getMeasuredHeight();
        int right = this.acB.getRight() - this.abO;
        int bottom2 = this.acB.getBottom() - this.abP;
        this.acx.layout(this.acc + i6, this.acd + bottom, measuredWidth4 + i6 + this.acc, measuredHeight3 + this.acd + bottom);
        int measuredWidth5 = this.acC.getMeasuredWidth();
        this.acC.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.acC.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.acD.getMeasuredWidth();
        this.acD.layout((i5 - measuredWidth6) >> 1, (this.acx.getTop() - this.acD.getMeasuredHeight()) - this.abQ, (measuredWidth6 + i5) >> 1, (this.acx.getTop() + i2) - this.abQ);
        this.acB.getLeft();
        this.acB.getRight();
        int measuredWidth7 = this.acz.getMeasuredWidth();
        int measuredHeight4 = this.acz.getMeasuredHeight();
        int bottom3 = this.acB.getBottom();
        this.acz.layout((i5 - measuredWidth7) >> 1, this.abN[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.abN[3]);
        this.acu.set((i5 - this.acs.getIntrinsicWidth()) >> 1, this.acC.getTop() - this.abR, (i5 + this.acs.getIntrinsicHeight()) >> 1, (this.acC.getTop() + this.acs.getIntrinsicHeight()) - this.abR);
        this.acs.setBounds(this.acu);
        this.acv.set(this.acC.getLeft() + (this.abS >> 1) + this.abT, this.acC.getTop() + (this.abS >> 1) + this.abT, (this.acC.getRight() - (this.abS >> 1)) - this.abT, (this.acC.getBottom() - (this.abS >> 1)) - this.abT);
        if (this.acL == null) {
            this.acL = new SweepGradient(this.acv.centerX(), this.acv.centerY(), this.acJ, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.acL.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.acv.centerX(), this.acv.centerY());
            this.acL.setLocalMatrix(matrix);
            this.act.setShader(this.acL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sr() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.abn == null) {
            this.abn = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.abn.Bo(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sB();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cW(VoiceRecordButton.this.mModel.voiceId);
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
            this.abn.bpc();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cW(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.acy = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.acy, R.color.cp_cont_a, 1);
        this.acz = (TextView) findViewById(R.id.tip_operator);
        this.acA = (TextView) findViewById(R.id.tip_time_out);
        this.acB = (VoiceButton) findViewById(R.id.voice_bnt);
        this.acx = (TextView) findViewById(R.id.restart);
        this.acC = (ImageView) findViewById(R.id.play_img);
        this.acD = (TextView) findViewById(R.id.play_time);
        this.acD.setClickable(false);
        this.acx.setOnClickListener(this);
        this.acC.setOnClickListener(this);
        this.acB.setRecorderView(this);
        sB();
    }

    private void sA() {
        this.acB.setVisibility(4);
        this.acD.setVisibility(0);
        this.acx.setVisibility(0);
        ap.setViewTextColor(this.acD, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.acx, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.acx, R.drawable.but_posts_record_again_selector);
        this.acC.setVisibility(0);
        if (this.mModel != null) {
            this.acD.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.acC.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.acC, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.acz, R.color.cp_cont_c, 1);
        this.acz.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB() {
        ap.setImageResource(this.acB, R.drawable.but_posts_record_zero_selector);
        this.acB.setVisibility(0);
        this.abU = 0;
        this.acC.setVisibility(4);
        this.acD.setVisibility(4);
        this.acx.setVisibility(4);
        this.acA.setVisibility(4);
        ap.setViewTextColor(this.acz, R.color.cp_cont_c, 1);
        this.acz.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sB();
        this.mModel = null;
        this.abU = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.acy.setText("");
        this.acy.setVisibility(4);
        this.abU = 0;
        sA();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sB();
            this.acz.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.acC != null && this.acD != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.acD, R.color.cp_cont_f, 1);
                    this.acD.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.acC, R.drawable.but_posts_record_play_selector);
                    this.acC.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.acz.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.acD, R.color.cp_cont_f, 1);
                    ap.setImageResource(this.acC, R.drawable.but_posts_record_stop_selector);
                    this.acC.setContentDescription(getContext().getString(R.string.pause_load));
                    this.acz.setText(getContext().getString(R.string.voice_stop_tip));
                    sC();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.acA, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.acy, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.acz, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.acA.setVisibility(0);
                this.acA.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acA != null) {
                            VoiceRecordButton.this.acA.setVisibility(4);
                            VoiceRecordButton.this.acA.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.acy.setVisibility(0);
                this.acy.setText(str);
                this.acz.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acy != null) {
                            VoiceRecordButton.this.acy.setVisibility(4);
                            VoiceRecordButton.this.acy.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.acy.setVisibility(0);
                this.acy.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acy != null) {
                            VoiceRecordButton.this.acy.setVisibility(4);
                            VoiceRecordButton.this.acy.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sB();
                this.acy.setVisibility(0);
                this.acy.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acy != null) {
                            VoiceRecordButton.this.acy.setVisibility(4);
                            VoiceRecordButton.this.acy.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.acy.setVisibility(4);
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
        ap.setViewTextColor(this.acy, R.color.cp_cont_a, 1);
        this.acy.setVisibility(0);
        this.acy.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.abb = Math.max(i, this.abb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abd > 200) {
            this.abb = 0;
            this.abd = uptimeMillis;
        }
        if (this.abb < 10) {
            this.abU = 1;
            invalidate();
        } else if (this.abb < 20) {
            this.abU = 2;
            invalidate();
        } else if (this.abb < 30) {
            this.abU = 3;
            invalidate();
        } else if (this.abb < 40) {
            this.abU = 4;
            invalidate();
        } else {
            this.abU = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (this.mModel != null && this.acD != null) {
            int i2 = i / 1000;
            if (this.acM != i2) {
                this.acD.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.acM = i2;
        }
    }

    private void sC() {
        if (this.mModel != null) {
            this.abU = 0;
            this.acE = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.acH = SystemClock.uptimeMillis();
            this.acI = this.acH + 200;
            this.acK.sendEmptyMessageAtTime(1, this.acI);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abU = 0;
        this.abV = 0;
        this.acE = 0.0f;
        this.acF = 0.0f;
        this.acK.removeMessages(1);
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
        this.acG = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void sD() {
        this.ace = new Paint();
        this.ace.setAntiAlias(true);
        this.ace.setStyle(Paint.Style.STROKE);
        this.ace.setStrokeWidth(2.0f);
        this.acf = new Paint();
        this.acf.setAntiAlias(true);
        this.acf.setStyle(Paint.Style.STROKE);
        this.acf.setStrokeWidth(2.0f);
        this.acg = new Paint();
        this.acg.setAntiAlias(true);
        this.acg.setStyle(Paint.Style.STROKE);
        this.acg.setStrokeWidth(2.0f);
        this.ach = new Paint();
        this.ach.setAntiAlias(true);
        this.ach.setStyle(Paint.Style.STROKE);
        this.ach.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ace.setColor(this.aco);
            this.acf.setColor(this.acp);
            this.acg.setColor(this.acq);
            this.ach.setColor(this.acr);
        } else {
            this.ace.setColor(this.aci);
            this.acf.setColor(this.acj);
            this.acg.setColor(this.acm);
            this.ach.setColor(this.acn);
        }
        if (this.abU == 2) {
            canvas.drawCircle(this.abW, this.abX, this.abY, this.ace);
        } else if (this.abU == 3) {
            canvas.drawCircle(this.abW, this.abX, this.abY, this.ace);
            canvas.drawCircle(this.abW, this.abX, this.abZ, this.acf);
        } else if (this.abU == 4) {
            canvas.drawCircle(this.abW, this.abX, this.abY, this.ace);
            canvas.drawCircle(this.abW, this.abX, this.abZ, this.acf);
            canvas.drawCircle(this.abW, this.abX, this.aca, this.acg);
        } else if (this.abU == 5) {
            canvas.drawCircle(this.abW, this.abX, this.abY, this.ace);
            canvas.drawCircle(this.abW, this.abX, this.abZ, this.acf);
            canvas.drawCircle(this.abW, this.abX, this.aca, this.acg);
            canvas.drawCircle(this.abW, this.abX, this.acb, this.ach);
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
        return this.abl;
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
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
