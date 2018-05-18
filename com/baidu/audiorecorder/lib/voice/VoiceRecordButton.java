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
    private int JG;
    private long JH;
    private EditorTools JO;
    private int JP;
    private com.baidu.tbadk.core.dialog.a JR;
    private int KA;
    private int KC;
    private int KD;
    private int KE;
    private int KF;
    private int KG;
    private int KH;
    private int KI;
    private Paint KJ;
    private Paint KK;
    private Paint KL;
    private Paint KM;
    private int KN;
    private int KO;
    private int KP;
    private int KQ;
    private int KR;
    private int KS;
    private int KT;
    private int KU;
    private final BitmapDrawable KV;
    private final Paint KW;
    private final Rect KX;
    private final RectF KY;
    private TextView KZ;
    private final int[] Kt;
    private int Ku;
    private final int Kv;
    private final int Kw;
    private final int Kx;
    private final int Ky;
    private final int Kz;
    private TextView La;
    private TextView Lb;
    private TextView Lc;
    private VoiceButton Ld;
    private ImageView Le;
    private TextView Lf;
    private float Lg;
    private float Lh;
    private f Li;
    private long Lj;
    private long Lk;
    private final int[] Ll;
    private final a Lm;
    private SweepGradient Ln;
    private int Lo;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.KC;
        voiceRecordButton.KC = i + 1;
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
                if (VoiceRecordButton.this.Lh >= 360.0f) {
                    VoiceRecordButton.this.Lh = 360.0f;
                    VoiceRecordButton.this.KC = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Lj = uptimeMillis;
                    VoiceRecordButton.this.Lk = uptimeMillis + 200;
                    VoiceRecordButton.this.Lh += (((float) (uptimeMillis - VoiceRecordButton.this.Lj)) / 1000.0f) * VoiceRecordButton.this.Lg;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Lk);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.KA = VoiceRecordButton.this.KC % 6;
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
        this.JH = 0L;
        this.Kt = new int[4];
        this.KA = 0;
        this.KC = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.KD = 0;
        this.KE = 0;
        this.KF = 0;
        this.KG = 0;
        this.KH = 0;
        this.KI = 0;
        this.KN = -1724676609;
        this.KO = 1546880511;
        this.KP = 674465279;
        this.KQ = 255034879;
        this.KR = -1725669966;
        this.KS = 1545887154;
        this.KT = 673471922;
        this.KU = 254041522;
        this.KW = new Paint(1);
        this.KX = new Rect();
        this.KY = new RectF();
        this.JP = 0;
        this.Ll = new int[2];
        this.Lm = new a();
        this.JG = 0;
        this.Lo = 0;
        this.Kt[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Kt[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Kt[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Kt[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.KD = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.KE = this.KD + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.KF = this.KE + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.KG = this.KF + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.KH = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.KI = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.KH = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.KI = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Ku = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.Kv = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.Kw = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Kx = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Ky = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.Kz = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.KW.setStyle(Paint.Style.STROKE);
        this.KW.setStrokeWidth(this.Ky);
        this.KV = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        am(context);
        lZ();
        this.Ll[0] = ak.getColor(d.C0126d.common_color_10151);
        this.Ll[1] = ak.getColor(d.C0126d.common_color_10152);
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
        int measuredWidth = this.Ld.getMeasuredWidth();
        int measuredHeight = this.Ld.getMeasuredHeight();
        int measuredWidth2 = this.La.getMeasuredWidth();
        this.La.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.La.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.La.getBottom();
        this.Ld.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Lc.getMeasuredWidth();
        int measuredHeight2 = this.Lc.getMeasuredHeight();
        int top = this.Ld.getTop();
        this.Lc.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.KZ.getMeasuredWidth();
        int measuredHeight3 = this.KZ.getMeasuredHeight();
        int right = this.Ld.getRight() - this.Ku;
        int bottom2 = this.Ld.getBottom() - this.Kv;
        this.KZ.layout(this.KH + i6, this.KI + bottom, measuredWidth4 + i6 + this.KH, measuredHeight3 + this.KI + bottom);
        int measuredWidth5 = this.Le.getMeasuredWidth();
        this.Le.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Le.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Lf.getMeasuredWidth();
        this.Lf.layout((i5 - measuredWidth6) >> 1, (this.KZ.getTop() - this.Lf.getMeasuredHeight()) - this.Kw, (measuredWidth6 + i5) >> 1, (this.KZ.getTop() + i2) - this.Kw);
        this.Ld.getLeft();
        this.Ld.getRight();
        int measuredWidth7 = this.Lb.getMeasuredWidth();
        int measuredHeight4 = this.Lb.getMeasuredHeight();
        int bottom3 = this.Ld.getBottom();
        this.Lb.layout((i5 - measuredWidth7) >> 1, this.Kt[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Kt[3]);
        this.KX.set((i5 - this.KV.getIntrinsicWidth()) >> 1, this.Le.getTop() - this.Kx, (i5 + this.KV.getIntrinsicHeight()) >> 1, (this.Le.getTop() + this.KV.getIntrinsicHeight()) - this.Kx);
        this.KV.setBounds(this.KX);
        this.KY.set(this.Le.getLeft() + (this.Ky >> 1) + this.Kz, this.Le.getTop() + (this.Ky >> 1) + this.Kz, (this.Le.getRight() - (this.Ky >> 1)) - this.Kz, (this.Le.getBottom() - (this.Ky >> 1)) - this.Kz);
        if (this.Ln == null) {
            this.Ln = new SweepGradient(this.KY.centerX(), this.KY.centerY(), this.Ll, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ln.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.KY.centerX(), this.KY.centerY());
            this.Ln.setLocalMatrix(matrix);
            this.KW.setShader(this.Ln);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lL() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.JR == null) {
            this.JR = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.JR.dc(getContext().getString(d.k.voice_restart_tip)).a(getContext().getString(d.k.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lV();
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
            this.JR.tC();
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
        this.La = (TextView) findViewById(d.g.tip_error);
        ak.c(this.La, d.C0126d.cp_cont_i, 1);
        this.Lb = (TextView) findViewById(d.g.tip_operator);
        this.Lc = (TextView) findViewById(d.g.tip_time_out);
        this.Ld = (VoiceButton) findViewById(d.g.voice_bnt);
        this.KZ = (TextView) findViewById(d.g.restart);
        this.Le = (ImageView) findViewById(d.g.play_img);
        this.Lf = (TextView) findViewById(d.g.play_time);
        this.Lf.setClickable(false);
        this.KZ.setOnClickListener(this);
        this.Le.setOnClickListener(this);
        this.Ld.setRecorderView(this);
        lV();
    }

    private void lU() {
        this.Ld.setVisibility(4);
        this.Lf.setVisibility(0);
        this.KZ.setVisibility(0);
        ak.c(this.Lf, d.C0126d.cp_cont_f, 1);
        ak.c(this.KZ, d.C0126d.cp_cont_f, 1);
        ak.i(this.KZ, d.f.but_posts_record_again_selector);
        this.Le.setVisibility(0);
        if (this.mModel != null) {
            this.Lf.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Le.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(this.mModel.duration)));
            ak.c(this.Le, d.f.but_posts_record_play_selector);
        }
        ak.c(this.Lb, d.C0126d.cp_cont_c, 1);
        this.Lb.setText(getContext().getString(d.k.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV() {
        ak.c(this.Ld, d.f.but_posts_record_zero_selector);
        this.Ld.setVisibility(0);
        this.KA = 0;
        this.Le.setVisibility(4);
        this.Lf.setVisibility(4);
        this.KZ.setVisibility(4);
        this.Lc.setVisibility(4);
        ak.c(this.Lb, d.C0126d.cp_cont_c, 1);
        this.Lb.setText(getContext().getString(d.k.voice_record_press_to_record));
    }

    public void reset() {
        lV();
        this.mModel = null;
        this.KA = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.La.setText("");
        this.La.setVisibility(4);
        this.KA = 0;
        lU();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lV();
            this.Lb.setText(getContext().getString(d.k.voice_record_release_to_stop));
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
        if (this.Le != null && this.Lf != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ak.c(this.Lf, d.C0126d.cp_cont_f, 1);
                    this.Lf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ak.c(this.Le, d.f.but_posts_record_play_selector);
                    this.Le.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Lb.setText(getContext().getString(d.k.voice_play_tip));
                    lX();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ak.c(this.Lf, d.C0126d.cp_cont_f, 1);
                    ak.c(this.Le, d.f.but_posts_record_stop_selector);
                    this.Le.setContentDescription(getContext().getString(d.k.pause_load));
                    this.Lb.setText(getContext().getString(d.k.voice_stop_tip));
                    lW();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        ak.c(this.Lc, d.C0126d.cp_cont_i, 1);
        ak.c(this.La, d.C0126d.cp_cont_i, 1);
        ak.c(this.Lb, d.C0126d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Lc.setVisibility(0);
                this.Lc.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Lc != null) {
                            VoiceRecordButton.this.Lc.setVisibility(4);
                            VoiceRecordButton.this.Lc.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.La.setVisibility(0);
                this.La.setText(str);
                this.Lb.setText(d.k.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.La != null) {
                            VoiceRecordButton.this.La.setVisibility(4);
                            VoiceRecordButton.this.La.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.La.setVisibility(0);
                this.La.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.La != null) {
                            VoiceRecordButton.this.La.setVisibility(4);
                            VoiceRecordButton.this.La.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lV();
                this.La.setVisibility(0);
                this.La.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.La != null) {
                            VoiceRecordButton.this.La.setVisibility(4);
                            VoiceRecordButton.this.La.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.La.setVisibility(4);
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
        ak.c(this.La, d.C0126d.cp_cont_i, 1);
        this.La.setVisibility(0);
        this.La.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.JG = Math.max(i, this.JG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JH > 200) {
            this.JG = 0;
            this.JH = uptimeMillis;
        }
        if (this.JG < 10) {
            this.KA = 1;
            invalidate();
        } else if (this.JG < 20) {
            this.KA = 2;
            invalidate();
        } else if (this.JG < 30) {
            this.KA = 3;
            invalidate();
        } else if (this.JG < 40) {
            this.KA = 4;
            invalidate();
        } else {
            this.KA = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (this.mModel != null && this.Lf != null) {
            int i2 = i / 1000;
            if (this.Lo != i2) {
                this.Lf.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Lo = i2;
        }
    }

    private void lW() {
        if (this.mModel != null) {
            this.KA = 0;
            this.Lg = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Lj = SystemClock.uptimeMillis();
            this.Lk = this.Lj + 200;
            this.Lm.sendEmptyMessageAtTime(1, this.Lk);
            invalidate();
        }
    }

    private void lX() {
        this.KA = 0;
        this.KC = 0;
        this.Lg = 0.0f;
        this.Lh = 0.0f;
        this.Lm.removeMessages(1);
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
                lL();
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
        this.Li = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lY() {
    }

    public void lZ() {
        this.KJ = new Paint();
        this.KJ.setAntiAlias(true);
        this.KJ.setStyle(Paint.Style.STROKE);
        this.KJ.setStrokeWidth(2.0f);
        this.KK = new Paint();
        this.KK.setAntiAlias(true);
        this.KK.setStyle(Paint.Style.STROKE);
        this.KK.setStrokeWidth(2.0f);
        this.KL = new Paint();
        this.KL.setAntiAlias(true);
        this.KL.setStyle(Paint.Style.STROKE);
        this.KL.setStrokeWidth(2.0f);
        this.KM = new Paint();
        this.KM.setAntiAlias(true);
        this.KM.setStyle(Paint.Style.STROKE);
        this.KM.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.KJ.setColor(this.KR);
            this.KK.setColor(this.KS);
            this.KL.setColor(this.KT);
            this.KM.setColor(this.KU);
        } else {
            this.KJ.setColor(this.KN);
            this.KK.setColor(this.KO);
            this.KL.setColor(this.KP);
            this.KM.setColor(this.KQ);
        }
        if (this.KA == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.KD, this.KJ);
        } else if (this.KA == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.KD, this.KJ);
            canvas.drawCircle(this.centerX, this.centerY, this.KE, this.KK);
        } else if (this.KA == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.KD, this.KJ);
            canvas.drawCircle(this.centerX, this.centerY, this.KE, this.KK);
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
        } else if (this.KA == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.KD, this.KJ);
            canvas.drawCircle(this.centerX, this.centerY, this.KE, this.KK);
            canvas.drawCircle(this.centerX, this.centerY, this.KF, this.KL);
            canvas.drawCircle(this.centerX, this.centerY, this.KG, this.KM);
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
                    lU();
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
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
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
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
