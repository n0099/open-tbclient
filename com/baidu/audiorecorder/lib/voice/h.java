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
    private long axA;
    private i axH;
    private int axI;
    private com.baidu.tbadk.core.dialog.a axK;
    private int axz;
    private int ayA;
    private Paint ayB;
    private Paint ayC;
    private Paint ayD;
    private Paint ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private int ayI;
    private int ayJ;
    private int ayK;
    private int ayL;
    private int ayM;
    private final BitmapDrawable ayN;
    private final Paint ayO;
    private final Rect ayP;
    private final RectF ayQ;
    private TextView ayR;
    private TextView ayS;
    private TextView ayT;
    private TextView ayU;
    private VoiceButton ayV;
    private ImageView ayW;
    private TextView ayX;
    private float ayY;
    private float ayZ;
    private final int[] aym;
    private int ayn;
    private final int ayo;
    private final int ayp;
    private final int ayq;
    private final int ayr;
    private final int ays;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private g aza;
    private long azb;
    private long azc;
    private final int[] azd;
    private final a aze;
    private SweepGradient azf;
    private int azg;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayu;
        hVar.ayu = i + 1;
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
                if (h.this.ayZ >= 360.0f) {
                    h.this.ayZ = 360.0f;
                    h.this.ayu = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.azb = uptimeMillis;
                    h.this.azc = uptimeMillis + 200;
                    h.this.ayZ += (((float) (uptimeMillis - h.this.azb)) / 1000.0f) * h.this.ayY;
                    sendEmptyMessageAtTime(1, h.this.azc);
                    h.e(h.this);
                }
                h.this.ayt = h.this.ayu % 6;
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
        this.axA = 0L;
        this.aym = new int[4];
        this.ayt = 0;
        this.ayu = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayv = 0;
        this.ayw = 0;
        this.ayx = 0;
        this.ayy = 0;
        this.ayz = 0;
        this.ayA = 0;
        this.ayF = -1724676609;
        this.ayG = 1546880511;
        this.ayH = 674465279;
        this.ayI = 255034879;
        this.ayJ = -1725669966;
        this.ayK = 1545887154;
        this.ayL = 673471922;
        this.ayM = 254041522;
        this.ayO = new Paint(1);
        this.ayP = new Rect();
        this.ayQ = new RectF();
        this.axI = 0;
        this.azd = new int[2];
        this.aze = new a();
        this.axz = 0;
        this.azg = 0;
        this.aym[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.aym[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.aym[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.aym[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayv = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayw = this.ayv + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayx = this.ayw + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayy = this.ayx + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayz = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayA = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayz = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayA = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayn = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayo = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayp = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayq = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayr = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ays = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayO.setStyle(Paint.Style.STROKE);
        this.ayO.setStrokeWidth(this.ayr);
        this.ayN = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tu();
        this.azd[0] = aj.getColor(d.C0141d.common_color_10151);
        this.azd[1] = aj.getColor(d.C0141d.common_color_10152);
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
        int measuredWidth = this.ayV.getMeasuredWidth();
        int measuredHeight = this.ayV.getMeasuredHeight();
        int measuredWidth2 = this.ayS.getMeasuredWidth();
        this.ayS.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.ayS.getMeasuredHeight() + this.kq + i2);
        int bottom = this.ayS.getBottom();
        this.ayV.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.ayU.getMeasuredWidth();
        int measuredHeight2 = this.ayU.getMeasuredHeight();
        int top = this.ayV.getTop();
        this.ayU.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ayR.getMeasuredWidth();
        int measuredHeight3 = this.ayR.getMeasuredHeight();
        int right = this.ayV.getRight() - this.ayn;
        int bottom2 = this.ayV.getBottom() - this.ayo;
        this.ayR.layout(this.ayz + i6, this.ayA + bottom, measuredWidth4 + i6 + this.ayz, measuredHeight3 + this.ayA + bottom);
        int measuredWidth5 = this.ayW.getMeasuredWidth();
        this.ayW.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.ayW.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.ayX.getMeasuredWidth();
        this.ayX.layout((i5 - measuredWidth6) >> 1, (this.ayR.getTop() - this.ayX.getMeasuredHeight()) - this.ayp, (measuredWidth6 + i5) >> 1, (this.ayR.getTop() + i2) - this.ayp);
        this.ayV.getLeft();
        this.ayV.getRight();
        int measuredWidth7 = this.ayT.getMeasuredWidth();
        int measuredHeight4 = this.ayT.getMeasuredHeight();
        int bottom3 = this.ayV.getBottom();
        this.ayT.layout((i5 - measuredWidth7) >> 1, this.aym[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.aym[3]);
        this.ayP.set((i5 - this.ayN.getIntrinsicWidth()) >> 1, this.ayW.getTop() - this.ayq, (i5 + this.ayN.getIntrinsicHeight()) >> 1, (this.ayW.getTop() + this.ayN.getIntrinsicHeight()) - this.ayq);
        this.ayN.setBounds(this.ayP);
        this.ayQ.set(this.ayW.getLeft() + (this.ayr >> 1) + this.ays, this.ayW.getTop() + (this.ayr >> 1) + this.ays, (this.ayW.getRight() - (this.ayr >> 1)) - this.ays, (this.ayW.getBottom() - (this.ayr >> 1)) - this.ays);
        if (this.azf == null) {
            this.azf = new SweepGradient(this.ayQ.centerX(), this.ayQ.centerY(), this.azd, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.azf.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayQ.centerX(), this.ayQ.centerY());
            this.azf.setLocalMatrix(matrix);
            this.ayO.setShader(this.azf);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void tg() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axK == null) {
            this.axK = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axK.dk(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
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
            this.axK.AV();
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
        this.ayS = (TextView) findViewById(d.g.tip_error);
        aj.e(this.ayS, d.C0141d.cp_cont_i, 1);
        this.ayT = (TextView) findViewById(d.g.tip_operator);
        this.ayU = (TextView) findViewById(d.g.tip_time_out);
        this.ayV = (VoiceButton) findViewById(d.g.voice_bnt);
        this.ayR = (TextView) findViewById(d.g.restart);
        this.ayW = (ImageView) findViewById(d.g.play_img);
        this.ayX = (TextView) findViewById(d.g.play_time);
        this.ayX.setClickable(false);
        this.ayR.setOnClickListener(this);
        this.ayW.setOnClickListener(this);
        this.ayV.setRecorderView(this);
        tq();
    }

    private void tp() {
        this.ayV.setVisibility(4);
        this.ayX.setVisibility(0);
        this.ayR.setVisibility(0);
        aj.e(this.ayX, d.C0141d.cp_cont_f, 1);
        aj.e(this.ayR, d.C0141d.cp_cont_f, 1);
        aj.s(this.ayR, d.f.but_posts_record_again_selector);
        this.ayW.setVisibility(0);
        if (this.mModel != null) {
            this.ayX.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.ayW.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.ayW, d.f.but_posts_record_play_selector);
        }
        aj.e(this.ayT, d.C0141d.cp_cont_c, 1);
        this.ayT.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        aj.c(this.ayV, d.f.but_posts_record_zero_selector);
        this.ayV.setVisibility(0);
        this.ayt = 0;
        this.ayW.setVisibility(4);
        this.ayX.setVisibility(4);
        this.ayR.setVisibility(4);
        this.ayU.setVisibility(4);
        aj.e(this.ayT, d.C0141d.cp_cont_c, 1);
        this.ayT.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tq();
        this.mModel = null;
        this.ayt = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.ayS.setText("");
        this.ayS.setVisibility(4);
        this.ayt = 0;
        tp();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tq();
            this.ayT.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.ayW != null && this.ayX != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.ayX, d.C0141d.cp_cont_f, 1);
                    this.ayX.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.ayW, d.f.but_posts_record_play_selector);
                    this.ayW.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.ayT.setText(getContext().getString(d.j.voice_play_tip));
                    ts();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.ayX, d.C0141d.cp_cont_f, 1);
                    aj.c(this.ayW, d.f.but_posts_record_stop_selector);
                    this.ayW.setContentDescription(getContext().getString(d.j.pause_load));
                    this.ayT.setText(getContext().getString(d.j.voice_stop_tip));
                    tr();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.ayU, d.C0141d.cp_cont_i, 1);
        aj.e(this.ayS, d.C0141d.cp_cont_i, 1);
        aj.e(this.ayT, d.C0141d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.ayU.setVisibility(0);
                this.ayU.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayU != null) {
                            h.this.ayU.setVisibility(4);
                            h.this.ayU.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.ayS.setVisibility(0);
                this.ayS.setText(str);
                this.ayT.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayS != null) {
                            h.this.ayS.setVisibility(4);
                            h.this.ayS.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.ayS.setVisibility(0);
                this.ayS.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayS != null) {
                            h.this.ayS.setVisibility(4);
                            h.this.ayS.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tq();
                this.ayS.setVisibility(0);
                this.ayS.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayS != null) {
                            h.this.ayS.setVisibility(4);
                            h.this.ayS.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.ayS.setVisibility(4);
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
        aj.e(this.ayS, d.C0141d.cp_cont_i, 1);
        this.ayS.setVisibility(0);
        this.ayS.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axz = Math.max(i, this.axz);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axA > 200) {
            this.axz = 0;
            this.axA = uptimeMillis;
        }
        if (this.axz < 10) {
            this.ayt = 1;
            invalidate();
        } else if (this.axz < 20) {
            this.ayt = 2;
            invalidate();
        } else if (this.axz < 30) {
            this.ayt = 3;
            invalidate();
        } else if (this.axz < 40) {
            this.ayt = 4;
            invalidate();
        } else {
            this.ayt = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (this.mModel != null && this.ayX != null) {
            int i2 = i / 1000;
            if (this.azg != i2) {
                this.ayX.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azg = i2;
        }
    }

    private void tr() {
        if (this.mModel != null) {
            this.ayt = 0;
            this.ayY = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.azb = SystemClock.uptimeMillis();
            this.azc = this.azb + 200;
            this.aze.sendEmptyMessageAtTime(1, this.azc);
            invalidate();
        }
    }

    private void ts() {
        this.ayt = 0;
        this.ayu = 0;
        this.ayY = 0.0f;
        this.ayZ = 0.0f;
        this.aze.removeMessages(1);
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
        this.aza = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void tu() {
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
        this.ayE = new Paint();
        this.ayE.setAntiAlias(true);
        this.ayE.setStyle(Paint.Style.STROKE);
        this.ayE.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayB.setColor(this.ayJ);
            this.ayC.setColor(this.ayK);
            this.ayD.setColor(this.ayL);
            this.ayE.setColor(this.ayM);
        } else {
            this.ayB.setColor(this.ayF);
            this.ayC.setColor(this.ayG);
            this.ayD.setColor(this.ayH);
            this.ayE.setColor(this.ayI);
        }
        if (this.ayt == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
        } else if (this.ayt == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
            canvas.drawCircle(this.centerX, this.centerY, this.ayw, this.ayC);
        } else if (this.ayt == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
            canvas.drawCircle(this.centerX, this.centerY, this.ayw, this.ayC);
            canvas.drawCircle(this.centerX, this.centerY, this.ayx, this.ayD);
        } else if (this.ayt == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayv, this.ayB);
            canvas.drawCircle(this.centerX, this.centerY, this.ayw, this.ayC);
            canvas.drawCircle(this.centerX, this.centerY, this.ayx, this.ayD);
            canvas.drawCircle(this.centerX, this.centerY, this.ayy, this.ayE);
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
        return this.axI;
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
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
