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
    public final int Si;
    public final int Sj;
    public int TA;
    public int TB;
    public String TC;
    public String TD;
    public double TF;
    public double TG;
    private String TH;
    private String TI;
    private String TJ;
    private String TK;
    private String TL;
    private String TM;
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
    public String Ti;
    protected int Tn;
    protected int To;
    protected int Tp;
    private CriusNode Tq;
    public final CriusNode Tr;
    private TextView Ts;
    private final CriusMeasureFunction Tt;
    public String Tu;
    public String Tv;
    public String Tw;
    public String Tx;
    public String Ty;
    public int Tz;
    public String UB;
    public String UC;
    public String UD;
    public String UE;
    public double UF;
    public String UG;
    public String UH;
    public String UJ;
    public String UK;
    public String UL;
    public final List<a> UM;
    private double Ua;
    private double Ub;
    private double Uc;
    private double Ue;
    private double Uf;
    private double Ug;
    private double Uh;
    private double Ui;
    private double Uj;
    private double Uk;
    private double Ul;
    public String Um;
    public double Un;
    public double Uo;
    public double Up;
    public double Uq;
    public double Ur;
    public String Us;
    public String Ut;
    public Typeface Uu;
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
        String cC(String str);
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
            if (Double.compare(aVar.oF(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.oF() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.Uu);
            textView.setGravity(aVar.gravity);
            float d = aVar.TF > 0.0d ? d(aVar.TF) : 0.0f;
            float f = aVar.TG > 0.0d ? (float) aVar.TG : 1.0f;
            if (d > 0.0f || f > 0.0f) {
                textView.setLineSpacing(d, f);
            }
        }
    }

    public static boolean cy(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cy(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void d(JSONObject jSONObject) {
        this.id = c.g(jSONObject, "id");
        this.name = c.g(jSONObject, "name");
        this.type = c.g(jSONObject, "type");
        if (pk()) {
            this.Tr.setMeasureFunction(this.Tt);
        }
        this.Tu = c.g(jSONObject, "component");
        this.src = c.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.g(jSONObject, "poster");
        this.Tv = c.g(jSONObject, "href");
        this.text = c.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Tu) && this.businessConverter != null) {
            this.text = this.businessConverter.cC(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.TF = c.h(jSONObject, "line-space");
        this.TG = c.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Tw = jSONObject.optString("data-als-stat");
        this.Tx = jSONObject.optString("data-url-stat");
        this.Ty = jSONObject.optString("data-href-pop");
        this.Tz = c.i(jSONObject, "data-share-num");
        this.TA = c.i(jSONObject, "data-reply-num");
        this.TB = c.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.TC = jSONObject.optString("data-share-image");
        this.TD = jSONObject.optString("data-share-link");
    }

    private void e(JSONObject jSONObject) {
        this.TH = c.g(jSONObject, LogConfig.KEY_DISPLAY);
        pc();
        this.TI = c.g(jSONObject, "flex-direction");
        pj();
        this.TJ = c.g(jSONObject, "justify-content");
        pi();
        this.TK = c.g(jSONObject, "align-items");
        ph();
        this.TL = c.g(jSONObject, "align-self");
        pg();
        this.TM = c.g(jSONObject, "align-content");
        pf();
        this.TO = c.h(jSONObject, "flex");
        pb();
        this.TP = c.h(jSONObject, "flex-grow");
        pa();
        this.TQ = c.h(jSONObject, "flex-shrink");
        oZ();
        this.TR = c.h(jSONObject, "flex-basis");
        oY();
        this.position = c.g(jSONObject, "position");
        pe();
        this.TS = c.h(jSONObject, "left");
        this.TT = c.h(jSONObject, VerticalTranslateLayout.TOP);
        this.TU = c.h(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.TV = c.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        pd();
        this.TW = c.h(jSONObject, "margin");
        oX();
        this.TX = c.h(jSONObject, "margin-left");
        oT();
        this.TY = c.h(jSONObject, "margin-top");
        oW();
        this.TZ = c.h(jSONObject, "margin-right");
        oV();
        this.Ua = c.h(jSONObject, "margin-bottom");
        oU();
        this.Ub = c.h(jSONObject, "padding");
        initPadding();
        this.Uc = c.h(jSONObject, "padding-left");
        oP();
        this.Ue = c.h(jSONObject, "padding-top");
        oS();
        this.Uf = c.h(jSONObject, "padding-right");
        oR();
        this.Ug = c.h(jSONObject, "padding-bottom");
        oQ();
        this.width = c.h(jSONObject, "width");
        oO();
        this.height = c.h(jSONObject, "height");
        oN();
        this.Uh = c.h(jSONObject, "min-width");
        oM();
        this.Ui = c.h(jSONObject, "min-height");
        oL();
        this.Uj = c.h(jSONObject, "max-width");
        oI();
        this.Uk = c.h(jSONObject, "max-height");
        oK();
        this.Ul = c.h(jSONObject, "aspect-ratio");
        oJ();
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.UH = c.g(optJSONObject, "background-image");
            this.UJ = c.g(optJSONObject, "background-color");
            this.UK = c.g(optJSONObject, "border-color");
            this.UL = c.g(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.UC = c.g(jSONObject, "background-image");
        this.UD = c.g(jSONObject, "background-color");
        this.UE = c.g(jSONObject, "border-color");
        this.UF = c.h(jSONObject, "opacity");
        this.UG = c.g(jSONObject, "color");
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.Ux = c.g(optJSONObject, "background-image");
            this.Uy = c.g(optJSONObject, "background-color");
            this.Uz = c.g(optJSONObject, "border-color");
            this.UB = c.g(optJSONObject, "color");
        }
    }

    private void i(JSONObject jSONObject) {
        this.Um = c.g(jSONObject, "background-image");
        this.backgroundColor = c.g(jSONObject, "background-color");
        this.borderColor = c.g(jSONObject, "border-color");
        this.opacity = c.h(jSONObject, "opacity");
        this.color = c.g(jSONObject, "color");
        this.Un = c.h(jSONObject, "border-width");
        this.borderRadius = c.h(jSONObject, "border-radius");
        this.Uo = c.h(jSONObject, "border-top-left-radius");
        this.Up = c.h(jSONObject, "border-bottom-left-radius");
        this.Uq = c.h(jSONObject, "border-top-right-radius");
        this.Ur = c.h(jSONObject, "border-bottom-right-radius");
        this.Us = c.g(jSONObject, "font-style");
        this.Ut = c.g(jSONObject, "font-weight");
        this.Uu = Typeface.create(Typeface.DEFAULT, oG());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.Uv = c.g(jSONObject, "text-align");
        this.Uw = c.g(jSONObject, "vertical-align");
        this.gravity = oH();
        this.Ti = c.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0050a interfaceC0050a, boolean z) {
        this.Tn = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.To = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.Tp = 0;
        this.Tt = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.Ts, a.this);
                TextPaint paint = a.this.Ts.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.TF > 0.0d) {
                    f3 = a.this.d(a.this.TF);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.TG > 0.0d ? (float) a.this.TG : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Tn).setHyphenationFrequency(a.this.To);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.Tp);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Tn).setHyphenationFrequency(a.this.To);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.Tp);
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
        this.UF = -10000.0d;
        this.Tr = new CriusNode();
        this.businessConverter = interfaceC0050a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.Si = context.getResources().getDisplayMetrics().widthPixels;
        this.Sj = context.getResources().getDisplayMetrics().heightPixels;
        this.Ts = new TextView(context);
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
                this.UM = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0050a, false);
                    this.UM.add(aVar);
                    this.Tr.addChildAt(aVar.Tr, i);
                }
            } else {
                this.UM = null;
            }
        } else {
            this.UM = null;
        }
        if (z) {
            this.Tq = new CriusNode();
            this.Tq.addChildAt(this.Tr, 0);
            this.Tq.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double oF() {
        return this.fontSize;
    }

    private int oG() {
        return "italic".equalsIgnoreCase(this.Us) ? (TextUtils.isEmpty(this.Ut) || "normal".equalsIgnoreCase(this.Ut) || !"bold".equalsIgnoreCase(this.Ut)) ? 2 : 3 : (TextUtils.isEmpty(this.Ut) || "normal".equalsIgnoreCase(this.Ut) || !"bold".equalsIgnoreCase(this.Ut)) ? 0 : 1;
    }

    private int oH() {
        int i;
        if ("left".equalsIgnoreCase(this.Uv)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.Uv)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.Uv)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.Uw)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.Uw)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Uw)) {
            return i | 16;
        }
        return i | 0;
    }

    private void oI() {
        if (this.Uj >= 0.0d) {
            this.Tr.setMaxWidth(d(this.Uj));
        } else if (this.Uj > -10000.0d) {
            this.Tr.setMaxWidth(this.Si);
        }
    }

    private void oJ() {
        if (this.Ul > 0.0d) {
            this.Tr.setAspectRatio((float) this.Ul);
        }
    }

    private void oK() {
        if (this.Uk >= 0.0d) {
            this.Tr.setMaxHeight(d(this.Uk));
        } else if (this.Uk > -10000.0d) {
            this.Tr.setMaxHeight(this.Sj);
        }
    }

    private void oL() {
        if (this.Ui >= 0.0d) {
            this.Tr.setMinHeight(d(this.Ui));
        } else if (this.Ui > -10000.0d) {
            this.Tr.setMinHeight(this.Sj);
        }
    }

    private void oM() {
        if (this.Uh >= 0.0d) {
            this.Tr.setMinWidth(d(this.Uh));
        } else if (this.Uh > -10000.0d) {
            this.Tr.setMinWidth(this.Si);
        }
    }

    private void oN() {
        if (this.height >= 0.0d) {
            this.Tr.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.Tr.setHeight(this.Sj);
        }
    }

    private void oO() {
        if (this.width >= 0.0d) {
            this.Tr.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.Tr.setWidth(this.Si);
        }
    }

    private void oP() {
        if (this.Uc >= -1.0d) {
            this.Tr.setPadding(CriusEdge.LEFT, d(this.Uc));
        }
    }

    private void oQ() {
        if (this.Ug >= -1.0d) {
            this.Tr.setPadding(CriusEdge.BOTTOM, d(this.Ug));
        }
    }

    private void oR() {
        if (this.Uf >= -1.0d) {
            this.Tr.setPadding(CriusEdge.RIGHT, d(this.Uf));
        }
    }

    private void oS() {
        if (this.Ue >= -1.0d) {
            this.Tr.setPadding(CriusEdge.TOP, d(this.Ue));
        }
    }

    private void initPadding() {
        if (this.Ub >= -1.0d) {
            this.Tr.setPadding(CriusEdge.ALL, d(this.Ub));
        }
    }

    private void oT() {
        if (this.TX >= -1.0d) {
            this.Tr.setMargin(CriusEdge.LEFT, d(this.TX));
        }
    }

    private void oU() {
        if (this.Ua >= -1.0d) {
            this.Tr.setMargin(CriusEdge.BOTTOM, d(this.Ua));
        }
    }

    private void oV() {
        if (this.TZ >= -1.0d) {
            this.Tr.setMargin(CriusEdge.RIGHT, d(this.TZ));
        }
    }

    private void oW() {
        if (this.TY >= -1.0d) {
            this.Tr.setMargin(CriusEdge.TOP, d(this.TY));
        }
    }

    private void oX() {
        if (this.TW >= -1.0d) {
            this.Tr.setMargin(CriusEdge.ALL, d(this.TW));
        }
    }

    private void oY() {
        if (this.TR >= -1.0d) {
            this.Tr.setFlexBasis(d(this.TR));
        }
    }

    private void oZ() {
        if (this.TQ >= -1.0d) {
            this.Tr.setFlexShrink((float) this.TQ);
        }
    }

    private void pa() {
        if (this.TP >= -1.0d) {
            this.Tr.setFlexGrow((float) this.TP);
        }
    }

    private void pb() {
        if (this.TO >= -1.0d) {
            this.Tr.setFlex((float) this.TO);
        }
    }

    private void pc() {
        if (!TextUtils.isEmpty(this.TH)) {
            if ("flex".equalsIgnoreCase(this.TH)) {
                this.Tr.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.TH)) {
                this.Tr.setDisplay(CriusDisplay.NONE);
            } else {
                this.Tr.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void pd() {
        if (!c.b(this.TS, -10000.0d)) {
            this.Tr.setPosition(CriusEdge.LEFT, d(this.TS));
        }
        if (!c.b(this.TT, -10000.0d)) {
            this.Tr.setPosition(CriusEdge.TOP, d(this.TT));
        }
        if (!c.b(this.TU, -10000.0d)) {
            this.Tr.setPosition(CriusEdge.RIGHT, d(this.TU));
        }
        if (!c.b(this.TV, -10000.0d)) {
            this.Tr.setPosition(CriusEdge.BOTTOM, d(this.TV));
        }
    }

    private void pe() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Tr.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Tr.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void pf() {
        if (!TextUtils.isEmpty(this.TM)) {
            if ("flex-start".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.TM)) {
                this.Tr.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Tr.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void pg() {
        if (!TextUtils.isEmpty(this.TL)) {
            if ("auto".equalsIgnoreCase(this.TL)) {
                this.Tr.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.TL)) {
                this.Tr.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TL)) {
                this.Tr.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TL)) {
                this.Tr.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.TL)) {
                this.Tr.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Tr.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void ph() {
        if (!TextUtils.isEmpty(this.TK)) {
            if ("flex-start".equalsIgnoreCase(this.TK)) {
                this.Tr.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TK)) {
                this.Tr.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TK)) {
                this.Tr.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.TK)) {
                this.Tr.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Tr.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void pi() {
        if (!TextUtils.isEmpty(this.TJ)) {
            if ("flex-start".equalsIgnoreCase(this.TJ)) {
                this.Tr.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.TJ)) {
                this.Tr.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.TJ)) {
                this.Tr.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.TJ)) {
                this.Tr.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.TJ)) {
                this.Tr.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Tr.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void pj() {
        if (!TextUtils.isEmpty(this.TI)) {
            if ("column".equalsIgnoreCase(this.TI)) {
                this.Tr.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.TI)) {
                this.Tr.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.TI)) {
                this.Tr.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.TI)) {
                this.Tr.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Tr.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean pk() {
        return "text".equals(this.type);
    }

    public a cz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.UM != null && this.UM.size() > 0) {
                for (a aVar : this.UM) {
                    a cz = aVar.cz(str);
                    if (cz != null) {
                        return cz;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a cA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Tu)) {
            if (this.UM != null && this.UM.size() > 0) {
                for (a aVar : this.UM) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public float d(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cB(String str) {
        a cA;
        if (this.Tq == null || (cA = cA(str)) == null || cA.Tr == null) {
            return false;
        }
        cA.Tr.setDisplay(CriusDisplay.NONE);
        cA.Tr.dirty();
        this.Tq.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a cz;
        if (this.Tq != null && (cz = cz(str)) != null && cz.Tr != null) {
            cz.fontSize = f;
            cz.Tr.dirty();
            this.Tq.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
