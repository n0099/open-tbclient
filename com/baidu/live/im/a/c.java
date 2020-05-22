package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.u.a;
import com.baidu.live.view.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.aPf);
    }

    @Override // com.baidu.live.im.a.b
    protected void Db() {
        if (Dc()) {
            Dd();
        } else {
            De();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Dc()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.DB(), cVar, false, false);
        a l = l(aVar);
        String format = String.format(this.mContext.getString(a.i.ala_rec_gift), (l == null || TextUtils.isEmpty(l.giftName)) ? this.mContext.getString(a.i.sdk_gift) : l.giftName);
        SpannableString valueOf = SpannableString.valueOf(format);
        if (format != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        if (l != null && !TextUtils.isEmpty(l.aEY)) {
            AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
            alaLiveMarkData.mark_pic = l.aEY;
            alaLiveMarkData.isWidthAutoFit = true;
            com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.a.c.1
                @Override // com.baidu.live.view.c.a
                public void d(Bitmap bitmap) {
                    cVar.aPv.forceLayout();
                }

                @Override // com.baidu.live.view.c.a
                public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                }
            });
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder2.setSpan(cVar2, 1, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        a(spannableStringBuilder, l);
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = !TextUtils.isEmpty(aVar.aSI) ? aVar.aSI : "1";
            String str2 = !TextUtils.isEmpty(aVar.aSJ) ? aVar.aSJ : "1";
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.aSy && !aVar.aRL && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.i.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (v.eR(aVar.giftId) && !v.eP(aVar.giftId) && v.eQ(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.aRL && aVar.aRK > 0.0d) {
                com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(this.mContext, aVar.aRK + "倍");
                SpannableString spannableString = new SpannableString(" rate");
                spannableString.setSpan(aVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[Catch: JSONException -> 0x00c0, TryCatch #0 {JSONException -> 0x00c0, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0045, B:9:0x005f, B:12:0x0069, B:14:0x0079, B:16:0x007f, B:17:0x0089, B:19:0x0091, B:21:0x009c, B:23:0x00a4, B:30:0x00c5, B:26:0x00ba, B:25:0x00ae), top: B:32:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a l(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.aSI = aVar.DJ() + "";
            if (aVar.DL() > 0) {
                aVar2.aSJ = aVar.DL() + "";
            } else {
                aVar2.aSJ = "";
            }
            aVar2.aRL = jSONObject.optInt("is_free") == 1;
            aVar2.aRK = aVar.DK();
            com.baidu.live.gift.g eO = v.eO(aVar2.giftId);
            if (eO != null) {
                if (eO.xt()) {
                    aVar2.giftName = this.mContext.getString(a.i.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar2.giftName)) {
                        aVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar2.aEY)) {
                        aVar2.aEY = jSONObject.optString("gift_url");
                        return aVar2;
                    }
                }
                aVar2.giftName = eO.xm();
                aVar2.aEY = eO.xo();
            }
            z = false;
            if (TextUtils.isEmpty(aVar2.giftName)) {
            }
            return z ? aVar2 : aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public String aEY;
        public double aRK;
        public boolean aRL;
        public String aSI;
        public String aSJ;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}
