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
    private final int[] abM;
    private int abN;
    private final int abO;
    private final int abP;
    private final int abQ;
    private final int abR;
    private final int abS;
    private int abT;
    private int abU;
    private int abV;
    private int abW;
    private int abX;
    private int abY;
    private int abZ;
    private int aba;
    private long abb;
    private EditorTools abj;
    private int abk;
    private com.baidu.tbadk.core.dialog.a abm;
    private VoiceButton acA;
    private ImageView acB;
    private TextView acC;
    private float acD;
    private float acE;
    private f acF;
    private long acG;
    private long acH;
    private final int[] acI;
    private final a acJ;
    private SweepGradient acK;
    private int acL;
    private int aca;
    private int acb;
    private int acc;
    private Paint acd;
    private Paint ace;
    private Paint acf;
    private Paint acg;
    private int ach;
    private int aci;
    private int acj;
    private int acm;
    private int acn;
    private int aco;
    private int acp;
    private int acq;
    private final BitmapDrawable acr;
    private final Paint acs;
    private final Rect act;
    private final RectF acu;
    private TextView acv;
    private TextView acx;
    private TextView acy;
    private TextView acz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.abU;
        voiceRecordButton.abU = i + 1;
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
                if (VoiceRecordButton.this.acE >= 360.0f) {
                    VoiceRecordButton.this.acE = 360.0f;
                    VoiceRecordButton.this.abU = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.acG = uptimeMillis;
                    VoiceRecordButton.this.acH = uptimeMillis + 200;
                    VoiceRecordButton.this.acE += (((float) (uptimeMillis - VoiceRecordButton.this.acG)) / 1000.0f) * VoiceRecordButton.this.acD;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.acH);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abT = VoiceRecordButton.this.abU % 6;
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
        this.abb = 0L;
        this.abM = new int[4];
        this.abT = 0;
        this.abU = 0;
        this.abV = 0;
        this.abW = 0;
        this.abX = 0;
        this.abY = 0;
        this.abZ = 0;
        this.aca = 0;
        this.acb = 0;
        this.acc = 0;
        this.ach = -1724676609;
        this.aci = 1546880511;
        this.acj = 674465279;
        this.acm = 255034879;
        this.acn = -1725669966;
        this.aco = 1545887154;
        this.acp = 673471922;
        this.acq = 254041522;
        this.acs = new Paint(1);
        this.act = new Rect();
        this.acu = new RectF();
        this.abk = 0;
        this.acI = new int[2];
        this.acJ = new a();
        this.aba = 0;
        this.acL = 0;
        this.abM[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.abM[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.abM[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.abM[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.abX = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.abY = this.abX + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abZ = this.abY + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.aca = this.abZ + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.acb = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.acc = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.acb = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.acc = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abN = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.abO = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abP = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abQ = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abR = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abS = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.acs.setStyle(Paint.Style.STROKE);
        this.acs.setStrokeWidth(this.abR);
        this.acr = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sD();
        this.acI[0] = ap.getColor(R.color.common_color_10151);
        this.acI[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.acA.getMeasuredWidth();
        int measuredHeight = this.acA.getMeasuredHeight();
        int measuredWidth2 = this.acx.getMeasuredWidth();
        this.acx.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.acx.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.acx.getBottom();
        this.acA.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.abV = (measuredWidth / 2) + i6;
        this.abW = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.acz.getMeasuredWidth();
        int measuredHeight2 = this.acz.getMeasuredHeight();
        int top = this.acA.getTop();
        this.acz.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.acv.getMeasuredWidth();
        int measuredHeight3 = this.acv.getMeasuredHeight();
        int right = this.acA.getRight() - this.abN;
        int bottom2 = this.acA.getBottom() - this.abO;
        this.acv.layout(this.acb + i6, this.acc + bottom, measuredWidth4 + i6 + this.acb, measuredHeight3 + this.acc + bottom);
        int measuredWidth5 = this.acB.getMeasuredWidth();
        this.acB.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.acB.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.acC.getMeasuredWidth();
        this.acC.layout((i5 - measuredWidth6) >> 1, (this.acv.getTop() - this.acC.getMeasuredHeight()) - this.abP, (measuredWidth6 + i5) >> 1, (this.acv.getTop() + i2) - this.abP);
        this.acA.getLeft();
        this.acA.getRight();
        int measuredWidth7 = this.acy.getMeasuredWidth();
        int measuredHeight4 = this.acy.getMeasuredHeight();
        int bottom3 = this.acA.getBottom();
        this.acy.layout((i5 - measuredWidth7) >> 1, this.abM[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.abM[3]);
        this.act.set((i5 - this.acr.getIntrinsicWidth()) >> 1, this.acB.getTop() - this.abQ, (i5 + this.acr.getIntrinsicHeight()) >> 1, (this.acB.getTop() + this.acr.getIntrinsicHeight()) - this.abQ);
        this.acr.setBounds(this.act);
        this.acu.set(this.acB.getLeft() + (this.abR >> 1) + this.abS, this.acB.getTop() + (this.abR >> 1) + this.abS, (this.acB.getRight() - (this.abR >> 1)) - this.abS, (this.acB.getBottom() - (this.abR >> 1)) - this.abS);
        if (this.acK == null) {
            this.acK = new SweepGradient(this.acu.centerX(), this.acu.centerY(), this.acI, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.acK.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.acu.centerX(), this.acu.centerY());
            this.acK.setLocalMatrix(matrix);
            this.acs.setShader(this.acK);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sr() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.abm == null) {
            this.abm = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.abm.AH(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
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
            this.abm.bkJ();
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
        this.acx = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.acx, R.color.cp_cont_a, 1);
        this.acy = (TextView) findViewById(R.id.tip_operator);
        this.acz = (TextView) findViewById(R.id.tip_time_out);
        this.acA = (VoiceButton) findViewById(R.id.voice_bnt);
        this.acv = (TextView) findViewById(R.id.restart);
        this.acB = (ImageView) findViewById(R.id.play_img);
        this.acC = (TextView) findViewById(R.id.play_time);
        this.acC.setClickable(false);
        this.acv.setOnClickListener(this);
        this.acB.setOnClickListener(this);
        this.acA.setRecorderView(this);
        sB();
    }

    private void sA() {
        this.acA.setVisibility(4);
        this.acC.setVisibility(0);
        this.acv.setVisibility(0);
        ap.setViewTextColor(this.acC, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.acv, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.acv, R.drawable.but_posts_record_again_selector);
        this.acB.setVisibility(0);
        if (this.mModel != null) {
            this.acC.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.acB.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.acB, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.acy, R.color.cp_cont_c, 1);
        this.acy.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB() {
        ap.setImageResource(this.acA, R.drawable.but_posts_record_zero_selector);
        this.acA.setVisibility(0);
        this.abT = 0;
        this.acB.setVisibility(4);
        this.acC.setVisibility(4);
        this.acv.setVisibility(4);
        this.acz.setVisibility(4);
        ap.setViewTextColor(this.acy, R.color.cp_cont_c, 1);
        this.acy.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sB();
        this.mModel = null;
        this.abT = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.acx.setText("");
        this.acx.setVisibility(4);
        this.abT = 0;
        sA();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sB();
            this.acy.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.acB != null && this.acC != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.acC, R.color.cp_cont_f, 1);
                    this.acC.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.acB, R.drawable.but_posts_record_play_selector);
                    this.acB.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.acy.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.acC, R.color.cp_cont_f, 1);
                    ap.setImageResource(this.acB, R.drawable.but_posts_record_stop_selector);
                    this.acB.setContentDescription(getContext().getString(R.string.pause_load));
                    this.acy.setText(getContext().getString(R.string.voice_stop_tip));
                    sC();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.acz, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.acx, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.acy, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.acz.setVisibility(0);
                this.acz.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acz != null) {
                            VoiceRecordButton.this.acz.setVisibility(4);
                            VoiceRecordButton.this.acz.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.acx.setVisibility(0);
                this.acx.setText(str);
                this.acy.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acx != null) {
                            VoiceRecordButton.this.acx.setVisibility(4);
                            VoiceRecordButton.this.acx.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.acx.setVisibility(0);
                this.acx.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acx != null) {
                            VoiceRecordButton.this.acx.setVisibility(4);
                            VoiceRecordButton.this.acx.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sB();
                this.acx.setVisibility(0);
                this.acx.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.acx != null) {
                            VoiceRecordButton.this.acx.setVisibility(4);
                            VoiceRecordButton.this.acx.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.acx.setVisibility(4);
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
        ap.setViewTextColor(this.acx, R.color.cp_cont_a, 1);
        this.acx.setVisibility(0);
        this.acx.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aba = Math.max(i, this.aba);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.abb > 200) {
            this.aba = 0;
            this.abb = uptimeMillis;
        }
        if (this.aba < 10) {
            this.abT = 1;
            invalidate();
        } else if (this.aba < 20) {
            this.abT = 2;
            invalidate();
        } else if (this.aba < 30) {
            this.abT = 3;
            invalidate();
        } else if (this.aba < 40) {
            this.abT = 4;
            invalidate();
        } else {
            this.abT = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (this.mModel != null && this.acC != null) {
            int i2 = i / 1000;
            if (this.acL != i2) {
                this.acC.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.acL = i2;
        }
    }

    private void sC() {
        if (this.mModel != null) {
            this.abT = 0;
            this.acD = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.acG = SystemClock.uptimeMillis();
            this.acH = this.acG + 200;
            this.acJ.sendEmptyMessageAtTime(1, this.acH);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abT = 0;
        this.abU = 0;
        this.acD = 0.0f;
        this.acE = 0.0f;
        this.acJ.removeMessages(1);
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
        this.acF = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void sD() {
        this.acd = new Paint();
        this.acd.setAntiAlias(true);
        this.acd.setStyle(Paint.Style.STROKE);
        this.acd.setStrokeWidth(2.0f);
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
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.acd.setColor(this.acn);
            this.ace.setColor(this.aco);
            this.acf.setColor(this.acp);
            this.acg.setColor(this.acq);
        } else {
            this.acd.setColor(this.ach);
            this.ace.setColor(this.aci);
            this.acf.setColor(this.acj);
            this.acg.setColor(this.acm);
        }
        if (this.abT == 2) {
            canvas.drawCircle(this.abV, this.abW, this.abX, this.acd);
        } else if (this.abT == 3) {
            canvas.drawCircle(this.abV, this.abW, this.abX, this.acd);
            canvas.drawCircle(this.abV, this.abW, this.abY, this.ace);
        } else if (this.abT == 4) {
            canvas.drawCircle(this.abV, this.abW, this.abX, this.acd);
            canvas.drawCircle(this.abV, this.abW, this.abY, this.ace);
            canvas.drawCircle(this.abV, this.abW, this.abZ, this.acf);
        } else if (this.abT == 5) {
            canvas.drawCircle(this.abV, this.abW, this.abX, this.acd);
            canvas.drawCircle(this.abV, this.abW, this.abY, this.ace);
            canvas.drawCircle(this.abV, this.abW, this.abZ, this.acf);
            canvas.drawCircle(this.abV, this.abW, this.aca, this.acg);
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
        return this.abk;
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
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
