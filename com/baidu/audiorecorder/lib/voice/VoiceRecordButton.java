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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes11.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private final int[] ZV;
    private int ZW;
    private final int ZX;
    private final int ZY;
    private final int ZZ;
    private int Zl;
    private long Zm;
    private EditorTools Zt;
    private int Zu;
    private com.baidu.tbadk.core.dialog.a Zw;
    private final Paint aaA;
    private final Rect aaB;
    private final RectF aaC;
    private TextView aaD;
    private TextView aaE;
    private TextView aaF;
    private TextView aaG;
    private VoiceButton aaH;
    private ImageView aaI;
    private TextView aaJ;
    private float aaK;
    private float aaL;
    private f aaM;
    private long aaN;
    private long aaO;
    private final int[] aaP;
    private final a aaQ;
    private SweepGradient aaR;
    private int aaS;
    private final int aaa;
    private final int aab;
    private int aac;
    private int aae;
    private int aaf;
    private int aag;
    private int aah;
    private int aai;
    private int aaj;
    private int aak;
    private int aal;
    private int aam;
    private Paint aan;
    private Paint aao;
    private Paint aap;
    private Paint aaq;
    private int aar;
    private int aas;
    private int aat;
    private int aau;
    private int aav;
    private int aaw;
    private int aax;
    private int aay;
    private final BitmapDrawable aaz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.aae;
        voiceRecordButton.aae = i + 1;
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
                if (VoiceRecordButton.this.aaL >= 360.0f) {
                    VoiceRecordButton.this.aaL = 360.0f;
                    VoiceRecordButton.this.aae = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aaN = uptimeMillis;
                    VoiceRecordButton.this.aaO = uptimeMillis + 200;
                    VoiceRecordButton.this.aaL += (((float) (uptimeMillis - VoiceRecordButton.this.aaN)) / 1000.0f) * VoiceRecordButton.this.aaK;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aaO);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.aac = VoiceRecordButton.this.aae % 6;
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
        this.Zm = 0L;
        this.ZV = new int[4];
        this.aac = 0;
        this.aae = 0;
        this.aaf = 0;
        this.aag = 0;
        this.aah = 0;
        this.aai = 0;
        this.aaj = 0;
        this.aak = 0;
        this.aal = 0;
        this.aam = 0;
        this.aar = -1724676609;
        this.aas = 1546880511;
        this.aat = 674465279;
        this.aau = 255034879;
        this.aav = -1725669966;
        this.aaw = 1545887154;
        this.aax = 673471922;
        this.aay = 254041522;
        this.aaA = new Paint(1);
        this.aaB = new Rect();
        this.aaC = new RectF();
        this.Zu = 0;
        this.aaP = new int[2];
        this.aaQ = new a();
        this.Zl = 0;
        this.aaS = 0;
        this.ZV[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ZV[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ZV[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.ZV[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.aah = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.aai = this.aah + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.aaj = this.aai + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.aak = this.aaj + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.aal = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.aam = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.aal = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.aam = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ZW = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ZX = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ZY = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ZZ = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.aaa = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.aab = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aaA.setStyle(Paint.Style.STROKE);
        this.aaA.setStrokeWidth(this.aaa);
        this.aaz = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        K(context);
        qG();
        this.aaP[0] = am.getColor(R.color.common_color_10151);
        this.aaP[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.aaH.getMeasuredWidth();
        int measuredHeight = this.aaH.getMeasuredHeight();
        int measuredWidth2 = this.aaE.getMeasuredWidth();
        this.aaE.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.aaE.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.aaE.getBottom();
        this.aaH.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.aaf = (measuredWidth / 2) + i6;
        this.aag = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aaG.getMeasuredWidth();
        int measuredHeight2 = this.aaG.getMeasuredHeight();
        int top2 = this.aaH.getTop();
        this.aaG.layout((i5 - measuredWidth3) >> 1, top2 - measuredHeight2, (measuredWidth3 + i5) >> 1, top2);
        int measuredWidth4 = this.aaD.getMeasuredWidth();
        int measuredHeight3 = this.aaD.getMeasuredHeight();
        int right = this.aaH.getRight() - this.ZW;
        int bottom2 = this.aaH.getBottom() - this.ZX;
        this.aaD.layout(this.aal + i6, this.aam + bottom, measuredWidth4 + i6 + this.aal, measuredHeight3 + this.aam + bottom);
        int measuredWidth5 = this.aaI.getMeasuredWidth();
        this.aaI.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aaI.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aaJ.getMeasuredWidth();
        this.aaJ.layout((i5 - measuredWidth6) >> 1, (this.aaD.getTop() - this.aaJ.getMeasuredHeight()) - this.ZY, (measuredWidth6 + i5) >> 1, (this.aaD.getTop() + i2) - this.ZY);
        this.aaH.getLeft();
        this.aaH.getRight();
        int measuredWidth7 = this.aaF.getMeasuredWidth();
        int measuredHeight4 = this.aaF.getMeasuredHeight();
        int bottom3 = this.aaH.getBottom();
        this.aaF.layout((i5 - measuredWidth7) >> 1, this.ZV[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ZV[3]);
        this.aaB.set((i5 - this.aaz.getIntrinsicWidth()) >> 1, this.aaI.getTop() - this.ZZ, (i5 + this.aaz.getIntrinsicHeight()) >> 1, (this.aaI.getTop() + this.aaz.getIntrinsicHeight()) - this.ZZ);
        this.aaz.setBounds(this.aaB);
        this.aaC.set(this.aaI.getLeft() + (this.aaa >> 1) + this.aab, this.aaI.getTop() + (this.aaa >> 1) + this.aab, (this.aaI.getRight() - (this.aaa >> 1)) - this.aab, (this.aaI.getBottom() - (this.aaa >> 1)) - this.aab);
        if (this.aaR == null) {
            this.aaR = new SweepGradient(this.aaC.centerX(), this.aaC.centerY(), this.aaP, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aaR.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.aaC.centerX(), this.aaC.centerY());
            this.aaR.setLocalMatrix(matrix);
            this.aaA.setShader(this.aaR);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qt() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Zw == null) {
            this.Zw = new com.baidu.tbadk.core.dialog.a(i.G(getContext()).getPageActivity());
            this.Zw.vO(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qD();
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
            this.Zw.aST();
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
        this.aaE = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.aaE, R.color.cp_cont_a, 1);
        this.aaF = (TextView) findViewById(R.id.tip_operator);
        this.aaG = (TextView) findViewById(R.id.tip_time_out);
        this.aaH = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aaD = (TextView) findViewById(R.id.restart);
        this.aaI = (ImageView) findViewById(R.id.play_img);
        this.aaJ = (TextView) findViewById(R.id.play_time);
        this.aaJ.setClickable(false);
        this.aaD.setOnClickListener(this);
        this.aaI.setOnClickListener(this);
        this.aaH.setRecorderView(this);
        qD();
    }

    private void qC() {
        this.aaH.setVisibility(4);
        this.aaJ.setVisibility(0);
        this.aaD.setVisibility(0);
        am.setViewTextColor(this.aaJ, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.aaD, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.aaD, R.drawable.but_posts_record_again_selector);
        this.aaI.setVisibility(0);
        if (this.mModel != null) {
            this.aaJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aaI.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.aaI, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.aaF, R.color.cp_cont_c, 1);
        this.aaF.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qD() {
        am.setImageResource(this.aaH, R.drawable.but_posts_record_zero_selector);
        this.aaH.setVisibility(0);
        this.aac = 0;
        this.aaI.setVisibility(4);
        this.aaJ.setVisibility(4);
        this.aaD.setVisibility(4);
        this.aaG.setVisibility(4);
        am.setViewTextColor(this.aaF, R.color.cp_cont_c, 1);
        this.aaF.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qD();
        this.mModel = null;
        this.aac = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aaE.setText("");
        this.aaE.setVisibility(4);
        this.aac = 0;
        qC();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qD();
            this.aaF.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aaI != null && this.aaJ != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.aaJ, R.color.cp_cont_f, 1);
                    this.aaJ.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.aaI, R.drawable.but_posts_record_play_selector);
                    this.aaI.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aaF.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.aaJ, R.color.cp_cont_f, 1);
                    am.setImageResource(this.aaI, R.drawable.but_posts_record_stop_selector);
                    this.aaI.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aaF.setText(getContext().getString(R.string.voice_stop_tip));
                    qE();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.aaG, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aaE, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aaF, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aaG.setVisibility(0);
                this.aaG.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aaG != null) {
                            VoiceRecordButton.this.aaG.setVisibility(4);
                            VoiceRecordButton.this.aaG.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aaE.setVisibility(0);
                this.aaE.setText(str);
                this.aaF.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aaE != null) {
                            VoiceRecordButton.this.aaE.setVisibility(4);
                            VoiceRecordButton.this.aaE.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aaE.setVisibility(0);
                this.aaE.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aaE != null) {
                            VoiceRecordButton.this.aaE.setVisibility(4);
                            VoiceRecordButton.this.aaE.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qD();
                this.aaE.setVisibility(0);
                this.aaE.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aaE != null) {
                            VoiceRecordButton.this.aaE.setVisibility(4);
                            VoiceRecordButton.this.aaE.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aaE.setVisibility(4);
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
        am.setViewTextColor(this.aaE, R.color.cp_cont_a, 1);
        this.aaE.setVisibility(0);
        this.aaE.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Zl = Math.max(i, this.Zl);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Zm > 200) {
            this.Zl = 0;
            this.Zm = uptimeMillis;
        }
        if (this.Zl < 10) {
            this.aac = 1;
            invalidate();
        } else if (this.Zl < 20) {
            this.aac = 2;
            invalidate();
        } else if (this.Zl < 30) {
            this.aac = 3;
            invalidate();
        } else if (this.Zl < 40) {
            this.aac = 4;
            invalidate();
        } else {
            this.aac = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (this.mModel != null && this.aaJ != null) {
            int i2 = i / 1000;
            if (this.aaS != i2) {
                this.aaJ.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aaS = i2;
        }
    }

    private void qE() {
        if (this.mModel != null) {
            this.aac = 0;
            this.aaK = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aaN = SystemClock.uptimeMillis();
            this.aaO = this.aaN + 200;
            this.aaQ.sendEmptyMessageAtTime(1, this.aaO);
            invalidate();
        }
    }

    private void stopProgress() {
        this.aac = 0;
        this.aae = 0;
        this.aaK = 0.0f;
        this.aaL = 0.0f;
        this.aaQ.removeMessages(1);
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
                qt();
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
        this.aaM = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qF() {
    }

    public void qG() {
        this.aan = new Paint();
        this.aan.setAntiAlias(true);
        this.aan.setStyle(Paint.Style.STROKE);
        this.aan.setStrokeWidth(2.0f);
        this.aao = new Paint();
        this.aao.setAntiAlias(true);
        this.aao.setStyle(Paint.Style.STROKE);
        this.aao.setStrokeWidth(2.0f);
        this.aap = new Paint();
        this.aap.setAntiAlias(true);
        this.aap.setStyle(Paint.Style.STROKE);
        this.aap.setStrokeWidth(2.0f);
        this.aaq = new Paint();
        this.aaq.setAntiAlias(true);
        this.aaq.setStyle(Paint.Style.STROKE);
        this.aaq.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.aan.setColor(this.aav);
            this.aao.setColor(this.aaw);
            this.aap.setColor(this.aax);
            this.aaq.setColor(this.aay);
        } else {
            this.aan.setColor(this.aar);
            this.aao.setColor(this.aas);
            this.aap.setColor(this.aat);
            this.aaq.setColor(this.aau);
        }
        if (this.aac == 2) {
            canvas.drawCircle(this.aaf, this.aag, this.aah, this.aan);
        } else if (this.aac == 3) {
            canvas.drawCircle(this.aaf, this.aag, this.aah, this.aan);
            canvas.drawCircle(this.aaf, this.aag, this.aai, this.aao);
        } else if (this.aac == 4) {
            canvas.drawCircle(this.aaf, this.aag, this.aah, this.aan);
            canvas.drawCircle(this.aaf, this.aag, this.aai, this.aao);
            canvas.drawCircle(this.aaf, this.aag, this.aaj, this.aap);
        } else if (this.aac == 5) {
            canvas.drawCircle(this.aaf, this.aag, this.aah, this.aan);
            canvas.drawCircle(this.aaf, this.aag, this.aai, this.aao);
            canvas.drawCircle(this.aaf, this.aag, this.aaj, this.aap);
            canvas.drawCircle(this.aaf, this.aag, this.aak, this.aaq);
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
                    qC();
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
        return this.Zu;
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
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
