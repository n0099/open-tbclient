package com.baidu.c.a.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.c.a.e.b;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes10.dex */
public class a {
    public final int Qv;
    public final int Qw;
    public String RA;
    public String RB;
    public String RC;
    public int RD;
    public int RE;
    public int RF;
    public String RG;
    public String RH;
    public double RI;
    public double RJ;
    private String RK;
    private String RL;
    private String RO;
    private String RP;
    private String RQ;
    private String RR;
    private double RT;
    private double RU;
    private double RV;
    private double RW;
    private double RX;
    private double RY;
    private double RZ;
    public String Re;
    public String Rm;
    protected int Rr;
    protected int Rs;
    protected int Rt;
    private CriusNode Ru;
    public final CriusNode Rv;
    private TextView Rw;
    private final CriusMeasureFunction Rx;
    public String Ry;
    public String Rz;
    public String SA;
    public String SB;
    public String SC;
    public String SD;
    public String SF;
    public String SG;
    public String SH;
    public String SJ;
    public String SK;
    public double SL;
    public String SM;
    public String SO;
    public String SQ;
    public String SR;
    public String SS;
    public final List<a> ST;
    private double Sa;
    private double Sb;
    private double Sc;
    private double Se;
    private double Sf;
    private double Sg;
    private double Sh;
    private double Si;
    private double Sj;
    private double Sk;
    private double Sl;
    private double Sm;
    private double Sn;
    private double So;
    private double Sp;
    private double Sq;
    public String Sr;
    public double Ss;
    public double St;
    public double Su;
    public double Sv;
    public double Sw;
    public String Sx;
    public String Sy;
    public Typeface Sz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0048a businessConverter;
    public String color;
    public final float density;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0048a {
        String cv(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public void a(@NonNull StaticLayout.Builder builder, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = builder.getClass().getDeclaredMethod("setUseLineSpacingFromFallbacks", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.valueOf(z));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, a aVar) {
        if (!TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                }
                textView.setMaxLines(aVar.maxLines);
            }
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Double.compare(aVar.nQ(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.nQ() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.Sz);
            textView.setGravity(aVar.gravity);
            float d = aVar.RI > 0.0d ? d(aVar.RI) : 0.0f;
            float f = aVar.RJ > 0.0d ? (float) aVar.RJ : 1.0f;
            if (d > 0.0f || f > 0.0f) {
                textView.setLineSpacing(d, f);
            }
        }
    }

    public static boolean cr(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float H(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cr(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void d(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (ow()) {
            this.Rv.setMeasureFunction(this.Rx);
        }
        this.Ry = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.Re = b.g(jSONObject, "poster");
        this.Rz = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Ry) && this.businessConverter != null) {
            this.text = this.businessConverter.cv(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.RI = b.h(jSONObject, "line-space");
        this.RJ = b.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.RA = jSONObject.optString("data-als-stat");
        this.RB = jSONObject.optString("data-url-stat");
        this.RC = jSONObject.optString("data-href-pop");
        this.RD = b.i(jSONObject, "data-share-num");
        this.RE = b.i(jSONObject, "data-reply-num");
        this.RF = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.RG = jSONObject.optString("data-share-image");
        this.RH = jSONObject.optString("data-share-link");
    }

    private void e(JSONObject jSONObject) {
        this.RK = b.g(jSONObject, LogConfig.KEY_DISPLAY);
        oo();
        this.RL = b.g(jSONObject, "flex-direction");
        ov();
        this.RO = b.g(jSONObject, "justify-content");
        ou();
        this.RP = b.g(jSONObject, "align-items");
        ot();
        this.RQ = b.g(jSONObject, "align-self");
        os();
        this.RR = b.g(jSONObject, "align-content");
        or();
        this.RT = b.h(jSONObject, "flex");
        on();
        this.RU = b.h(jSONObject, "flex-grow");
        om();
        this.RV = b.h(jSONObject, "flex-shrink");
        ol();
        this.RW = b.h(jSONObject, "flex-basis");
        ok();
        this.position = b.g(jSONObject, "position");
        oq();
        this.RX = b.h(jSONObject, "left");
        this.RY = b.h(jSONObject, VerticalTranslateLayout.TOP);
        this.RZ = b.h(jSONObject, HorizontalTranslateLayout.RIGHT);
        this.Sa = b.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        op();
        this.Sb = b.h(jSONObject, "margin");
        oj();
        this.Sc = b.h(jSONObject, "margin-left");
        oe();
        this.Se = b.h(jSONObject, "margin-top");
        oi();
        this.Sf = b.h(jSONObject, "margin-right");
        oh();
        this.Sg = b.h(jSONObject, "margin-bottom");
        og();
        this.Sh = b.h(jSONObject, "padding");
        initPadding();
        this.Si = b.h(jSONObject, "padding-left");
        oa();
        this.Sj = b.h(jSONObject, "padding-top");
        od();
        this.Sk = b.h(jSONObject, "padding-right");
        oc();
        this.Sl = b.h(jSONObject, "padding-bottom");
        ob();
        this.width = b.h(jSONObject, "width");
        nZ();
        this.height = b.h(jSONObject, "height");
        nY();
        this.Sm = b.h(jSONObject, "min-width");
        nX();
        this.Sn = b.h(jSONObject, "min-height");
        nW();
        this.So = b.h(jSONObject, "max-width");
        nT();
        this.Sp = b.h(jSONObject, "max-height");
        nV();
        this.Sq = b.h(jSONObject, "aspect-ratio");
        nU();
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.SO = b.g(optJSONObject, "background-image");
            this.SQ = b.g(optJSONObject, "background-color");
            this.SR = b.g(optJSONObject, "border-color");
            this.SS = b.g(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.SH = b.g(jSONObject, "background-image");
        this.SJ = b.g(jSONObject, "background-color");
        this.SK = b.g(jSONObject, "border-color");
        this.SL = b.h(jSONObject, "opacity");
        this.SM = b.g(jSONObject, "color");
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.SC = b.g(optJSONObject, "background-image");
            this.SD = b.g(optJSONObject, "background-color");
            this.SF = b.g(optJSONObject, "border-color");
            this.SG = b.g(optJSONObject, "color");
        }
    }

    private void i(JSONObject jSONObject) {
        this.Sr = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.Ss = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.St = b.h(jSONObject, "border-top-left-radius");
        this.Su = b.h(jSONObject, "border-bottom-left-radius");
        this.Sv = b.h(jSONObject, "border-top-right-radius");
        this.Sw = b.h(jSONObject, "border-bottom-right-radius");
        this.Sx = b.g(jSONObject, "font-style");
        this.Sy = b.g(jSONObject, "font-weight");
        this.Sz = Typeface.create(Typeface.DEFAULT, nR());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.SA = b.g(jSONObject, "text-align");
        this.SB = b.g(jSONObject, "vertical-align");
        this.gravity = nS();
        this.Rm = b.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0048a interfaceC0048a, boolean z) {
        this.Rr = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.Rs = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.Rt = 0;
        this.Rx = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.Rw, a.this);
                TextPaint paint = a.this.Rw.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.RI > 0.0d) {
                    f3 = a.this.d(a.this.RI);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.RJ > 0.0d ? (float) a.this.RJ : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Rr).setHyphenationFrequency(a.this.Rs);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.Rt);
                        }
                        a.this.a(hyphenationFrequency, true);
                        build2 = hyphenationFrequency.build();
                    }
                    z2 = false;
                    build = build2;
                } else if (isBoring != null && (z3 || isBoring.width <= f)) {
                    build = BoringLayout.make(spannableString, paint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, f4, f3, isBoring, false);
                    z2 = true;
                } else if (Build.VERSION.SDK_INT < 23) {
                    Layout staticLayout = new StaticLayout(spannableString, paint, (int) f, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    z2 = false;
                    build = staticLayout;
                } else {
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Rr).setHyphenationFrequency(a.this.Rs);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.Rt);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.H(build.getWidth()), a.this.G(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float H = a.this.H(build.getWidth());
                    float G = a.this.G(build.getHeight());
                    if (!z2) {
                        boolean z4 = false;
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            if (Build.VERSION.SDK_INT < 23) {
                                z4 = true;
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            float lineDescent = (build.getLineDescent(0) - build.getLineAscent(0)) - f3;
                            float lineCount = ((build.getLineCount() - 1) * f3) + (build.getLineCount() * lineDescent);
                            if (lineDescent > 0.0f && G > lineCount) {
                                G -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(H, G);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.SL = -10000.0d;
        this.Rv = new CriusNode();
        this.businessConverter = interfaceC0048a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.Qv = context.getResources().getDisplayMetrics().widthPixels;
        this.Qw = context.getResources().getDisplayMetrics().heightPixels;
        this.Rw = new TextView(context);
        d(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            e(optJSONObject);
            i(optJSONObject);
            h(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            g(optJSONObject2);
            f(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ST = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0048a, false);
                    this.ST.add(aVar);
                    this.Rv.addChildAt(aVar.Rv, i);
                }
            } else {
                this.ST = null;
            }
        } else {
            this.ST = null;
        }
        if (z) {
            this.Ru = new CriusNode();
            this.Ru.addChildAt(this.Rv, 0);
            this.Ru.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double nQ() {
        return this.fontSize;
    }

    private int nR() {
        return "italic".equalsIgnoreCase(this.Sx) ? (TextUtils.isEmpty(this.Sy) || "normal".equalsIgnoreCase(this.Sy) || !"bold".equalsIgnoreCase(this.Sy)) ? 2 : 3 : (TextUtils.isEmpty(this.Sy) || "normal".equalsIgnoreCase(this.Sy) || !"bold".equalsIgnoreCase(this.Sy)) ? 0 : 1;
    }

    private int nS() {
        int i;
        if ("left".equalsIgnoreCase(this.SA)) {
            i = 3;
        } else if (HorizontalTranslateLayout.RIGHT.equalsIgnoreCase(this.SA)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.SA)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.SB)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.SB)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.SB)) {
            return i | 16;
        }
        return i | 0;
    }

    private void nT() {
        if (this.So >= 0.0d) {
            this.Rv.setMaxWidth(d(this.So));
        } else if (this.So > -10000.0d) {
            this.Rv.setMaxWidth(this.Qv);
        }
    }

    private void nU() {
        if (this.Sq > 0.0d) {
            this.Rv.setAspectRatio((float) this.Sq);
        }
    }

    private void nV() {
        if (this.Sp >= 0.0d) {
            this.Rv.setMaxHeight(d(this.Sp));
        } else if (this.Sp > -10000.0d) {
            this.Rv.setMaxHeight(this.Qw);
        }
    }

    private void nW() {
        if (this.Sn >= 0.0d) {
            this.Rv.setMinHeight(d(this.Sn));
        } else if (this.Sn > -10000.0d) {
            this.Rv.setMinHeight(this.Qw);
        }
    }

    private void nX() {
        if (this.Sm >= 0.0d) {
            this.Rv.setMinWidth(d(this.Sm));
        } else if (this.Sm > -10000.0d) {
            this.Rv.setMinWidth(this.Qv);
        }
    }

    private void nY() {
        if (this.height >= 0.0d) {
            this.Rv.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.Rv.setHeight(this.Qw);
        }
    }

    private void nZ() {
        if (this.width >= 0.0d) {
            this.Rv.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.Rv.setWidth(this.Qv);
        }
    }

    private void oa() {
        if (this.Si >= -1.0d) {
            this.Rv.setPadding(CriusEdge.LEFT, d(this.Si));
        }
    }

    private void ob() {
        if (this.Sl >= -1.0d) {
            this.Rv.setPadding(CriusEdge.BOTTOM, d(this.Sl));
        }
    }

    private void oc() {
        if (this.Sk >= -1.0d) {
            this.Rv.setPadding(CriusEdge.RIGHT, d(this.Sk));
        }
    }

    private void od() {
        if (this.Sj >= -1.0d) {
            this.Rv.setPadding(CriusEdge.TOP, d(this.Sj));
        }
    }

    private void initPadding() {
        if (this.Sh >= -1.0d) {
            this.Rv.setPadding(CriusEdge.ALL, d(this.Sh));
        }
    }

    private void oe() {
        if (this.Sc >= -1.0d) {
            this.Rv.setMargin(CriusEdge.LEFT, d(this.Sc));
        }
    }

    private void og() {
        if (this.Sg >= -1.0d) {
            this.Rv.setMargin(CriusEdge.BOTTOM, d(this.Sg));
        }
    }

    private void oh() {
        if (this.Sf >= -1.0d) {
            this.Rv.setMargin(CriusEdge.RIGHT, d(this.Sf));
        }
    }

    private void oi() {
        if (this.Se >= -1.0d) {
            this.Rv.setMargin(CriusEdge.TOP, d(this.Se));
        }
    }

    private void oj() {
        if (this.Sb >= -1.0d) {
            this.Rv.setMargin(CriusEdge.ALL, d(this.Sb));
        }
    }

    private void ok() {
        if (this.RW >= -1.0d) {
            this.Rv.setFlexBasis(d(this.RW));
        }
    }

    private void ol() {
        if (this.RV >= -1.0d) {
            this.Rv.setFlexShrink((float) this.RV);
        }
    }

    private void om() {
        if (this.RU >= -1.0d) {
            this.Rv.setFlexGrow((float) this.RU);
        }
    }

    private void on() {
        if (this.RT >= -1.0d) {
            this.Rv.setFlex((float) this.RT);
        }
    }

    private void oo() {
        if (!TextUtils.isEmpty(this.RK)) {
            if ("flex".equalsIgnoreCase(this.RK)) {
                this.Rv.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.RK)) {
                this.Rv.setDisplay(CriusDisplay.NONE);
            } else {
                this.Rv.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void op() {
        if (!b.b(this.RX, -10000.0d)) {
            this.Rv.setPosition(CriusEdge.LEFT, d(this.RX));
        }
        if (!b.b(this.RY, -10000.0d)) {
            this.Rv.setPosition(CriusEdge.TOP, d(this.RY));
        }
        if (!b.b(this.RZ, -10000.0d)) {
            this.Rv.setPosition(CriusEdge.RIGHT, d(this.RZ));
        }
        if (!b.b(this.Sa, -10000.0d)) {
            this.Rv.setPosition(CriusEdge.BOTTOM, d(this.Sa));
        }
    }

    private void oq() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Rv.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Rv.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void or() {
        if (!TextUtils.isEmpty(this.RR)) {
            if ("flex-start".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.RR)) {
                this.Rv.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Rv.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void os() {
        if (!TextUtils.isEmpty(this.RQ)) {
            if ("auto".equalsIgnoreCase(this.RQ)) {
                this.Rv.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.RQ)) {
                this.Rv.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RQ)) {
                this.Rv.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RQ)) {
                this.Rv.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RQ)) {
                this.Rv.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Rv.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void ot() {
        if (!TextUtils.isEmpty(this.RP)) {
            if ("flex-start".equalsIgnoreCase(this.RP)) {
                this.Rv.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RP)) {
                this.Rv.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RP)) {
                this.Rv.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RP)) {
                this.Rv.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Rv.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ou() {
        if (!TextUtils.isEmpty(this.RO)) {
            if ("flex-start".equalsIgnoreCase(this.RO)) {
                this.Rv.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RO)) {
                this.Rv.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RO)) {
                this.Rv.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.RO)) {
                this.Rv.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.RO)) {
                this.Rv.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Rv.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ov() {
        if (!TextUtils.isEmpty(this.RL)) {
            if ("column".equalsIgnoreCase(this.RL)) {
                this.Rv.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.RL)) {
                this.Rv.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.RL)) {
                this.Rv.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.RL)) {
                this.Rv.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Rv.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean ow() {
        return "text".equals(this.type);
    }

    public a cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.ST != null && this.ST.size() > 0) {
                for (a aVar : this.ST) {
                    a cs = aVar.cs(str);
                    if (cs != null) {
                        return cs;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a ct(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Ry)) {
            if (this.ST != null && this.ST.size() > 0) {
                for (a aVar : this.ST) {
                    a ct = aVar.ct(str);
                    if (ct != null) {
                        return ct;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cu(String str) {
        a ct;
        if (this.Ru == null || (ct = ct(str)) == null || ct.Rv == null) {
            return false;
        }
        ct.Rv.setDisplay(CriusDisplay.NONE);
        ct.Rv.dirty();
        this.Ru.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a cs;
        if (this.Ru != null && (cs = cs(str)) != null && cs.Rv != null) {
            cs.fontSize = f;
            cs.Rv.dirty();
            this.Ru.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
