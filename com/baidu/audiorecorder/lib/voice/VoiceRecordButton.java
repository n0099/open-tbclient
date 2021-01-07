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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes8.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private int acR;
    private long acS;
    private EditorTools acZ;
    private final int[] adF;
    private int adG;
    private int adH;
    private final int adI;
    private final int adJ;
    private final int adK;
    private final int adL;
    private final int adM;
    private int adN;
    private int adO;
    private int adP;
    private int adQ;
    private int adR;
    private int adS;
    private int adT;
    private int adU;
    private int adV;
    private int adW;
    private Paint adX;
    private Paint adY;
    private Paint adZ;
    private int ada;
    private com.baidu.tbadk.core.dialog.a adc;
    private final int[] aeA;
    private final a aeB;
    private SweepGradient aeC;
    private int aeD;
    private Paint aea;
    private int aeb;
    private int aed;
    private int aee;
    private int aef;
    private int aeg;
    private int aeh;
    private int aei;
    private int aej;
    private final BitmapDrawable aek;
    private final Paint ael;
    private final Rect aem;
    private final RectF aen;
    private TextView aeo;
    private TextView aep;
    private TextView aeq;
    private TextView aer;
    private VoiceButton aes;
    private ImageView aet;
    private TextView aeu;
    private float aev;
    private float aew;
    private f aex;
    private long aey;
    private long aez;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.adO;
        voiceRecordButton.adO = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.aew >= 360.0f) {
                    VoiceRecordButton.this.aew = 360.0f;
                    VoiceRecordButton.this.adO = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aey = uptimeMillis;
                    VoiceRecordButton.this.aez = uptimeMillis + 200;
                    VoiceRecordButton.this.aew += (((float) (uptimeMillis - VoiceRecordButton.this.aey)) / 1000.0f) * VoiceRecordButton.this.aev;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aez);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.adN = VoiceRecordButton.this.adO % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton N(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acS = 0L;
        this.adF = new int[4];
        this.adN = 0;
        this.adO = 0;
        this.adP = 0;
        this.adQ = 0;
        this.adR = 0;
        this.adS = 0;
        this.adT = 0;
        this.adU = 0;
        this.adV = 0;
        this.adW = 0;
        this.aeb = -1724676609;
        this.aed = 1546880511;
        this.aee = 674465279;
        this.aef = 255034879;
        this.aeg = -1725669966;
        this.aeh = 1545887154;
        this.aei = 673471922;
        this.aej = 254041522;
        this.ael = new Paint(1);
        this.aem = new Rect();
        this.aen = new RectF();
        this.ada = 0;
        this.aeA = new int[2];
        this.aeB = new a();
        this.acR = 0;
        this.aeD = 0;
        this.adF[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.adF[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.adF[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.adF[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.adR = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.adS = this.adR + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adT = this.adS + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.adU = this.adT + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.adV = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.adW = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.adV = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.adW = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.adG = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.adH = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.adI = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adJ = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adK = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adL = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.adM = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.ael.setStyle(Paint.Style.STROKE);
        this.ael.setStrokeWidth(this.adL);
        this.aek = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        O(context);
        si();
        this.aeA[0] = ao.getColor(R.color.common_color_10151);
        this.aeA[1] = ao.getColor(R.color.common_color_10152);
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
        this.adG = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.aes.getMeasuredWidth();
        int measuredHeight = this.aes.getMeasuredHeight();
        int measuredWidth2 = this.aep.getMeasuredWidth();
        this.aep.layout((i5 - measuredWidth2) >> 1, this.adG + i2, (measuredWidth2 + i5) >> 1, this.aep.getMeasuredHeight() + this.adG + i2);
        int bottom = this.aep.getBottom();
        this.aes.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.adP = (measuredWidth / 2) + i6;
        this.adQ = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aer.getMeasuredWidth();
        int measuredHeight2 = this.aer.getMeasuredHeight();
        int top = this.aes.getTop();
        this.aer.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.aeo.getMeasuredWidth();
        int measuredHeight3 = this.aeo.getMeasuredHeight();
        int right = this.aes.getRight() - this.adH;
        int bottom2 = this.aes.getBottom() - this.adI;
        this.aeo.layout(this.adV + i6, this.adW + bottom, measuredWidth4 + i6 + this.adV, measuredHeight3 + this.adW + bottom);
        int measuredWidth5 = this.aet.getMeasuredWidth();
        this.aet.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aet.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aeu.getMeasuredWidth();
        this.aeu.layout((i5 - measuredWidth6) >> 1, (this.aeo.getTop() - this.aeu.getMeasuredHeight()) - this.adJ, (measuredWidth6 + i5) >> 1, (this.aeo.getTop() + i2) - this.adJ);
        this.aes.getLeft();
        this.aes.getRight();
        int measuredWidth7 = this.aeq.getMeasuredWidth();
        int measuredHeight4 = this.aeq.getMeasuredHeight();
        int bottom3 = this.aes.getBottom();
        this.aeq.layout((i5 - measuredWidth7) >> 1, this.adF[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.adF[3]);
        this.aem.set((i5 - this.aek.getIntrinsicWidth()) >> 1, this.aet.getTop() - this.adK, (i5 + this.aek.getIntrinsicHeight()) >> 1, (this.aet.getTop() + this.aek.getIntrinsicHeight()) - this.adK);
        this.aek.setBounds(this.aem);
        this.aen.set(this.aet.getLeft() + (this.adL >> 1) + this.adM, this.aet.getTop() + (this.adL >> 1) + this.adM, (this.aet.getRight() - (this.adL >> 1)) - this.adM, (this.aet.getBottom() - (this.adL >> 1)) - this.adM);
        if (this.aeC == null) {
            this.aeC = new SweepGradient(this.aen.centerX(), this.aen.centerY(), this.aeA, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aeC.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.aen.centerX(), this.aen.centerY());
            this.aeC.setLocalMatrix(matrix);
            this.ael.setShader(this.aeC);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g(canvas);
        super.dispatchDraw(canvas);
    }

    private void rU() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.adc == null) {
            this.adc = new com.baidu.tbadk.core.dialog.a(j.K(getContext()).getPageActivity());
            this.adc.Bo(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sf();
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
            }).b(j.K(getContext()));
        }
        try {
            this.adc.btY();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cU(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void O(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.aep = (TextView) findViewById(R.id.tip_error);
        ao.setViewTextColor(this.aep, R.color.CAM_X0101, 1);
        this.aeq = (TextView) findViewById(R.id.tip_operator);
        this.aer = (TextView) findViewById(R.id.tip_time_out);
        this.aes = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aeo = (TextView) findViewById(R.id.restart);
        this.aet = (ImageView) findViewById(R.id.play_img);
        this.aeu = (TextView) findViewById(R.id.play_time);
        this.aeu.setClickable(false);
        this.aeo.setOnClickListener(this);
        this.aet.setOnClickListener(this);
        this.aes.setRecorderView(this);
        sf();
    }

    private void se() {
        this.aes.setVisibility(4);
        this.aeu.setVisibility(0);
        this.aeo.setVisibility(0);
        ao.setViewTextColor(this.aeu, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.aeo, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.aeo, R.drawable.but_posts_record_again_selector);
        this.aet.setVisibility(0);
        if (this.mModel != null) {
            this.aeu.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aet.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ao.setImageResource(this.aet, R.drawable.but_posts_record_play_selector);
        }
        ao.setViewTextColor(this.aeq, R.color.CAM_X0108, 1);
        this.aeq.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf() {
        ao.setImageResource(this.aes, R.drawable.but_posts_record_zero_selector);
        this.aes.setVisibility(0);
        this.adN = 0;
        this.aet.setVisibility(4);
        this.aeu.setVisibility(4);
        this.aeo.setVisibility(4);
        this.aer.setVisibility(4);
        ao.setViewTextColor(this.aeq, R.color.CAM_X0301, 1);
        this.aeq.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sf();
        this.mModel = null;
        this.adN = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aep.setText("");
        this.aep.setVisibility(4);
        this.adN = 0;
        se();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sf();
            this.aeq.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aet != null && this.aeu != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ao.setViewTextColor(this.aeu, R.color.CAM_X0106, 1);
                    this.aeu.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ao.setImageResource(this.aet, R.drawable.but_posts_record_play_selector);
                    this.aet.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aeq.setText(getContext().getString(R.string.voice_play_tip));
                    sh();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ao.setViewTextColor(this.aeu, R.color.CAM_X0106, 1);
                    ao.setImageResource(this.aet, R.drawable.but_posts_record_stop_selector);
                    this.aet.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aeq.setText(getContext().getString(R.string.voice_stop_tip));
                    sg();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ao.setViewTextColor(this.aer, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.aep, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.aeq, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aer.setVisibility(0);
                this.aer.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aer != null) {
                            VoiceRecordButton.this.aer.setVisibility(4);
                            VoiceRecordButton.this.aer.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aep.setVisibility(0);
                this.aep.setText(str);
                this.aeq.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aep != null) {
                            VoiceRecordButton.this.aep.setVisibility(4);
                            VoiceRecordButton.this.aep.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aep.setVisibility(0);
                this.aep.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aep != null) {
                            VoiceRecordButton.this.aep.setVisibility(4);
                            VoiceRecordButton.this.aep.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sf();
                this.aep.setVisibility(0);
                this.aep.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aep != null) {
                            VoiceRecordButton.this.aep.setVisibility(4);
                            VoiceRecordButton.this.aep.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aep.setVisibility(4);
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
        ao.setViewTextColor(this.aep, R.color.CAM_X0101, 1);
        this.aep.setVisibility(0);
        this.aep.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acR = Math.max(i, this.acR);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acS > 200) {
            this.acR = 0;
            this.acS = uptimeMillis;
        }
        if (this.acR < 10) {
            this.adN = 1;
            invalidate();
        } else if (this.acR < 20) {
            this.adN = 2;
            invalidate();
        } else if (this.acR < 30) {
            this.adN = 3;
            invalidate();
        } else if (this.acR < 40) {
            this.adN = 4;
            invalidate();
        } else {
            this.adN = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (this.mModel != null && this.aeu != null) {
            int i2 = i / 1000;
            if (this.aeD != i2) {
                this.aeu.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aeD = i2;
        }
    }

    private void sg() {
        if (this.mModel != null) {
            this.adN = 0;
            this.aev = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aey = SystemClock.uptimeMillis();
            this.aez = this.aey + 200;
            this.aeB.sendEmptyMessageAtTime(1, this.aez);
            invalidate();
        }
    }

    private void sh() {
        this.adN = 0;
        this.adO = 0;
        this.aev = 0.0f;
        this.aew = 0.0f;
        this.aeB.removeMessages(1);
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
                rU();
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
        this.aex = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rJ() {
    }

    public void si() {
        this.adX = new Paint();
        this.adX.setAntiAlias(true);
        this.adX.setStyle(Paint.Style.STROKE);
        this.adX.setStrokeWidth(2.0f);
        this.adY = new Paint();
        this.adY.setAntiAlias(true);
        this.adY.setStyle(Paint.Style.STROKE);
        this.adY.setStrokeWidth(2.0f);
        this.adZ = new Paint();
        this.adZ.setAntiAlias(true);
        this.adZ.setStyle(Paint.Style.STROKE);
        this.adZ.setStrokeWidth(2.0f);
        this.aea = new Paint();
        this.aea.setAntiAlias(true);
        this.aea.setStyle(Paint.Style.STROKE);
        this.aea.setStrokeWidth(2.0f);
    }

    public void g(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.adX.setColor(this.aeg);
            this.adY.setColor(this.aeh);
            this.adZ.setColor(this.aei);
            this.aea.setColor(this.aej);
        } else {
            this.adX.setColor(this.aeb);
            this.adY.setColor(this.aed);
            this.adZ.setColor(this.aee);
            this.aea.setColor(this.aef);
        }
        if (this.adN == 2) {
            canvas.drawCircle(this.adP, this.adQ, this.adR, this.adX);
        } else if (this.adN == 3) {
            canvas.drawCircle(this.adP, this.adQ, this.adR, this.adX);
            canvas.drawCircle(this.adP, this.adQ, this.adS, this.adY);
        } else if (this.adN == 4) {
            canvas.drawCircle(this.adP, this.adQ, this.adR, this.adX);
            canvas.drawCircle(this.adP, this.adQ, this.adS, this.adY);
            canvas.drawCircle(this.adP, this.adQ, this.adT, this.adZ);
        } else if (this.adN == 5) {
            canvas.drawCircle(this.adP, this.adQ, this.adR, this.adX);
            canvas.drawCircle(this.adP, this.adQ, this.adS, this.adY);
            canvas.drawCircle(this.adP, this.adQ, this.adT, this.adZ);
            canvas.drawCircle(this.adP, this.adQ, this.adU, this.aea);
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
                    se();
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
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
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
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
