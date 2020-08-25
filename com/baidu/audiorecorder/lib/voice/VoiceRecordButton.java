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
    private com.baidu.tbadk.core.dialog.a aaB;
    private int aaq;
    private long aar;
    private EditorTools aay;
    private int aaz;
    private int abA;
    private int abB;
    private int abC;
    private int abD;
    private int abE;
    private final BitmapDrawable abF;
    private final Paint abG;
    private final Rect abH;
    private final RectF abI;
    private TextView abJ;
    private TextView abK;
    private TextView abL;
    private TextView abM;
    private VoiceButton abN;
    private ImageView abO;
    private TextView abP;
    private float abQ;
    private float abR;
    private f abS;
    private long abT;
    private long abU;
    private final int[] abV;
    private final a abW;
    private SweepGradient abX;
    private int abY;
    private final int[] aba;
    private int abb;
    private final int abd;
    private final int abe;
    private final int abf;
    private final int abg;
    private final int abh;
    private int abi;
    private int abj;
    private int abk;
    private int abl;
    private int abm;
    private int abn;
    private int abo;
    private int abp;
    private int abq;
    private int abr;
    private Paint abt;
    private Paint abu;
    private Paint abv;
    private Paint abw;
    private int abx;
    private int aby;
    private int abz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.abj;
        voiceRecordButton.abj = i + 1;
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
                if (VoiceRecordButton.this.abR >= 360.0f) {
                    VoiceRecordButton.this.abR = 360.0f;
                    VoiceRecordButton.this.abj = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.abT = uptimeMillis;
                    VoiceRecordButton.this.abU = uptimeMillis + 200;
                    VoiceRecordButton.this.abR += (((float) (uptimeMillis - VoiceRecordButton.this.abT)) / 1000.0f) * VoiceRecordButton.this.abQ;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.abU);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.abi = VoiceRecordButton.this.abj % 6;
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
        this.aar = 0L;
        this.aba = new int[4];
        this.abi = 0;
        this.abj = 0;
        this.abk = 0;
        this.abl = 0;
        this.abm = 0;
        this.abn = 0;
        this.abo = 0;
        this.abp = 0;
        this.abq = 0;
        this.abr = 0;
        this.abx = -1724676609;
        this.aby = 1546880511;
        this.abz = 674465279;
        this.abA = 255034879;
        this.abB = -1725669966;
        this.abC = 1545887154;
        this.abD = 673471922;
        this.abE = 254041522;
        this.abG = new Paint(1);
        this.abH = new Rect();
        this.abI = new RectF();
        this.aaz = 0;
        this.abV = new int[2];
        this.abW = new a();
        this.aaq = 0;
        this.abY = 0;
        this.aba[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.aba[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.aba[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.aba[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.abm = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.abn = this.abm + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abo = this.abn + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.abp = this.abo + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.abq = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.abr = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.abq = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.abr = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.abb = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.abd = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.abe = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abf = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.abg = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.abh = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.abG.setStyle(Paint.Style.STROKE);
        this.abG.setStrokeWidth(this.abg);
        this.abF = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        M(context);
        sy();
        this.abV[0] = ap.getColor(R.color.common_color_10151);
        this.abV[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.abN.getMeasuredWidth();
        int measuredHeight = this.abN.getMeasuredHeight();
        int measuredWidth2 = this.abK.getMeasuredWidth();
        this.abK.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.abK.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.abK.getBottom();
        this.abN.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.abk = (measuredWidth / 2) + i6;
        this.abl = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.abM.getMeasuredWidth();
        int measuredHeight2 = this.abM.getMeasuredHeight();
        int top = this.abN.getTop();
        this.abM.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.abJ.getMeasuredWidth();
        int measuredHeight3 = this.abJ.getMeasuredHeight();
        int right = this.abN.getRight() - this.abb;
        int bottom2 = this.abN.getBottom() - this.abd;
        this.abJ.layout(this.abq + i6, this.abr + bottom, measuredWidth4 + i6 + this.abq, measuredHeight3 + this.abr + bottom);
        int measuredWidth5 = this.abO.getMeasuredWidth();
        this.abO.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.abO.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.abP.getMeasuredWidth();
        this.abP.layout((i5 - measuredWidth6) >> 1, (this.abJ.getTop() - this.abP.getMeasuredHeight()) - this.abe, (measuredWidth6 + i5) >> 1, (this.abJ.getTop() + i2) - this.abe);
        this.abN.getLeft();
        this.abN.getRight();
        int measuredWidth7 = this.abL.getMeasuredWidth();
        int measuredHeight4 = this.abL.getMeasuredHeight();
        int bottom3 = this.abN.getBottom();
        this.abL.layout((i5 - measuredWidth7) >> 1, this.aba[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.aba[3]);
        this.abH.set((i5 - this.abF.getIntrinsicWidth()) >> 1, this.abO.getTop() - this.abf, (i5 + this.abF.getIntrinsicHeight()) >> 1, (this.abO.getTop() + this.abF.getIntrinsicHeight()) - this.abf);
        this.abF.setBounds(this.abH);
        this.abI.set(this.abO.getLeft() + (this.abg >> 1) + this.abh, this.abO.getTop() + (this.abg >> 1) + this.abh, (this.abO.getRight() - (this.abg >> 1)) - this.abh, (this.abO.getBottom() - (this.abg >> 1)) - this.abh);
        if (this.abX == null) {
            this.abX = new SweepGradient(this.abI.centerX(), this.abI.centerY(), this.abV, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.abX.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.abI.centerX(), this.abI.centerY());
            this.abX.setLocalMatrix(matrix);
            this.abG.setShader(this.abX);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void sm() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.aaB == null) {
            this.aaB = new com.baidu.tbadk.core.dialog.a(i.I(getContext()).getPageActivity());
            this.aaB.zz(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sw();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cT(VoiceRecordButton.this.mModel.voiceId);
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
            this.aaB.bhg();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cT(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.abK = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.abK, R.color.cp_cont_a, 1);
        this.abL = (TextView) findViewById(R.id.tip_operator);
        this.abM = (TextView) findViewById(R.id.tip_time_out);
        this.abN = (VoiceButton) findViewById(R.id.voice_bnt);
        this.abJ = (TextView) findViewById(R.id.restart);
        this.abO = (ImageView) findViewById(R.id.play_img);
        this.abP = (TextView) findViewById(R.id.play_time);
        this.abP.setClickable(false);
        this.abJ.setOnClickListener(this);
        this.abO.setOnClickListener(this);
        this.abN.setRecorderView(this);
        sw();
    }

    private void sv() {
        this.abN.setVisibility(4);
        this.abP.setVisibility(0);
        this.abJ.setVisibility(0);
        ap.setViewTextColor(this.abP, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.abJ, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.abJ, R.drawable.but_posts_record_again_selector);
        this.abO.setVisibility(0);
        if (this.mModel != null) {
            this.abP.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.abO.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.abO, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.abL, R.color.cp_cont_c, 1);
        this.abL.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw() {
        ap.setImageResource(this.abN, R.drawable.but_posts_record_zero_selector);
        this.abN.setVisibility(0);
        this.abi = 0;
        this.abO.setVisibility(4);
        this.abP.setVisibility(4);
        this.abJ.setVisibility(4);
        this.abM.setVisibility(4);
        ap.setViewTextColor(this.abL, R.color.cp_cont_c, 1);
        this.abL.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sw();
        this.mModel = null;
        this.abi = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.abK.setText("");
        this.abK.setVisibility(4);
        this.abi = 0;
        sv();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sw();
            this.abL.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.abO != null && this.abP != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.abP, R.color.cp_cont_f, 1);
                    this.abP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.abO, R.drawable.but_posts_record_play_selector);
                    this.abO.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.abL.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.abP, R.color.cp_cont_f, 1);
                    ap.setImageResource(this.abO, R.drawable.but_posts_record_stop_selector);
                    this.abO.setContentDescription(getContext().getString(R.string.pause_load));
                    this.abL.setText(getContext().getString(R.string.voice_stop_tip));
                    sx();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.abM, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.abK, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.abL, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.abM.setVisibility(0);
                this.abM.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abM != null) {
                            VoiceRecordButton.this.abM.setVisibility(4);
                            VoiceRecordButton.this.abM.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.abK.setVisibility(0);
                this.abK.setText(str);
                this.abL.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abK != null) {
                            VoiceRecordButton.this.abK.setVisibility(4);
                            VoiceRecordButton.this.abK.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.abK.setVisibility(0);
                this.abK.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abK != null) {
                            VoiceRecordButton.this.abK.setVisibility(4);
                            VoiceRecordButton.this.abK.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sw();
                this.abK.setVisibility(0);
                this.abK.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.abK != null) {
                            VoiceRecordButton.this.abK.setVisibility(4);
                            VoiceRecordButton.this.abK.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.abK.setVisibility(4);
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
        ap.setViewTextColor(this.abK, R.color.cp_cont_a, 1);
        this.abK.setVisibility(0);
        this.abK.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.aaq = Math.max(i, this.aaq);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.aar > 200) {
            this.aaq = 0;
            this.aar = uptimeMillis;
        }
        if (this.aaq < 10) {
            this.abi = 1;
            invalidate();
        } else if (this.aaq < 20) {
            this.abi = 2;
            invalidate();
        } else if (this.aaq < 30) {
            this.abi = 3;
            invalidate();
        } else if (this.aaq < 40) {
            this.abi = 4;
            invalidate();
        } else {
            this.abi = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bb(int i) {
        if (this.mModel != null && this.abP != null) {
            int i2 = i / 1000;
            if (this.abY != i2) {
                this.abP.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.abY = i2;
        }
    }

    private void sx() {
        if (this.mModel != null) {
            this.abi = 0;
            this.abQ = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.abT = SystemClock.uptimeMillis();
            this.abU = this.abT + 200;
            this.abW.sendEmptyMessageAtTime(1, this.abU);
            invalidate();
        }
    }

    private void stopProgress() {
        this.abi = 0;
        this.abj = 0;
        this.abQ = 0.0f;
        this.abR = 0.0f;
        this.abW.removeMessages(1);
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
        this.abS = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sb() {
    }

    public void sy() {
        this.abt = new Paint();
        this.abt.setAntiAlias(true);
        this.abt.setStyle(Paint.Style.STROKE);
        this.abt.setStrokeWidth(2.0f);
        this.abu = new Paint();
        this.abu.setAntiAlias(true);
        this.abu.setStyle(Paint.Style.STROKE);
        this.abu.setStrokeWidth(2.0f);
        this.abv = new Paint();
        this.abv.setAntiAlias(true);
        this.abv.setStyle(Paint.Style.STROKE);
        this.abv.setStrokeWidth(2.0f);
        this.abw = new Paint();
        this.abw.setAntiAlias(true);
        this.abw.setStyle(Paint.Style.STROKE);
        this.abw.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.abt.setColor(this.abB);
            this.abu.setColor(this.abC);
            this.abv.setColor(this.abD);
            this.abw.setColor(this.abE);
        } else {
            this.abt.setColor(this.abx);
            this.abu.setColor(this.aby);
            this.abv.setColor(this.abz);
            this.abw.setColor(this.abA);
        }
        if (this.abi == 2) {
            canvas.drawCircle(this.abk, this.abl, this.abm, this.abt);
        } else if (this.abi == 3) {
            canvas.drawCircle(this.abk, this.abl, this.abm, this.abt);
            canvas.drawCircle(this.abk, this.abl, this.abn, this.abu);
        } else if (this.abi == 4) {
            canvas.drawCircle(this.abk, this.abl, this.abm, this.abt);
            canvas.drawCircle(this.abk, this.abl, this.abn, this.abu);
            canvas.drawCircle(this.abk, this.abl, this.abo, this.abv);
        } else if (this.abi == 5) {
            canvas.drawCircle(this.abk, this.abl, this.abm, this.abt);
            canvas.drawCircle(this.abk, this.abl, this.abn, this.abu);
            canvas.drawCircle(this.abk, this.abl, this.abo, this.abv);
            canvas.drawCircle(this.abk, this.abl, this.abp, this.abw);
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
        return this.aaz;
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
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
