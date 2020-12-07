package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.view.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.im.a.b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.bjP);
    }

    @Override // com.baidu.live.im.a.b
    protected void Nx() {
        if (Ny()) {
            Nz();
        } else {
            NA();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (Ny()) {
            return -5864;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.b bVar, final com.baidu.live.im.c cVar) {
        String str;
        JSONObject jSONObject;
        String optString;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        JSONObject jSONObject2 = null;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject2 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject2 = new JSONObject(bVar.getContent());
            }
            str = jSONObject2.optString("content_type");
            jSONObject = jSONObject2;
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
            jSONObject = jSONObject2;
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
            jSONObject = jSONObject2;
        }
        if (str != null && jSONObject != null && str.equals("pk_send_props")) {
            String optString2 = jSONObject.optString("pk_image_url");
            String optString3 = jSONObject.optString("props_belong_text");
            String str2 = bVar.NU().name_show;
            String optString4 = jSONObject.optString("gift_name");
            String optString5 = jSONObject.optString("gift_url");
            String optString6 = jSONObject.optString("props_text");
            if (!TextUtils.isEmpty(optString2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = optString2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.im.a.c.1
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        cVar.bkf.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("[img] ");
                spannableStringBuilder2.setSpan(bVar2, 0, spannableStringBuilder2.length() - 1, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
            SpannableString valueOf = SpannableString.valueOf(optString3 + str2);
            if (!TextUtils.isEmpty(valueOf)) {
                valueOf.setSpan(new ForegroundColorSpan(-7479041), 0, optString3.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(-5462), optString3.length(), optString3.length() + str2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf);
            String string = this.mContext.getString(a.h.ala_pk_props);
            SpannableString valueOf2 = SpannableString.valueOf(string + optString4);
            if (!TextUtils.isEmpty(string)) {
                valueOf2.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf2.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf2);
            if (!TextUtils.isEmpty(optString5)) {
                AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                alaLiveMarkData2.mark_pic = optString5;
                alaLiveMarkData2.isWidthAutoFit = true;
                com.baidu.live.view.b bVar3 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData2, false, new b.a() { // from class: com.baidu.live.im.a.c.2
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        cVar.bkf.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar4, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(bVar3, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            SpannableString valueOf3 = SpannableString.valueOf("," + optString6);
            if (!TextUtils.isEmpty(valueOf3)) {
                valueOf3.setSpan(new ForegroundColorSpan(-7479041), 0, valueOf3.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf3);
        } else if (str != null && jSONObject != null && str.equals("tying_gift")) {
            jSONObject.optString("pay_username");
            String optString7 = jSONObject.optString("tying_gift_name");
            int optInt = jSONObject.optInt("tying_status");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            a(spannableStringBuilder, bVar.NU(), cVar, false, false);
            if (optJSONArray != null) {
                int i = 0;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString8 = optJSONArray.optJSONObject(i2).optString(LogConfig.VALUE_IM_GIFT);
                    if (optString8 != null && optString8.equals("1")) {
                        i++;
                    }
                }
                if (optInt == 0) {
                    String string2 = this.mContext.getString(a.h.ala_middle_context);
                    SpannableString valueOf4 = SpannableString.valueOf(" " + string2);
                    if (!TextUtils.isEmpty(valueOf4)) {
                        valueOf4.setSpan(new ForegroundColorSpan(-5864), 0, string2.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf4);
                    SpannableString valueOf5 = SpannableString.valueOf(" " + optString7 + " ");
                    if (!TextUtils.isEmpty(valueOf5)) {
                        valueOf5.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf5.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf5);
                    SpannableString valueOf6 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift));
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
                    String string3 = this.mContext.getString(a.h.ala_tying_gift_middle);
                    SpannableString valueOf8 = SpannableString.valueOf(string3);
                    if (!TextUtils.isEmpty(valueOf8)) {
                        valueOf8.setSpan(new ForegroundColorSpan(-5864), 0, string3.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf8);
                    SpannableString valueOf9 = SpannableString.valueOf(" " + optString7 + " ");
                    if (!TextUtils.isEmpty(valueOf9)) {
                        valueOf9.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf9.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf9);
                    SpannableString valueOf10 = SpannableString.valueOf(this.mContext.getString(a.h.ala_tying_gift_behind));
                    if (!TextUtils.isEmpty(valueOf10)) {
                        valueOf10.setSpan(new ForegroundColorSpan(-5864), 0, valueOf10.length(), 33);
                    }
                    spannableStringBuilder.append((CharSequence) valueOf10);
                }
            }
        } else if (str != null && jSONObject != null && str.equals("luckybag_send")) {
            a(spannableStringBuilder, bVar.NU(), cVar, false, false);
            jSONObject.optString("user_nickname");
            jSONObject.optString("user_name");
            com.baidu.live.gift.g hr = ac.hr(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            if (hr != null) {
                optString = hr.getThumbnail_url();
            } else {
                optString = jSONObject.optString("gift_url");
            }
            String optString9 = jSONObject.optString("gift_name");
            String optString10 = jSONObject.optString("gift_count");
            String format = String.format(this.mContext.getString(a.h.ala_rec_gift), optString9);
            SpannableString valueOf11 = SpannableString.valueOf(format);
            if (format != null) {
                valueOf11.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf11.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf11);
            if (optString != null) {
                AlaLiveMarkData alaLiveMarkData3 = new AlaLiveMarkData();
                alaLiveMarkData3.mark_pic = optString;
                alaLiveMarkData3.isWidthAutoFit = true;
                com.baidu.live.view.b bVar4 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData3, false, new b.a() { // from class: com.baidu.live.im.a.c.3
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        cVar.bkf.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar5, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder4.setSpan(bVar4, 1, spannableStringBuilder4.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            }
            if (!TextUtils.isEmpty(optString10)) {
                SpannableString valueOf12 = SpannableString.valueOf("×" + optString10);
                valueOf12.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf12.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf12);
            }
        } else {
            a(spannableStringBuilder, bVar.NU(), cVar, false, false);
            b u = u(bVar);
            String format2 = String.format(this.mContext.getString(a.h.ala_rec_gift), (u == null || TextUtils.isEmpty(u.giftName)) ? this.mContext.getString(a.h.sdk_gift) : u.giftName);
            SpannableString valueOf13 = SpannableString.valueOf(format2);
            if (format2 != null) {
                valueOf13.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf13.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) valueOf13);
            if (u != null && !TextUtils.isEmpty(u.aWS)) {
                AlaLiveMarkData alaLiveMarkData4 = new AlaLiveMarkData();
                alaLiveMarkData4.mark_pic = u.aWS;
                alaLiveMarkData4.isWidthAutoFit = true;
                com.baidu.live.view.b bVar5 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData4, false, new b.a() { // from class: com.baidu.live.im.a.c.4
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        cVar.bkf.forceLayout();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar6, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder5.setSpan(bVar5, 1, spannableStringBuilder5.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder5);
            }
            a(spannableStringBuilder, u);
        }
        return spannableStringBuilder;
    }

    private void a(SpannableStringBuilder spannableStringBuilder, b bVar) {
        if (bVar != null) {
            String str = bVar.bnI;
            String str2 = bVar.bnJ;
            if (!TextUtils.isEmpty(str)) {
                SpannableString valueOf = SpannableString.valueOf("×" + str);
                valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (!TextUtils.isEmpty(bVar.bdf) && (!bVar.aLe || !TextUtils.equals(bVar.bnR, "luckybag"))) {
                SpannableString valueOf2 = SpannableString.valueOf("（" + bVar.bdf + "）");
                valueOf2.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf2.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf2);
            }
            if (this.bnu && !bVar.bmx && !TextUtils.isEmpty(str2)) {
                SpannableString valueOf3 = SpannableString.valueOf(String.format(this.mContext.getString(a.h.ala_rec_gift_charm_value), str2));
                valueOf3.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf3.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf3);
            }
            if (ac.hv(bVar.giftId) && !ac.ht(bVar.giftId) && ac.hu(bVar.giftId)) {
                SpannableString valueOf4 = SpannableString.valueOf(this.mContext.getString(a.h.ala_dynamic_gift_downloading));
                valueOf4.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf4.length(), 33);
                spannableStringBuilder.append((CharSequence) valueOf4);
            }
            if (!bVar.bmx && bVar.bnL != 0.0d && !TextUtils.isEmpty(bVar.bnM)) {
                com.baidu.live.im.view.b bVar2 = new com.baidu.live.im.view.b(this.mContext, bVar.bnL + "倍" + bVar.bnM, false, true, bVar.bnN, bVar.bnO, bVar.bnP, true);
                SpannableString spannableString = new SpannableString(" raterate");
                spannableString.setSpan(bVar2, 1, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
            }
            if (bVar.bnQ != null) {
                for (int i = 0; i < bVar.bnQ.length; i++) {
                    com.baidu.live.im.view.b bVar3 = new com.baidu.live.im.view.b(this.mContext, bVar.bnQ[i].NB(), false, true, bVar.bnQ[i].ND(), bVar.bnQ[i].NE(), bVar.bnQ[i].NC());
                    SpannableString spannableString2 = new SpannableString(" raterate");
                    spannableString2.setSpan(bVar3, 1, spannableString2.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0109 A[Catch: JSONException -> 0x014e, TryCatch #0 {JSONException -> 0x014e, blocks: (B:3:0x0003, B:5:0x000b, B:6:0x0012, B:8:0x0021, B:9:0x004e, B:11:0x0057, B:12:0x008d, B:14:0x00bd, B:15:0x00d7, B:18:0x00e1, B:20:0x00f1, B:22:0x00f7, B:23:0x0101, B:25:0x0109, B:27:0x0114, B:29:0x011c, B:30:0x0125, B:37:0x0153, B:33:0x0148, B:32:0x013c), top: B:39:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b u(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            b bVar2 = new b();
            JSONObject optJSONObject = jSONObject.optJSONObject("pk_info");
            if (optJSONObject != null) {
                bVar2.bnL = optJSONObject.optDouble("pk_honer_buff_multiple");
                bVar2.bnM = optJSONObject.optString("pk_honer_buff_text");
                bVar2.bnN = optJSONObject.optString("pk_honer_buff_text_color_start");
                bVar2.bnO = optJSONObject.optString("pk_honer_buff_text_color_end");
                bVar2.bnP = optJSONObject.optString("pk_honer_buff_text_font_color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("headline_info");
            if (optJSONObject2 != null) {
                bVar2.bnK = optJSONObject2.optString("second_text");
                bVar2.bnL = optJSONObject2.optDouble("headline_buff_multiple");
                bVar2.bnM = optJSONObject2.optString("headline_buff_text");
                bVar2.bnN = optJSONObject2.optString("headline_buff_text_color_start");
                bVar2.bnO = optJSONObject2.optString("headline_buff_text_color_end");
                bVar2.bnP = optJSONObject2.optString("headline_buff_text_font_color");
            }
            bVar2.parserJson(jSONObject);
            bVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            bVar2.bnI = bVar.Oc() + "";
            if (bVar.Oe() > 0) {
                bVar2.bnJ = bVar.Oe() + "";
            } else {
                bVar2.bnJ = "";
            }
            bVar2.bmx = jSONObject.optInt("is_free") == 1;
            bVar2.bmw = bVar.Od();
            com.baidu.live.gift.g hr = ac.hr(bVar2.giftId);
            if (hr != null) {
                if (hr.Hf()) {
                    bVar2.giftName = this.mContext.getString(a.h.sdk_text_gift_graffiti);
                    if (TextUtils.isEmpty(bVar2.giftName)) {
                        bVar2.giftName = jSONObject.optString("gift_name");
                    }
                    if (!z && TextUtils.isEmpty(bVar2.aWS)) {
                        bVar2.aWS = jSONObject.optString("gift_url");
                    }
                    bVar2.bdf = jSONObject.optString("gift_source_text");
                    bVar2.bnR = jSONObject.optString("gift_source");
                    bVar2.aLe = bVar.aLe;
                    return bVar2;
                }
                bVar2.giftName = hr.GY();
                bVar2.aWS = hr.getThumbnail_url();
            }
            z = false;
            if (TextUtils.isEmpty(bVar2.giftName)) {
            }
            if (!z) {
                bVar2.aWS = jSONObject.optString("gift_url");
            }
            bVar2.bdf = jSONObject.optString("gift_source_text");
            bVar2.bnR = jSONObject.optString("gift_source");
            bVar2.aLe = bVar.aLe;
            return bVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        public boolean aLe;
        public String aWS;
        public String bdf;
        public double bmw;
        public boolean bmx;
        public String bnI;
        public String bnJ;
        public String bnK;
        public double bnL;
        public String bnM;
        public String bnN;
        public String bnO;
        public String bnP;
        public a[] bnQ;
        public String bnR;
        public String giftId;
        public String giftName;

        private b() {
            this.aLe = false;
        }

        public void parserJson(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("im_icon_conf")) != null) {
                this.bnQ = new a[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.bnQ[i] = new a(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        public String bnE;
        public String bnF;
        public String bnG;
        public String bnH;

        public a(JSONObject jSONObject) {
            this.bnE = jSONObject.optString("text");
            this.bnF = jSONObject.optString("text_color");
            this.bnG = jSONObject.optString("bg_color_start");
            this.bnH = jSONObject.optString("bg_color_end");
        }

        public String NB() {
            return this.bnE;
        }

        public String NC() {
            return this.bnF;
        }

        public String ND() {
            return this.bnG;
        }

        public String NE() {
            return this.bnH;
        }
    }
}
