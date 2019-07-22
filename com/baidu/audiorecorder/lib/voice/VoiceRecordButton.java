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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int TL;
    private long TM;
    private EditorTools TU;
    private int TV;
    private com.baidu.tbadk.core.dialog.a TX;
    private int UB;
    private final int UC;
    private final int UD;
    private final int UE;
    private final int UF;
    private final int UG;
    private int UH;
    private int UI;
    private int UJ;
    private int UK;
    private int UL;
    private int UM;
    private int UN;
    private int UO;
    private int UQ;
    private int UR;
    private Paint US;
    private Paint UT;
    private Paint UU;
    private Paint UV;
    private int UW;
    private int UX;
    private int UY;
    private int UZ;
    private final int[] Uz;
    private int Va;
    private int Vb;
    private int Vc;
    private int Vd;
    private final BitmapDrawable Ve;
    private final Paint Vf;
    private final Rect Vg;
    private final RectF Vh;
    private TextView Vi;
    private TextView Vj;
    private TextView Vk;
    private TextView Vl;
    private VoiceButton Vm;
    private ImageView Vn;
    private TextView Vo;
    private float Vp;
    private float Vq;
    private f Vr;
    private long Vs;
    private long Vt;
    private final int[] Vu;
    private final a Vv;
    private SweepGradient Vw;
    private int Vx;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.UI;
        voiceRecordButton.UI = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.Vq >= 360.0f) {
                    VoiceRecordButton.this.Vq = 360.0f;
                    VoiceRecordButton.this.UI = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Vs = uptimeMillis;
                    VoiceRecordButton.this.Vt = uptimeMillis + 200;
                    VoiceRecordButton.this.Vq += (((float) (uptimeMillis - VoiceRecordButton.this.Vs)) / 1000.0f) * VoiceRecordButton.this.Vp;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Vt);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.UH = VoiceRecordButton.this.UI % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton an(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TM = 0L;
        this.Uz = new int[4];
        this.UH = 0;
        this.UI = 0;
        this.UJ = 0;
        this.UK = 0;
        this.UL = 0;
        this.UM = 0;
        this.UN = 0;
        this.UO = 0;
        this.UQ = 0;
        this.UR = 0;
        this.UW = -1724676609;
        this.UX = 1546880511;
        this.UY = 674465279;
        this.UZ = 255034879;
        this.Va = -1725669966;
        this.Vb = 1545887154;
        this.Vc = 673471922;
        this.Vd = 254041522;
        this.Vf = new Paint(1);
        this.Vg = new Rect();
        this.Vh = new RectF();
        this.TV = 0;
        this.Vu = new int[2];
        this.Vv = new a();
        this.TL = 0;
        this.Vx = 0;
        this.Uz[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Uz[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Uz[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Uz[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.UL = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.UM = this.UL + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.UN = this.UM + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.UO = this.UN + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.UQ = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.UR = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.UQ = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.UR = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.UB = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.UC = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.UD = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.UE = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.UF = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.UG = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.Vf.setStyle(Paint.Style.STROKE);
        this.Vf.setStrokeWidth(this.UF);
        this.Ve = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ao(context);
        qy();
        this.Vu[0] = am.getColor(R.color.common_color_10151);
        this.Vu[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.Vm.getMeasuredWidth();
        int measuredHeight = this.Vm.getMeasuredHeight();
        int measuredWidth2 = this.Vj.getMeasuredWidth();
        this.Vj.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Vj.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Vj.getBottom();
        this.Vm.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.UJ = (measuredWidth / 2) + i6;
        this.UK = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Vl.getMeasuredWidth();
        int measuredHeight2 = this.Vl.getMeasuredHeight();
        int top = this.Vm.getTop();
        this.Vl.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Vi.getMeasuredWidth();
        int measuredHeight3 = this.Vi.getMeasuredHeight();
        int right = this.Vm.getRight() - this.UB;
        int bottom2 = this.Vm.getBottom() - this.UC;
        this.Vi.layout(this.UQ + i6, this.UR + bottom, measuredWidth4 + i6 + this.UQ, measuredHeight3 + this.UR + bottom);
        int measuredWidth5 = this.Vn.getMeasuredWidth();
        this.Vn.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Vn.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Vo.getMeasuredWidth();
        this.Vo.layout((i5 - measuredWidth6) >> 1, (this.Vi.getTop() - this.Vo.getMeasuredHeight()) - this.UD, (measuredWidth6 + i5) >> 1, (this.Vi.getTop() + i2) - this.UD);
        this.Vm.getLeft();
        this.Vm.getRight();
        int measuredWidth7 = this.Vk.getMeasuredWidth();
        int measuredHeight4 = this.Vk.getMeasuredHeight();
        int bottom3 = this.Vm.getBottom();
        this.Vk.layout((i5 - measuredWidth7) >> 1, this.Uz[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Uz[3]);
        this.Vg.set((i5 - this.Ve.getIntrinsicWidth()) >> 1, this.Vn.getTop() - this.UE, (i5 + this.Ve.getIntrinsicHeight()) >> 1, (this.Vn.getTop() + this.Ve.getIntrinsicHeight()) - this.UE);
        this.Ve.setBounds(this.Vg);
        this.Vh.set(this.Vn.getLeft() + (this.UF >> 1) + this.UG, this.Vn.getTop() + (this.UF >> 1) + this.UG, (this.Vn.getRight() - (this.UF >> 1)) - this.UG, (this.Vn.getBottom() - (this.UF >> 1)) - this.UG);
        if (this.Vw == null) {
            this.Vw = new SweepGradient(this.Vh.centerX(), this.Vh.centerY(), this.Vu, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Vw.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Vh.centerX(), this.Vh.centerY());
            this.Vw.setLocalMatrix(matrix);
            this.Vf.setShader(this.Vw);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qj() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.TX == null) {
            this.TX = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.TX.mO(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qu();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cf(VoiceRecordButton.this.mModel.voiceId);
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
            this.TX.agI();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cf(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Vj = (TextView) findViewById(R.id.tip_error);
        am.f(this.Vj, R.color.cp_btn_a, 1);
        this.Vk = (TextView) findViewById(R.id.tip_operator);
        this.Vl = (TextView) findViewById(R.id.tip_time_out);
        this.Vm = (VoiceButton) findViewById(R.id.voice_bnt);
        this.Vi = (TextView) findViewById(R.id.restart);
        this.Vn = (ImageView) findViewById(R.id.play_img);
        this.Vo = (TextView) findViewById(R.id.play_time);
        this.Vo.setClickable(false);
        this.Vi.setOnClickListener(this);
        this.Vn.setOnClickListener(this);
        this.Vm.setRecorderView(this);
        qu();
    }

    private void qt() {
        this.Vm.setVisibility(4);
        this.Vo.setVisibility(0);
        this.Vi.setVisibility(0);
        am.f(this.Vo, R.color.cp_cont_f, 1);
        am.f(this.Vi, R.color.cp_cont_f, 1);
        am.k(this.Vi, R.drawable.but_posts_record_again_selector);
        this.Vn.setVisibility(0);
        if (this.mModel != null) {
            this.Vo.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Vn.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.c(this.Vn, (int) R.drawable.but_posts_record_play_selector);
        }
        am.f(this.Vk, R.color.cp_cont_c, 1);
        this.Vk.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu() {
        am.c(this.Vm, (int) R.drawable.but_posts_record_zero_selector);
        this.Vm.setVisibility(0);
        this.UH = 0;
        this.Vn.setVisibility(4);
        this.Vo.setVisibility(4);
        this.Vi.setVisibility(4);
        this.Vl.setVisibility(4);
        am.f(this.Vk, R.color.cp_cont_c, 1);
        this.Vk.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qu();
        this.mModel = null;
        this.UH = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Vj.setText("");
        this.Vj.setVisibility(4);
        this.UH = 0;
        qt();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qu();
            this.Vk.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.Vn != null && this.Vo != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.f(this.Vo, R.color.cp_cont_f, 1);
                    this.Vo.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.c(this.Vn, (int) R.drawable.but_posts_record_play_selector);
                    this.Vn.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Vk.setText(getContext().getString(R.string.voice_play_tip));
                    qw();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.f(this.Vo, R.color.cp_cont_f, 1);
                    am.c(this.Vn, (int) R.drawable.but_posts_record_stop_selector);
                    this.Vn.setContentDescription(getContext().getString(R.string.pause_load));
                    this.Vk.setText(getContext().getString(R.string.voice_stop_tip));
                    qv();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.f(this.Vl, R.color.cp_btn_a, 1);
        am.f(this.Vj, R.color.cp_btn_a, 1);
        am.f(this.Vk, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Vl.setVisibility(0);
                this.Vl.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vl != null) {
                            VoiceRecordButton.this.Vl.setVisibility(4);
                            VoiceRecordButton.this.Vl.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Vj.setVisibility(0);
                this.Vj.setText(str);
                this.Vk.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vj != null) {
                            VoiceRecordButton.this.Vj.setVisibility(4);
                            VoiceRecordButton.this.Vj.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Vj.setVisibility(0);
                this.Vj.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vj != null) {
                            VoiceRecordButton.this.Vj.setVisibility(4);
                            VoiceRecordButton.this.Vj.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qu();
                this.Vj.setVisibility(0);
                this.Vj.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Vj != null) {
                            VoiceRecordButton.this.Vj.setVisibility(4);
                            VoiceRecordButton.this.Vj.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Vj.setVisibility(4);
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
        am.f(this.Vj, R.color.cp_btn_a, 1);
        this.Vj.setVisibility(0);
        this.Vj.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.TL = Math.max(i, this.TL);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.TM > 200) {
            this.TL = 0;
            this.TM = uptimeMillis;
        }
        if (this.TL < 10) {
            this.UH = 1;
            invalidate();
        } else if (this.TL < 20) {
            this.UH = 2;
            invalidate();
        } else if (this.TL < 30) {
            this.UH = 3;
            invalidate();
        } else if (this.TL < 40) {
            this.UH = 4;
            invalidate();
        } else {
            this.UH = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (this.mModel != null && this.Vo != null) {
            int i2 = i / 1000;
            if (this.Vx != i2) {
                this.Vo.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Vx = i2;
        }
    }

    private void qv() {
        if (this.mModel != null) {
            this.UH = 0;
            this.Vp = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Vs = SystemClock.uptimeMillis();
            this.Vt = this.Vs + 200;
            this.Vv.sendEmptyMessageAtTime(1, this.Vt);
            invalidate();
        }
    }

    private void qw() {
        this.UH = 0;
        this.UI = 0;
        this.Vp = 0.0f;
        this.Vq = 0.0f;
        this.Vv.removeMessages(1);
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
                qj();
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
        this.Vr = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qx() {
    }

    public void qy() {
        this.US = new Paint();
        this.US.setAntiAlias(true);
        this.US.setStyle(Paint.Style.STROKE);
        this.US.setStrokeWidth(2.0f);
        this.UT = new Paint();
        this.UT.setAntiAlias(true);
        this.UT.setStyle(Paint.Style.STROKE);
        this.UT.setStrokeWidth(2.0f);
        this.UU = new Paint();
        this.UU.setAntiAlias(true);
        this.UU.setStyle(Paint.Style.STROKE);
        this.UU.setStrokeWidth(2.0f);
        this.UV = new Paint();
        this.UV.setAntiAlias(true);
        this.UV.setStyle(Paint.Style.STROKE);
        this.UV.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.US.setColor(this.Va);
            this.UT.setColor(this.Vb);
            this.UU.setColor(this.Vc);
            this.UV.setColor(this.Vd);
        } else {
            this.US.setColor(this.UW);
            this.UT.setColor(this.UX);
            this.UU.setColor(this.UY);
            this.UV.setColor(this.UZ);
        }
        if (this.UH == 2) {
            canvas.drawCircle(this.UJ, this.UK, this.UL, this.US);
        } else if (this.UH == 3) {
            canvas.drawCircle(this.UJ, this.UK, this.UL, this.US);
            canvas.drawCircle(this.UJ, this.UK, this.UM, this.UT);
        } else if (this.UH == 4) {
            canvas.drawCircle(this.UJ, this.UK, this.UL, this.US);
            canvas.drawCircle(this.UJ, this.UK, this.UM, this.UT);
            canvas.drawCircle(this.UJ, this.UK, this.UN, this.UU);
        } else if (this.UH == 5) {
            canvas.drawCircle(this.UJ, this.UK, this.UL, this.US);
            canvas.drawCircle(this.UJ, this.UK, this.UM, this.UT);
            canvas.drawCircle(this.UJ, this.UK, this.UN, this.UU);
            canvas.drawCircle(this.UJ, this.UK, this.UO, this.UV);
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
                    qt();
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
    public void qk() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
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
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
