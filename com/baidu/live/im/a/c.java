package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.bfR);
    }

    @Override // com.baidu.live.im.a.b
    protected void LB() {
        if (LC()) {
            LD();
        } else {
            LE();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (LC()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        String str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        JSONObject jSONObject = null;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            str = jSONObject.optString("content_type");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str != null && jSONObject != null && str.equals("pk_send_props")) {
            String optString = jSONObject.optString("pk_image_url");
            String optString2 = jSONObject.optString("props_belong_text");
            String str2 = aVar.LO().name_show;
            String optString3 = jSONObject.optString("gift_name");
            String optString4 = jSONObject.optString("gift_url");
            String optString5 = jSONObject.optString("props_text");
            if (!TextUtils.isEmpty(optString)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = optString;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.c cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.im.a.c.1
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.bgh.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[img] ");
                spannableStringBuilder2.setSpan(cVar2, 0, spannableStringBuilder2.length() - 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
            SpannableString valueOf = SpannableString.valueOf(optString2 + str2);
            if (!TextUtils.isEmpty(valueOf)) {
                valueOf.setSpan(new ForegroundColorSpan(-7479041), 0, optString2.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(-5462), optString2.length(), optString2.length() + str2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.i.ala_pk_props);
            SpannableString valueOf2 = SpannableString.valueOf(string + optString3);
            if (!TextUtils.isEmpty(string)) {
                valueOf2.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf2);
            if (!TextUtils.isEmpty(optString4)) {
                AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                alaLiveMarkData2.mark_pic = optString4;
                alaLiveMarkData2.isWidthAutoFit = true;
                com.baidu.live.view.c cVar3 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData2, false, new c.a() { // from class: com.baidu.live.im.a.c.2
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.bgh.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar4, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(cVar3, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            SpannableString valueOf3 = SpannableString.valueOf(Constants.ACCEPT_TIME_SEPARATOR_SP + optString5);
            if (!TextUtils.isEmpty(valueOf3)) {
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf3.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf3);
        } else if (str != null && jSONObject != null && str.equals("tying_gift")) {
            jSONObject.optString("pay_username");
            String optString6 = jSONObject.optString("tying_gift_name");
            int optInt = jSONObject.optInt("tying_status");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            a(spannableStringBuilder, aVar.LO(), cVar, false, false);
            if (optJSONArray != null) {
                int i = 0;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString7 = optJSONArray.optJSONObject(i2).optString(LogConfig.VALUE_IM_GIFT);
                    if (optString7 != null && optString7.equals("1")) {
                        i++;
                    }
                }
                if (optInt == 0) {
                    String string2 = this.mContext.getString(a.i.ala_middle_context);
                    SpannableString valueOf4 = SpannableString.valueOf(" " + string2);
                    if (!TextUtils.isEmpty(valueOf4)) {
                        valueOf4.setSpan(new ForegroundColorSpan(-5864), 0, string2.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf4);
                    SpannableString valueOf5 = SpannableString.valueOf(" " + optString6 + " ");
                    if (!TextUtils.isEmpty(valueOf5)) {
                        valueOf5.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf5.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf5);
                    SpannableString valueOf6 = SpannableString.valueOf(this.mContext.getString(a.i.ala_tying_gift));
                    if (!TextUtils.isEmpty(valueOf6)) {
                        valueOf6.setSpan(new ForegroundColorSpan(-5864), 0, valueOf6.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf6);
                    SpannableString valueOf7 = SpannableString.valueOf(i + "/" + optJSONArray.length());
                    if (!TextUtils.isEmpty(valueOf7)) {
                        valueOf7.setSpan(new ForegroundColorSpan(-5864), 0, valueOf7.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf7);
                } else {
                    String string3 = this.mContext.getString(a.i.ala_tying_gift_middle);
                    SpannableString valueOf8 = SpannableString.valueOf(string3);
                    if (!TextUtils.isEmpty(valueOf8)) {
                        valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, string3.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf8);
                    SpannableString valueOf9 = SpannableString.valueOf(" " + optString6 + " ");
                    if (!TextUtils.isEmpty(valueOf9)) {
                        valueOf9.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf9.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf9);
                    SpannableString valueOf10 = SpannableString.valueOf(this.mContext.getString(a.i.ala_tying_gift_behind));
                    if (!TextUtils.isEmpty(valueOf10)) {
                        valueOf10.setSpan(new ForegroundColorSpan(-5864), 0, valueOf10.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf10);
                }
            }
        } else {
            a(spannableStringBuilder, aVar.LO(), cVar, false, false);
            a t = t(aVar);
            String format = String.format(this.mContext.getString(a.i.ala_rec_gift), (t == null || TextUtils.isEmpty(t.giftName)) ? this.mContext.getString(a.i.sdk_gift) : t.giftName);
            SpannableString valueOf11 = SpannableString.valueOf(format);
            if (format != null) {
                valueOf11.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf11.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf11);
            if (t != null && !TextUtils.isEmpty(t.aUh)) {
                AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                alaLiveMarkData3.mark_pic = t.aUh;
                alaLiveMarkData3.isWidthAutoFit = true;
                com.baidu.live.view.c cVar4 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData3, false, new c.a() { // from class: com.baidu.live.im.a.c.3
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        cVar.bgh.forceLayout();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar5, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder4.setSpan(cVar4, 1, spannableStringBuilder4.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            }
            a(spannableStringBuilder, t);
        }
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, a aVar) {
        if (aVar != null) {
            String str = aVar.bjC;
            String str2 = aVar.bjD;
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (this.bjs && !aVar.biC && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf2 = SpannableString.valueOf(String.format(this.mContext.getString(a.i.ala_rec_gift_charm_value), str2));
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (ab.ha(aVar.giftId) && !ab.gY(aVar.giftId) && ab.gZ(aVar.giftId)) {
                SpannableString valueOf3 = SpannableString.valueOf(this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (!aVar.biC && aVar.bjF != 0.0d && !TextUtils.isEmpty(aVar.bjG)) {
                com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(this.mContext, aVar.bjF + "倍" + aVar.bjG, false, true, aVar.bjH, aVar.bjI, aVar.bjJ, true);
                SpannableString spannableString = new SpannableString(" raterate");
                spannableString.setSpan(aVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0106 A[Catch: JSONException -> 0x0135, TryCatch #0 {JSONException -> 0x0135, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0021, B:9:0x004e, B:11:0x0057, B:12:0x008d, B:14:0x00ba, B:15:0x00d4, B:18:0x00de, B:20:0x00ee, B:22:0x00f4, B:23:0x00fe, B:25:0x0106, B:27:0x0111, B:29:0x0119, B:36:0x013a, B:32:0x012f, B:31:0x0123), top: B:38:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
            if (optJSONObject != null) {
                aVar2.bjF = optJSONObject.optDouble("pk_honer_buff_multiple");
                aVar2.bjG = optJSONObject.optString("pk_honer_buff_text");
                aVar2.bjH = optJSONObject.optString("pk_honer_buff_text_color_start");
                aVar2.bjI = optJSONObject.optString("pk_honer_buff_text_color_end");
                aVar2.bjJ = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("headline_info");
            if (optJSONObject2 != null) {
                aVar2.bjE = optJSONObject2.optString("second_text");
                aVar2.bjF = optJSONObject2.optDouble("headline_buff_multiple");
                aVar2.bjG = optJSONObject2.optString("headline_buff_text");
                aVar2.bjH = optJSONObject2.optString("headline_buff_text_color_start");
                aVar2.bjI = optJSONObject2.optString("headline_buff_text_color_end");
                aVar2.bjJ = optJSONObject2.optString("headline_buff_text_font_color");
            }
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.bjC = aVar.LW() + "";
            if (aVar.LY() > 0) {
                aVar2.bjD = aVar.LY() + "";
            } else {
                aVar2.bjD = "";
            }
            aVar2.biC = jSONObject.optInt("is_free") == 1;
            aVar2.biB = aVar.LX();
            com.baidu.live.gift.g gW = ab.gW(aVar2.giftId);
            if (gW != null) {
                if (gW.Fz()) {
                    aVar2.giftName = this.mContext.getString(a.i.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(aVar2.giftName)) {
                        aVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (z && TextUtils.isEmpty(aVar2.aUh)) {
                        aVar2.aUh = jSONObject.optString("gift_url");
                        return aVar2;
                    }
                }
                aVar2.giftName = gW.Ft();
                aVar2.aUh = gW.getThumbnail_url();
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
    /* loaded from: classes4.dex */
    public static class a {
        public String aUh;
        public double biB;
        public boolean biC;
        public String bjC;
        public String bjD;
        public String bjE;
        public double bjF;
        public String bjG;
        public String bjH;
        public String bjI;
        public String bjJ;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}
