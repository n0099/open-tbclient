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
import com.baidu.c.a.e.c;
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
/* loaded from: classes13.dex */
public class a {
    public String SX;
    public final int Sg;
    public final int Sh;
    private String TA;
    private String TB;
    private double TC;
    private double TD;
    private double TF;
    private double TG;
    private double TH;
    private double TI;
    private double TJ;
    private double TK;
    private double TL;
    private double TM;
    private double TO;
    private double TP;
    private double TQ;
    private double TR;
    private double TS;
    private double TT;
    private double TU;
    private double TV;
    private double TW;
    private double TX;
    private double TY;
    private double TZ;
    protected int Tc;
    protected int Te;
    protected int Tf;
    private CriusNode Tg;
    public final CriusNode Th;
    private TextView Ti;
    private final CriusMeasureFunction Tj;
    public String Tk;
    public String Tl;
    public String Tm;
    public String Tn;
    public String To;
    public int Tp;
    public int Tq;
    public int Tr;
    public String Ts;
    public String Tt;
    public double Tu;
    public double Tv;
    private String Tw;
    private String Tx;
    private String Ty;
    private String Tz;
    public final List<a> UB;
    private double Ua;
    public String Ub;
    public double Uc;
    public double Ue;
    public double Uf;
    public double Ug;
    public double Uh;
    public String Ui;
    public String Uj;
    public Typeface Uk;
    public String Ul;
    public String Um;
    public String Un;
    public String Uo;
    public String Up;
    public String Uq;
    public String Ur;
    public String Us;
    public String Ut;
    public double Uu;
    public String Uv;
    public String Uw;
    public String Ux;
    public String Uy;
    public String Uz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0050a businessConverter;
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
    public String poster;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0050a {
        String cD(String str);
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
            if (Double.compare(aVar.oA(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.oA() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.Uk);
            textView.setGravity(aVar.gravity);
            float d = aVar.Tu > 0.0d ? d(aVar.Tu) : 0.0f;
            float f = aVar.Tv > 0.0d ? (float) aVar.Tv : 1.0f;
            if (d > 0.0f || f > 0.0f) {
                textView.setLineSpacing(d, f);
            }
        }
    }

    public static boolean cz(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cz(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void d(JSONObject jSONObject) {
        this.id = c.g(jSONObject, "id");
        this.name = c.g(jSONObject, "name");
        this.type = c.g(jSONObject, "type");
        if (pf()) {
            this.Th.setMeasureFunction(this.Tj);
        }
        this.Tk = c.g(jSONObject, "component");
        this.src = c.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.g(jSONObject, "poster");
        this.Tl = c.g(jSONObject, "href");
        this.text = c.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Tk) && this.businessConverter != null) {
            this.text = this.businessConverter.cD(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.Tu = c.h(jSONObject, "line-space");
        this.Tv = c.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Tm = jSONObject.optString("data-als-stat");
        this.Tn = jSONObject.optString("data-url-stat");
        this.To = jSONObject.optString("data-href-pop");
        this.Tp = c.i(jSONObject, "data-share-num");
        this.Tq = c.i(jSONObject, "data-reply-num");
        this.Tr = c.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Ts = jSONObject.optString("data-share-image");
        this.Tt = jSONObject.optString("data-share-link");
    }

    private void e(JSONObject jSONObject) {
        this.Tw = c.g(jSONObject, LogConfig.KEY_DISPLAY);
        oX();
        this.Tx = c.g(jSONObject, "flex-direction");
        pe();
        this.Ty = c.g(jSONObject, "justify-content");
        pd();
        this.Tz = c.g(jSONObject, "align-items");
        pc();
        this.TA = c.g(jSONObject, "align-self");
        pb();
        this.TB = c.g(jSONObject, "align-content");
        pa();
        this.TC = c.h(jSONObject, "flex");
        oW();
        this.TD = c.h(jSONObject, "flex-grow");
        oV();
        this.TF = c.h(jSONObject, "flex-shrink");
        oU();
        this.TG = c.h(jSONObject, "flex-basis");
        oT();
        this.position = c.g(jSONObject, "position");
        oZ();
        this.TH = c.h(jSONObject, "left");
        this.TI = c.h(jSONObject, VerticalTranslateLayout.TOP);
        this.TJ = c.h(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.TK = c.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        oY();
        this.TL = c.h(jSONObject, "margin");
        oS();
        this.TM = c.h(jSONObject, "margin-left");
        oO();
        this.TO = c.h(jSONObject, "margin-top");
        oR();
        this.TP = c.h(jSONObject, "margin-right");
        oQ();
        this.TQ = c.h(jSONObject, "margin-bottom");
        oP();
        this.TR = c.h(jSONObject, "padding");
        initPadding();
        this.TS = c.h(jSONObject, "padding-left");
        oK();
        this.TT = c.h(jSONObject, "padding-top");
        oN();
        this.TU = c.h(jSONObject, "padding-right");
        oM();
        this.TV = c.h(jSONObject, "padding-bottom");
        oL();
        this.width = c.h(jSONObject, "width");
        oJ();
        this.height = c.h(jSONObject, "height");
        oI();
        this.TW = c.h(jSONObject, "min-width");
        oH();
        this.TX = c.h(jSONObject, "min-height");
        oG();
        this.TY = c.h(jSONObject, "max-width");
        oD();
        this.TZ = c.h(jSONObject, "max-height");
        oF();
        this.Ua = c.h(jSONObject, "aspect-ratio");
        oE();
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.Uw = c.g(optJSONObject, "background-image");
            this.Ux = c.g(optJSONObject, "background-color");
            this.Uy = c.g(optJSONObject, "border-color");
            this.Uz = c.g(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.Ur = c.g(jSONObject, "background-image");
        this.Us = c.g(jSONObject, "background-color");
        this.Ut = c.g(jSONObject, "border-color");
        this.Uu = c.h(jSONObject, "opacity");
        this.Uv = c.g(jSONObject, "color");
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.Un = c.g(optJSONObject, "background-image");
            this.Uo = c.g(optJSONObject, "background-color");
            this.Up = c.g(optJSONObject, "border-color");
            this.Uq = c.g(optJSONObject, "color");
        }
    }

    private void i(JSONObject jSONObject) {
        this.Ub = c.g(jSONObject, "background-image");
        this.backgroundColor = c.g(jSONObject, "background-color");
        this.borderColor = c.g(jSONObject, "border-color");
        this.opacity = c.h(jSONObject, "opacity");
        this.color = c.g(jSONObject, "color");
        this.Uc = c.h(jSONObject, "border-width");
        this.borderRadius = c.h(jSONObject, "border-radius");
        this.Ue = c.h(jSONObject, "border-top-left-radius");
        this.Uf = c.h(jSONObject, "border-bottom-left-radius");
        this.Ug = c.h(jSONObject, "border-top-right-radius");
        this.Uh = c.h(jSONObject, "border-bottom-right-radius");
        this.Ui = c.g(jSONObject, "font-style");
        this.Uj = c.g(jSONObject, "font-weight");
        this.Uk = Typeface.create(Typeface.DEFAULT, oB());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.Ul = c.g(jSONObject, "text-align");
        this.Um = c.g(jSONObject, "vertical-align");
        this.gravity = oC();
        this.SX = c.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0050a interfaceC0050a, boolean z) {
        this.Tc = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.Te = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.Tf = 0;
        this.Tj = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.Ti, a.this);
                TextPaint paint = a.this.Ti.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.Tu > 0.0d) {
                    f3 = a.this.d(a.this.Tu);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.Tv > 0.0d ? (float) a.this.Tv : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Tc).setHyphenationFrequency(a.this.Te);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.Tf);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Tc).setHyphenationFrequency(a.this.Te);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.Tf);
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
        this.Uu = -10000.0d;
        this.Th = new CriusNode();
        this.businessConverter = interfaceC0050a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.Sg = context.getResources().getDisplayMetrics().widthPixels;
        this.Sh = context.getResources().getDisplayMetrics().heightPixels;
        this.Ti = new TextView(context);
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
                this.UB = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0050a, false);
                    this.UB.add(aVar);
                    this.Th.addChildAt(aVar.Th, i);
                }
            } else {
                this.UB = null;
            }
        } else {
            this.UB = null;
        }
        if (z) {
            this.Tg = new CriusNode();
            this.Tg.addChildAt(this.Th, 0);
            this.Tg.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double oA() {
        return this.fontSize;
    }

    private int oB() {
        return "italic".equalsIgnoreCase(this.Ui) ? (TextUtils.isEmpty(this.Uj) || "normal".equalsIgnoreCase(this.Uj) || !"bold".equalsIgnoreCase(this.Uj)) ? 2 : 3 : (TextUtils.isEmpty(this.Uj) || "normal".equalsIgnoreCase(this.Uj) || !"bold".equalsIgnoreCase(this.Uj)) ? 0 : 1;
    }

    private int oC() {
        int i;
        if ("left".equalsIgnoreCase(this.Ul)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.Ul)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.Ul)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.Um)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.Um)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Um)) {
            return i | 16;
        }
        return i | 0;
    }

    private void oD() {
        if (this.TY >= 0.0d) {
            this.Th.setMaxWidth(d(this.TY));
        } else if (this.TY > -10000.0d) {
            this.Th.setMaxWidth(this.Sg);
        }
    }

    private void oE() {
        if (this.Ua > 0.0d) {
            this.Th.setAspectRatio((float) this.Ua);
        }
    }

    private void oF() {
        if (this.TZ >= 0.0d) {
            this.Th.setMaxHeight(d(this.TZ));
        } else if (this.TZ > -10000.0d) {
            this.Th.setMaxHeight(this.Sh);
        }
    }

    private void oG() {
        if (this.TX >= 0.0d) {
            this.Th.setMinHeight(d(this.TX));
        } else if (this.TX > -10000.0d) {
            this.Th.setMinHeight(this.Sh);
        }
    }

    private void oH() {
        if (this.TW >= 0.0d) {
            this.Th.setMinWidth(d(this.TW));
        } else if (this.TW > -10000.0d) {
            this.Th.setMinWidth(this.Sg);
        }
    }

    private void oI() {
        if (this.height >= 0.0d) {
            this.Th.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.Th.setHeight(this.Sh);
        }
    }

    private void oJ() {
        if (this.width >= 0.0d) {
            this.Th.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.Th.setWidth(this.Sg);
        }
    }

    private void oK() {
        if (this.TS >= -1.0d) {
            this.Th.setPadding(CriusEdge.LEFT, d(this.TS));
        }
    }

    private void oL() {
        if (this.TV >= -1.0d) {
            this.Th.setPadding(CriusEdge.BOTTOM, d(this.TV));
        }
    }

    private void oM() {
        if (this.TU >= -1.0d) {
            this.Th.setPadding(CriusEdge.RIGHT, d(this.TU));
        }
    }

    private void oN() {
        if (this.TT >= -1.0d) {
            this.Th.setPadding(CriusEdge.TOP, d(this.TT));
        }
    }

    private void initPadding() {
        if (this.TR >= -1.0d) {
            this.Th.setPadding(CriusEdge.ALL, d(this.TR));
        }
    }

    private void oO() {
        if (this.TM >= -1.0d) {
            this.Th.setMargin(CriusEdge.LEFT, d(this.TM));
        }
    }

    private void oP() {
        if (this.TQ >= -1.0d) {
            this.Th.setMargin(CriusEdge.BOTTOM, d(this.TQ));
        }
    }

    private void oQ() {
        if (this.TP >= -1.0d) {
            this.Th.setMargin(CriusEdge.RIGHT, d(this.TP));
        }
    }

    private void oR() {
        if (this.TO >= -1.0d) {
            this.Th.setMargin(CriusEdge.TOP, d(this.TO));
        }
    }

    private void oS() {
        if (this.TL >= -1.0d) {
            this.Th.setMargin(CriusEdge.ALL, d(this.TL));
        }
    }

    private void oT() {
        if (this.TG >= -1.0d) {
            this.Th.setFlexBasis(d(this.TG));
        }
    }

    private void oU() {
        if (this.TF >= -1.0d) {
            this.Th.setFlexShrink((float) this.TF);
        }
    }

    private void oV() {
        if (this.TD >= -1.0d) {
            this.Th.setFlexGrow((float) this.TD);
        }
    }

    private void oW() {
        if (this.TC >= -1.0d) {
            this.Th.setFlex((float) this.TC);
        }
    }

    private void oX() {
        if (!TextUtils.isEmpty(this.Tw)) {
            if ("flex".equalsIgnoreCase(this.Tw)) {
                this.Th.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.Tw)) {
                this.Th.setDisplay(CriusDisplay.NONE);
            } else {
                this.Th.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void oY() {
        if (!c.b(this.TH, -10000.0d)) {
            this.Th.setPosition(CriusEdge.LEFT, d(this.TH));
        }
        if (!c.b(this.TI, -10000.0d)) {
            this.Th.setPosition(CriusEdge.TOP, d(this.TI));
        }
        if (!c.b(this.TJ, -10000.0d)) {
            this.Th.setPosition(CriusEdge.RIGHT, d(this.TJ));
        }
        if (!c.b(this.TK, -10000.0d)) {
            this.Th.setPosition(CriusEdge.BOTTOM, d(this.TK));
        }
    }

    private void oZ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Th.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Th.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void pa() {
        if (!TextUtils.isEmpty(this.TB)) {
            if ("flex-start".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.TB)) {
                this.Th.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Th.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void pb() {
        if (!TextUtils.isEmpty(this.TA)) {
            if ("auto".equalsIgnoreCase(this.TA)) {
                this.Th.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.TA)) {
                this.Th.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TA)) {
                this.Th.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TA)) {
                this.Th.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.TA)) {
                this.Th.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Th.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void pc() {
        if (!TextUtils.isEmpty(this.Tz)) {
            if ("flex-start".equalsIgnoreCase(this.Tz)) {
                this.Th.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Tz)) {
                this.Th.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Tz)) {
                this.Th.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Tz)) {
                this.Th.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Th.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void pd() {
        if (!TextUtils.isEmpty(this.Ty)) {
            if ("flex-start".equalsIgnoreCase(this.Ty)) {
                this.Th.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Ty)) {
                this.Th.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Ty)) {
                this.Th.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Ty)) {
                this.Th.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Ty)) {
                this.Th.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Th.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void pe() {
        if (!TextUtils.isEmpty(this.Tx)) {
            if ("column".equalsIgnoreCase(this.Tx)) {
                this.Th.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Tx)) {
                this.Th.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Tx)) {
                this.Th.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Tx)) {
                this.Th.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Th.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean pf() {
        return "text".equals(this.type);
    }

    public a cA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.UB != null && this.UB.size() > 0) {
                for (a aVar : this.UB) {
                    a cA = aVar.cA(str);
                    if (cA != null) {
                        return cA;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Tk)) {
            if (this.UB != null && this.UB.size() > 0) {
                for (a aVar : this.UB) {
                    a cB = aVar.cB(str);
                    if (cB != null) {
                        return cB;
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

    public boolean cC(String str) {
        a cB;
        if (this.Tg == null || (cB = cB(str)) == null || cB.Th == null) {
            return false;
        }
        cB.Th.setDisplay(CriusDisplay.NONE);
        cB.Th.dirty();
        this.Tg.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a cA;
        if (this.Tg != null && (cA = cA(str)) != null && cA.Th != null) {
            cA.fontSize = f;
            cA.Th.dirty();
            this.Tg.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
