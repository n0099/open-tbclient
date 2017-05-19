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
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, com.baidu.tbadk.editortools.y {
    private int JR;
    private long JS;
    private Paint KA;
    private Paint KB;
    private Paint KC;
    private Paint KD;
    private int KE;
    private int KF;
    private int KG;
    private int KH;
    private int KI;
    private int KJ;
    private int KK;
    private int KL;
    private final BitmapDrawable KM;
    private final Paint KN;
    private final Rect KO;
    private final RectF KP;
    private TextView KQ;
    private TextView KR;
    private TextView KS;
    private TextView KT;
    private VoiceButton KU;
    private ImageView KV;
    private TextView KW;
    private float KX;
    private float KY;
    private r KZ;
    private int Kf;
    private com.baidu.tbadk.editortools.j Kg;
    private final int[] Kk;
    private int Kl;
    private int Km;
    private final int Kn;
    private final int Ko;
    private final int Kp;
    private final int Kq;
    private final int Kr;
    private int Ks;
    private int Kt;
    private int Ku;
    private int Kv;
    private int Kw;
    private int Kx;
    private int Ky;
    private int Kz;
    private com.baidu.tbadk.core.dialog.a La;
    private long Lb;
    private long Lc;
    private final int[] Ld;
    private final a Le;
    private SweepGradient Lf;
    private int Lg;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(s sVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (s.this.KY >= 360.0f) {
                    s.this.KY = 360.0f;
                    s.this.Kt = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.Lb = uptimeMillis;
                    s.this.Lc = uptimeMillis + 200;
                    s.this.KY += (((float) (uptimeMillis - s.this.Lb)) / 1000.0f) * s.this.KX;
                    sendEmptyMessageAtTime(1, s.this.Lc);
                    s.this.Kt++;
                }
                s.this.Ks = s.this.Kt % 6;
                s.this.invalidate();
            }
        }
    }

    public static s aj(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JS = 0L;
        this.Kk = new int[4];
        this.Ks = 0;
        this.Kt = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Ku = 0;
        this.Kv = 0;
        this.Kw = 0;
        this.Kx = 0;
        this.Ky = 0;
        this.Kz = 0;
        this.KE = -1724676609;
        this.KF = 1546880511;
        this.KG = 674465279;
        this.KH = 255034879;
        this.KI = -1725669966;
        this.KJ = 1545887154;
        this.KK = 673471922;
        this.KL = 254041522;
        this.KN = new Paint(1);
        this.KO = new Rect();
        this.KP = new RectF();
        this.Kf = 0;
        this.Ld = new int[2];
        this.Le = new a(this, null);
        this.JR = 0;
        this.Lg = 0;
        this.Kk[0] = context.getResources().getDimensionPixelSize(w.f.ds24);
        this.Kk[1] = context.getResources().getDimensionPixelSize(w.f.ds8);
        this.Kk[2] = context.getResources().getDimensionPixelSize(w.f.ds22);
        this.Kk[3] = context.getResources().getDimensionPixelSize(w.f.ds36);
        this.Ku = context.getResources().getDimensionPixelSize(w.f.ds134);
        this.Kv = this.Ku + context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Kw = this.Kv + context.getResources().getDimensionPixelSize(w.f.ds16);
        this.Kx = this.Kw + context.getResources().getDimensionPixelSize(w.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Ky = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Kz = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Ky = context.getResources().getDimensionPixelSize(w.f.ds70);
            this.Kz = context.getResources().getDimensionPixelSize(w.f.ds210);
        }
        this.Kl = context.getResources().getDimensionPixelSize(w.f.ds26);
        this.Km = context.getResources().getDimensionPixelSize(w.f.ds10);
        this.Kn = context.getResources().getDimensionPixelSize(w.f.ds14);
        this.Ko = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Kp = context.getResources().getDimensionPixelSize(w.f.ds4);
        this.Kq = context.getResources().getDimensionPixelSize(w.f.ds12);
        this.Kr = context.getResources().getDimensionPixelSize(w.f.ds2);
        this.KN.setStyle(Paint.Style.STROKE);
        this.KN.setStrokeWidth(this.Kq);
        this.KM = (BitmapDrawable) getResources().getDrawable(w.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ak(context);
        me();
        this.Ld[0] = aq.getColor(w.e.common_color_10151);
        this.Ld[1] = aq.getColor(w.e.common_color_10152);
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
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
            }
        }
        setMeasuredDimension(i3, i4);
        this.Kl = ((i4 - getContext().getResources().getDimensionPixelSize(w.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(w.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.KU.getMeasuredWidth();
        int measuredHeight = this.KU.getMeasuredHeight();
        int measuredWidth2 = this.KR.getMeasuredWidth();
        this.KR.layout((i5 - measuredWidth2) >> 1, this.Kl + i2, (measuredWidth2 + i5) >> 1, this.KR.getMeasuredHeight() + this.Kl + i2);
        int bottom = this.KR.getBottom();
        this.KU.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.KT.getMeasuredWidth();
        int measuredHeight2 = this.KT.getMeasuredHeight();
        int top = this.KU.getTop();
        this.KT.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.KQ.getMeasuredWidth();
        int measuredHeight3 = this.KQ.getMeasuredHeight();
        int right = this.KU.getRight() - this.Km;
        int bottom2 = this.KU.getBottom() - this.Kn;
        this.KQ.layout(this.Ky + i6, this.Kz + bottom, measuredWidth4 + i6 + this.Ky, measuredHeight3 + this.Kz + bottom);
        int measuredWidth5 = this.KV.getMeasuredWidth();
        this.KV.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.KV.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.KW.getMeasuredWidth();
        this.KW.layout((i5 - measuredWidth6) >> 1, (this.KQ.getTop() - this.KW.getMeasuredHeight()) - this.Ko, (measuredWidth6 + i5) >> 1, (this.KQ.getTop() + i2) - this.Ko);
        this.KU.getLeft();
        this.KU.getRight();
        int measuredWidth7 = this.KS.getMeasuredWidth();
        int measuredHeight4 = this.KS.getMeasuredHeight();
        int bottom3 = this.KU.getBottom();
        this.KS.layout((i5 - measuredWidth7) >> 1, this.Kk[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Kk[3]);
        this.KO.set((i5 - this.KM.getIntrinsicWidth()) >> 1, this.KV.getTop() - this.Kp, (i5 + this.KM.getIntrinsicHeight()) >> 1, (this.KV.getTop() + this.KM.getIntrinsicHeight()) - this.Kp);
        this.KM.setBounds(this.KO);
        this.KP.set(this.KV.getLeft() + (this.Kq >> 1) + this.Kr, this.KV.getTop() + (this.Kq >> 1) + this.Kr, (this.KV.getRight() - (this.Kq >> 1)) - this.Kr, (this.KV.getBottom() - (this.Kq >> 1)) - this.Kr);
        if (this.Lf == null) {
            this.Lf = new SweepGradient(this.KP.centerX(), this.KP.centerY(), this.Ld, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Lf.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.KP.centerX(), this.KP.centerY());
            this.Lf.setLocalMatrix(matrix);
            this.KN.setShader(this.Lf);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lY() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.La == null) {
            this.La = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(getContext()).getPageActivity());
            this.La.cC(getContext().getString(w.l.voice_restart_tip)).a(getContext().getString(w.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(w.l.cancel), new u(this)).b(com.baidu.adp.base.k.Z(getContext()));
        }
        try {
            this.La.td();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bz(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ak(Context context) {
        LayoutInflater.from(context).inflate(w.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.KR = (TextView) findViewById(w.h.tip_error);
        aq.c(this.KR, w.e.cp_cont_i, 1);
        this.KS = (TextView) findViewById(w.h.tip_operator);
        this.KT = (TextView) findViewById(w.h.tip_time_out);
        this.KU = (VoiceButton) findViewById(w.h.voice_bnt);
        this.KQ = (TextView) findViewById(w.h.restart);
        this.KV = (ImageView) findViewById(w.h.play_img);
        this.KW = (TextView) findViewById(w.h.play_time);
        this.KW.setClickable(false);
        this.KQ.setOnClickListener(this);
        this.KV.setOnClickListener(this);
        this.KU.setRecorderView(this);
        ma();
    }

    private void lZ() {
        this.KU.setVisibility(4);
        this.KW.setVisibility(0);
        this.KQ.setVisibility(0);
        aq.c(this.KW, w.e.cp_cont_f, 1);
        aq.c(this.KQ, w.e.cp_cont_f, 1);
        aq.j(this.KQ, w.g.but_posts_record_again_selector);
        this.KV.setVisibility(0);
        if (this.mModel != null) {
            this.KW.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.KV.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aq.c(this.KV, w.g.but_posts_record_play_selector);
        }
        aq.c(this.KS, w.e.cp_cont_c, 1);
        this.KS.setText(getContext().getString(w.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        aq.c(this.KU, w.g.but_posts_record_zero_selector);
        this.KU.setVisibility(0);
        this.Ks = 0;
        this.KV.setVisibility(4);
        this.KW.setVisibility(4);
        this.KQ.setVisibility(4);
        this.KT.setVisibility(4);
        aq.c(this.KS, w.e.cp_cont_c, 1);
        this.KS.setText(getContext().getString(w.l.voice_record_press_to_record));
    }

    public void reset() {
        ma();
        this.mModel = null;
        this.Ks = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.KR.setText("");
        this.KR.setVisibility(4);
        this.Ks = 0;
        lZ();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            ma();
            this.KS.setText(getContext().getString(w.l.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.KV != null && this.KW != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aq.c(this.KW, w.e.cp_cont_f, 1);
                    this.KW.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aq.c(this.KV, w.g.but_posts_record_play_selector);
                    this.KV.setContentDescription(String.format(getContext().getString(w.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.KS.setText(getContext().getString(w.l.voice_play_tip));
                    mc();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aq.c(this.KW, w.e.cp_cont_f, 1);
                    aq.c(this.KV, w.g.but_posts_record_stop_selector);
                    this.KV.setContentDescription(getContext().getString(w.l.pause));
                    this.KS.setText(getContext().getString(w.l.voice_stop_tip));
                    mb();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        aq.c(this.KT, w.e.cp_cont_i, 1);
        aq.c(this.KR, w.e.cp_cont_i, 1);
        aq.c(this.KS, w.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.KT.setVisibility(0);
                this.KT.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.KR.setVisibility(0);
                this.KR.setText(str);
                this.KS.setText(w.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.KR.setVisibility(0);
                this.KR.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                ma();
                this.KR.setVisibility(0);
                this.KR.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.KR.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
        aq.c(this.KR, w.e.cp_cont_i, 1);
        this.KR.setVisibility(0);
        this.KR.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.JR = Math.max(i, this.JR);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.JS > 200) {
            this.JR = 0;
            this.JS = uptimeMillis;
        }
        if (this.JR < 10) {
            this.Ks = 1;
            invalidate();
        } else if (this.JR < 20) {
            this.Ks = 2;
            invalidate();
        } else if (this.JR < 30) {
            this.Ks = 3;
            invalidate();
        } else if (this.JR < 40) {
            this.Ks = 4;
            invalidate();
        } else {
            this.Ks = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (this.mModel != null && this.KW != null) {
            int i2 = i / 1000;
            if (this.Lg != i2) {
                this.KW.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Lg = i2;
        }
    }

    private void mb() {
        if (this.mModel != null) {
            this.Ks = 0;
            this.KX = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Lb = SystemClock.uptimeMillis();
            this.Lc = this.Lb + 200;
            this.Le.sendEmptyMessageAtTime(1, this.Lc);
            invalidate();
        }
    }

    private void mc() {
        this.Ks = 0;
        this.Kt = 0;
        this.KX = 0.0f;
        this.KY = 0.0f;
        this.Le.removeMessages(1);
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
            if (id == w.h.restart) {
                voiceManager.stopPlay();
                lY();
            } else if (id == w.h.play_img && this.mModel != null) {
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

    public void setCallback(r rVar) {
        this.KZ = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void md() {
    }

    public void me() {
        this.KA = new Paint();
        this.KA.setAntiAlias(true);
        this.KA.setStyle(Paint.Style.STROKE);
        this.KA.setStrokeWidth(2.0f);
        this.KB = new Paint();
        this.KB.setAntiAlias(true);
        this.KB.setStyle(Paint.Style.STROKE);
        this.KB.setStrokeWidth(2.0f);
        this.KC = new Paint();
        this.KC.setAntiAlias(true);
        this.KC.setStyle(Paint.Style.STROKE);
        this.KC.setStrokeWidth(2.0f);
        this.KD = new Paint();
        this.KD.setAntiAlias(true);
        this.KD.setStyle(Paint.Style.STROKE);
        this.KD.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.KA.setColor(this.KI);
            this.KB.setColor(this.KJ);
            this.KC.setColor(this.KK);
            this.KD.setColor(this.KL);
        } else {
            this.KA.setColor(this.KE);
            this.KB.setColor(this.KF);
            this.KC.setColor(this.KG);
            this.KD.setColor(this.KH);
        }
        if (this.Ks == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ku, this.KA);
        } else if (this.Ks == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ku, this.KA);
            canvas.drawCircle(this.centerX, this.centerY, this.Kv, this.KB);
        } else if (this.Ks == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ku, this.KA);
            canvas.drawCircle(this.centerX, this.centerY, this.Kv, this.KB);
            canvas.drawCircle(this.centerX, this.centerY, this.Kw, this.KC);
        } else if (this.Ks == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ku, this.KA);
            canvas.drawCircle(this.centerX, this.centerY, this.Kv, this.KB);
            canvas.drawCircle(this.centerX, this.centerY, this.Kw, this.KC);
            canvas.drawCircle(this.centerX, this.centerY, this.Kx, this.KD);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
