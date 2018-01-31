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
    private int axI;
    private long axJ;
    private i axQ;
    private int axR;
    private com.baidu.tbadk.core.dialog.a axT;
    private final int ayA;
    private final int ayB;
    private int ayC;
    private int ayD;
    private int ayE;
    private int ayF;
    private int ayG;
    private int ayH;
    private int ayI;
    private int ayJ;
    private Paint ayK;
    private Paint ayL;
    private Paint ayM;
    private Paint ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR;
    private int ayS;
    private int ayT;
    private int ayU;
    private int ayV;
    private final BitmapDrawable ayW;
    private final Paint ayX;
    private final Rect ayY;
    private final RectF ayZ;
    private final int[] ayv;
    private int ayw;
    private final int ayx;
    private final int ayy;
    private final int ayz;
    private TextView aza;
    private TextView azb;
    private TextView azc;
    private TextView azd;
    private VoiceButton aze;
    private ImageView azf;
    private TextView azg;
    private float azh;
    private float azi;
    private g azj;
    private long azk;
    private long azl;
    private final int[] azm;
    private final a azn;
    private SweepGradient azo;
    private int azp;
    private int centerX;
    private int centerY;
    private int kq;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.ayD;
        hVar.ayD = i + 1;
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
                if (h.this.azi >= 360.0f) {
                    h.this.azi = 360.0f;
                    h.this.ayD = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.azk = uptimeMillis;
                    h.this.azl = uptimeMillis + 200;
                    h.this.azi += (((float) (uptimeMillis - h.this.azk)) / 1000.0f) * h.this.azh;
                    sendEmptyMessageAtTime(1, h.this.azl);
                    h.e(h.this);
                }
                h.this.ayC = h.this.ayD % 6;
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
        this.axJ = 0L;
        this.ayv = new int[4];
        this.ayC = 0;
        this.ayD = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.ayE = 0;
        this.ayF = 0;
        this.ayG = 0;
        this.ayH = 0;
        this.ayI = 0;
        this.ayJ = 0;
        this.ayO = -1724676609;
        this.ayP = 1546880511;
        this.ayQ = 674465279;
        this.ayR = 255034879;
        this.ayS = -1725669966;
        this.ayT = 1545887154;
        this.ayU = 673471922;
        this.ayV = 254041522;
        this.ayX = new Paint(1);
        this.ayY = new Rect();
        this.ayZ = new RectF();
        this.axR = 0;
        this.azm = new int[2];
        this.azn = new a();
        this.axI = 0;
        this.azp = 0;
        this.ayv[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.ayv[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.ayv[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.ayv[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.ayE = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.ayF = this.ayE + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayG = this.ayF + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.ayH = this.ayG + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ayI = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ayJ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ayI = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.ayJ = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.kq = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.ayw = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.ayx = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.ayy = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayz = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.ayA = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.ayB = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.ayX.setStyle(Paint.Style.STROKE);
        this.ayX.setStrokeWidth(this.ayA);
        this.ayW = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        av(context);
        tv();
        this.azm[0] = aj.getColor(d.C0108d.common_color_10151);
        this.azm[1] = aj.getColor(d.C0108d.common_color_10152);
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
        int measuredWidth = this.aze.getMeasuredWidth();
        int measuredHeight = this.aze.getMeasuredHeight();
        int measuredWidth2 = this.azb.getMeasuredWidth();
        this.azb.layout((i5 - measuredWidth2) >> 1, this.kq + i2, (measuredWidth2 + i5) >> 1, this.azb.getMeasuredHeight() + this.kq + i2);
        int bottom = this.azb.getBottom();
        this.aze.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.azd.getMeasuredWidth();
        int measuredHeight2 = this.azd.getMeasuredHeight();
        int top = this.aze.getTop();
        this.azd.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.aza.getMeasuredWidth();
        int measuredHeight3 = this.aza.getMeasuredHeight();
        int right = this.aze.getRight() - this.ayw;
        int bottom2 = this.aze.getBottom() - this.ayx;
        this.aza.layout(this.ayI + i6, this.ayJ + bottom, measuredWidth4 + i6 + this.ayI, measuredHeight3 + this.ayJ + bottom);
        int measuredWidth5 = this.azf.getMeasuredWidth();
        this.azf.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.azf.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.azg.getMeasuredWidth();
        this.azg.layout((i5 - measuredWidth6) >> 1, (this.aza.getTop() - this.azg.getMeasuredHeight()) - this.ayy, (measuredWidth6 + i5) >> 1, (this.aza.getTop() + i2) - this.ayy);
        this.aze.getLeft();
        this.aze.getRight();
        int measuredWidth7 = this.azc.getMeasuredWidth();
        int measuredHeight4 = this.azc.getMeasuredHeight();
        int bottom3 = this.aze.getBottom();
        this.azc.layout((i5 - measuredWidth7) >> 1, this.ayv[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ayv[3]);
        this.ayY.set((i5 - this.ayW.getIntrinsicWidth()) >> 1, this.azf.getTop() - this.ayz, (i5 + this.ayW.getIntrinsicHeight()) >> 1, (this.azf.getTop() + this.ayW.getIntrinsicHeight()) - this.ayz);
        this.ayW.setBounds(this.ayY);
        this.ayZ.set(this.azf.getLeft() + (this.ayA >> 1) + this.ayB, this.azf.getTop() + (this.ayA >> 1) + this.ayB, (this.azf.getRight() - (this.ayA >> 1)) - this.ayB, (this.azf.getBottom() - (this.ayA >> 1)) - this.ayB);
        if (this.azo == null) {
            this.azo = new SweepGradient(this.ayZ.centerX(), this.ayZ.centerY(), this.azm, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.azo.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.ayZ.centerX(), this.ayZ.centerY());
            this.azo.setLocalMatrix(matrix);
            this.ayX.setShader(this.azo);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i(canvas);
        super.dispatchDraw(canvas);
    }

    private void th() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axT == null) {
            this.axT = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axT.cZ(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    h.this.tr();
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
            this.axT.AB();
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
        this.azb = (TextView) findViewById(d.g.tip_error);
        aj.e(this.azb, d.C0108d.cp_cont_i, 1);
        this.azc = (TextView) findViewById(d.g.tip_operator);
        this.azd = (TextView) findViewById(d.g.tip_time_out);
        this.aze = (VoiceButton) findViewById(d.g.voice_bnt);
        this.aza = (TextView) findViewById(d.g.restart);
        this.azf = (ImageView) findViewById(d.g.play_img);
        this.azg = (TextView) findViewById(d.g.play_time);
        this.azg.setClickable(false);
        this.aza.setOnClickListener(this);
        this.azf.setOnClickListener(this);
        this.aze.setRecorderView(this);
        tr();
    }

    private void tq() {
        this.aze.setVisibility(4);
        this.azg.setVisibility(0);
        this.aza.setVisibility(0);
        aj.e(this.azg, d.C0108d.cp_cont_f, 1);
        aj.e(this.aza, d.C0108d.cp_cont_f, 1);
        aj.s(this.aza, d.f.but_posts_record_again_selector);
        this.azf.setVisibility(0);
        if (this.mModel != null) {
            this.azg.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.azf.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.azf, d.f.but_posts_record_play_selector);
        }
        aj.e(this.azc, d.C0108d.cp_cont_c, 1);
        this.azc.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr() {
        aj.c(this.aze, d.f.but_posts_record_zero_selector);
        this.aze.setVisibility(0);
        this.ayC = 0;
        this.azf.setVisibility(4);
        this.azg.setVisibility(4);
        this.aza.setVisibility(4);
        this.azd.setVisibility(4);
        aj.e(this.azc, d.C0108d.cp_cont_c, 1);
        this.azc.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        tr();
        this.mModel = null;
        this.ayC = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.azb.setText("");
        this.azb.setVisibility(4);
        this.ayC = 0;
        tq();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            tr();
            this.azc.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.azf != null && this.azg != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.e(this.azg, d.C0108d.cp_cont_f, 1);
                    this.azg.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.azf, d.f.but_posts_record_play_selector);
                    this.azf.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.azc.setText(getContext().getString(d.j.voice_play_tip));
                    tt();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.e(this.azg, d.C0108d.cp_cont_f, 1);
                    aj.c(this.azf, d.f.but_posts_record_stop_selector);
                    this.azf.setContentDescription(getContext().getString(d.j.pause_load));
                    this.azc.setText(getContext().getString(d.j.voice_stop_tip));
                    ts();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.e(this.azd, d.C0108d.cp_cont_i, 1);
        aj.e(this.azb, d.C0108d.cp_cont_i, 1);
        aj.e(this.azc, d.C0108d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.azd.setVisibility(0);
                this.azd.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azd != null) {
                            h.this.azd.setVisibility(4);
                            h.this.azd.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.azb.setVisibility(0);
                this.azb.setText(str);
                this.azc.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azb != null) {
                            h.this.azb.setVisibility(4);
                            h.this.azb.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.azb.setVisibility(0);
                this.azb.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azb != null) {
                            h.this.azb.setVisibility(4);
                            h.this.azb.setText("");
                        }
                    }
                }, 2000L);
            } else {
                tr();
                this.azb.setVisibility(0);
                this.azb.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.azb != null) {
                            h.this.azb.setVisibility(4);
                            h.this.azb.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.azb.setVisibility(4);
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
        aj.e(this.azb, d.C0108d.cp_cont_i, 1);
        this.azb.setVisibility(0);
        this.azb.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.axI = Math.max(i, this.axI);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.axJ > 200) {
            this.axI = 0;
            this.axJ = uptimeMillis;
        }
        if (this.axI < 10) {
            this.ayC = 1;
            invalidate();
        } else if (this.axI < 20) {
            this.ayC = 2;
            invalidate();
        } else if (this.axI < 30) {
            this.ayC = 3;
            invalidate();
        } else if (this.axI < 40) {
            this.ayC = 4;
            invalidate();
        } else {
            this.ayC = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (this.mModel != null && this.azg != null) {
            int i2 = i / 1000;
            if (this.azp != i2) {
                this.azg.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.azp = i2;
        }
    }

    private void ts() {
        if (this.mModel != null) {
            this.ayC = 0;
            this.azh = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.azk = SystemClock.uptimeMillis();
            this.azl = this.azk + 200;
            this.azn.sendEmptyMessageAtTime(1, this.azl);
            invalidate();
        }
    }

    private void tt() {
        this.ayC = 0;
        this.ayD = 0;
        this.azh = 0.0f;
        this.azi = 0.0f;
        this.azn.removeMessages(1);
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
                th();
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
        this.azj = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tu() {
    }

    public void tv() {
        this.ayK = new Paint();
        this.ayK.setAntiAlias(true);
        this.ayK.setStyle(Paint.Style.STROKE);
        this.ayK.setStrokeWidth(2.0f);
        this.ayL = new Paint();
        this.ayL.setAntiAlias(true);
        this.ayL.setStyle(Paint.Style.STROKE);
        this.ayL.setStrokeWidth(2.0f);
        this.ayM = new Paint();
        this.ayM.setAntiAlias(true);
        this.ayM.setStyle(Paint.Style.STROKE);
        this.ayM.setStrokeWidth(2.0f);
        this.ayN = new Paint();
        this.ayN.setAntiAlias(true);
        this.ayN.setStyle(Paint.Style.STROKE);
        this.ayN.setStrokeWidth(2.0f);
    }

    public void i(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ayK.setColor(this.ayS);
            this.ayL.setColor(this.ayT);
            this.ayM.setColor(this.ayU);
            this.ayN.setColor(this.ayV);
        } else {
            this.ayK.setColor(this.ayO);
            this.ayL.setColor(this.ayP);
            this.ayM.setColor(this.ayQ);
            this.ayN.setColor(this.ayR);
        }
        if (this.ayC == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
        } else if (this.ayC == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
        } else if (this.ayC == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
            canvas.drawCircle(this.centerX, this.centerY, this.ayG, this.ayM);
        } else if (this.ayC == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.ayE, this.ayK);
            canvas.drawCircle(this.centerX, this.centerY, this.ayF, this.ayL);
            canvas.drawCircle(this.centerX, this.centerY, this.ayG, this.ayM);
            canvas.drawCircle(this.centerX, this.centerY, this.ayH, this.ayN);
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
                    tq();
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
    public void ti() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
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
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
