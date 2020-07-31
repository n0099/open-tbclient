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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes18.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private int ZK;
    private long ZL;
    private EditorTools ZS;
    private int ZT;
    private com.baidu.tbadk.core.dialog.a ZV;
    private final int aaA;
    private final int aaB;
    private int aaC;
    private int aaD;
    private int aaE;
    private int aaF;
    private int aaG;
    private int aaH;
    private int aaI;
    private int aaJ;
    private int aaK;
    private int aaL;
    private Paint aaM;
    private Paint aaN;
    private Paint aaO;
    private Paint aaP;
    private int aaQ;
    private int aaR;
    private int aaS;
    private int aaT;
    private int aaU;
    private int aaV;
    private int aaW;
    private int aaX;
    private final BitmapDrawable aaY;
    private final Paint aaZ;
    private final int[] aav;
    private int aaw;
    private final int aax;
    private final int aay;
    private final int aaz;
    private final Rect aba;
    private final RectF abb;
    private TextView abd;
    private TextView abe;
    private TextView abf;
    private TextView abg;
    private VoiceButton abh;
    private ImageView abi;
    private TextView abj;
    private float abk;
    private float abl;
    private f abm;
    private long abn;
    private long abo;
    private final int[] abp;
    private final a abq;
    private SweepGradient abr;
    private int abt;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.aaD;
        voiceRecordButton.aaD = i + 1;
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
                if (VoiceRecordButton.this.abl >= 360.0f) {
                    VoiceRecordButton.this.abl = 360.0f;
                    VoiceRecordButton.this.aaD = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.abn = uptimeMillis;
                    VoiceRecordButton.this.abo = uptimeMillis + 200;
                    VoiceRecordButton.this.abl += (((float) (uptimeMillis - VoiceRecordButton.this.abn)) / 1000.0f) * VoiceRecordButton.this.abk;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.abo);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.aaC = VoiceRecordButton.this.aaD % 6;
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
        this.ZL = 0L;
        this.aav = new int[4];
        this.aaC = 0;
        this.aaD = 0;
        this.aaE = 0;
        this.aaF = 0;
        this.aaG = 0;
        this.aaH = 0;
        this.aaI = 0;
        this.aaJ = 0;
        this.aaK = 0;
        this.aaL = 0;
        this.aaQ = -1724676609;
        this.aaR = 1546880511;
        this.aaS = 674465279;
        this.aaT = 255034879;
        this.aaU = -1725669966;
        this.aaV = 1545887154;
        this.aaW = 673471922;
        this.aaX = 254041522;
        this.aaZ = new Paint(1);
        this.aba = new Rect();
        this.abb = new RectF();
        this.ZT = 0;
        this.abp = new int[2];
        this.abq = new a();
        this.ZK = 0;
        this.abt = 0;
        this.aav[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aav[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.aav[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.aav[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.aaG = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.aaH = this.aaG + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aaI = this.aaH + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.aaJ = this.aaI + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.aaK = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.aaL = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.aaK = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.aaL = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.aaw = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.aax = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aay = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aaz = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aaA = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.aaB = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aaZ.setStyle(Paint.Style.STROKE);
        this.aaZ.setStrokeWidth(this.aaA);
        this.aaY = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        K(context);
        qZ();
        this.abp[0] = ao.getColor(R.color.common_color_10151);
        this.abp[1] = ao.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.abh.getMeasuredWidth();
        int measuredHeight = this.abh.getMeasuredHeight();
        int measuredWidth2 = this.abe.getMeasuredWidth();
        this.abe.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.abe.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.abe.getBottom();
        this.abh.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.aaE = (measuredWidth / 2) + i6;
        this.aaF = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.abg.getMeasuredWidth();
        int measuredHeight2 = this.abg.getMeasuredHeight();
        int top = this.abh.getTop();
        this.abg.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.abd.getMeasuredWidth();
        int measuredHeight3 = this.abd.getMeasuredHeight();
        int right = this.abh.getRight() - this.aaw;
        int bottom2 = this.abh.getBottom() - this.aax;
        this.abd.layout(this.aaK + i6, this.aaL + bottom, measuredWidth4 + i6 + this.aaK, measuredHeight3 + this.aaL + bottom);
        int measuredWidth5 = this.abi.getMeasuredWidth();
        this.abi.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.abi.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.abj.getMeasuredWidth();
        this.abj.layout((i5 - measuredWidth6) >> 1, (this.abd.getTop() - this.abj.getMeasuredHeight()) - this.aay, (measuredWidth6 + i5) >> 1, (this.abd.getTop() + i2) - this.aay);
        this.abh.getLeft();
        this.abh.getRight();
        int measuredWidth7 = this.abf.getMeasuredWidth();
        int measuredHeight4 = this.abf.getMeasuredHeight();
        int bottom3 = this.abh.getBottom();
        this.abf.layout((i5 - measuredWidth7) >> 1, this.aav[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.aav[3]);
        this.aba.set((i5 - this.aaY.getIntrinsicWidth()) >> 1, this.abi.getTop() - this.aaz, (i5 + this.aaY.getIntrinsicHeight()) >> 1, (this.abi.getTop() + this.aaY.getIntrinsicHeight()) - this.aaz);
        this.aaY.setBounds(this.aba);
        this.abb.set(this.abi.getLeft() + (this.aaA >> 1) + this.aaB, this.abi.getTop() + (this.aaA >> 1) + this.aaB, (this.abi.getRight() - (this.aaA >> 1)) - this.aaB, (this.abi.getBottom() - (this.aaA >> 1)) - this.aaB);
        if (this.abr == null) {
            this.abr = new SweepGradient(this.abb.centerX(), this.abb.centerY(), this.abp, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.abr.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.abb.centerX(), this.abb.centerY());
            this.abr.setLocalMatrix(matrix);
            this.aaZ.setShader(this.abr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qN() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.ZV == null) {
            this.ZV = new com.baidu.tbadk.core.dialog.a(i.G(getContext()).getPageActivity());
            this.ZV.xl(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qX();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cO(VoiceRecordButton.this.mModel.voiceId);
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
            this.ZV.aYL();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cO(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.abe = (TextView) findViewById(R.id.tip_error);
        ao.setViewTextColor(this.abe, R.color.cp_cont_a, 1);
        this.abf = (TextView) findViewById(R.id.tip_operator);
        this.abg = (TextView) findViewById(R.id.tip_time_out);
        this.abh = (VoiceButton) findViewById(R.id.voice_bnt);
        this.abd = (TextView) findViewById(R.id.restart);
        this.abi = (ImageView) findViewById(R.id.play_img);
        this.abj = (TextView) findViewById(R.id.play_time);
        this.abj.setClickable(false);
        this.abd.setOnClickListener(this);
        this.abi.setOnClickListener(this);
        this.abh.setRecorderView(this);
        qX();
    }

    private void qW() {
        this.abh.setVisibility(4);
        this.abj.setVisibility(0);
        this.abd.setVisibility(0);
        ao.setViewTextColor(this.abj, R.color.cp_cont_f, 1);
        ao.setViewTextColor(this.abd, R.color.cp_cont_f, 1);
        ao.setBackgroundResource(this.abd, R.drawable.but_posts_record_again_selector);
        this.abi.setVisibility(0);
        if (this.mModel != null) {
            this.abj.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.abi.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ao.setImageResource(this.abi, R.drawable.but_posts_record_play_selector);
        }
        ao.setViewTextColor(this.abf, R.color.cp_cont_c, 1);
        this.abf.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX() {
        ao.setImageResource(this.abh, R.drawable.but_posts_record_zero_selector);
        this.abh.setVisibility(0);
        this.aaC = 0;
        this.abi.setVisibility(4);
        this.abj.setVisibility(4);
        this.abd.setVisibility(4);
        this.abg.setVisibility(4);
        ao.setViewTextColor(this.abf, R.color.cp_cont_c, 1);
        this.abf.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qX();
        this.mModel = null;
        this.aaC = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.abe.setText("");
        this.abe.setVisibility(4);
        this.aaC = 0;
        qW();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qX();
            this.abf.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.abi != null && this.abj != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ao.setViewTextColor(this.abj, R.color.cp_cont_f, 1);
                    this.abj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ao.setImageResource(this.abi, R.drawable.but_posts_record_play_selector);
                    this.abi.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.abf.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ao.setViewTextColor(this.abj, R.color.cp_cont_f, 1);
                    ao.setImageResource(this.abi, R.drawable.but_posts_record_stop_selector);
                    this.abi.setContentDescription(getContext().getString(R.string.pause_load));
                    this.abf.setText(getContext().getString(R.string.voice_stop_tip));
                    qY();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ao.setViewTextColor(this.abg, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.abe, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.abf, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.abg.setVisibility(0);
                this.abg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abg != null) {
                            VoiceRecordButton.this.abg.setVisibility(4);
                            VoiceRecordButton.this.abg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.abe.setVisibility(0);
                this.abe.setText(str);
                this.abf.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abe != null) {
                            VoiceRecordButton.this.abe.setVisibility(4);
                            VoiceRecordButton.this.abe.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.abe.setVisibility(0);
                this.abe.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abe != null) {
                            VoiceRecordButton.this.abe.setVisibility(4);
                            VoiceRecordButton.this.abe.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qX();
                this.abe.setVisibility(0);
                this.abe.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abe != null) {
                            VoiceRecordButton.this.abe.setVisibility(4);
                            VoiceRecordButton.this.abe.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.abe.setVisibility(4);
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
        ao.setViewTextColor(this.abe, R.color.cp_cont_a, 1);
        this.abe.setVisibility(0);
        this.abe.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.ZK = Math.max(i, this.ZK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ZL > 200) {
            this.ZK = 0;
            this.ZL = uptimeMillis;
        }
        if (this.ZK < 10) {
            this.aaC = 1;
            invalidate();
        } else if (this.ZK < 20) {
            this.aaC = 2;
            invalidate();
        } else if (this.ZK < 30) {
            this.aaC = 3;
            invalidate();
        } else if (this.ZK < 40) {
            this.aaC = 4;
            invalidate();
        } else {
            this.aaC = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aY(int i) {
        if (this.mModel != null && this.abj != null) {
            int i2 = i / 1000;
            if (this.abt != i2) {
                this.abj.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.abt = i2;
        }
    }

    private void qY() {
        if (this.mModel != null) {
            this.aaC = 0;
            this.abk = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.abn = SystemClock.uptimeMillis();
            this.abo = this.abn + 200;
            this.abq.sendEmptyMessageAtTime(1, this.abo);
            invalidate();
        }
    }

    private void stopProgress() {
        this.aaC = 0;
        this.aaD = 0;
        this.abk = 0.0f;
        this.abl = 0.0f;
        this.abq.removeMessages(1);
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
                qN();
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
        this.abm = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qC() {
    }

    public void qZ() {
        this.aaM = new Paint();
        this.aaM.setAntiAlias(true);
        this.aaM.setStyle(Paint.Style.STROKE);
        this.aaM.setStrokeWidth(2.0f);
        this.aaN = new Paint();
        this.aaN.setAntiAlias(true);
        this.aaN.setStyle(Paint.Style.STROKE);
        this.aaN.setStrokeWidth(2.0f);
        this.aaO = new Paint();
        this.aaO.setAntiAlias(true);
        this.aaO.setStyle(Paint.Style.STROKE);
        this.aaO.setStrokeWidth(2.0f);
        this.aaP = new Paint();
        this.aaP.setAntiAlias(true);
        this.aaP.setStyle(Paint.Style.STROKE);
        this.aaP.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.aaM.setColor(this.aaU);
            this.aaN.setColor(this.aaV);
            this.aaO.setColor(this.aaW);
            this.aaP.setColor(this.aaX);
        } else {
            this.aaM.setColor(this.aaQ);
            this.aaN.setColor(this.aaR);
            this.aaO.setColor(this.aaS);
            this.aaP.setColor(this.aaT);
        }
        if (this.aaC == 2) {
            canvas.drawCircle(this.aaE, this.aaF, this.aaG, this.aaM);
        } else if (this.aaC == 3) {
            canvas.drawCircle(this.aaE, this.aaF, this.aaG, this.aaM);
            canvas.drawCircle(this.aaE, this.aaF, this.aaH, this.aaN);
        } else if (this.aaC == 4) {
            canvas.drawCircle(this.aaE, this.aaF, this.aaG, this.aaM);
            canvas.drawCircle(this.aaE, this.aaF, this.aaH, this.aaN);
            canvas.drawCircle(this.aaE, this.aaF, this.aaI, this.aaO);
        } else if (this.aaC == 5) {
            canvas.drawCircle(this.aaE, this.aaF, this.aaG, this.aaM);
            canvas.drawCircle(this.aaE, this.aaF, this.aaH, this.aaN);
            canvas.drawCircle(this.aaE, this.aaF, this.aaI, this.aaO);
            canvas.drawCircle(this.aaE, this.aaF, this.aaJ, this.aaP);
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
                    qW();
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
        return this.ZT;
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
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
