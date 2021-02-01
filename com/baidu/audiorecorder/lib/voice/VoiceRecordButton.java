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
/* loaded from: classes8.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, n {
    private int acJ;
    private long acK;
    private EditorTools acR;
    private int acS;
    private com.baidu.tbadk.core.dialog.a acU;
    private final int adA;
    private final int adB;
    private final int adC;
    private final int adD;
    private int adE;
    private int adF;
    private int adG;
    private int adH;
    private int adI;
    private int adJ;
    private int adK;
    private int adL;
    private int adM;
    private int adN;
    private Paint adO;
    private Paint adP;
    private Paint adQ;
    private Paint adR;
    private int adS;
    private int adT;
    private int adU;
    private int adV;
    private int adW;
    private int adX;
    private int adY;
    private int adZ;
    private final int[] adx;
    private int ady;
    private final int adz;
    private final BitmapDrawable aea;
    private final Paint aeb;
    private final Rect aed;
    private final RectF aee;
    private TextView aef;
    private TextView aeg;
    private TextView aeh;
    private TextView aei;
    private VoiceButton aej;
    private ImageView aek;
    private TextView ael;
    private float aem;
    private float aen;
    private f aeo;
    private long aep;
    private long aeq;
    private final int[] aer;
    private final a aes;
    private SweepGradient aet;
    private int aeu;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.adF;
        voiceRecordButton.adF = i + 1;
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
                if (VoiceRecordButton.this.aen >= 360.0f) {
                    VoiceRecordButton.this.aen = 360.0f;
                    VoiceRecordButton.this.adF = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aep = uptimeMillis;
                    VoiceRecordButton.this.aeq = uptimeMillis + 200;
                    VoiceRecordButton.this.aen += (((float) (uptimeMillis - VoiceRecordButton.this.aep)) / 1000.0f) * VoiceRecordButton.this.aem;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aeq);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.adE = VoiceRecordButton.this.adF % 6;
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
        this.acK = 0L;
        this.adx = new int[4];
        this.adE = 0;
        this.adF = 0;
        this.adG = 0;
        this.adH = 0;
        this.adI = 0;
        this.adJ = 0;
        this.adK = 0;
        this.adL = 0;
        this.adM = 0;
        this.adN = 0;
        this.adS = -1724676609;
        this.adT = 1546880511;
        this.adU = 674465279;
        this.adV = 255034879;
        this.adW = -1725669966;
        this.adX = 1545887154;
        this.adY = 673471922;
        this.adZ = 254041522;
        this.aeb = new Paint(1);
        this.aed = new Rect();
        this.aee = new RectF();
        this.acS = 0;
        this.aer = new int[2];
        this.aes = new a();
        this.acJ = 0;
        this.aeu = 0;
        this.adx[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.adx[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.adx[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.adx[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.adI = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.adJ = this.adI + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adK = this.adJ + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.adL = this.adK + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.adM = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.adN = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.adM = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.adN = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ady = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.adz = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.adA = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adB = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.adC = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.adD = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aeb.setStyle(Paint.Style.STROKE);
        this.aeb.setStrokeWidth(this.adC);
        this.aea = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        O(context);
        sf();
        this.aer[0] = ap.getColor(R.color.common_color_10151);
        this.aer[1] = ap.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.aej.getMeasuredWidth();
        int measuredHeight = this.aej.getMeasuredHeight();
        int measuredWidth2 = this.aeg.getMeasuredWidth();
        this.aeg.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.aeg.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.aeg.getBottom();
        this.aej.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.adG = (measuredWidth / 2) + i6;
        this.adH = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aei.getMeasuredWidth();
        int measuredHeight2 = this.aei.getMeasuredHeight();
        int top = this.aej.getTop();
        this.aei.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.aef.getMeasuredWidth();
        int measuredHeight3 = this.aef.getMeasuredHeight();
        int right = this.aej.getRight() - this.ady;
        int bottom2 = this.aej.getBottom() - this.adz;
        this.aef.layout(this.adM + i6, this.adN + bottom, measuredWidth4 + i6 + this.adM, measuredHeight3 + this.adN + bottom);
        int measuredWidth5 = this.aek.getMeasuredWidth();
        this.aek.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aek.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.ael.getMeasuredWidth();
        this.ael.layout((i5 - measuredWidth6) >> 1, (this.aef.getTop() - this.ael.getMeasuredHeight()) - this.adA, (measuredWidth6 + i5) >> 1, (this.aef.getTop() + i2) - this.adA);
        this.aej.getLeft();
        this.aej.getRight();
        int measuredWidth7 = this.aeh.getMeasuredWidth();
        int measuredHeight4 = this.aeh.getMeasuredHeight();
        int bottom3 = this.aej.getBottom();
        this.aeh.layout((i5 - measuredWidth7) >> 1, this.adx[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.adx[3]);
        this.aed.set((i5 - this.aea.getIntrinsicWidth()) >> 1, this.aek.getTop() - this.adB, (i5 + this.aea.getIntrinsicHeight()) >> 1, (this.aek.getTop() + this.aea.getIntrinsicHeight()) - this.adB);
        this.aea.setBounds(this.aed);
        this.aee.set(this.aek.getLeft() + (this.adC >> 1) + this.adD, this.aek.getTop() + (this.adC >> 1) + this.adD, (this.aek.getRight() - (this.adC >> 1)) - this.adD, (this.aek.getBottom() - (this.adC >> 1)) - this.adD);
        if (this.aet == null) {
            this.aet = new SweepGradient(this.aee.centerX(), this.aee.centerY(), this.aer, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aet.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.aee.centerX(), this.aee.centerY());
            this.aet.setLocalMatrix(matrix);
            this.aeb.setShader(this.aet);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g(canvas);
        super.dispatchDraw(canvas);
    }

    private void rS() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.acU == null) {
            this.acU = new com.baidu.tbadk.core.dialog.a(j.K(getContext()).getPageActivity());
            this.acU.Au(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.sc();
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
            this.acU.bqx();
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
        this.aeg = (TextView) findViewById(R.id.tip_error);
        ap.setViewTextColor(this.aeg, R.color.CAM_X0101, 1);
        this.aeh = (TextView) findViewById(R.id.tip_operator);
        this.aei = (TextView) findViewById(R.id.tip_time_out);
        this.aej = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aef = (TextView) findViewById(R.id.restart);
        this.aek = (ImageView) findViewById(R.id.play_img);
        this.ael = (TextView) findViewById(R.id.play_time);
        this.ael.setClickable(false);
        this.aef.setOnClickListener(this);
        this.aek.setOnClickListener(this);
        this.aej.setRecorderView(this);
        sc();
    }

    private void sb() {
        this.aej.setVisibility(4);
        this.ael.setVisibility(0);
        this.aef.setVisibility(0);
        ap.setViewTextColor(this.ael, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.aef, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.aef, R.drawable.but_posts_record_again_selector);
        this.aek.setVisibility(0);
        if (this.mModel != null) {
            this.ael.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aek.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.setImageResource(this.aek, R.drawable.but_posts_record_play_selector);
        }
        ap.setViewTextColor(this.aeh, R.color.CAM_X0108, 1);
        this.aeh.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        ap.setImageResource(this.aej, R.drawable.but_posts_record_zero_selector);
        this.aej.setVisibility(0);
        this.adE = 0;
        this.aek.setVisibility(4);
        this.ael.setVisibility(4);
        this.aef.setVisibility(4);
        this.aei.setVisibility(4);
        ap.setViewTextColor(this.aeh, R.color.CAM_X0301, 1);
        this.aeh.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        sc();
        this.mModel = null;
        this.adE = 0;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aeg.setText("");
        this.aeg.setVisibility(4);
        this.adE = 0;
        sb();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            sc();
            this.aeh.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aek != null && this.ael != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.setViewTextColor(this.ael, R.color.CAM_X0106, 1);
                    this.ael.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.setImageResource(this.aek, R.drawable.but_posts_record_play_selector);
                    this.aek.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aeh.setText(getContext().getString(R.string.voice_play_tip));
                    se();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.setViewTextColor(this.ael, R.color.CAM_X0106, 1);
                    ap.setImageResource(this.aek, R.drawable.but_posts_record_stop_selector);
                    this.aek.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aeh.setText(getContext().getString(R.string.voice_stop_tip));
                    sd();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ap.setViewTextColor(this.aei, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.aeg, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.aeh, R.color.CAM_X0108, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aei.setVisibility(0);
                this.aei.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aei != null) {
                            VoiceRecordButton.this.aei.setVisibility(4);
                            VoiceRecordButton.this.aei.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aeg.setVisibility(0);
                this.aeg.setText(str);
                this.aeh.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aeg != null) {
                            VoiceRecordButton.this.aeg.setVisibility(4);
                            VoiceRecordButton.this.aeg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aeg.setVisibility(0);
                this.aeg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aeg != null) {
                            VoiceRecordButton.this.aeg.setVisibility(4);
                            VoiceRecordButton.this.aeg.setText("");
                        }
                    }
                }, 2000L);
            } else {
                sc();
                this.aeg.setVisibility(0);
                this.aeg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aeg != null) {
                            VoiceRecordButton.this.aeg.setVisibility(4);
                            VoiceRecordButton.this.aeg.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aeg.setVisibility(4);
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
        ap.setViewTextColor(this.aeg, R.color.CAM_X0101, 1);
        this.aeg.setVisibility(0);
        this.aeg.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.acJ = Math.max(i, this.acJ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.acK > 200) {
            this.acJ = 0;
            this.acK = uptimeMillis;
        }
        if (this.acJ < 10) {
            this.adE = 1;
            invalidate();
        } else if (this.acJ < 20) {
            this.adE = 2;
            invalidate();
        } else if (this.acJ < 30) {
            this.adE = 3;
            invalidate();
        } else if (this.acJ < 40) {
            this.adE = 4;
            invalidate();
        } else {
            this.adE = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (this.mModel != null && this.ael != null) {
            int i2 = i / 1000;
            if (this.aeu != i2) {
                this.ael.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aeu = i2;
        }
    }

    private void sd() {
        if (this.mModel != null) {
            this.adE = 0;
            this.aem = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aep = SystemClock.uptimeMillis();
            this.aeq = this.aep + 200;
            this.aes.sendEmptyMessageAtTime(1, this.aeq);
            invalidate();
        }
    }

    private void se() {
        this.adE = 0;
        this.adF = 0;
        this.aem = 0.0f;
        this.aen = 0.0f;
        this.aes.removeMessages(1);
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
        this.aeo = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rH() {
    }

    public void sf() {
        this.adO = new Paint();
        this.adO.setAntiAlias(true);
        this.adO.setStyle(Paint.Style.STROKE);
        this.adO.setStrokeWidth(2.0f);
        this.adP = new Paint();
        this.adP.setAntiAlias(true);
        this.adP.setStyle(Paint.Style.STROKE);
        this.adP.setStrokeWidth(2.0f);
        this.adQ = new Paint();
        this.adQ.setAntiAlias(true);
        this.adQ.setStyle(Paint.Style.STROKE);
        this.adQ.setStrokeWidth(2.0f);
        this.adR = new Paint();
        this.adR.setAntiAlias(true);
        this.adR.setStyle(Paint.Style.STROKE);
        this.adR.setStrokeWidth(2.0f);
    }

    public void g(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.adO.setColor(this.adW);
            this.adP.setColor(this.adX);
            this.adQ.setColor(this.adY);
            this.adR.setColor(this.adZ);
        } else {
            this.adO.setColor(this.adS);
            this.adP.setColor(this.adT);
            this.adQ.setColor(this.adU);
            this.adR.setColor(this.adV);
        }
        if (this.adE == 2) {
            canvas.drawCircle(this.adG, this.adH, this.adI, this.adO);
        } else if (this.adE == 3) {
            canvas.drawCircle(this.adG, this.adH, this.adI, this.adO);
            canvas.drawCircle(this.adG, this.adH, this.adJ, this.adP);
        } else if (this.adE == 4) {
            canvas.drawCircle(this.adG, this.adH, this.adI, this.adO);
            canvas.drawCircle(this.adG, this.adH, this.adJ, this.adP);
            canvas.drawCircle(this.adG, this.adH, this.adK, this.adQ);
        } else if (this.adE == 5) {
            canvas.drawCircle(this.adG, this.adH, this.adI, this.adO);
            canvas.drawCircle(this.adG, this.adH, this.adJ, this.adP);
            canvas.drawCircle(this.adG, this.adH, this.adK, this.adQ);
            canvas.drawCircle(this.adG, this.adH, this.adL, this.adR);
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
        return this.acS;
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
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
