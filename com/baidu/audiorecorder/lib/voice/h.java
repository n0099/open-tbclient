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
public class h extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private i axG;
    private int axH;
    private com.baidu.tbadk.core.dialog.a axJ;
    private int axy;
    private long axz;
    private Paint ayA;
    private Paint ayB;
    private Paint ayC;
    private Paint ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private int ayI;
    private int ayJ;
    private int ayK;
    private int ayL;
    private final BitmapDrawable ayM;
    private final Paint ayN;
    private final Rect ayO;
    private final RectF ayP;
    private TextView ayQ;
    private TextView ayR;
    private TextView ayS;
    private TextView ayT;
    private VoiceButton ayU;
    private ImageView ayV;
    private TextView ayW;
    private float ayX;
    private float ayY;
    private g ayZ;
    private final int[] ayl;
    private int aym;
    private final int ayn;
    private final int ayo;
    private final int ayp;
    private final int ayq;
    private final int ayr;
    private int ays;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private long aza;
    private long azb;
    private final int[] azc;
    private final a azd;
    private SweepGradient aze;
    private int azf;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayt;
        hVar.ayt = i + 1;
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
                if (h.this.ayY >= 360.0f) {
                    h.this.ayY = 360.0f;
                    h.this.ayt = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.aza = uptimeMillis;
                    h.this.azb = uptimeMillis + 200;
                    h.this.ayY += (((float) (uptimeMillis - h.this.aza)) / 1000.0f) * h.this.ayX;
                    sendEmptyMessageAtTime(1, h.this.azb);
                    h.e(h.this);
                }
                h.this.ays = h.this.ayt % 6;
                h.this.invalidate();
            }
        }
    }

    public static h au(Context context) {
        return new h(context);
    }

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axz = 0L;
        this.ayl = new int[4];
        this.ays = 0;
        this.ayt = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayu = 0;
        this.ayv = 0;
        this.ayw = 0;
        this.ayx = 0;
        this.ayy = 0;
        this.ayz = 0;
        this.ayE = -1724676609;
        this.ayF = 1546880511;
        this.ayG = 674465279;
        this.ayH = 255034879;
        this.ayI = -1725669966;
        this.ayJ = 1545887154;
        this.ayK = 673471922;
        this.ayL = 254041522;
        this.ayN = new Paint(1);
        this.ayO = new Rect();
        this.ayP = new RectF();
        this.axH = 0;
        this.azc = new int[2];
        this.azd = new a();
        this.axy = 0;
        this.azf = 0;
        this.ayl[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.ayl[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.ayl[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.ayl[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayu = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayv = this.ayu + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayw = this.ayv + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayx = this.ayw + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayy = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayz = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayy = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayz = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.aym = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayn = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayo = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayp = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayq = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ayr = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayN.setStyle(Paint.Style.STROKE);
        this.ayN.setStrokeWidth(this.ayq);
        this.ayM = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tu();
        this.azc[0] = aj.getColor(d.C0141d.common_color_10151);
        this.azc[1] = aj.getColor(d.C0141d.common_color_10152);
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
        this.kq = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.ayU.getMeasuredWidth();
        int measuredHeight = this.ayU.getMeasuredHeight();
        int measuredWidth2 = this.ayR.getMeasuredWidth();
        this.ayR.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.ayR.getMeasuredHeight() + this.kq + i2);
        int bottom = this.ayR.getBottom();
        this.ayU.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.ayT.getMeasuredWidth();
        int measuredHeight2 = this.ayT.getMeasuredHeight();
        int top = this.ayU.getTop();
        this.ayT.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ayQ.getMeasuredWidth();
        int measuredHeight3 = this.ayQ.getMeasuredHeight();
        int right = this.ayU.getRight() - this.aym;
        int bottom2 = this.ayU.getBottom() - this.ayn;
        this.ayQ.layout(this.ayy + i6, this.ayz + bottom, measuredWidth4 + i6 + this.ayy, measuredHeight3 + this.ayz + bottom);
        int measuredWidth5 = this.ayV.getMeasuredWidth();
        this.ayV.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.ayV.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.ayW.getMeasuredWidth();
        this.ayW.layout((i5 - measuredWidth6) >> 1, (this.ayQ.getTop() - this.ayW.getMeasuredHeight()) - this.ayo, (measuredWidth6 + i5) >> 1, (this.ayQ.getTop() + i2) - this.ayo);
        this.ayU.getLeft();
        this.ayU.getRight();
        int measuredWidth7 = this.ayS.getMeasuredWidth();
        int measuredHeight4 = this.ayS.getMeasuredHeight();
        int bottom3 = this.ayU.getBottom();
        this.ayS.layout((i5 - measuredWidth7) >> 1, this.ayl[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ayl[3]);
        this.ayO.set((i5 - this.ayM.getIntrinsicWidth()) >> 1, this.ayV.getTop() - this.ayp, (i5 + this.ayM.getIntrinsicHeight()) >> 1, (this.ayV.getTop() + this.ayM.getIntrinsicHeight()) - this.ayp);
        this.ayM.setBounds(this.ayO);
        this.ayP.set(this.ayV.getLeft() + (this.ayq >> 1) + this.ayr, this.ayV.getTop() + (this.ayq >> 1) + this.ayr, (this.ayV.getRight() - (this.ayq >> 1)) - this.ayr, (this.ayV.getBottom() - (this.ayq >> 1)) - this.ayr);
        if (this.aze == null) {
            this.aze = new SweepGradient(this.ayP.centerX(), this.ayP.centerY(), this.azc, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aze.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayP.centerX(), this.ayP.centerY());
            this.aze.setLocalMatrix(matrix);
            this.ayN.setShader(this.aze);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void tg() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axJ == null) {
            this.axJ = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axJ.dk(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    h.this.tq();
                    if (h.this.getVoiceManager() != null && h.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bR(h.this.mModel.voiceId);
                        }
                        h.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.ak(getContext()));
        }
        try {
            this.axJ.AU();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bR(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void av(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.ayR = (TextView) findViewById(d.g.tip_error);
        aj.e(this.ayR, d.C0141d.cp_cont_i, 1);
        this.ayS = (TextView) findViewById(d.g.tip_operator);
        this.ayT = (TextView) findViewById(d.g.tip_time_out);
        this.ayU = (VoiceButton) findViewById(d.g.voice_bnt);
        this.ayQ = (TextView) findViewById(d.g.restart);
        this.ayV = (ImageView) findViewById(d.g.play_img);
        this.ayW = (TextView) findViewById(d.g.play_time);
        this.ayW.setClickable(false);
        this.ayQ.setOnClickListener(this);
        this.ayV.setOnClickListener(this);
        this.ayU.setRecorderView(this);
        tq();
    }

    private void tp() {
        this.ayU.setVisibility(4);
        this.ayW.setVisibility(0);
        this.ayQ.setVisibility(0);
        aj.e(this.ayW, d.C0141d.cp_cont_f, 1);
        aj.e(this.ayQ, d.C0141d.cp_cont_f, 1);
        aj.s(this.ayQ, d.f.but_posts_record_again_selector);
        this.ayV.setVisibility(0);
        if (this.mModel != null) {
            this.ayW.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.ayV.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.ayV, d.f.but_posts_record_play_selector);
        }
        aj.e(this.ayS, d.C0141d.cp_cont_c, 1);
        this.ayS.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        aj.c(this.ayU, d.f.but_posts_record_zero_selector);
        this.ayU.setVisibility(0);
        this.ays = 0;
        this.ayV.setVisibility(4);
        this.ayW.setVisibility(4);
        this.ayQ.setVisibility(4);
        this.ayT.setVisibility(4);
        aj.e(this.ayS, d.C0141d.cp_cont_c, 1);
        this.ayS.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tq();
        this.mModel = null;
        this.ays = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.ayR.setText("");
        this.ayR.setVisibility(4);
        this.ays = 0;
        tp();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tq();
            this.ayS.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.ayV != null && this.ayW != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.ayW, d.C0141d.cp_cont_f, 1);
                    this.ayW.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.ayV, d.f.but_posts_record_play_selector);
                    this.ayV.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.ayS.setText(getContext().getString(d.j.voice_play_tip));
                    ts();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.ayW, d.C0141d.cp_cont_f, 1);
                    aj.c(this.ayV, d.f.but_posts_record_stop_selector);
                    this.ayV.setContentDescription(getContext().getString(d.j.pause_load));
                    this.ayS.setText(getContext().getString(d.j.voice_stop_tip));
                    tr();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.ayT, d.C0141d.cp_cont_i, 1);
        aj.e(this.ayR, d.C0141d.cp_cont_i, 1);
        aj.e(this.ayS, d.C0141d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.ayT.setVisibility(0);
                this.ayT.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayT != null) {
                            h.this.ayT.setVisibility(4);
                            h.this.ayT.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.ayR.setVisibility(0);
                this.ayR.setText(str);
                this.ayS.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayR != null) {
                            h.this.ayR.setVisibility(4);
                            h.this.ayR.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.ayR.setVisibility(0);
                this.ayR.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayR != null) {
                            h.this.ayR.setVisibility(4);
                            h.this.ayR.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tq();
                this.ayR.setVisibility(0);
                this.ayR.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayR != null) {
                            h.this.ayR.setVisibility(4);
                            h.this.ayR.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.ayR.setVisibility(4);
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
        aj.e(this.ayR, d.C0141d.cp_cont_i, 1);
        this.ayR.setVisibility(0);
        this.ayR.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axy = Math.max(i, this.axy);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axz > 200) {
            this.axy = 0;
            this.axz = uptimeMillis;
        }
        if (this.axy < 10) {
            this.ays = 1;
            invalidate();
        } else if (this.axy < 20) {
            this.ays = 2;
            invalidate();
        } else if (this.axy < 30) {
            this.ays = 3;
            invalidate();
        } else if (this.axy < 40) {
            this.ays = 4;
            invalidate();
        } else {
            this.ays = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (this.mModel != null && this.ayW != null) {
            int i2 = i / 1000;
            if (this.azf != i2) {
                this.ayW.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azf = i2;
        }
    }

    private void tr() {
        if (this.mModel != null) {
            this.ays = 0;
            this.ayX = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aza = SystemClock.uptimeMillis();
            this.azb = this.aza + 200;
            this.azd.sendEmptyMessageAtTime(1, this.azb);
            invalidate();
        }
    }

    private void ts() {
        this.ays = 0;
        this.ayt = 0;
        this.ayX = 0.0f;
        this.ayY = 0.0f;
        this.azd.removeMessages(1);
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
                tg();
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

    public void setCallback(g gVar) {
        this.ayZ = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void tu() {
        this.ayA = new Paint();
        this.ayA.setAntiAlias(true);
        this.ayA.setStyle(Paint.Style.STROKE);
        this.ayA.setStrokeWidth(2.0f);
        this.ayB = new Paint();
        this.ayB.setAntiAlias(true);
        this.ayB.setStyle(Paint.Style.STROKE);
        this.ayB.setStrokeWidth(2.0f);
        this.ayC = new Paint();
        this.ayC.setAntiAlias(true);
        this.ayC.setStyle(Paint.Style.STROKE);
        this.ayC.setStrokeWidth(2.0f);
        this.ayD = new Paint();
        this.ayD.setAntiAlias(true);
        this.ayD.setStyle(Paint.Style.STROKE);
        this.ayD.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayA.setColor(this.ayI);
            this.ayB.setColor(this.ayJ);
            this.ayC.setColor(this.ayK);
            this.ayD.setColor(this.ayL);
        } else {
            this.ayA.setColor(this.ayE);
            this.ayB.setColor(this.ayF);
            this.ayC.setColor(this.ayG);
            this.ayD.setColor(this.ayH);
        }
        if (this.ays == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayu, this.ayA);
        } else if (this.ays == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayu, this.ayA);
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
        } else if (this.ays == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayu, this.ayA);
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
            canvas.drawCircle(this.centerX, this.centerY, this.ayw, this.ayC);
        } else if (this.ays == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayu, this.ayA);
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
            canvas.drawCircle(this.centerX, this.centerY, this.ayw, this.ayC);
            canvas.drawCircle(this.centerX, this.centerY, this.ayx, this.ayD);
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
                    tp();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
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
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
