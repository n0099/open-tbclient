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
/* loaded from: classes7.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private int acP;
    private long acQ;
    private EditorTools acX;
    private int acY;
    private final int[] adD;
    private int adE;
    private int adF;
    private final int adG;
    private final int adH;
    private final int adI;
    private final int adJ;
    private final int adK;
    private int adL;
    private int adM;
    private int adN;
    private int adO;
    private int adP;
    private int adQ;
    private int adR;
    private int adS;
    private int adT;
    private int adU;
    private Paint adV;
    private Paint adW;
    private Paint adX;
    private Paint adY;
    private int adZ;
    private com.baidu.tbadk.core.dialog.a ada;
    private SweepGradient aeA;
    private int aeB;
    private int aea;
    private int aeb;
    private int aed;
    private int aee;
    private int aef;
    private int aeg;
    private int aeh;
    private final BitmapDrawable aei;
    private final Paint aej;
    private final Rect aek;
    private final RectF ael;
    private TextView aem;
    private TextView aen;
    private TextView aeo;
    private TextView aep;
    private VoiceButton aeq;
    private ImageView aer;
    private TextView aes;
    private float aet;
    private float aeu;
    private f aev;
    private long aew;
    private long aex;
    private final int[] aey;
    private final a aez;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.adM;
        voiceRecordButton.adM = i + 1;
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
                if (VoiceRecordButton.this.aeu >= 360.0f) {
                    VoiceRecordButton.this.aeu = 360.0f;
                    VoiceRecordButton.this.adM = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aew = uptimeMillis;
                    VoiceRecordButton.this.aex = uptimeMillis + 200;
                    VoiceRecordButton.this.aeu += (((float) (uptimeMillis - VoiceRecordButton.this.aew)) / 1000.0f) * VoiceRecordButton.this.aet;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aex);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.adL = VoiceRecordButton.this.adM % 6;
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
        this.acQ = 0L;
        this.adD = new int[4];
        this.adL = 0;
        this.adM = 0;
        this.adN = 0;
        this.adO = 0;
        this.adP = 0;
        this.adQ = 0;
        this.adR = 0;
        this.adS = 0;
        this.adT = 0;
        this.adU = 0;
        this.adZ = -1724676609;
        this.aea = 1546880511;
        this.aeb = 674465279;
        this.aed = 255034879;
        this.aee = -1725669966;
        this.aef = 1545887154;
        this.aeg = 673471922;
        this.aeh = 254041522;
        this.aej = new Paint(1);
        this.aek = new Rect();
        this.ael = new RectF();
        this.acY = 0;
        this.aey = new int[2];
        this.aez = new a();
        this.acP = 0;
        this.aeB = 0;
        this.adD[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.adD[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.adD[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.adD[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.adP = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.adQ = this.adP + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adR = this.adQ + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.adS = this.adR + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.adT = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.adU = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.adT = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.adU = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.adE = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.adF = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.adG = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adH = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adI = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adJ = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.adK = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aej.setStyle(Paint.Style.STROKE);
        this.aej.setStrokeWidth(this.adJ);
        this.aei = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        O(context);
        si();
        this.aey[0] = ao.getColor(R.color.common_color_10151);
        this.aey[1] = ao.getColor(R.color.common_color_10152);
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
        this.adE = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.aeq.getMeasuredWidth();
        int measuredHeight = this.aeq.getMeasuredHeight();
        int measuredWidth2 = this.aen.getMeasuredWidth();
        this.aen.layout((i5 - measuredWidth2) >> 1, this.adE + i2, (measuredWidth2 + i5) >> 1, this.aen.getMeasuredHeight() + this.adE + i2);
        int bottom = this.aen.getBottom();
        this.aeq.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.adN = (measuredWidth / 2) + i6;
        this.adO = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aep.getMeasuredWidth();
        int measuredHeight2 = this.aep.getMeasuredHeight();
        int top = this.aeq.getTop();
        this.aep.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.aem.getMeasuredWidth();
        int measuredHeight3 = this.aem.getMeasuredHeight();
        int right = this.aeq.getRight() - this.adF;
        int bottom2 = this.aeq.getBottom() - this.adG;
        this.aem.layout(this.adT + i6, this.adU + bottom, measuredWidth4 + i6 + this.adT, measuredHeight3 + this.adU + bottom);
        int measuredWidth5 = this.aer.getMeasuredWidth();
        this.aer.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aer.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aes.getMeasuredWidth();
        this.aes.layout((i5 - measuredWidth6) >> 1, (this.aem.getTop() - this.aes.getMeasuredHeight()) - this.adH, (measuredWidth6 + i5) >> 1, (this.aem.getTop() + i2) - this.adH);
        this.aeq.getLeft();
        this.aeq.getRight();
        int measuredWidth7 = this.aeo.getMeasuredWidth();
        int measuredHeight4 = this.aeo.getMeasuredHeight();
        int bottom3 = this.aeq.getBottom();
        this.aeo.layout((i5 - measuredWidth7) >> 1, this.adD[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.adD[3]);
        this.aek.set((i5 - this.aei.getIntrinsicWidth()) >> 1, this.aer.getTop() - this.adI, (i5 + this.aei.getIntrinsicHeight()) >> 1, (this.aer.getTop() + this.aei.getIntrinsicHeight()) - this.adI);
        this.aei.setBounds(this.aek);
        this.ael.set(this.aer.getLeft() + (this.adJ >> 1) + this.adK, this.aer.getTop() + (this.adJ >> 1) + this.adK, (this.aer.getRight() - (this.adJ >> 1)) - this.adK, (this.aer.getBottom() - (this.adJ >> 1)) - this.adK);
        if (this.aeA == null) {
            this.aeA = new SweepGradient(this.ael.centerX(), this.ael.centerY(), this.aey, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aeA.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ael.centerX(), this.ael.centerY());
            this.aeA.setLocalMatrix(matrix);
            this.aej.setShader(this.aeA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g(canvas);
        super.dispatchDraw(canvas);
    }

    private void rU() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.ada == null) {
            this.ada = new com.baidu.tbadk.core.dialog.a(j.K(getContext()).getPageActivity());
            this.ada.Ad(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
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
            this.ada.bqe();
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
        this.aen = (TextView) findViewById(R.id.tip_error);
        ao.setViewTextColor(this.aen, R.color.CAM_X0101, 1);
        this.aeo = (TextView) findViewById(R.id.tip_operator);
        this.aep = (TextView) findViewById(R.id.tip_time_out);
        this.aeq = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aem = (TextView) findViewById(R.id.restart);
        this.aer = (ImageView) findViewById(R.id.play_img);
        this.aes = (TextView) findViewById(R.id.play_time);
        this.aes.setClickable(false);
        this.aem.setOnClickListener(this);
        this.aer.setOnClickListener(this);
        this.aeq.setRecorderView(this);
        sf();
    }

    private void se() {
        this.aeq.setVisibility(4);
        this.aes.setVisibility(0);
        this.aem.setVisibility(0);
        ao.setViewTextColor(this.aes, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.aem, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.aem, R.drawable.but_posts_record_again_selector);
        this.aer.setVisibility(0);
        if (this.mModel != null) {
            this.aes.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aer.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ao.setImageResource(this.aer, R.drawable.but_posts_record_play_selector);
        }
        ao.setViewTextColor(this.aeo, R.color.CAM_X0108, 1);
        this.aeo.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf() {
        ao.setImageResource(this.aeq, R.drawable.but_posts_record_zero_selector);
        this.aeq.setVisibility(0);
        this.adL = 0;
        this.aer.setVisibility(4);
        this.aes.setVisibility(4);
        this.aem.setVisibility(4);
        this.aep.setVisibility(4);
        ao.setViewTextColor(this.aeo, R.color.CAM_X0301, 1);
        this.aeo.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sf();
        this.mModel = null;
        this.adL = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aen.setText("");
        this.aen.setVisibility(4);
        this.adL = 0;
        se();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sf();
            this.aeo.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aer != null && this.aes != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ao.setViewTextColor(this.aes, R.color.CAM_X0106, 1);
                    this.aes.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ao.setImageResource(this.aer, R.drawable.but_posts_record_play_selector);
                    this.aer.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aeo.setText(getContext().getString(R.string.voice_play_tip));
                    sh();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ao.setViewTextColor(this.aes, R.color.CAM_X0106, 1);
                    ao.setImageResource(this.aer, R.drawable.but_posts_record_stop_selector);
                    this.aer.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aeo.setText(getContext().getString(R.string.voice_stop_tip));
                    sg();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ao.setViewTextColor(this.aep, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.aen, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.aeo, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aep.setVisibility(0);
                this.aep.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aep != null) {
                            VoiceRecordButton.this.aep.setVisibility(4);
                            VoiceRecordButton.this.aep.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aen.setVisibility(0);
                this.aen.setText(str);
                this.aeo.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aen != null) {
                            VoiceRecordButton.this.aen.setVisibility(4);
                            VoiceRecordButton.this.aen.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aen.setVisibility(0);
                this.aen.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aen != null) {
                            VoiceRecordButton.this.aen.setVisibility(4);
                            VoiceRecordButton.this.aen.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sf();
                this.aen.setVisibility(0);
                this.aen.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aen != null) {
                            VoiceRecordButton.this.aen.setVisibility(4);
                            VoiceRecordButton.this.aen.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aen.setVisibility(4);
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
        ao.setViewTextColor(this.aen, R.color.CAM_X0101, 1);
        this.aen.setVisibility(0);
        this.aen.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acP = Math.max(i, this.acP);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acQ > 200) {
            this.acP = 0;
            this.acQ = uptimeMillis;
        }
        if (this.acP < 10) {
            this.adL = 1;
            invalidate();
        } else if (this.acP < 20) {
            this.adL = 2;
            invalidate();
        } else if (this.acP < 30) {
            this.adL = 3;
            invalidate();
        } else if (this.acP < 40) {
            this.adL = 4;
            invalidate();
        } else {
            this.adL = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (this.mModel != null && this.aes != null) {
            int i2 = i / 1000;
            if (this.aeB != i2) {
                this.aes.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aeB = i2;
        }
    }

    private void sg() {
        if (this.mModel != null) {
            this.adL = 0;
            this.aet = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aew = SystemClock.uptimeMillis();
            this.aex = this.aew + 200;
            this.aez.sendEmptyMessageAtTime(1, this.aex);
            invalidate();
        }
    }

    private void sh() {
        this.adL = 0;
        this.adM = 0;
        this.aet = 0.0f;
        this.aeu = 0.0f;
        this.aez.removeMessages(1);
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
        this.aev = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rJ() {
    }

    public void si() {
        this.adV = new Paint();
        this.adV.setAntiAlias(true);
        this.adV.setStyle(Paint.Style.STROKE);
        this.adV.setStrokeWidth(2.0f);
        this.adW = new Paint();
        this.adW.setAntiAlias(true);
        this.adW.setStyle(Paint.Style.STROKE);
        this.adW.setStrokeWidth(2.0f);
        this.adX = new Paint();
        this.adX.setAntiAlias(true);
        this.adX.setStyle(Paint.Style.STROKE);
        this.adX.setStrokeWidth(2.0f);
        this.adY = new Paint();
        this.adY.setAntiAlias(true);
        this.adY.setStyle(Paint.Style.STROKE);
        this.adY.setStrokeWidth(2.0f);
    }

    public void g(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.adV.setColor(this.aee);
            this.adW.setColor(this.aef);
            this.adX.setColor(this.aeg);
            this.adY.setColor(this.aeh);
        } else {
            this.adV.setColor(this.adZ);
            this.adW.setColor(this.aea);
            this.adX.setColor(this.aeb);
            this.adY.setColor(this.aed);
        }
        if (this.adL == 2) {
            canvas.drawCircle(this.adN, this.adO, this.adP, this.adV);
        } else if (this.adL == 3) {
            canvas.drawCircle(this.adN, this.adO, this.adP, this.adV);
            canvas.drawCircle(this.adN, this.adO, this.adQ, this.adW);
        } else if (this.adL == 4) {
            canvas.drawCircle(this.adN, this.adO, this.adP, this.adV);
            canvas.drawCircle(this.adN, this.adO, this.adQ, this.adW);
            canvas.drawCircle(this.adN, this.adO, this.adR, this.adX);
        } else if (this.adL == 5) {
            canvas.drawCircle(this.adN, this.adO, this.adP, this.adV);
            canvas.drawCircle(this.adN, this.adO, this.adQ, this.adW);
            canvas.drawCircle(this.adN, this.adO, this.adR, this.adX);
            canvas.drawCircle(this.adN, this.adO, this.adS, this.adY);
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
        return this.acY;
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
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
