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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes8.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private final int[] FT;
    private int FU;
    private final int FV;
    private final int FW;
    private final int FX;
    private final int FY;
    private final int FZ;
    private int Fi;
    private long Fj;
    private EditorTools Fq;
    private int Fr;
    private com.baidu.tbadk.core.dialog.a Ft;
    private TextView GA;
    private TextView GC;
    private TextView GD;
    private TextView GE;
    private VoiceButton GF;
    private ImageView GG;
    private TextView GH;
    private float GI;
    private float GJ;
    private f GK;
    private long GL;
    private long GM;
    private final int[] GN;
    private final a GO;
    private SweepGradient GP;
    private int GQ;
    private int Ga;
    private int Gb;
    private int Gc;
    private int Gd;
    private int Ge;
    private int Gf;
    private int Gg;
    private int Gh;
    private int Gi;
    private int Gj;
    private Paint Gk;
    private Paint Gl;
    private Paint Gm;
    private Paint Gn;
    private int Go;
    private int Gp;
    private int Gq;
    private int Gr;
    private int Gs;
    private int Gt;
    private int Gu;
    private int Gv;
    private final BitmapDrawable Gw;
    private final Paint Gx;
    private final Rect Gy;
    private final RectF Gz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Gb;
        voiceRecordButton.Gb = i + 1;
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
                if (VoiceRecordButton.this.GJ >= 360.0f) {
                    VoiceRecordButton.this.GJ = 360.0f;
                    VoiceRecordButton.this.Gb = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.GL = uptimeMillis;
                    VoiceRecordButton.this.GM = uptimeMillis + 200;
                    VoiceRecordButton.this.GJ += (((float) (uptimeMillis - VoiceRecordButton.this.GL)) / 1000.0f) * VoiceRecordButton.this.GI;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.GM);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Ga = VoiceRecordButton.this.Gb % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton ae(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fj = 0L;
        this.FT = new int[4];
        this.Ga = 0;
        this.Gb = 0;
        this.Gc = 0;
        this.Gd = 0;
        this.Ge = 0;
        this.Gf = 0;
        this.Gg = 0;
        this.Gh = 0;
        this.Gi = 0;
        this.Gj = 0;
        this.Go = -1724676609;
        this.Gp = 1546880511;
        this.Gq = 674465279;
        this.Gr = 255034879;
        this.Gs = -1725669966;
        this.Gt = 1545887154;
        this.Gu = 673471922;
        this.Gv = 254041522;
        this.Gx = new Paint(1);
        this.Gy = new Rect();
        this.Gz = new RectF();
        this.Fr = 0;
        this.GN = new int[2];
        this.GO = new a();
        this.Fi = 0;
        this.GQ = 0;
        this.FT[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.FT[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.FT[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.FT[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.Ge = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.Gf = this.Ge + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Gg = this.Gf + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.Gh = this.Gg + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Gi = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Gj = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Gi = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.Gj = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.FU = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.FV = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.FW = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.FX = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.FY = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.FZ = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.Gx.setStyle(Paint.Style.STROKE);
        this.Gx.setStrokeWidth(this.FY);
        this.Gw = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        af(context);
        lJ();
        this.GN[0] = am.getColor(R.color.common_color_10151);
        this.GN[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.GF.getMeasuredWidth();
        int measuredHeight = this.GF.getMeasuredHeight();
        int measuredWidth2 = this.GC.getMeasuredWidth();
        this.GC.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.GC.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.GC.getBottom();
        this.GF.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.Gc = (measuredWidth / 2) + i6;
        this.Gd = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.GE.getMeasuredWidth();
        int measuredHeight2 = this.GE.getMeasuredHeight();
        int top = this.GF.getTop();
        this.GE.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.GA.getMeasuredWidth();
        int measuredHeight3 = this.GA.getMeasuredHeight();
        int right = this.GF.getRight() - this.FU;
        int bottom2 = this.GF.getBottom() - this.FV;
        this.GA.layout(this.Gi + i6, this.Gj + bottom, measuredWidth4 + i6 + this.Gi, measuredHeight3 + this.Gj + bottom);
        int measuredWidth5 = this.GG.getMeasuredWidth();
        this.GG.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.GG.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.GH.getMeasuredWidth();
        this.GH.layout((i5 - measuredWidth6) >> 1, (this.GA.getTop() - this.GH.getMeasuredHeight()) - this.FW, (measuredWidth6 + i5) >> 1, (this.GA.getTop() + i2) - this.FW);
        this.GF.getLeft();
        this.GF.getRight();
        int measuredWidth7 = this.GD.getMeasuredWidth();
        int measuredHeight4 = this.GD.getMeasuredHeight();
        int bottom3 = this.GF.getBottom();
        this.GD.layout((i5 - measuredWidth7) >> 1, this.FT[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.FT[3]);
        this.Gy.set((i5 - this.Gw.getIntrinsicWidth()) >> 1, this.GG.getTop() - this.FX, (i5 + this.Gw.getIntrinsicHeight()) >> 1, (this.GG.getTop() + this.Gw.getIntrinsicHeight()) - this.FX);
        this.Gw.setBounds(this.Gy);
        this.Gz.set(this.GG.getLeft() + (this.FY >> 1) + this.FZ, this.GG.getTop() + (this.FY >> 1) + this.FZ, (this.GG.getRight() - (this.FY >> 1)) - this.FZ, (this.GG.getBottom() - (this.FY >> 1)) - this.FZ);
        if (this.GP == null) {
            this.GP = new SweepGradient(this.Gz.centerX(), this.Gz.centerY(), this.GN, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.GP.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Gz.centerX(), this.Gz.centerY());
            this.GP.setLocalMatrix(matrix);
            this.Gx.setShader(this.GP);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lv() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Ft == null) {
            this.Ft = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.Ft.sz(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lG();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bx(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        try {
            this.Ft.aBW();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bx(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.GC = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.GC, R.color.cp_cont_a, 1);
        this.GD = (TextView) findViewById(R.id.tip_operator);
        this.GE = (TextView) findViewById(R.id.tip_time_out);
        this.GF = (VoiceButton) findViewById(R.id.voice_bnt);
        this.GA = (TextView) findViewById(R.id.restart);
        this.GG = (ImageView) findViewById(R.id.play_img);
        this.GH = (TextView) findViewById(R.id.play_time);
        this.GH.setClickable(false);
        this.GA.setOnClickListener(this);
        this.GG.setOnClickListener(this);
        this.GF.setRecorderView(this);
        lG();
    }

    private void lF() {
        this.GF.setVisibility(4);
        this.GH.setVisibility(0);
        this.GA.setVisibility(0);
        am.setViewTextColor(this.GH, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.GA, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.GA, R.drawable.but_posts_record_again_selector);
        this.GG.setVisibility(0);
        if (this.mModel != null) {
            this.GH.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.GG.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.GG, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.GD, R.color.cp_cont_c, 1);
        this.GD.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG() {
        am.setImageResource(this.GF, R.drawable.but_posts_record_zero_selector);
        this.GF.setVisibility(0);
        this.Ga = 0;
        this.GG.setVisibility(4);
        this.GH.setVisibility(4);
        this.GA.setVisibility(4);
        this.GE.setVisibility(4);
        am.setViewTextColor(this.GD, R.color.cp_cont_c, 1);
        this.GD.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        lG();
        this.mModel = null;
        this.Ga = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.GC.setText("");
        this.GC.setVisibility(4);
        this.Ga = 0;
        lF();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, HanziToPinyin.Token.SEPARATOR));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lG();
            this.GD.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.GG != null && this.GH != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.GH, R.color.cp_cont_f, 1);
                    this.GH.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.GG, R.drawable.but_posts_record_play_selector);
                    this.GG.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.GD.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.GH, R.color.cp_cont_f, 1);
                    am.setImageResource(this.GG, R.drawable.but_posts_record_stop_selector);
                    this.GG.setContentDescription(getContext().getString(R.string.pause_load));
                    this.GD.setText(getContext().getString(R.string.voice_stop_tip));
                    lH();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.GE, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.GC, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.GD, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.GE.setVisibility(0);
                this.GE.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GE != null) {
                            VoiceRecordButton.this.GE.setVisibility(4);
                            VoiceRecordButton.this.GE.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.GC.setVisibility(0);
                this.GC.setText(str);
                this.GD.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GC != null) {
                            VoiceRecordButton.this.GC.setVisibility(4);
                            VoiceRecordButton.this.GC.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.GC.setVisibility(0);
                this.GC.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GC != null) {
                            VoiceRecordButton.this.GC.setVisibility(4);
                            VoiceRecordButton.this.GC.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lG();
                this.GC.setVisibility(0);
                this.GC.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GC != null) {
                            VoiceRecordButton.this.GC.setVisibility(4);
                            VoiceRecordButton.this.GC.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.GC.setVisibility(4);
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
        am.setViewTextColor(this.GC, R.color.cp_cont_a, 1);
        this.GC.setVisibility(0);
        this.GC.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Fi = Math.max(i, this.Fi);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Fj > 200) {
            this.Fi = 0;
            this.Fj = uptimeMillis;
        }
        if (this.Fi < 10) {
            this.Ga = 1;
            invalidate();
        } else if (this.Fi < 20) {
            this.Ga = 2;
            invalidate();
        } else if (this.Fi < 30) {
            this.Ga = 3;
            invalidate();
        } else if (this.Fi < 40) {
            this.Ga = 4;
            invalidate();
        } else {
            this.Ga = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        if (this.mModel != null && this.GH != null) {
            int i2 = i / 1000;
            if (this.GQ != i2) {
                this.GH.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.GQ = i2;
        }
    }

    private void lH() {
        if (this.mModel != null) {
            this.Ga = 0;
            this.GI = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.GL = SystemClock.uptimeMillis();
            this.GM = this.GL + 200;
            this.GO.sendEmptyMessageAtTime(1, this.GM);
            invalidate();
        }
    }

    private void stopProgress() {
        this.Ga = 0;
        this.Gb = 0;
        this.GI = 0.0f;
        this.GJ = 0.0f;
        this.GO.removeMessages(1);
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
                lv();
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
        this.GK = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    public void lJ() {
        this.Gk = new Paint();
        this.Gk.setAntiAlias(true);
        this.Gk.setStyle(Paint.Style.STROKE);
        this.Gk.setStrokeWidth(2.0f);
        this.Gl = new Paint();
        this.Gl.setAntiAlias(true);
        this.Gl.setStyle(Paint.Style.STROKE);
        this.Gl.setStrokeWidth(2.0f);
        this.Gm = new Paint();
        this.Gm.setAntiAlias(true);
        this.Gm.setStyle(Paint.Style.STROKE);
        this.Gm.setStrokeWidth(2.0f);
        this.Gn = new Paint();
        this.Gn.setAntiAlias(true);
        this.Gn.setStyle(Paint.Style.STROKE);
        this.Gn.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Gk.setColor(this.Gs);
            this.Gl.setColor(this.Gt);
            this.Gm.setColor(this.Gu);
            this.Gn.setColor(this.Gv);
        } else {
            this.Gk.setColor(this.Go);
            this.Gl.setColor(this.Gp);
            this.Gm.setColor(this.Gq);
            this.Gn.setColor(this.Gr);
        }
        if (this.Ga == 2) {
            canvas.drawCircle(this.Gc, this.Gd, this.Ge, this.Gk);
        } else if (this.Ga == 3) {
            canvas.drawCircle(this.Gc, this.Gd, this.Ge, this.Gk);
            canvas.drawCircle(this.Gc, this.Gd, this.Gf, this.Gl);
        } else if (this.Ga == 4) {
            canvas.drawCircle(this.Gc, this.Gd, this.Ge, this.Gk);
            canvas.drawCircle(this.Gc, this.Gd, this.Gf, this.Gl);
            canvas.drawCircle(this.Gc, this.Gd, this.Gg, this.Gm);
        } else if (this.Ga == 5) {
            canvas.drawCircle(this.Gc, this.Gd, this.Ge, this.Gk);
            canvas.drawCircle(this.Gc, this.Gd, this.Gf, this.Gl);
            canvas.drawCircle(this.Gc, this.Gd, this.Gg, this.Gm);
            canvas.drawCircle(this.Gc, this.Gd, this.Gh, this.Gn);
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
                    lF();
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
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fr;
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
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fr = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
