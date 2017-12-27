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
    private int axG;
    private long axH;
    private i axO;
    private int axP;
    private com.baidu.tbadk.core.dialog.a axR;
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private Paint ayI;
    private Paint ayJ;
    private Paint ayK;
    private Paint ayL;
    private int ayM;
    private int ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    private int ayT;
    private final BitmapDrawable ayU;
    private final Paint ayV;
    private final Rect ayW;
    private final RectF ayX;
    private TextView ayY;
    private TextView ayZ;
    private final int[] ayt;
    private int ayu;
    private final int ayv;
    private final int ayw;
    private final int ayx;
    private final int ayy;
    private final int ayz;
    private TextView aza;
    private TextView azb;
    private VoiceButton azc;
    private ImageView azd;
    private TextView aze;
    private float azf;
    private float azg;
    private g azh;
    private long azi;
    private long azj;
    private final int[] azk;
    private final a azl;
    private SweepGradient azm;
    private int azn;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayB;
        hVar.ayB = i + 1;
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
                if (h.this.azg >= 360.0f) {
                    h.this.azg = 360.0f;
                    h.this.ayB = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.azi = uptimeMillis;
                    h.this.azj = uptimeMillis + 200;
                    h.this.azg += (((float) (uptimeMillis - h.this.azi)) / 1000.0f) * h.this.azf;
                    sendEmptyMessageAtTime(1, h.this.azj);
                    h.e(h.this);
                }
                h.this.ayA = h.this.ayB % 6;
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
        this.axH = 0L;
        this.ayt = new int[4];
        this.ayA = 0;
        this.ayB = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayC = 0;
        this.ayD = 0;
        this.ayE = 0;
        this.ayF = 0;
        this.ayG = 0;
        this.ayH = 0;
        this.ayM = -1724676609;
        this.ayN = 1546880511;
        this.ayO = 674465279;
        this.ayP = 255034879;
        this.ayQ = -1725669966;
        this.ayR = 1545887154;
        this.ayS = 673471922;
        this.ayT = 254041522;
        this.ayV = new Paint(1);
        this.ayW = new Rect();
        this.ayX = new RectF();
        this.axP = 0;
        this.azk = new int[2];
        this.azl = new a();
        this.axG = 0;
        this.azn = 0;
        this.ayt[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.ayt[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.ayt[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.ayt[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayC = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayD = this.ayC + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayE = this.ayD + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayF = this.ayE + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayG = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayH = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayG = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayH = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayu = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayv = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayw = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayx = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayy = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ayz = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayV.setStyle(Paint.Style.STROKE);
        this.ayV.setStrokeWidth(this.ayy);
        this.ayU = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tu();
        this.azk[0] = aj.getColor(d.C0108d.common_color_10151);
        this.azk[1] = aj.getColor(d.C0108d.common_color_10152);
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
        int measuredWidth = this.azc.getMeasuredWidth();
        int measuredHeight = this.azc.getMeasuredHeight();
        int measuredWidth2 = this.ayZ.getMeasuredWidth();
        this.ayZ.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.ayZ.getMeasuredHeight() + this.kq + i2);
        int bottom = this.ayZ.getBottom();
        this.azc.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.azb.getMeasuredWidth();
        int measuredHeight2 = this.azb.getMeasuredHeight();
        int top = this.azc.getTop();
        this.azb.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.ayY.getMeasuredWidth();
        int measuredHeight3 = this.ayY.getMeasuredHeight();
        int right = this.azc.getRight() - this.ayu;
        int bottom2 = this.azc.getBottom() - this.ayv;
        this.ayY.layout(this.ayG + i6, this.ayH + bottom, measuredWidth4 + i6 + this.ayG, measuredHeight3 + this.ayH + bottom);
        int measuredWidth5 = this.azd.getMeasuredWidth();
        this.azd.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.azd.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aze.getMeasuredWidth();
        this.aze.layout((i5 - measuredWidth6) >> 1, (this.ayY.getTop() - this.aze.getMeasuredHeight()) - this.ayw, (measuredWidth6 + i5) >> 1, (this.ayY.getTop() + i2) - this.ayw);
        this.azc.getLeft();
        this.azc.getRight();
        int measuredWidth7 = this.aza.getMeasuredWidth();
        int measuredHeight4 = this.aza.getMeasuredHeight();
        int bottom3 = this.azc.getBottom();
        this.aza.layout((i5 - measuredWidth7) >> 1, this.ayt[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ayt[3]);
        this.ayW.set((i5 - this.ayU.getIntrinsicWidth()) >> 1, this.azd.getTop() - this.ayx, (i5 + this.ayU.getIntrinsicHeight()) >> 1, (this.azd.getTop() + this.ayU.getIntrinsicHeight()) - this.ayx);
        this.ayU.setBounds(this.ayW);
        this.ayX.set(this.azd.getLeft() + (this.ayy >> 1) + this.ayz, this.azd.getTop() + (this.ayy >> 1) + this.ayz, (this.azd.getRight() - (this.ayy >> 1)) - this.ayz, (this.azd.getBottom() - (this.ayy >> 1)) - this.ayz);
        if (this.azm == null) {
            this.azm = new SweepGradient(this.ayX.centerX(), this.ayX.centerY(), this.azk, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.azm.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayX.centerX(), this.ayX.centerY());
            this.azm.setLocalMatrix(matrix);
            this.ayV.setShader(this.azm);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void tg() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axR == null) {
            this.axR = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axR.cZ(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
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
            this.axR.AI();
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
        this.ayZ = (TextView) findViewById(d.g.tip_error);
        aj.e(this.ayZ, d.C0108d.cp_cont_i, 1);
        this.aza = (TextView) findViewById(d.g.tip_operator);
        this.azb = (TextView) findViewById(d.g.tip_time_out);
        this.azc = (VoiceButton) findViewById(d.g.voice_bnt);
        this.ayY = (TextView) findViewById(d.g.restart);
        this.azd = (ImageView) findViewById(d.g.play_img);
        this.aze = (TextView) findViewById(d.g.play_time);
        this.aze.setClickable(false);
        this.ayY.setOnClickListener(this);
        this.azd.setOnClickListener(this);
        this.azc.setRecorderView(this);
        tq();
    }

    private void tp() {
        this.azc.setVisibility(4);
        this.aze.setVisibility(0);
        this.ayY.setVisibility(0);
        aj.e(this.aze, d.C0108d.cp_cont_f, 1);
        aj.e(this.ayY, d.C0108d.cp_cont_f, 1);
        aj.s(this.ayY, d.f.but_posts_record_again_selector);
        this.azd.setVisibility(0);
        if (this.mModel != null) {
            this.aze.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.azd.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.azd, d.f.but_posts_record_play_selector);
        }
        aj.e(this.aza, d.C0108d.cp_cont_c, 1);
        this.aza.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        aj.c(this.azc, d.f.but_posts_record_zero_selector);
        this.azc.setVisibility(0);
        this.ayA = 0;
        this.azd.setVisibility(4);
        this.aze.setVisibility(4);
        this.ayY.setVisibility(4);
        this.azb.setVisibility(4);
        aj.e(this.aza, d.C0108d.cp_cont_c, 1);
        this.aza.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tq();
        this.mModel = null;
        this.ayA = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.ayZ.setText("");
        this.ayZ.setVisibility(4);
        this.ayA = 0;
        tp();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tq();
            this.aza.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.azd != null && this.aze != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.aze, d.C0108d.cp_cont_f, 1);
                    this.aze.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.azd, d.f.but_posts_record_play_selector);
                    this.azd.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aza.setText(getContext().getString(d.j.voice_play_tip));
                    ts();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.aze, d.C0108d.cp_cont_f, 1);
                    aj.c(this.azd, d.f.but_posts_record_stop_selector);
                    this.azd.setContentDescription(getContext().getString(d.j.pause_load));
                    this.aza.setText(getContext().getString(d.j.voice_stop_tip));
                    tr();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.azb, d.C0108d.cp_cont_i, 1);
        aj.e(this.ayZ, d.C0108d.cp_cont_i, 1);
        aj.e(this.aza, d.C0108d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.azb.setVisibility(0);
                this.azb.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azb != null) {
                            h.this.azb.setVisibility(4);
                            h.this.azb.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.ayZ.setVisibility(0);
                this.ayZ.setText(str);
                this.aza.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayZ != null) {
                            h.this.ayZ.setVisibility(4);
                            h.this.ayZ.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.ayZ.setVisibility(0);
                this.ayZ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayZ != null) {
                            h.this.ayZ.setVisibility(4);
                            h.this.ayZ.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tq();
                this.ayZ.setVisibility(0);
                this.ayZ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.ayZ != null) {
                            h.this.ayZ.setVisibility(4);
                            h.this.ayZ.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.ayZ.setVisibility(4);
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
        aj.e(this.ayZ, d.C0108d.cp_cont_i, 1);
        this.ayZ.setVisibility(0);
        this.ayZ.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axG = Math.max(i, this.axG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axH > 200) {
            this.axG = 0;
            this.axH = uptimeMillis;
        }
        if (this.axG < 10) {
            this.ayA = 1;
            invalidate();
        } else if (this.axG < 20) {
            this.ayA = 2;
            invalidate();
        } else if (this.axG < 30) {
            this.ayA = 3;
            invalidate();
        } else if (this.axG < 40) {
            this.ayA = 4;
            invalidate();
        } else {
            this.ayA = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (this.mModel != null && this.aze != null) {
            int i2 = i / 1000;
            if (this.azn != i2) {
                this.aze.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azn = i2;
        }
    }

    private void tr() {
        if (this.mModel != null) {
            this.ayA = 0;
            this.azf = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.azi = SystemClock.uptimeMillis();
            this.azj = this.azi + 200;
            this.azl.sendEmptyMessageAtTime(1, this.azj);
            invalidate();
        }
    }

    private void ts() {
        this.ayA = 0;
        this.ayB = 0;
        this.azf = 0.0f;
        this.azg = 0.0f;
        this.azl.removeMessages(1);
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
        this.azh = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void tu() {
        this.ayI = new Paint();
        this.ayI.setAntiAlias(true);
        this.ayI.setStyle(Paint.Style.STROKE);
        this.ayI.setStrokeWidth(2.0f);
        this.ayJ = new Paint();
        this.ayJ.setAntiAlias(true);
        this.ayJ.setStyle(Paint.Style.STROKE);
        this.ayJ.setStrokeWidth(2.0f);
        this.ayK = new Paint();
        this.ayK.setAntiAlias(true);
        this.ayK.setStyle(Paint.Style.STROKE);
        this.ayK.setStrokeWidth(2.0f);
        this.ayL = new Paint();
        this.ayL.setAntiAlias(true);
        this.ayL.setStyle(Paint.Style.STROKE);
        this.ayL.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayI.setColor(this.ayQ);
            this.ayJ.setColor(this.ayR);
            this.ayK.setColor(this.ayS);
            this.ayL.setColor(this.ayT);
        } else {
            this.ayI.setColor(this.ayM);
            this.ayJ.setColor(this.ayN);
            this.ayK.setColor(this.ayO);
            this.ayL.setColor(this.ayP);
        }
        if (this.ayA == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
        } else if (this.ayA == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
        } else if (this.ayA == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
        } else if (this.ayA == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayC, this.ayI);
            canvas.drawCircle(this.centerX, this.centerY, this.ayD, this.ayJ);
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
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
        return this.axP;
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
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
