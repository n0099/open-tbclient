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
/* loaded from: classes11.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private int FG;
    private long FH;
    private EditorTools FO;
    private int FP;
    private com.baidu.tbadk.core.dialog.a FR;
    private int GA;
    private int GC;
    private int GD;
    private int GF;
    private int GG;
    private int GH;
    private int GI;
    private int GJ;
    private Paint GK;
    private Paint GL;
    private Paint GM;
    private Paint GN;
    private int GO;
    private int GP;
    private int GQ;
    private int GR;
    private int GU;
    private int GV;
    private int GW;
    private int GX;
    private final BitmapDrawable GY;
    private final Paint GZ;
    private final int[] Gr;
    private int Gs;
    private final int Gt;
    private final int Gu;
    private final int Gv;
    private final int Gw;
    private final int Gx;
    private int Gy;
    private int Gz;
    private final Rect Ha;
    private final RectF Hb;
    private TextView Hc;
    private TextView Hd;
    private TextView He;
    private TextView Hf;
    private VoiceButton Hg;
    private ImageView Hh;
    private TextView Hi;
    private float Hj;
    private float Hk;
    private f Hl;
    private long Hm;
    private long Hn;
    private final int[] Ho;
    private final a Hp;
    private SweepGradient Hq;
    private int Hr;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Gz;
        voiceRecordButton.Gz = i + 1;
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
                if (VoiceRecordButton.this.Hk >= 360.0f) {
                    VoiceRecordButton.this.Hk = 360.0f;
                    VoiceRecordButton.this.Gz = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Hm = uptimeMillis;
                    VoiceRecordButton.this.Hn = uptimeMillis + 200;
                    VoiceRecordButton.this.Hk += (((float) (uptimeMillis - VoiceRecordButton.this.Hm)) / 1000.0f) * VoiceRecordButton.this.Hj;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Hn);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Gy = VoiceRecordButton.this.Gz % 6;
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
        this.FH = 0L;
        this.Gr = new int[4];
        this.Gy = 0;
        this.Gz = 0;
        this.GA = 0;
        this.GC = 0;
        this.GD = 0;
        this.GF = 0;
        this.GG = 0;
        this.GH = 0;
        this.GI = 0;
        this.GJ = 0;
        this.GO = -1724676609;
        this.GP = 1546880511;
        this.GQ = 674465279;
        this.GR = 255034879;
        this.GU = -1725669966;
        this.GV = 1545887154;
        this.GW = 673471922;
        this.GX = 254041522;
        this.GZ = new Paint(1);
        this.Ha = new Rect();
        this.Hb = new RectF();
        this.FP = 0;
        this.Ho = new int[2];
        this.Hp = new a();
        this.FG = 0;
        this.Hr = 0;
        this.Gr[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Gr[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Gr[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Gr[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.GD = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.GF = this.GD + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.GG = this.GF + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.GH = this.GG + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.GI = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.GJ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.GI = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.GJ = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.Gs = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.Gt = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Gu = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Gv = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Gw = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.Gx = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.GZ.setStyle(Paint.Style.STROKE);
        this.GZ.setStrokeWidth(this.Gw);
        this.GY = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        af(context);
        lY();
        this.Ho[0] = am.getColor(R.color.common_color_10151);
        this.Ho[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.Hg.getMeasuredWidth();
        int measuredHeight = this.Hg.getMeasuredHeight();
        int measuredWidth2 = this.Hd.getMeasuredWidth();
        this.Hd.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Hd.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Hd.getBottom();
        this.Hg.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.GA = (measuredWidth / 2) + i6;
        this.GC = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Hf.getMeasuredWidth();
        int measuredHeight2 = this.Hf.getMeasuredHeight();
        int top2 = this.Hg.getTop();
        this.Hf.layout((i5 - measuredWidth3) >> 1, top2 - measuredHeight2, (measuredWidth3 + i5) >> 1, top2);
        int measuredWidth4 = this.Hc.getMeasuredWidth();
        int measuredHeight3 = this.Hc.getMeasuredHeight();
        int right = this.Hg.getRight() - this.Gs;
        int bottom2 = this.Hg.getBottom() - this.Gt;
        this.Hc.layout(this.GI + i6, this.GJ + bottom, measuredWidth4 + i6 + this.GI, measuredHeight3 + this.GJ + bottom);
        int measuredWidth5 = this.Hh.getMeasuredWidth();
        this.Hh.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Hh.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Hi.getMeasuredWidth();
        this.Hi.layout((i5 - measuredWidth6) >> 1, (this.Hc.getTop() - this.Hi.getMeasuredHeight()) - this.Gu, (measuredWidth6 + i5) >> 1, (this.Hc.getTop() + i2) - this.Gu);
        this.Hg.getLeft();
        this.Hg.getRight();
        int measuredWidth7 = this.He.getMeasuredWidth();
        int measuredHeight4 = this.He.getMeasuredHeight();
        int bottom3 = this.Hg.getBottom();
        this.He.layout((i5 - measuredWidth7) >> 1, this.Gr[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Gr[3]);
        this.Ha.set((i5 - this.GY.getIntrinsicWidth()) >> 1, this.Hh.getTop() - this.Gv, (i5 + this.GY.getIntrinsicHeight()) >> 1, (this.Hh.getTop() + this.GY.getIntrinsicHeight()) - this.Gv);
        this.GY.setBounds(this.Ha);
        this.Hb.set(this.Hh.getLeft() + (this.Gw >> 1) + this.Gx, this.Hh.getTop() + (this.Gw >> 1) + this.Gx, (this.Hh.getRight() - (this.Gw >> 1)) - this.Gx, (this.Hh.getBottom() - (this.Gw >> 1)) - this.Gx);
        if (this.Hq == null) {
            this.Hq = new SweepGradient(this.Hb.centerX(), this.Hb.centerY(), this.Ho, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Hq.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Hb.centerX(), this.Hb.centerY());
            this.Hq.setLocalMatrix(matrix);
            this.GZ.setShader(this.Hq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lL() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.FR == null) {
            this.FR = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.FR.sR(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lV();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bz(VoiceRecordButton.this.mModel.voiceId);
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
            this.FR.aEG();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bz(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Hd = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.Hd, R.color.cp_cont_a, 1);
        this.He = (TextView) findViewById(R.id.tip_operator);
        this.Hf = (TextView) findViewById(R.id.tip_time_out);
        this.Hg = (VoiceButton) findViewById(R.id.voice_bnt);
        this.Hc = (TextView) findViewById(R.id.restart);
        this.Hh = (ImageView) findViewById(R.id.play_img);
        this.Hi = (TextView) findViewById(R.id.play_time);
        this.Hi.setClickable(false);
        this.Hc.setOnClickListener(this);
        this.Hh.setOnClickListener(this);
        this.Hg.setRecorderView(this);
        lV();
    }

    private void lU() {
        this.Hg.setVisibility(4);
        this.Hi.setVisibility(0);
        this.Hc.setVisibility(0);
        am.setViewTextColor(this.Hi, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.Hc, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.Hc, R.drawable.but_posts_record_again_selector);
        this.Hh.setVisibility(0);
        if (this.mModel != null) {
            this.Hi.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Hh.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.Hh, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.He, R.color.cp_cont_c, 1);
        this.He.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV() {
        am.setImageResource(this.Hg, R.drawable.but_posts_record_zero_selector);
        this.Hg.setVisibility(0);
        this.Gy = 0;
        this.Hh.setVisibility(4);
        this.Hi.setVisibility(4);
        this.Hc.setVisibility(4);
        this.Hf.setVisibility(4);
        am.setViewTextColor(this.He, R.color.cp_cont_c, 1);
        this.He.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        lV();
        this.mModel = null;
        this.Gy = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Hd.setText("");
        this.Hd.setVisibility(4);
        this.Gy = 0;
        lU();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, HanziToPinyin.Token.SEPARATOR));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lV();
            this.He.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.Hh != null && this.Hi != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.Hi, R.color.cp_cont_f, 1);
                    this.Hi.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.Hh, R.drawable.but_posts_record_play_selector);
                    this.Hh.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.He.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.Hi, R.color.cp_cont_f, 1);
                    am.setImageResource(this.Hh, R.drawable.but_posts_record_stop_selector);
                    this.Hh.setContentDescription(getContext().getString(R.string.pause_load));
                    this.He.setText(getContext().getString(R.string.voice_stop_tip));
                    lW();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.Hf, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.Hd, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.He, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Hf.setVisibility(0);
                this.Hf.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Hf != null) {
                            VoiceRecordButton.this.Hf.setVisibility(4);
                            VoiceRecordButton.this.Hf.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Hd.setVisibility(0);
                this.Hd.setText(str);
                this.He.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Hd != null) {
                            VoiceRecordButton.this.Hd.setVisibility(4);
                            VoiceRecordButton.this.Hd.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Hd.setVisibility(0);
                this.Hd.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Hd != null) {
                            VoiceRecordButton.this.Hd.setVisibility(4);
                            VoiceRecordButton.this.Hd.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lV();
                this.Hd.setVisibility(0);
                this.Hd.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Hd != null) {
                            VoiceRecordButton.this.Hd.setVisibility(4);
                            VoiceRecordButton.this.Hd.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Hd.setVisibility(4);
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
        am.setViewTextColor(this.Hd, R.color.cp_cont_a, 1);
        this.Hd.setVisibility(0);
        this.Hd.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.FG = Math.max(i, this.FG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.FH > 200) {
            this.FG = 0;
            this.FH = uptimeMillis;
        }
        if (this.FG < 10) {
            this.Gy = 1;
            invalidate();
        } else if (this.FG < 20) {
            this.Gy = 2;
            invalidate();
        } else if (this.FG < 30) {
            this.Gy = 3;
            invalidate();
        } else if (this.FG < 40) {
            this.Gy = 4;
            invalidate();
        } else {
            this.Gy = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aG(int i) {
        if (this.mModel != null && this.Hi != null) {
            int i2 = i / 1000;
            if (this.Hr != i2) {
                this.Hi.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Hr = i2;
        }
    }

    private void lW() {
        if (this.mModel != null) {
            this.Gy = 0;
            this.Hj = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Hm = SystemClock.uptimeMillis();
            this.Hn = this.Hm + 200;
            this.Hp.sendEmptyMessageAtTime(1, this.Hn);
            invalidate();
        }
    }

    private void stopProgress() {
        this.Gy = 0;
        this.Gz = 0;
        this.Hj = 0.0f;
        this.Hk = 0.0f;
        this.Hp.removeMessages(1);
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
                lL();
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
        this.Hl = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lX() {
    }

    public void lY() {
        this.GK = new Paint();
        this.GK.setAntiAlias(true);
        this.GK.setStyle(Paint.Style.STROKE);
        this.GK.setStrokeWidth(2.0f);
        this.GL = new Paint();
        this.GL.setAntiAlias(true);
        this.GL.setStyle(Paint.Style.STROKE);
        this.GL.setStrokeWidth(2.0f);
        this.GM = new Paint();
        this.GM.setAntiAlias(true);
        this.GM.setStyle(Paint.Style.STROKE);
        this.GM.setStrokeWidth(2.0f);
        this.GN = new Paint();
        this.GN.setAntiAlias(true);
        this.GN.setStyle(Paint.Style.STROKE);
        this.GN.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.GK.setColor(this.GU);
            this.GL.setColor(this.GV);
            this.GM.setColor(this.GW);
            this.GN.setColor(this.GX);
        } else {
            this.GK.setColor(this.GO);
            this.GL.setColor(this.GP);
            this.GM.setColor(this.GQ);
            this.GN.setColor(this.GR);
        }
        if (this.Gy == 2) {
            canvas.drawCircle(this.GA, this.GC, this.GD, this.GK);
        } else if (this.Gy == 3) {
            canvas.drawCircle(this.GA, this.GC, this.GD, this.GK);
            canvas.drawCircle(this.GA, this.GC, this.GF, this.GL);
        } else if (this.Gy == 4) {
            canvas.drawCircle(this.GA, this.GC, this.GD, this.GK);
            canvas.drawCircle(this.GA, this.GC, this.GF, this.GL);
            canvas.drawCircle(this.GA, this.GC, this.GG, this.GM);
        } else if (this.Gy == 5) {
            canvas.drawCircle(this.GA, this.GC, this.GD, this.GK);
            canvas.drawCircle(this.GA, this.GC, this.GF, this.GL);
            canvas.drawCircle(this.GA, this.GC, this.GG, this.GM);
            canvas.drawCircle(this.GA, this.GC, this.GH, this.GN);
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

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
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
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
