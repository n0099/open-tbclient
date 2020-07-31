package com.baidu.swan.apps.setting.oauth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.i;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.setting.oauth.e;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements i {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final int[] cMI = {a.f.agreement_first, a.f.agreement_second, a.f.agreement_third, a.f.agreement_forth};
    private static final int[] cMJ = {a.f.agreement_layout_first, a.f.agreement_layout_second, a.f.agreement_layout_third, a.f.agreement_layout_forth};
    private com.baidu.swan.apps.runtime.e bRs;
    private e cKv;
    private DialogInterface.OnClickListener cMC;
    private JSONObject cMD;
    private g.a cME;
    private TextView cMF;
    private TextView cMG;
    private TextView cMH;
    protected Context mContext;
    private View mCustomView;
    private View mRootView;

    @Override // com.baidu.swan.apps.adaptation.a.i
    public g.a a(Context context, com.baidu.swan.apps.runtime.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        if (context == null || eVar == null || eVar2 == null) {
            return null;
        }
        this.cME = new g.a(context);
        this.mContext = context;
        this.bRs = eVar;
        this.cKv = eVar2;
        this.cMD = jSONObject;
        this.cMC = onClickListener;
        this.cME.ff(true);
        this.cME.ar(atA());
        this.cME.a(new com.baidu.swan.apps.view.c.a());
        this.cME.gW(a.e.aiapps_action_sheet_bg);
        this.cME.fk(false);
        this.cME.arb();
        this.cME.fg(false);
        return this.cME;
    }

    public View atA() {
        this.mRootView = View.inflate(this.mContext, a.g.swan_app_auth_dialog_content_common, null);
        atB();
        atC();
        atG();
        return this.mRootView;
    }

    public void atB() {
        List<e> list;
        Bitmap a;
        boolean z = (TextUtils.isEmpty(this.cKv.cMt) || TextUtils.isEmpty(this.cKv.cMu)) ? false : true;
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.mRootView.findViewById(a.f.swan_app_icon);
        if (swanAppRoundedImageView != null) {
            if (z) {
                a = al.o(this.cKv.cMu, "SwanAppAuthDialog", false);
            } else {
                a = al.a((com.baidu.swan.apps.u.c.b) this.bRs.Se(), "SwanAppAuthDialog", false);
            }
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), a));
            swanAppRoundedImageView.setBorderColor(this.mContext.getResources().getColor(a.c.swan_app_auth_icon_border));
        }
        ((TextView) this.mRootView.findViewById(a.f.swan_app_name)).setText(z ? this.cKv.cMt : this.bRs.getName());
        this.cMF = (TextView) this.mRootView.findViewById(a.f.permission_name);
        if (this.cMF != null) {
            if (g(this.cKv)) {
                View findViewById = this.mRootView.findViewById(a.f.swan_app_action_text);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.cMF.setText(this.cKv.cMv);
            } else {
                this.cMF.setText(this.cKv.name);
            }
        }
        if (g(this.cKv) && (list = this.cKv.cMw) != null && list.size() > 0) {
            for (int i = 0; i < list.size() && i <= 3; i++) {
                e eVar = list.get(i);
                if (eVar != null) {
                    this.mRootView.findViewById(cMJ[i]).setVisibility(0);
                    ((TextView) this.mRootView.findViewById(cMI[i])).setText(eVar.cMl);
                }
            }
        }
        this.cMG = (TextView) this.mRootView.findViewById(a.f.auth_negative_button);
        this.cMH = (TextView) this.mRootView.findViewById(a.f.auth_positive_button);
        this.cME.a(this.cMG, -2, this.cMC);
        this.cME.a(this.cMH, -1, this.cMC);
    }

    public void atC() {
        if (g(this.cKv)) {
            atE();
        } else if (h(this.cKv)) {
            atF();
        } else {
            atD();
        }
    }

    private void atD() {
        FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(a.f.auth_custom_layout);
        if (frameLayout != null) {
            this.mRootView.findViewById(a.f.multi_auth_custom_layout).setVisibility(8);
            this.mRootView.findViewById(a.f.multi_auth_agreement_layout).setVisibility(8);
            this.mRootView.findViewById(a.f.auth_custom_layout).setVisibility(0);
            ((TextView) this.mRootView.findViewById(a.f.multi_auth_agreement_layout)).setVisibility(8);
            this.mCustomView = a(this.mContext, this.cKv, this.cMD);
            String str = this.cKv.id;
            char c = 65535;
            switch (str.hashCode()) {
                case -1068855134:
                    if (str.equals("mobile")) {
                        c = 1;
                        break;
                    }
                    break;
                case -977063690:
                    if (str.equals("snsapi_userinfo")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (this.cMD != null) {
                        a(this.mContext, this.mCustomView, this.cMD);
                        break;
                    } else {
                        b(this.mCustomView, this.cKv);
                        break;
                    }
                case 1:
                    a(this.mCustomView, this.cKv);
                    break;
                default:
                    b(this.mCustomView, this.cKv);
                    break;
            }
            frameLayout.addView(this.mCustomView);
        }
    }

    private void atE() {
        if (((FrameLayout) this.mRootView.findViewById(a.f.multi_auth_custom_layout)) != null) {
            this.mRootView.findViewById(a.f.multi_auth_custom_layout).setVisibility(0);
            this.mRootView.findViewById(a.f.multi_auth_agreement_layout).setVisibility(0);
            this.mRootView.findViewById(a.f.auth_custom_layout).setVisibility(8);
            this.cKv.atz();
            b(true, this.mRootView.findViewById(a.f.auth_scope_detail_layout), this.cMH, this.cKv);
            TextView textView = (TextView) this.mRootView.findViewById(a.f.multi_auth_agreement_layout);
            textView.setVisibility(0);
            e.a aVar = this.cKv.cMr;
            String str = aVar.cMA;
            JSONArray jSONArray = this.cKv.cMr.cMB;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mContext.getString(a.h.swanapp_multi_auth_agreement_head));
            if (!TextUtils.isEmpty(aVar.cMz)) {
                sb.append(aVar.cMz);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("keyword");
                    String optString2 = optJSONObject.optString("detail_url");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString.length() <= 17) {
                        sb.append(optString);
                    }
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            if (!TextUtils.isEmpty(aVar.cMz)) {
                a(spannableString, sb, aVar.cMz, aVar.detailUrl, str);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i2);
                    String optString3 = optJSONObject2.optString("keyword");
                    String optString4 = optJSONObject2.optString("detail_url");
                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && optString3.length() <= 17) {
                        a(spannableString, sb, optString3, optString4, str);
                    }
                }
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(com.baidu.swan.support.v4.a.a.getColor(this.mContext, a.c.aiapps_transparent));
            textView.setLongClickable(false);
        }
    }

    private void atF() {
        FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(a.f.auth_custom_layout);
        if (frameLayout != null) {
            this.mRootView.findViewById(a.f.multi_auth_custom_layout).setVisibility(8);
            this.mRootView.findViewById(a.f.multi_auth_agreement_layout).setVisibility(8);
            this.mRootView.findViewById(a.f.auth_custom_layout).setVisibility(0);
            this.mCustomView = View.inflate(this.mContext, a.g.swan_app_auth_scope_detail, null);
            this.cKv.atz();
            a(false, this.mCustomView, this.cMH, this.cKv);
            frameLayout.addView(this.mCustomView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final View view, final TextView textView, final e eVar) {
        Drawable drawable;
        if (view != null && eVar != null && eVar.cMr != null) {
            final e.a aVar = eVar.cMr;
            TextView textView2 = (TextView) view.findViewById(a.f.auth_scope_detail);
            if (textView2 != null && !TextUtils.isEmpty(aVar.cMx)) {
                if (!aVar.cMx.startsWith("XXXX   ")) {
                    aVar.cMx = "XXXX   " + aVar.cMx;
                }
                textView2.setText(aVar.cMx);
                try {
                    textView2.setTextColor(Color.parseColor(aVar.cMy));
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        throw e;
                    }
                }
                SpannableString spannableString = new SpannableString(textView2.getText());
                textView.setEnabled(z);
                if (z) {
                    drawable = view.getResources().getDrawable(a.e.swanapp_scope_selected);
                } else {
                    drawable = view.getResources().getDrawable(a.e.swanapp_scope_unselected);
                }
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                spannableString.setSpan(new ImageSpan(drawable) { // from class: com.baidu.swan.apps.setting.oauth.f.2
                    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
                    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
                        Drawable drawable2 = getDrawable();
                        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                        int i6 = fontMetricsInt.ascent;
                        canvas.save();
                        canvas.translate(f, ((i6 + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable2.getBounds().bottom / 2));
                        drawable2.draw(canvas);
                        canvas.restore();
                    }
                }, 0, 4, 33);
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.3
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view2) {
                        f.this.a(!textView.isEnabled(), view, textView, eVar);
                    }
                }, 0, 7, 33);
                int length = TextUtils.isEmpty(aVar.cMz) ? 0 : aVar.cMz.length();
                int indexOf = aVar.cMx.indexOf(aVar.cMz);
                int i = indexOf + length;
                try {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.cMA)), indexOf, i, 33);
                } catch (RuntimeException e2) {
                    if (DEBUG) {
                        throw e2;
                    }
                }
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.4
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view2) {
                        f.this.X(view.getContext(), aVar.detailUrl);
                    }
                }, indexOf, i, 33);
                textView2.setText(spannableString);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setHighlightColor(textView2.getResources().getColor(a.c.aiapps_transparent));
            }
        }
    }

    private void a(SpannableString spannableString, StringBuilder sb, String str, final String str2, final String str3) {
        int length = TextUtils.isEmpty(str) ? 0 : str.length();
        int indexOf = sb.indexOf(str);
        int i = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), indexOf, i, 33);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.5
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                @SuppressLint({"ResourceAsColor"})
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(Color.parseColor(str3));
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    f.this.X(com.baidu.swan.apps.runtime.d.arr().arp(), str2);
                }
            }, indexOf, i, 33);
        } catch (RuntimeException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void atG() {
        final TextView textView;
        if (!TextUtils.isEmpty(this.cKv.cMp) && (textView = (TextView) this.mRootView.findViewById(a.f.permission_detail)) != null) {
            if (this.bRs != null && this.bRs.Se() != null && TextUtils.equals(this.bRs.Se().ajg(), "11010020") && TextUtils.equals(this.cKv.id, "mobile")) {
                a(this.cKv, this.cMF, this.mRootView, textView, this.cMD, this.mCustomView);
                textView.setTextColor(com.baidu.swan.support.v4.a.a.getColor(this.mContext, a.c.aiapps_black));
                return;
            }
            if (!g(this.cKv)) {
                com.baidu.swan.apps.view.b bVar = new com.baidu.swan.apps.view.b(this.mContext, a.e.swan_app_auth_question_mark_pressed);
                SpannableString spannableString = new SpannableString(" # ");
                spannableString.setSpan(bVar, 1, 2, 33);
                spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        f.this.a(f.this.cKv, f.this.cMF, f.this.mRootView, textView, f.this.cMD, f.this.mCustomView);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                    }
                }, 0, spannableString.length(), 33);
                this.cMF.append(spannableString);
            }
            this.cMF.setHighlightColor(com.baidu.swan.support.v4.a.a.getColor(this.mContext, a.c.aiapps_transparent));
            this.cMF.setMovementMethod(LinkMovementMethod.getInstance());
            this.cMF.setLongClickable(false);
        }
    }

    public boolean g(e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.id, "scope_multi_authorize");
    }

    public boolean h(e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.id, "ppcert") || TextUtils.equals(eVar.id, "mapp_i_face_verify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        if (eVar != null) {
            if (eVar.cMp != null) {
                textView2.setText(Html.fromHtml(eVar.cMp));
            }
            textView.setText(eVar.name);
            ((LinearLayout) view.findViewById(a.f.permission_detail_layout)).setVisibility(0);
            if (((TextUtils.equals(eVar.id, "snsapi_userinfo") && jSONObject != null) || TextUtils.equals(eVar.id, "mobile")) && view2 != null) {
                view2.findViewById(a.f.auth_divider1).setVisibility(8);
            }
        }
    }

    private View a(Context context, e eVar, JSONObject jSONObject) {
        int i;
        if (context == null || eVar == null || TextUtils.isEmpty(eVar.id)) {
            return null;
        }
        String str = eVar.id;
        char c = 65535;
        switch (str.hashCode()) {
            case -1068855134:
                if (str.equals("mobile")) {
                    c = 1;
                    break;
                }
                break;
            case -977063690:
                if (str.equals("snsapi_userinfo")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (jSONObject != null) {
                    i = a.g.swan_app_auth_level1_userinfo_custom;
                    break;
                } else {
                    i = a.g.swan_app_auth_level2_custom;
                    break;
                }
            case 1:
                i = a.g.swan_app_auth_level1_mobile_custom;
                break;
            default:
                i = a.g.swan_app_auth_level2_custom;
                break;
        }
        return View.inflate(context, i, null);
    }

    private void a(final Context context, View view, JSONObject jSONObject) {
        if (context != null && view != null && jSONObject != null) {
            final SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(a.f.user_icon);
            TextView textView = (TextView) view.findViewById(a.f.user_name);
            Pair<String, String> bx = bx(jSONObject);
            if (bx != null) {
                s.a((String) bx.second, new s.a() { // from class: com.baidu.swan.apps.setting.oauth.f.7
                    @Override // com.baidu.swan.apps.aq.s.a
                    public void h(String str, Bitmap bitmap) {
                        if (bitmap == null) {
                            bitmap = BitmapFactory.decodeResource(context.getResources(), a.e.swan_app_user_portrait_pressed);
                        }
                        if (swanAppRoundedImageView != null) {
                            swanAppRoundedImageView.setImageBitmap(bitmap);
                            swanAppRoundedImageView.setBorderColor(context.getResources().getColor(a.c.swan_app_auth_icon_border));
                        }
                    }
                });
                if (textView != null) {
                    textView.setText((CharSequence) bx.first);
                }
            }
        }
    }

    protected Pair<String, String> bx(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
        if (optJSONObject == null) {
            return null;
        }
        return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
    }

    private void a(View view, e eVar) {
        if (view != null && eVar != null) {
            TextView textView = (TextView) view.findViewById(a.f.user_phone_number);
            StringBuilder sb = new StringBuilder();
            for (String str : eVar.cMn) {
                sb.append(str);
            }
            if (textView != null) {
                textView.setText(sb.toString());
            }
        }
    }

    private void b(View view, e eVar) {
        TextView textView;
        SwanAppConfigData ajW;
        Map<String, String> map;
        if (view != null && eVar != null && (textView = (TextView) view.findViewById(a.f.permission_function)) != null) {
            if (TextUtils.equals(eVar.id, "mapp_location") && (ajW = com.baidu.swan.apps.v.f.akr().ajW()) != null && ajW.cIf != null && (map = ajW.cIf.cIi.get("scope.userLocation")) != null) {
                String str = map.get("desc");
                if (!TextUtils.isEmpty(str)) {
                    eVar.cMq = str;
                }
            }
            textView.setText(eVar.cMq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, final View view, final TextView textView, final e eVar) {
        TextView textView2;
        Drawable drawable;
        if (view != null && eVar != null && eVar.cMr != null && (textView2 = (TextView) view.findViewById(a.f.auth_scope_detail)) != null) {
            textView2.setText("XXXX   " + this.mContext.getString(a.h.swanapp_multi_auth_agreement_desc));
            textView.setEnabled(z);
            if (z) {
                drawable = view.getResources().getDrawable(a.e.swanapp_scope_selected);
            } else {
                drawable = view.getResources().getDrawable(a.e.swanapp_scope_unselected);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ImageSpan imageSpan = new ImageSpan(drawable) { // from class: com.baidu.swan.apps.setting.oauth.f.8
                @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
                public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
                    Drawable drawable2 = getDrawable();
                    Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                    int i6 = fontMetricsInt.ascent;
                    canvas.save();
                    canvas.translate(f, ((i6 + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable2.getBounds().bottom / 2));
                    drawable2.draw(canvas);
                    canvas.restore();
                }
            };
            SpannableString spannableString = new SpannableString(textView2.getText());
            spannableString.setSpan(imageSpan, 0, 4, 33);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.swan.apps.setting.oauth.f.9
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view2) {
                    f.this.b(!textView.isEnabled(), view, textView, eVar);
                }
            }, 0, 7, 33);
            textView2.setText(spannableString);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(textView2.getResources().getColor(a.c.aiapps_transparent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Context context, String str) {
        if (context instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.setting.oauth.f.1
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                    com.baidu.swan.apps.v.f.akr().ajS();
                    return true;
                }
            });
            com.baidu.swan.apps.v.f.akr().ajR();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(a.C0290a.aiapps_slide_in_from_right, a.C0290a.aiapps_hold);
        }
    }
}
