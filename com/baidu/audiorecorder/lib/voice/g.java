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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes2.dex */
public class g extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private int IL;
    private long IM;
    private int JA;
    private int JB;
    private int JC;
    private int JD;
    private int JE;
    private int JF;
    private int JG;
    private final BitmapDrawable JH;
    private final Paint JI;
    private final Rect JJ;
    private final RectF JK;
    private TextView JL;
    private TextView JM;
    private TextView JN;
    private TextView JO;
    private VoiceButton JP;
    private ImageView JQ;
    private TextView JR;
    private float JS;
    private float JT;
    private f JU;
    private com.baidu.tbadk.core.dialog.a JV;
    private long JW;
    private long JX;
    private final int[] JY;
    private final a JZ;
    private int Ja;
    private i Jb;
    private final int[] Jf;
    private int Jg;
    private int Jh;
    private final int Ji;
    private final int Jj;
    private final int Jk;
    private final int Jl;
    private final int Jm;
    private int Jn;
    private int Jo;
    private int Jp;
    private int Jq;
    private int Jr;
    private int Js;
    private int Jt;
    private int Ju;
    private Paint Jv;
    private Paint Jw;
    private Paint Jx;
    private Paint Jy;
    private int Jz;
    private SweepGradient Ka;
    private int Kb;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.Jo;
        gVar.Jo = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (g.this.JT >= 360.0f) {
                    g.this.JT = 360.0f;
                    g.this.Jo = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.JW = uptimeMillis;
                    g.this.JX = uptimeMillis + 200;
                    g.this.JT += (((float) (uptimeMillis - g.this.JW)) / 1000.0f) * g.this.JS;
                    sendEmptyMessageAtTime(1, g.this.JX);
                    g.e(g.this);
                }
                g.this.Jn = g.this.Jo % 6;
                g.this.invalidate();
            }
        }
    }

    public static g ah(Context context) {
        return new g(context);
    }

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IM = 0L;
        this.Jf = new int[4];
        this.Jn = 0;
        this.Jo = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Jp = 0;
        this.Jq = 0;
        this.Jr = 0;
        this.Js = 0;
        this.Jt = 0;
        this.Ju = 0;
        this.Jz = -1724676609;
        this.JA = 1546880511;
        this.JB = 674465279;
        this.JC = 255034879;
        this.JD = -1725669966;
        this.JE = 1545887154;
        this.JF = 673471922;
        this.JG = 254041522;
        this.JI = new Paint(1);
        this.JJ = new Rect();
        this.JK = new RectF();
        this.Ja = 0;
        this.JY = new int[2];
        this.JZ = new a();
        this.IL = 0;
        this.Kb = 0;
        this.Jf[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Jf[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Jf[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Jf[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.Jp = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.Jq = this.Jp + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.Jr = this.Jq + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.Js = this.Jr + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Jt = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ju = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Jt = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.Ju = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.Jg = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Jh = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.Ji = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.Jj = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Jk = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Jl = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.Jm = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.JI.setStyle(Paint.Style.STROKE);
        this.JI.setStrokeWidth(this.Jl);
        this.JH = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ai(context);
        lO();
        this.JY[0] = aj.getColor(d.C0080d.common_color_10151);
        this.JY[1] = aj.getColor(d.C0080d.common_color_10152);
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
        this.Jg = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.JP.getMeasuredWidth();
        int measuredHeight = this.JP.getMeasuredHeight();
        int measuredWidth2 = this.JM.getMeasuredWidth();
        this.JM.layout((i5 - measuredWidth2) >> 1, this.Jg + i2, (measuredWidth2 + i5) >> 1, this.JM.getMeasuredHeight() + this.Jg + i2);
        int bottom = this.JM.getBottom();
        this.JP.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.JO.getMeasuredWidth();
        int measuredHeight2 = this.JO.getMeasuredHeight();
        int top = this.JP.getTop();
        this.JO.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.JL.getMeasuredWidth();
        int measuredHeight3 = this.JL.getMeasuredHeight();
        int right = this.JP.getRight() - this.Jh;
        int bottom2 = this.JP.getBottom() - this.Ji;
        this.JL.layout(this.Jt + i6, this.Ju + bottom, measuredWidth4 + i6 + this.Jt, measuredHeight3 + this.Ju + bottom);
        int measuredWidth5 = this.JQ.getMeasuredWidth();
        this.JQ.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.JQ.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.JR.getMeasuredWidth();
        this.JR.layout((i5 - measuredWidth6) >> 1, (this.JL.getTop() - this.JR.getMeasuredHeight()) - this.Jj, (measuredWidth6 + i5) >> 1, (this.JL.getTop() + i2) - this.Jj);
        this.JP.getLeft();
        this.JP.getRight();
        int measuredWidth7 = this.JN.getMeasuredWidth();
        int measuredHeight4 = this.JN.getMeasuredHeight();
        int bottom3 = this.JP.getBottom();
        this.JN.layout((i5 - measuredWidth7) >> 1, this.Jf[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Jf[3]);
        this.JJ.set((i5 - this.JH.getIntrinsicWidth()) >> 1, this.JQ.getTop() - this.Jk, (i5 + this.JH.getIntrinsicHeight()) >> 1, (this.JQ.getTop() + this.JH.getIntrinsicHeight()) - this.Jk);
        this.JH.setBounds(this.JJ);
        this.JK.set(this.JQ.getLeft() + (this.Jl >> 1) + this.Jm, this.JQ.getTop() + (this.Jl >> 1) + this.Jm, (this.JQ.getRight() - (this.Jl >> 1)) - this.Jm, (this.JQ.getBottom() - (this.Jl >> 1)) - this.Jm);
        if (this.Ka == null) {
            this.Ka = new SweepGradient(this.JK.centerX(), this.JK.centerY(), this.JY, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ka.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.JK.centerX(), this.JK.centerY());
            this.Ka.setLocalMatrix(matrix);
            this.JI.setShader(this.Ka);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e(canvas);
        super.dispatchDraw(canvas);
    }

    private void lI() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.JV == null) {
            this.JV = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.JV.cS(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    g.this.lK();
                    if (g.this.getVoiceManager() != null && g.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bJ(g.this.mModel.voiceId);
                        }
                        g.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.Y(getContext()));
        }
        try {
            this.JV.th();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bJ(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ai(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.JM = (TextView) findViewById(d.g.tip_error);
        aj.c(this.JM, d.C0080d.cp_cont_i, 1);
        this.JN = (TextView) findViewById(d.g.tip_operator);
        this.JO = (TextView) findViewById(d.g.tip_time_out);
        this.JP = (VoiceButton) findViewById(d.g.voice_bnt);
        this.JL = (TextView) findViewById(d.g.restart);
        this.JQ = (ImageView) findViewById(d.g.play_img);
        this.JR = (TextView) findViewById(d.g.play_time);
        this.JR.setClickable(false);
        this.JL.setOnClickListener(this);
        this.JQ.setOnClickListener(this);
        this.JP.setRecorderView(this);
        lK();
    }

    private void lJ() {
        this.JP.setVisibility(4);
        this.JR.setVisibility(0);
        this.JL.setVisibility(0);
        aj.c(this.JR, d.C0080d.cp_cont_f, 1);
        aj.c(this.JL, d.C0080d.cp_cont_f, 1);
        aj.j(this.JL, d.f.but_posts_record_again_selector);
        this.JQ.setVisibility(0);
        if (this.mModel != null) {
            this.JR.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.JQ.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.JQ, d.f.but_posts_record_play_selector);
        }
        aj.c(this.JN, d.C0080d.cp_cont_c, 1);
        this.JN.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK() {
        aj.c(this.JP, d.f.but_posts_record_zero_selector);
        this.JP.setVisibility(0);
        this.Jn = 0;
        this.JQ.setVisibility(4);
        this.JR.setVisibility(4);
        this.JL.setVisibility(4);
        this.JO.setVisibility(4);
        aj.c(this.JN, d.C0080d.cp_cont_c, 1);
        this.JN.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        lK();
        this.mModel = null;
        this.Jn = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.JM.setText("");
        this.JM.setVisibility(4);
        this.Jn = 0;
        lJ();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lK();
            this.JN.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.JQ != null && this.JR != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.JR, d.C0080d.cp_cont_f, 1);
                    this.JR.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.JQ, d.f.but_posts_record_play_selector);
                    this.JQ.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.JN.setText(getContext().getString(d.j.voice_play_tip));
                    lM();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.JR, d.C0080d.cp_cont_f, 1);
                    aj.c(this.JQ, d.f.but_posts_record_stop_selector);
                    this.JQ.setContentDescription(getContext().getString(d.j.pause_load));
                    this.JN.setText(getContext().getString(d.j.voice_stop_tip));
                    lL();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.JO, d.C0080d.cp_cont_i, 1);
        aj.c(this.JM, d.C0080d.cp_cont_i, 1);
        aj.c(this.JN, d.C0080d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.JO.setVisibility(0);
                this.JO.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.JO != null) {
                            g.this.JO.setVisibility(4);
                            g.this.JO.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.JM.setVisibility(0);
                this.JM.setText(str);
                this.JN.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.JM != null) {
                            g.this.JM.setVisibility(4);
                            g.this.JM.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.JM.setVisibility(0);
                this.JM.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.JM != null) {
                            g.this.JM.setVisibility(4);
                            g.this.JM.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lK();
                this.JM.setVisibility(0);
                this.JM.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.JM != null) {
                            g.this.JM.setVisibility(4);
                            g.this.JM.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.JM.setVisibility(4);
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
        aj.c(this.JM, d.C0080d.cp_cont_i, 1);
        this.JM.setVisibility(0);
        this.JM.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IL = Math.max(i, this.IL);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IM > 200) {
            this.IL = 0;
            this.IM = uptimeMillis;
        }
        if (this.IL < 10) {
            this.Jn = 1;
            invalidate();
        } else if (this.IL < 20) {
            this.Jn = 2;
            invalidate();
        } else if (this.IL < 30) {
            this.Jn = 3;
            invalidate();
        } else if (this.IL < 40) {
            this.Jn = 4;
            invalidate();
        } else {
            this.Jn = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (this.mModel != null && this.JR != null) {
            int i2 = i / 1000;
            if (this.Kb != i2) {
                this.JR.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Kb = i2;
        }
    }

    private void lL() {
        if (this.mModel != null) {
            this.Jn = 0;
            this.JS = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.JW = SystemClock.uptimeMillis();
            this.JX = this.JW + 200;
            this.JZ.sendEmptyMessageAtTime(1, this.JX);
            invalidate();
        }
    }

    private void lM() {
        this.Jn = 0;
        this.Jo = 0;
        this.JS = 0.0f;
        this.JT = 0.0f;
        this.JZ.removeMessages(1);
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
            if (id == d.g.restart) {
                voiceManager.stopPlay();
                lI();
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
        this.JU = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lN() {
    }

    public void lO() {
        this.Jv = new Paint();
        this.Jv.setAntiAlias(true);
        this.Jv.setStyle(Paint.Style.STROKE);
        this.Jv.setStrokeWidth(2.0f);
        this.Jw = new Paint();
        this.Jw.setAntiAlias(true);
        this.Jw.setStyle(Paint.Style.STROKE);
        this.Jw.setStrokeWidth(2.0f);
        this.Jx = new Paint();
        this.Jx.setAntiAlias(true);
        this.Jx.setStyle(Paint.Style.STROKE);
        this.Jx.setStrokeWidth(2.0f);
        this.Jy = new Paint();
        this.Jy.setAntiAlias(true);
        this.Jy.setStyle(Paint.Style.STROKE);
        this.Jy.setStrokeWidth(2.0f);
    }

    public void e(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Jv.setColor(this.JD);
            this.Jw.setColor(this.JE);
            this.Jx.setColor(this.JF);
            this.Jy.setColor(this.JG);
        } else {
            this.Jv.setColor(this.Jz);
            this.Jw.setColor(this.JA);
            this.Jx.setColor(this.JB);
            this.Jy.setColor(this.JC);
        }
        if (this.Jn == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Jp, this.Jv);
        } else if (this.Jn == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Jp, this.Jv);
            canvas.drawCircle(this.centerX, this.centerY, this.Jq, this.Jw);
        } else if (this.Jn == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Jp, this.Jv);
            canvas.drawCircle(this.centerX, this.centerY, this.Jq, this.Jw);
            canvas.drawCircle(this.centerX, this.centerY, this.Jr, this.Jx);
        } else if (this.Jn == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Jp, this.Jv);
            canvas.drawCircle(this.centerX, this.centerY, this.Jq, this.Jw);
            canvas.drawCircle(this.centerX, this.centerY, this.Jr, this.Jx);
            canvas.drawCircle(this.centerX, this.centerY, this.Js, this.Jy);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
