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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private EditorTools TB;
    private int TC;
    private com.baidu.tbadk.core.dialog.a TF;
    private int Tt;
    private long Tu;
    private Paint UB;
    private int UC;
    private int UD;
    private int UE;
    private int UF;
    private int UG;
    private int UH;
    private int UI;
    private int UJ;
    private final BitmapDrawable UK;
    private final Paint UL;
    private final Rect UM;
    private final RectF UN;
    private TextView UO;
    private TextView UQ;
    private TextView UR;
    private TextView US;
    private VoiceButton UT;
    private ImageView UU;
    private TextView UV;
    private float UW;
    private float UX;
    private f UY;
    private long UZ;
    private final int[] Ui;
    private int Uj;
    private final int Uk;
    private final int Ul;
    private final int Um;
    private final int Un;
    private final int Uo;
    private int Up;
    private int Uq;
    private int Ur;
    private int Us;
    private int Ut;
    private int Uu;
    private int Uv;
    private int Uw;
    private Paint Ux;
    private Paint Uy;
    private Paint Uz;
    private long Va;
    private final int[] Vb;
    private final a Vc;
    private SweepGradient Vd;
    private int Ve;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Uq;
        voiceRecordButton.Uq = i + 1;
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
                if (VoiceRecordButton.this.UX >= 360.0f) {
                    VoiceRecordButton.this.UX = 360.0f;
                    VoiceRecordButton.this.Uq = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.UZ = uptimeMillis;
                    VoiceRecordButton.this.Va = uptimeMillis + 200;
                    VoiceRecordButton.this.UX += (((float) (uptimeMillis - VoiceRecordButton.this.UZ)) / 1000.0f) * VoiceRecordButton.this.UW;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Va);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Up = VoiceRecordButton.this.Uq % 6;
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
        this.Tu = 0L;
        this.Ui = new int[4];
        this.Up = 0;
        this.Uq = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Ur = 0;
        this.Us = 0;
        this.Ut = 0;
        this.Uu = 0;
        this.Uv = 0;
        this.Uw = 0;
        this.UC = -1724676609;
        this.UD = 1546880511;
        this.UE = 674465279;
        this.UF = 255034879;
        this.UG = -1725669966;
        this.UH = 1545887154;
        this.UI = 673471922;
        this.UJ = 254041522;
        this.UL = new Paint(1);
        this.UM = new Rect();
        this.UN = new RectF();
        this.TC = 0;
        this.Vb = new int[2];
        this.Vc = new a();
        this.Tt = 0;
        this.Ve = 0;
        this.Ui[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Ui[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Ui[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Ui[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.Ur = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.Us = this.Ur + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Ut = this.Us + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.Uu = this.Ut + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Uv = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Uw = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Uv = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.Uw = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.Uj = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.Uk = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Ul = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Um = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Un = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.Uo = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.UL.setStyle(Paint.Style.STROKE);
        this.UL.setStrokeWidth(this.Un);
        this.UK = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ao(context);
        qc();
        this.Vb[0] = al.getColor(R.color.common_color_10151);
        this.Vb[1] = al.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.UT.getMeasuredWidth();
        int measuredHeight = this.UT.getMeasuredHeight();
        int measuredWidth2 = this.UQ.getMeasuredWidth();
        this.UQ.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.UQ.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.UQ.getBottom();
        this.UT.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.US.getMeasuredWidth();
        int measuredHeight2 = this.US.getMeasuredHeight();
        int top = this.UT.getTop();
        this.US.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.UO.getMeasuredWidth();
        int measuredHeight3 = this.UO.getMeasuredHeight();
        int right = this.UT.getRight() - this.Uj;
        int bottom2 = this.UT.getBottom() - this.Uk;
        this.UO.layout(this.Uv + i6, this.Uw + bottom, measuredWidth4 + i6 + this.Uv, measuredHeight3 + this.Uw + bottom);
        int measuredWidth5 = this.UU.getMeasuredWidth();
        this.UU.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.UU.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.UV.getMeasuredWidth();
        this.UV.layout((i5 - measuredWidth6) >> 1, (this.UO.getTop() - this.UV.getMeasuredHeight()) - this.Ul, (measuredWidth6 + i5) >> 1, (this.UO.getTop() + i2) - this.Ul);
        this.UT.getLeft();
        this.UT.getRight();
        int measuredWidth7 = this.UR.getMeasuredWidth();
        int measuredHeight4 = this.UR.getMeasuredHeight();
        int bottom3 = this.UT.getBottom();
        this.UR.layout((i5 - measuredWidth7) >> 1, this.Ui[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Ui[3]);
        this.UM.set((i5 - this.UK.getIntrinsicWidth()) >> 1, this.UU.getTop() - this.Um, (i5 + this.UK.getIntrinsicHeight()) >> 1, (this.UU.getTop() + this.UK.getIntrinsicHeight()) - this.Um);
        this.UK.setBounds(this.UM);
        this.UN.set(this.UU.getLeft() + (this.Un >> 1) + this.Uo, this.UU.getTop() + (this.Un >> 1) + this.Uo, (this.UU.getRight() - (this.Un >> 1)) - this.Uo, (this.UU.getBottom() - (this.Un >> 1)) - this.Uo);
        if (this.Vd == null) {
            this.Vd = new SweepGradient(this.UN.centerX(), this.UN.centerY(), this.Vb, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Vd.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.UN.centerX(), this.UN.centerY());
            this.Vd.setLocalMatrix(matrix);
            this.UL.setShader(this.Vd);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pN() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.TF == null) {
            this.TF = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.TF.mE(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.pY();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cd(VoiceRecordButton.this.mModel.voiceId);
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
            this.TF.afG();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cd(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.UQ = (TextView) findViewById(R.id.tip_error);
        al.f(this.UQ, R.color.cp_btn_a, 1);
        this.UR = (TextView) findViewById(R.id.tip_operator);
        this.US = (TextView) findViewById(R.id.tip_time_out);
        this.UT = (VoiceButton) findViewById(R.id.voice_bnt);
        this.UO = (TextView) findViewById(R.id.restart);
        this.UU = (ImageView) findViewById(R.id.play_img);
        this.UV = (TextView) findViewById(R.id.play_time);
        this.UV.setClickable(false);
        this.UO.setOnClickListener(this);
        this.UU.setOnClickListener(this);
        this.UT.setRecorderView(this);
        pY();
    }

    private void pX() {
        this.UT.setVisibility(4);
        this.UV.setVisibility(0);
        this.UO.setVisibility(0);
        al.f(this.UV, R.color.cp_cont_f, 1);
        al.f(this.UO, R.color.cp_cont_f, 1);
        al.k(this.UO, R.drawable.but_posts_record_again_selector);
        this.UU.setVisibility(0);
        if (this.mModel != null) {
            this.UV.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.UU.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.UU, (int) R.drawable.but_posts_record_play_selector);
        }
        al.f(this.UR, R.color.cp_cont_c, 1);
        this.UR.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY() {
        al.c(this.UT, (int) R.drawable.but_posts_record_zero_selector);
        this.UT.setVisibility(0);
        this.Up = 0;
        this.UU.setVisibility(4);
        this.UV.setVisibility(4);
        this.UO.setVisibility(4);
        this.US.setVisibility(4);
        al.f(this.UR, R.color.cp_cont_c, 1);
        this.UR.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        pY();
        this.mModel = null;
        this.Up = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.UQ.setText("");
        this.UQ.setVisibility(4);
        this.Up = 0;
        pX();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            pY();
            this.UR.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.UU != null && this.UV != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.f(this.UV, R.color.cp_cont_f, 1);
                    this.UV.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.UU, (int) R.drawable.but_posts_record_play_selector);
                    this.UU.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.UR.setText(getContext().getString(R.string.voice_play_tip));
                    qa();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.f(this.UV, R.color.cp_cont_f, 1);
                    al.c(this.UU, (int) R.drawable.but_posts_record_stop_selector);
                    this.UU.setContentDescription(getContext().getString(R.string.pause_load));
                    this.UR.setText(getContext().getString(R.string.voice_stop_tip));
                    pZ();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.f(this.US, R.color.cp_btn_a, 1);
        al.f(this.UQ, R.color.cp_btn_a, 1);
        al.f(this.UR, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.US.setVisibility(0);
                this.US.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.US != null) {
                            VoiceRecordButton.this.US.setVisibility(4);
                            VoiceRecordButton.this.US.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.UQ.setVisibility(0);
                this.UQ.setText(str);
                this.UR.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UQ != null) {
                            VoiceRecordButton.this.UQ.setVisibility(4);
                            VoiceRecordButton.this.UQ.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.UQ.setVisibility(0);
                this.UQ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UQ != null) {
                            VoiceRecordButton.this.UQ.setVisibility(4);
                            VoiceRecordButton.this.UQ.setText("");
                        }
                    }
                }, 2000L);
            } else {
                pY();
                this.UQ.setVisibility(0);
                this.UQ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UQ != null) {
                            VoiceRecordButton.this.UQ.setVisibility(4);
                            VoiceRecordButton.this.UQ.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.UQ.setVisibility(4);
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
        al.f(this.UQ, R.color.cp_btn_a, 1);
        this.UQ.setVisibility(0);
        this.UQ.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Tt = Math.max(i, this.Tt);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tu > 200) {
            this.Tt = 0;
            this.Tu = uptimeMillis;
        }
        if (this.Tt < 10) {
            this.Up = 1;
            invalidate();
        } else if (this.Tt < 20) {
            this.Up = 2;
            invalidate();
        } else if (this.Tt < 30) {
            this.Up = 3;
            invalidate();
        } else if (this.Tt < 40) {
            this.Up = 4;
            invalidate();
        } else {
            this.Up = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (this.mModel != null && this.UV != null) {
            int i2 = i / 1000;
            if (this.Ve != i2) {
                this.UV.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Ve = i2;
        }
    }

    private void pZ() {
        if (this.mModel != null) {
            this.Up = 0;
            this.UW = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.UZ = SystemClock.uptimeMillis();
            this.Va = this.UZ + 200;
            this.Vc.sendEmptyMessageAtTime(1, this.Va);
            invalidate();
        }
    }

    private void qa() {
        this.Up = 0;
        this.Uq = 0;
        this.UW = 0.0f;
        this.UX = 0.0f;
        this.Vc.removeMessages(1);
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
                pN();
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
        this.UY = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qb() {
    }

    public void qc() {
        this.Ux = new Paint();
        this.Ux.setAntiAlias(true);
        this.Ux.setStyle(Paint.Style.STROKE);
        this.Ux.setStrokeWidth(2.0f);
        this.Uy = new Paint();
        this.Uy.setAntiAlias(true);
        this.Uy.setStyle(Paint.Style.STROKE);
        this.Uy.setStrokeWidth(2.0f);
        this.Uz = new Paint();
        this.Uz.setAntiAlias(true);
        this.Uz.setStyle(Paint.Style.STROKE);
        this.Uz.setStrokeWidth(2.0f);
        this.UB = new Paint();
        this.UB.setAntiAlias(true);
        this.UB.setStyle(Paint.Style.STROKE);
        this.UB.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Ux.setColor(this.UG);
            this.Uy.setColor(this.UH);
            this.Uz.setColor(this.UI);
            this.UB.setColor(this.UJ);
        } else {
            this.Ux.setColor(this.UC);
            this.Uy.setColor(this.UD);
            this.Uz.setColor(this.UE);
            this.UB.setColor(this.UF);
        }
        if (this.Up == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
        } else if (this.Up == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
            canvas.drawCircle(this.centerX, this.centerY, this.Us, this.Uy);
        } else if (this.Up == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
            canvas.drawCircle(this.centerX, this.centerY, this.Us, this.Uy);
            canvas.drawCircle(this.centerX, this.centerY, this.Ut, this.Uz);
        } else if (this.Up == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
            canvas.drawCircle(this.centerX, this.centerY, this.Us, this.Uy);
            canvas.drawCircle(this.centerX, this.centerY, this.Ut, this.Uz);
            canvas.drawCircle(this.centerX, this.centerY, this.Uu, this.UB);
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
                    pX();
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
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
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
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
