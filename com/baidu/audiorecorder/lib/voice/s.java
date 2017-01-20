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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes.dex */
public class s extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.j, VoiceManager.b, com.baidu.tbadk.editortools.y {
    private int DI;
    private long DJ;
    private int DW;
    private com.baidu.tbadk.editortools.j DX;
    private int EA;
    private int EB;
    private int EC;
    private final BitmapDrawable ED;
    private final Paint EE;
    private final Rect EF;
    private final RectF EG;
    private TextView EH;
    private TextView EI;
    private TextView EJ;
    private TextView EK;
    private VoiceButton EL;
    private ImageView EM;
    private TextView EN;
    private float EO;
    private float EP;
    private r EQ;
    private com.baidu.tbadk.core.dialog.a ER;
    private long ES;
    private long ET;
    private final int[] EU;
    private final a EV;
    private SweepGradient EW;
    private int EX;
    private final int[] Eb;
    private int Ec;
    private int Ed;
    private final int Ee;
    private final int Ef;
    private final int Eg;
    private final int Eh;
    private final int Ei;
    private int Ej;
    private int Ek;
    private int El;
    private int Em;
    private int En;
    private int Eo;
    private int Ep;
    private int Eq;
    private Paint Er;
    private Paint Es;
    private Paint Et;
    private Paint Eu;
    private int Ev;
    private int Ew;
    private int Ex;
    private int Ey;
    private int Ez;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(s sVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (s.this.EP >= 360.0f) {
                    s.this.EP = 360.0f;
                    s.this.Ek = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    s.this.ES = uptimeMillis;
                    s.this.ET = uptimeMillis + 200;
                    s.this.EP += (((float) (uptimeMillis - s.this.ES)) / 1000.0f) * s.this.EO;
                    sendEmptyMessageAtTime(1, s.this.ET);
                    s.this.Ek++;
                }
                s.this.Ej = s.this.Ek % 6;
                s.this.invalidate();
            }
        }
    }

    public static s M(Context context) {
        return new s(context);
    }

    public s(Context context) {
        this(context, null);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DJ = 0L;
        this.Eb = new int[4];
        this.Ej = 0;
        this.Ek = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.El = 0;
        this.Em = 0;
        this.En = 0;
        this.Eo = 0;
        this.Ep = 0;
        this.Eq = 0;
        this.Ev = -1724676609;
        this.Ew = 1546880511;
        this.Ex = 674465279;
        this.Ey = 255034879;
        this.Ez = -1725669966;
        this.EA = 1545887154;
        this.EB = 673471922;
        this.EC = 254041522;
        this.EE = new Paint(1);
        this.EF = new Rect();
        this.EG = new RectF();
        this.DW = 0;
        this.EU = new int[2];
        this.EV = new a(this, null);
        this.DI = 0;
        this.EX = 0;
        this.Eb[0] = context.getResources().getDimensionPixelSize(r.f.ds24);
        this.Eb[1] = context.getResources().getDimensionPixelSize(r.f.ds8);
        this.Eb[2] = context.getResources().getDimensionPixelSize(r.f.ds22);
        this.Eb[3] = context.getResources().getDimensionPixelSize(r.f.ds36);
        this.El = context.getResources().getDimensionPixelSize(r.f.ds134);
        this.Em = this.El + context.getResources().getDimensionPixelSize(r.f.ds14);
        this.En = this.Em + context.getResources().getDimensionPixelSize(r.f.ds16);
        this.Eo = this.En + context.getResources().getDimensionPixelSize(r.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Ep = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Eq = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Ep = context.getResources().getDimensionPixelSize(r.f.ds70);
            this.Eq = context.getResources().getDimensionPixelSize(r.f.ds210);
        }
        this.Ec = context.getResources().getDimensionPixelSize(r.f.ds26);
        this.Ed = context.getResources().getDimensionPixelSize(r.f.ds10);
        this.Ee = context.getResources().getDimensionPixelSize(r.f.ds14);
        this.Ef = context.getResources().getDimensionPixelSize(r.f.ds4);
        this.Eg = context.getResources().getDimensionPixelSize(r.f.ds4);
        this.Eh = context.getResources().getDimensionPixelSize(r.f.ds12);
        this.Ei = context.getResources().getDimensionPixelSize(r.f.ds2);
        this.EE.setStyle(Paint.Style.STROKE);
        this.EE.setStrokeWidth(this.Eh);
        this.ED = (BitmapDrawable) getResources().getDrawable(r.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        N(context);
        lz();
        this.EU[0] = ap.getColor(r.e.common_color_10151);
        this.EU[1] = ap.getColor(r.e.common_color_10152);
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
        this.Ec = ((i4 - getContext().getResources().getDimensionPixelSize(r.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(r.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.EL.getMeasuredWidth();
        int measuredHeight = this.EL.getMeasuredHeight();
        int measuredWidth2 = this.EI.getMeasuredWidth();
        this.EI.layout((i5 - measuredWidth2) >> 1, this.Ec + i2, (measuredWidth2 + i5) >> 1, this.EI.getMeasuredHeight() + this.Ec + i2);
        int bottom = this.EI.getBottom();
        this.EL.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.EK.getMeasuredWidth();
        int measuredHeight2 = this.EK.getMeasuredHeight();
        int top = this.EL.getTop();
        this.EK.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.EH.getMeasuredWidth();
        int measuredHeight3 = this.EH.getMeasuredHeight();
        int right = this.EL.getRight() - this.Ed;
        int bottom2 = this.EL.getBottom() - this.Ee;
        this.EH.layout(this.Ep + i6, this.Eq + bottom, measuredWidth4 + i6 + this.Ep, measuredHeight3 + this.Eq + bottom);
        int measuredWidth5 = this.EM.getMeasuredWidth();
        this.EM.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.EM.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.EN.getMeasuredWidth();
        this.EN.layout((i5 - measuredWidth6) >> 1, (this.EH.getTop() - this.EN.getMeasuredHeight()) - this.Ef, (measuredWidth6 + i5) >> 1, (this.EH.getTop() + i2) - this.Ef);
        this.EL.getLeft();
        this.EL.getRight();
        int measuredWidth7 = this.EJ.getMeasuredWidth();
        int measuredHeight4 = this.EJ.getMeasuredHeight();
        int bottom3 = this.EL.getBottom();
        this.EJ.layout((i5 - measuredWidth7) >> 1, this.Eb[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Eb[3]);
        this.EF.set((i5 - this.ED.getIntrinsicWidth()) >> 1, this.EM.getTop() - this.Eg, (i5 + this.ED.getIntrinsicHeight()) >> 1, (this.EM.getTop() + this.ED.getIntrinsicHeight()) - this.Eg);
        this.ED.setBounds(this.EF);
        this.EG.set(this.EM.getLeft() + (this.Eh >> 1) + this.Ei, this.EM.getTop() + (this.Eh >> 1) + this.Ei, (this.EM.getRight() - (this.Eh >> 1)) - this.Ei, (this.EM.getBottom() - (this.Eh >> 1)) - this.Ei);
        if (this.EW == null) {
            this.EW = new SweepGradient(this.EG.centerX(), this.EG.centerY(), this.EU, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.EW.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.EG.centerX(), this.EG.centerY());
            this.EW.setLocalMatrix(matrix);
            this.EE.setShader(this.EW);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        d(canvas);
        super.dispatchDraw(canvas);
    }

    private void lt() {
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.ER == null) {
            this.ER = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.C(getContext()).getPageActivity());
            this.ER.cE(getContext().getString(r.l.voice_restart_tip)).a(getContext().getString(r.l.voice_restart), new t(this, recorderManager)).b(getContext().getString(r.l.cancel), new u(this)).b(com.baidu.adp.base.k.C(getContext()));
        }
        try {
            this.ER.sV();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bK(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void N(Context context) {
        LayoutInflater.from(context).inflate(r.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.EI = (TextView) findViewById(r.h.tip_error);
        ap.c(this.EI, r.e.cp_cont_i, 1);
        this.EJ = (TextView) findViewById(r.h.tip_operator);
        this.EK = (TextView) findViewById(r.h.tip_time_out);
        this.EL = (VoiceButton) findViewById(r.h.voice_bnt);
        this.EH = (TextView) findViewById(r.h.restart);
        this.EM = (ImageView) findViewById(r.h.play_img);
        this.EN = (TextView) findViewById(r.h.play_time);
        this.EN.setClickable(false);
        this.EH.setOnClickListener(this);
        this.EM.setOnClickListener(this);
        this.EL.setRecorderView(this);
        lv();
    }

    private void lu() {
        this.EL.setVisibility(4);
        this.EN.setVisibility(0);
        this.EH.setVisibility(0);
        ap.c(this.EN, r.e.cp_cont_f, 1);
        ap.c(this.EH, r.e.cp_cont_f, 1);
        ap.j((View) this.EH, r.g.but_posts_record_again_selector);
        this.EM.setVisibility(0);
        if (this.mModel != null) {
            this.EN.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.EM.setContentDescription(String.format(getContext().getString(r.l.listen_time), Integer.valueOf(this.mModel.duration)));
            ap.c(this.EM, r.g.but_posts_record_play_selector);
        }
        ap.c(this.EJ, r.e.cp_cont_c, 1);
        this.EJ.setText(getContext().getString(r.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv() {
        ap.c(this.EL, r.g.but_posts_record_zero_selector);
        this.EL.setVisibility(0);
        this.Ej = 0;
        this.EM.setVisibility(4);
        this.EN.setVisibility(4);
        this.EH.setVisibility(4);
        this.EK.setVisibility(4);
        ap.c(this.EJ, r.e.cp_cont_c, 1);
        this.EJ.setText(getContext().getString(r.l.voice_record_press_to_record));
    }

    public void reset() {
        lv();
        this.mModel = null;
        this.Ej = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.EI.setText("");
        this.EI.setVisibility(4);
        this.Ej = 0;
        lu();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
        if (z) {
            lv();
            this.EJ.setText(getContext().getString(r.l.voice_record_release_to_stop));
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
        if (this.EM != null && this.EN != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    ap.c(this.EN, r.e.cp_cont_f, 1);
                    this.EN.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ap.c(this.EM, r.g.but_posts_record_play_selector);
                    this.EM.setContentDescription(String.format(getContext().getString(r.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.EJ.setText(getContext().getString(r.l.voice_play_tip));
                    lx();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    ap.c(this.EN, r.e.cp_cont_f, 1);
                    ap.c(this.EM, r.g.but_posts_record_stop_selector);
                    this.EM.setContentDescription(getContext().getString(r.l.pause));
                    this.EJ.setText(getContext().getString(r.l.voice_stop_tip));
                    lw();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        ap.c(this.EK, r.e.cp_cont_i, 1);
        ap.c(this.EI, r.e.cp_cont_i, 1);
        ap.c(this.EJ, r.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.EK.setVisibility(0);
                this.EK.setText(str);
                postDelayed(new v(this), 2000L);
            } else if (i == 2) {
                this.EI.setVisibility(0);
                this.EI.setText(str);
                this.EJ.setText(r.l.voice_record_press_to_record);
                postDelayed(new w(this), 2000L);
            } else if (i == 5) {
                this.EI.setVisibility(0);
                this.EI.setText(str);
                postDelayed(new x(this), 2000L);
            } else {
                lv();
                this.EI.setVisibility(0);
                this.EI.setText(str);
                postDelayed(new y(this), 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        this.EI.setVisibility(4);
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
        ap.c(this.EI, r.e.cp_cont_i, 1);
        this.EI.setVisibility(0);
        this.EI.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        this.DI = Math.max(i, this.DI);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.DJ > 200) {
            this.DI = 0;
            this.DJ = uptimeMillis;
        }
        if (this.DI < 10) {
            this.Ej = 1;
            invalidate();
        } else if (this.DI < 20) {
            this.Ej = 2;
            invalidate();
        } else if (this.DI < 30) {
            this.Ej = 3;
            invalidate();
        } else if (this.DI < 40) {
            this.Ej = 4;
            invalidate();
        } else {
            this.Ej = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.EN != null) {
            int i2 = i / 1000;
            if (this.EX != i2) {
                this.EN.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.EX = i2;
        }
    }

    private void lw() {
        if (this.mModel != null) {
            this.Ej = 0;
            this.EO = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.ES = SystemClock.uptimeMillis();
            this.ET = this.ES + 200;
            this.EV.sendEmptyMessageAtTime(1, this.ET);
            invalidate();
        }
    }

    private void lx() {
        this.Ej = 0;
        this.Ek = 0;
        this.EO = 0.0f;
        this.EP = 0.0f;
        this.EV.removeMessages(1);
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
            if (id == r.h.restart) {
                voiceManager.stopPlay();
                lt();
            } else if (id == r.h.play_img && this.mModel != null) {
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
        this.EQ = rVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ly() {
    }

    public void lz() {
        this.Er = new Paint();
        this.Er.setAntiAlias(true);
        this.Er.setStyle(Paint.Style.STROKE);
        this.Er.setStrokeWidth(2.0f);
        this.Es = new Paint();
        this.Es.setAntiAlias(true);
        this.Es.setStyle(Paint.Style.STROKE);
        this.Es.setStrokeWidth(2.0f);
        this.Et = new Paint();
        this.Et.setAntiAlias(true);
        this.Et.setStyle(Paint.Style.STROKE);
        this.Et.setStrokeWidth(2.0f);
        this.Eu = new Paint();
        this.Eu.setAntiAlias(true);
        this.Eu.setStyle(Paint.Style.STROKE);
        this.Eu.setStrokeWidth(2.0f);
    }

    public void d(Canvas canvas) {
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.Er.setColor(this.Ez);
            this.Es.setColor(this.EA);
            this.Et.setColor(this.EB);
            this.Eu.setColor(this.EC);
        } else {
            this.Er.setColor(this.Ev);
            this.Es.setColor(this.Ew);
            this.Et.setColor(this.Ex);
            this.Eu.setColor(this.Ey);
        }
        if (this.Ej == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.El, this.Er);
        } else if (this.Ej == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.El, this.Er);
            canvas.drawCircle(this.centerX, this.centerY, this.Em, this.Es);
        } else if (this.Ej == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.El, this.Er);
            canvas.drawCircle(this.centerX, this.centerY, this.Em, this.Es);
            canvas.drawCircle(this.centerX, this.centerY, this.En, this.Et);
        } else if (this.Ej == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.El, this.Er);
            canvas.drawCircle(this.centerX, this.centerY, this.Em, this.Es);
            canvas.drawCircle(this.centerX, this.centerY, this.En, this.Et);
            canvas.drawCircle(this.centerX, this.centerY, this.Eo, this.Eu);
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
    public void lr() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
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
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }
}
