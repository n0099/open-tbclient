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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes3.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int JK;
    private long JL;
    private EditorTools JS;
    private int JT;
    private com.baidu.tbadk.core.dialog.a JV;
    private final int KA;
    private final int KC;
    private final int KD;
    private final int KE;
    private int KF;
    private int KG;
    private int KH;
    private int KI;
    private int KJ;
    private int KK;
    private int KL;
    private int KM;
    private Paint KN;
    private Paint KO;
    private Paint KP;
    private Paint KQ;
    private int KR;
    private int KS;
    private int KT;
    private int KU;
    private int KV;
    private int KW;
    private int KX;
    private int KY;
    private final BitmapDrawable KZ;
    private final int[] Kx;
    private int Ky;
    private final int Kz;
    private final Paint La;
    private final Rect Lb;
    private final RectF Lc;
    private TextView Ld;
    private TextView Le;
    private TextView Lf;
    private TextView Lg;
    private VoiceButton Lh;
    private ImageView Li;
    private TextView Lj;
    private float Lk;
    private float Ll;
    private f Lm;
    private long Ln;
    private long Lo;
    private final int[] Lp;
    private final a Lq;
    private SweepGradient Lr;
    private int Ls;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.KG;
        voiceRecordButton.KG = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.Ll >= 360.0f) {
                    VoiceRecordButton.this.Ll = 360.0f;
                    VoiceRecordButton.this.KG = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Ln = uptimeMillis;
                    VoiceRecordButton.this.Lo = uptimeMillis + 200;
                    VoiceRecordButton.this.Ll += (((float) (uptimeMillis - VoiceRecordButton.this.Ln)) / 1000.0f) * VoiceRecordButton.this.Lk;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Lo);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.KF = VoiceRecordButton.this.KG % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton al(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JL = 0L;
        this.Kx = new int[4];
        this.KF = 0;
        this.KG = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.KH = 0;
        this.KI = 0;
        this.KJ = 0;
        this.KK = 0;
        this.KL = 0;
        this.KM = 0;
        this.KR = -1724676609;
        this.KS = 1546880511;
        this.KT = 674465279;
        this.KU = 255034879;
        this.KV = -1725669966;
        this.KW = 1545887154;
        this.KX = 673471922;
        this.KY = 254041522;
        this.La = new Paint(1);
        this.Lb = new Rect();
        this.Lc = new RectF();
        this.JT = 0;
        this.Lp = new int[2];
        this.Lq = new a();
        this.JK = 0;
        this.Ls = 0;
        this.Kx[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Kx[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Kx[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Kx[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.KH = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.KI = this.KH + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.KJ = this.KI + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.KK = this.KJ + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.KL = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.KM = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.KL = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.KM = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Ky = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.Kz = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.KA = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.KC = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.KD = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.KE = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.La.setStyle(Paint.Style.STROKE);
        this.La.setStrokeWidth(this.KD);
        this.KZ = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        am(context);
        ma();
        this.Lp[0] = ak.getColor(d.C0126d.common_color_10151);
        this.Lp[1] = ak.getColor(d.C0126d.common_color_10152);
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
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Lh.getMeasuredWidth();
        int measuredHeight = this.Lh.getMeasuredHeight();
        int measuredWidth2 = this.Le.getMeasuredWidth();
        this.Le.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Le.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Le.getBottom();
        this.Lh.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Lg.getMeasuredWidth();
        int measuredHeight2 = this.Lg.getMeasuredHeight();
        int top = this.Lh.getTop();
        this.Lg.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ld.getMeasuredWidth();
        int measuredHeight3 = this.Ld.getMeasuredHeight();
        int right = this.Lh.getRight() - this.Ky;
        int bottom2 = this.Lh.getBottom() - this.Kz;
        this.Ld.layout(this.KL + i6, this.KM + bottom, measuredWidth4 + i6 + this.KL, measuredHeight3 + this.KM + bottom);
        int measuredWidth5 = this.Li.getMeasuredWidth();
        this.Li.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Li.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Lj.getMeasuredWidth();
        this.Lj.layout((i5 - measuredWidth6) >> 1, (this.Ld.getTop() - this.Lj.getMeasuredHeight()) - this.KA, (measuredWidth6 + i5) >> 1, (this.Ld.getTop() + i2) - this.KA);
        this.Lh.getLeft();
        this.Lh.getRight();
        int measuredWidth7 = this.Lf.getMeasuredWidth();
        int measuredHeight4 = this.Lf.getMeasuredHeight();
        int bottom3 = this.Lh.getBottom();
        this.Lf.layout((i5 - measuredWidth7) >> 1, this.Kx[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Kx[3]);
        this.Lb.set((i5 - this.KZ.getIntrinsicWidth()) >> 1, this.Li.getTop() - this.KC, (i5 + this.KZ.getIntrinsicHeight()) >> 1, (this.Li.getTop() + this.KZ.getIntrinsicHeight()) - this.KC);
        this.KZ.setBounds(this.Lb);
        this.Lc.set(this.Li.getLeft() + (this.KD >> 1) + this.KE, this.Li.getTop() + (this.KD >> 1) + this.KE, (this.Li.getRight() - (this.KD >> 1)) - this.KE, (this.Li.getBottom() - (this.KD >> 1)) - this.KE);
        if (this.Lr == null) {
            this.Lr = new SweepGradient(this.Lc.centerX(), this.Lc.centerY(), this.Lp, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Lr.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Lc.centerX(), this.Lc.centerY());
            this.Lr.setLocalMatrix(matrix);
            this.La.setShader(this.Lr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lM() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.JV == null) {
            this.JV = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.JV.dc(getContext().getString(d.k.voice_restart_tip)).a(getContext().getString(d.k.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lW();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bO(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        try {
            this.JV.tD();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bO(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void am(Context context) {
        LayoutInflater.from(context).inflate(d.i.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Le = (TextView) findViewById(d.g.tip_error);
        ak.c(this.Le, d.C0126d.cp_cont_i, 1);
        this.Lf = (TextView) findViewById(d.g.tip_operator);
        this.Lg = (TextView) findViewById(d.g.tip_time_out);
        this.Lh = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Ld = (TextView) findViewById(d.g.restart);
        this.Li = (ImageView) findViewById(d.g.play_img);
        this.Lj = (TextView) findViewById(d.g.play_time);
        this.Lj.setClickable(false);
        this.Ld.setOnClickListener(this);
        this.Li.setOnClickListener(this);
        this.Lh.setRecorderView(this);
        lW();
    }

    private void lV() {
        this.Lh.setVisibility(4);
        this.Lj.setVisibility(0);
        this.Ld.setVisibility(0);
        ak.c(this.Lj, d.C0126d.cp_cont_f, 1);
        ak.c(this.Ld, d.C0126d.cp_cont_f, 1);
        ak.i(this.Ld, d.f.but_posts_record_again_selector);
        this.Li.setVisibility(0);
        if (this.mModel != null) {
            this.Lj.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Li.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(this.mModel.duration)));
            ak.c(this.Li, d.f.but_posts_record_play_selector);
        }
        ak.c(this.Lf, d.C0126d.cp_cont_c, 1);
        this.Lf.setText(getContext().getString(d.k.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW() {
        ak.c(this.Lh, d.f.but_posts_record_zero_selector);
        this.Lh.setVisibility(0);
        this.KF = 0;
        this.Li.setVisibility(4);
        this.Lj.setVisibility(4);
        this.Ld.setVisibility(4);
        this.Lg.setVisibility(4);
        ak.c(this.Lf, d.C0126d.cp_cont_c, 1);
        this.Lf.setText(getContext().getString(d.k.voice_record_press_to_record));
    }

    public void reset() {
        lW();
        this.mModel = null;
        this.KF = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Le.setText("");
        this.Le.setVisibility(4);
        this.KF = 0;
        lV();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lW();
            this.Lf.setText(getContext().getString(d.k.voice_record_release_to_stop));
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
        if (this.Li != null && this.Lj != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ak.c(this.Lj, d.C0126d.cp_cont_f, 1);
                    this.Lj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ak.c(this.Li, d.f.but_posts_record_play_selector);
                    this.Li.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Lf.setText(getContext().getString(d.k.voice_play_tip));
                    lY();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ak.c(this.Lj, d.C0126d.cp_cont_f, 1);
                    ak.c(this.Li, d.f.but_posts_record_stop_selector);
                    this.Li.setContentDescription(getContext().getString(d.k.pause_load));
                    this.Lf.setText(getContext().getString(d.k.voice_stop_tip));
                    lX();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ak.c(this.Lg, d.C0126d.cp_cont_i, 1);
        ak.c(this.Le, d.C0126d.cp_cont_i, 1);
        ak.c(this.Lf, d.C0126d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Lg.setVisibility(0);
                this.Lg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Lg != null) {
                            VoiceRecordButton.this.Lg.setVisibility(4);
                            VoiceRecordButton.this.Lg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Le.setVisibility(0);
                this.Le.setText(str);
                this.Lf.setText(d.k.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Le != null) {
                            VoiceRecordButton.this.Le.setVisibility(4);
                            VoiceRecordButton.this.Le.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Le.setVisibility(0);
                this.Le.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Le != null) {
                            VoiceRecordButton.this.Le.setVisibility(4);
                            VoiceRecordButton.this.Le.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lW();
                this.Le.setVisibility(0);
                this.Le.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Le != null) {
                            VoiceRecordButton.this.Le.setVisibility(4);
                            VoiceRecordButton.this.Le.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Le.setVisibility(4);
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
        ak.c(this.Le, d.C0126d.cp_cont_i, 1);
        this.Le.setVisibility(0);
        this.Le.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.JK = Math.max(i, this.JK);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JL > 200) {
            this.JK = 0;
            this.JL = uptimeMillis;
        }
        if (this.JK < 10) {
            this.KF = 1;
            invalidate();
        } else if (this.JK < 20) {
            this.KF = 2;
            invalidate();
        } else if (this.JK < 30) {
            this.KF = 3;
            invalidate();
        } else if (this.JK < 40) {
            this.KF = 4;
            invalidate();
        } else {
            this.KF = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (this.mModel != null && this.Lj != null) {
            int i2 = i / 1000;
            if (this.Ls != i2) {
                this.Lj.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Ls = i2;
        }
    }

    private void lX() {
        if (this.mModel != null) {
            this.KF = 0;
            this.Lk = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ln = SystemClock.uptimeMillis();
            this.Lo = this.Ln + 200;
            this.Lq.sendEmptyMessageAtTime(1, this.Lo);
            invalidate();
        }
    }

    private void lY() {
        this.KF = 0;
        this.KG = 0;
        this.Lk = 0.0f;
        this.Ll = 0.0f;
        this.Lq.removeMessages(1);
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
    public void onClick(View view2) {
        VoiceManager voiceManager;
        if (view2 != null && (voiceManager = getVoiceManager()) != null) {
            int id = view2.getId();
            if (id == d.g.restart) {
                voiceManager.stopPlay();
                lM();
            } else if (id == d.g.play_img && this.mModel != null) {
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
        this.Lm = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lZ() {
    }

    public void ma() {
        this.KN = new Paint();
        this.KN.setAntiAlias(true);
        this.KN.setStyle(Paint.Style.STROKE);
        this.KN.setStrokeWidth(2.0f);
        this.KO = new Paint();
        this.KO.setAntiAlias(true);
        this.KO.setStyle(Paint.Style.STROKE);
        this.KO.setStrokeWidth(2.0f);
        this.KP = new Paint();
        this.KP.setAntiAlias(true);
        this.KP.setStyle(Paint.Style.STROKE);
        this.KP.setStrokeWidth(2.0f);
        this.KQ = new Paint();
        this.KQ.setAntiAlias(true);
        this.KQ.setStyle(Paint.Style.STROKE);
        this.KQ.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.KN.setColor(this.KV);
            this.KO.setColor(this.KW);
            this.KP.setColor(this.KX);
            this.KQ.setColor(this.KY);
        } else {
            this.KN.setColor(this.KR);
            this.KO.setColor(this.KS);
            this.KP.setColor(this.KT);
            this.KQ.setColor(this.KU);
        }
        if (this.KF == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
        } else if (this.KF == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
            canvas.drawCircle(this.centerX, this.centerY, this.KI, this.KO);
        } else if (this.KF == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
            canvas.drawCircle(this.centerX, this.centerY, this.KI, this.KO);
            canvas.drawCircle(this.centerX, this.centerY, this.KJ, this.KP);
        } else if (this.KF == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.KH, this.KN);
            canvas.drawCircle(this.centerX, this.centerY, this.KI, this.KO);
            canvas.drawCircle(this.centerX, this.centerY, this.KJ, this.KP);
            canvas.drawCircle(this.centerX, this.centerY, this.KK, this.KQ);
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
                    lV();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
