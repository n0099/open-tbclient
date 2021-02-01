package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.adp.widget.CenterImageSpan;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends b {
    public e(Context context) {
        super(context, com.baidu.live.im.a.bjY);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected void Kz() {
        if (KA()) {
            KB();
        } else {
            KC();
        }
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected int getColor() {
        return TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_other_b);
    }

    @Override // com.baidu.live.yuyinim.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar) {
        Drawable drawable;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a L = L(bVar);
        if (L != null) {
            String str = L.shareText;
            SpannableString valueOf = SpannableString.valueOf(str);
            if (KA()) {
                if (L.shareType != 3) {
                    valueOf.setSpan(new ForegroundColorSpan(-6574339), 0, valueOf.length(), 33);
                } else {
                    valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                }
            } else {
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.h.sdk_share_blue_zhuan);
            if (L.shareType == 2 && str.contains(string) && (drawable = TbadkCoreApplication.getInst().getResources().getDrawable(a.e.sdk_icon_live_blue_diamond)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                CenterImageSpan centerImageSpan = new CenterImageSpan(drawable, 1);
                SpannableString spannableString = new SpannableString(" [img]");
                spannableString.setSpan(centerImageSpan, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
            if (L.shareType != 3) {
                a(spannableStringBuilder, bVar.KZ(), aVar, false, false);
                if (KA()) {
                    KB();
                }
            }
            aVar.bkl.setText(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private a L(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            a aVar = new a();
            aVar.shareText = jSONObject.optString("share_content");
            aVar.shareType = jSONObject.optInt("share_type", 1);
            return aVar;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        public String shareText;
        public int shareType;

        private a() {
        }
    }
}
